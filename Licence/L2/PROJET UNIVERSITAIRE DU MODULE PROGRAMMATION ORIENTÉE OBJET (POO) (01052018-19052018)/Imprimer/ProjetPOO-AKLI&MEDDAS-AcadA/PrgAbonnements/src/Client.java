import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Client {
	private String nom, prénom;private String numTelephone;private boolean bloqué;private Abonnement Abon;
	private Date DateOper;private boolean AvantBloqué;private AdresseMail mail;private Adresse Adr;
	private Set <Appel> A1= new HashSet<Appel>();
	private Set<Appel>A = new TreeSet<Appel>(new Comparator<Appel>() 
	{
		   
	    @Override
		public int compare(Appel one, Appel other) {
			// TODO Auto-generated method stub
	    	int cpr;
			if((cpr=one.getDateEvoie().compare(other.getDateEvoie()))==0)
			{
				return Heure.compare(one.getHeureEnvoie(),other.getHeureEnvoie());
				//pour le cas ou on crée deux appel au meme temps il y aura une exception et
				// l'appel ne se créea pas
			}
			else
				return cpr;
			
		}
	});
	
	
	/**
	 * @return the avantBloqué
	 */
	public boolean isAvantBloqué() {
		return AvantBloqué;
	}
	/**
	 * @param avantBloqué the avantBloqué to set
	 */
	public void setAvantBloqué(boolean avantBloqué) {
		AvantBloqué = avantBloqué;
	}
	/**
	 * @return the mail
	 */
	public AdresseMail getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(AdresseMail mail) {
		this.mail = mail;
	}
	public Set <Appel> getA() {
		return A;
	}
	public void setA(Set <Appel> a) {
		A = a;
	}
	/**
	 * @return the adr
	 */
	public Adresse getAdr() {
		return Adr;
	}
	/**
	 * @param adr the adr to set
	 */
	public void setAdr(Adresse adr) {
		Adr = adr;
	}
/**
	 * @return the abon
	 */
	public Abonnement getAbon() {
		return Abon;
	}
	/**
	 * @param abon the abon to set
	 */
	public void setAbon(Abonnement abon) {
		Abon = abon;
	}
	/**
	 * @param bloqué the bloqué to set
	 */
	public void setBloqué(boolean bloqué) {
		this.bloqué = bloqué;
	}
	public Date getDateOper() {
		return DateOper;
	}
	public void setDateOper(Date dateOper) {
		DateOper = dateOper;
	}
	//********************************************************
	//*******************constructeur*************************
	//********************************************************
	public Client() {
		
	}
	
	public Client(String nom, String prénom, String numTelephone,Date d,AdresseMail mail,Adresse adr,  Abonnement A) 
	throws  NegativeException, TelephoneExceptions, DateException, AdresseException
	   {
		if(!Client.verifieNumTelephone(numTelephone))
		{
			throw new TelephoneExceptions(" Numéro de téléphone invalide !!");
		}
		
		this.nom = nom;
		this.prénom = prénom;
		this.numTelephone = numTelephone;
		this.Abon=A;
		this.DateOper= d;
		this.Adr=adr;
		this.mail=mail;
		this.setAvantBloqué(false);//il peut appelé si c'est vreai il ne peut que recevoir
		this.setBloqué(false);//si c'est vrai il ne peut po effectuer ni des appels ni des sms ni les recevoire
	}
	//*******************************************************
	//***************construire client***********************
	public static Client construireClient(String numeroTelephone,String dateContrat, String nom, String prénom, String adresse,
			String mail, Abonnement TypeAbon, int durée, String datedebabon, double montant)throws Exception, NegativeException, TelephoneExceptions, DateException,AdresseException
    {
    	Client c = null;Date d ;Date dAbon;Adresse Adr;AdresseMail adrMail;
    	try{//verifier si le numéro entrée est valide
    		//System.out.println(numeroTelephone.charAt(0));
    		 if(numeroTelephone.length()!=10 && numeroTelephone.charAt(0) != 0)
    		    throw new  TelephoneExceptions("Numéro de téléphone invalide !!");
    		    dAbon=Date.Parse(datedebabon);
    		    if(dAbon==null )//erreur de saisit de date
    			{throw new DateException("date d'abonnement");
    			}if(montant < 0 || durée < 0)
    			{throw new NegativeException("nombre négative !!");
    			}d=Date.Parse(dateContrat);
    		    if(d==null )//erreur de saisit de date
        		{throw new DateException("date de contrat non valid");
        		}if(Date.compareTo(dateContrat, datedebabon)==1)
        	    {throw new DateException("erreur logique !! (date de contrat ne doit pas venir après date d'abonnement");
        	    }Adr=Adresse.Parse(adresse);
        	    if(Adr == null) 
        	    {throw new AdresseException("Adresse invalide");
        	    }adrMail= AdresseMail.Parse(mail);
        	    if(adrMail.getExtension() == null || adrMail.getNomSite()==null || adrMail.getNomUser()==null)
        	    {
        	    	throw new Exception("Adresse mail invalid !!");
        	    }
        	   c=new Client(nom,prénom,numeroTelephone,d,adrMail,Adr, TypeAbon );
        	   c.Abon.setDateDebAbon(dAbon);
        	   c.Abon.setDurée(durée);
        	   c.Abon.setSoldeMontant(montant);
        	 
        	    return c;
        	    //if(dateContrat)
    		//c= new Client( numeroTelephone,  dateContrat, nom,prénom, adresse, mail, TypeAbon);
    	}
    	catch(TelephoneExceptions t)
    	{c= new Client();System.out.println("vous devez resaisir à nouveau ==(information vide1)");
    		
    	}
    	catch(DateException del)
    	{System.out.println("vous devez resaisir à nouveau ==(information vide2)");
		
    		c= new Client();
    	}
    	catch(AdresseException dhe)
    	{System.out.println("vous devez resaisir à nouveau ==(information vide3)");
		
    		c= new Client();
    	}
    	catch(NegativeException e)
    	{System.out.println("vous devez resaisir à nouveau ==(information vide4)");
		
    		c=new Client();
    	}
    	return c;
    }
	//*******************************************************
	//*******************************************************
	//**************Affichage********************************
	//*******************************************************
	public  void Affichage()
	{
		System.out.println(this);}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Client [nom=" + nom + ", prénom=" + prénom + ", numTelephone=" + numTelephone + ", bloqué=" + bloqué
					+ ", Abon=" + Abon + ", DateOper=" + DateOper + ", AvantBloqué=" + AvantBloqué + ", mail=" + mail
					+ ", Adresse=" + Adr + "]\n";
		}
	
	//------------afficher l'ensemble des appel:
		public void AfficherAppel()
		{
			System.out.println(this.getA());
		}
		public void AfficherAppelEmis()
		{
			for(Appel A : this.A)
			{
				if(A instanceof AppelEmis)
				{
					System.out.println(A);
				}
			}
		}
		public void AfficherAppelRecu()
		{
			for(Appel A : this.A)
			{
				if(A instanceof AppelRecu)
				{
					System.out.println(A);
				}
			}	
		}
	//*********************************************************
	//******************getter et setter**********************
	//********************************************************
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prénom
	 */
	public String getPrénom() {
		return prénom;
	}
	/**
	 * @param prénom the prénom to set
	 */
	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}
	
	
	//private Adresse 
	
    //--------------------------------
	/**
	 * @return the numTelephone
	 */
	public String getNumTelephone() {
		return numTelephone;
	}
	/**
	 * @param numTelephone the numTelephone to set
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	//------------------------------------------------------------
	//------------------------------------------------------------
	//------------------------------------------------------------
	//-------voir si deux num son du meme opérateur
	public boolean memeOperateur(String s)
	{
		if(this.getNumTelephone().charAt(1)==s.charAt(1))return true;
		return false;
	}
	//-------voir si un numéro est vers l'etranger
	public boolean versEtranger(String s)
	{
		if(!this.memeOperateur(s))
		{
			if(s.charAt(1)==0)return true;
		}
		return false;
	}
	//-------voir si un numéro donnée n'aest po du meme opérateur
	public boolean operateurDifférent(String s)
	{
		if(!this.versEtranger(s) || !this.memeOperateur(s))return true;
		return false;
	}
	//--------------------------------------------------------------
	//--------------------------------------------------------------
	//--------------------------------------------------------------
	public static boolean verifieNumTelephone(String s)
	{int i=0;
		if(s.length() == 10)
		{
			if(s.charAt(1)!=0)
			{
			   for( i=0; i<s.length() && Character.isDigit(s.charAt(i)); i++)
			   {
				   
			   }
				if(i==s.length())return true;
			}
		}
		return false;
	}
	
	//*************************************************
	//*****************bloqué client*******************
	//*************************************************
	//---------si client bloqué retourne true sinon retourne false
	public boolean isBloqué()
	{return this.bloqué;	
	}
	//---------voir si on bloque le client ou non:
	public void stBloqué(Date D)
	{
		if(this.getAbon().verifierDate(D)==-1)
		{
			this.setBloqué(true);
		}
			if(this.getAbon().verifierDate(D)==0)
			{  
			//crée 3 smsentrant
				//remettre compteur a 0 // envoyé le premier sms
				//le deuxieme apres 3 jour , le troisieme apres 10 jour
				//creer 3 smsentrant meme message meme numéro date différente
				//
				//this.getMessageIsbloqué();
				 this.setBloqué(true);
			}
			//voir si on bloque ou nn
		
		
	}
	//----------methode on lui donne la date d'envoi d'un sms, appel / recu , 
	//si on a atteint la date finfixemax d'abonnement on bloque
	//sinon on envoie 3 sms contenant le num du client avant de décidé de le bloqué
	//getDuéeCumulé
	//---durée cumulé:
	/*public int getDuéeCumuléAppel()
	{int duréecumulé=0;
		for(int i=0;i<this.A.size())
			duréecumulé=this.A.
			
	}*/
	//----------ajouter appel 
	public int getUnity(String s)
	{
		if(this.memeOperateur(s))return 4;
		if(this.operateurDifférent(s))return 5;
		if(this.versEtranger(s))return 20;
		return 0;
	}
	
	
	private Date getLastDate() {//retourne la derniere date d'appel ou sms
		// TODO Auto-generated method stub
		return null;
	}
	//------Ajouter un appel dans le tableau des appel
	public void AjouterAppels(String s, Date D, Heure h,int durée)throws NegativeException, DateException, HeureException, TelephoneExceptions
	{if(!Client.verifieNumTelephone(s))
	{throw new TelephoneExceptions("le numéro que vous avez composé n'est pas valide °°°°°");
    }
    if(durée <0)
    {
	
    }
    if(this.Abon.verifierAtteinteDateFBloqué().compare(D)==-1)
    	throw new DateException("date invalide  !!!");
    if(this.Abon.verifierAtteinteDateFBloqué().compare(D)==0)
    //appelé  methode verifie si on bloque client ou pas
    	;
    
	if(this.Abon.verifierDate(D)==-1)//impossible d'ajouter
	{
	//si le retourn est null 
	//on envoie les trois sms entrant puis on va voir si on bloque ou non
	//'on decide de bloqué ou de payer; réajouter un nouvel abonnement(réinitialisé)
	}
else 
{
	if(this.Abon.verifierDate(D)==0)
    {
	
	System.out.println(" Date expire aujourd'hui (veuillez payer votre facture!!) ");
	//on peut pas ajouté mais on reçois
	
    }
		this.A.add(this.AjouterAppel(s, D,h, durée));
	}
	}
	//-----créer un appel
	public  Appel AjouterAppel( String s, Date D, Heure H,int durée )
	{//si client bloqué pas la peine d'ajouter
		if(!this.isBloqué())
		{
			
			
			//voir si on peut ajouter à cette date:
			if(DateOper.compare(getDateOper(), D)==1){
			
				System.out.println("erreur de date_ la date d'appel vient après la date d'inscription ( Invalide  !!)"); }
		    if(DateOper.compare(getDateOper(), D)==0)
		    {
		    	if(DateOper.compare(this.getAbon().getDateDebAbon(), D)==1)//trhow exception
		    	{System.out.println("erreur de date_ la date d'appel ne vient pas avant la date de début d'abonnement( Invalide  !!)"); }
				  
		    }
		    this.stBloqué(D);
		    if(!this.isBloqué())//---il n est po bloqué
		    {	Appel app;
		    if(this.AvantBloqué == false)
			{try {
				app = this.Abon.AjouterAppel(this, s, D, H, durée);
				return app;
			    } catch (SoldeException c) {
				// TODO Auto-generated catch block
			    	this.AvantBloqué=true;
			    	this.A.add(new Appel(null,null,null,null,Status.echec));
			    	System.out.println(this+" echec d'envoie ");
			    	System.err.println(" solde insuffisant");
				
		    	}catch(DateException e){
				return null;
			    } catch (SoldeInssuffisantException e) {
					// TODO Auto-generated catch block
			    	
					this.A.add(new Appel(this.getNumTelephone(), D, H," ",s,Status.fin_d_appel, this.getAbon().getDurée()));
				    this.Abon.setSoldeMontant(0);
			    }
			
		        return null;
		    }else{//--------est bloqué après mise a jour de l'etat bloqué du client avec stBloqué(D)
				try {
					
					throw new ClientException("\ndevient bloquée !! : ");
				     } catch (ClientException e)
				     {
					// TODO Auto-generated catch block
					System.out.println(" client : "+this);
					this.setBloqué(true);
					return null;}
				     //--fin try cacth}
				
			}}
		    else{
		    	try {
					throw new SoldeException("\nvous ne pouvez plus effectué d'appel vous devez chargé votre crédit :");
				} catch (SoldeException e) {
					// TODO Auto-generated catch block
					System.out.print(this);
					this.setAvantBloqué(true);
					return null;
				}
		    	
		    	
		    }
		}
			else{//---si client est bloqé
				try {
					throw new ClientException(" client"+this+" bloquée Impossible d'effectué l'appel !!");
				} catch (ClientException e) {
					// TODO Auto-generated catch block
					this.setBloqué(true);
					return null;
				}}
		
	}//----fin methode ajouter appel

	public void bloqué()
	{
		
	}
}
