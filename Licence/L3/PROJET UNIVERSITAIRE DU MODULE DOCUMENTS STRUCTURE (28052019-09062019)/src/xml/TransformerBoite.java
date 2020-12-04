package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TransformerBoite {
    static List liste =new ArrayList();

    public static String transformerBo(String pathcourant) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        
        DocumentBuilder pa =CreateDomParser.parseur();
        Document doc_src = pa.parse(pathcourant);
        
        DOMImplementation dom = CreateDomParser.cons();
        Document doc_res = dom.createDocument(null,"Racine", null);
        
        Element rac = doc_res.getDocumentElement();
        
        rac.setAttribute("xmlns:fx", "http://javafx.com/fxml");
		/*
		 * beginning of the extraction of the cibled nods: 
		 * */
		NodeList list =   doc_src.getElementsByTagName("GridPane");
		Node p = list.item(0);
		Recursive(p);		
		for(int i =0;i<liste.size();i=i+2){
			Element texte = doc_res.createElement("texte");
			String s = liste.get(i).toString().replaceAll("\\s", "");
			
			texte.setAttribute(s, "x");
			texte.setTextContent(liste.get(i+1).toString());
			rac.appendChild(texte);
		}
		/*
		 * end of the treatement
		 * */
        DOMSource ds = new DOMSource(doc_res);
       
        StreamResult resultat = new StreamResult(new File("javafx.xml"));
        
        TransformerFactory transform = TransformerFactory.newInstance();
        Transformer tr= transform.newTransformer();
        tr.setOutputProperty
        (OutputKeys.OMIT_XML_DECLARATION, "no");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");//specifies that the result tree will be written out as XML
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");//specify the indent amount between each level on the xml tree

        tr.setOutputProperty(OutputKeys.INDENT, "yes");

        doc_res.setXmlStandalone(true);
        tr.transform(ds, resultat);
       return "javafx.xml"+"  ====>  ne pointe vers aucune dtd";
    }
public static void Recursive (Node nod){
		
		if(nod != null && nod.hasAttributes())
		{
			NamedNodeMap attributes = nod.getAttributes();//avoir toute les attributs du noueud
			List temp = new ArrayList();
			int add_pos = 0;
			for (int j = 0; j < attributes.getLength(); j++) 
			{		
				Attr attr = (Attr) attributes.item(j);		
				String Name = attr.getNodeName();			
				String Value = attr.getNodeValue();			
				//if attribute value start with "\n" and " "
				if(!Name.startsWith("GridPane") )
				{
					temp.add(Name);
					temp.add(Value);			
				}
				else
				{//if the attribut start with gridpane we should add it on the beginning
					temp.add(add_pos++, Name);
					temp.add(add_pos++, Value);
				}			
			}	
			for(int j = 0;j< temp.size();j++)
			{
				liste.add(temp.get(j));
			}			
	    }
		if(nod.hasChildNodes())
		{
			NodeList nod_rec = nod.getChildNodes();
			for(int i =0;i<nod_rec.getLength();i++)
			{
				Recursive(nod_rec.item(i));
			}
		}
	}
}
