package com.JeuxAleatoire.conception;



import java.util.Vector;

public class Vecteur {
	gamer [] Vect;
	public Vecteur()
	{
		Vect=new gamer[20];
		for(int i=0;i<20;i++)
		{
			Vect[i]=new gamer();
		    Vect[i].saisie();
		    Vect[i].partiejeu();
	    }
		
		
	}
	//pour eviter la saisit fastidieuse
	public Vecteur(int n)
	{
		Vect=new gamer[20];
		int i= 0 ;
		Vect[i]=new gamer("Amine");
		Vect[i].partiejeu(5);i=i+1;
		
		Vect[i]=new gamer("Meriem");
		Vect[i].partiejeu(7);i=i+1;
		Vect[i]=new gamer("Salim");
		Vect[i].partiejeu(12);i=i+1;
		Vect[i]=new gamer("Soria");
		Vect[i].partiejeu(11);i=i+1;
		Vect[i]=new gamer("Cherfa");
		Vect[i].partiejeu(5052);i=i+1;
		Vect[i]=new gamer("Adem");
		Vect[i].partiejeu(5516);i=i+1;
		Vect[i]=new gamer("Madjid");
		Vect[i].partiejeu(625485);i=i+1;
		Vect[i]=new gamer("Zohra");
		Vect[i].partiejeu(10000);i=i+1;
		Vect[i]=new gamer("Maria");
		Vect[i].partiejeu(18951);i=i+1;
		Vect[i]=new gamer("Alaa");
		Vect[i].partiejeu(70);i=i+1;
		Vect[i]=new gamer("Amani");
		Vect[i].partiejeu(555);i=i+1;
		Vect[i]=new gamer("Hichem");
		Vect[i].partiejeu(89876);i=i+1;
		Vect[i]=new gamer("Ibtissem");
		Vect[i].partiejeu(1125);i=i+1;
		Vect[i]=new gamer("Amel");
		Vect[i].partiejeu(333);i=i+1;
		Vect[i]=new gamer("Bilel");
		Vect[i].partiejeu(15574);i=i+1;
		Vect[i]=new gamer("Aimen");
		Vect[i].partiejeu(4613);i=i+1;
		Vect[i]=new gamer("Houria");
		Vect[i].partiejeu(4432);i=i+1;
		Vect[i]=new gamer("Yasmine");
		Vect[i].partiejeu(4248);i=i+1;
		Vect[i]=new gamer("Annie");
		Vect[i].partiejeu(4116);i=i+1;
		Vect[i]=new gamer("Asia");
		Vect[i].partiejeu(99999);i=i+1;
		
		
	}
	public void TriDecroissant()
	{
		gamer J;
		for(int i=0;i<19;i++)
			for(int j=i+1;j<20;j++)
				if(this.Vect[i].score<this.Vect[j].score)
					//if(this.Vect[i].getScore<this.Vect[j].getScore())//si on declare score private
				{//echanger
					J=this.Vect[i];
					this.Vect[i]=this.Vect[j];
					this.Vect[j]=J;
					
				}
	}
	public void Affichage()
	{
		for(int i=0;i<19;i++)
		{
			Vect[i].affichage();
		}
	}
	
}
