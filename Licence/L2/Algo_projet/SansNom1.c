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
	int Hauteur;
	 struct Node *succg;
	 struct Node *succd;
}Node;
typedef struct Node Node;
//-----------------------PRIMITIVES
Node *Supprimer_Racine(Node *R);
Node *SupprimerABR (Node* R, char x[30]);
int MAX(int x, int y)//retourne le aximum entre deux nombre
{
	if(x > y){return x;
	}
	return y;
}
int SIZE(Node *t)//si t == NULL retourn 0 sinon on retourne t->Hauteur
{
	if (t != NULL)
	{
		return t->Hauteur;
	}
	return 0;
}
//voir si un arbre est vide ou non
int Vide(Node *a)// 1 == vide
{ int trouv=0;
if(a==NULL){ trouv=1;}
 return trouv;
}

//voir si un noeud est une feuille ou non
 int Feuille(Node *a) // 1  == c'est une feuille
{ int trouv=0;
 if((a->succd==NULL)&&(a->succg==NULL)){ trouv=1;}
 	return trouv;
}
///----------------------liberation et suppression

//*************************************************************************************************************************
void initialiser(liste *occurence_mot){
//initialise une liste
occurence_mot->debut=NULL;
occurence_mot->fin=NULL;
occurence_mot->taille=0;
printf("\n\n\n\t ...initialisation ... \n\n ");
 }
//cree une tete de liste supposé non vide a partir de sa donné (numero de page)
int creation_tete( liste *liste,int page){
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

//fonction qui insere une valeur( page) dans une liste deja initialisé(non vide)
int inser_liste_Trier( liste *occurence_Mot,int page){//point d'entre tete : occurence_Mot->debut, queue : occurence_Mot->fin
	// variable locale
    element *nouveau_element;
    element *parcour;
//debut  -   creer un nouvel element
   		 nouveau_element=(element*)malloc(sizeof(element));
        parcour=(element*)malloc(sizeof(element));

  			nouveau_element->num_page= page;
   if( nouveau_element->num_page < occurence_Mot->debut->num_page ) // nouveau_elt< tete (insertion entete )
 	 {
 	     printf("Creation tete");
	    nouveau_element->suivant = occurence_Mot->debut ;//mettre a jour les chainages
   		occurence_Mot->debut=nouveau_element;//entre la tete et le nouvel element ,
      }// if 1  creation tete
   else if ( nouveau_element->num_page > occurence_Mot->fin->num_page ) // insertion Queue
	 {
	     printf("Creation Queue");
		 nouveau_element->suivant=NULL;
		 occurence_Mot->fin->suivant =nouveau_element; //dernier elt point vers nouv
		 occurence_Mot->fin=nouveau_element; // nouv devien le dernier
	  }// else if creation queue
	else
	{               parcour=occurence_Mot->debut;
		 while ( page >= parcour->suivant->num_page )
		 {//("parcour au debut !=null");
		    parcour=parcour->suivant;
       		//("parcour incrementer");
         }// on parcour jousqu'a le num page de : nouv_elt >parcour && nouv elt < parcour->suiv

		if( page==parcour->num_page ){
			printf("\n\t ***** Cette occurence exist deja ! ***** \n");
			return;
        }//ne pas inserer element existe deja
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

//supprimer un element (page) dans une liste trie
void suppression(liste *Liste, int nvNombre)
{element *aSupprimer;
		if(Liste == NULL || Liste->debut == NULL)//if 1  si liste vide
	{ 	printf("Liste vide !! \n");
		exit(EXIT_FAILURE);}//1 fin if sortir si liste est vide (erreur)

		if(Liste->debut != NULL && Liste->debut->num_page == nvNombre )
	{   //suppression en tete
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
		}//2fin if pas de suppression si c'est la fin
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
			}//pas de suppression si l'element a cherché est plu petit que ^Parour.num_Page
        }
	}getchar();}
//-------------------------------------
//LIBERATION DE L'ESPACE MEMOIRE DE LA LISTE DE L'ELEMENT D 'UN NOEUD
void Libere_liste(elt **prem)
{
	element *n;
while((*prem)->occurence!=NULL){n=(*prem)->occurence->debut;
(*prem)->occurence->debut=(*prem)->occurence->debut->suivant;
free(n);
}
}

