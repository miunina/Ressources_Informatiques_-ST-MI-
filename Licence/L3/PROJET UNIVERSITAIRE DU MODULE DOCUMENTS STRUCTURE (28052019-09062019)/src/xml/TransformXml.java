package xml;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformXml {
    public static String transformerXml(String pathcourant) throws ParserConfigurationException, SAXException, IOException, TransformerException
    {   
        String[] split1 = pathcourant.split("\\\\");
      
        
        String s ="";
        for ( int i=0;i<split1.length-1;i++)
        {
        	s = s+split1[i]+"\\";
        }
       
        if (s != null)
        {
            String dtdPath = s;
            String namef = split1[split1.length-1];
            //System.out.print(s+namef);
            
            DocumentBuilder one_parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc_src = one_parser.parse(pathcourant);
            DOMImplementation dom = CreateDomParser.cons();
            DocumentBuilder pars1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            DOMImplementation dom2 = pars1.getDOMImplementation();

            DocumentType dtd = dom2.createDocumentType(
            		doc_src.getDocumentElement().getNodeName().concat("_S"), null
            		, "dom.dtd");
            Document doc_res = dom.createDocument(
            		null,
            		doc_src.getDocumentElement().getNodeName().concat("_S"),dtd);
            doc_res.setXmlStandalone(true);
            Element res = doc_res.getDocumentElement();
            Element elem = null;
            String nameFile = "";
            if (pathcourant.contains("M674"))
            {
                elem = doc_res.createElement("M674");
            }
            else
            {
                elem = doc_res.createElement("M457");
            }
            res.appendChild(elem);
            NodeList p = doc_src.getElementsByTagName("p");
            for (int i = 0; i < p.getLength(); i++){
                Node node = p.item(i);
                if (node != null){
                    NodeList liste =node.getChildNodes();
                    for (int j=0; j< liste.getLength();j++){
                        Node child =liste.item(j);
                       
                        if(child != null && child.getNodeName()=="#text" && child.getNodeValue()!=null)
                        {
                            String cont = child.getNodeValue();
                            cont.replaceAll("\r","");
                            cont.replaceAll("\n", "");
                            cont.replaceAll("\\s*","");
                            
                            if (cont != null)
                            { 
                                Element text = doc_res.createElement("texte");
                                elem.appendChild(text);
                                text.appendChild(doc_res.createTextNode(cont));
                            }
                        }
                       
                    }
                }
            }

            DOMSource domS = new DOMSource(doc_res);
            String st;
            if (namef.contains("M457")){
                st = new String("sortie2.xml");
                nameFile = "sortie2.xml";
            }else{
                st= new String("sortie1.xml");
                nameFile = "sortie1.xml";
            }

            StreamResult result = new StreamResult(new File(st));
            TransformerFactory transform = TransformerFactory.newInstance();
            Transformer trans = transform.newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");//specifies that the result tree will be written out as XML
            trans.setOutputProperty(OutputKeys.INDENT,"yes");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");                    
            trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"dom.dtd");
            trans.transform(domS,result);

       return nameFile+" ====>  dom.dtd"; }
        	return "";
    }
}
