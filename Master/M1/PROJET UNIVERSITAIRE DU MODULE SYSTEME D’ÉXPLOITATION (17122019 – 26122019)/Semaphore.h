#ifndef SEMAPHORE_H_
#define SEMAPHORE_H_

#include<stdio.h>
#include<stdlib.h>
#include<sys/wait.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/ipc.h>
#include<sys/sem.h>
#include<string.h>
#include<fcntl.h>
#include<lastlog.h>
#include<paths.h>
//#include<Semaphore.c>

/*typedef struct data
{
int id;
char proc[20];
int tab[10];
}sdata;*/
typedef union semun
{
 int val;
 ushort *array;//Tab poour GETALL, SETALL
 struct semid_ds *buf;//contint les info du groupe, IPC_STAT, IPC_STAT
 struct seminfo *__buf;
}semun;
/*struct sembuf
{
unsigned short sem_num;
short sem_op;
short sem_flg;
};*/
//-------------------------------------------------------------------------
void getsemid(char chemin[], char lettre, unsigned int n, int *sem);
int get_semnum(int semid);
void semcreate(char chemin[],char lettre,unsigned int n, int *sem);
void semgetvall(int semid, unsigned int n);
int semgetv(int semid, unsigned int n);
int get_pid(int semid, unsigned int n);
//----------------------------------------------------------
void supprimer_sem(int semid);
//---------------------------------------------------
void seminit(int semid, unsigned short semnum, int initval, int arg);
//---------------------------------------------------------------
void group_seminit(int semid,unsigned int n,int initval, ushort tab[],semun arg);
//---------------------------------------------------------------
void group_seminit_setall(int semid, unsigned int n,int initval, ushort tab[],semun arg);
//------------------------------------------------------------------------------
int P_TIMED(int semid, unsigned short semnum);
int P(int semid, unsigned short semnum);
int V(int semid, unsigned short semnum);
int Z(int semid, unsigned short semnum);
#endif
