#include "station1.h"

#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/types.h>
#include <netdb.h>
#include <string.h>

#include "common.h"
#include "network.h"

void* receiveFrom2(void* arg);

// Indique si on peut envoyer une pi�ce sur la station 2
int canSend = 0;
int sockSend;


int main(void)
{
    
    // Cr�e un thread qui ecoutera ce que la station 2 lui dira
    pthread_t th;
    if(pthread_create(&th, NULL, thread_receive, NULL) != 0) {
        write(1, "Erreur thread\n", 40);
        return 1;
    }
    
    // Socket pour envoyer des messages
    if((sockSend = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        write(1, "Creation de socket echouee\n", 40);
        return 1;
    }
    
    initLink();
    
    // Met le bras a droite
    setActuateur(BRAS_POSITION, OFF);
    
    SendTo(sockSend, ADDR_STATION_2, PORT_LISTEN_2_1, "SALUT", 6);
    
    // Boucle principale
    while(1) {
    }
    
    closeLink();
    
    return 0;
}

/**
 * Place la station en position initiale
 */
void reinitialise()
{
    // Stoppe l'aspiration
    setActuateur(ASPIRATION, OFF);
    wait(PIECE_ASPIRE, FALSE);
    
    // Place le bras a gauche pour d�bloquer la station 2
    setActuateur(BRAS_POSITION, OFF);
    wait(BRAS_GAUCHE, TRUE);
    
    // Place le poussoir principal en position rentr�e
    setActuateur(MAIN_P, OFF);
    wait(MAIN_P_RENTRE, TRUE);
    
    // Rentre tout les poussoir secondaires
    setActuateur(PP1_OUT, OFF);
    setActuateur(PP2_OUT, OFF);
    setActuateur(PP3_OUT, OFF);
    setActuateur(PP1_IN, ON);
    setActuateur(PP2_IN, ON);
    setActuateur(PP3_IN, ON);
    wait(PP1_RENTRE, TRUE);
    wait(PP2_RENTRE, TRUE);
    wait(PP3_RENTRE, TRUE);
}

/**
 * Traite une pi�ce et l'amm�nne vers la station 2
 */
void processPiece()
{
    // Ame�nne le bras a droite
    
    // Pi�ce dans le tube 1
    if(getCapteur(PIECE_1)) {
        setActuateur(PP1_IN, OFF);
        setActuateur(PP1_OUT, ON);
        wait(PP1_SORTIT, TRUE);
        
        setActuateur(PP1_OUT, OFF);
        setActuateur(PP1_IN, ON);
        wait(PP1_RENTRE, TRUE);
    }
    // Pi�ce dans le tube 2
    else if(getCapteur(PIECE_2)) {
        setActuateur(PP2_IN, OFF);
        setActuateur(PP2_OUT, ON);
        wait(PP2_SORTIT, TRUE);
        
        setActuateur(PP2_OUT, OFF);
        setActuateur(PP2_IN, ON);
        wait(PP2_RENTRE, TRUE);
    }
    // Pi�ce dans le tube 3
    else if(getCapteur(PIECE_3)) {
        setActuateur(PP3_IN, OFF);
        setActuateur(PP3_OUT, ON);
        wait(PP3_SORTIT, TRUE);
        
        setActuateur(PP3_OUT, OFF);
        setActuateur(PP3_IN, ON);
        wait(PP3_RENTRE, TRUE);
    }
    
    // Active le poussoir principal
}

/**
 * Recoit les messages de la station 2
 */
void* receiveFrom2(void* arg)
{
    char buffer[BUFFER_SIZE];
    struct sockaddr_in addr;
    int v, sockRecv, addr_len;
    
    initListen(&sockRecv, &addr, PORT_LISTEN_1_2);
    
    // R�ception des donn�es
    while(1) {
        addr_len = sizeof(addr);
        
        if ((v = recvfrom(sockRecv, buffer, BUFFER_SIZE, 0, (struct sockaddr *)&addr, &addr_len)) > 0) {
            write(1, buffer, BUFFER_SIZE);
        }
    }
}