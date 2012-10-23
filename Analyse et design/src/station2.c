#include "station2.h"

#include "common.h"


int main(void)
{
    init();
    
    // Boucle principale
    while(1) {
        reinitialise();
        processPiece();
    }
    
    close();
    
    return 0;
}


/**
 * Passe la station en attente de pi�ce
 */
void reinitialise()
{
    // Coussin d'air �teint ?
    setActuateur(COUSSIN_AIR, OFF);
    
    // Position du pousseur de pi�ce
    setActuateur(PP, OFF);
    wait(PP_RENTRE, TRUE);
    
    // Position de l'ascenseur
    setActuateur(ASC_MONTE, OFF);
    setActuateur(ASC_DESCEND, ON);
    wait(ASC_BAS, TRUE);
    setActuateur(ASC_DESCEND, OFF);
    
    // Pr�viens la station 1 qu'on attend une pi�ce
    // TODO
}

/**
 * R�alise le parcourt avec la pi�ce courante
 */
void processPiece()
{
    // TODO
    
    // Pr�viens la station 3 qu'on lui donne une pi�ce
    // TODO
}