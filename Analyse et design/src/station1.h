#ifndef __STATION2__
#define __STATION2__

// Actuateurs
#define PP1_OUT         0  /* byte 0 */  // Fait sortir le pousseur pi�ce 1    
#define PP1_IN          1  /* byte 0 */  // Fait rentrer le pousseur pi�ce 1
#define PP2_OUT         2  /* byte 0 */  // Fait sortir le pousseur pi�ce 2
#define PP2_IN          3  /* byte 0 */  // Fait rentrer le pousseur pi�ce 2
#define PP3_OUT         4  /* byte 0 */  // Fait sortir le pousseur pi�ce 3
#define PP3_IN          5  /* byte 0 */  // Fait rentrer le pousseur pi�ce 3
#define MAIN_P          6  /* byte 0 */  // Fait rentrer/sortir le pousseur principal
#define BRAS_POSITION   8  /* byte 1 */  // D�place le bras de gauche � droite
#define ASPIRATION      10 /* byte 1 */  // Aspiration

// Capteurs
#define MAIN_P_RENTRE   0  /* byte 0 */  // Pousseur rentr�
#define PP1_RENTRE      1  /* byte 0 */  // PP1 rentr�
#define PP2_RENTRE      2  /* byte 0 */  // PP2 rentr�
#define PP3_RENTRE      3  /* byte 0 */  // PP3 rentr�
#define BRAS_DROITE     4  /* byte 0 */  // Bras � droite
#define PIECE_1         5  /* byte 0 */  // Pi�ce pr�sente dans tube 1
#define PIECE_2         6  /* byte 0 */  // Pi�ce pr�sente dans tube 2
#define PIECE_3         7  /* byte 0 */  // Pi�ce pr�sente dans tube 3
#define MAIN_P_SORTIT   8  /* byte 1 */  // Pousseur sortit
#define PP1_SORTIT      9  /* byte 1 */  // PP1 sortit
#define PP2_SORTIT      10 /* byte 1 */  // PP2 sortit
#define PP3_SORTIT      11 /* byte 1 */  // PP3 sortit
#define BRAS_DROITE     12 /* byte 1 */  // Bras � gauche
#define PIECE_ASPIRE    13 /* byte 1 */  // Piece aspir�e

#endif