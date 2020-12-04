package xml;


import javax.xml.parsers.*;
import org.w3c.dom.DOMImplementation;
public class CreateDomParser{
	//create a dom parser to be used later, deja vu en cours
	public static  DocumentBuilder parseur() throws ParserConfigurationException {
		DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return parseur;
	}
 	public static  DOMImplementation cons() throws ParserConfigurationException {
		DOMImplementation cons=parseur().getDOMImplementation();
		return cons;
	}
}
