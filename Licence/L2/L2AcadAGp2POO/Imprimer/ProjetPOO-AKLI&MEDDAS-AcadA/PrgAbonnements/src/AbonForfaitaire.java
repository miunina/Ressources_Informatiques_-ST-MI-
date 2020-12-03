import java.util.Scanner;

public class AbonForfaitaire extends Abonnement {
	private int dur�eFixe;
	private  int dur�eFixeBloqu�;
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

	public AbonForfaitaire(Date dateDebAbon, int dur�e, double soldeMontant ) throws DateException, NegativeException {
		super(dateDebAbon, dur�e,soldeMontant );
		this.dur�eFixe = dur�e;
		this.dur�eFixeBloqu�=dur�e+dur�e;SoldeFixe = soldeMontant;
	}


	
	
	/**
	 * @return the dur�eFixe
	 */
	public int getDur�eFixe() {
		return dur�eFixe;
	}

	public int getDur�eFixeBloqu�() {
		return dur�eFixeBloqu�;
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

		return "\n---------------------------------\n---Type Abonnement : Forfaitaire "+super.toString()+"---fin du d�lais : "+verifierAtteinteDateFinAbon()+"\n---solde restant : "+this.getSoldeMontant()+"\n---------------------------------\n";
		
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
		System.out.println("  ----------Information sur Votre Abonnement (facture)--------\n Nom :"+C.getNom()+"\tpr�nom :"+C.getPr�nom());
		System.out.println(" num�ro de t�l�phone : "+C.getNumTelephone());
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
		return Date.dateApresnbMois(getDateDebAbon(), getDur�eFixe());

	}



	
	@Override
	public Date verifierAtteinteDateFBloqu�() {
		// TODO Auto-generated method stub
		return Date.dateApresnbMois(this.getDateDebAbon(), this.getDur�eFixeBloqu�());
	}

	@Override
	public Appel AjouterAppel(Client client, String s, Date D, Heure hd, int dur�e) throws SoldeException, SoldeInssuffisantException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Appel A = null;
			
			
			
			
			
			if(this.verifierDate(D)==-1)//impossible d'ajouter date non valide (elle ne doit pas venir apr�s la date fin d'abonnement)
				{
				//ici le client ne peut que recevoir  mais il n'est pas bloqu�
				//on v�rifie :
				//on appel une methode:
				//ccete methode va envoy� trois sms � ce client puis le bloque
				client.setBloqu�(true);	
				return null;}
			
			//le client devient bloqu� si on est arriv� 
			
				if(this.verifierDate(D)==0)
			    {System.out.println(" \n--------------------------------------------------------------");
				System.out.println(" \n"+client);
				System.out.println(" Date expire aujourd'hui (veuillez recharger votre paiement(type forfaitaire)!!) ");
				//throw new SoldeException("vous devez charg� votre paiement(type forfaitaire)");
			    }//si il appel a une date == date fin:
			//le client devient bloqu� =>
			//on lui lance 3 smsEntrant de l'op�ateur
			//un cette date un autre apr�s 3 jour un autre apres 15 jour
			//-------le client pendant cette dur�e ne peut que recevoir ---
			//----------------------------------------------------------
				
			      Status stat=null;//si il reste seulement une uni�e
				  if((this.getSoldeMontant()<20 && client.getUnity(s)==20)||(this.getSoldeMontant()<5 && client.getUnity(s)==5)||(this.getSoldeMontant()<4 && client.getUnity(s)==4))
				  {
						throw new SoldeException(" ");
					
					  //impossible d'effectu� l'appel=> solde inssuffisant
					  
				  }
				  else
				  {   int h = 0;
				      int unity = client.getUnity(s);
				      long compteurSlode = 0;
				      compteurSlode = (long) (this.getSoldeMontant());
					   this.setSoldeMontant(getSoldeMontant()-(unity*dur�e));
					   stat=Status.fin_d_appel;
					  if(soldeMontant <=0 )
						  {
						  dur�e = this.dur�e;
						   throw new SoldeInssuffisantException("\nappel coup� apr�s "+dur�e+" dur�e :");
						  }//diminuer la dur�e de l'appel (sera coup�_car la dur�e de l'appel
					  //voulu est plus grande
					  
					  else 
					  {
					        if(dur�e*unity < this.getSoldeMontant())
					        {
					        	 compteurSlode = dur�e * unity;
						          this.setSoldeMontant(this.getSoldeMontant());
						          stat = Status.envoy�;
					        }
					       
					  }
					 //dans tout les cas on a cr�e un appel
			//this.A.add(new Appel(this.getNumTelephone(), D, H," ",s,Status.fin_d_appel, this.getAbon().getDur�e()));
						  A = new Appel( client.getNumTelephone(), D, hd," ddd ",s,stat,dur�e );
						  
						  //appel ajout�e avec succ�s	  
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
