package xml;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Main 
{

    public static void parcoursDir(Path rep) throws Exception
    {
        try (DirectoryStream<Path> DStream = Files.newDirectoryStream(rep)) 
        { 
  		  for (Path dir : DStream) 
  		  { 
            if (Files.exists(dir))
            {           	
                if (Files.isDirectory(dir))
                {
                	parcoursDir(dir);
                }                	
                else
                {
                	String	pathcourant= dir.toString();               	       	
                    String newFile;
					if (pathcourant.matches(".*\\.xml$")) 
                    {
                        newFile = TransformXml.transformerXml(pathcourant);
                        System.out.println("fin de traitement du fichier  : "+dir.getFileName()+" transform� en fichier  :"+newFile.toString());
                        
                        
                    }
                    if (pathcourant.endsWith("\\fiches.txt"))
                    { 	               
                    	 newFile = TrasnformFiches.ReadTxt(pathcourant);
                    	 System.out.println("fin de traitement du fichier  : "+dir.getFileName()+" transform� en fichier  :"+newFile.toString());
                         
                         
                    	 newFile = TrasnformFiches.ReadTxt2(pathcourant);
                    	 System.out.println("fin de traitement du fichier  : "+dir.getFileName()+" transform� en fichier  :"+newFile.toString());
                         
                         
                    }
                    if (pathcourant.matches(".*e.txt")) 
                    {                    	                   	
                        newFile = TransformerPoeme.transformerP(pathcourant); 
                        System.out.println("fin de traitement du fichier  : "+dir.getFileName()+" transform� en fichier  :"+newFile.toString());                                               
                    }
                    if (pathcourant.matches(".*\\.*html$")) 
                    {        	
                        newFile = TransformerRenault.transformerRen(pathcourant);
                        System.out.println("fin de traitement du fichier  : "+dir.getFileName()+" transform� en fichier  :"+newFile.toString());
                    }
                    if (pathcourant.matches(".*fxml"))
                    {                    	 
                        newFile = TransformerBoite.transformerBo(pathcourant);
                        System.out.println("fin de traitement du fichier  : "+dir.getFileName()+" transform� en fichier  :"+newFile.toString());
                    }
                }
              } 
  		}
        
        }
        catch (IOException e) 
        { 
        		    e.printStackTrace() ;
        }           
    }    
    public static void main(String[] args) throws Exception 
    { System.out.println("_______________________________________________________________________");
    
        System.out.println("Donner un chemin de repertoire\n");
        System.out.println("_______________________________________________________________________");
         if (args.length == 0)
         {
            System.out.println("Attention vous avez oubli� de sp�cifier le nom du r�pertoire � traiter !");
         }
        else 
        {System.out.println("Veuillez attendre jusqu'� l'affichage du message \"Traitement fini\"");
        	/*Create a Path from String  */
        	 File dir = new File(args[0]);
             
             // Tests whether the directory denoted by this abstract pathname exists.
             boolean exists = dir.exists();
             if (exists)
        	{Path repertoire = Paths.get(args[0]); 
        	/*Une instance de type Path stocke les
        	 *  �l�ments de la hi�rarchie du chemin sous une forme s�quentielle, 
        	 *  l'�l�ment le plus haut dans la hi�rarchie (apr�s la racine) ayant
        	 *   l'index 0 et l'�l�ment le plus bas ayant l'index n-1, n �tant
        	 *    le nombre d'�l�ments du chemin.*/
        	
        	/*start the recursive parcour on the input directory:*/
            parcoursDir(repertoire);
            System.out.println("Traitement fini");
            System.out.println("_______________________________________________________________________");
            
        	}
             else
             {
            	 System.out.println("Attention vous avez oubli� de sp�cifier le nom du r�pertoire � traiter !");  
            	 System.out.println("_______________________________________________________________________");
                 
             }
        }
    }
}





