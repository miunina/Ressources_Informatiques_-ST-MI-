package com.JeuxAleatoire.conception;


import java.util.Scanner;


public class programme {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int ch;
		do{
		ch = programme.menuPrincipale();
		switch(ch)
		{case 1:
			
			gamer j1;
			j1=new gamer();
			j1.saisie();
			j1.partiejeu();
			j1.affichage();
			
			break;
		case 2:
		gamer j3,j2;
		j3=new gamer();j3.saisie();j2=new gamer();j2.saisie();j3.partiejeu();j2.partiejeu();
		System.out.println("le gamer gagnant est: ");
		j3.gagnant(j2);
		
		break;
		//question 3
		case 3:
		
		//le trie du tableau
		int choix;Vecteur v;
		do{System.out.println("si vous vouler saisir tapez 1 si vous voulez éviter la saisit taper 2 ");
		choix = scan.nextInt();}while(choix!=1 && choix!=2);
		switch (choix)
		{
		case 1: v= new Vecteur();v.TriDecroissant();
		v.Affichage();
			break;
		case 2: v=new Vecteur(0);v.TriDecroissant();
		v.Affichage();
			break;
		}
		
		break;
		case 4:
		System.out.println("Merci d'avoir jouer à notre jeu à plus");
		break;}
		}while(ch <4 && ch >= 1);
		//question 4 si on declare score avec le neveau private, il faut appeler le getter et le setter

	
	//Fenetre f = new Fenetre();
		}
	public static int menuPrincipale()
	{Scanner scan = new Scanner(System.in);int n;
		System.out.println("votre choix:"
				+ "\n                   1-solo"
				+ "\n                   2-multijoueur *2"
				+ "\n                   3-multijoueur *20"
				+ "\n                   4-retour");
		n = scan.nextInt();return n;
	}

}
