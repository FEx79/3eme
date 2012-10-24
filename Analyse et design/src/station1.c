#include "station1.h"

#include "common.h"


int main(void)
{
    init();
    
    // Boucle principale
    while(1) {
        // Met le bras a droite
        
        wait(PIECE_1, TRUE);
    }
    
    close();
    
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