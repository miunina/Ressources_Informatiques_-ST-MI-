#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#include <time.h>
#include <math.h>
#define tmax 50
#define selected_color 15
#define selected_background 5
#define not_selected_color 15
#define not_selected_background 0
int wherex()
{
        CONSOLE_SCREEN_BUFFER_INFO coninfo;

        GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &coninfo);
        return coninfo.dwCursorPosition.X+1;
}
/*-----------------------------------------------------------------------------------------------------------------------------*/
int wherey()
{
        CONSOLE_SCREEN_BUFFER_INFO coninfo;

        GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &coninfo);
        return coninfo.dwCursorPosition.Y;
}
void gotoxy(int xpos, int ypos)
{
        COORD scrn;
        HANDLE hOuput = GetStdHandle(STD_OUTPUT_HANDLE);

        scrn.X = xpos-1;
        scrn.Y = ypos;
        SetConsoleCursorPosition(hOuput, scrn);
}
void textcolor(unsigned int color)
{
    if (color >15 || color <=0)
    {
        HANDLE hcon = GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(hcon,15);

    }
    else
    {
        HANDLE hcon = GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(hcon,color);
    }
}
/*-----------------------------------------------------------------------------------------------------------------------------*/
void textbackground(int bcolor)
{
     WORD wColor;
     //We will need this handle to get the current background attribute
     HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
     CONSOLE_SCREEN_BUFFER_INFO csbi;

     //We use csbi for the wAttributes word.
     if(GetConsoleScreenBufferInfo(hStdOut, &csbi))
     {
        //make a color form the current backgound and our forground color
          wColor = (csbi.wAttributes & 0xF) | ((bcolor  << 4 ) & 0xF0);
          SetConsoleTextAttribute(hStdOut, wColor);

     }
}
/*------------------------------------------------------------------------------------------------------------------------------*/
void pied_de_page ()
{
    int i ;
    gotoxy(1,42);
    for (i=1;i<=110;i++) printf("%c",196);
    gotoxy(3,43);
    printf("AKLI Yassamine   &   MEDDAS Nesrine ");
    gotoxy(3,45);
    printf("SECTION A                         ");
    gotoxy(3,47);
    printf("ANNEE UNIVERSITAIRE :       2017/2018\n\n");
    gotoxy(1,48);
    for (i=1;i<=110;i++) printf("%c",196);
}
/*------------------------------------------------------------------------------------------------------------------------------------*/
void color(int couleurDuTexte,int couleurDeFond) // fonction d'affichage de couleurs
{
        HANDLE H=GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(H,couleurDeFond*16+couleurDuTexte);
}
void cputsxy (int x, int y, char * str)
{
    gotoxy (x, y);
    printf ("%s",str);}
void cadre ( int l , int L , int x , int y ) // Dessine un cadre de longeur == L et de largeur == l à partir du point M(x,y) de la console
{
    int i ;

    gotoxy(x,y);
    printf("%c",218);
    gotoxy(x,y + L);
    printf("%c",192);
    gotoxy(x+l,y);
    printf("%c",191);
    gotoxy(x+l,y+L);
    printf("%c",217);
    for (i=1 ; i <= l-1 ; i++  )
    {
        gotoxy(x+i,y);
        printf("%c",196);
        gotoxy(x+i,y+L);
        printf("%c",196);
    }
    for (i=1 ; i <= L-1; i++ )
    {
        gotoxy(x,y+i);
        printf("%c",179);
        gotoxy(x+l,y+i);
        printf("%c",179);
    }

}
void quitter() /**Graphisme de fin**/
{

    system("cls");
    system ("mode 90,40");
    color(15,0);
    gotoxy(1,10);
    printf("                ######     ######                             ###   \n");
    Sleep(150);
    printf("                   ####     #####                             ### \n ");
    Sleep(150);
    printf("                  #####    #####                             ### \n ");
    Sleep(150);color(9,0);
    printf("                  #####    #####                                  \n ");
    Sleep(150);
    printf("                  ######   #####     ####  ########  #####   ### \n");
    Sleep(150);
    printf("                   # ####   # ###   ####### #######  #######  ### \n ");
    Sleep(150);color(15,0);
    printf("                  #  #### ## ###   ###  ##  ####### ###   ## ### \n ");
    Sleep(150);
    printf("                  #  ######  ###   ###  ### ####    ###   ## ### \n");
    Sleep(150);
    printf("                   #  ######  ###   ######## ####    ###      ###  \n  ");
    Sleep(150);color(9,0);
    printf("                 #   ####   ###   ###      ###     ###      ###  \n");
    Sleep(150);
    printf("                   #   ####   ###   ###      ###     ####     ###  \n  ");
    Sleep(150);
    printf("                 #    ##    ###   ####  ## ###     ####  ## ###  \n");
    Sleep(150); color (9,0);
    printf("                   #    ##    ####   ######  ####     ####### ####  \n  ");
    Sleep(150);
    printf("              #####   #  #######    ####   #####    ###### ###### \n");
    color(9,0);
    gotoxy (30,30);
    printf (" Thank you for using our pragram");
    gotoxy(30,32);
    printf ("  We hope to see you soon ^_^ \n\n");
    color(15,0);
    Sleep(3000);

}
/*-----------------------------------------------------------------------------------------------------------------------*/

void affich_menu()
{
    system ("cls");
    system("cls");
            color(7,15);
            printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c\n",219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219);
            printf("%c%c                                                                                                         %c%c\n",219,219,219,219,219,219,219,219);
            printf("%c%c                                           MENU  PRICIPAL                                                %c%c\n",219,219,219,219,219,219,219,219);
            printf("%c%c                                                                                                         %c%c\n",219,219,219,219,219,219,219,219);
            printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c\n",219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219,219);

}int menu(int max,...)
{
   int choi,a,i,b,d,y;
   char p[tmax];
   char **choix=NULL;
   choix=malloc(max*sizeof(p));
   va_list marker;
   va_start( marker,max );     /* Initialize variable arguments. */
   for (i=0;i<max;i++)
   {
      choix[i] = va_arg( marker,char*);
   }
    va_end( marker );
    d=wherey();
    y=d;
    textcolor (selected_color);
    textbackground (selected_background);
    printf("%s\n",choix[0]);
    textbackground (not_selected_background);
    textcolor(not_selected_color);
    for (i=1;i<max;i++)
    {
        printf("%s\n",choix[i]);
    }
    abbbbb:
    while((a=getch())==224)
    {
        b=getch();
        if(b==80 && y<d+max-1)
        {
            gotoxy(1,y);
            textcolor(not_selected_color);
            i=y-d;
            textbackground (not_selected_background);
            printf("%s",choix[i]);
            y++;
            textcolor (selected_color);
            gotoxy(1,y);
            textbackground (selected_background);
            printf("%s",choix[i+1]);
        }
        if(b==72 && y>d)
        {
            gotoxy(1,y);
            textcolor(not_selected_color);
            i=y-d;
            textbackground (not_selected_background);
            printf("%s",choix[i]);
            y--;
            textcolor (selected_color);
            gotoxy(1,y);
            textbackground (selected_background);
            printf("%s",choix[i-1]);
        }


        }
        if (a!=13)goto abbbbb;

    choi=y-d;
    textbackground (not_selected_background);
    textcolor(not_selected_color);
    gotoxy(1,d+4);
    return choi+1;
}
//-----------------------------------------------------fonctions de TRI ----------------------------------------
// Procedure de saisis
void saisir(int *tab,int taille)
{   int i;	printf("\n                         Remplissage des elements\n");
   for (i=0;i<taille;i++)
   {printf("\t");printf("t[%d] : ",i+1);scanf("%d",&tab[i]);}
}
// Procedure d'affichage
void affiche(int *tab,int taille)
{  int i;color(15,0);	printf("\n                                   \n\t");
    for (i=0;i<taille;i++)
     {color(0,6);
    printf ("%c ",179);
    color(0,6);
	 printf(" %d ",tab[i]);}color(15,0);
}
//**-------------------------------------------------------------------

