#include "station2.h"

#include "common.h"
#include "network.h"
#include <stdio.h>
#include <sys/ioctl.h>
#include <signal.h>
#include <unistd.h>

void reinitialise();
void processPiece();
void* receiveFrom1(void* arg);
void* receiveFrom3(void* arg);
void handlerEnd(int signo);

int station_1;
int station_3;
pthread_t receive_1, receive_3;

int main(void)
{
    initSignal(handlerEnd);
    
    // Initialise les mutex
    pthread_mutex_init(&mutex_received, NULL);
    pthread_mutex_init(&mutex_give, NULL);
    
    // Cree un thread qui ecoutera ce que la station 1 et 3 lui dira
    if(pthread_create(&receive_1, NULL, receiveFrom1, NULL) != 0 ||
       pthread_create(&receive_3, NULL, receiveFrom3, NULL) != 0) {
        printf("Erreur thread\n");
        return 1;
    }
    
    initSend(&station_1, ADDR_STATION_1, PORT_LISTEN_1_2);
    initSend(&station_3, ADDR_STATION_3, PORT_LISTEN_3_2);
    
    initLink();
        
    // Boucle principale
    while(1) {
        reinitialise();
        processPiece();
    }
    
    return 0;
}


/**
 * Passe la station en attente de piece
 */
void reinitialise()
{
    // Coussin d'air eteint ?
    setActuateur(COUSSIN_AIR, OFF);
    
    // Position du pousseur de piece
    setActuateur(PP, OFF);
    wait(PP_RENTRE, TRUE);
    
    // Position de l'ascenseur
    setActuateur(ASC_MONTE, OFF);
    setActuateur(ASC_DESCEND, ON);
    wait(ASC_BAS, TRUE);
    setActuateur(ASC_DESCEND, OFF);
    
    // Previens la station 1 qu'on attend une piece
    SendTo(station_1, ADDR_STATION_1, PORT_LISTEN_1_2, "ATTEND_PIECE", 12);
    setPieceReceived(FALSE);
}

/**
 * Realise le parcourt avec la piece courante
 */
void processPiece()
{
    // Attend que la station 1 nous ai donn� une pi�ce
    while(!getPieceReceived())
        waitTime(500);
    
    wait(PIECE, TRUE);
    waitTime(1000);

    // Monte l'ascenseur
    setActuateur(ASC_DESCEND, OFF);
    setActuateur(ASC_MONTE, ON);
    wait(ASC_HAUT, TRUE);
    setActuateur(ASC_MONTE, OFF);
    
    // Attend que la station 3 soit en r�c�ption
    while(!getCanGivePiece())
        waitTime(500);
    
    // Active le pousseur
    setActuateur(PP, ON);
    waitTime(1000);
    setActuateur(PP, OFF);
    
    // Active le coussin
    setActuateur(COUSSIN_AIR, ON);
    waitTime(2000);
    setActuateur(COUSSIN_AIR, OFF);
    
    // Previens la station 3 qu'on lui donne une piece
    SendTo(station_3, ADDR_STATION_3, PORT_LISTEN_3_2, "DONNE_PIECE", 11);
    setCanGivePiece(FALSE);
}

/**
 * Recoit les messages de la station 1
 */
void* receiveFrom1(void* arg)
{
    char buffer[BUFFER_SIZE];
    struct sockaddr_in addr;
    int v, sockRecv, addr_len, erreur = -1;
    
    initListen(&sockRecv, &addr, PORT_LISTEN_2_1);
    
    // Reception des donnees
    while(1) {
        addr_len = sizeof(addr);
        if ((v = recvfrom(sockRecv, buffer, BUFFER_SIZE, 0, (struct sockaddr *)&addr, &addr_len)) > 0) {
            printf("%s\n", buffer);
            
            // Indique que la station 1 nous a donn� une pi�ce
            if(strcmp("DONNE_PIECE", buffer)) {
                setPieceReceived(TRUE);
        }
    }
}

/**
 * Recoit les messages de la station 3
 */
void* receiveFrom3(void* arg)
{
    char buffer[BUFFER_SIZE];
    struct sockaddr_in addr;
    int v, sockRecv, addr_len, erreur = -1;
    
    initListen(&sockRecv, &addr, PORT_LISTEN_2_3);
    
    // Reception des donnees
    while(1) {
        addr_len = sizeof(addr);
        if ((v = recvfrom(sockRecv, buffer, BUFFER_SIZE, 0, (struct sockaddr *)&addr, &addr_len)) > 0) {
            printf("Recu; %s\n", buffer);
            
            // Indique que la station 3 attend une pi�ce
            if(strcmp("ATTEND_PIECE", buffer)) {
                setCanGivePiece(TRUE);
            }
        }
    }
}