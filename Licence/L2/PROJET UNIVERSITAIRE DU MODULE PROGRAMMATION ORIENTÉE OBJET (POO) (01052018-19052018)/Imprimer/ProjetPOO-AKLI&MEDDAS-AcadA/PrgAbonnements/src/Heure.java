

import java.util.Scanner;

public class Heure {
private int heure,minute,seconde;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

public Heure()
{
	
}
public Heure(int heure, int minute, int seconde) {
	this.heure = heure;
	this.minute = minute;
	this.seconde = seconde;
}

public String toString() {
	return  heure+":"+minute+":"+seconde;
}
/**
 * @return the heure
 */
public int getHeure() {
	return heure;
}

/**
 * @param heure the heure to set
 */
public void setHeure(int heure) {
	this.heure = heure;
}

/**
 * @return the minute
 */
public int getMinute() {
	return minute;
}

/**
 * @param minute the minute to set
 */
public void setMinute(int minute) {
	this.minute = minute;
}

/**
 * @return the seconde
 */
public int getSeconde() {
	return seconde;
}

/**
 * @param seconde the seconde to set
 */
public void setSeconde(int seconde) {
	this.seconde = seconde;
}
public void saisir ()
{
	Scanner s = new Scanner(System.in);
	Heure A= null;String str = new String();boolean b = true;
	int integer;
	do{
		System.out.println("\n================\nheure:");
	    str = s.next();
	    integer=Integer.parseInt(str);
	try {b=true;
		if(!Heure.getHeureException(Integer.parseInt(str)))throw new HeureException("heure invalid");
	
	this.setHeure(integer);} catch (NumberFormatException | HeureException e) {
		// TODO Auto-generated catch block
		b= false;
	
		
	}
	}while(!b);
	do {try {b=true;	System.out.println("\nminute:");
	        str = s.next();
	        integer=Integer.parseInt(str);
		    if(!Heure.getMinuteException(Integer.parseInt(str)))throw new HeureException("minute invalid");
		     this.setMinute(integer);} catch (NumberFormatException | HeureException e) {
		// TODO Auto-generated catch block
	

		}}while (!b);
	do{try {b=true;System.out.println("\nseconde:");
	     str = s.next();
	     integer=Integer.parseInt(str);
	     if(!Heure.getSecondeException(Integer.parseInt(str)))throw new HeureException("seconde invalid");
         this.setSeconde(integer);} catch (NumberFormatException | HeureException e) {

		// TODO Auto-generated catch block
	
	}}while(!b);
	

	
	
}
//***************************************************
//*****************pour facilité la construction*****
//****************************************************
//----pour evité les try catch lors de la création ----
public static Heure Parse(String s)
{String[] result = new String[3];
result = s.split(":");
int seconde = Integer.parseInt(result[2]);
int minute = Integer.parseInt(result[1]);
int heure = Integer.parseInt(result[0]);
boolean b = true;
Heure h = new Heure();
   
try {
	if(!Heure.getHeureException(heure))throw new HeureException("heure invalid");
	h.setHeure(heure);
} catch (NumberFormatException | HeureException e) {
	// TODO Auto-generated catch block
	result[0]=null;
	
	return null;
}
try {
	if(!Heure.getMinuteException(minute))throw new HeureException("minute invalid");
	h.setMinute(minute);
} catch (NumberFormatException | HeureException e) {
	// TODO Auto-generated catch block
	result[1]=null;

	return null;}
try {
	if(!Heure.getSecondeException(seconde))throw new HeureException("seconde invalid");
	h.setSeconde(seconde);

} catch (NumberFormatException | HeureException e) {
	result[2]=null;
	// TODO Auto-generated catch block
	return null;
}
   //h=new Heure (Integer.parseInt(result[2]),Integer.parseInt(result[1]),Integer.parseInt(result[0]));
return h;
}
public static boolean getHeureException(int heure) 
{
	if(heure > 23)return false;return true;
	
}
public static boolean getMinuteException(int minute) 
{
	if(minute > 59)return false;
	return true;
	
}
public static boolean getSecondeException(int seconde) 
{
	if(seconde > 59){return false;
	}

return true;}
///-------------methodes de convension:
//------convertir en seconde
public int fromHeureTOseconde()
{
	return this.getHeure()*3600 + this.getMinute()*60 + this.getSeconde();

}
//------convertir en minute
public int fromHeureTOminute()
{
	return this.getHeure()*60 + this.getMinute() + this.getSeconde()/60;
}
//------convertir seconde en Heure : 
// on lui donne nb jour , seconde ou heure en seconde et on recupère la nouvel here ainsi que les jour
public int fromSecodeTOheure(int s,Heure a )
{ //int NBjour;
	int NBjour=0;
	int x=0, y=0;
  x=s/60;
	if(s<=59){a.setHeure(0);a.setMinute(0);a.setSeconde(s);return 0;}
	a.setSeconde(x);
	y = s/60;
	if(y<=59){a.setHeure(0);a.setMinute(y);return 0;}
	a.setMinute(y%60);
	x= y/60;
	if(x<=23){a.setHeure(x);return 0;}
	a.setHeure(x%23);
	NBjour = x/23;
	return NBjour;
	
}
//--
//-------durée entre deux date:
//-----static
public static int DuréeEntreDeuxHeures(Heure a1, Heure a2)
{   Heure s1,s2;
    s1= Heure.Parse(a1.toString());
    s2=Heure.Parse(a2.toString());
    int j1= s1.fromHeureTOseconde();int j2=s2.fromHeureTOseconde();
    
    		
	return j1-j2;//== dire: entre a1 et a2 il y c'est passé j1-j2 seconde
}
//-----instance
//---------comparer deux date (static methode)
public static int compare(Heure h1,Heure h2)
{
if(h1.getHeure() > h2.getHeure())return 1;
else {if(h1.getHeure() < h2.getHeure())return -1;
	  else if(h1.getMinute() > h2.getMinute())return 1;
	       else {if(h1.getMinute() < h2.getMinute()){return -1;}
	             else {if(h1.getSeconde() > h2.getSeconde()){return 1;}
	                   else{ if(h1.getSeconde() < h2.getSeconde()){return -1;}}
	                   }
	             }
     }
	return 0;
	
}
//une deuxieme methode de saisit : qui utilise la methode parse :
public static Heure saisitParString()
{Heure a = null;
StringBuffer s = new StringBuffer ();
Scanner sc = new Scanner(System.in);
String s1,s2,s3;
System.out.println("\n========= Heure : ");
s1=(sc.next());

System.out.println("\nMinute : ");
s2=(sc.next());
System.out.println("\nSeconde : ");
s3=(sc.next());
do{ a =Heure.Parse(s3+":"+s2+":"+s1);}while(a != null);
		
	
return a;

}
}