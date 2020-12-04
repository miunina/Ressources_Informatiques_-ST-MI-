#include "Semaphore.h" /*AKLI Yassamine _ AITHAMMOUDA Kenza / RSD/ G2 2019*/
#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include "Memoire.h"
#include<math.h>
#include<time.h>
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
semun arg;int n=6;int lettre = 21;int semid;
key_t key_memo;int memo;int initval=1;int status;
int t;
int P_=2;//nombre de place dans la voiture
int K_=0;//numéro de la tournée


//---mémoire partagé---
memo = memcreate_(argv[1],'A', sizeof(sdata_parc));

sd = shmat(memo, sd, 0);//attacher processus père à mémoire partager


//---initialisation des indexes:
sd->nbEmbarques=0;
sd->nbDebarques=0;
sd->nbtour=1;

//---creation ou recupération du (si il exist dejà) semid:
semcreate(argv[1], lettre,n,&semid);

//---initialiser sem setall:
tab = (ushort *)malloc(n*sizeof(ushort));
//0 mutex1, 1 mutex2, 2 semEmbarquement, 3 semDebarquement, 4 semTousAbord, 5 semTousDehors
for(i=0;i<2;i++)tab[i]=1;
for(i=2;i<n;i++)tab[i]=0;
//for(i=0;i<n;i++)printf("%d  tab,  ",tab[i]);
group_seminit_setall(semid,n,initval,tab,arg);

//---afficher les sémaphores initialiser:
semgetvall( semid, n);

while(1)
{
   K_++;
   Charger(K_);
   for(i=1;i<=P_;i++)
   {
    V(semid, 2);//debloquer P processus client bloqué dans la file de selEmbarquement
   }
   P(semid, 4);// ici le processus voiture se bloque et attend d'etre libérer par le dernier client qui  monte pour ensuite reouler
   Rouler();//afficher un message et sleep 3
   Decharger();//affichage message processus pret pour dechargment
   for(j=1;j<=P_;j++)
   {
    V(semid, 3);//libérer les processus client qui font la queue pour descendre
   }//bloqués dans l'opération P(semDebarquement)
  P(semid, 5);//le processus voiture se bloque ici et attend que le dernier client qui descent le reveil
}//fin while(1)
}
 
