

import java.util.Scanner;



public class Adresse {
private String	nomRue;
private int codeRue;
private WilayaDz wilaya;
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() 
{
	return  nomRue+","+codeRue+","+wilaya.ordinal();
}
public Adresse()
{
	
}
public Adresse(String nomRue, int codeRue, WilayaDz wilaya) {
	
	this.nomRue = nomRue;
	this.codeRue = codeRue;
	this.wilaya = wilaya;
}
public boolean verifier()
{
	if(codeRue < 0)return false;
	if(nomRue==null)return false;
	return true;
}
public void Afficher()
{
	System.out.println("nom rue:  "+nomRue+", Code Rue:  "+codeRue+", Wilaya:  "+this.getWilaya().name());
}
public static Adresse Parse(String string)
{
	String[] result = new String[3];
	result = string.split(",");
	Adresse a = null;
	try {
		a= new Adresse(result[0], Integer.valueOf(result[1]),WilayaDz.getWilayaDZ(Integer.valueOf(result[2])+1));
		if(!a.verifier())throw new AdresseException("Adresse non valid !!");
	} catch (NumberFormatException | AdresseException e ) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		a= new Adresse();
	}
	catch(Exception c)
	{
		System.err.println("wilaya invalid !!!");
		a= new Adresse();
	}
	return a;
}
//---------------------saisir : 
public void saisir() {
	// TODO Auto-generated method stub
	boolean b =true;
	Scanner sce = new Scanner(System.in);
	//---------num wilaya:***************
	System.out.println("\n numéro de la Wilaya: ");
	do{b=true;try {
		this.setWilaya((sce.nextInt()));
	} catch (AdresseException e) {
		// TODO Auto-generated catch block
		b=false;
	}}while(b==false);
	//----- --code de rue :*************
	System.out.println("\n code de la rue: ");
	this.setCodeRue(sce.nextInt());
	//--------nom rue*******************
System.out.println("\n nom de rue: ");
this.setNomRue(sce.next());
}
//----------getter et stter---------------
public void setWilaya(int n) throws AdresseException
{this.setWilaya(WilayaDz.getWilayaString(n));
	//this.Mois = mois.valueOf(arg0)n;
}
//
/**
 * @return the nomRue
 */
public String getNomRue() {
	return nomRue;
}
/**
 * @param nomRue the nomRue to set
 */
public void setNomRue(String nomRue) {
	this.nomRue = nomRue;
}
/**
 * @return the codeRue
 */
public int getCodeRue() {
	return codeRue;
}
/**
 * @param codeRue the codeRue to set
 */
public void setCodeRue(int codeRue) {
	this.codeRue = codeRue;
}
/**
 * @return the wilaya
 */
public WilayaDz getWilaya() {
	return wilaya;
}
/**
 * @param wilaya the wilaya to set
 */
public void setWilaya(WilayaDz wilaya) {
	this.wilaya = wilaya;
}
//--------------fin setter et getter
}
