#include "Semaphore.h"/*AKLI Yassamine _ AITHAMMOUDA Kenza / RSD/ G2 2019*/
#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include "Memoire.h"
#include<math.h>
#include<time.h>
int K=0;
//_________________Charger_Rouler_Decharger________________________
void Charger()
{K++;
printf("\nVOITURE...chargement... numéro = %d\n",K);fflush(stdout);
}
void Rouler()
{
printf("VOITURE...Rouler ...:)\n");fflush(stdout);
sleep(3);
}
void Decharger()
{
printf("VOITURE...décharger...(:\n\n");fflush(stdout);//sleep(2);
}


//__________________________________________________________________
//_________________________main____________________________________
int main(char argc, char *argv[])
{
//---declaration des variables---
unsigned int time_sleep;unsigned int x;int i,j;
ushort *tab;sdata_parc *sd = NULL;//initialiser au null
semun arg;int n=6;int lettre = 1;int semid;int t;
key_t key_memo;int memo;int initval=1;int status;
int P_=7;

//---mémoire partagé---
memo = memcreate_(argv[1],11, sizeof(sdata_parc));

sd = shmat(memo, sd, 0);//attacher processus père à mémoire partager

//---initialisation des indexes:
sd->nbEmbarques=0;
sd->nbDebarques=0;
sd->nbtour=1;
int semEmbarquement=2,semDebarquement=3,mutex1=0,mutex2=1,semTousAbord=4,semTousDehord=5;
//---creation ou recupération du (si il exist dejà) semid:
semcreate(argv[1], lettre,n,&semid);

//---initialiser sem setall:
tab = (ushort *)malloc(n*sizeof(ushort));
//0 mutex1, 1 mutex2, 2 semEmbarquement, 3 semDebarquement, 4 semTousAbord, 5 semTousDehors
for(i=0;i<2;i++)tab[i]=1;
for(i=2;i<n;i++)tab[i]=0;

group_seminit_setall(semid,n,initval,tab,arg);



//---afficher les sémaphores initialiser:
printf("mutex1 ");
printf(",mutex2 ");
printf(",SemEmbarquement ");
printf(",SemDebarquement ");
printf(",semTousAbord ");
printf(",semTousDehord \n");
semgetvall( semid,n);
printf("   ___________________\n");
printf("donner le nombre de tour du client \n");
scanf("%d",&t);
sd->nbtour=t;

while (1)
{    
	Charger();
	for( i=1;i<=P_;i++)
	{  
		V(semid,2); //debloquer P processus client bloqué dans la file de selEmbarquement

	} 
	P_TIMED(semid,4);//se debloque apres timeout défini dans la fonction semtimedop sans attendre le dernier client
	if(sd->nbEmbarques > P_/3 )
	{
	   Rouler();  
	   Decharger(); 
       seminit(semid,2,0,0);//réinitialiser le semaphore semEmbarquement
	   for( j=1;j<=P_;j++)
	   {
    		V(semid,3);//libérer les processus client qui font la queue pour descendre
       }//bloqués dans l'opération P(semDebarquement)
       P_TIMED(semid,5);//le processus voiture se bloque ici et attend que le dernier client qui descent le reveil
       sd->nbDebarques=0;// voiture réinitialise ces variable après chaque fin de tournée
       sd->nbEmbarques = 0;
	}
    else 
	{
		printf("\n\n...ANNULER TOURNEE...\n\n");
		Decharger();
		//réinitialiser les sémaphores
		seminit(semid,2,0,0);//semEmbarquement
		seminit(semid,3,0,0);//semDebarquement
		seminit(semid,4,0,0);//semTousAbord
		seminit(semid,5,0,0);//semTousDehors
		sd->nbEmbarques=0;
    }
}
return 0;
}