//**------------------------------------------------------------------
//************tri par selection par ordre croissant
int *tri_selection1(int *tab, int N)
{   int I,J,AIDE,PMIN;int nbPerm=0;int nbComp=0;int *A;
A= malloc(N *sizeof(int));
   
    //remplissage
    for(I=0; I<N; I++)
    {
    	A[I]=tab[I];
	}
//tri
 for (I=0; I<N-1; I++)
     {  
      PMIN=I;
      for (J=I+1; J<N; J++)// liste non-triée : (Ai+1, A2, ... , An)  
       {            if (A[J]<A[PMIN])
	                {// Aj est le nouveau minimum partiel 
		               PMIN=J;
                      //on échange les positions de Ai et de Aj 
                      AIDE=A[I];
                      A[I]=A[PMIN];
                      A[PMIN]=AIDE;	 PMIN=I;
	                  affiche(A, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d>nouveau max->On permute", A[J],A[PMIN], I+1, N, J);nbPerm++;
	   }else{affiche(A, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->On laisse", A[J],A[PMIN], I+1, N, J);           
	   
	   }nbComp++;//incrementer le nombre de comparaison (condition))  
	   }
      
	  }
	  
	  printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Vecteur apres tri:\n", nbPerm, nbComp);
      affiche(A, N);//Affihage apres le tri
    return A; // free(A);//Liberation de l'espace memoire
}
//*****************tri par selection par ordre decroissant
int *tri_selection2(int *tab, int N)
{   int I,J,AIDE,PMAX;int nbPerm=0;int nbComp=0;int *A;
A= malloc(N *sizeof(int));
    
    //remplissage
    for(I=0; I<N; I++)
    {
    	A[I]=tab[I];
	}
//tri
 for (I=0; I<N-1; I++)
     {  
      PMAX=I;
      for (J=I+1; J<N; J++)// liste non-triée : (Ai+1, A2, ... , An)  
       {            if (A[J]>A[PMAX])
	                {// Aj est le nouveau MAIMUM partiel 
		               PMAX=J;
                      //on échange les positions de Ai et de Aj 
                      AIDE=A[I];
                      A[I]=A[PMAX];
                      A[PMAX]=AIDE;	 PMAX=I;
	                  affiche(A, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->nouveau max->On permute", A[J],A[PMAX], I+1, N, J);nbPerm++;
	   }else{affiche(A, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->On laisse", A[J],A[PMAX], I+1, N, J);//incrementer le nombre de comparaison (condition))             
	   
	   }nbComp++;//incrementer le nombre de comparaison (condition))  
	   }
      
	  }
	  
	  printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Vecteur apres tri:\n", nbPerm, nbComp);
      affiche(A, N);//Affihage apres le tri
    return A;  //free(A);//Liberation de l'espace memoire
}
//**----------------------------------------------------------------------

//**----------------------------------------------------------------------
//************************************************************************Vecteur********************************************************************

//************************************TRI BULLES
int *tribullec(int *tabT, int taille)//fonction pour t a bulle d'un tableau a une dimension de taille variable par ordre croissant
{int *tabp;
tabp= malloc(taille *sizeof(int));int a=0;int i;int etape=0;//etape pour compter le nombre de permutation
int n=taille;int nbCompare=0;//nbCompare pour compter le nombre de comparaison//variable de travail
    int tab_en_ordre = 0;
  //remplissage (qu'on travaillera dessus)
  for(i=0; i<n; i++)
  {
  	tabp[i]=tabT[i];
  }    
    while(!tab_en_ordre)//tant qu'il reste des elements a permuter on continue
    {        tab_en_ordre = 1;
        for( i=0 ; i < taille-1 ; i++)//parcourir le tableau et conparer l'element tab[i] a tab[i+1]
        {           if(tabp[i] > tabp[i+1])
            {          a=tabp[i];//permuter
		              tabp[i]=tabp[i+1];//permuter
			           tabp[i+1]=a;//permuter
                  affiche(tabp,n);printf(" // On compare %d et %d :On inverse Etape %d:\n",tabp[i],tabp[i+1],etape);//afficher
				  etape++;//incrementation _ compter le nombre de permutation
                  tab_en_ordre = 0;
            }
			else { affiche(tabp,n);printf(" // On compare %d et %d :On laisse\n",tabp[i],tabp[i+1]);}
        nbCompare++;//incrementation _ compter le nombre de comparaison
    }taille--;
    
}printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Vecteur apres tri:\n", etape, nbCompare);
    affiche(tabp, n);
    //free(tabp);}
return tabp;}
//***************************************
int *tribulled(int *tabT, int taille)//fonction pour t a bulle d'un tableau a une dimension de taille variable par ordre decroissant
{int *tabp;
tabp= malloc(taille *sizeof(int));int a=0;int i;int etape=0;//etape pour compter le nombre de permutation
int n=taille;int nbCompare=0;//nbCompare pour compter le nombre de comparaison//variable de travail
    int tab_en_ordre = 0;
  //remplissage (qu'on travaillera dessus)
  for(i=0; i<n; i++)
  {
  	tabp[i]=tabT[i];
  }    
    while(!tab_en_ordre)//tant qu'il reste des elements a permuter on continue
    {        tab_en_ordre = 1;
        for( i=0 ; i < taille-1 ; i++)//parcourir le tableau et conparer l'element tab[i] a tab[i+1]
        {           if(tabp[i] < tabp[i+1])
            {          a=tabp[i];//permuter
		              tabp[i]=tabp[i+1];//permuter
			           tabp[i+1]=a;//permuter
                  affiche(tabp,n);printf(" // On compare %d et %d :On inverse Etape %d:\n",tabp[i],tabp[i+1],etape);//afficher
				  etape++;//incrementation _ compter le nombre de permutation
                  tab_en_ordre = 0;
            }
			else { affiche(tabp,n);printf(" // On compare %d et %d :On laisse\n",tabp[i],tabp[i+1]);}
        nbCompare++;//incrementation _ compter le nombre de comparaison
    }taille--;
    
}printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Vecteur apres tri:\n", etape, nbCompare);
    affiche(tabp, n);
    return tabp;}//free(tabp);}	
//**************************************TRI INSERTION
//tris par insertion PAR ORDRE CROISSANT
int  *Tri_insertion_C( int *tab, int N)
{
int i, j;int nbComp=0, nbPerm=0;int *A;
A= malloc(N *sizeof(int));
//Remplissage
  for(i=0; i<N; i++)
  {
  	A[i]=tab[i];
  }
  //tri 
   for (i = 1; i < N; ++i) {
       int elem = A[i];
       for (j = i; j > 0 && A[j-1] > elem; j--)
           {A[j] = A[j-1];nbComp++;affiche(A, N);printf("//On compare %d et %d : On decale a gauche\n",A[j],A[j-1]);}
     A[j] = elem;//nb comparer tant qu'on est dans la boucle i 
  if(A[j-1]<=elem && j != 0){ nbComp++;nbPerm++;affiche(A, N);printf("//On compare %d et %d : On insere %d a l'indice %d'\n",A[j],A[j-1], elem, j);

  }  else {
  affiche(A, N);printf("//On compare indice j = 0: On laisse le premier et on passe a l'element suivant %d++\n",i);}
   }
   printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Vecteur apres tri:\n", nbPerm, nbComp);
    affiche(A, N);//Affichage apres le tri
  return A;//  free(A);//Liberation de A
}
//*******************************************
//tris par insertion PAR ORDRE DECROISSANT
int *Tri_insertion_D( int *tab, int N)
{
int i, j;int nbComp=0, nbPerm=0;int *A;
A= malloc(N *sizeof(int));
//Remplissage
  for(i=0; i<N; i++)
  {
  	A[i]=tab[i];
  }
  //tri 
   for (i = 1; i < N; ++i) {
       int elem = A[i];
       for (j = i; j > 0 && A[j-1] < elem; j--)
                {A[j] = A[j-1];nbComp++;affiche(A, N);printf("//On compare %d et %d : On decale a gauche\n",A[j],A[j-1]);}
     A[j] = elem;//nb comparer tant qu'on est dans la boucle i 
  if(A[j-1]>=elem && j !=0){ nbComp++;nbPerm++;affiche(A, N);printf("//On compare %d et %d : On insere %d a l'indice %d'\n",A[j],A[j-1], elem, j);

  }  else{
   affiche(A, N);printf("//On compare indice j = 0: On laisse le premier et on passe a l'element suivant %d++\n",i);}
   }
   printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Vecteur apres tri:\n", nbPerm, nbComp);
    affiche(A, N);//Affichage apres le tri
    return A;//free(A);//Liberation de A
}
//*****************************************************************************************fin Vecteur***********************************************************************
//***************************************************************************************************************************************************************************
//*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//***************************************************************************************Matrice************************************************************************----
void convertMatToTab(int **mat, int *tab, int n,int m)//fonction qui convertit une matrice en un tableau
{   int i,j;int k=(n*m)-1;
	for(i=n-1; i>=0 ; i--)
	{   for(j=m-1; j>=0 ; j--)
		{tab[k]=mat[i][j];k--;}
	} 	
}
void convertTabToMat(int **mat, int *t,int n,int m)//fonction qui convertit un tableau en une matrice
{   int i,j,k=(n*m)-1;
	for(i=n-1; i>=0; i--)
	{   for(j=m-1; j>=0; j--)
		{mat[i][j]=t[k];k--;}
	} 
}

void afficheMatINT(int **Mat, int n, int m)
{
	int i;color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(Mat[i], m);
   printf("\n");}
}
void saisirMatINT(int **Mat, int n, int m)
{
	int i,j;
	printf("\n                           veuillez remplir la matrice\n");
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
   	printf("  Matrice[%d][%d] : ", i, j);
    scanf("%d",&Mat[i][j]);
   }}
}
//TRI INSERTION MATRICE
void Tri_insertion_C_mat1(int **matt, int n, int m)
//TRi une matrice d'entier ligne par ligne par ordre croissant (innsertion)
{    int i;int **mat;
//allocation
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {	printf("\n--------------Ligne %d:\n",i+1);mat[i]=Tri_insertion_C(matt[i], m);
   }
   color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(mat[i], m);
   printf("\n");}
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
}
void Tri_insertion_D_mat1(int **matt, int n, int m)
//TRi une matrice d'entier ligne par ligne par ordre decroissant (innsertion)
 {   int i;int **mat;
//allocation
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {	printf("\n--------------Ligne %d:\n",i+1);mat[i]=Tri_insertion_D(matt[i], m);
   }
   color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(mat[i], m);
   printf("\n");}
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
}
//                  -------------------------------------------
//*TRI SELECTION MATRICE
void tri_selection1_mat1(int **matt, int n, int m)
//TRi une matrice d'entier ligne par ligne par ordre croissant (selection)

{
    int i;int **mat;
//allocation
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {	printf("\n--------------Ligne %d:\n",i+1);mat[i]=tri_selection1(matt[i], m);
   }
   color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(mat[i], m);
   printf("\n");}
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
}
void tri_selection2_mat1(int **matt, int n, int m)
//TRi une matrice d'entier ligne par ligne par ordre decroissant (selection)
{
    int i;int **mat;
//allocation
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {	printf("\n--------------Ligne %d:\n",i+1);mat[i]=tri_selection2(matt[i], m);
   }
   color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(mat[i], m);
   printf("\n");}
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
}
//TRI A BULLE MATRICE
	void tribullec_mat1(int **matt, int n, int m)
	//TRi une matrice d'entier ligne par ligne par ordre croissant (a bulles)
{
 int i;int **mat;
//allocation
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {	printf("\n--------------Ligne %d:\n",i+1);mat[i]=tribullec(matt[i], m);
   }
   color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(mat[i], m);
   printf("\n");}
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);	
}
   void tribulled_mat1(int **matt, int n, int m)
