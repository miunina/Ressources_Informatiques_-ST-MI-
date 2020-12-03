#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//*********************************************************************************************************
//******************************************** Declaration **********************************************
//*********************************************************************************************************
// ~~~~~~ Liste & Noeud ~~~~~~
typedef struct elementListe{
        int num_page;
      struct  elementListe *suivant;
}element;
typedef struct listeRepere{
        element *debut;
        element *fin;
        int taille;
 }liste;

 typedef struct elt{
 	char Mot[40];
 	liste *occurence;
 }elt;
 //~~~~~~~~~ Ãrbre ~~~~~~~~~
typedef struct Node {
	elt *info;
	 struct Node *succg;
	 struct Node *succd;
}Node;
typedef struct Node Node;
void initialiser(liste *occurence_mot){
//initialise une liste
occurence_mot->debut=NULL;
occurence_mot->fin=NULL;
occurence_mot->taille=0;
printf("\n\n\n\t ...initialisation ... \n\n ");
 }

int creation_tete( liste *liste,int page){//cree une tete de liste  et sa donnér
    element *Premier_element  ;

	  Premier_element=(element*)malloc(sizeof(element));

	  Premier_element->num_page=page;
      Premier_element->suivant=NULL;
      liste->debut=Premier_element;
      liste->fin=Premier_element;
      liste->taille=1;
    printf("...... l'element numero 1 etait creer avec succes ..... ! ");
    return 0;
}

int inser_liste_Trier( liste *occurence_Mot,int page){
	// variable locale
    element *nouveau_element;
    element *parcour;
//debut
   		 nouveau_element=(element*)malloc(sizeof(element));
        parcour=(element*)malloc(sizeof(element));

  			nouveau_element->num_page= page;
   if( nouveau_element->num_page < occurence_Mot->debut->num_page ) // nouveau_elt< tete (insertion entete )
 	 {
 	     printf("Creation tete");
	    nouveau_element->suivant = occurence_Mot->debut ;
   		occurence_Mot->debut=nouveau_element;
      }// if 1
   else if ( nouveau_element->num_page > occurence_Mot->fin->num_page ) // insertion Queue
	 {
	     printf("Creation Queue");
		 nouveau_element->suivant=NULL;
		 occurence_Mot->fin->suivant =nouveau_element; //dernier elt point vers nouv
		 occurence_Mot->fin=nouveau_element; // nouv devien le dernier
	  }// else if
	else
	{               parcour=occurence_Mot->debut;
		 while ( page >= parcour->suivant->num_page )
		 {// printf("parcour au debut !=null");
		    parcour=parcour->suivant;
       		//printf("parcour incrementer =null");
         }// on parcour jousqu'a le num page de : nouv_elt >parcour && nouv elt < parcour->suiv

		if( page==parcour->num_page ){
			printf("\n\t ***** Cette occurence exist deja ! ***** \n");
			return;
        }
        else{

		 nouveau_element->suivant=parcour->suivant; // chainage nouv_elt et parcour-> suiv
		 parcour->suivant=nouveau_element; // chainage parcour et nouv_elt

        }
	 }// else

   occurence_Mot->taille++;
   printf("...... l'element numero %d etait creer avec succes ..... ! \n\n",occurence_Mot->taille);
   getchar();
   
    return 0;
}
//supprimer un element
void suppression(liste *Liste, int nvNombre)
{element *aSupprimer;
	

		
		
		if(Liste == NULL || Liste->debut == NULL)//if 1  si liste vide
	/*Initialiser la liste la liste */
	{ 	printf("Liste vide !! \n");
		exit(EXIT_FAILURE);}//1 fin if

		if(Liste->debut != NULL && Liste->debut->num_page == nvNombre )
	{   
		aSupprimer = Liste->debut;
		Liste->debut=Liste->debut->suivant;
		free(aSupprimer);
		
	}
	
	else // else 1
	{element *Parcour = Liste->debut;element *q;q = Parcour;
		while(Parcour->num_page != nvNombre && Parcour != NULL )
		{
		  q= Parcour; 
		  Parcour = Parcour->suivant;	
		}
		if( Parcour == NULL)//2
		{  
		  printf("element innexistant!!\n");
		}//2fin if
		else//2
		{
			if(Parcour->num_page == nvNombre)//3
			{
				printf("Suppression !!!\n");
				
				aSupprimer = Parcour;
		        Parcour=Parcour->suivant;
		        q->suivant=Parcour;
		        free(aSupprimer);
			}/*supp*/
			else
			{
				printf("num innexistant !!!\n");
			}
}}getchar();}
//-------------------------------------

