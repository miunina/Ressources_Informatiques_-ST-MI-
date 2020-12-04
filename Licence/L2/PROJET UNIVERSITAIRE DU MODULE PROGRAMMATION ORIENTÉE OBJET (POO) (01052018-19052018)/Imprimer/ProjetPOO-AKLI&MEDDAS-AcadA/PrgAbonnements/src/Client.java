import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Client {
	private String nom, pr�nom;private String numTelephone;private boolean bloqu�;private Abonnement Abon;
	private Date DateOper;private boolean AvantBloqu�;private AdresseMail mail;private Adresse Adr;
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
				//pour le cas ou on cr�e deux appel au meme temps il y aura une exception et
				// l'appel ne se cr�ea pas
			}
			else
				return cpr;
			
		}
	});
	
	
	/**
	 * @return the avantBloqu�
	 */
	public boolean isAvantBloqu�() {
		return AvantBloqu�;
	}
	/**
	 * @param avantBloqu� the avantBloqu� to set
	 */
	public void setAvantBloqu�(boolean avantBloqu�) {
		AvantBloqu� = avantBloqu�;
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
	 * @param bloqu� the bloqu� to set
	 */
	public void setBloqu�(boolean bloqu�) {
		this.bloqu� = bloqu�;
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
	
	public Client(String nom, String pr�nom, String numTelephone,Date d,AdresseMail mail,Adresse adr,  Abonnement A) 
	throws  NegativeException, TelephoneExceptions, DateException, AdresseException
	   {
		if(!Client.verifieNumTelephone(numTelephone))
		{
			throw new TelephoneExceptions(" Num�ro de t�l�phone invalide !!");
		}
		
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.numTelephone = numTelephone;
		this.Abon=A;
		this.DateOper= d;
		this.Adr=adr;
		this.mail=mail;
		this.setAvantBloqu�(false);//il peut appel� si c'est vreai il ne peut que recevoir
		this.setBloqu�(false);//si c'est vrai il ne peut po effectuer ni des appels ni des sms ni les recevoire
	}
	//*******************************************************
	//***************construire client***********************
	public static Client construireClient(String numeroTelephone,String dateContrat, String nom, String pr�nom, String adresse,
			String mail, Abonnement TypeAbon, int dur�e, String datedebabon, double montant)throws Exception, NegativeException, TelephoneExceptions, DateException,AdresseException
    {
    	Client c = null;Date d ;Date dAbon;Adresse Adr;AdresseMail adrMail;
    	try{//verifier si le num�ro entr�e est valide
    		//System.out.println(numeroTelephone.charAt(0));
    		 if(numeroTelephone.length()!=10 && numeroTelephone.charAt(0) != 0)
    		    throw new  TelephoneExceptions("Num�ro de t�l�phone invalide !!");
    		    dAbon=Date.Parse(datedebabon);
    		    if(dAbon==null )//erreur de saisit de date
    			{throw new DateException("date d'abonnement");
    			}if(montant < 0 || dur�e < 0)
    			{throw new NegativeException("nombre n�gative !!");
    			}d=Date.Parse(dateContrat);
    		    if(d==null )//erreur de saisit de date
        		{throw new DateException("date de contrat non valid");
        		}if(Date.compareTo(dateContrat, datedebabon)==1)
        	    {throw new DateException("erreur logique !! (date de contrat ne doit pas venir apr�s date d'abonnement");
        	    }Adr=Adresse.Parse(adresse);
        	    if(Adr == null) 
        	    {throw new AdresseException("Adresse invalide");
        	    }adrMail= AdresseMail.Parse(mail);
        	    if(adrMail.getExtension() == null || adrMail.getNomSite()==null || adrMail.getNomUser()==null)
        	    {
        	    	throw new Exception("Adresse mail invalid !!");
        	    }
        	   c=new Client(nom,pr�nom,numeroTelephone,d,adrMail,Adr, TypeAbon );
        	   c.Abon.setDateDebAbon(dAbon);
        	   c.Abon.setDur�e(dur�e);
        	   c.Abon.setSoldeMontant(montant);
        	 
        	    return c;
        	    //if(dateContrat)
    		//c= new Client( numeroTelephone,  dateContrat, nom,pr�nom, adresse, mail, TypeAbon);
    	}
    	catch(TelephoneExceptions t)
    	{c= new Client();System.out.println("vous devez resaisir � nouveau ==(information vide1)");
    		
    	}
    	catch(DateException del)
    	{System.out.println("vous devez resaisir � nouveau ==(information vide2)");
		
    		c= new Client();
    	}
    	catch(AdresseException dhe)
    	{System.out.println("vous devez resaisir � nouveau ==(information vide3)");
		
    		c= new Client();
    	}
    	catch(NegativeException e)
    	{System.out.println("vous devez resaisir � nouveau ==(information vide4)");
		
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
			return "Client [nom=" + nom + ", pr�nom=" + pr�nom + ", numTelephone=" + numTelephone + ", bloqu�=" + bloqu�
					+ ", Abon=" + Abon + ", DateOper=" + DateOper + ", AvantBloqu�=" + AvantBloqu� + ", mail=" + mail
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
	 * @return the pr�nom
	 */
	public String getPr�nom() {
		return pr�nom;
	}
	/**
	 * @param pr�nom the pr�nom to set
	 */
	public void setPr�nom(String pr�nom) {
		this.pr�nom = pr�nom;
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
	//-------voir si deux num son du meme op�rateur
	public boolean memeOperateur(String s)
	{
		if(this.getNumTelephone().charAt(1)==s.charAt(1))return true;
		return false;
	}
	//-------voir si un num�ro est vers l'etranger
	public boolean versEtranger(String s)
	{
		if(!this.memeOperateur(s))
		{
			if(s.charAt(1)==0)return true;
		}
		return false;
	}
	//-------voir si un num�ro donn�e n'aest po du meme op�rateur
	public boolean operateurDiff�rent(String s)
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
	//*****************bloqu� client*******************
	//*************************************************
	//---------si client bloqu� retourne true sinon retourne false
	public boolean isBloqu�()
	{return this.bloqu�;	
	}
	//---------voir si on bloque le client ou non:
	public void stBloqu�(Date D)
	{
		if(this.getAbon().verifierDate(D)==-1)
		{
			this.setBloqu�(true);
		}
			if(this.getAbon().verifierDate(D)==0)
			{  
			//cr�e 3 smsentrant
				//remettre compteur a 0 // envoy� le premier sms
				//le deuxieme apres 3 jour , le troisieme apres 10 jour
				//creer 3 smsentrant meme message meme num�ro date diff�rente
				//
				//this.getMessageIsbloqu�();
				 this.setBloqu�(true);
			}
			//voir si on bloque ou nn
		
		
	}
	//----------methode on lui donne la date d'envoi d'un sms, appel / recu , 
	//si on a atteint la date finfixemax d'abonnement on bloque
	//sinon on envoie 3 sms contenant le num du client avant de d�cid� de le bloqu�
	//getDu�eCumul�
	//---dur�e cumul�:
	/*public int getDu�eCumul�Appel()
	{int dur�ecumul�=0;
		for(int i=0;i<this.A.size())
			dur�ecumul�=this.A.
			
	}*/
	//----------ajouter appel 
	public int getUnity(String s)
	{
		if(this.memeOperateur(s))return 4;
		if(this.operateurDiff�rent(s))return 5;
		if(this.versEtranger(s))return 20;
		return 0;
	}
	
	
	private Date getLastDate() {//retourne la derniere date d'appel ou sms
		// TODO Auto-generated method stub
		return null;
	}
	//------Ajouter un appel dans le tableau des appel
	public void AjouterAppels(String s, Date D, Heure h,int dur�e)throws NegativeException, DateException, HeureException, TelephoneExceptions
	{if(!Client.verifieNumTelephone(s))
	{throw new TelephoneExceptions("le num�ro que vous avez compos� n'est pas valide �����");
    }
    if(dur�e <0)
    {
	
    }
    if(this.Abon.verifierAtteinteDateFBloqu�().compare(D)==-1)
    	throw new DateException("date invalide  !!!");
    if(this.Abon.verifierAtteinteDateFBloqu�().compare(D)==0)
    //appel�  methode verifie si on bloque client ou pas
    	;
    
	if(this.Abon.verifierDate(D)==-1)//impossible d'ajouter
	{
	//si le retourn est null 
	//on envoie les trois sms entrant puis on va voir si on bloque ou non
	//'on decide de bloqu� ou de payer; r�ajouter un nouvel abonnement(r�initialis�)
	}
else 
{
	if(this.Abon.verifierDate(D)==0)
    {
	
	System.out.println(" Date expire aujourd'hui (veuillez payer votre facture!!) ");
	//on peut pas ajout� mais on re�ois
	
    }
		this.A.add(this.AjouterAppel(s, D,h, dur�e));
	}
	}
	//-----cr�er un appel
	public  Appel AjouterAppel( String s, Date D, Heure H,int dur�e )
	{//si client bloqu� pas la peine d'ajouter
		if(!this.isBloqu�())
		{
			
			
			//voir si on peut ajouter � cette date:
			if(DateOper.compare(getDateOper(), D)==1){
			
				System.out.println("erreur de date_ la date d'appel vient apr�s la date d'inscription ( Invalide  !!)"); }
		    if(DateOper.compare(getDateOper(), D)==0)
		    {
		    	if(DateOper.compare(this.getAbon().getDateDebAbon(), D)==1)//trhow exception
		    	{System.out.println("erreur de date_ la date d'appel ne vient pas avant la date de d�but d'abonnement( Invalide  !!)"); }
				  
		    }
		    this.stBloqu�(D);
		    if(!this.isBloqu�())//---il n est po bloqu�
		    {	Appel app;
		    if(this.AvantBloqu� == false)
			{try {
				app = this.Abon.AjouterAppel(this, s, D, H, dur�e);
				return app;
			    } catch (SoldeException c) {
				// TODO Auto-generated catch block
			    	this.AvantBloqu�=true;
			    	this.A.add(new Appel(null,null,null,null,Status.echec));
			    	System.out.println(this+" echec d'envoie ");
			    	System.err.println(" solde insuffisant");
				
		    	}catch(DateException e){
				return null;
			    } catch (SoldeInssuffisantException e) {
					// TODO Auto-generated catch block
			    	
					this.A.add(new Appel(this.getNumTelephone(), D, H," ",s,Status.fin_d_appel, this.getAbon().getDur�e()));
				    this.Abon.setSoldeMontant(0);
			    }
			
		        return null;
		    }else{//--------est bloqu� apr�s mise a jour de l'etat bloqu� du client avec stBloqu�(D)
				try {
					
					throw new ClientException("\ndevient bloqu�e !! : ");
				     } catch (ClientException e)
				     {
					// TODO Auto-generated catch block
					System.out.println(" client : "+this);
					this.setBloqu�(true);
					return null;}
				     //--fin try cacth}
				
			}}
		    else{
		    	try {
					throw new SoldeException("\nvous ne pouvez plus effectu� d'appel vous devez charg� votre cr�dit :");
				} catch (SoldeException e) {
					// TODO Auto-generated catch block
					System.out.print(this);
					this.setAvantBloqu�(true);
					return null;
				}
		    	
		    	
		    }
		}
			else{//---si client est bloq�
				try {
					throw new ClientException(" client"+this+" bloqu�e Impossible d'effectu� l'appel !!");
				} catch (ClientException e) {
					// TODO Auto-generated catch block
					this.setBloqu�(true);
					return null;
				}}
		
	}//----fin methode ajouter appel

	public void bloqu�()
	{
		
	}
}