//TRi une matrice d'entier ligne par ligne par ordre decroissant (a bulles)
{
 int i;int **mat;
//allocation
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {	printf("\n--------------Ligne %d:\n",i+1);mat[i]=tribulled
   (matt[i], m);
   }
   color(14,0);
	printf("\n                           Affichage\n");
	for (i=0; i<n; i++){
		affiche(mat[i], m);
   printf("\n");}
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);	;	
}
/////////////////////////////////////////////////////////////////////MATRICE ENTIERE
 void tri_selection1_Mat2(int **matt, int n, int m)
 {//tri croissant par selection d'une matrice d'entier(toute la matrice sera trié)
 	int i;int **mat;int *t;
//allocation int *t;
   t=malloc( n * m * sizeof(int));
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {
   	mat[i]=malloc( m * sizeof(int));
   }
   convertMatToTab(matt, t, n , m);
   convertTabToMat(mat,tri_selection1(t, n*m), n, m );
   printf(" Apres le tri ");
   afficheMatINT(mat, n, m);
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
 }
 void tri_selection2_Mat2(int **matt, int n, int m)
 {//tri decroissant par selection d'une matrice d'entier(toute la matrice sera trié)
 int i;int **mat;int *t;
//allocation int *t;
   t=malloc( n * m * sizeof(int));
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {
   	mat[i]=malloc( m * sizeof(int));
   }
   convertMatToTab(matt, t, n , m);
   convertTabToMat(mat,tri_selection2(t, n*m), n, m );
   printf(" Apres le tri ");
   afficheMatINT(mat, n, m);
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);	
 }
 void tribullec_Mat2(int **matt, int n, int m)
 {//tri croissant par bulle d'une matrice d'entier(toute la matrice sera trié)
 int i;int **mat;int *t;
//allocation int *t;
   t=malloc( n * m * sizeof(int));
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {
   	mat[i]=malloc( m * sizeof(int));
   }
   convertMatToTab(matt, t, n , m);
   convertTabToMat(mat,tribullec(t, n*m), n, m );
   printf(" Apres le tri ");
   afficheMatINT(mat, n, m);
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
 }
 void tribulled_Mat2(int **matt, int n, int m)
 {//tri decroissant par bulle d'une matrice d'entier(toute la matrice sera trié)

 int i;int **mat;int *t;
//allocation int *t;
   t=malloc( n * m * sizeof(int));
   mat = malloc( n * sizeof( * mat));
   printf("\n");
   for(i=0; i<n; i++)
   {
   	mat[i]=malloc( m * sizeof(int));
   }
   convertMatToTab(matt, t, n , m);
   convertTabToMat(mat,tribulled(t, n*m), n, m );
   printf(" Apres le tri ");
   afficheMatINT(mat, n, m);
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
 }
 void Tri_insertion_C_Mat2(int **matt, int n, int m)
 {//tri croissant par insertion d'une matrice d'entier(toute la matrice sera trié)
 	int i;int **mat;int *t;
//allocation int *t;
   t=malloc( n * m * sizeof(int));
   mat = malloc( n * sizeof( * mat));
   for(i=0; i<n; i++)
   {
   	mat[i]=malloc( m * sizeof(int));
   }
   convertMatToTab(matt, t, n , m);
   convertTabToMat(mat,Tri_insertion_C(t, n*m), n, m );
   printf(" Apres le tri ");
   afficheMatINT(mat, n, m);
   //free 
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
 }
 void Tri_insertion_D_Mat2(int **matt, int n, int m)
 {//tri decroissant par insertion d'une matrice d'entier(toute la matrice sera trié)
 	
 int i;int **mat;int *t;
//allocation int *t;
   t=malloc( n * m * sizeof(int));
   mat = malloc( n * sizeof( * mat));
   for(i=0; i<n; i++)
   {
   	mat[i]=malloc( m * sizeof(int));
   }
   convertMatToTab(matt, t, n , m);
   convertTabToMat(mat,Tri_insertion_D(t, n*m), n, m );
   printf(" Apres le tri ");
   afficheMatINT(mat, n, m);
   //free 
   free(t);
   for(i=0;i<n;i++)
   {free(mat[i]);
   }free(mat);
 }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //////////////////////////////////////MATRICES DE CARACTERES
 int comparer(const char *ch1,const char *ch2)//la fonction strcmp
{
	int L1=strlen(ch1),L2=strlen(ch2);
	int i=0,j=L2-1;
    if(L1 == L2)//si les deux chaines ont la meme taille
    {
    	i=0; while(i<L1 && ch1[i] == ch2[i]){i++;}//tant que sont dans le meme ordrdre	}
             if(i == L1){return 0;}//arrive a la fin ->ils sont dans le meme ordre = identique 
             else if(ch1[i]<ch2[i]){return -1;}//ch1 vient avant ch2 dans l'ordre 
             else return 1;//ch1 vient apres ch2
    }
    else
    {	if(L1 < L2)
    	{
    		i=0;
    	    	while(i<L1 && ch1[i] == ch2[i]){i++;}
			 if(i == L1){return 0;}//arrive a la fin ->ils sont dans le meme ordre = identique 
             else if(ch1[i]<ch2[i]){return -1;}//ch1 vient avant ch2 dans l'ordre 
             else return 1;//ch1 vient apres ch2
    		
			
		}
    	else
    		i=0;
    	    	while(i<L1 && ch1[i] == ch2[i]){i++;}
			 if(i == L1){return 0;}//arrive a la fin ->ils sont dans le meme ordre = identique 
             else if(ch1[i]<ch2[i]){return -1;}//ch1 vient avant ch2 dans l'ordre 
             else return 1;//ch1 vient apres ch2
    	
	}
}
//fonction affichage d'une caractere
void afficheMatCar(char **mat, int n)
{int i;color(15,0);	printf("\n                                   \n\t");
    for (i=0;i<n;i++)
     {color(0,6);
    printf ("%c ",179);
    color(0,6);
	 printf("%s ", mat[i]);}color(15,0);
getchar();
}
//////////fonction selection mat caractere
//fonction tri selection par ordre croissant d'une matrice de caractere
void tri_selection1_Mat3(char **A, int N)
{int I, J;int nbComp=0, nbPerm=0;char **Mat;
Mat= malloc(N *sizeof(* Mat));char AIDE[100];
  int PMAX;
//Remplissage
  for(I=0; I<N; I++)
  { Mat[I]= malloc(strlen(A[I])*sizeof(char));
  if(Mat[I] == NULL){exit(1);
  }
  strcpy(Mat[I] ,A[I]);
  }
  //tri
   for (I=0; I<N-1; I++)
     {  
      PMAX=I;
      for (J=I+1; J<N; J++)// liste non-triée : (Ai+1, A2, ... , An)  
       {            if (strcmp(Mat[J], Mat[PMAX])< 0)
	                {// Aj est le nouveau MAIMUM partiel 
		               PMAX=J;
                      //on échange les positions de Ai et de Aj 
                      strcpy(AIDE,Mat[I]);
                      strcpy(Mat[I],Mat[PMAX]);
                      strcpy( Mat[PMAX],AIDE);	 PMAX=I;
	                  afficheMatCar(Mat, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->nouveau max->On permute", Mat[J],Mat[PMAX], I+1, N, J);nbPerm++;
	   }else{afficheMatCar(Mat, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->On laisse", Mat[J],A[PMAX], I+1, N, J);//incrementer le nombre de comparaison (condition))             
	   
	   }nbComp++;//incrementer le nombre de comparaison (condition))  
	   }
      
	  }
  
  printf("apres tri\n");afficheMatCar(Mat, N);   afficheMatCar(Mat, N);//Affichage apres le tri
  for(I=0; I<N; I++){  free(Mat[I]);//Liberation de A
}free(Mat);
}
//fonction tri selection par ordre decroissant d'une matrice de caractere
void tri_selection2_Mat3(char **A, int N)
{int I, J;int nbComp=0, nbPerm=0;char **Mat;
Mat= malloc(N *sizeof(* Mat));char AIDE[100];
  int PMAX;
//Remplissage
  for(I=0; I<N; I++)
  { Mat[I]= malloc(strlen(A[I])*sizeof(char));
  if(Mat[I] == NULL){exit(1);
  }
  strcpy(Mat[I] ,A[I]);
  }
  //tri
   for (I=0; I<N-1; I++)
     {  
      PMAX=I;
      for (J=I+1; J<N; J++)// liste non-triée : (Ai+1, A2, ... , An)  
       {            if (strcmp(Mat[J], Mat[PMAX])> 0)
	                {// Aj est le nouveau MAIMUM partiel 
		               PMAX=J;
                      //on échange les positions de Ai et de Aj 
                      strcpy(AIDE,Mat[I]);
                      strcpy(Mat[I],Mat[PMAX]);
                      strcpy( Mat[PMAX],AIDE);	
	                  afficheMatCar(Mat, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->nouveau max->On permute", Mat[J],Mat[PMAX], I+1, N, J);nbPerm++;
	   }else{afficheMatCar(Mat, N); printf("//On compare %d avec %d dans la partie non trie [%d,%d] indice J=%d->On laisse", Mat[J],A[PMAX], I+1, N, J);//incrementer le nombre de comparaison (condition))             
	   
	   }nbComp++;//incrementer le nombre de comparaison (condition))  
	   }
      
	  }
  
  printf("apres tri\n");afficheMatCar(Mat, N);   afficheMatCar(Mat, N);//Affichage apres le tri
  for(I=0; I<N; I++){  free(Mat[I]);//Liberation de A
}free(Mat);
}
//////////fonction insertion mat caractere
//fonction tri insertion par ordre croissant d'une matrice de caractere
void  Tri_insertion_C_Mat3( char **tab, int N)
{
int i, j;int nbComp=0, nbPerm=0;char **A;char elem[100];
A= malloc(N *sizeof(* A));
  
//Remplissage
  for(i=0; i<N; i++)
  { A[i]= malloc(strlen(tab[i])*sizeof(char));
  if(A[i] == NULL){exit(1);
  }
  strcpy(A[i], tab[i]);
  }
  //tri 
   for (i = 1; i < N; ++i) {
      strcpy(elem ,A[i]);
       for (j = i; j > 0 && comparer(A[j-1], elem) > 0 ; j--)
           { strcpy(A[j],A[j-1]);nbComp++;afficheMatCar(A, N);printf("//On compare %s et %s : On decale a gauche\n",A[j],A[j-1]);}
         strcpy(A[j] , elem);//nb comparer tant qu'on est dans la boucle i 
  if(comparer(A[j-1], elem) <=0 && j != 0){ nbComp++;nbPerm++;afficheMatCar(A, N);printf("//On compare %s et %s : On insere %s a l'indice %d'\n",A[j],A[j-1], elem, j);

  }  else {
  afficheMatCar(A, N);printf("//On compare indice j = 0: On laisse le premier et on passe a l'element suivant %d++\n",i);}
   }
   printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Matrice apres tri:\n", nbPerm, nbComp);
    afficheMatCar(A, N);//Affichage apres le tri
  for(i=0; i<N; i++){  free(A[i]);//Liberation de A
}free(A);}
//*******************************************
//tris par insertion PAR ORDRE DECROISSANT
void Tri_insertion_D_Mat3( char **tab, int N)
{int i, j;int nbComp=0, nbPerm=0;char **A;char elem[100];
A= malloc(N *sizeof(* A));
  
//Remplissage
  for(i=0; i<N; i++)
  { A[i]= malloc(strlen(tab[i])*sizeof(char));
  if(A[i] == NULL){exit(1);
  }
  strcpy(A[i], tab[i]);
  }
  //tri 
   for (i = 1; i < N; ++i) {
      strcpy(elem ,A[i]);
       for (j = i; j > 0 && comparer(A[j-1], elem) < 0 ; j--)
           { strcpy(A[j],A[j-1]);nbComp++;afficheMatCar(A, N);printf("//On compare %s et %s : On decale a gauche\n",A[j],A[j-1]);}
         strcpy(A[j] , elem);//nb comparer tant qu'on est dans la boucle i 
  if(comparer(A[j-1], elem) >=0 && j != 0){ nbComp++;nbPerm++;afficheMatCar(A, N);printf("//On compare %s et %s : On insere %s a l'indice %d'\n",A[j],A[j-1], elem, j);

  }  else {
  afficheMatCar(A, N);printf("//On compare indice j = 0: On laisse le premier et on passe a l'element suivant %d++\n",i);}
   }
   printf("\n          Apres le tri on a :\n          le nombre de permutation: %d\n          le nombre de comparaison: %d\n           Matrice apres tri:\n", nbPerm, nbComp);
    afficheMatCar(A, N);//Affichage apres le tri
  for(i=0; i<N; i++){  free(A[i]);//Liberation de A
}free(A);

}
/////////////TRI BULLE MATRICE CARACTERE
//fonction tri bulle par ordre decroissant d'une matrice de caractere
void tribulled_Mat3(char **A, int n)
{
	int i, j;int nbComp=0, nbPerm=0;char **Mat;
Mat= malloc(n *sizeof(* Mat));
  
//Remplissage
  for(i=0; i<n; i++)
  { Mat[i]= malloc(strlen(A[i])*sizeof(char));
  if(Mat[i] == NULL){exit(1);
  }
  strcpy(Mat[i] ,A[i]);
  }
	char a[100];int b=0, etape=1; 
	while(b !=1 ){b=1;
	for(i=n-2; i>=0; i--)
		{nbComp++;
		if(comparer(Mat[i],Mat[i+1]) > 0)
		   {strcpy(a, Mat[i]);
            strcpy(Mat[i],Mat[i+1]);
            strcpy(Mat[i+1], a);
			afficheMatCar(Mat, n);	b=0;nbPerm++;
			printf("\n\tetape n%d\n",etape);etape++;
	         
		   }
	}
}printf("apres tri\n");afficheMatCar(Mat, n);   afficheMatCar(Mat, n);//Affichage apres le tri
  for(i=0; i<n; i++){  free(Mat[i]);//Liberation de A
}free(Mat);}
//fonction tri bulle par ordre croissant d'une matrice de caractere
void tribullec_Mat3(char **A, int n)
{int i, j;int nbComp=0, nbPerm=0;char **Mat;
Mat= malloc(n *sizeof(* Mat));
  
//Remplissage
  for(i=0; i<n; i++)
  { Mat[i]= malloc(strlen(A[i])*sizeof(char));
  if(Mat[i] == NULL){exit(1);
  }
  strcpy(Mat[i], A[i]);
  }
	char a[100];int b=0, etape=1;
	while(b !=1 ){b=1;
	for(i=n-2; i>=0; i--)
		{nbComp++;
		if(comparer(Mat[i],Mat[i+1]) > 0)
		   {strcpy(a, Mat[i]);
            strcpy(Mat[i],Mat[i+1]);
            strcpy(Mat[i+1], a);
			afficheMatCar(Mat, n);	b=0;
			printf("\n\tetape n%d\n",etape);etape++;nbPerm++;
	         
		   }
	}
}printf("apres tri\n");afficheMatCar(Mat, n);   afficheMatCar(Mat, n);//Affichage apres le tri
  for(i=0; i<n; i++){  free(Mat[i]);//Liberation de A
}free(Mat);
}

 /////////////////////////////////////Liste chainnée

//declaration de la liste chainnée
typedef struct elementListe{
        char *donnee;
      struct  elementListe *suivant;
}element;
 typedef struct listeRepere{
        element *debut;
        element *fin;
        int taille;
 }liste;
 //fonction pour afficher la liste de chaine de caracteres
 void affichage(liste *L){
    int i=1;
	 element *temp;
	 temp=(element*)malloc(sizeof(element ));

	 for(temp=L->debut; temp!=NULL; temp=temp->suivant)
	 {
		 printf("\t%d : %s",i,temp->donnee);
        i++;
	 }
}

 void initialiser_liste(liste *liste){//initialise une liste 
liste->debut=NULL;
liste->fin=NULL;
liste->taille=0;
printf("initialisation ... \n\n ");
 }

int creation_tete( liste *liste,char *donnee){//cree une tete de liste  et sa donnér
    element *Premier_element,*nouveau_element,*parcour;

    if (liste->taille=0)  return 0;
    Premier_element=(element*)malloc(sizeof(element));
    nouveau_element=(element*)malloc(sizeof(element));
    parcour=(element*)malloc(sizeof(element));

    Premier_element->donnee=(char *)malloc(50*sizeof(char));
    nouveau_element->donnee=(char *)malloc(50*sizeof(char));
    parcour->donnee=(char *)malloc(50*sizeof(char));


    strcpy(Premier_element->donnee,donnee);
    Premier_element->suivant=NULL;
    liste->debut=Premier_element;
    liste->fin=Premier_element;
    liste->taille=1;
   // printf(" l'element numero 1 est creer avec succée : %s !\n\n\n",liste->debut->donnee);

    return 0;
}

int inser_liste( liste *liste){//fonction inserer une liste retourn
    element *nouveau_element;
    element *parcour;
    char *donnee;

    nouveau_element=(element*)malloc(sizeof(element));
    nouveau_element->donnee=(char *)malloc(50*sizeof(char));

        parcour=(element*)malloc(sizeof(element));
        parcour->donnee=(char*)malloc(50*sizeof(char));

            parcour=liste->debut;
   while(parcour->suivant != NULL){
      // printf("parcour au debut !=null");
        parcour=parcour->suivant;
        //printf("parcour incrementer =null");
    }
    //quand on arrive o dernier on copie lÃ  chaine faire les chainage et changer la queue de la liste

  printf("donnez la chaine de l'lement N' %d :\t",liste->taille+1);

   scanf("%s",donnee);
        strcpy(nouveau_element->donnee,donnee);
//printf("la copie et faite\n\n");
    parcour->suivant=nouveau_element ;
  //  printf("par.svt=new ... fait\n\n");
    nouveau_element->suivant=NULL;
    //printf("new.svt=null ... fait\n\n");
    liste->fin=nouveau_element;
    //printf("insertion de nouveau element !\n\n\n");
   // printf("valeur inserer : %s",liste->fin->donnee);
   liste->taille++;
   //printf("l'element numero %d etait creer avec succes\n\n",liste->taille);
    return 0;

}
void trier_liste_selection_A_Z(liste *ma_liste)
{//procedure tri une liste chainnée de chaine//de caracters par ordre croissant a selection

    element *parcour,*tete;
   char *valeur;
            // laisser le trie dans le main
        if ( ma_liste->debut == NULL)
            printf("\n\nla liste est vide\n");
        else{
        parcour=(element *)malloc(sizeof(element));
        parcour->donnee=malloc(50*sizeof(char));
           tete=(element *)malloc(sizeof(element));
        tete->donnee=malloc(50*sizeof(char));
        valeur=malloc(50*sizeof(char));
      tete=ma_liste->debut;
      while(tete!=ma_liste->fin){
          for (parcour=tete->suivant;parcour!=NULL;parcour=parcour->suivant){
            if (strcmp(tete->donnee,parcour->donnee)<0)
                printf("\n\tla tete est avant .. rien a fair!\n\n");
            else {
                printf("\n\tl'element dans la tete est aprÃ¨s .. on doit Permuter\n\n");
                strcpy(valeur,tete->donnee);
                strcpy(tete->donnee,parcour->donnee);
                strcpy(parcour->donnee,valeur);
                affichage(ma_liste);
            }
          }//for
          tete=tete->suivant;
         }//while

        }
          printf("\n\n\t ~~~~~~~~~ Apres le tri selection ordre croissant~~~~~~~~~~~~~~~~~\n\n");
           affichage(ma_liste);
}

void trier_liste_selection_Z_A(liste *ma_liste)
{//procedure tri une liste chainnée de chaine//de caracters par ordre decroissant a selection

    element *parcour,*tete;
   char *valeur;
            // laisser le trie dans le main
        if ( ma_liste->debut == NULL)
            printf("\n\nla liste est vide\n");
        else{
        parcour=(element *)malloc(sizeof(element));
        parcour->donnee=malloc(50*sizeof(char));
           tete=(element *)malloc(sizeof(element));
        tete->donnee=malloc(50*sizeof(char));
        valeur=malloc(50*sizeof(char));
      tete=ma_liste->debut;
      while(tete!=ma_liste->fin){
          for (parcour=tete->suivant;parcour!=NULL;parcour=parcour->suivant){
            if (strcmp(tete->donnee,parcour->donnee)<0)
            {
                printf("\n\tOoops!.. on doit Permuter\n\n");
                strcpy(valeur,tete->donnee);
                strcpy(tete->donnee,parcour->donnee);
                strcpy(parcour->donnee,valeur);
                affichage(ma_liste);
                printf("\n\n");
            }
            else {

            printf("\n\ten ordre .. rien a fair!\n\n");

            }
          }//for
          tete=tete->suivant;
         }//while
        }
        printf("\n\n\t ~~~~~~~~~ Apres le tri sslection ordre decroissant~~~~~~~~~~~~~~~~~\n\n");
        affichage(ma_liste);
}



void trier_liste_bull_A_Z(liste *ma_liste)
{//procedure tri une liste chainnée de chaine//de caracters par ordre croissant a bulle 

    element *parcour,*tete;
    char *valeur;

        if ( ma_liste->debut == NULL)
            printf("\n\nla liste est vide\n");
        else{
        parcour=(element *)malloc(sizeof(element));
        parcour->donnee=malloc(50*sizeof(char));

        tete=(element *)malloc(sizeof(element));
        tete->donnee=malloc(50*sizeof(char));

        valeur=malloc(50*sizeof(char));


      tete=ma_liste->debut;

      while(tete!=NULL){
                for( parcour=tete->suivant ; parcour!=NULL ;parcour=parcour->suivant){
                    // tete=ma_liste->debut;
                        if (strcmp(tete->donnee,parcour->donnee)<0)     //if 2
                        {
                            printf("\n\tla tete est avant .. rien a fair!\n\n");
                            }   //if2
                        else {      //else2
                                printf("\n\t on doit Permuter\n\n");

                                strcpy(valeur,tete->donnee);
                                strcpy(tete->donnee,parcour->donnee);
                                strcpy(parcour->donnee,valeur);
                                affichage(ma_liste);
                        }   //else2
                }//for
            tete=tete->suivant;
         } //while


    }//while
          printf("\n\n\t ~~~~~~~~~ Apres le tri bulle ordre croissant~~~~~~~~~~~~~~~~~\n\n");
           affichage(ma_liste);
}

void trier_liste_bull_Z_A(liste *ma_liste)
{//procedure tri une liste chainnée de chaine//de caracters par ordre decroissant a bulle 

    element *parcour,*tete;
    char *valeur;

        if ( ma_liste->debut == NULL)
            printf("\n\tla liste est vide\n");
        else{
        parcour=(element *)malloc(sizeof(element));
        parcour->donnee=malloc(50*sizeof(char));

        tete=(element *)malloc(sizeof(element));
        tete->donnee=malloc(50*sizeof(char));

        valeur=malloc(50*sizeof(char));


      tete=ma_liste->debut;

      while(tete!=NULL){
                for( parcour=tete->suivant ; parcour!=NULL ;parcour=parcour->suivant){
                    // tete=ma_liste->debut;
                        if (strcmp(tete->donnee,parcour->donnee)<0)
                        {
                              printf("\n\t on doit Permuter\n\n");

                                strcpy(valeur,tete->donnee);
                                strcpy(tete->donnee,parcour->donnee);
                                strcpy(parcour->donnee,valeur);
                                affichage(ma_liste);

                            }   //end if
                        else {

                            printf("\n\tla tete est avant .. rien a fair!\n\n");
                        }   //end else
                }//for
            tete=tete->suivant;
         } //while


    }//while
          printf("\n\n\t ~~~~~~~~~ Apres le tri Bulle ordre decroissant ~~~~~~~~~~~~~~~~~\n\n");
           affichage(ma_liste);
}

 /////////////////////////////////////////////////////////////////////////
void programme2()
{       //declaration des variables
        clock_t start_t, end_t, total_t;//pour le temps d'execution
        int choix,exist,i,rep,pos;
	    int boul;
    	int *tab, **mat;//tab pour la partie vecteur
		int *x;
		char **Mat; 
		char chaine[100];
	    int n, m, taille=0;//nombre de lignes| nombre de colonnes
        char nom[20],c;
        //pour la partie liste:
        
         liste *ma_liste;
         element *parcour,*tete;
         int nombre=1;
         char *valeur;
    
    menu:
        system ("cls");
        system ("color 0f");
        system("mode 110,50");
        affich_menu();
        color(15,0);
   
        printf("\n \n \n\n            Qu'est ce que vous voulez faire? \n \n \n \n\n\n\n\n\n");
        pied_de_page();
        
        gotoxy(1,15);
        choix=menu(4,"\t             PARTIE 1: TRI D UN VECTEUR","\t             PARTIE 2: TRI D UNE MATRICE","\t             PARTIE 2: TRI D UNE LISTE CHAINNEE","\t             Quitter");
        switch (choix)
       { case 1://vecteur 
             //un autr mini menu pour choisir entre tri croissant et decroissant
            
             	system ("cls");
                   system ("color 0f");
                      system("mode 110,50");
                                    //remplissage vecteur a trier
                                    color(14,0);printf("\n     donner taille de tab ");scanf("%d",&n);
	                                tab = malloc(n * sizeof(int)); saisir(tab, n);
                               	    affiche(tab, n);
                      menuVecteurCD:       affich_menu();
                                color(15,0);
                                     printf("\n \n \n\n            Qu'est ce que vous voulez faire? \n \n \n \n\n\n\n\n\n");
                                        pied_de_page(); 
                                           gotoxy(1,15);
            choix=menu(3,"\t             1-TRIER UN VECTEUR PAR ORDRE CROISSANT","\t             2-TRIER UN VECTEUR PAR ORDRE DCROISSANT","\t             Retour");
            switch (choix)
            {
            	case 1: //tri croissant d'un vecteur
            	  menuVectC:
                      system ("cls");
                       system ("color 0f");
                        system("mode 110,50");
                          printf("\n \n \n\n            Choisissez l'un de ces tri\n \n \n \n\n\n\n\n\n");
                            pied_de_page();
                                gotoxy(1,15);
                                  printf("\t                Vecteur\n\n\n");
            choix=menu(4,"\t          01-----Tri par selection par ordre croissant","\t          02-----Tri par bulle par ordre croissant","\t          03-----Tri par insertion a l'ordre croissant","\t          04-----Retourner"); 
			            system("mode 110,900");
			            switch (choix)
        {
        	case 1:	  ///tri d un vecteur (selection) par ordre croissant               
			                        color(13,0);
			                        //printf("\n-----------------------------------TRI d un vecteur d entier par ordre croissant (selection)--------\n");
									color(3,0);cadre(75,2,3,1);
                                    cputsxy(15,2,"TRI d un vecteur d entier par ordre croissant(selection)\n");	
									color(14,0);
                                    start_t = clock();//pour calculer le temps d'execution
                                    printf("\nStarting of the program, start_t = %ld\n", start_t);
                                    tri_selection1(tab, n);  //appel de la fonction tri
                                    end_t = clock();
                                    printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                    total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                              printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                    printf("Exiting of the program...\n");
                            	                         	    
        		break;
        	case 2:   ///tri d un vecteur (bulle) par ordre croissant
			                        color(3,0);
			                        //printf("\n--------------------------------TRI d un vecteur d entier par ordre croissant (bulle)------------\n");
			                        cadre(75,2,3,1);
                                    cputsxy(15,2,"TRI d un vecteur d entier par ordre croissant (bulle)\n");	
									color(14,0);
                            	       
								    start_t = clock();//pour calculer le temps d'execution
                                    printf("\nStarting of the program, start_t = %ld\n", start_t);
                                    tribullec(tab, n);  //appel de la fonction tri
                                    end_t = clock();
                                    printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                    total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                       printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                    printf("Exiting of the program...\n");                        	  
        		break;
        	case 3:   ///tri d un vecteur (insertion) par ordre croissant
			                        color(3,0);
			                        //printf("\n--------------------------------TRI d un vecteur d entier par ordre croissant (insertion)------\n");
									cadre(75,2,3,1);
                                    cputsxy(15,2,"TRI un vecteur d entier par ordre croissant(insertion)\n");	
									color(14,0);															
                            	     
									start_t = clock();//pour calculer le temps d'execution
                                    printf("\nStarting of the program, start_t = %ld\n", start_t);
                                    Tri_insertion_C(tab, n);   //appel de la fonction tri
                                    end_t = clock();
                                    printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                    total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                    printf("Exiting of the program...\n");                            	   
        		break;
        	case 4://retour en arriere vers le menu de choix entre ordre croissant et decroissant d'un vecteur
                              goto menuVecteurCD;
        	   break;
			}
			 rpet1c: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
            c=getch();
            if (c==27|| c==8) goto menuVectC;
            else goto rpet1c;
        
     

        break;//fin case _ tri vecteur croissant
        
        case 2: //tri d'un vecteur dans l'ordre decroissant
        /////////////////////////////////////////////////////////////////////////////////////
			 menuVectD:
                      system ("cls");
                       system ("color 0f");
                        system("mode 110,50");
                          printf("\n \n \n\n            Choisissez l'un de ces tri\n \n \n \n\n\n\n\n\n");
                            pied_de_page();
                                gotoxy(1,15);
                                  printf("\t                Vecteur\n\n\n");
            choix=menu(4,"\t          01-----Tri par selection par ordre decroissant","\t          02-----Tri par bulle par ordre decroissant","\t          03-----Tri par insertion a l'ordre decroissant","\t          04-----Retourner"); 
			            system("mode 110,900");
			            switch (choix)
			            {  
			                 	
			            	
			            	
			            	
							case 1:  ///tri d un vecteur (selection) par ordre decroissant///
        	                      	color(3,0);
        	                      	//printf("\n------------------------------TRI d un vecteur d entier par ordre decroissant (selection)-------\n");
									  cadre(75,2,3,1);
                                     cputsxy(15,2,"TRI d un vecteur d entier par ordre decroissant (selection)\n");				                     
									  color(14,0);
	                                
	                              	start_t = clock();//pour calculer le temps d'execution
                                    printf("\nStarting of the program, start_t = %ld\n", start_t);
                                    tri_selection2(tab, n);  //appel de la fonction tri
                                    end_t = clock();
                                    printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                    total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                    printf("Exiting of the program...\n");  
                                	free(tab);
        	             	break;
        	               case 2:///tri d un vecteur (Bullles ) par ordre decroissant
        	                        color(3,0);
        	                        //printf("\n--------------------------------TRI d un vecteur d entier par ordre decroissant (bulle)-----\n");
										cadre(75,2,3,1);
                                    cputsxy(15,2,"TRI d un vecteur d entier par ordre decroissant (bulle)\n");	
									color(14,0);							
                            	   
                            		start_t = clock();//pour calculer le temps d'execution
                                    printf("\nStarting of the program, start_t = %ld\n", start_t);
                                    tribulled(tab, n);  //appel de la fonction tri
                                    end_t = clock();
                                    printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                    total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                    printf("Exiting of the program...\n"); 
                                 	free(tab);
        		            break;
                          	case 3:///tri d un vecteur (insertion) par ordre decroissant
        	                        color(3,0);
        	                        //printf("\n------------------------------TRI d un vecteur d entier par ordre decroissant (insertion)----------------------------------\n");
        	                        	cadre(75,2,3,1);
                                    cputsxy(15,2,"TRI d un vecteur d entier par ordre decroissant (insertion)\n");	
									color(14,0);								
                            	   
                                    start_t = clock();//pour calculer le temps d'execution
                                    printf("\nStarting of the program, start_t = %ld\n", start_t);
                                    Tri_insertion_D(tab, n);  //appel de la fonction tri
                                    end_t = clock();
                                    printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                    total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                             printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                    printf("Exiting of the program...\n"); 
                                 	free(tab);
        		            break;
        	                case 4://retour en arriere vers le menu de choix entre ordre croissant et decroissant d'un vecteur
                                   goto  menuVecteurCD;
        	                break;
        }
        
		  rpet1d: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
            c=getch();
            if (c==27|| c==8) goto menuVectD;
            else goto rpet1d;
        
     

        break;//  fin de case ===  choix de tri decroissant
		
       case 3: //retourner a menu _ (avant le menu du choix de l'ordre de tri du vecteur croissant\decroissant 	
          free(tab);goto menu;  break;
      }
      	    
         break;   //pour le case 1   ===  choix de tri vecteur

        
/////////////////////////////////////////////////////////////
 case 2://matrice                                                      //1
       menu2MatriceENTIERCARACTERE:system("clc");
       system ("color 0f");
        system("mode 110,900");
            printf("\n \n \n\n            Qu'est ce que vous voulez faire? \n \n \n \n\n\n\n\n\n");
            pied_de_page();
            gotoxy(1,15);
            printf("\t                    Matrices\n\n\n");
            choix=menu(3,"\t          01-----Traiter une matrice d'entier","\t          02-----Trier une matrice de caracteres","\t          03-----Revenir au menu principale");
        system("mode 110,900");
            switch(choix)
            
        {
        	case 1: // matrice d entier                               //1-1
        	   //remplissage
        	   //autre menu de choix croissant ou decroissant
        	   //remplissage 
        	   	color(14,0);printf("\n\n     donner taille de la matrice   ");scanf("%d",&n);scanf("%d",&m);
	                                /*allocation de la matrice*/
									mat = malloc( n * sizeof(*mat));
	                                for(i =0; i < n; i++)
	                                {
	                                	mat[i] =malloc ( m * sizeof(int));
									}
									saisirMatINT(mat, n, m);
        	   menu2MatriceLE:
        	     printf("\n \n \n\n            Quel Mode de tri voulez vous opter? \n \n \n \n\n\n\n\n\n");
            pied_de_page();
            gotoxy(1,15);
            printf("\t                    Matrices d entier\n\n\n");
            choix=menu(3,"\t            trier une matrice ligne par ligne","\t            trier une matrice entiere","\t            retourner au menu choix type de la matrice");
            system("mode 110,900");
            switch(choix)
            {
        	    case 1://matrice ligne par ligne                    //1-1-1
        	          menu2MatriceLigne:
        	          	//pour choisir l'un des methodes de tri croissant
        	          	system ("color 0f");
                        system("mode 110,900");
                        printf("\n \n \n\n            Votre matrice sera trie ligne par ligne choisissez l'ordre de tri'? \n \n \n \n\n\n\n\n\n");
                        pied_de_page();
                        gotoxy(1,15);
                        printf("\t                    Matrices\n\n\n");
                        choix=menu(3,"\t             trier une matrice ligne par ligne ordre croissant","\t               trier une matrice ligne par ligne ordre decroissant","\t               retourner au menu choix mode de tri" );
        	            system("mode 110,900");
                        switch(choix)
                        {
                        	case 1://tri croissant              //1-1-1-1-
                        	menu2MatriceLigneC:
                        			system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Votre matrice sera trie ligne par ligne par ordre croissant quel tri utilisé? \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Matrices\n\n\n");
                                    choix=menu(4,"\t          01-----Tri par selection a l'ordre croissant","\t          02-----Tri par bulle a l'ordre croissant","\t          03-----Tri par insertion a l'ordre croissant"," \t          04-----Revenir en arriere (ordre de tri)"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    {
                                    	case 1://tri selection           //1-1-1-1-1
                                    	color(3,0);cadre(75,2,3,1);//cadrage 
                                        cputsxy(4,2,"TRI d une matrice d entier par ordre croissant (selection_ligne par ligne)\n\n");
                                        color(14,0);                               	   
                            	        
                            	         start_t = clock();//pour calculer le temps d'execution
                                         printf("\nStarting of the program, start_t = %ld\n", start_t);
                                         tri_selection1_mat1(mat, n, m);    //appel de la fonction tri
                                         end_t = clock();
                                         printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                         total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                        printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                         printf("Exiting of the program...\n"); 
                                    		break;
                                    		case 2://tri bulle 
											color(3,0);cadre(75,2,3,1);//cadrage 
                                            cputsxy(4,2,"TRI d une matrice d entier par ordre croissant (bulle_ligne par ligne)\n\n");
									        color(14,0);
                            	                        //1-1-1-1-2
                            	             start_t = clock();//pour calculer le temps d'execution
                                             printf("\nStarting of the program, start_t = %ld\n", start_t);
                                            tribullec_mat1(mat, n, m);     //appel de la fonction tri
                                            end_t = clock();
                                            printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                            total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                            printf("Exiting of the program...\n"); 
                                    			break;
                                    			case 3://tri insertion   //1-1-1-1-3
                                    			color(3,0);cadre(75,2,3,1);//cadrage 
                                                cputsxy(4,2,"TRI d une matrice d entier par ordre croissant (insertion_ligne par ligne)\n\n");
	    							            color(14,0);
	    							            
	    							             start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                           Tri_insertion_C_mat1(mat, n, m);   //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                  printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    				break;
                                    				case 4:
													color(3,0);//revenir en arriere 
        		 	                                //liberation de la matrice*/
									                
													goto menu2MatriceLigne;  //1-1-1-1-4
                                    					break;
									}//revenir a menu2MatriceLigneC
									   rpeMatligne15C: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                                        c=getch();
                                       if (c==27|| c==8) goto     menu2MatriceLigneC;
                                       else goto rpeMatligne15C;
									   
                        		break;
                        		case 2://tri decroissant                //1-1-1-2
                        		menu2MatriceLigneD:
                        				system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Votre matrice sera trie ligne par ligne par ordre decroissant quel tri utilisé? \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Matrices\n\n\n");
                                    choix=menu(4,"\t          01-----Tri par selection a l'ordre decroissant","\t          02-----Tri par bulle a l'ordre decroissant","\t          03-----Tri par insertion a l'ordre decroissant"," \t          04-----Revenir en arriere (ordre de tri)"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    {
                                    	case 1://tri selection                  //1-1-1-2-1
                                    	color(3,0);cadre(75,2,3,1);//cadrage 
                                        cputsxy(4,2,"TRI d une matrice d entier par ordre decroissant (selection_ligne par ligne)\n\n");
									    color(14,0);
                            	        
										 start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                           tri_selection2_mat1(mat, n, m);    //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                      printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n");                           	    				
                                    		break;                
                                    		case 2://tri bulle                        //1-1-1-2-2
                                    		color(3,0);cadre(75,2,3,1);//cadrage */
                                            cputsxy(4,2,"TRI d une matrice d entier par ordre decroissant bulle_ligne par ligne)\n\n");							          	
                           	                 
											    start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                           tribulled_mat1(mat, n, m);     //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                   printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n");         
												break;
                                    			case 3://tri insertion //1-1-1-2-3
											    color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice d entier par ordre decroissant (insertion_ligne par ligne)\n\n");
									            color(14,0);
                            	                 
												start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                          Tri_insertion_D_mat1(mat, n, m);     //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                             printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n");                        	   
                                    				break;
                                    				case 4:
													color(3,0); 
													goto menu2MatriceLigne;              //1-1-1-2-4
                                    					break;
									}//revenir a menu2MatriceLigneD
											 rpeMatligne200: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                                        c=getch();
                                       if (c==27|| c==8) goto     menu2MatriceLigneD;
                                       else goto rpeMatligne200;
                        			 break;
                        			 case 3:
									 goto menu2MatriceLE;              //1-1-1-3
                        			 	break;
						}//revenir a menu2MatriceLigne
						 rpeMatligne20: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                                        c=getch();
                                       if (c==27|| c==8) goto     menu2MatriceLigne;
                                       else goto rpeMatligne20;
			   
			   	break;
        	   	case 2:                                                                    //1-1-2
				     //menu2MatriceEntiere
				      menu2MatriceEntiere:
        	          	//pour choisir l'un des methodes de tri croissant
        	          	system ("color 0f");
                        system("mode 110,900");
                        printf("\n \n \n\n            Votre matrice sera trie entierement choisissez l'ordre de tri'? \n \n \n \n\n\n\n\n\n");
                        pied_de_page();
                        gotoxy(1,15);
                        printf("\t                    Matrices\n\n\n");
                        choix=menu(3,"\t               trier une matrice d'entier entierement ordre croissant","\t               trier une matrice d'entier entierement ordre decroissant","\t               retourner au menu choix mode de tri" );
        	            system("mode 110,900");
                        switch(choix)
                        {
                        	case 1://tri croissant                        //1-1-2-1
                        	menu2MatriceEntiereC: 
                        			system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Votre matrice sera trie entierement par ordre croissant quel tri utilisé? \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Matrices\n\n\n");
                                    choix=menu(4,"\t          01-----Tri par selection a l'ordre croissant","\t          02-----Tri par bulle a l'ordre croissant","\t          03-----Tri par insertion a l'ordre croissant"," \t          04-----Revenir en arriere (ordre de tri)"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    {
                                    	case 1://tri selection
                                    	    
                                            color(3,0); cadre(75,2,3,1);//cadrage 
                                            cputsxy(4,2,"TRI d une matrice d entier par ordre croissant selection\n\n");
                                            color(14,0);
                                    		
                                    		start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                          tri_selection1_Mat2(mat, n, m);    //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                             printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    	
                                    		break;
                                    		case 2://tri bulle
                                    		 color(3,0); cadre(75,2,3,1);//cadrage 
                                             cputsxy(4,2,"TRI d une matrice d entier par ordre croissant bulle\n\n");
                                             color(14,0);
                                    			
                                    				start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                          tribullec_Mat2(mat, n, m);    //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                   printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    			break;
                                    			case 3://tri insertion
                                    			    color(3,0); cadre(75,2,3,1);/*cadrage */
                                                    cputsxy(4,2,"TRI d une matrice d entier par ordre croissant insertion\n\n");
                                                    color(14,0);
                                    				
                                    					start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                          Tri_insertion_C_Mat2(mat, n, m);   //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                   printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    				break;
                                    				case 4:
												
													goto menu2MatriceEntiere;
                                    					break;
									}//revenir a menu2MatricEntiereC
									rpeMatDL: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                                     c=getch();
                                    if (c==27|| c==8) goto menu2MatriceEntiereC;
                                    else goto rpeMatDL;
                        		break;
                        		case 2://tri decroissant                    //1-1-2-2
                        		menu2MatricEntierD:
                        				system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Votre matrice sera trie entierement par ordre decroissant quel tri utilisé? \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Matrices\n\n\n");
                                    choix=menu(4,"\t          01-----Tri par selection a l'ordre decroissant","\t          02-----Tri par bulle a l'ordre decroissant","\t          03-----Tri par insertion a l'ordre decroissant"," \t          04-----Revenir en arriere (ordre de tri)"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    {
                                    	case 1://tri selection    //1-1-2-2-1
                                    
 

                                    
                                    	color(3,0); cadre(75,2,3,1);/*cadrage */
                                        cputsxy(4,2,"TRI d une matrice d entier par ordre decroissant selection\n\n");
                                        color(14,0);	
                                        	start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  tri_selection2_Mat2(mat, n, m);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                 printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 

 
                                    		break;
                                    		case 2://tri bulle        //1-1-2-2-2
                                    	 color(3,0); cadre(75,2,3,1);/*cadrage */
                                         cputsxy(4,2,"TRI d une matrice d entier par ordre decroissant bulle\n\n");
                                         color(14,0);

                                    
                                    		
                                    		start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  tribulled_Mat2(mat, n, m);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                  printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    			break;
                                    			case 3://tri insertion     //1-1-2-2-3
                                    					color(3,0); cadre(75,2,3,1);/*cadrage */
                                                        cputsxy(4,2,"TRI d une matrice d entier par ordre decroissant insertion\n\n");
                                                        color(14,0);
                                    		
                                    				start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  	Tri_insertion_D_Mat2(mat, n, m);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    				break;
                                    				case 4:goto menu2MatriceEntiere;      //1-1-2-2-4
                                    					break;
									}//revenir a menu2MatricEntiereD
									
                        			 rpeMatLD8: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                                     c=getch();
                                    if (c==27|| c==8) goto menu2MatricEntierD;
                                    else goto rpeMatLD8;
									 break;
                        			 case 3:
									 goto  menu2MatriceLE ;   //1-1-2-3
                        			 	break;
						}
				     //revenir a menu2MatriceEntier
				     	rpeMatE: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                c=getch();
                if (c==27|| c==8) goto      menu2MatriceLigne;
                else goto rpeMatE;
        	   	break;
        	    case 3://retourner au choix de type de la matrice               //1-1-3
        	    for(i=0; i<n; i++)
									 {free(mat[i]);}free(mat);
        	   goto menu2MatriceENTIERCARACTERE;
        	   	break;
        	   			
        	
		    }	rpeMatLE: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                c=getch();
                if (c==27|| c==8) goto     menu2MatriceLE;
                else goto rpeMatLE;
		    break;
		    case 2://// matrice de caracteres              //1-2
        	   //remplissage
        	   //autre menu de choix croissant ou decroissant
        	   printf(" \n la taille de la matrice est : ");scanf("%d",&n);
    Mat = malloc( n * sizeof( * Mat));
   for (i = 0; i < n; i++)
   {
      char chaine[100];
      printf ("         donner la chaine : ");
      scanf("%s", chaine);
      
      Mat[i] = malloc (strlen (chaine) + 1);
 
      if (Mat[i] != NULL)
      {
         strcpy (Mat[i], chaine);
      }
      else
         printf ("no\n");
   }getchar ();
        	   menu2MatCaractereCD:
        	   printf("\n \n \n\n            Qu'est ce que vous voulez faire? \n \n \n \n\n\n\n\n\n");
            pied_de_page();
            gotoxy(1,15);
            printf("\t                    Matrices de caractere\n\n\n");
            choix=menu(3,"\t               trier une matrice par ordre croissant","\t            trier une matrice par ordre decroisasant","\t            retourner au menu choix type de la matrice");
            system("mode 110,900");
            switch(choix)
            {
        	    case 1://trier matrice de caracteres par ordre croissant
        	    menu2MatCarctereC:
        	    		system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Votre matrice sera trie entierement par ordre decroissant quel tri utilisé? \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Matrices\n\n\n");
                                    choix=menu(4,"\t          01-----Tri par selection a l'ordre croissant","\t          02-----Tri par bulle a l'ordre croissant","\t          03-----Tri par insertion a l'ordre croissant"," \t          04-----Revenir en arriere (ordre de tri)"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    {
                                    	case 1://tri selection    //1-1-2-2-1
                                    	color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice de caractere par ordre croissant (selection)\n\n");
									            color(14,0);
                                    	printf("\n\n     Avant le tri:\n");
                                                  afficheMatCar(Mat, n);  
     
    
                                    	start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  tri_selection1_Mat3(Mat, n); //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    		break;
                                    		case 2://tri bulle        //1-1-2-2-2
                                    		color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice de caractere par ordre croissant (bulle)\n\n");
									            color(14,0);
                                    			printf("\n\n     Avant le tri:\n");
                                                afficheMatCar(Mat, n);
                                    		start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  tribullec_Mat3(Mat, n);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    			break;
                                    			case 3://tri insertion     //1-1-2-2-3
                                    			color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice de caractere par ordre croissant (insertion)\n\n");
									            color(14,0);
                                    				printf("\n\n     Avant le tri:\n");
                                                afficheMatCar(Mat, n);
                                    			start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  Tri_insertion_C_Mat3(Mat, n);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                    printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    				break;
                                    				case 4:
													for(i=0; i<n; i++)
								                 	{free(Mat[i]);}free(Mat);
													goto menu2MatCaractereCD;      //1-1-2-2-4
                                    					break;
									}//revenir a menu2MatricCaractereD
				rpeMatCarCD: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                c=getch();
                if (c==27|| c==8) goto     menu2MatCarctereC;
                else goto rpeMatCarCD;					 
        	   	break;
        	   	case 2://trier matrice de caracteres par ordre decroissant
        	   	menu2MatCarctereD:
        	    		system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Votre matrice sera trie entierement par ordre decroissant quel tri utilisé? \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Matrices de caractere\n\n\n");
                                    choix=menu(4,"\t          01-----Tri par selection a l'ordre decroissant","\t          02-----Tri par bulle a l'ordre decroissant","\t          03-----Tri par insertion a l'ordre decroissant"," \t          04-----Revenir en arriere (ordre de tri)"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    {
                                    	case 1://tri selection    //1-1-2-2-1
                                    	color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice de caractere par ordre decroissant (selection)\n\n");
									            color(14,0);
                                    		printf("\n\n     Avant le tri:\n");
                                                  afficheMatCar(Mat, n);  
     
    
                                    	start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  tri_selection2_Mat3(Mat, n); //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    		break;
                                    		case 2://tri bulle        //1-1-2-2-2
                                    		color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice de caractere par ordre decroissant (bulle)\n\n");
									            color(14,0);
                                    			printf("\n\n     Avant le tri:\n");
                                                afficheMatCar(Mat, n);
                                    		start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  tribulled_Mat3(Mat, n);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                     printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    			break;
                                    			case 3://tri insertion     //1-1-2-2-3
                                    			color(3,0);cadre(75,2,3,1);//cadrage */
                                                cputsxy(4,2,"TRI d une matrice de caractere par ordre decroissant (insertion)\n\n");
									            color(14,0);
                                    				printf("\n\n     Avant le tri:\n");
                                                afficheMatCar(Mat, n);
                                    			start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  Tri_insertion_D_Mat3(Mat, n);  //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                    printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    				break;
                                    				case 4:
													for(i=0; i<n; i++)
								                 	{free(mat[i]);}free(mat);
													goto menu2MatCaractereCD;      //1-1-2-2-4
                                    					break;
									}//revenir a menu2MatricCaractereD
				rpeMatCaractereD: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
                c=getch();
                if (c==27|| c==8) goto     menu2MatCarctereD;
                else goto rpeMatCaractereD;					 
        	   	break;
        	   	break;
        	    case 3:  //liberation de la matrice
                             for (i = 0; i < n; i++)
                             {
                                  free (Mat[i]);Mat[i] = NULL;
                               }//retourner au choix de type de la matrice
        	      goto menu2MatriceENTIERCARACTERE;
        	   	break;
        	
		    }
		    rpeMatCaractereC000: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
            c=getch();
            if (c==27|| c==8) goto     menu2MatCaractereCD;
            else goto rpeMatCaractereC000;
		    	
		    //retourner a 	
		    break;
		    case 3://retourner au menu de choix de ordre de tri de la matrice de la matrice
		    	goto   menu;
		    break;
        }	 
		rpeMat: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
        c=getch();
        if (c==27|| c==8) goto     menu2MatriceENTIERCARACTERE;
        else goto rpeMat;
        //traitement terminee revenir en arriere pour reaffiche le menu 
        break;
        
        case 3://Liste
              Menu3_Liste:      system("clc");             	system ("color 0f");
                                    system("mode 110,900");
                                    printf("\n \n \n\n            Choisissez le tri dont vous voulez adapte a votre liste \n \n \n \n\n\n\n\n\n");
                                    pied_de_page();
                                    gotoxy(1,15);
                                    printf("\t                    Liste de chaine de caractere\n\n\n");
                                    choix=menu(5,"\t          01-----Tri par selection a l'ordre croissant 'A' a 'Z' ","\t          02-----Tri par bulle a l'ordre croissant 'A' a 'Z'","\t          03-----Tri par selection a l'ordre decroissant 'Z' a 'A'"," \t          04-----Tri par bulle a l'ordre decroissant 'Z' a 'A'"," \t          05-----Revenir au menuprincipae"); 
                        		    system("mode 110,900");
                                    switch(choix)
                                    { case 1:
									
									color(3,0);
									        printf("\n\tdonnez la taille de liste : \t");
                                            scanf("%d",&taille);
                                            valeur=malloc(50*sizeof(char));
                                            ma_liste=malloc(sizeof(liste));
                                            initialiser_liste(ma_liste);
                                            if (taille==0){
                                               printf("\n\n\t\tliste vide\n\n");
                                               }
                                             else {
                                             printf("\ndonnez la chaine de la tete :\t");
                                             scanf("%s",valeur);
                                              //creation du premier noeud
                                              creation_tete(ma_liste,valeur);
                                              // creation du reste de la liste
                                              while ( (ma_liste->taille) < (taille) ){
                                              inser_liste(ma_liste);
                                                    }
                                        //else non vide
                                        // printf("la tete : %s \n",ma_liste->debut->donnee);
                                          //printf("la Queue : %s\n",ma_liste->fin->donnee);
                                         printf("\nvotre liste avant le tri : \n ");
                                        affichage(ma_liste);
                                                  }

                                         //appell
                                         cadre(100,2,3,1);
                                    cputsxy(15,2,"Tri d'une liste de chaine de caractere par selection a l'ordre croissant 'A' a 'Z'\n");	
									color(14,0);
                                   gotoxy(1, 30);      start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  trier_liste_selection_A_Z(ma_liste); //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                  printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    	break;
                                    	case 2:color(3,0);
										printf("\n\tdonnez la taille de liste : \t");
                                            scanf("%d",&taille);
                                            valeur=malloc(50*sizeof(char));
                                            ma_liste=malloc(sizeof(liste));
                                            initialiser_liste(ma_liste);
                                            if (taille==0){
                                               printf("\n\n\t\tliste vide\n\n");
                                               }
                                             else {
                                             printf("\ndonnez la chaine de la tete :\t");
                                             scanf("%s",valeur);
                                              //creation du premier noeud
                                              creation_tete(ma_liste,valeur);
                                              // creation du reste de la liste
                                              while ( (ma_liste->taille) < (taille) ){
                                              inser_liste(ma_liste);
                                                    }
                                        //else non vide
                                        // printf("la tete : %s \n",ma_liste->debut->donnee);
                                          //printf("la Queue : %s\n",ma_liste->fin->donnee);
                                         printf("\nvotre liste avant le tri : \n ");
                                        affichage(ma_liste);
                                                  }

                                         cadre(100,2,3,1);
                                    cputsxy(15,2,"Tri d'une liste de chaine de caractere par bulle a l'ordre croissant 'A' a 'Z'\n");	
									color(14,0);gotoxy(1, 30);
                                         start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                  trier_liste_bull_A_Z(ma_liste); //appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                  printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    		break;
                                    		case 3:
											printf("\n\tdonnez la taille de liste : \t");
                                            scanf("%d",&taille);
                                            valeur=malloc(50*sizeof(char));
                                            ma_liste=malloc(sizeof(liste));
                                            initialiser_liste(ma_liste);
                                            if (taille==0){
                                               printf("\n\n\t\tliste vide\n\n");
                                               }
                                             else {
                                             printf("\ndonnez la chaine de la tete :\t");
                                             scanf("%s",valeur);
                                              //creation du premier noeud
                                              creation_tete(ma_liste,valeur);
                                              // creation du reste de la liste
                                              while ( (ma_liste->taille) < (taille) ){
                                              inser_liste(ma_liste);
                                                    }
                                        //else non vide
                                        // printf("la tete : %s \n",ma_liste->debut->donnee);
                                          //printf("la Queue : %s\n",ma_liste->fin->donnee);
                                         printf("\nvotre liste avant le tri : \n ");
                                        affichage(ma_liste);
                                                  }

                                         color(3,0);cadre(100,2,3,1);
                                    cputsxy(15,2,"Tri d'une liste de chaine de caractere par selection a l'ordre decroissant 'Z' a 'A'\n");	
									color(14,0);gotoxy(1, 30);
                                         start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                 trier_liste_selection_Z_A(ma_liste);//appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                  printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    			break;
                                    			case 4:
									color(14,0);
												printf("\n\tdonnez la taille de liste : \t");
                                            scanf("%d",&taille);
                                            valeur=malloc(50*sizeof(char));
                                            ma_liste=malloc(sizeof(liste));
                                            initialiser_liste(ma_liste);
                                            if (taille==0){
                                               printf("\n\n\t\tliste vide\n\n");
                                               }
                                             else {
                                             printf("\ndonnez la chaine de la tete :\t");
                                             scanf("%s",valeur);
                                              //creation du premier noeud
                                              creation_tete(ma_liste,valeur);
                                              // creation du reste de la liste
                                              while ( (ma_liste->taille) < (taille) ){
                                              inser_liste(ma_liste);
                                                    }
                                        //else non vide
                                        // printf("la tete : %s \n",ma_liste->debut->donnee);
                                          //printf("la Queue : %s\n",ma_liste->fin->donnee);
                                         printf("\nvotre liste avant le tri : \n ");
                                        affichage(ma_liste);
                                                  }
 
                                      
                                           color(3,0);cadre(100,2,3,1);
                                    cputsxy(15,2,"Tri d'une liste de chaine de caractere par bulle a l'ordre decroissant 'A' a 'Z'\n");	
                                gotoxy(1, 30);         start_t = clock();//pour calculer le temps d'execution
                                                  printf("\nStarting of the program, start_t = %ld\n", start_t);
                                                 trier_liste_bull_Z_A(ma_liste);//appel de la fonction tri
                                                  end_t = clock();
                                                  printf("\nEnd of the big loop, end_t = %ld\n", end_t);
                                                  total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
                                                   printf("\nTotal time taken by CPU: %f   %ld\n", total_t, end_t - start_t  );
                                                  printf("Exiting of the program...\n"); 
                                    				break;
                                    				case 5:
                                    					goto menu;
                                    					break;
                                    				
									}rpeListe: printf ("\n\n Appuyez sur ECHAP ou sur BACKSPACE pour revenir en arriere\n\n ");
            c=getch();//revenir au choix de tri de la liste
            if (c==27|| c==8) goto     Menu3_Liste;
            else goto rpeListe;
        	break;
        
        case 4://quitter le programme
        	  system ("color 0f");
                system ("mode con lines 50 cols 80");
                quitter();
        
        	break;

}}
int main()
{
    system("mode con lines=500 cols=2000");
    programme2();return 0;

}
                      

