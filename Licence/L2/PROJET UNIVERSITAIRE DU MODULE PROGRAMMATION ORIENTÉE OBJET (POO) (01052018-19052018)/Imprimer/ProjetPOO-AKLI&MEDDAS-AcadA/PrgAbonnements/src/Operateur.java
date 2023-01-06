
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;




public class Operateur 
{
//------------------Attributs:
private String nom;
//ensemble de point de vente:
private ArrayList <PointDeVente> ptrVente=new ArrayList <PointDeVente>();
//pourcentage de couverture par wilaya
private long pourcentage[] = new long[49];
//ensembles de clients abonnées:
private ArrayList <Client> Abonnées=new ArrayList <Client>();
//--------------------------------------------------------------------------
public Operateur(String nom, ArrayList<PointDeVente> ptrVente, ArrayList<Client> abonnées) {

	this.nom = nom;
	this.ptrVente = ptrVente;
	Abonnées = abonnées;
	//attribuer par defaut les pourcetage
	for(int i=0;i<48;i++)
	{
		pourcentage[i+1]=( i+1)*2;
	}
	
}//--------------------------------------------------------------------------
public Operateur(String nom) {

	this.nom = nom;

	
}
//--------------------Modifier poucentage wilaya
public void pourcentageModifier(int n,long pr)
{
	this.pourcentage[n]=pr;
}
public void AfficherWilayaPourcentage()
{
	int i=1;
	for(WilayaDz W : WilayaDz.values())
	{
		System.out.println(W.name()+" , pourcentage :"+this.pourcentage[i]+"%");
		i=i+1;
	}
}
//--------------------Affichage client non bloqué
public void AfficherClientNonBlqué()
{System.out.println("\n-----------\nClients non bloqué:----------------:");
 for(Client A: Abonnées)
 {
	if(!A.isBloqué())System.out.println(A);
 }
}
@Override
public String toString() {
	return "Operateur [nom=" + nom + ", ptrVente=" + ptrVente + ", pourcentage=" + Arrays.toString(pourcentage)
			+ ", Abonnées=" + Abonnées + ", setWilaya=" + setWilaya + ", setAbon=" + setAbon + "]";
}

//--------------------Affichage clients bloqué
public void AfficherClientBloqué()
{System.out.println("\n-----------\n client bloqué :----------------:");
	 for(Client A: Abonnées)
	 {
		 if(A.isBloqué())System.out.println(A);

	 }
}
//---------------Afficher les facture : 
public void AfficherFactureClient()
{
	for(Client Abn : Abonnées)
	{
		System.out.println();
	}
}
//---------------Afficher client par wilaya
public void AfficherClientParWilaya()
{System.out.println("\n-----------\n client par wilaya :----------------:");
for(Client Abn : Abonnées)
{
	this.setWilaya.add(Abn);
}
System.out.println(setWilaya);
}
Set<Client> setWilaya = new TreeSet<Client>(new Comparator<Client>() 
{
   
    @Override
	public int compare(Client one, Client other) {
		// TODO Auto-generated method stub
		if( one.getAdr().getWilaya().getX()== other.getAdr().getWilaya().getX())return one.getNumTelephone().compareTo(other.getNumTelephone());
    	if(one.getAdr().getWilaya().getX()<other.getAdr().getWilaya().getX())return -1;
    	
    	return 1;
	}
});
//---------------Afficher client par type d abon
public void AfficherClientParTypeAbonnement()
{System.out.println("\n-----------\n client par Type D'abonnement :----------------:");
for(Client Abn : Abonnées)
{
	this.setAbon.add(Abn);
	
	
}
System.out.println(setAbon);
}
Set<Client> setAbon = new TreeSet<Client>(new Comparator<Client>() 
{
 
  @Override
	public int compare(Client one, Client other) {
		// TODO Auto-generated method stub
		if((one.getAbon() instanceof AbonLibre &&other.getAbon() instanceof AbonLibre ) || (one.getAbon() instanceof AbonForfaitaire &&other.getAbon() instanceof AbonForfaitaire ) || (one.getAbon() instanceof AbonPrepayer &&other.getAbon() instanceof AbonPrepayer ))
		{
			return one.getNumTelephone().compareTo(other.getNumTelephone());
		}
		if(one.getAbon() instanceof AbonLibre)
		{
			return -1;
              
		}
		if(one.getAbon() instanceof AbonPrepayer)
		{
			return 1;
		}
		if(one.getAbon() instanceof AbonForfaitaire)
		{
			if(other.getAbon() instanceof AbonLibre)return 1;
			
		}
		return -1;
		
	}
});
	 
//
public void AfficherPointDeVente()
{System.out.println("\n-----------\n points de ventes ----------------:");
	 for(PointDeVente A: ptrVente)
	 {
		System.out.println(A);
	 }System.out.println("\n---------------------------- ----------------:");
}
//--------------------REMPLISSAGE CLIENT: 
public void RemplissageClients()
{/*System.out.println("\najouter des clients : ");
Client c = new Client();
	do{c.saisir();this.Abonnées.add(c);
	}while(tester.Continuer("\nVoulez - vous ajouter encore un abonnée o/n?")==true);
*/}
//-------------------REMPLISSAGE POINT DE VENTE:
public void RemplissagePointDeVente()
{System.out.println("\najouter des clients : ");
PointDeVente e = new PointDeVente();
	do{e.saisir();this.ptrVente.add(e);
	}while(Tester.Continuer("\nVoulez - vous ajouter encore un autre point de vente o/n?")==true);
}
//--------------------------------------------------------------------------
//--------------------Méthodes:
//-------echercher un numero donné\tobj
public Client RecherchernNumeroDonnéeClient(String s)
{
	for(Client c:Abonnées)
	{
		if(c.getNumTelephone().equals(s))return c;
	}
	return null;
}
//=======================point de vente
//-------rechercher un numero donné\tobj
public PointDeVente RecherchernNumeroDonnésPointDeVente(String s)
{
	for(PointDeVente v: this.ptrVente)
	{	if(v.getNumeroTelephone().equals(s))return v;
	}
	return null;
}

//--------------------retourne l indice du numéro du client\tab get i
public int  getMemeNuméroEmplacementPtrVente(String num)
{
	for(int i=0; i< this.ptrVente.size();i++)
	{
		if(this.ptrVente.get(i).getNumeroTelephone().equals(num))return i;
	}
	return -1;
}
//--------------------retourne l indice du numéro du client\tab get i
public int  getMemeNuméroEmplacement(String num)
{
	for(int i=0; i< this.Abonnées.size();i++)
	{
		if(this.Abonnées.get(i).getNumTelephone().equals(num))return i;
	}
	return -1;
}

//-----------------------getters et setters--------------------------------:
/**
 * @return the abonnées
 */
public ArrayList<Client> getAbonnées() {
	return Abonnées;
}
/**
 * @param abonnées the abonnées to set
 */
public void setAbonnées(ArrayList<Client> abonnées) {
	Abonnées = abonnées;
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public ArrayList <PointDeVente> getPtrVente() {
	return ptrVente;
}
public void setPtrVente(ArrayList <PointDeVente> ptrVente) {
	this.ptrVente = ptrVente;
}
//cette methode permet de modifier un point de vente
public void setPointdeVenteElt(PointDeVente pAncien, PointDeVente pNouveau)
{
	for(int i=0; i< ptrVente.size(); i++)
	{
		if(ptrVente.get(i).equals(pAncien))this.ptrVente.set(i, pNouveau);
	}
}
public void setClientElt(Client pAncien, Client pNouveau)
{
	for(int i=0; i< this.Abonnées.size(); i++)
	{
		if(Abonnées.get(i).equals(pAncien))this.Abonnées.set(i, pNouveau);
	}
}
//----------supprimer un nmero
public void SupprimerClient(Client c)
{
	this.Abonnées.remove(c);
	
}
//=====ajouter point de vente:
public void AjouterPtrVente(PointDeVente p)
{
	this.ptrVente.add(p);
}
//=====supprimer un point de vente:
public void SupprimerPtrVente(PointDeVente p)
{
	this.ptrVente.remove(p);
}
//----------------------------------------------avoir la date debut 
public  Date DateDebutAbonnementApartirNumo(String num) {
	// TODO Auto-generated method stub
	for(int i=0; i< this.Abonnées.size();i++)
	{
		if(this.Abonnées.get(i).getNumTelephone().equals(num))return this.Abonnées.get(i).getDateOper();
	}
	return null;
}
public long[] getPourcentage() {
	return pourcentage;
}
public void setPourcentage(long[] pourcentage) {
	this.pourcentage = pourcentage;
}

}
