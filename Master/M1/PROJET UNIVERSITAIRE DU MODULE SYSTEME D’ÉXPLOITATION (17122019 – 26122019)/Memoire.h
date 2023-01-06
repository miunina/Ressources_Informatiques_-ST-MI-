 
#include<stdio.h>
#include<stdlib.h>
#include<sys/wait.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/ipc.h>
#include<sys/sem.h>
#include<sys/shm.h>
#include<string.h>
#include<fcntl.h>
#include<lastlog.h>
#include<paths.h>
//_________différente structure _____ utiliser commen ressources partagé 
//_________peuvent etre implémenté dans différent problèmes
typedef struct data
{
int id;
char proc[20];
int tab[10];
}sdata;
typedef struct data_producer_consumer
{
int indxl;
int indxr;
int tab[10];
}sdata_producer_consumer;
typedef struct data_parc
{
int nbEmbarques;
int nbDebarques;
int nbtour;
}sdata_parc;
int memocreate(key_t key, size_t size);
int memcreate_(char chemin[],int lettre, size_t size);
