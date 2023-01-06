package xml;

import java.io.*;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TransformerRenault 
{
    static List li = new ArrayList();
    public static String transformerRen(String pathcourant) throws SAXException, IOException, ParserConfigurationException{
        Element rac = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(pathcourant).getDocumentElement();
        NodeList p =rac.getElementsByTagName("p");            
        List li = new ArrayList();
        for (int i=0; i<p.getLength();i++)
        { 
            if (p.item(i).getParentNode().getNodeName()=="div" && ((Element) p.item(i).getParentNode()).getAttribute("class").equals("post-single"));
            Ajout(li, p.item(i));

        }     
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        String adress,tel, nom;
        List lis = new ArrayList();
        try {
            DocumentBuilder build =fact.newDocumentBuilder();
            Document doc_res = build.newDocument();
            Element racine = doc_res.createElement("Concessionnaires");
            doc_res.appendChild(racine);
            String str ="";
            for (int i =0; i<li.size();i++)
            {
                str=str+" "+li.get(i);
            }            
            List stringlist= new ArrayList();
            String ligne ="";
            str=str.replaceAll("\n"," ");
            str = str.replaceAll("\r", " ");
            str = str.replaceAll("Fax[ :0-9 ]+"," ");
            str=str.replaceAll("\\s+"," ");            
            for (int i=0;i<str.length();i++){
            	   if (ligne.endsWith("021"))
                {                 	                	                              
                	int count =0;
                	ligne+=" ";
                	while (i<str.length()&& count++ <9-3)
                	{
                		ligne+=str.charAt(i);
                		if(str.charAt(i) ==' ')
                    	{count = count - 1;
                    	ligne+=" ";}                		
                		i = i + 1;
                	}              
                	i--;
                	stringlist.add(ligne);
                	ligne=" ";
                }
                else
                {              
                	 while (i<str.length() &&  !ligne.endsWith("021"))
                	 {
                         ligne+=str.charAt(i);
                         i = i+1;
                	 }                	                                       
               }            	
            } 
            for (int i=0; i<stringlist.size();i++)
            {
            	Pattern try_patern = Pattern.compile("((.+)\\p{Punct})?(.+)Adresse\\p{Space}\\p{Punct}(.+)Tél\\p{Space}\\p{Punct}(.+)");
                
                Matcher try_mat = try_patern.matcher(stringlist.get(i).toString());
                if (try_mat.find() || try_mat.matches())
                {
                
                    nom =try_mat.group(3);
                    adress=try_mat.group(4);
                    tel= try_mat.group(5);
                    Element nomelem = doc_res.createElement("Nom");
                    nomelem.appendChild(doc_res.createTextNode(nom.trim()));
                    Element ad = doc_res.createElement("Adresse");
                    ad.appendChild(doc_res.createTextNode(adress.trim()));
                    Element telnum= doc_res.createElement("Num_téléphone");
                    telnum.appendChild(doc_res.createTextNode(tel.trim()));
                    racine.appendChild(nomelem);
                    racine.appendChild(ad);
                    racine.appendChild(telnum);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            doc_res.setXmlStandalone(true);
            DOMSource source = new DOMSource(doc_res);
            
            StreamResult output = new StreamResult(new File("renault.xml"));
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");//specifies that the result tree will be written out as XML
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            //transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, output);
        }
        catch (final ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e1){
            e1.printStackTrace();
        }
        catch (TransformerException e2){
            e2.printStackTrace();
        }
   return "renault.xml"; }

    public static void Ajout(List li, Node node)
    {
        for (int i=0;i <node.getChildNodes().getLength();i++)
        {
            Node nod =node.getChildNodes().item(i);
            if (nod != null && nod.getNodeName()=="#text" && nod.getNodeValue()!=null)
            {
            	String l= nod.getNodeValue();
                li.add(l);
            }
            Ajout(li, nod);
        }
    }
}