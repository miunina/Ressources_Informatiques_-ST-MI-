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
{

int nb;//variable popur recupere le nb tour
//---declaration des variables---
unsigned int time_sleep;unsigned int x;int i,j;pid_t pid;
ushort *tab;sdata_parc *sd = NULL;//initialiser au null
semun arg;int n=6;int lettre = 21;int semid;
key_t key_memo;int memo;int initval=1;int status;
int nt;//variable pour stocker le nombre de clients
int P_=2;//nombre de place dans la voiture
int K_=0;//numéro de la tournée


//__________________________________
//---mémoire partagé---
memo = memcreate_(argv[1],'A', sizeof(sdata_parc));
sd = shmat(memo, sd, 0);//attacher processus père à mémoire partager


//__________________________________
//---creation ou recupération du (si il exist dejà) semid:
semcreate(argv[1], lettre,n,&semid);


//__________________________________
//---afficher les sémaphores initialiser:
semgetvall( semid, n);


//__________________________________

printf("Donnez le nombre de client : ");
scanf("%d",&nt);
pid_t child_pid[nt];
for(i=0;i<nt;i++)
{
	pid=fork();
	if(pid == -1)
	{  
        printf("erreur fork \n");
        exit(0);
    }	
  if(pid==0)
  {
    nb=sd->nbtour;//recupere le nombre de tour
    while(1)
   {
       if(nb==0){exit(0);}//si le client a fait tt les tour il quite
       nb--;
       P(semid, 2);//faire la chaine pour moner attendre d'etre libéré par le processus voiture
       Embarquement();//affichage : client pid je vais monter
       P(semid, 0);//protege variable/
       sd->nbEmbarques++;
       if(sd->nbEmbarques==P_)
       {
           V(semid, 4);//debloquer le processus voiture en fin d'embarquement
           // c'est le dernier processus client qui va reveiller
           sd->nbEmbarques=0;
        }
       V(semid,0);//liberer la SC
       EnBalade();
       P(semid,3);
       Debarquement();
       P(semid, 1);//protege la variable debarquer
       sd->nbDebarques++;
       if(sd->nbDebarques==P_)
       {
          V(semid,5);
	       //debloquer le prcessus voiture en fin de debarquement_ quand 
	        //tout le monde est descendu voiture est reveiller pour qu'il charge à nouveau
          sd->nbDebarques=0;
       }
       V(semid,1);
       sleep(3);
       //exit(0); si il ny a pas de nbTour 
       //dans les question 1 et 2 
    }//fin while
  }//fin if pid == 0
  else
   {
	child_pid[i]=pid;
   }
}//fin for

//Attente de pere de ses child_pid 
for(int i = 0; i < nt; i++){
    waitpid(child_pid[i],&status,0);
}

exit(0);}
 

