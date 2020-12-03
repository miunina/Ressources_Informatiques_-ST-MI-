
public abstract class Abonnement {

//***************************************
//************Ls attributs**:************
//***************************************
//date deb abon:
	protected Date dateDebAbon;
	//int dur�e max:
    protected int dur�e;//minute 
	//int PRIXmontant: forfait fixe (fixe):
	
    //int SOLDEmontant (solde):� consomm�(cumul� / decrementer)
    protected double soldeMontant;

    
//***************************************
//**********Constructeur*****************
//***************************************
//sans param�tre  
public Abonnement() {
	
}
//avec param�tres
public Abonnement(Date dateDebAbon, int dur�e, double soldeMontant)throws DateException, NegativeException
{
	if(dur�e<0 || soldeMontant<0)
	{
		throw new NegativeException("nombre negative !!");
	}
	this.dateDebAbon = dateDebAbon;
	this.dur�e = dur�e;
	this.soldeMontant = soldeMontant;
}

//***************************************
//**********M�thodess pour saisir********
//***************************************

public abstract void Saisir();

//***************************************
//********M�thodess pour Afficher********
//***************************************
public void Afficher(){System.out.println(this);}
public String toString()
{
	return "\n---� partir du :"+dateDebAbon+"\n";
}


//***************************************
//*******M�thodess de verification*******
//***************************************
//----verification des date:
public int verifierDate(Date D)//si la date depasse la date debut d'abonnement retourne -1
{
	return this.verifierAtteinteDateFinAbon().compare(D);
	
}

public abstract Date verifierAtteinteDateFinAbon();
public abstract Date verifierAtteinteDateFBloqu�();
public boolean isBloqu�(Date d)
{
	if(this.verifierAtteinteDateFBloqu�().compare(d)<=0)
	{
		return true;
	}
	return false;
}
/*{
	public abstract Date verifierAtteinteDateFBloqu�();
	// TODO Auto-generated method stub
	
	return Date.dateApresnbMois(getDateDebAbon(), getDur�e());
}//si la dur�e max est atteinte retourne faux*/

//----verification du solde:
public abstract boolean verifierSoldeRestant();//SI <=0 retourner faux sinn retourner vrai

//----verification si le client devient bloqu� a une date donn�e:
// revoi true si il est bloqu�
// revoi false sinon


//***************************************
//**********M�thodess pour Ajouter*******
//***************************************
//ajouter appel entrant appel sortant---
//***************************************
//----voir si on peut cr�e l'appel en supposant que le client n'est pas bloqu�
//- on met verifie dedant on verifie la date donn�e
//le solde restant et on ajoute un nouvel appel 
//(sortant et entrant meme chose=> on donne le num�ro de t�l�phone ainsi qu'on doit 
//v�rifier si il est valide ou non- on ajoute les exceptions lorsque c'est n�ssessaire)


//***************************************
//*******M�thodess pour facture**********
//***************************************

//---calculer cumul:
public abstract double MontantAppel(Appel A);//supposant qe l'appel est ajout�e cr�e
//---calculer le tout:S
public abstract double facture(Client C);//elle est appel� dans une autre m�thode , qu'on diot lui donn�e 
//un num�ro  => si il existe dans l'op�rateur on fait sortir le client
//pour appel� cette methode
public abstract double cumulAppels(Client c);
//***************************************
//**********setter et getter:************
//***************************************
    
	/**
	 * @return the dateDebAbon
	 */
	public Date getDateDebAbon() {
		return dateDebAbon;
	}

	/**
	 * @param dateDebAbon the dateDebAbon to set
	 */
	public void setDateDebAbon(Date dateDebAbon) {
		this.dateDebAbon = dateDebAbon;
	}

	/**
	 * @return the dur�e
	 */
	public int getDur�e() {
		return dur�e;
	}

	/**
	 * @param dur�e the dur�e to set
	 */
	public void setDur�e(int dur�e) {
		this.dur�e = dur�e;
	}

	/**
	 * @return the soldeMontant
	 */
	public double getSoldeMontant() {
		return soldeMontant;
	}

	/**
	 * @param soldeMontant the soldeMontant to set
	 */
	public void setSoldeMontant(double soldeMontant) {
		this.soldeMontant = soldeMontant;
	}
		public abstract Appel AjouterAppel(Client client, String s, Date D,Heure h, int dur�e )throws SoldeException, DateException, SoldeInssuffisantException  ;
	
	
	
	public abstract Appel AjouterAppelRe�u(Client client, String s, Date D, int dur�e ) throws  DateException ;
	public abstract Appel AjouterAppelRecu(Client client, String s, Date D,Heure h, int dur�e ) ;
	
	
	public abstract int AfficherChoixAbonnement();
	
}
