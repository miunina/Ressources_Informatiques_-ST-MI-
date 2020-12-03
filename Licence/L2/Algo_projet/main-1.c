
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
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
Node *Supprimer_Racine(Node *R);
Node *SupprimerABR (Node* R, char x[30]);
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
    return 0;
}

void creat_liste(elt *Element){
    int Page;
    int nombre_occurence;
   	// Le Mots
	printf("saisir le Mots : ");
   	scanf("%s",&Element->Mot);

	 printf("le nombre d'occurence du mot %s === >  ",Element->Mot);
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
//*******************************************AFFICHAGE
void affichageElem(elt *y){
		
	 element *temp;
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
elt *creat_listes(char mot[30])
{   elt *Element= (elt *)malloc(sizeof(elt));int n,i,occ1;
    Element->occurence=(liste *)malloc(sizeof(liste));
    creat_liste(Element);
    return Element;
}

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

Node *Cree_Noeud_Exemple(elt *e)
{
	Node *s =(Node*)malloc(sizeof(Node)); 
	s->info = (elt*)malloc(sizeof(elt));
	s->info = e;
	s->succg=NULL;s->succd=NULL;return s;
}
Node *InsererABR (Node* R,elt *inf )
{
    if(R==NULL)
         R = Cree_Noeud_Exemple(inf);
    else
        if(strcmp(mot(R),inf->Mot)>0)
           aff_FG(R,InsererABR(FG(R),inf));
        else
            aff_FD(R,InsererABR(FD(R),inf));

        return R;
}

/*Node *ConstruireABR ()
{
    char x[30];
    int c;
    Node* R = NULL;
    do
    {
        printf("\n Donner un mot");
        scanf("%s", x);
        R = InsererABR(R, x);
        printf("\n Voulez vous ajouter une autre valeur? (O/N)");
        c = getchar();
        c =getchar();
    } while (c=='O'); //jusqu'à ce que exp égale à "O"
    return (R);
}*/
void Libere_liste(elt *prem)
{
	element *n;
while((prem)->occurence!=NULL){n=(prem)->occurence->debut;
(prem)->occurence->debut=(prem)->occurence->debut->suivant;
free(n);
}
}

void Libere_Arbre(Node *p_racine)
{

Node *racine = p_racine;                                  //  LIBERATION ESPACE MEMOIRE
if (racine != NULL)
{
Libere_Arbre(racine->succg);
Libere_Arbre(racine->succd);
Libere_liste(racine->info);
free(racine);
}
p_racine = NULL;

}

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
Node *Successeur (Node* R)
{
    R=FD(R);
    if(R!=NULL)
        while(FG(R)!=NULL)
          R=FG(R);
    return R;
}


Node *Supprimer_Racine(Node *R)
{
    Node *D,*G, *S;
    if(FG(R)==NULL)
        if(FD(R)==NULL){//feuille
        Libere_liste(R->info);
        free(R);
          return NULL;

          }
        else {//il ya FD
            D=FD(R);
            Libere_liste(R->info);
        free(R);
            return D;
          }
     else
      if(FD(R)==NULL){  //il ya FG
        G=FG(R);
        Libere_liste(R->info);
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

void chainage(Node *Arbre, Node *fg, Node *fd)
 {
   (Arbre)->succg=fg;(Arbre)->succd=fd;
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



/*
void Detruire (Node **R){

   Node *G,*D;

   if(*R!=NULL){
    G=FG(*R);
    D=FD(*R);
    libererNoeud(*R);
    Detruire(G);
    Detruire(D);
  }

}

*/
//afficher arbre postfixe 
/*Node *PrintPostfixe(Node *tree)
{Node * R;
	if(tree != NULL)//si non vide tree (tree != NULL)
	{/***
	si c est une feuille : 
	                        1- on affiche la valeur 
	                        2- On depile (on se trouve a l'instruction avc adresse @1) 
							       [valeur se trouvant au sommet qui n'est pas encoresera perdu?!]
	                        3- on empile @2 
							      [Heureusement avant de passer au prochain appel
								   on l'empile mais sera traiter dans ce 2eme appel=apres depilement (@2 est un affichage) ]
								   [le traitement continue tant que la pile systeme n'est pas vide
	                        4- appeler PrintPrefixe(right_child(tree))
	                        
	                        lors du 2eme appel : on refait les meme etape de sauvegarde et de verification
	                        sauf qu'ici l'adresse de retour diffère @2
	sinon :             1-On empile la valeur + l'adress de retour @1
	                        
	
	***/void infixe(Node *a, Node **R)
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
		   affichageElem(r->info);printf("lala2\n");
	  	} 
	 	 else{ 
		    aff_infixe(FG(r));
	   	    affichageElem(r->info);printf("lala2\n");
	     aff_infixe(FD(r));
	   }
     }
  }
/*	if(feuille(tree) == 1)//si c'esr  une feuille:
		{ affichageElem(tree->info);
		  printf("lala\n");
		  R=InsererABR(R, tree->info);
		}
		else
		{
			PrintPostfixe(FG(tree));//1 er appel sauvegarder @1
	/*	/*@1*/	/*PrintPostfixe(FD(tree));//2 eme appel sauvegardre @2(lors du retour :  )
		/*@2*/	/*affichageElem(tree->info);printf("lala2\n");
		         R=InsererABR(R, tree->info);
		}
	}
	
	return R;
}*/
void AfficherAB(Node* AD, int largeur, int indice)
{//indice pour indiquer si c'est le fils droit a parcourir ou si c'est le fils gauche a parcourir
    int i;
    for (i=0; i < largeur-1; i++)
    {
        printf("        ");
    }
    if ((largeur!=0) && (indice == 0)) printf("|__FG_ ");
    if ((largeur!=0) && (indice == 1)) printf("|__FD_ ");
    affichageElem(AD->info);printf("\n");

    if (FG(AD)!=NULL) AfficherAB(FG(AD), largeur + 1, 0);
    if (FD(AD)!=NULL) AfficherAB(FD(AD), largeur + 1, 1);
}

//**********************************************************************
//recherche
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
	{ recherche_Ord(a->succg,mot,niv+1,niveau,adr) ;
	  recherche_Ord(a->succd,mot,niv+1,niveau,adr) ;
 	}
else
{
	return *adr;
}
}
}

void Recherche_Comp_Ord (Node *a,char mot[20],int niv,int niveau,Node **adr)
{
     if( recherche_Ord( a,mot,0,&niveau,adr)!=NULL)
     {affichageElem((*adr)->info);
			printf("et le niveau est :%d\n",niveau);getchar();}
else // ( recherche_prefixee( a,mot,0,&niveau,adr)==0)
  printf("ce mot %s n'existe pas",mot);getchar();

}
int main()
{
	char Mot[30];
	Node *tree=NULL;Node *Ordtree=NULL;Node *Noeud=NULL;int niv=0;int Niveau=0;
	tree =Creat_Arbre_Exemple();
	getchar();
	 infixe(tree, &Ordtree);
		getchar();

	AfficherAB(Ordtree, 0, 0);	getchar();
	printf("\n****2-Affichage infixee*****:\n");
	aff_infixe(Ordtree);getchar();
	printf("\n****3-Recherche d'un mot et retourner son niveau:\n'");
	printf("\n5-****Rechercher un mot****\n");
    printf("donnez le mot");
    scanf("%s",&Mot);
    Recherche_Comp_Ord (tree,Mot,niv,Niveau,&Noeud);
}