//LIBERATION DE L ESPACE MEMOIRE DE L ELEMENT (D' UN NOEUD)
void detruire_elt(elt *t)
{
	if( t != NULL)
	{
		 Libere_liste(&t);
		 
		 free(t);
	}
}
//LIBERATION ESPACE MEMOIRE DE L' ARBRE
void Libere_Arbre(Node *p_racine)
{

Node *racine = p_racine;                                                          
if (racine != NULL)
{
Libere_Arbre(racine->succg);
Libere_Arbre(racine->succd);
detruire_elt(racine->info);
free(racine);
}
p_racine = NULL;

}
//creer une liste et l'affecté au champs Element->occurence 
// [ element deja initialisé (non vide_alloué) de type *elt]
void creat_liste(elt *Element){
    int Page;
    int nombre_occurence;
   	// Le Mot a donne :
	 printf("saisir le Mots : ");
   	scanf("%s",&Element->Mot);
     //le nombre d'apparition du mot donné a lire :
	 printf("le num_page d'occurence du mot %s === >  ",Element->Mot);
     scanf("%d",&nombre_occurence);
	 initialiser(Element->occurence);

     if (nombre_occurence == 0 ) {
	  printf("Oops ! ce mots n'existe pas dans ce livre u_u \n");
	  }
     else // non vide
     	{  printf("\n la premiere occurence ===>  ");
		   	scanf("%d",&Page);
		   creation_tete(Element->occurence,Page);//inserer la tete appart
		   while ((Element->occurence->taille ) < (nombre_occurence) )
		    {    
		   		printf("\n saisir la page d'occurence Svp ! ====> ");
		   		scanf("%d",&Page);
	 			inser_liste_Trier(Element->occurence,Page);
//inserer la page tant que le nombre d'occurence est superieur a la taille de la liste
			}
		 }
}

//fonction qui cree un element ( * elt) et lui affecte le mot
//donnee comme parametre au champ : Mot , occ1 pour creation de la tete
//du champ occurence
 elt *creat_liste_exemple(char mot[30], int occ1)
{   elt *Element= (elt *)malloc(sizeof(elt));
    strcpy(Element->Mot, mot);
    Element->occurence=(liste *)malloc(sizeof(liste));
    initialiser(Element->occurence);
    creation_tete(Element->occurence, occ1);
    return Element;
}//retourne l'element

//fonction qui prend l'element du noeud a cree pour le lui affecté
Node *Cree_Noeud_Exemple(elt *inf)
  { Node *a= (Node*)malloc(sizeof(Node));
    a->info=inf;
    a->succg=NULL;
    a->succd=NULL;
  return a;
  }

//chainage fonction utilisé dans la fonction Creat_Arbre_Exemple, 
void chainage(Node *Arbre, Node *fg, Node *fd)
 {
   (Arbre)->succg=fg;(Arbre)->succd=fd;
}

//pour evité la saisit au clavier on a donne cette fonction qui cree par defaut 10 noeuds
//fait le chainage entre eux puis retourne la racine qui doit etre recupere lors de l'appel 
//de cette fonction
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
//AFFICHAGE de l'element d'un noeud ; afficher la liste des numero de page d'un mot
void affichageElem(elt *y)
{			 element *temp;//pour parcourir la liste
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
	          system("color d3");
    while (l--) printf("      ");
    system("color e3");

    printf("->");affichageElem(tree->info);printf("  \n\n  "); 
    system("color 0f");

    horizontal(tree->succd, level + 1);


}

