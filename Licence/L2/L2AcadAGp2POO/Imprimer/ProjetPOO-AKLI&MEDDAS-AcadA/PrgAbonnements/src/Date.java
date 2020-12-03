

import java.util.Scanner;

public class Date{
	private int jour, ann�e;
	private mois Mois;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return jour+"/"+Mois+"/"+ann�e;
	}
	public Date()
	{
		
	}
	public Date(int jour, int mois, int ann�e) throws DateException, IllegalArgumentException
	{
		if(!Date.verifier(jour, mois, ann�e))
		{
			throw new DateException(" Date invalide");
		}
		this.Mois = Date.getMoisString(mois);
		this.jour=jour;
		this.ann�e=ann�e;
	}
	public static mois getMoisString(int n)throws IllegalArgumentException
	{
		for(mois moi : mois.values())
		{
			if(moi.ordinal()==n-1){return moi;}
		}
		throw new IllegalArgumentException("===moi invalid===");
	}
	public Date(int jour, mois mois, int ann�e) {
		
		this.jour = jour;
		this.ann�e = ann�e;
		this.setMois(mois);
	}
	
	public void setMois(int n) throws DateException
	{this.setMois(mois.getMoisString(n));
		//this.Mois = mois.valueOf(arg0)n;
	}
	
	public static boolean verifier(int jour, int moi, int annee)
	
	{
		  boolean maxjdm31 = (moi==1 || moi==3 || moi==5 || moi==7 || moi==8 || moi==10 || moi==12);
	      boolean maxjdm30 = (moi==4 || moi==6 || moi==9 || moi==11);
	      boolean maxjdm29 = (moi==2 && Date.bissextil(annee));
	      boolean maxjdm28 = (moi==2 && !Date.bissextil(annee));
	    
	//  boolean valid = (moi>=1 && moi<=12 && jour>=1) && ( (maxjdm31 && jour<=31) || (maxjdm30 && jour<=30) || (maxjdm29 && jour<=29) || (maxjdm28 && jour<=28) );
	        return (annee>=1 && moi>=1 && moi<=12 && jour>=1) && ( (maxjdm31 && jour<=31) || (maxjdm30 && jour<=30) || (maxjdm29 && jour<=29) || (maxjdm28 && jour<=28) );
		
	}
	  //methode pour dire si une annee est bissextille
	   public static boolean bissextil(int annee)
	  {   return ((annee % 100 != 0) && (annee % 4 == 0));
	  }
	  public void saisir()
	  {
		  Scanner s = new Scanner(System.in);
		  Date d =null; String sJour,sMois, sAnn�e;
		 do{ System.out.println("\nsaisir jour : ");
		     sJour = s.next();
		     System.out.println("mois :(entier) ");
		     sMois = s.next();
		     System.out.println("ann�e : ");
		     sAnn�e = s.next();
		     d= Date.Parse(sJour+"/"+sMois+'/'+sAnn�e);
		    this.setAnn�e(d.getAnn�e());
		    this.setJour(d.getJour());
		    this.setMois(d.getMois());}while(d==null);
		 
	  }
	  
	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}
	/**
	 * @param jour the jour to set
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}
	/**
	 * @return the ann�e
	 */
	public int getAnn�e() {
		return ann�e;
	}
	/**
	 * @param ann�e the ann�e to set
	 */
	public void setAnn�e(int ann�e) {
		this.ann�e = ann�e;
	}
	/**
	 * @return the mois
	 */
	public mois getMois() {
		return Mois;
	}
	/**
	 * @param mois the mois to set
	 */
	public void setMois(mois mois) {
		
		Mois = mois;
	}

