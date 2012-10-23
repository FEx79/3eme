/**
 * Permet d'acc�der a n'importe quel bit d'une variable de type
 * enti�re (int) aussi bien en lecture qu'en �criture.
 */
#ifndef __BITMANAGER__
#define __BITMANAGER__

int getBit(int value, int bit);
int setBit(int* value, int bit, int bitValue);

#endif