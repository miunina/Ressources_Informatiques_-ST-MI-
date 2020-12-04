
import java.util.Scanner;
public class AdresseMail  {
	private String nomUser;
	private Site nomSite;
	private  String extension;
//constructeur avec paramètre
	/*public AdresseMail(String nomUser, String nomSite, String extension) {	
	    try{
	    	this.setNomSite (Site.valueOf(nomSite.toUpperCase()));
            this.setNomUser(nomUser);
		    this.setExtension(extension);
            } catch(NullPointerException e) 
            {System.out.print("you must introduce name user or extension");
            this.setNomSite (null);
            this.setNomUser(null);
  	        this.setExtension(null);}
	         catch(IllegalArgumentException e)
	         {System.out.print("there is no constant like that");
	    	this.setNomSite (null);
	        this.setNomUser(null);
		    this.setExtension(null);
		    } 
	    catch(Exception ce)
	    {this.setNomSite (null);
        this.setNomUser(null);
	    this.setExtension(null);
	    	
	    }
	    //si l'adresse n'est pas valid on aura un espace resérvé mais vide contient des null@null.null par exemple
	}*/
	public AdresseMail(String nomUser, String nomSite, String extension)	{
		this.setNomSite (Site.valueOf(nomSite.toUpperCase()));
        this.setNomUser(nomUser);
	    this.setExtension(extension);
	}
//construceut sans paramètre
	public AdresseMail() {
		
	}
	public static AdresseMail Parse(String s)
	{
		String ss [];
		String [] part = new String[3];
		part=s.split("@");
		ss=part[1].split("\\.");
		
		
		AdresseMail A = null;
		A = new AdresseMail(part[0],ss[0],ss[1]);
	return A;
	}
	public void saisir()
	{
		Scanner s = new Scanner(System.in);
		boolean found = false;
		do{
			System.out.println("\n nom user ");
			nomUser=s.next();
			
		}while(nomUser == null);
		int n= 0;
		boolean found2;
		System.out.println("\n nom site ");
		String g = new String(s.next());//chaine utiliser pour récupérer le nom du site lue par s
		do{found2 = true;
		try{setNomSite(Site.valueOf(g.toUpperCase()));}
		//mettre nom site
		catch(IllegalArgumentException e){//en cas d'erreur (argument invalid) on récupère l'exception dans ce catch
			System.err.println("please enter a valid argument !!");
			found2=false;
			System.out.println("\n nom site:");
			g=(s.next());
		}
		catch(Exception e){
			System.err.println("please enter a valid argument !!");
			found2=false;
			System.out.println("\n nom site:");
			g=(s.next());
		}	 
		}while(n != 0);
		do{
        	System.out.println("\nextension ");
        	//s.useDelimiter("\n");
        	extension = s.next();	
		}while(extension == null);
	}
	//--pour afficher une adresse mail
	public void Afficher()
	{System.out.println("Adresse mail : "+this.toString());}
	//methode toString de la classe objet
	public String toString()
	{return this.getNomUser()+"@"+String.valueOf(getNomSite()).toLowerCase()+"."+this.getExtension();}
	//_______________________________________________________voir si c'est meme site:
	public boolean MemeSite(AdresseMail a1)
	{return ((this.getNomSite().toString()).compareTo((a1.getNomSite().toString()))==0);}
	//_____________________________________________________voir egalitée entre :adressemail
	public static boolean Egale(AdresseMail a1, AdresseMail a2)
	{return ((a1).compare(a2)==0);}
	public boolean Egale(AdresseMail a1)
	{return ((this).compare(a1)==0);}
    //_____________________________________________________comparer:nomsite && nomuser
	
    public int compare(AdresseMail s2)
    { return this.toString().compareTo(s2.toString());}
    public static int compare(AdresseMail s1, AdresseMail s2) 
    {return s1.toString().compareTo(s2.toString());}	//_________________________________________________________________________
	//les getters et les setters
	/**
	 * @return the nomUser
	 */
	public String getNomUser() {
		return nomUser;
	}
	/**
	 * @param nomUser the nomUser to set
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	/**
	 * @return the extension
	 */
	public  String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public  void setExtension(String extension) {
		this.extension = extension;
	}

	public Site getNomSite() {
		return nomSite;
	}

	public void setNomSite(Site nomSite) {
		this.nomSite = nomSite;
	}
    //***----fin getters et setters*************/
}
