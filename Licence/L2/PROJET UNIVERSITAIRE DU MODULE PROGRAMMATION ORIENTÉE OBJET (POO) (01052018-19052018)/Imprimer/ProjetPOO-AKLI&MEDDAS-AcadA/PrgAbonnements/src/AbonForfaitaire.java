import java.util.Scanner;

public class AbonForfaitaire extends Abonnement {
	private int duréeFixe;
	private  int duréeFixeBloqué;
	private Double SoldeFixe;

	public AbonForfaitaire() {
		super();
		
	}

	/**
	 * @return the soldeFixe
	 */
	public Double getSoldeFixe() {
		return SoldeFixe;
	}

	/**
	 * @param soldeFixe the soldeFixe to set
	 */
	public void setSoldeFixe(Double soldeFixe) {
		SoldeFixe = soldeFixe;
	}

	public AbonForfaitaire(Date dateDebAbon, int durée, double soldeMontant ) throws DateException, NegativeException {
		super(dateDebAbon, durée,soldeMontant );
		this.duréeFixe = durée;
		this.duréeFixeBloqué=durée+durée;SoldeFixe = soldeMontant;
	}


	
	
	/**
	 * @return the duréeFixe
	 */
	public int getDuréeFixe() {
		return duréeFixe;
	}

	public int getDuréeFixeBloqué() {
		return duréeFixeBloqué;
	}

	

	@Override
	public void Saisir() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void Afficher() {
		// TODO Auto-generated method stub
		
			System.out.println(this);
		
	}

	public String toString()
	{

		return "\n---------------------------------\n---Type Abonnement : Forfaitaire "+super.toString()+"---fin du délais : "+verifierAtteinteDateFinAbon()+"\n---solde restant : "+this.getSoldeMontant()+"\n---------------------------------\n";
		
	}
	

	@Override
	public boolean verifierSoldeRestant() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public double MontantAppel(Appel A) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double facture(Client C) {
		// TODO Auto-generated method stub
		System.out.println("  ----------Information sur Votre Abonnement (facture)--------\n Nom :"+C.getNom()+"\tprénom :"+C.getPrénom());
		System.out.println(" numéro de téléphone : "+C.getNumTelephone());
		System.out.println(" Adresse: "+C.getAdr()+"\tAdresse Mail: "+C.getMail());
		
		System.out.println(" "+this);
		System.out.println(" Liste des Appel :"+C.getA());
		System.out.println(" Type de rechargement : "+this.getSoldeFixe());
		
		
		
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
		return Date.dateApresnbMois(this.getDateDebAbon(), this.getDuréeFixeBloqué());
	}

	@Override
	public Appel AjouterAppel(Client client, String s, Date D, Heure hd, int durée) throws SoldeException, SoldeInssuffisantException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Appel A = null;
			
			
			
			
			
			if(this.verifierDate(D)==-1)//impossible d'ajouter date non valide (elle ne doit pas venir après la date fin d'abonnement)
				{
				//ici le client ne peut que recevoir  mais il n'est pas bloqué
				//on vérifie :
				//on appel une methode:
				//ccete methode va envoyé trois sms à ce client puis le bloque
				client.setBloqué(true);	
				return null;}
			
			//le client devient bloqué si on est arrivé 
			
				if(this.verifierDate(D)==0)
			    {System.out.println(" \n--------------------------------------------------------------");
				System.out.println(" \n"+client);
				System.out.println(" Date expire aujourd'hui (veuillez recharger votre paiement(type forfaitaire)!!) ");
				//throw new SoldeException("vous devez chargé votre paiement(type forfaitaire)");
			    }//si il appel a une date == date fin:
			//le client devient bloqué =>
			//on lui lance 3 smsEntrant de l'opéateur
			//un cette date un autre après 3 jour un autre apres 15 jour
			//-------le client pendant cette durée ne peut que recevoir ---
			//----------------------------------------------------------
				
			      Status stat=null;//si il reste seulement une uniée
				  if((this.getSoldeMontant()<20 && client.getUnity(s)==20)||(this.getSoldeMontant()<5 && client.getUnity(s)==5)||(this.getSoldeMontant()<4 && client.getUnity(s)==4))
				  {
						throw new SoldeException(" ");
					
					  //impossible d'effectué l'appel=> solde inssuffisant
					  
				  }
				  else
				  {   int h = 0;
				      int unity = client.getUnity(s);
				      long compteurSlode = 0;
				      compteurSlode = (long) (this.getSoldeMontant());
					   this.setSoldeMontant(getSoldeMontant()-(unity*durée));
					   stat=Status.fin_d_appel;
					  if(soldeMontant <=0 )
						  {
						  durée = this.durée;
						   throw new SoldeInssuffisantException("\nappel coupé après "+durée+" durée :");
						  }//diminuer la durée de l'appel (sera coupé_car la durée de l'appel
					  //voulu est plus grande
					  
					  else 
					  {
					        if(durée*unity < this.getSoldeMontant())
					        {
					        	 compteurSlode = durée * unity;
						          this.setSoldeMontant(this.getSoldeMontant());
						          stat = Status.envoyé;
					        }
					       
					  }
					 //dans tout les cas on a crée un appel
			//this.A.add(new Appel(this.getNumTelephone(), D, H," ",s,Status.fin_d_appel, this.getAbon().getDurée()));
						  A = new Appel( client.getNumTelephone(), D, hd," ddd ",s,stat,durée );
						  
						  //appel ajoutée avec succés	  
				  }
			
			return A;
	}

	@Override
	public int AfficherChoixAbonnement() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int choix;
		 System.out.println("vueillezs choisir votre forfait :");
		 System.out.println("1:un mois = 1000DA	 ");
		 System.out.println("2:deux mois = 17500Da ");
		 choix = s.nextInt();
		 while(choix < 1 && choix > 2)
		 {
			 System.out.println("vueillezs choisir votre forfait :");
			 System.out.println("1:un mois = 1000DA	 ");
			 System.out.println("2:deux mois = 17500Da ");
			 choix = s.nextInt();
			
			 
		 }
		 return choix;
		
		
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
