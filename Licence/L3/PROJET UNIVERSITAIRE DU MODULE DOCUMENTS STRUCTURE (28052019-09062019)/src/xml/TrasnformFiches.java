package xml;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

//fiches2.xml
public class TrasnformFiches{
	
    public static String ReadTxt2(String pathcourant) throws FileNotFoundException, ParserConfigurationException, IOException, TransformerException
    {	String nameSortie = "fichier2.xml";
    	DocumentBuilder parseur;
        CreateDomParser docParser = null; 	
    	DOMImplementation impl = docParser.cons();
        Document doc_res = impl.createDocument(null,"FICHES",null);
        doc_res.setXmlStandalone(true);
        doc_res.insertBefore(doc_res.createProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"fiches.xsl\""),doc_res.getDocumentElement());
               
        Element racineSortie = doc_res.getDocumentElement();
        
        BufferedReader ips = new BufferedReader(new InputStreamReader(new FileInputStream(pathcourant),"UTF-8"));
   
        String ds ="";
        String ss= "";
        String ligne;
        int Id =1;
        while(((ligne=ips.readLine())!=null) && (Id<=4)){
           
           int t= ligne.length();
           /*to relance the while boucle*/
            if(t<=1) continue;
            Element rac = doc_res.createElement("rac");
            rac.setAttribute("id",String.valueOf(Id));
            racineSortie.appendChild(rac);
            Element be = doc_res.createElement("BE");
            rac.appendChild(be);
            ligne = ligne.replace("BE","");
            be.appendChild(doc_res.createTextNode(ligne));
            ligne= ips.readLine();
            Element ty = doc_res.createElement("TY");
            rac.appendChild(ty);
            ligne=ligne.replace("TY","");
            ty.appendChild(doc_res.createTextNode("TY : "+ligne));
            ligne=ips.readLine();
            Element DO = doc_res.createElement("DO");
            rac.appendChild(DO);
            ligne=ligne.replace("DO", "");
            ds=ligne;
            DO.appendChild(doc_res.createTextNode("DO : "+ligne));
            ligne=ips.readLine();
            Element sd= doc_res.createElement("SD");
            rac.appendChild(sd);
            ligne = ligne.replace("SD", "");
            ss=ligne;
            sd.appendChild(doc_res.createTextNode("SD : "+ligne));
            ligne = ips.readLine();
            Element au = doc_res.createElement("AU");
            rac.appendChild(au);
            ligne =ligne.replace("AU", "");
            au.appendChild(doc_res.createTextNode("AU : "+ligne));
            ligne=ips.readLine();
            Element ar = doc_res.createElement("Langue");
            rac.appendChild(ar);
            ar.setAttribute("id","AR");
            ligne = ips.readLine();
            Element ve = doc_res.createElement("VE");
            ar.appendChild(ve);
            ligne = ligne.replace("VE :", "");
            ve.appendChild(doc_res.createTextNode("VE : "+ligne));
            ligne=ips.readLine();
            Element df = doc_res.createElement("DF");
            ar.appendChild(df);
            ligne=ligne.replace("DF :", "");
            df.appendChild(doc_res.createTextNode("DF : "+ligne));
            ligne=ips.readLine();
            Element ph = doc_res.createElement("PH");
            ar.appendChild(ph);
            ligne=ligne.replace("PH :", "");
            ph.appendChild(doc_res.createTextNode("PH : "+ligne));
            ligne=ips.readLine();
            Element nt = doc_res.createElement("NT");
            ar.appendChild(nt);
            ligne=ligne.replace("NT :", "");
            ph.appendChild(doc_res.createTextNode("NT : "+ligne));
            ligne=ips.readLine();
            
             if(Id == 3)
            {
                ligne = ligne.replace("VE : DF : PH : NT :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                ar.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | NT : PH : DF : VE : "+ligne));
            }
            else
            {
                ligne = ligne.replace("VE : DF :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                ar.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | DF :  VE : "+ligne));
                ligne = ips.readLine();
                ligne= ligne.replace("PH :", "");
                Element rf2 = doc_res.createElement("RF");
                ar.appendChild(rf2);
                rf2.appendChild(doc_res.createTextNode("RF | PH :  "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("NT :", "");
                Element rf3 = doc_res.createElement("RF");
                ar.appendChild(rf3);
                rf3.appendChild(doc_res.createTextNode("RF | NT :  "+ligne));
            }
            ligne= ips.readLine();
            Element fr = doc_res.createElement("Langue");
            rac.appendChild(fr);
            fr.setAttribute("id", "FR");
            ligne = ips.readLine();
            ligne = ligne.replace("VE :", "");
            Element ve2 = doc_res.createElement("VE");
            fr.appendChild(ve2);
            ve2.appendChild(doc_res.createTextNode("VE : "+ligne));
            ligne = ips.readLine();
            ligne = ligne.replace("DF :", "");
            Element df2 = doc_res.createElement("DF");
            fr.appendChild(df2);
            df2.appendChild(doc_res.createTextNode("DF : "+ligne));
            ligne = ips.readLine();
            ligne = ligne.replace("PH :", "");
            Element ph2 = doc_res.createElement("PH");
            fr.appendChild(ph2);
            ph2.appendChild(doc_res.createTextNode("PH : "+ligne));
            ligne = ips.readLine();
            ligne = ligne.replace("NT :", "");
            Element nt2 = doc_res.createElement("NT");
            fr.appendChild(nt2);
            nt2.appendChild(doc_res.createTextNode("NT : "+ligne));
            
              if(Id == 4)
            {
                ligne = ips.readLine();
                ligne = ligne.replace("VE : DF : PH :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                fr.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | PH : DF : VE : "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("NT :", "");
                Element rf2 = doc_res.createElement("RF");
                fr.appendChild(rf2);
                rf2.appendChild(doc_res.createTextNode("RF | NT : "+ligne));
            }
            else
            {
                ligne = ips.readLine();
                ligne = ligne.replace("VE :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                fr.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | VE : "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("DF :", "");
                Element rf2 = doc_res.createElement("RF");
                fr.appendChild(rf2);
                rf2.appendChild(doc_res.createTextNode("RF | DF :  "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("PH :", "");
                Element rf3 = doc_res.createElement("RF");
                fr.appendChild(rf3);
                rf3.appendChild(doc_res.createTextNode("RF | PH :  "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("NT :", "");
                Element rf4 = doc_res.createElement("RF");
                fr.appendChild(rf4);
                rf4.appendChild(doc_res.createTextNode("RF | NT :  "+ligne));
            }
              Id++;

        }
        DOMSource ds1 = new DOMSource(doc_res);
		String comp = new String("fiches2.xml");

       

        StreamResult res = new StreamResult(new File(comp));
        TransformerFactory transform = TransformerFactory.newInstance();
        Transformer tr = transform.newTransformer();
       tr.setOutputProperty
        (OutputKeys.OMIT_XML_DECLARATION, "no");
     tr.setOutputProperty(OutputKeys.METHOD, "xml");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
       // tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "fiches.dtd");

        tr.transform(ds1, res);
        ips.close();
		
        
        return nameSortie+" ====>  ne pointe vers aucune dtd";}
    
    
    
    public static String ReadTxt(String pathcourant) throws Exception
    {
       
        DocumentBuilder parseur;
        CreateDomParser docParser = null;
          
        BufferedReader ips = new BufferedReader(new InputStreamReader(new FileInputStream(pathcourant), "UTF-8"));
        DOMImplementation impl = docParser.cons();
          //create document type
          DocumentType dtd = impl.createDocumentType("FICHES",null,"fiches.dtd");
          Document doc_res = impl.createDocument(null,"FICHES",dtd);
          doc_res.setXmlStandalone(true);
          doc_res.insertBefore(doc_res.createProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"fiches.xsl\""),doc_res.getDocumentElement());
          
        
  String nameSortie = "";
        Element racineSortie = doc_res.getDocumentElement();
        String ds ="";
        String ss= "";
        String ligne;
        int Id =1;
        
        while(((ligne=ips.readLine())!=null) && (Id<=4)){
       
            int t= ligne.length();
            //to relance the while boucle
            if(t<=1)continue;
            Element rac = doc_res.createElement("rac");
            rac.setAttribute("id",String.valueOf(Id));
            racineSortie.appendChild(rac);
            Element be = doc_res.createElement("BE");
            rac.appendChild(be);
            ligne = ligne.replace("BE","");
            be.appendChild(doc_res.createTextNode(ligne));
            ligne= ips.readLine();
            Element ty = doc_res.createElement("TY");
            rac.appendChild(ty);
            ligne=ligne.replace("TY","");
            ty.appendChild(doc_res.createTextNode("TY : "+ligne));
            ligne=ips.readLine();
            Element DO = doc_res.createElement("DO");
            ligne=ligne.replace("DO", "");
            ds=ligne;
            DO.appendChild(doc_res.createTextNode("DO : "+ligne));
            ligne=ips.readLine();
            Element sd= doc_res.createElement("SD");
            ligne = ligne.replace("SD", "");
            ss=ligne;
            sd.appendChild(doc_res.createTextNode("SD : "+ligne));
            ligne = ips.readLine();
            Element au = doc_res.createElement("AU");
            rac.appendChild(au);
            ligne =ligne.replace("AU", "");
            au.appendChild(doc_res.createTextNode("AU : "+ligne));
            ligne=ips.readLine();
            Element ar = doc_res.createElement("Langue");
            rac.appendChild(ar);
            ar.setAttribute("id","AR");
            ar.appendChild(DO);
            ar.appendChild(sd);
            ligne = ips.readLine();
            Element ve = doc_res.createElement("VE");
            ar.appendChild(ve);
            ligne = ligne.replace("VE :", "");
            ve.appendChild(doc_res.createTextNode("VE : "+ligne));
            ligne=ips.readLine();
            Element df = doc_res.createElement("DF");
            ar.appendChild(df);
            ligne=ligne.replace("DF :", "");
            df.appendChild(doc_res.createTextNode("DF : "+ligne));
            ligne=ips.readLine();
            Element ph = doc_res.createElement("PH");
            
            ligne=ligne.replace("PH :", "");
            ph.appendChild(doc_res.createTextNode("PH : "+ligne));
            ar.appendChild(ph);
            ligne=ips.readLine();
            ligne=ligne.replace("NT :", "");
            Element nt = doc_res.createElement("NT");
            ar.appendChild(nt);
            ph.appendChild(doc_res.createTextNode("NT : "+ligne));
            ligne=ips.readLine();
            
             if(Id == 3)
            {
                ligne = ligne.replace("VE : DF : PH : NT :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                ar.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | NT : PH : DF : VE : "+ligne));
            }
            else
            {
                ligne = ligne.replace("VE : DF :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                ar.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | DF :  VE : "+ligne));
                ligne = ips.readLine();
                ligne= ligne.replace("PH :", "");
                Element rf2 = doc_res.createElement("RF");
                ar.appendChild(rf2);
                rf2.appendChild(doc_res.createTextNode("RF | PH :  "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("NT :", "");
                Element rf3 = doc_res.createElement("RF");
                ar.appendChild(rf3);
                rf3.appendChild(doc_res.createTextNode("RF | NT :  "+ligne));
            }
            ligne= ips.readLine();
            Element fr = doc_res.createElement("Langue");
            rac.appendChild(fr);
            fr.setAttribute("id", "FR");
            Element do2 = doc_res.createElement("DO");
            fr.appendChild(do2);
            do2.appendChild(doc_res.createTextNode("DO : "+ds));
            Element sd2 = doc_res.createElement("SD");
            fr.appendChild(sd2);
            sd2.appendChild(doc_res.createTextNode("SD : "+ss));
            ligne = ips.readLine();
            ligne = ligne.replace("VE :", "");
            Element ve2 = doc_res.createElement("VE");
            fr.appendChild(ve2);
            ve2.appendChild(doc_res.createTextNode("VE : "+ligne));
            ligne = ips.readLine();
            ligne = ligne.replace("DF :", "");
            Element df2 = doc_res.createElement("DF");
            fr.appendChild(df2);
            df2.appendChild(doc_res.createTextNode("DF : "+ligne));
            ligne = ips.readLine();
            ligne = ligne.replace("PH :", "");
            Element ph2 = doc_res.createElement("PH");
            fr.appendChild(ph2);
            ph2.appendChild(doc_res.createTextNode("PH : "+ligne));
            ligne = ips.readLine();
            ligne = ligne.replace("NT :", "");
            Element nt2 = doc_res.createElement("NT");
            fr.appendChild(nt2);
            nt2.appendChild(doc_res.createTextNode("NT : "+ligne));
            
              if(Id == 4)
            {
                ligne = ips.readLine();
                ligne = ligne.replace("VE : DF : PH :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                fr.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | PH : DF : VE : "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("NT :", "");
                Element rf2 = doc_res.createElement("RF");
                fr.appendChild(rf2);
                rf2.appendChild(doc_res.createTextNode("RF | NT : "+ligne));
            }
            else
            {
                ligne = ips.readLine();
                ligne = ligne.replace("VE :	RF :", "");
                Element rf1 = doc_res.createElement("RF");
                fr.appendChild(rf1);
                rf1.appendChild(doc_res.createTextNode("RF | VE : "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("DF :", "");
                Element rf2 = doc_res.createElement("RF");
                fr.appendChild(rf2);
                rf2.appendChild(doc_res.createTextNode("RF | DF :  "+ligne));
                ligne = ips.readLine();
                ligne = ligne.replace("PH :", "");
                Element rf3 = doc_res.createElement("RF");
                fr.appendChild(rf3);
                rf3.appendChild(doc_res.createTextNode("RF | PH :  "+ligne));
                ligne = ips.readLine();              
                Element rf4 = doc_res.createElement("RF");
                fr.appendChild(rf4);
                rf4.appendChild(doc_res.createTextNode("RF | NT :  "+ligne));
            }
              Id++;          
        }
        DOMSource ds1 = new DOMSource(doc_res);
        nameSortie= "fichier1.xml";
		String comp = new String("fiches1.xml");

        StreamResult res = new StreamResult(new File(comp));
        TransformerFactory transform = TransformerFactory.newInstance();
        Transformer tr = transform.newTransformer();
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");//specifies that the result tree will be written out as XML
        
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "fiches.dtd");
        
        tr.transform(ds1, res);
        return nameSortie+" ====>  fiches.dtd";
    }
}