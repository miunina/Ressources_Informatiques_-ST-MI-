package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TransformerPoeme {
    public static String transformerP(String pathcourant) throws TransformerException, ParserConfigurationException{
        Pattern pat =Pattern.compile("(.+\\\\)(.*)\\.txt$");
        Matcher mat = pat.matcher(pathcourant);
        
          if (mat.find()){
                BufferedReader buf = null;                                                                            
                DOMImplementation dom_cible = CreateDomParser.cons();
                DocumentType dtd = dom_cible.createDocumentType("poema",null,"neruda.dtd");
                Document doc_result = dom_cible.createDocument(null,"poema", dtd);
                doc_result.setXmlStandalone(true);
                                              
                Element elem = doc_result.getDocumentElement();
                try {               	        			
                    buf = new BufferedReader(new InputStreamReader(new FileInputStream(pathcourant),"UTF-8"));
                    String lignecourante = null;
                    boolean bool = true;                             
                    while ((lignecourante = buf.readLine()) != null)
                    {                    	
                        if (lignecourante.trim().length() > 0)
                        {
                            if (bool == false)
                            {
                                Element est = doc_result.createElement("estrofa");
                                elem.appendChild(est);
                                Element verso = doc_result.createElement("verso");
                                verso.appendChild(doc_result.createTextNode(lignecourante));
                                est.appendChild(verso);
                                while ((lignecourante=buf.readLine()) !=null && lignecourante.trim().length()>0)
                                {
                                    verso = doc_result.createElement("verso");
                                    verso.appendChild(doc_result.createTextNode(lignecourante));
                                    est.appendChild(verso);
                                }                              
                             }
                            else
                            {
                                Element titulo = doc_result.createElement("titulo");
                                titulo.appendChild(doc_result.createTextNode(lignecourante));
                                elem.appendChild(titulo);
                                bool = false;
                            }
                        }
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }finally
                {
                    try 
                    {
                        if (buf!=null)
                            buf.close();
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                 }
            DOMSource ds = new DOMSource(doc_result);
           
            String comp = new String("neruda.xml");
            StreamResult res = new StreamResult(new File(comp));
            
            TransformerFactory transform = TransformerFactory.newInstance();
           
            Transformer tr = transform.newTransformer();
            tr.setOutputProperty(OutputKeys.METHOD, "xml");//specifies that the result tree will be written out as XML
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "neruda.dtd");//or   // tr.setOutputProperty( OutputKeys.DOCTYPE_SYSTEM, dtd.getSystemId() );1
            tr.transform(ds, res);
        }
          return "neruda.xml   ====>  dtd = neruda.dtd";
    }


}
