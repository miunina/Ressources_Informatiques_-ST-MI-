import java.util.Scanner;

public class AbonLibre extends Abonnement {
	private final double montantFixe=500;
	private final int TVA= 19;
	private  int duréeFixe;
	private  int duréePourBloqué;
	//private final int duréeffix;
	
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
    public AbonLibre (Date dateDebAbon, int durée, double soldeMontant ) throws DateException, NegativeException {
    	
    	super(dateDebAbon, durée, 0);
    	this.duréeFixe=durée;
    	this.duréePourBloqué=durée+durée;
    	
    	
    }
	//----------------------------------
	@Override
	public void Saisir() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("donnez la date du debut d'abonnement:");
		System.out.println("la durée de payement : 1 mois, ");
		
		System.out.println("combien de temps vous accordez au client avant de le bloqué ?");
		this.setDurée(s.nextInt());
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
		return "\n---------------------------------\n---Type Abonnement : Libre "+super.toString()+"---facture à payer le : "+verifierAtteinteDateFinAbon()+"\n---solde cumulée: "+this.getSoldeMontant()+"\n---------------------------------";
		
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
				System.out.println("  ----------Information sur Votre Abonnement (facture)--------\n Nom :"+C.getNom()+"\tprénom :"+C.getPrénom());
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
		
		
		return Date.dateApresnbMois(getDateDebAbon(), getDuréeFixe());
	}
	@Override
	public Date verifierAtteinteDateFBloqué() {
		// TODO Auto-generated method stub
		
		return Date.dateApresnbMois(getDateDebAbon(), getDuréePourBloqué());
	}
	/**
	 * @return the duréeFixe
	 */
	public int getDuréeFixe() {
		return duréeFixe;
	}
	public int getDuréePourBloqué()
	{
		return this.duréePourBloqué;
	}

	
	 
	@Override
	public Appel AjouterAppel(Client client, String s, Date D, Heure h, int durée) {
		// TODO Auto-generated method stub
		Appel A = null;
		if(this.verifierDate(D)==-1)//impossible d'ajouter
			{
			//si le retourn est null 
			//on envoie les trois sms entrant puis on va voir si on bloque ou non
			//'on decide de bloqué ou de payer; réajouter un nouvel abonnement(réinitialisé)
			
			
			try {
				throw new ClientException(" veuillez rechargé votre facture-Date expiré");
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				client.setAvantBloqué(true);
			}}
		else 
		{
			if(this.verifierDate(D)==0)
		    {
			
			System.out.println(" Date expire aujourd'hui (veuillez payer votre facture!!) ");
			//on peut pas ajouté mais on reçois
			
		    }//si il appel a une date == date fin:
		//le client devient bloqué =>
		//on lui lance 3 smsEntrant de l'opéateur
		//un cette date un autre après 3 jour un autre apres 15 jour
		//-------le client pendant cette durée ne peut que recevoir ---
		//----------------------------------------------------------
			                int unity=client.getUnity(s);
				        	long compteurSlode = durée * unity;
					        this.setSoldeMontant(this.getSoldeMontant()+compteurSlode);
					        this.setDurée(this.getDurée()+durée);
					        Status stat = Status.envoyé;
				        
				       
				  
				  
				  //si on a arrivé a effectuer l'appel sans coupure alors
				  //if()
					      // this.A.add(new Appel(this.getNumTelephone(), D, H," ",s,Status.fin_d_appel, this.getAbon().getDurée()));
		
					  A = new Appel( client.getNumTelephone(), D, h, " ddd ",s, stat, durée );
					  
					  
					  //appel ajoutée avec succés	  
			  }
		
		return A;
	}
	/**
	 * @param duréeFixe the duréeFixe to set
	 */
	public void setDuréeFixe(int duréeFixe) {
		this.duréeFixe = duréeFixe;
	}
	/**
	 * @param duréePourBloqué the duréePourBloqué to set
	 */
	public void setDuréePourBloqué(int duréePourBloqué) {
		this.duréePourBloqué = duréePourBloqué;
	}
	@Override
	public int AfficherChoixAbonnement() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Appel AjouterAppelReçu(Client client, String s, Date D, int durée) throws DateException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Appel AjouterAppelRecu(Client client, String s, Date D, Heure h, int durée) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