//procedure affiche fils gauche fils droit de chaque pere
void AfficherAB(Node* AD, int largeur, int indice)
{//indice pour indiquer si c'est 1 alors c'est le fils droit a parcourir 
//ou si c'est  0 alors c'est le fils gauche a parcourir
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

//recherche un mot a partir de a , niv=0, niveau = 0, adr = nil
//on recupere le noued dans adr  
Node *recherche(Node *a,char mot[20],int niv,int *niveau,Node **adr)//on recupere le noeud dans adr
{int var = 0;
if (!Vide(a) && var==0) 
{	
	 if(strcmp(a->info->Mot,mot)==0)
	 { 		*niveau=niv;*adr=a;
			 var =1;
			 return(*adr);
	 }
	if (!Feuille(a))
	{ recherche(a->succg,mot,niv+1,niveau,adr) ;//sauvegarder l'adress de retour (@1) avant l'appel
	  /*@a1*/recherche(a->succd,mot,niv+1,niveau,adr) ;//pas de sauvegarde d'adresse (a droite)
 	}
else
{//si c'est une feuille
	return *adr;
}
}//sinon on se retrouve a l'adresse de retour @1 apres depilement
}

//pour la question de recherche --  on perçoit le mot trouve et son niveau
//sinon si le noeud a retourner lors de l'appel de recherche == le mot n'existe pas
void Recherche_Comp (Node *a,int niv,int niveau,Node **adr)
{
char mot[30];
printf("\n5-****Rechercher un mot****\n");
    printf("donnez le mot");
    scanf("%s",&mot);
     if( recherche( a,mot,0,&niveau,adr)!=NULL)
     {affichageElem((*adr)->info);
			printf("et le niveau est :%d\n",niveau);getchar();}
else // ( recherche_prefixee( a,mot,0,&niveau,adr)==0)
  printf("ce mot %s n'existe pas",mot);getchar();

}

//supprime un numero de page d'un mot si il existe dans l'arbre 
//et si ce n'est pas le seul element a supprimmé
void Suppression_Comp (Node *a,int niv,int niveau,Node **adr)
{  int page;char mot[30];
    printf("\n7-***Supprimer un numero***\n");
    printf("donnez le mot");
    scanf("%s",&mot);
	    if( recherche( a,mot,0,&niveau,adr)!=NULL)
     {   affichageElem((*adr)->info);
		printf("et le niveau est :%d\n",niveau);
		printf("Sppression : \n");
	    if((*adr) == NULL ||(*adr)->info->occurence->taille == 1)
        {
    	printf("\n impossible de supprimer");
	    }
       else
	   {
		printf("\ndonnez une page:\t");scanf("%d", &page);
		suppression((*adr)->info->occurence, page);
		printf("\n4-***Affichage des fils g et fils droit apres suppression");
        AfficherAB(a, 0, 0);
	    getchar();
	    }getchar();
	}
else 
  printf("ce mot %s n'existe pas",mot);getchar();
}

//insertion d'un numero d'un mot donne supposant qu'il existe
void Insertion_Comp(Node *a,int niv,int niveau,Node *adr)
{int page;char mot[30];
		printf("\n6-***Ajouter un numero***\n");
	 printf("donnez le mot");
    scanf("%s", mot);
	    
        
    if(recherche( a,mot,0,&niveau,&adr)==NULL)
    {
    	printf("\n impossible d'inserer ");
	}
	else
	{
		printf("\ndonnez une page:\n");
		scanf("%d", &page);printf("%d", page);
		inser_liste_Trier((adr)->info->occurence, page);getchar();
	    printf("\n-***Affichage des fils g et fils droit apres insertion");
        AfficherAB(a, 0, 0);getchar();
	}
}
//*---------------------------------------------------FIN PART 1---------------------------------------------------------**//
//*------------------------------------------------DEBUT PART 2---------------------------------------------------------**//
//****************PRIMITIVES ARBRES BINAIRE 

//*****************************************************************************************Caracteristique:::
char *mot(Node *R)
{
    return R->info->Mot;
}

Node *FG(Node *R)
{
    return R->succg;
}

Node *FD(Node *R)
{
    return R->succd;
}

void    aff_FG(Node *R,  Node *Q)
{
    R->succg=Q;
}

void    aff_FD(Node *R,  Node *Q)
{
    R->succd=Q;
}
elt *Info(elt *v)
{
	return v;
}
void    aff_Info(Node *R, elt *v)
{
    R->info=v;
}
int feuille(Node *a)
{if(FD(a)==NULL && FG(a)==NULL)
return 1;else return 0;
}
//----------------------------------------
//INSERTION :
void InsererNode(Node *R, elt *inf)
{
	Node *P;
	if(strcmp((R)->info->Mot,inf->Mot)==0)
	{
		printf("la valeur existe deja\n");
	}
	else 
	{
		if(strcmp((R)->info->Mot,inf->Mot)>0)
		{
			if(Vide(FG(R)))
			{
				P = Cree_Noeud_Exemple(inf);
				R->succg = P;
			}
			else
			{
				InsererNode(FG(R), inf);
			}
		}
		else
		{
			if(Vide(FD(R)))
			{
				P = Cree_Noeud_Exemple(inf);
				R->succd = P;
			}
			else
			{
				InsererNode(FD(R), inf);
			}
		}
	}
}
Node *InsererABR (Node* R,elt *inf )
{
    if(R==NULL)
         R = Cree_Noeud_Exemple(inf);
    else
        if(strcmp((R)->info->Mot,inf->Mot)>0)
           {
           	aff_FG(R,InsererABR(FG(R),inf));
		   }
        else if(strcmp((R)->info->Mot,inf->Mot)<0)
            {
            	aff_FD(R,InsererABR(FD(R),inf));
			}
			else 
			{
				printf("\nla valeur existe deja\n");
			}

        return R;
}
void infixe(Node *a, Node **R)
{	
  	if(a != NULL){
  		if(feuille(a)==1){ 
		   *R=InsererABR(*R, a->info);
	  	} 
	 	 else{ 
		    infixe(a->succg, R);
	   	    *R=InsererABR(*R, a->info);
	     infixe(a->succd, R);
	   }
     }
    
  }
  void aff_infixe(Node *r)
  {
  		if(r != NULL){
  		if(feuille(r)==1){ 
		   affichageElem(r->info);printf("\n");
	  	} 
	 	 else{ 
		    aff_infixe(FG(r));
	   	    affichageElem(r->info);printf("\n");
	     aff_infixe(FD(r));
	   }
     }
  }

//CALCULER HAUTEUR DE L'ARBRE
// calculer la hauteur des noeuds du t_arbre a
void calculer_hauteur(Node *a)
{
    if( a != NULL )
    {
        if( FG(a) == NULL )
        {
            if( FD(a) == NULL )
                a->Hauteur = 0;
            else
            {
                calculer_hauteur( FD(a) );
                a->Hauteur = FD(a)->Hauteur + 1;
            }
        }
        else if(FD(a) == NULL )
        {
            if( FG(a) == NULL )
                a->Hauteur = 0;
            else
            {
                calculer_hauteur( FG(a) );
                a->Hauteur = FG(a)->Hauteur + 1;
            }
        }
        else
        {
            calculer_hauteur( FD(a) );
            calculer_hauteur( FG(a) );
            a->Hauteur = MAX( FD(a)->Hauteur, FG(a)->Hauteur ) + 1;
        }
    }
}
//SUCCESSEUR :
Node *Successeur (Node* R)
{
    R=FD(R);
    if(R!=NULL)
        while(FG(R)!=NULL)
          R=FG(R);
    return R;
}
//RECHERCHE:
Node *RechercherABR (Node* R, char x[30])
{
    if(R==NULL)
        return NULL;
    else
        if(strcmp(mot(R),x)==0)
            return R;
        else if(strcmp(mot(R),x)>0)
          return RechercherABR((R),x);
        else
            return RechercherABR((R),x);

}
//SUPPRESSION:
Node *SupprimerABR (Node* R, char x[30])
{
    if(R==NULL)
        return NULL;
    else
    if(strcmp(mot(R),x)>0){
        aff_FG(R,SupprimerABR(FG(R),x));
        return R;
    }

    else if(strcmp(mot(R),x)<0){
           aff_FD(R,SupprimerABR(FD(R),x));
           return R;
         }

         else //info(R)=x
            return (Supprimer_Racine(R));
}
Node *Supprimer_Racine(Node *R)
{
    Node *D,*G, *S;
    if(FG(R)==NULL)
        if(FD(R)==NULL){//feuille
        detruire_elt(R->info);
        free(R);
        return NULL;

          }
        else {//il ya FD
            D=FD(R);
            detruire_elt(R->info);
            free(R);
            return D;
          }
     else
      if(FD(R)==NULL){  //il ya FG
        G=FG(R);
        detruire_elt(R->info);
        free(R);
        return G;
     }

     else{
        S=Successeur(R);
        aff_Info(R,S->info);
        aff_FD(R,SupprimerABR(FD(R),(S)->info->Mot));
        return R;
     }

}
// suppression - cette fonction renvoie le nouvel arbre 
Node *supprimer_arbre(Node *a, elt *v)
{
    Node *r = NULL;
    Node *o = NULL;
    Node *p = NULL;
    Node *i = NULL;
    r = a;
    i = p;
 
    if( r == NULL )
        return NULL;
 
    switch( strcmp( r->info->Mot, v->Mot ) )
    {
        case 1:
            p->succd = supprimer_arbre( FD(r), v );
            break;
        case -1:
          p->succg = supprimer_arbre( FG(r), v );
            break;
        case 0:
            if(FG(p) == NULL )
                r = FD(r);
            else if( FD(p) == NULL )
                r = FG(r);
            else
            {
                while( i != NULL )
                {
                    p = i;
                    i = FG(i);
                }
               (p)->succg = FG(r);
                detruire_elt( r->info);
                o =FD(r);
                free( r );
                r = o;
            }
            break;
    }
    return r;
}

//INSERTION D'un MOT DONNEE

//****************arbre binaire  ===>   Arbre binaire de recherche


//****************equilibrage::::arbre binaire de recherche ===> arbre binaire de recherche equilibré  (AVL)
/* lors d'un parcours en profondeur, l'ordre de visite des feuilles est le même qu'avant l'opération==> la rotation concerve
l'ordre des feuilles( ne change pas)*/
//losrqu'il y a un desequilibrage: les hauteurs
//des sous-arbres gauche et droit
//diffèrent plus 1.
/*une rotation a droite aboutit à un mouvement dans le sens  des aiguilles d'une montre*/
Node *rotation_droite(Node *y)
{
 Node* a = NULL;
 
    if (y != NULL && y->succg != NULL)
    {
        a = y->succg;
        y->succg = a->succd;
        a->succd = y;
 
        a->succd->Hauteur = MAX(SIZE(a->succd->succg), SIZE(a->succd->succd))+1;
		//calcule des hauteur du node pere, racine et les fils
        if( a->succg != NULL )
            a->succg->Hauteur = MAX(SIZE(a->succg->succg), SIZE(a->succg->succd))+1;
        a->Hauteur = MAX(SIZE(a->succg), SIZE(a->succd))+1;
        return a;//a devient la nouvelle racine 
    }
    else
        return y;
}
 /* lors d'un parcours en profondeur, l'ordre de visite des feuilles est le même qu'avant l'opération*/
 /*une rotation a gauche aboutit à un mouvement dans le sens  inverse des aiguilles d'une montre*/
Node *rotation_gauche(Node *x)
{
    Node* a = NULL;
 
    if (x != NULL && x->succd != NULL)
    {
        a = x->succd;
        x->succd = a->succg;
        a->succg = x;
 
        if( a->succd != NULL )
            //calcule des hauteur du node pere, racine et les fils
            a->succd->Hauteur = MAX(SIZE(a->succd->succg), SIZE(a->succd->succd))+1;
            a->succg->Hauteur = MAX(SIZE(a->succg->succg), SIZE(a->succg->succd))+1;
            a->Hauteur = MAX(SIZE(a->succg), SIZE(a->succd))+1;
        return a;//devient la nouvelle racine
    }
    else
        return x;
}
 //appel des fonctions de rotations droite et gauche afin de 
 //réduir la hauteur d'un arbre en faisant descendre les petits sous-arbres et remonter les grands
Node *equilibrer_arbre(Node *a)
{
    int hd = 0;
    int hp = 0;
    if( a == NULL )
        return NULL;
 
    hd = SIZE(a->succg) - SIZE(a->succd);
 
    while( ( hd < -1 || hd > 1 ) && hd != hp && hd != ( - hp ) )
    {
        hp = hd;
        if( hd > 1 )
            a = rotation_droite(a);
        else
            a = rotation_gauche(a);
        a->succg = equilibrer_arbre(a->succg);
        a->succd = equilibrer_arbre(a->succd);
 
        hd = SIZE(a->succg) - SIZE(a->succd);
    }
 
    if( a->succg == NULL && SIZE(a->succd) > 1 )
        a->succd = equilibrer_arbre( a->succd );
 
    if( a->succd == NULL && SIZE(a->succg) > 1 )
        a->succg = equilibrer_arbre( a->succg );
 
    a->Hauteur = MAX(SIZE(a->succg), SIZE(a->succd))+1;
 
    return a;
}
//**********************************************************************
Node *recherche_Ord(Node *a,char mot[20],int niv,int *niveau,Node **adr)//on recupere le noeud dans adr
{int var = 0;
if (a !=NULL && var==0) //parcours préfixé
{	
	 if(strcmp(a->info->Mot,mot)==0)
	 { 		*niveau=niv;*adr=a;
			 var =1;
			 return(*adr);
	 }
	if (feuille(a) != 1)
	{ 
	  if(strcmp((a)->info->Mot,mot)>0)
	  recherche_Ord(a->succg,mot,niv+1,niveau,adr) ;
	  else
	  recherche_Ord(a->succd,mot,niv+1,niveau,adr) ;
 	}
else
{
	return *adr;
}
}
}
void Recherche_Comp_Ord (Node *a,int niv,int niveau,Node **adr)
{char mot[30];
printf("donnez le mot\n");
    scanf("%s",mot);
     if( recherche_Ord( a,mot,0,&niveau,adr)!=NULL)
     {affichageElem((*adr)->info);
			printf("et le niveau est :%d\n",niveau);getchar();}
else // ( recherche_prefixee( a,mot,0,&niveau,adr)==0)
  printf("ce mot %s n'existe pas",mot);getchar();

}
void Inserer_Comp_Ord(Node *a,int niv,int niveau,Node **adr)
{int num_p;char mot[30];
    printf("mot:\n");scanf("%s", mot);
    printf("\nnum page:\n");scanf("%d",&num_p);
    
	if( (recherche_Ord( a,mot,niv,&niveau,adr)) !=NULL)
    {    
    
	inser_liste_Trier((*adr)->info->occurence, num_p);getchar();
	printf("\n***apres insertion du numero de page\n");aff_infixe(a);getchar();
    }
	else
	{   
		elt *N=NULL;
	    N = (creat_liste_exemple(mot, num_p));
	   
		InsererNode(a,N);
		printf("+");
		a = equilibrer_arbre(a);getchar();printf("+");
		printf("\n***apres insertion\n");printf("+");
		aff_infixe(a);printf("+");
		//detruire_elt(N);
		getchar();
	}
}

//*---------------------------------------------------FIN PART 2--------------------------------------------------------**//

int main ()
{
	Node *tree=NULL;
	Node *Noeud=NULL;
	char Mot[30];
	int niv=0; 
	int Niveau=0;
	int page;
    printf("\n1-***creation de l'arbre****\n");
    if(tree != NULL)
    {
       Libere_Arbre(tree);	
	}
    

	/*niv=0;Niveau=0;Noeud=NULL;Recherche_Comp(tree,niv,Niveau,&Noeud);
    niv=0;Niveau=0;Noeud=NULL;Insertion_Comp(tree,niv,Niveau,Noeud);
    niv=0;Niveau=0;Noeud=NULL;Suppression_Comp (tree,niv,Niveau,&Noeud);*/
	    
	Node *Ordtree=NULL;//Node *Noeud=NULL;int niv=0;int Niveau=0;
	tree=Creat_Arbre_Exemple();
    printf("\n3-***Affichage Largeur******\n");
    AfficherAB(tree, 0, 0);
	printf("\n\n\n 1-l'arbre binaire equilibré crée a partir de l'ancien arbre:\n\n");
	/*if(tree != NULL)
	{ 
	  Libere_Arbre(tree);
	}
	if(Ordtree != NULL)
	{
		Libere_Arbre(Ordtree);
	}*/
	//tree =Creat_Arbre_Exemple();
	infixe(tree, &Ordtree);
	AfficherAB(Ordtree, 0, 0);getchar();
	Ordtree = equilibrer_arbre(Ordtree);getchar();// aff_infixe(Ordtree);getchar();
	AfficherAB(Ordtree, 0, 0);getchar();
	

	printf("\n\n\n****2-Affichage infixee*****:\n\n");
    aff_infixe(Ordtree);getchar();
	printf("\n****3-Recherche d'un mot et retourner son niveau:\n'");
	printf("\n5-****Rechercher un mot****\n");
      niv=0;Niveau=0;Noeud=NULL;
	  Recherche_Comp_Ord (Ordtree,niv,Niveau,&Noeud);
    getchar();
    //*******************************************************************************
  	printf("\n6-****Ajouter un mot avec le numero de page dont il apparait**\n");
	Noeud = NULL;Niveau =0;niv =0;

     Inserer_Comp_Ord( Ordtree, niv, Niveau, &Noeud);

getchar();}