void creat_liste(elt *Element){
    int Page;
    int nombre_occurence;
   	// Le Mots
	printf("saisir le Mots : ");
   	scanf("%s",&Element->Mot);

	 printf("le num_page d'occurence du mot %s === >  ",Element->Mot);
     scanf("%d",&nombre_occurence);

	 //nombre_occurence=malloc(sizeof(liste));

	 initialiser(Element->occurence);

     if (nombre_occurence == 0 ) {
	  printf("Oops ! ce mots n'existe pas dans ce livre u_u \n");
	  }
     else // non vide
     	{  printf("\n la premiere occurence ===>  ");
		   	scanf("%d",&Page);
		   creation_tete(Element->occurence,Page);
		   while ((Element->occurence->taille ) < (nombre_occurence) )
		    {
		   		printf("\n saisir la page d'occurence Svp ! ====> ");
		   		scanf("%d",&Page);
	 			inser_liste_Trier(Element->occurence,Page);

			}
		 }


}

 elt *creat_liste_exemple(char mot[30], int occ1)
{   elt *Element= (elt *)malloc(sizeof(elt));
    strcpy(Element->Mot, mot);
    Element->occurence=(liste *)malloc(sizeof(liste));
    Element->occurence->taille = 1;
    initialiser(Element->occurence);
    creation_tete(Element->occurence, occ1);
    return Element;
}

Node *Cree_Noeud_Exemple(elt *inf)
  { Node *a= (Node*)malloc(sizeof(Node));
    a->info=inf;
    a->succg=NULL;
    a->succd=NULL;
  return a;
  }

void chainage(Node *Arbre, Node *fg, Node *fd)
 {
   (Arbre)->succg=fg;(Arbre)->succd=fd;
}

Node *Creat_Arbre_Exemple()
{


      Node *racine = Cree_Noeud_Exemple(creat_liste_exemple("Process", 12));
	  Node *childg1 = Cree_Noeud_Exemple(creat_liste_exemple("Hardwar", 13)); //fgfg
	  Node *childd2 = Cree_Noeud_Exemple(creat_liste_exemple("Softwar", 11)); //fdfg
	  Node *childg3 = Cree_Noeud_Exemple(creat_liste_exemple("Security", 9)); //fgfd
      Node *childd4 = Cree_Noeud_Exemple(creat_liste_exemple("switch", 8));  //fdfd
	  Node *childg5 = Cree_Noeud_Exemple(creat_liste_exemple("Rooter", 7));
	  Node *childd6 = Cree_Noeud_Exemple(creat_liste_exemple("WIFI", 10));
	  Node *childg7 = Cree_Noeud_Exemple(creat_liste_exemple("CodeMachine", 5));
	  Node *childd8 = Cree_Noeud_Exemple(creat_liste_exemple("Windows", 4));
	  Node *childg9 = Cree_Noeud_Exemple(creat_liste_exemple("DD", 5));

	  chainage(racine, childg1, childd2);
	  chainage((racine->succd), childg3, childd4);
	  chainage((racine->succg), childg5, childd6);
	  chainage((racine->succg->succg), childg7, childd8);
	  chainage((racine->succg->succd), childg9, NULL);
	  return racine;


}



//****************************************************************
//AFFICHAGE
void affichageElem(elt *y)
{			 element *temp;
	 //temp=(element*)malloc(sizeof(element ));
	// temp=y->occurence;
	 printf("Mot : %s",y->Mot);
      printf(" [");
	 for(temp=y->occurence->debut; temp->suivant!=NULL; temp=temp->suivant)
	 {
		 printf(" %d ,",temp->num_page);
	 }
		 printf(" %d ] ,",temp->num_page);
}
//**********************************************************

void horizontal(Node *tree, int level)
{
    int l = level;

    if (tree == NULL) return;
   horizontal(tree->succg, level + 1);
	          system("color d3");//sleep(1);
    while (l--) printf("      ");
    system("color e3");//sleep(1);

    printf("->");affichageElem(tree->info);printf("  \n\n  "); sleep(1);
     system("color 0f");

    horizontal(tree->succd, level + 1);


}

void AfficherAB(Node* AD, int largeur, int indice)// fils gauche fils droit de chaque pere
{//indice pour indiquer si c'est le fils droit a parcourir ou si c'est le fils gauche a parcourir
    int i;
    for (i=0; i < largeur-1; i++)
    {
        printf("        ");
    }
    if ((largeur!=0) && (indice == 0)) printf("|__FG_ ");
    if ((largeur!=0) && (indice == 1)) printf("|__FD_ ");
    affichageElem(AD->info);printf("\n");

    if (AD->succg!=NULL) AfficherAB((AD->succg), largeur + 1, 0);
    if (AD->succd!=NULL) AfficherAB((AD->succd), largeur + 1, 1);
}

void Libere_liste(elt **prem)
{
	element *n;
while((*prem)->occurence!=NULL){n=(*prem)->occurence->debut;
(*prem)->occurence->debut=(*prem)->occurence->debut->suivant;
free(n);
}
}

