import java.util.ArrayList;
import java.util.Scanner;

public class AbonPrepayer extends Abonnement {
	private ArrayList<CarteRecharge> cartRecharge = new ArrayList<CarteRecharge>();
public  class CarteRecharge{
	/*num�ro de s�rie (String sur 14 chiffres), une dat
	 * e de validit�, un montant et un �tat (activ� ou non). 
	 * Lorsqu�un client recharge son compte, on enregistre le num�ro de la
	 *  carte pay�e et la date de son activation et on change son �tat. 
	 *  Le client peut charger
	 *  plusieurs cartes et le montant
	 *  
	 *   du solde est alors cumul� (additionn�). On peut consulter
	 *   le solde restant et la date limite de validit� de la recharge 
	 *   (par exemple 3 mois). Quand le montant de la recharge est �puis�,
	 *    le client ne peut que recevoir
	 *   */
	int Dur�e;//en mois
	public CarteRecharge()
	{numSerie=String.valueOf(Integer.getInteger(numSerie)+1);
	
		
	}
	public CarteRecharge( int dur�e)
	{
		numSerie=String.valueOf(Integer.getInteger(numSerie)+1);
				Dur�e = dur�e;
	}
	public void Saisir()
	{boolean  b =true;;int i=0;
		Scanner s = new Scanner(System.in);
		System.out.println(" donnez la dur�e ed validit�e : ");Dur�e = s.nextInt();
		do{
			System.out.println("donnez num�ro de s�rie :");numSerie = s.next();
			if(numSerie.length()==14)
			{
				for(i=0;i<numSerie.length(); i++)
				{
					if(!Character.isDefined(numSerie.charAt(i)))b=false;break;
				}
			}else b= false;
		}while(b==false);
	}
	
	
	private String numSerie;
	

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	
	
}//fin classe carte recharge
public static boolean verifierNumSerie(String numS�rie)
{int i;
	if(numS�rie.length()==14)
	{
		for(i=0;i<numS�rie.length(); i++)
		{
			if(!Character.isDefined(numS�rie.charAt(i)))return false;
		}
	}else return false;	
	return true;
}
	@Override
	public void Saisir() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("  ");
		int choix = this.AfficherChoixAbonnement();
		switch(choix)
		{
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
			
		}
	}

	@Override
	public Date verifierAtteinteDateFinAbon() {
		// TODO Auto-generated method stub
		return null;
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
		System.out.println(" Adresse: "+C.getAdr()+"\tAdresse Mail: "+C.getMail());
		System.out.println(" "+this);
		System.out.println(" Liste des Appel :"+C.getA());
		
		
		return 0;
	}

	@Override
	public double cumulAppels(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}





	@Override
	public Date verifierAtteinteDateFBloqu�() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appel AjouterAppel(Client client, String s, Date D, Heure hd, int dur�e) {
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
		else 
		{
			if(this.verifierDate(D)==0)
		    {
			
			System.out.println(" Date expire aujourd'hui (veuillez recharger votre paiement!!) ");
			
		    }//si il appel a une date == date fin:
		//le client devient bloqu� =>
		//on lui lance 3 smsEntrant de l'op�ateur
		//un cette date un autre apr�s 3 jour un autre apres 15 jour
		//-------le client pendant cette dur�e ne peut que recevoir ---
		//----------------------------------------------------------
			
		      Status stat=null;//si il reste seulement une uni�e
			  if((this.getSoldeMontant()<20 && client.getUnity(s)==20)||(this.getSoldeMontant()<5 && client.getUnity(s)==5)||(this.getSoldeMontant()<4 && client.getUnity(s)==4))
			  {
				   try {
					throw new SoldeException(" solde insuffisant !!");
				} catch (SoldeException e) {
					// TODO Auto-generated catch block
					
					return new Appel(null,null,null,null,Status.echec);
				}
				  //impossible d'effectu� l'appel=> solde inssuffisant
				  
			  }
			  else
			  {   int h = 0;
			      int unity = client.getUnity(s);
			      long compteurSlode = 0;
			      compteurSlode = (long) (this.getSoldeMontant());
				   this.setSoldeMontant(0);
				   stat=Status.fin_d_appel;
				  if(dur�e < this.dur�e)
					  {dur�e = this.dur�e;
					   
					  }//diminuer la dur�e de l'appel (sera coup�_car la dur�e de l'appel
				  //voulu est plus grande
				  
				  else 
				  {
				        if(dur�e*unity < this.getSoldeMontant())
				        {
				        	 compteurSlode = dur�e * unity;
					          this.setSoldeMontant(this.getSoldeMontant()-compteurSlode);
					          stat = Status.envoy�;
				        }
				       
				  }
				 //dans tout les cas on a cr�e un appel
		
					  A = new Appel( s, D, hd," ddd ",stat );
					  
					  //appel ajout�e avec succ�s	  
			  }
		}
		return A;
	}

	public int AfficherChoixAbonnement() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int choix;
		System.out.print(" \n choisisser :");
		System.out.println(" 1 - 100 da");
		System.out.println(" 2 - pour 500 da");
		System.out.println(" 3 - pour 1000 da");
		System.out.println(" 4 - pour 2000 da");
		choix=s.nextInt();
		while(choix <1 && choix > 4)
		{
			System.out.print(" \n choisisser :");
			System.out.println(" 1 - 100 da");
			System.out.println(" 2 - pour 500 da");
			System.out.println(" 3 - pour 1000 da");
			System.out.println(" 4 - pour 2000 da");
			choix=s.nextInt();
		
		}
	return choix;
	}



	@Override
	public Appel AjouterAppelRecu(Client client, String s, Date D, Heure hd, int dur�e) {
	return null;
	}
	public ArrayList<CarteRecharge> getCartRecharge() {
		return cartRecharge;
	}
	public void setCartRecharge(ArrayList<CarteRecharge> cartRecharge) {
		this.cartRecharge = cartRecharge;
	}
	@Override
	public Appel AjouterAppelRe�u(Client client, String s, Date D, int dur�e) throws DateException {
		// TODO Auto-generated method stub
		return null;
	}

}
