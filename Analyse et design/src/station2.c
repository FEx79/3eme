#include "station2.h"

int fd;
int capteurs;
int actuateurs;


int main(void)
{
    // Connexion a la station 2
    int fd = open("/dev/pio_d48", O_RDWR);
    
    // Boucle principale
    while(1) {
        reinitialise();
        processPiece();
    }
    
    close(fd);
    
    return 0;
}


/**
 * Passe la station en attente de pi�ce
 */
void reinitialise()
{
    capteurs = readCapteurs(fd);
    
    // Coussin d'air �teint ?
    // TODO
    
    // Position du pousseur de pi�ce
    // TODO
    
    // Position de l'ascenseur
    // TODO
    
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