//-------------methodes de comparaison
	
	public int compare( Date s2)//m�thode compare d'instance compare deux date
{
      if(this.getAnn�e() > s2.getAnn�e()){return 1;}
      else {if(this.getAnn�e() < s2.getAnn�e()){return -1;}
             else {if(this.getMois().ordinal() > s2.getMois().ordinal()){return 1;}
                   else{if(this.getMois().ordinal() < s2.getMois().ordinal()){return -1;}
                         else{if(this.getJour() > s2.getJour()){return 1;}
                              else{if(this.getJour() < s2.getJour()){return -1;}
                                    
                                  }
                              }
                        }
                   }
  
} return 0;}
public static int compare(Date s1, Date s2)//m�thode compare satic qui compare deux date
{
if(s1.getAnn�e() > s2.getAnn�e()){return 1;}
else {if(s1.getAnn�e() < s2.getAnn�e()){return -1;}
     else {if(s1.getMois().ordinal() > s2.getMois().ordinal()){return 1;}
           else{if(s1.getMois().ordinal() < s2.getMois().ordinal()){return -1;}
                 else{if(s1.getJour() > s2.getJour()){return 1;}
                      else{if(s1.getJour() < s2.getJour()){return -1;}
                             else return 0;
                          }
                      }
                }
           }

}}
public static Date Parse(String string) 
{//cette methode statique permet de transformer une date entr�e comme �tant une chaine en une date
	String[] result = new String[3];
	result = string.split("/");
	boolean b = true;
	Date d1 =null;
	try {
		d1= new Date(Integer.parseInt(result[0]),mois.getMoisString(Integer.parseInt(result[1])) ,Integer.parseInt(result[2]));
	
		//d2 = new Date(2,mois.getMoisString(1),2012);
		}
    catch (DateException e)
	{
		// TODO Auto-generated catch block
    	d1=null;
		System.err.println("date invalid");
		b=false;
	} catch(IllegalArgumentException io)
	{
		d1=null;
		System.err.println("mois invalide !!");
		b=false;
	}
	catch(Exception eoi)
	{d1=null;
	System.err.println("mois invalide !!");
	b=false;
}
	
return d1;//retourner date
}
//cette methode compare deux date entr�e comme chaine de caract�re
public static int compareTo(String d, String s)
{
	
	Date s1 = Date.Parse(d);//faire appel � parse
	Date s2 = Date.Parse(s);

	if(s1.getAnn�e() > s2.getAnn�e()){return 1;}
	else {if(s1.getAnn�e() < s2.getAnn�e()){return -1;}
	       else {if(s1.getMois().ordinal() > s2.getMois().ordinal()){return 1;}
	             else{if(s1.getMois().ordinal() < s2.getMois().ordinal()){return -1;}
	                   else{if(s1.getJour() > s2.getJour()){return 1;}
	                        else{if(s1.getJour() < s2.getJour()){return -1;}
	                               else return 0;
	                            }
	                        }
	                  }
	             }
	      }
}
	
//--------------------------------------------------------------
//------pour avoir date du lendemain
public Date dateLendemaint()
{
  Date dateLendemain = new Date();
  int maxjour = mois.getMoisString2(this.getMois().ordinal()+1).Maxjdm();      // getMois().ordinal()+1;
  int jour= this.getJour()+1;
  int moi = this.getMois().ordinal()+1;
  if(Date.bissextil(this.getAnn�e())==true && moi ==2)
  {
  	maxjour = 29;
  }
  
    if(jour <= maxjour){
    	dateLendemain.setAnn�e(getAnn�e());
        dateLendemain.setJour(jour);
        dateLendemain.setMois(mois.getMoisString2(this.getMois().ordinal()+1));
                       }
    else{   dateLendemain.setJour(1);
            if(moi < 12){    	
  	            dateLendemain.setAnn�e(getAnn�e());
		        dateLendemain.setMois(mois.getMoisString2(this.getMois().ordinal()+1));
		          dateLendemain.setMois(mois.getMoisString2(dateLendemain.getMois().ordinal()+2));
	            }
            else{dateLendemain.setAnn�e(getAnn�e()+1);
	        dateLendemain.setMois(mois.JANVIER);}
      }
  return dateLendemain;
}
//------pour avoir la veille d'une date:
public Date veilleDate()
{Date dateLendemain = new Date();
int maxjour;// = this.getMois().Maxjdm();
int jour= this.getJour()-1;
int moi = this.getMois().ordinal()+1;

if (this.getJour()==1){
                if(moi == 1){dateLendemain.setAnn�e(getAnn�e()-1);
                             dateLendemain.setJour(31);
                             dateLendemain.setMois(mois.DESCENBRE);}
//si ce n'est po janvier alors :
               else {dateLendemain.setAnn�e(getAnn�e());
                    
                     jour=mois.values()[this.getMois().ordinal()].Maxjdm();

//on prend le max du moi pr�cedent
//si c'est 28 alors c'est fevrier et on doit verifier si c'est bissextil ou non
                      if(Date.bissextil(this.getAnn�e())==true && jour == 28)
                      {maxjour = 29;}
                      dateLendemain.setJour(jour);
                   dateLendemain.setMois(mois.values()[this.getMois().ordinal()]);}}
//sinon on peut retrancher comme on veut
else {dateLendemain.setAnn�e(getAnn�e());
dateLendemain.setJour(this.getJour()-1);
dateLendemain.setMois(getMois());}return dateLendemain;}
//
//------pour avoir le nombre de jour entre deux date:
public int getNombreJour()
{	/*int maxjour = mois.valueOf((this.getMois().toString())).Maxjdm();
	if(Date.bissextil(this.getAnn�e())==true)
	{if(maxjour==28)
return this.getAnn�e()*366 + this.getMois().ordinal() * (maxjour+1) +this.getJour();}
	else {
		return this.getAnn�e()*366 + this.getMois().ordinal() * (maxjour) +this.getJour();}
return 0;*/
	int m = this.getMois().ordinal();int y= this.getAnn�e();int d= this.getJour();
	 m = (m + 9) % 12;
	y = y - m/10;
	return 365*y + y/4 - y/100 + y/400 + (m*306 + 5)/10 + ( d - 1 );
}