void Libere_Arbre(Node **p_racine)
{

Node *racine = *p_racine;                                  //  LIBERATION ESPACE MEMOIRE
if (racine != NULL)
{
Libere_Arbre(&racine->succg);
Libere_Arbre(&racine->succd);
Libere_liste(&racine->info);
free(racine);
}
*p_racine = NULL;

}
/*
int recherche(Node *a,char Word[20],int niv,int *niveau,Node **Noeud)//on recupere le noeud dans adr
{
	if (!Vide(a)) //parcours préfixé
	{
		if(strcmp(a->info->Mot,Word)==0)
		{
 			*niveau=niv;*Noeud=a;
 			return 0;
 		}
		if (!Feuille(a))
		{
			recherche(a->succd,Word,niv+1,niveau,Noeud) ;
			recherche(a->succd,Word,niv+1,niveau,Noeud) ;
		}
 	}
	else
		return 0 ;

}

void Recherche_Comp(Node *a)
{   char word[20];
	int niveau=0;
	Node *Noeud=NULL;

	printf("\n Saisir Le Mots Que vous Cherchez\t");
	scanf("%s",&word);
     if(Noeud!=NULL)//( recherche(a,word,0,&niveau,&Noeud) == 1  )
     { affichageElem(Noeud->info);
		printf("et le niveau est :%d\n",niveau);getchar();
	 }
	 else // ( recherche(a,word,0,&niveau,&Noeud) == 0  )
		printf("ce mot ");printf("%s",word);printf(" n'existe pas");getchar();
}
*/
/*
void Recherche_Comp(Node *a)
{   char word[20];
	int niveau=0;
	Node *Noeud=NULL;

	//Noeud=(Node*)malloc(sizeof(Node));

	printf("\n Saisir Le Mots Que vous Cherchez\t");
	scanf("%s",&word);

	 if( recherche(a,word,0,&niveau,&Noeud) == 1  )
     {
	    affichageElem(Noeud->info);
		printf("et le niveau est :%d\n",niveau);
	 }
	else
		printf("ce mot %s n'existe pas",word);
}

*/
/*
void afficher_recherche_prefixee (Node *a,char mot[20],int niv,int niveau,Node **adr)
{
     if(recherche( a,mot,0,&niveau,&adr)==1)
     {affichageElem(->info);
			printf("et le niveau est :%d\n",niv);}
else printf("ce mot %s n'existe pas",mot);

}
*/
Node *recherche(Node *a,char mot[20],int niv,int *niveau,Node **adr)//on recupere le noeud dans adr
{int var = 0;
if (!Vide(a) && var==0) //parcours préfixé
{	
	 if(strcmp(a->info->Mot,mot)==0)
	 { 		*niveau=niv;*adr=a;
			 var =1;
			 return(*adr);
	 }
	if (!Feuille(a))
	{ recherche(a->succg,mot,niv+1,niveau,adr) ;
	  recherche(a->succd,mot,niv+1,niveau,adr) ;
 	}
else
{
	return *adr;
}
}
}

void Recherche_Comp (Node *a,char mot[20],int niv,int niveau,Node **adr)
{
     if( recherche( a,mot,0,&niveau,adr)!=NULL)
     {affichageElem((*adr)->info);
			printf("et le niveau est :%d\n",niveau);getchar();}
else // ( recherche_prefixee( a,mot,0,&niveau,adr)==0)
  printf("ce mot %s n'existe pas",mot);getchar();

}

int Vide(Node *a)
{ int trouv=0;
if(a==NULL){ trouv=1;}
 return trouv;
}


 int Feuille(Node *a)
 { int trouv=0;
 if((a->succd==NULL)&&(a->succg==NULL)){ trouv=1;}
 	return trouv;
}




int main ()
{
	Node *My_Tree=NULL;
	Node *Noeud=NULL;
	char Mot[30];
	int niv=0; 
	int Niveau=0;
	int page;
    printf("\n1-***creation de l'arbre****\n");
    My_Tree=Creat_Arbre_Exemple();
    printf("\n3-***Affichage Largeur******\n");
    //horizontal(My_Tree, 0);
   // printf("\n4-***Affichage des fils g et fils droit");
 
    //Libere_Arbre(&My_Tree);
    AfficherAB(My_Tree, 0, 0);
printf("\n5-****Rechercher un mot****\n");
  printf("donnez le mot");
   scanf("%s",&Mot);
	Recherche_Comp(My_Tree,Mot,niv,Niveau,&Noeud);
	printf("\n6-***Ajouter un numero***\n");
	
    if(Noeud == NULL)
    {
    	printf("\n impossible d'inserer");
	}
	else
	{
		printf("\ndonnez une page:\t");scanf("%d", &page);
		inser_liste_Trier(Noeud->info->occurence, page);
		 printf("\n-***Affichage des fils g et fils droit apres insertion");
 
    //Libere_Arbre(&My_Tree);
    AfficherAB(My_Tree, 0, 0);
	}
		//Recherche_Comp(My_Tree,Mot,niv,Niveau,&Noeud);
	
	
	
	printf("\n7-***Supprimer un numero***\n");
	
    if(Noeud == NULL || Noeud->info->occurence->taille == 1)
    {
    	printf("\n impossible de supprimer");
	}
	else
	{
		printf("\ndonnez une page:\t");scanf("%d", &page);
		suppression(Noeud->info->occurence, page);
		printf("\n4-***Affichage des fils g et fils droit apres suppression");
 
    //Libere_Arbre(&My_Tree);
    AfficherAB(My_Tree, 0, 0);
	    

}
getchar();}
