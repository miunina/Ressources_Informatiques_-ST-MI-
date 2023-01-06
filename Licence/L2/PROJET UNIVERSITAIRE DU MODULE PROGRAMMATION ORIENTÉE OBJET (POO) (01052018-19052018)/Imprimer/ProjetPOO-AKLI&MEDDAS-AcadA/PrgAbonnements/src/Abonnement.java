
public abstract class Abonnement {

//***************************************
//************Ls attributs**:************
//***************************************
//date deb abon:
	protected Date dateDebAbon;
	//int durée max:
    protected int durée;//minute 
	//int PRIXmontant: forfait fixe (fixe):
	
    //int SOLDEmontant (solde):à consommé(cumulé / decrementer)
    protected double soldeMontant;

    
//***************************************
//**********Constructeur*****************
//***************************************
//sans paramètre  
public Abonnement() {
	
}
//avec paramètres
public Abonnement(Date dateDebAbon, int durée, double soldeMontant)throws DateException, NegativeException
{
	if(durée<0 || soldeMontant<0)
	{
		throw new NegativeException("nombre negative !!");
	}
	this.dateDebAbon = dateDebAbon;
	this.durée = durée;
	this.soldeMontant = soldeMontant;
}

//***************************************
//**********Méthodess pour saisir********
//***************************************

public abstract void Saisir();

//***************************************
//********Méthodess pour Afficher********
//***************************************
public void Afficher(){System.out.println(this);}
public String toString()
{
	return "\n---à partir du :"+dateDebAbon+"\n";
}


//***************************************
//*******Méthodess de verification*******
//***************************************
//----verification des date:
public int verifierDate(Date D)//si la date depasse la date debut d'abonnement retourne -1
{
	return this.verifierAtteinteDateFinAbon().compare(D);
	
}

public abstract Date verifierAtteinteDateFinAbon();
public abstract Date verifierAtteinteDateFBloqué();
public boolean isBloqué(Date d)
{
	if(this.verifierAtteinteDateFBloqué().compare(d)<=0)
	{
		return true;
	}
	return false;
}
/*{
	public abstract Date verifierAtteinteDateFBloqué();
	// TODO Auto-generated method stub
	
	return Date.dateApresnbMois(getDateDebAbon(), getDurée());
}//si la durée max est atteinte retourne faux*/

//----verification du solde:
public abstract boolean verifierSoldeRestant();//SI <=0 retourner faux sinn retourner vrai

//----verification si le client devient bloqué a une date donnée:
// revoi true si il est bloqué
// revoi false sinon


//***************************************
//**********Méthodess pour Ajouter*******
//***************************************
//ajouter appel entrant appel sortant---
//***************************************
//----voir si on peut crée l'appel en supposant que le client n'est pas bloqué
//- on met verifie dedant on verifie la date donnée
//le solde restant et on ajoute un nouvel appel 
//(sortant et entrant meme chose=> on donne le numéro de téléphone ainsi qu'on doit 
//vérifier si il est valide ou non- on ajoute les exceptions lorsque c'est néssessaire)


//***************************************
//*******Méthodess pour facture**********
//***************************************

//---calculer cumul:
public abstract double MontantAppel(Appel A);//supposant qe l'appel est ajoutée crée
//---calculer le tout:S
public abstract double facture(Client C);//elle est appelé dans une autre méthode , qu'on diot lui donnée 
//un numéro  => si il existe dans l'opérateur on fait sortir le client
//pour appelé cette methode
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
	 * @return the durée
	 */
	public int getDurée() {
		return durée;
	}

	/**
	 * @param durée the durée to set
	 */
	public void setDurée(int durée) {
		this.durée = durée;
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
		public abstract Appel AjouterAppel(Client client, String s, Date D,Heure h, int durée )throws SoldeException, DateException, SoldeInssuffisantException  ;
	
	
	
	public abstract Appel AjouterAppelReçu(Client client, String s, Date D, int durée ) throws  DateException ;
	public abstract Appel AjouterAppelRecu(Client client, String s, Date D,Heure h, int durée ) ;
	
	
	public abstract int AfficherChoixAbonnement();
	
}