//------------nb jour entre deux date ::--------:
public int NombreJourEntre(Date d)
{
	return this.getNombreJour()-d.getNombreJour();
}
public static int NombreJourEntre(Date d1, Date d2)
{
	return d1.getNombreJour()-d2.getNombreJour();
}
//------------date apr�s nb jour ::  ----------::
public Date dateApresNjour(int jour)
{
	Date d = Date.Parse(this.toString());	
	for(int i=0; i<= jour ; i++)
	{
		d=d.dateLendemaint();
	}
	return d;
}
public static Date dateApresNjour(Date d1, int jour)
{
	Date d;
     d = Date.Parse(d1.toString());
	for(int i=0; i<= jour ; i++)
	{
		d=d.dateLendemaint();
	}
	return d;
}
//--------date apr�s un mois :: ---------------::
public Date dateunMois()
{
	Date d = Date.Parse(this.toString());int m = this.getMois().ordinal()+1;
	int jour = d.getJour();int annee= d.getAnn�e();
	
	if(m==12){
		d.setMois(mois.JANVIER);d.setAnn�e(getAnn�e()+1);
		     }
	else{
		d.setMois(mois.getMoisString2(this.getMois().ordinal()+1));
        d.setMois(mois.getMoisString2(d.getMois().ordinal()+2));
        m = d.getMois().ordinal()+1;
        if( m == 2 && (jour>=28 ) )
        {  if(Date.bissextil(annee)){d.setJour(29);return d;}
           else d.setJour(28);return d;
        }
        if(jour > 30)
        {
        	switch (m)
        	{
        	case 4:case 6: case 8:case 10: d.setJour(30);
        	}
        }
        }
	
	return d;
}

public static Date dateunMois(Date thi)
{
	Date d = Date.Parse(thi.toString());int m = thi.getMois().ordinal()+1;
	int jour = d.getJour();int annee= d.getAnn�e();
	
	if(m==12){
		d.setMois(mois.JANVIER);d.setAnn�e(thi.getAnn�e()+1);
		     }
	else{
		d.setMois(mois.getMoisString2(thi.getMois().ordinal()+1));
        d.setMois(mois.getMoisString2(d.getMois().ordinal()+2));
        m = d.getMois().ordinal()+1;
        if( m == 2 && (jour>=28 ) )
        {  if(Date.bissextil(annee)){d.setJour(29);return d;}
           else d.setJour(28);return d;
        }
        if(jour > 30)
        {
        	switch (m)
        	{
        	case 4:case 6: case 8:case 10: d.setJour(30);
        	}
        }
        }
	
	return d;	
}
//------date apres nb mois donn�e : ----------::
public static Date dateApresnbMois(Date d1,int moi)
{
	Date d = Date.Parse(d1.toString());
	for(int i=0; i<moi; i++)
	{d=Date.dateunMois(d);}
 
	return d;	
}
}