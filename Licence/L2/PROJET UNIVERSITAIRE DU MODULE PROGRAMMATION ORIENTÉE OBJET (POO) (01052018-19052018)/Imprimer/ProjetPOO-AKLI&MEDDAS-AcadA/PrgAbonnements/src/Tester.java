import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Tester {

	public static void main(String[] args) {
		int choixMenu,choixClient,choixFacture, choixOperateur, choixClientConsultation, choixClientModification;
		int choixModifierPointDevente;int durée;
		Client cli=null;boolean contin=false;int numWilaya;Client cliAncien = null;Appel appl =null;
		long pourcentageWilaya;
		Scanner scan = new Scanner(System.in);int indice;
		Operateur op = null;PointDeVente P = null;PointDeVente P2 =null;
		Abonnement A=null;
        AbonLibre libre=null;AbonForfaitaire forf=null;AbonPrepayer prep=null;
		String str=null;Adresse Adre=new Adresse();
		ArrayList <Client>listClient=null;String str2;Date det=new Date();Heure Her=new Heure();
		do
		{
			
		
		choixMenu=Tester.ApplicationMenu();
		switch(choixMenu)
		{
		case 1 ://remplissage automatique
		listClient=new  ArrayList <Client>();
		op=Tester.programmeRemplir(op);
	
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			
			break;
		
			case 2://gestion de l'operateur
				//***********************************************
				do
				{
					choixOperateur=Tester.menuOperateur();	
					//------------switch case operateur:
					  
					   
					
						
					switch(choixOperateur)
					{
					case 1:System.out.println("\n1.Ajouter un point de vente ");
					if(op == null )
					{
						System.out.println(" \n veuilllez creez vos objet");
					}
					else
					{P=new PointDeVente();P.saisir();System.out.println(P);//par saisit
					      if(op.RecherchernNumeroDonnésPointDeVente(P.getNumeroTelephone()) == null)
			              op.AjouterPtrVente(P);
					      else System.out.println(" l operateur existe deja \n !!");
					//Adre = new Adresse();Adre.saisir();//automatique
					}break;
					case 2:System.out.println("\n2. Supprimer un point de vente ");
					if(op == null )
					{
						System.out.println(" \n veuilllez creez vos objet");
					}
					else
					{
						 P=null;
						 System.out.println("donnez numéro tel :");
						 str = scan.next();
						 
					if(Client.verifieNumTelephone(str))
					{   if(( P=op.RecherchernNumeroDonnésPointDeVente(str))!=null)
						{
							 System.out.println("\nsuppression !!");
							 op.SupprimerPtrVente(P);
						}
						else {
							System.out.println("\nImpossible de supprimer num innexistant!!");
							
						}
					}
						else System.err.println("numero invalide !!");
					}
						break;
					case 3: System.out.println("\n3. Modifier un point de vente(changer type numéro ou adrese)");
					 //------------------------------------------------------
					if(op == null )
					{
						System.out.println(" \n veuilllez creez vos objet");
					}
					else
					{
						
					
					do{
						choixModifierPointDevente=Tester.menuModifierPointDeVente();
						switch(choixModifierPointDevente)
						{
						case 1:System.out.println("\n1-changer type:");
							System.out.println("donnez num pour changer !!");
						str = scan.next();
						if(Client.verifieNumTelephone(str))
						{if(( P=op.RecherchernNumeroDonnésPointDeVente(str))!=null)
						{
						//P ANCIEN POINT DE VENTE TROUV2 A PARTIR DU NUM TEL DONN2E
							
							 P2=P;//P2 LE NOUVEEAU PTR DE VENTE MODIFIER
							 System.out.println("\n1-donnez nouveau type !!");contin=false;
							 do{System.out.println("-----------type 'principale ou secondaire':------------");
								str =(scan.next().toUpperCase());
								for(Type tp :Type.values())
								{
									if(tp.name().equals(str))
									{
										contin=true;
										
										 if(!str.equals(P.getTyp().name()))//si ils ont meme type po la peine de changer
										 {P2.setTyp(tp);
										 op.setPointdeVenteElt(P, P2);
										 System.out.println("\nnouveau :"+P2);}
										 else
										 {
											 System.out.println("\n vous n' avez rien changer"); 
										 }
										 break;
									}
								}}while(contin == false);
							
							 
						}
						else {
							System.out.println("\nImpossible de changer type car  num innexistant!!");
							
						}}else System.err.println("numero invalide !!");
						break;
						//==============================================
						case 2:System.out.println("\n2-changer numéro:");
							System.out.println("donnez num a changer !!");
						str = scan.next();
						if(Client.verifieNumTelephone(str))
						{if(( P=op.RecherchernNumeroDonnésPointDeVente(str))!=null)
						{
						//P ANCIEN POINT DE VENTE TROUV2 A PARTIR DU NUM TEL DONN2E
							
							 P2=P;//P2 LE NOUVEEAU PTR DE VENTE MODIFIER
							 System.out.println("\ndonnez nouveau numéro !!");
							 str = scan.next();
							 if(!str.equals(P.getNumeroTelephone()))
							 {P2.setNumeroTelephone(str);
							 op.setPointdeVenteElt(P, P2);
							 System.out.println("\nnouveau :"+P2);}
								
							 else
							 {
								 System.out.println("\n vous n' avez rien changer"); 
							 }
							 
						}
						else {
							System.out.println("\nImpossible de changer num innexistant!!");
							
						}}
						else System.err.println("numero invalide !!");
						break;
						case 3: System.out.println("\n3-changer adresse:");
						
						System.out.println("donnez num pour changer !!");
					str = scan.next();
					if(Client.verifieNumTelephone(str))
					{
						
					
					if(( P=op.RecherchernNumeroDonnésPointDeVente(str))!=null)
					{
					//P ANCIEN POINT DE VENTE TROUV2 A PARTIR DU NUM TEL DONN2E
						
						 P2=P;//P2 LE NOUVEEAU PTR DE VENTE MODIFIER
						 System.out.println("\ndonnez nouvelle adresse !!");
						 Adre = new Adresse();
						 Adre.saisir();
						 if(!Adre.equals(P.getAdresse()))
						 {P2.setAdresse(Adre);
						 op.setPointdeVenteElt(P, P2);
						 System.out.println("\nnouveau :"+P2);}
							
						 else
						 {
							 System.out.println("\n vous n' avez rien changer"); 
						 }
						 
					}
					else {
						System.out.println("\nImpossible de changer adresse num innexistant!!");
						
					}}
					else System.err.println("numero invalide !!");
						break;
						case 4: //retourner
						break;
						case 5: choixMenu=6;
						break;
						
						}
					}while(choixModifierPointDevente!= 4 && choixModifierPointDevente!=5 );}
					//------------------------------------------------------
						
					break;
					case 4:System.out.println("\n4. Changer pourcentage de couverture pour une wilaya donnée ");
					      if(op==null)
					      {
				    	  System.out.println("\noperateur n'est po encore crée!!\n") ;
				          }
					      else
					      {
					    	  System.out.println("donnez numéro de wilaya et nouveau pourcentage de couverture");
					    	  
					    	  numWilaya = scan.nextInt();
					    	  pourcentageWilaya = scan.nextLong();
					    	  while(numWilaya <1 && numWilaya > 42)
					    	  {
					    		  System.out.println("donnez numéro de wilay CORRECTE");
						    	  
						    	  numWilaya = scan.nextInt();
						    	 
					    	  }
					    	  op.pourcentageModifier(numWilaya, pourcentageWilaya);
					    	 op.AfficherWilayaPourcentage();
					      }
						break;
					case 5:System.out.println("\n5. Afficher les informations concernant l'opérateur");
					      if(op == null)
					      {
					    	  System.out.println("\noperateur n'est po encore crée!!\n") ;
					      }
					      else
					      {
					    	  System.out.println(op);
					      }
						break;
					case 6:
						//retour
						break;
					case 7:choixMenu=6;
						break;
						
					}
				}while(choixOperateur != 7 && choixOperateur != 6);	//fin operateur***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			break;
			case 3://gestion des clients
				//***********************************************
				if(op == null) {System.out.println("\n veuillez creer vos objt!!");}
				else {do
				{
				choixClient=Tester.menuClients();	
				//------------switch case Client:
				switch(choixClient)
				{case 1://
					System.out.println("\n1-Ajouter un numéro");
					System.out.println("\n donnez num:");
					str= scan.next();
					while(!Client.verifieNumTelephone(str))
					{
						System.out.println("\n donnez num:");
						str= scan.next();
					}
					cli = op.RecherchernNumeroDonnéeClient(str);
					if(cli != null)
					{
						System.out.println("num exit=ste deja !!");
					}
					else
					{
						cli = new Client();
						cli.setBloqué(false);
						cli.setNumTelephone(str);
						System.out.println("\n=donnez nom, prenom, ");
						cli.setNom(scan.next());
						
					}
					
					
					
					break;
				case 2:
					System.out.println("\n2-Modifier Numéro(adresse, debloqué");
					
					break;
				case 3:
					System.out.println("\n3-Supprimer un numéro");
					 if(op==null)
				      {
			    	  System.out.println("\noperateur n'est po encore crée!!\n") ;
			          }
				      else
				      {
				    	if((cli = op.RecherchernNumeroDonnéeClient("0560626322"))!=null)
				    	{
				    		op.SupprimerClient(cli);
				    		System.out.println(op.getAbonnées());
				    	}
				    	else {System.out.println("\n numero innexistant !!");}
				    	cli=null;
				      }
					break;
				case 4:
					//***********************************************
					//***********************************************
					//*********consultation données clients**********
					System.out.println("\n4-Consultation des données");
					do
					{
					choixClientConsultation=Tester.menuConsultationClient();
					//------------switch case Client:
					switch(choixClientConsultation)
					{
					case 1:
						System.out.println("\n1-liste des client par type d'abonnement");
						 if(op==null)
					      {
				    	  System.out.println("\noperateur n'est po encore crée!!\n") ;
				          }
					      else
					      {
					    	op.AfficherClientParTypeAbonnement();  
					      }
						break;
					case 2:
						System.out.println("\n2-liste des numéros bloqué(date de bloquage motif de bloquage)");
						 if(op==null)
					      {
				    	  System.out.println("\noperateur n'est po encore crée!!\n") ;
				          }
					      else
					      {
					    	  op.AfficherClientBloqué();
					      }
						break;
					case 3:
						System.out.println("\n3-liste des numéro relancé pour paiement ou rechargement avec la date de rappel");
						if(op == null)
						{
							System.out.println("\noperateur n'est po encore crée!!\n") ;
					        
					}
						else
						{
							
						}
							
						break;
					case 4:
						
						System.out.println("\n4-Liste des clients par wilaya(selon l'adrese du client)");
						if(op == null)
						{
							System.out.println("\noperateur n'est po encore crée!!\n") ;
					        
						}
						else
						op.AfficherClientParWilaya();
						break;
					case 5:
						System.out.println("\n5-rechercher un numéro donnée et afficher ses informations ");
						if(op == null)
						{
							System.out.println("\noperateur n'est po encore crée!!\n") ;
					        
						}
						else
						{
							if((cli=op.RecherchernNumeroDonnéeClient("0560626322"))!=null)cli.Affichage();
							else System.out.println("\nNuméro n'existe pas dans la liste des clients");
							cli=null;
						}
						break;
					case 6:
						System.out.println("\n6-rechercher un numéro donnée et afficher les appels entrants et les appels sortants et les durées cumulées");
						if(op == null)
						{
							System.out.println("\noperateur n'est po encore crée!!\n") ;
					        
						}
						else
						{
							if((cli=op.RecherchernNumeroDonnéeClient("0560626365"))!=null)System.out.println("\n\nAffichage des appels entrant est sortant: \n"+cli.getA());
							else System.out.println("\nNuméro n'existe pas dans la liste des clients");
							cli=null;
						}
							
						break;
					case 7:
						System.out.println("\n7-etablir une facture pour un numéro donée");
						if(op == null)
						{
							System.out.println("\noperateur n'est po encore crée!!\n") ;
					        
						}
						else
						{
							System.out.println("donnez numero tel");
							str= scan.next();
							if(!Client.verifieNumTelephone(str))
							{
								System.err.println(" numéro invalide !! ");
							}
							else
							{
							if((cli=op.RecherchernNumeroDonnéeClient(str))!=null)
								
		                    System.out.println("\nclient:"+cli.toString()+"\nFacture= \n"+cli.getAbon().facture(cli));
							else System.out.println("\nNuméro n'existe pas dans la liste des clients");
							}cli=null;
						}
						
						break;
					case 8:
						System.out.println("\n8-Afficher tout les numéros arrivé à échéance de paiement");
						
						break;
					case 9:
						System.out.println("\n9-afficher les factures ");
						
						break;
					case 10://retour
						break;
					case 11:choixMenu= 6;
						break;
							
					}
					}while(choixClientConsultation != 10 && choixClientConsultation != 11);
					break;
					//fin case 4
				case 5:indice =-1;
					System.out.println("\n5-Appeler");
					do{
					System.out.println("donnez : num a appele num de l'appelant, date, heure, durée");
					str = scan.next();str2=scan.next();
					
					}while(!Client.verifieNumTelephone(str2) && !Client.verifieNumTelephone(str));
					if((indice = op.getMemeNuméroEmplacement(str)) != -1)
					{det.saisir();Her.saisir();
						cli = op.getAbonnées().get(indice);
						System.out.println("donnez la durée :");cliAncien=cli;
						durée=scan.nextInt();
						try {
							cli.AjouterAppels(str2, det, Her, durée);
							
						} catch (NegativeException | DateException | HeureException | TelephoneExceptions e) {
							// TODO Auto-generated catch block
							
						}
						op.setClientElt(cliAncien, cli);
						
						System.out.println("  liste appel "+cli.getA());
						
					}
					else System.out.println("numéro innexistant ! !! ");
					
					break;
				case 6:
					System.out.println("\n6-Recevoir Appel");
					System.out.println("donnez : num a appele num de l'appelant, date, heure, durée");
					
					break;
				case 7:
					System.out.println("\n7-Envoyer SMS");
					
					break;
				case 8:
					System.out.println("\n8-Recevoir SMS");
					
					break;
				case 9://retourner
					break;
				case 10:choixMenu=6;
					break;
				}	
				}while(choixClient != 9 && choixClient !=10);}
					//fin client***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			
			break;
		case 4://gestion des facture
			do
			{choixFacture=Tester.MenuFacture();
			switch(choixFacture)
			{
			case 1:System.out.println("\n1- Etablir une facture pour un numéro donnée:");
				break;
			case 2:System.out.println("\n2- Afficher tout les numéros arrivée à èchéance de paiement:");
			
				break;
			case 3:System.out.println("\n3-Toute les Facture en instant de paiement:");
			
				break;
			case 4:System.out.println("\n4- Relancer les numéros pour les rechargements/ paiements");
			listClient = op.getAbonnées();
			for(Client cie : listClient)
			{if(cie.isBloqué())
			{
				cie.setBloqué(false);
				//debloqué t reinitialiser l 'abonnement

				//on reinitialise l'abonnement
				//soit il paie la facture ou recharge son paiement
				libre= (AbonLibre) cie.getAbon();
				libre.setDateDebAbon(Date.dateApresnbMois(libre.getDateDebAbon(),libre.getDurée()));
				libre.setSoldeMontant(0);
				cie.setAbon(libre);
				
			}
			else{//si il nest po bloqué
				if(cie.isAvantBloqué())//recharger //si il peut que recevoir
					cie.setAvantBloqué(false);

				//on reinitialise l'abonnement
				//soit il paie la facture ou recharge son paiement
				if(cie.getAbon() instanceof AbonLibre)
				{
				libre= (AbonLibre) cie.getAbon();
				libre.setDateDebAbon(Date.dateApresnbMois(libre.getDateDebAbon(),libre.getDurée()));
				libre.setSoldeMontant(0);
				cie.setAbon(libre);
				
				}
				if(cie.getAbon() instanceof AbonForfaitaire)
				{
				forf=(AbonForfaitaire) cie.getAbon();
				}
				if(cie.getAbon() instanceof AbonPrepayer)
				{prep=(AbonPrepayer) cie.getAbon();
						
						
				
				
			}
			}}
		
				break;
			case 5://retour
				break;
			case 6:choixMenu=6;
				break;
			}
				
			}while(choixFacture!=5 && choixFacture != 6);
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			break;
		case 5://gestion des bonnus
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			//***********************************************
			break;
		case 6:
			System.out.println("\n  exit ");
			
		
		
		
		}
		
		
		
		}while(choixMenu != 6);
		// TODO Auto-gener.ted method stub
		
		//String numeroTelephone,String dateContrat, String nom, String prénom, String adresse,
		//String mail, Abonnement TypeAbon, int durée, String datedebabon, double montant
		/*Client c=null;
		try {
			c = Client.construireClient( "0560646367","8/5/2018","nom", "prenom" ,"aa,412,42","akli@hotmail.com", new AbonLibre(),3,"9/5/2018", 2300);
		c.setBloqué(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.Affichage();
		System.out.println("--------\n"+c.getAbon().getSoldeMontant());
		
		c.AjouterAppels(  "0560646368", Date.Parse("9/6/2018"), 5);
		System.out.println("--------\n"+c.getAbon().getSoldeMontant());
		
		c.AjouterAppels(  "0560645368", Date.Parse("9/6/2018"), 4);
		c.AfficherAppel();
		
		//c.A=c.getAbon().AjouterAppel(c, "0561636468", Date.Parse("9/5/2018"), 5);
		//AbonLibre AbnL = (AbonLibre) c.getAbon();
		//c.A =c.AjouterAppel(c,  "0560646368", Date.Parse("9/8/2018"), 5);
		System.out.println("--------\n"+c.getAbon().getSoldeMontant());
		*/
		Date d1=null;
		try {
			d1 = new Date(3,2,2012);
		} catch (DateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IllegalArgumentException c)
		{
			c.printStackTrace();
		}
		System.out.println(d1);
		
		
	}
	
	
	public static int QuelTypeAbonnement()
	{System.out.print("choisissez un type d'abonnement:\n1-libre.\n2-forfaitaire\n3-prépayer.");
	 Scanner sc = new Scanner(System.in);
	   int choix=sc.nextInt();
	   while(choix < 1 && choix > 3)
	   {
		   System.out.print("choisissez un type d'abonnement:\n1-libre.\n2-forfaitaire\n3-prépayer.");
		   choix=sc.nextInt();	
	   }
	   return choix;
		
	}
	 public static boolean Continuer(String messagAafficher)
	  { System.out.print(messagAafficher);
	    Scanner sc = new Scanner(System.in);
	   
	   char car=sc.next().charAt(0);
	   while(car != 'o' && car != 'O' && car !='n' && car !='N')
	   {   car=' ';
		   System.out.print(messagAafficher);
		   car=sc.next().charAt(0);
	   }
	   return (car=='o' || car == 'O');
		
		  
	  }
	 public static int ApplicationMenu()
	 { System.out.println("\n  \tMenu principal");
		 System.out.print("\n1. Remplissage automatique des données \n2. Gestion de l’opérateur \n3. Gestion des clients (numéros) \n4. Gestion des factures \n5. Gestion des bonus \n6. Quitter");
	 Scanner sc = new Scanner(System.in);
		   int choix=sc.nextInt();
		   while(choix < 1 && choix > 10)
		   { System.out.print("\n1. Remplissage automatique des données \n2. Gestion de l’opérateur \n3. Gestion des clients (numéros) \n4. Gestion des factures \n5. Gestion des bonus \n6. Quitter");
			  	   choix=sc.nextInt();	
		   }
		   return choix;
	 }
	 public static int menuConsultationClient()
	 { System.out.println("\n  \tConsultation Client");
		 System.out.print("\n1- La liste des clients par type d’abonnement \n2- La liste des numéros bloqués, on affichera en plus la date de blocage et le motif du blocage. \n3- La liste des numéros relancés pour paiement ou rechargement avec les dates de rappel \n4- La liste des clients par wilaya (selon l’adresse du client, l’adresse devra comporter un attribut wilaya) \n5- Recherche d’un numéro donné et afficher ses informations \n6 - Recherche d’un numéro donné et afficher les appels entrants et sortants et les durées cumulées \n7- Etablir facture pour un numéro donné \n8- Afficher tous les numéros arrivés à échéance de paiement \n9- Afficher toutes les factures (associées aux numéros) en instance de paiement\n10- retour\n11- Quitter ");
	   Scanner sc = new Scanner(System.in);
		   int choix=sc.nextInt();
		   while(choix < 1 && choix > 10)
		   { System.out.print("\n1- La liste des clients par type d’abonnement \n2- La liste des numéros bloqués, on affichera en plus la date de blocage et le motif du blocage. \n3- La liste des numéros relancés pour paiement ou rechargement avec les dates de rappel \n4- La liste des clients par wilaya (selon l’adresse du client, l’adresse devra comporter un attribut wilaya) \n5- Recherche d’un numéro donné et afficher ses informations \n6 - Recherche d’un numéro donné et afficher les appels entrants et sortants et les durées cumulées \n7- Etablir facture pour un numéro donné \n8- Afficher tous les numéros arrivés à échéance de paiement \n9- Afficher toutes les factures (associées aux numéros) en instance de paiement\n10- retour\n11- Quitter ");
			  	   choix=sc.nextInt();	
		   }
		   return choix;
	 }
	 public static int menuClients()
	 { System.out.println("\n  \tGesion des Clients");
		
		 System.out.print("\n1. Ajouter numéro \n2. Modifier numéro (modifier adresse, débloquer) \n3. Supprimer numéro \n4. consulation des données \n.5 Appeler \n6. Recevoir Appels \n7. Envoyer SMS \n8. Recevoir SMS \n9. Retourner au menu Princial \n10. Quitter");
		 Scanner sc = new Scanner(System.in);
	   int choix=sc.nextInt();
	   while(choix < 1 && choix > 10)
	   {
		   System.out.print("\n1. Ajouter numéro \n2. Modifier numéro (modifier adresse, débloquer) \n3. Supprimer numéro \n4. consulation des données \n.5 Appeler \n6. Recevoir Appels \n7. Envoyer SMS \n8. Recevoir SMS \n9. Retourner au menu Princial \n10. Quitter");
			   choix=sc.nextInt();	
	   }
	   return choix; 
	 }
	 public static int menuOperateur()
	 {System.out.println("\n  \tGestion d'opérateur telephonique");
		
		 System.out.print("\n1.Ajouter un point de vente \n2. Supprimer un point de vente \n3. Modifier un point de vente(changer type numéro ou adrese) \n4. Changer pourcentage de couverture pour une wilaya donnée \n5. Afficher les informations concernant l'opérateur \n6. retour \n7.Quitter");
		 Scanner sc = new Scanner(System.in);
	   int choix=sc.nextInt();
	   while(choix < 1 && choix > 7)
	   {
		   System.out.print("\n1.Ajouter un point de vente \n2. Supprimer un point de vente \n3. Modifier un point de vente(changer type numéro ou adrese) \n4. Changer pourcentage de couverture pour une wilaya donnée \n5. Afficher les informations concernant l'opérateur \n6. retour \n7.Quitter");
				   
		   choix=sc.nextInt();	
	   }
	   return choix; 
	 }
	 public static int menuModifierPointDeVente()
	 {
		 System.out.println("\n  \tModifier point de vente :");
			
		 System.out.print("\n1.Changer type \n2. changer numerp \n3. changer adresse\n4. retour\n5. Quitter");
		 	 Scanner sc = new Scanner(System.in);
	   int choix=sc.nextInt();
	   while(choix < 1 && choix > 5)
	   {
		   System.out.print("\n1.Changer type \n2. changer numerp \n3. changer adresse\n4. retour\n5. Quitter");	   
		   choix=sc.nextInt();	
	   }
	   return choix; 
		 
	 }
	 public static int MenuFacture()
	 { System.out.println("\n  \tGestion Facture :");
		
		 System.out.println("\n1. Etablir facture pour un numéro donné \n2. Afficher tous les numéros arrivés à échéance de paiement \n3. Toutes les factures en instance de paiement \n4. Relancer les numéros pour les rechargements/ paiements \n5. Retour\n6. Quitter");
		 /*Etablir facture pour un numéro donné 2. Afficher tous les numéros arrivés à échéance de paiement 3. Toutes les factures en instance de paiement 4. Relancer les numéros pour les rechargements/ paiements 5. Quitter*/
		 Scanner sc = new Scanner(System.in);
		   int choix=sc.nextInt();
		   while(choix < 1 && choix > 6)
		   {
			   System.out.println("\n1. Etablir facture pour un numéro donné \n2. Afficher tous les numéros arrivés à échéance de paiement \n3. Toutes les factures en instance de paiement \n4. Relancer les numéros pour les rechargements/ paiements \n5. Retour\n6. Quitter");
				 choix=sc.nextInt();	
		   }
		   return choix; 
			 
	 }
	 public static Operateur programmeRemplir( Operateur op)
	 {Set <Appel> ListAppel= new HashSet<Appel>();
	 ArrayList <Client>listClient=new ArrayList<Client>();
	 try {
			listClient.add(new Client("nom6", "prenom6","0560626365", Date.Parse("18/5/2018"), AdresseMail.Parse("nom6prenom6@GMAIL.com"),Adresse.Parse("nomRue1,412,42"), new AbonForfaitaire(Date.Parse("22/6/2018"),1,1000)));
			
			ListAppel.add(listClient.get(0).AjouterAppel("0540626377", Date.Parse("23/6/2018"),Heure.Parse("4:43:1"), 1));
			
			ListAppel.add(listClient.get(0).AjouterAppel("0560626777", Date.Parse("29/6/2019"),Heure.Parse("19:43:24"), 2));
			 ListAppel.add(listClient.get(0).AjouterAppel("0560626311", Date.Parse("23/6/2018"),Heure.Parse("18:43:24"), 3));
			 ListAppel.add(listClient.get(0).AjouterAppel("0560626337", Date.Parse("25/7/2018"),Heure.Parse("16:43:24"), 4));
			   listClient.get(0).setA(ListAppel);
			   
		 } catch (IllegalArgumentException | NegativeException | TelephoneExceptions | DateException
				| AdresseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		 
			
			
			 try {
					listClient.add(new Client("nom2", "prenom2","0560626377",Date.Parse("1/2/2018"), AdresseMail.Parse("nom2prenom2@GMAIL.com"),Adresse.Parse("nomRue2,412,41"), new AbonLibre(Date.Parse("18/5/2018"),1,0)));
				
			 } catch (IllegalArgumentException | NegativeException | TelephoneExceptions | DateException
						| AdresseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			 try {ListAppel.clear();
					listClient.add(new Client("nom3", "prenom3","0560626387", Date.Parse("20/3/2018"), AdresseMail.Parse("nom3prenom3@GMAIL.com"),Adresse.Parse("nomRue3,412,1"), new AbonLibre(Date.Parse("12/5/2018"),1,0)));
					ListAppel.add(listClient.get(1).AjouterAppel("0560626378", Date.Parse("19/5/2018"),Heure.Parse("4:43:1"), 5));
					ListAppel.add(listClient.get(1).AjouterAppel("0560626378", Date.Parse("19/5/2018"),Heure.Parse("19:43:24"), 6));
					ListAppel.add(listClient.get(1).AjouterAppel("0560626378", Date.Parse("19/5/2018"),Heure.Parse("18:43:24"), 7));
					ListAppel.add(listClient.get(1).AjouterAppel("0560626378", Date.Parse("19/5/2018"),Heure.Parse("16:43:24"), 8));
					   listClient.get(1).setA(ListAppel);
			 } catch (IllegalArgumentException | NegativeException | TelephoneExceptions | DateException
						| AdresseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			 
			
			 try {ListAppel.clear();
			 
					listClient.add(new Client("nom4", "prenom4","0560626322",Date.Parse("12/4/2017"), AdresseMail.Parse("nom4prenom4@GMAIL.com"),Adresse.Parse("nomRue4,412,16"), new AbonLibre(Date.Parse("13/6/2018"),1,0)));
						ListAppel.add(listClient.get(2).AjouterAppel("0560726377", Date.Parse("17/5/2018"),Heure.Parse("4:43:1"), 9));
					ListAppel.add(listClient.get(2).AjouterAppel("0560676378", Date.Parse("15/5/2018"),Heure.Parse("19:43:24"), 10));
					ListAppel.add(listClient.get(2).AjouterAppel("0560686378", Date.Parse("19/5/2018"),Heure.Parse("18:43:24"),11));
					ListAppel.add(listClient.get(2).AjouterAppel("0560626378", Date.Parse("19/5/2018"),Heure.Parse("16:43:24"), 12));
					   listClient.get(2).setA(ListAppel);
				
			 } catch (IllegalArgumentException | NegativeException | TelephoneExceptions | DateException
						| AdresseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			 try {
					listClient.add(new Client("nom5", "prenom5","0560756365", Date.Parse("18/5/2018"), AdresseMail.Parse("nom5prenom5@GMAIL.com"),Adresse.Parse("nomRue1,412,42"), new AbonForfaitaire(Date.Parse("18/5/2018"),2,2500)));
					
					ListAppel.add(listClient.get(3).AjouterAppel("0560626377", Date.Parse("19/5/2018"),Heure.Parse("4:43:1"), 1));
					
					ListAppel.add(listClient.get(3).AjouterAppel("0550626377", Date.Parse("19/5/2018"),Heure.Parse("19:43:24"), 2));
					 ListAppel.add(listClient.get(3).AjouterAppel("0560685377", Date.Parse("19/5/2018"),Heure.Parse("18:43:24"), 3));
					 ListAppel.add(listClient.get(3).AjouterAppel("0560600377", Date.Parse("19/5/2018"),Heure.Parse("16:43:24"), 4));
					   listClient.get(3).setA(ListAppel);
					   
				 } catch (IllegalArgumentException | NegativeException | TelephoneExceptions | DateException
						| AdresseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} 
			 try {
					listClient.add(new Client("nom1", "prenom1","0560626365", Date.Parse("18/5/2018"), AdresseMail.Parse("nom1prenom1@GMAIL.com"),Adresse.Parse("nomRue1,412,42"), new AbonLibre(Date.Parse("18/5/2018"),1,0)));
					
					ListAppel.add(listClient.get(4).AjouterAppel("0560626377", Date.Parse("19/5/2018"),Heure.Parse("4:43:1"), 1));
					
					ListAppel.add(listClient.get(4).AjouterAppel("0560626377", Date.Parse("19/5/2018"),Heure.Parse("19:43:24"), 2));
					 ListAppel.add(listClient.get(4).AjouterAppel("0560626377", Date.Parse("19/5/2018"),Heure.Parse("18:43:24"), 3));
					 ListAppel.add(listClient.get(4).AjouterAppel("0560626377", Date.Parse("19/5/2018"),Heure.Parse("16:43:24"), 4));
					   listClient.get(4).setA(ListAppel);
					   
				 } catch (IllegalArgumentException | NegativeException | TelephoneExceptions | DateException
						| AdresseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} 
		
			 //---------Ajouter Point de vente:
			ArrayList<PointDeVente > ptrVente = new ArrayList<PointDeVente>();
			try {
				ptrVente.add(new PointDeVente("NomAgence1", Adresse.Parse("ptrVentRue1,451,16"),Type.PRINCIPALE,"0244864501"));
			} catch (TelephoneExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ptrVente.add(new PointDeVente("NomAgence2", Adresse.Parse("ptrVentRue2,451,16"),Type.SCONDAIRE,"0244814501"));
			} catch (TelephoneExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ptrVente.add(new PointDeVente("NomAgence3", Adresse.Parse("ptrVentRue3,251,09"),Type.PRINCIPALE,"0222264501"));
			} catch (TelephoneExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ptrVente.add(new PointDeVente("NomAgence4", Adresse.Parse("ptrVentRue4,281,09"),Type.SCONDAIRE,"0244855501"));
			} catch (TelephoneExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //---------Ajouter operateur
			 op = new Operateur("WOOREDO",ptrVente, listClient);
			 return op;
		 
	 }

}
