#include "Semaphore.h"/*AKLI Yassamine _ AITHAMMOUDA Kenza / RSD/ G2 2019*/
#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include "Memoire.h"
#include<math.h>
#include<time.h>
//__________________Embarquement_EnBalade_Debarquement_______________
void Embarquement()
{
printf("\nEMBARQUEMENT client pid = %d\n",getpid());fflush(stdout);
}
void EnBalade()
{
printf("BALADE client pid  = %d :)\n", getpid());fflush(stdout);
sleep(1);
}
void Debarquement()
{
printf("FIN client pid = %d  :(\n\n",getpid());fflush(stdout);
}
//___________________________________________________________________
//_________________________main______________________________________
int main(char argc, char *argv[])
{int nb;//variable popur recupere le nb tour
//---declaration des variables---
unsigned int time_sleep;unsigned int x;int i,j;pid_t pid;
ushort *tab;sdata_parc *sd = NULL;//initialiser au null
semun arg;int n=6;int lettre = 1;int semid;//semun arg;
key_t key_memo;int memo;int initval=1;int status;
int nt;int P_=7;//nombre de place dans la voiture
int K_=0;//numéro de la tournée
nb=1;

//int semEmbarquement=5,semDebarquement=4,mutex1=3,mutex2=2,semTousAbord=1,semTousDehord=0,RDV=6;


//---mémoire partagé---
memo = memcreate_(argv[1],11, sizeof(sdata_parc));

sd = shmat(memo, sd, 0);//attacher processus père à mémoire partager
sd->nbEmbarques = 0;
sd->nbDebarques = 0;

//---creation ou recupération du (si il exist dejà) semid:
semcreate(argv[1], lettre,n,&semid);

//---afficher les sémaphores initialiser:
semgetvall( semid, n);


printf("Donnez le nombre de client : ");fflush(stdout);

scanf("%d",&nt);

pid_t child_pid[nt];

for(int i = 0; i < nt; i++)
{
    pid = fork();
    if(pid == -1){  
        printf("erreur fork \n");
        exit(0);
    }
    if(pid == 0)
	{  
	while (1)
	{

	P(semid,2);//faire la chaine pour moner attendre d'etre libéré par le processus voiture
 	Embarquement();//affichage : client pid je vais monter
	P(semid,0);//protege variable/
	sd->nbEmbarques++;
	if (sd->nbEmbarques>P_/3) 
	{  
		V(semid,4);
	}
	V(semid,0);//liberer la SC
	EnBalade();  
	P(semid,3);
	Debarquement();
	P(semid,1);//protege la variable debarquer
	sd->nbDebarques++;
	if (sd->nbDebarques==P_) 
	{  
		V(semid,5); //debloquer le prcessus voiture en fin de debarquement_ quand 
	        //tout le monde est descendu voiture est reveiller pour qu'il charge à nouveau
	} 

	V(semid,1);//liberer la SC
 	sleep(2);
	nb++;
	if(nb>sd->nbtour){exit(0);}//si le client a fait tt les tour il quite
	}
   }else
   {
	child_pid[i]=pid;
   }
}

//Attente de pere de ses child_pid 
for(int i = 0; i < nt; i++){
    waitpid(child_pid[i],&status,0);
}


exit(0);}

 

