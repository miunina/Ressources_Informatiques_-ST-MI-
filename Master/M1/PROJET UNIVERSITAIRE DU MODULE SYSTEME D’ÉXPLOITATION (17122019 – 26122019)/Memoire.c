#include "Memoire.h"
//__deux modes de création enfin fonction
//pour réserver une mémoire partagé  
//....une qui génére la clé dans son corps l'autre le prend comme paramètre
//_________on a utilisé memcreate_______
int memocreate(key_t key, size_t size)
{
int shmid = shmget(key,size,IPC_CREAT| IPC_EXCL| 0666);
if(shmid==-1){shmid=shmget(key,size,0);printf("Le segment mÃ©moire %d existe dÃ©jÃ \n",shmid);}
else printf("memo = %d\n",shmid);
return shmid;
}
int memcreate_(char chemin[],int lettre, size_t size)
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
//appel de la fonction
//--------decalaration memoire: 
key_t key =ftok(chemin,lettre);
 
int shmid = shmget(key,size,IPC_CREAT| IPC_EXCL| 0666);
if(shmid==-1){shmid=shmget(key,size,0);printf("Le segment mÃ©moire %d existe dÃ©jÃ \n",shmid);}
else {printf("memo = %d\n",shmid);}
return shmid;
}

