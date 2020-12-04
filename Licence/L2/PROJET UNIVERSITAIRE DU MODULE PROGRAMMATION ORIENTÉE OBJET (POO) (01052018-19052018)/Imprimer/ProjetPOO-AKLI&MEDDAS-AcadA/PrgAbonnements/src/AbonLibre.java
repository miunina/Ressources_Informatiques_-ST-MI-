import java.util.Scanner;

public class AbonLibre extends Abonnement {
	private final double montantFixe=500;
	private final int TVA= 19;
	private  int dur�eFixe;
	private  int dur�ePourBloqu�;
	//private final int dur�effix;
	
	public double getPourcentage(double j)
	{
		return (j*this.getTVA())/100;
	}
	//****************************************************************
	//***********************constructeur*****************************
	//****************************************************************
	 public AbonLibre () {
	    	
	    	super();
	    }
    public AbonLibre (Date dateDebAbon, int dur�e, double soldeMontant ) throws DateException, NegativeException {
    	
    	super(dateDebAbon, dur�e, 0);
    	this.dur�eFixe=dur�e;
    	this.dur�ePourBloqu�=dur�e+dur�e;
    	
    	
    }
	//----------------------------------
	@Override
	public void Saisir() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("donnez la date du debut d'abonnement:");
		System.out.println("la dur�e de payement : 1 mois, ");
		
		System.out.println("combien de temps vous accordez au client avant de le bloqu� ?");
		this.setDur�e(s.nextInt());
		this.setSoldeMontant(0);
		
		
	}
    //---------------------------------
	@Override
	public void Afficher() 
		// TODO Auto-generated method stub
	{super.Afficher();
			System.out.println(this);
		
	
	}
	public String toString()
	{
		return "\n---------------------------------\n---Type Abonnement : Libre "+super.toString()+"---facture � payer le : "+verifierAtteinteDateFinAbon()+"\n---solde cumul�e: "+this.getSoldeMontant()+"\n---------------------------------";
		
	}
    //---------------------------------
	
    //---------------------------------
	
    //---------------------------------
	@Override//
	public boolean verifierSoldeRestant() {
		// TODO Auto-generated method stub
		return false;
	}
    //---------------------------------
	public int getTVA() {
		return TVA;
	}
    //--------------------------------
	public double getMontantFixe() {
		return montantFixe;
	}
	//---------------------------------
	@Override
	public double facture(Client C) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("  ----------Information sur Votre Abonnement (facture)--------\n Nom :"+C.getNom()+"\tpr�nom :"+C.getPr�nom());
				System.out.println(" Adresse: "+C.getAdr()+"\tAdresse Mail: "+C.getMail());
				System.out.println(" "+this);
				System.out.println(" Liste des Appel :"+C.getA());
				
				
				
		return 0;
	}
	@Override
	public double MontantAppel(Appel A) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double cumulAppels(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Date verifierAtteinteDateFinAbon() {
		// TODO Auto-generated method stub
		
		
		return Date.dateApresnbMois(getDateDebAbon(), getDur�eFixe());
	}
	@Override
	public Date verifierAtteinteDateFBloqu�() {
		// TODO Auto-generated method stub
		
		return Date.dateApresnbMois(getDateDebAbon(), getDur�ePourBloqu�());
	}
	/**
	 * @return the dur�eFixe
	 */
	public int getDur�eFixe() {
		return dur�eFixe;
	}
	public int getDur�ePourBloqu�()
	{
		return this.dur�ePourBloqu�;
	}

	
	 
	@Override
	public Appel AjouterAppel(Client client, String s, Date D, Heure h, int dur�e) {
		// TODO Auto-generated method stub
		Appel A = null;
		if(this.verifierDate(D)==-1)//impossible d'ajouter
			{
			//si le retourn est null 
			//on envoie les trois sms entrant puis on va voir si on bloque ou non
			//'on decide de bloqu� ou de payer; r�ajouter un nouvel abonnement(r�initialis�)
			
			
			try {
				throw new ClientException(" veuillez recharg� votre facture-Date expir�");
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				client.setAvantBloqu�(true);
			}}
		else 
		{
			if(this.verifierDate(D)==0)
		    {
			
			System.out.println(" Date expire aujourd'hui (veuillez payer votre facture!!) ");
			//on peut pas ajout� mais on re�ois
			
		    }//si il appel a une date == date fin:
		//le client devient bloqu� =>
		//on lui lance 3 smsEntrant de l'op�ateur
		//un cette date un autre apr�s 3 jour un autre apres 15 jour
		//-------le client pendant cette dur�e ne peut que recevoir ---
		//----------------------------------------------------------
			                int unity=client.getUnity(s);
				        	long compteurSlode = dur�e * unity;
					        this.setSoldeMontant(this.getSoldeMontant()+compteurSlode);
					        this.setDur�e(this.getDur�e()+dur�e);
					        Status stat = Status.envoy�;
				        
				       
				  
				  
				  //si on a arriv� a effectuer l'appel sans coupure alors
				  //if()
					      // this.A.add(new Appel(this.getNumTelephone(), D, H," ",s,Status.fin_d_appel, this.getAbon().getDur�e()));
		
					  A = new Appel( client.getNumTelephone(), D, h, " ddd ",s, stat, dur�e );
					  
					  
					  //appel ajout�e avec succ�s	  
			  }
		
		return A;
	}
	/**
	 * @param dur�eFixe the dur�eFixe to set
	 */
	public void setDur�eFixe(int dur�eFixe) {
		this.dur�eFixe = dur�eFixe;
	}
	/**
	 * @param dur�ePourBloqu� the dur�ePourBloqu� to set
	 */
	public void setDur�ePourBloqu�(int dur�ePourBloqu�) {
		this.dur�ePourBloqu� = dur�ePourBloqu�;
	}
	@Override
	public int AfficherChoixAbonnement() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Appel AjouterAppelRe�u(Client client, String s, Date D, int dur�e) throws DateException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Appel AjouterAppelRecu(Client client, String s, Date D, Heure h, int dur�e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
