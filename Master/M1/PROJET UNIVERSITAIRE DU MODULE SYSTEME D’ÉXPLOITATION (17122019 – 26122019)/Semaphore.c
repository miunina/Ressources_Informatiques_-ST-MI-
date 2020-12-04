
#include "Semaphore.h"

/* Definition of _PATH_LASTLOG */
/* Declaration of userIdFromName() */
//struct semid_ds

//-------------------------------------------------------------------------
void getsemid(char chemin[], char lettre, unsigned int n, int *sem)
{int acctFile;
if (strlen(chemin)==0)
	{
          chemin = (char *)malloc(3*sizeof(char));
          chemin[0]='.';chemin[0]='.';chemin[0]='/';
	}
else
{
  acctFile = open(chemin, O_RDONLY);
  if(acctFile == -1)
	{
           chemin = (char *)malloc(3*sizeof(char));
           chemin[0]='.';chemin[0]='.';chemin[0]='/';
        }
}
key_t key =ftok(chemin,lettre);
  *sem=semget(key,n,IPC_CREAT|IPC_EXCL|0666);
  if(*sem == -1)
  {
    perror("semget\n");
    printf("groupe n existe apas\n");
  }
  else
  {
     printf("le semid est =  %d\n",*sem);
  }


}
//----------------------------------------------------------
int get_semnum(int semid)
{
semun arg;
struct semid_ds ds;
arg.buf=&ds;
semctl(semid,0,IPC_STAT,arg);
return ds.sem_nsems;
}
//----------------------------------------------------------
void semcreate(char chemin[],char lettre,unsigned int n, int *sem)
{
int acctFile;
if (strlen(chemin)==0)
	{
          chemin = (char *)malloc(3*sizeof(char));
          chemin[0]='.';chemin[0]='.';chemin[0]='/';	  
	}
else
{
  acctFile = open(chemin, O_RDONLY);
  if(acctFile == -1)
	{
           chemin = (char *)malloc(3*sizeof(char));
           chemin[0]='.';chemin[0]='.';chemin[0]='/';
        }
}
//appel de la fonction
//--------decalaration semphore: 
  key_t key =ftok(chemin,lettre);
  *sem=semget(key,n,IPC_CREAT|IPC_EXCL|0666);
  if(*sem == -1)
  {
    perror("semget\n");
    printf("groupe déjà existant avec semget= %d\n",*sem);
    *sem=semget(key,n,0);
  }
  else
  {
     printf("le semid est %d\n",*sem);
  }
}
//----------------------------------------------------------
void semgetvall(int semid, unsigned int n)
{int i;
 printf("___getval__all__\n");
 for(i=0;i<n;i++)
 {
  semgetv(semid, i);
 }
}
//----------------------------------------------------------
int semgetv(int semid, unsigned int n)
{int i;int val1;

 val1=semctl(semid,n,GETVAL,NULL);
 printf(" val de sem [%d]= %d;\n",n,val1);
 return val1;
}
//----------------------------------------------------------
int get_pid(int semid, unsigned int n)
{int val1;
val1=semctl(semid, n, GETPID, 0);
printf(" pid of sem %d which numsem=%d  is %d",semid, n, val1);
return val1;
}
void supprimer_sem(int semid)
{
semctl(semid,0,IPC_RMID,0);
}
//---------------------------------------------------
void seminit(int semid, unsigned short semnum, int initval, int arg)
{arg=initval;	 
 semctl(semid,semnum, SETALL,arg);
}
//---------------------------------------------------------------
void group_seminit(int semid, unsigned int n,int initval, ushort tab[],semun arg)
{
arg.val = initval;
arg.array=tab;
int r;int i;
struct semid_ds s;
arg.buf=&s;
int f=semctl(semid,0,IPC_STAT,arg);
printf("\n\n___initialiser__group__sem__setvall___\n");
if(f==0)
 {
    arg.buf->sem_nsems=n;
    printf("ipc_stat = %d\nnombre de semaphore arg.buf->nsems=%d\n",f,n);
    for(i=0;i<n;i++) 
    {  	
	seminit( semid, i, tab[i], arg.array[i]);
    }

 }
}
//---------------------------------------------------------------
void group_seminit_setall(int semid, unsigned int n,int initval, ushort tab[],semun arg)
{
arg.val = initval;
arg.array=tab;
int r;int i;
struct semid_ds s;
arg.buf=&s;
int f=semctl(semid,0,IPC_STAT,arg);
printf("\n\n___initialiser__group__sem__setvall___\n");
if(f==0)
 {
    arg.buf->sem_nsems=n;
    printf("ipc_stat = %d\nnombre de semaphore arg.buf->nsems=%d\n",f,n);
      for(i=0;i<n;i++) 
    {  	
        arg.array[i]=tab[i];
	semctl(semid, i, SETALL, arg);
    }

 }
}
//----------------------------------------------------------------
int P(int semid, unsigned short semnum)
{ struct sembuf ops[1];
  ops[0].sem_num=semnum;
  ops[0].sem_op=-1;
  ops[0].sem_flg=SEM_UNDO;/*on positionne le flag sur 0: opération bloquante + sem undo pour éviter l'interblocage*///avant le reglage (question1 et 2) on a mit 0
//si un processus doit s'endormir la valeur
//initial des sémaphores (avant l'apple)est restitué
  int r=semop(semid,ops,1);
  
  if(r==-1){perror("semop erroor");}
  //else{printf("After P %d  ",r);semgetv(semid,semnum);}
  return r;
}
int V(int semid, unsigned short semnum)
{ struct sembuf ops[1];
  ops[0].sem_num=semnum;
  ops[0].sem_op=1;
  ops[0].sem_flg=0;//SEM_UNDO;
  int r=semop(semid,ops,1);
  if(r==-1){perror("semop erroor");}
 // else{printf("After V %d  ",r);semgetv(semid,semnum);printf("\n\n");}
  return r;
}
int Z(int semid, unsigned short semnum)
{ struct sembuf ops[1];
  ops[0].sem_num=semnum;
  ops[0].sem_op=0;
  ops[0].sem_flg=0;
  int r=semop(semid,ops,1);
  if(r==-1){perror("semop erroor");}
  //else{printf("After Z %d  ",r);}
  return r;
}
int P_TIMED(int semid, unsigned short semnum)
{
struct sembuf ops[1];
ops[0].sem_op=-1;
ops[0].sem_num=semnum;
ops[0].sem_flg=0;
return 0;//semtimedop(semid, &ops, 1, 20);
}
//------------------------------------------------------
/*int main(char argc, char *argv[])
{
//declaration
int semid;
int i;
semun arg;
int initval=atoi(argv[4]);
int n=atoi(argv[3]);
int lettre = atoi(argv[2]);
ushort *tab;
tab = (ushort *)malloc(n*sizeof(ushort));
if(argc<4){n=4;lettre=26;}
if(n>4){n=4;ushort tab[4]={0,0,0,0};}
else{for(i=0;i<n;i++)tab[i]=initval;}

//creation / recup(si il exist dejà) semid:
semcreate(argv[1], lettre,n,&semid);

//initialiser sem setall:
group_seminit(semid,n,initval,tab,arg);

//sem getval:
semgetvall( semid, n);
}*/
//----------------------------------------------------

