


import java.util.Scanner;

public class PointDeVente {
	
	public PointDeVente(String nomAgence, Adresse adresse, Type typ, String numeroTelephone) throws TelephoneExceptions {
		
		this.nomAgence = nomAgence;
		this.adresse = adresse;
		this.typ = typ;
		if(!Client.verifieNumTelephone(numeroTelephone))throw new TelephoneExceptions("tel invalide");
		this.numeroTelephone = numeroTelephone;
	}
	public PointDeVente() {
		// TODO Auto-generated constructor stub
	}
	public void setPointDeVente(String nomAgence, Adresse adresse, Type typ, String numeroTelephone) {
		
		this.nomAgence = nomAgence;
		this.adresse = adresse;
		this.typ = typ;
		this.numeroTelephone = numeroTelephone;
	}
	private String nomAgence;
	
	private Adresse adresse;
	private Type typ;
	private String numeroTelephone;
	//---------------méthode saisit:
	public void saisir() {
		// TODO Auto-generated method stub
		Scanner sci = new Scanner(System.in);
		System.out.println("-----------point de vente ajout:------------");
		System.out.println("-----------nom de l'agence:------------");
		this.setNomAgence(sci.next());
		System.out.println("-----------Numéro de téléphone:------------");
		this.setNumeroTelephone(sci.next());
		System.out.println("-----------Adresse:------------");this.adresse.saisir();
		System.out.println("-----------type 'principale ou secondaire':------------");
		this.setTyp(Type.valueOf(sci.next().toUpperCase()));
		System.out.println("-----------ajout avec succés------------");
		
	}
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [nomAgence=" + nomAgence + ", adresse=" + adresse + ", typ=" + typ + ", numeroTelephone="
				+ numeroTelephone + "]";
	}





	//----------------gtter et setter
	/**
	 * @return the nomAgence
	 */
	
	public String getNomAgence() {
		return nomAgence;
	}
	/**
	 * @param nomAgence the nomAgence to set
	 */
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the numeroTelephone
	 */
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	/**
	 * @param numeroTelephone the numeroTelephone to set
	 */
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public Type getTyp() {
		return typ;
	}
	public void setTyp(Type typ) {
		this.typ = typ;
	}

    
}
