package com.JeuxAleatoire.conception;


import java.util.Random;
import java.util.Scanner;


public class gamer {
	
	int num,score;//private int score
	String nom;
	static int numeroj=0;
	
	public gamer()
	{
		numeroj++;
		this.num=numeroj;
		this.score=0;
	}
	public gamer(String nom)
	{  this.nom = nom;
		numeroj++;
		this.num=numeroj;
		this.score=0;
	}
	
	public void saisie()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("veuillez saisir votre nom");
		this.nom=s.nextLine();
		
	}
	
	public void affichage()
	{
		System.out.println("gamer Numero: "+this.num +"\t "+this.nom+ "\t avec un score de: "+this.score);
	}
	
	public void partiejeu()
	{   
		Scanner s=new Scanner(System.in);
		System.out.println("veuillez saisir une valeur");
		int d, val=s.nextInt();
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			d=r.nextInt()%2000;
			
			
			if(d<=val+1000 && d>=val-1000)
				this.score++;
		}
		
		
	}
	public void partiejeu(int val)
	{   
		
		int d;
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			d=r.nextInt()%2000;
			
			
			if(d<=val+1000 && d>=val-1000)
				this.score++;
		}
		
		
	}
	public void gagnant(gamer g)
	{
		if(this.score > g.score){System.out.println("le gagnant est : ");this.affichage();}
		else {
			    if(this.score < g.score)
			    {System.out.println("le gagnant est : ");g.affichage();}
			    else System.out.println("égalité"); }
		
	}
	/*
	  public void setScore(int s){score = s; }
	  public int getScore(){retrurn score;}//si on declare score private
	
     */


}
