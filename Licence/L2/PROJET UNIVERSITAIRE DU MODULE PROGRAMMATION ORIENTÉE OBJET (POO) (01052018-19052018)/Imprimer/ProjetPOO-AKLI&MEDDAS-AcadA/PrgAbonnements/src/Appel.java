
public class Appel {//entrant
private String num;
private Date dateEvoie;
private Heure heureEnvoie;
private String Text;
private String NumDest;
private Status Stat;
private int durée;
public Appel(String num,String numDestination, Date dateEvoie, Heure heureEnvoie, String text, Status stat) {
	
	this.num = num;
	this.dateEvoie = dateEvoie;
	this.heureEnvoie = heureEnvoie;
	Text = text;
	Stat = stat;
	NumDest=numDestination;
}
public Appel(String num, Date dateEvoie, Heure heureEnvoie, String text, Status stat) {
	
	this.num = num;
	this.dateEvoie = dateEvoie;
	this.heureEnvoie = heureEnvoie;
	Text = text;
	Stat = stat;

}
public Appel(String num, Date dateEvoie, Heure heureEnvoie, String text, String numDest, Status stat, int durée) {
	
	this.num = num;
	this.dateEvoie = dateEvoie;
	this.heureEnvoie = heureEnvoie;
	Text = text;
	NumDest = numDest;
	Stat = stat;
	this.durée = durée;
}
/**
 * @return the num
 */
public String getNum() {
	return num;
}
/**
 * @param num the num to set
 */
public void setNum(String num) {
	this.num = num;
}
/**
 * @return the dateEvoie
 */
public Date getDateEvoie() {
	return dateEvoie;
}
/**
 * @param dateEvoie the dateEvoie to set
 */
public void setDateEvoie(Date dateEvoie) {
	this.dateEvoie = dateEvoie;
}
/**
 * @return the heureEnvoie
 */
public Heure getHeureEnvoie() {
	return heureEnvoie;
}
/**
 * @param heureEnvoie the heureEnvoie to set
 */
public void setHeureEnvoie(Heure heureEnvoie) {
	this.heureEnvoie = heureEnvoie;
}
/**
 * @return the text
 */
public String getText() {
	return Text;
}
/**
 * @param text the text to set
 */
public void setText(String text) {
	Text = text;
}
/**
 * @return the stat
 */
public Status getStat() {
	return Stat;
}
/**
 * @param stat the stat to set
 */
public void setStat(Status stat) {
	Stat = stat;
}
public String getNumDest() {
	return NumDest;
}
public void setNumDest(String numDest) {
	NumDest = numDest;
}
public Appel() {
	
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Appel [num=" + num + ", dateEvoie=" + dateEvoie + ", heureEnvoie=" + heureEnvoie + ", Text=" + Text
			+ ", NumDest=" + NumDest + ", Stat=" + Stat + ", durée=" + durée + "]";
}
//-----Afficher  :
public void Afficher()
{
	System.out.println(this);
}
public int getDurée() {
	return durée;
}
public void setDurée(int durée) {
	this.durée = durée;
}
}
