#include "Memoire.h"
//__deux modes de cr�ation enfin fonction
//pour r�server une m�moire partag�  
//....une qui g�n�re la cl� dans son corps l'autre le prend comme param�tre
//_________on a utilis� memcreate_______
int memocreate(key_t key, size_t size)
{
int shmid = shmget(key,size,IPC_CREAT| IPC_EXCL| 0666);
if(shmid==-1){shmid=shmget(key,size,0);printf("Le segment mémoire %d existe déjà\n",shmid);}
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
if(shmid==-1){shmid=shmget(key,size,0);printf("Le segment mémoire %d existe déjà\n",shmid);}
else {printf("memo = %d\n",shmid);}
return shmid;
}

