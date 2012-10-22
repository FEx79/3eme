#include "BitManager.h"

/**
 * Donne le bit demand� de la valeur donn�e
 *
 * @param value         Valeur dont on veut extraire un bit
 * @param bit           Bit d�sir�
 *
 * @return              Valeur du bit demand�
 */
int getBit(int value, int bit)
{
    /*int mask = 1 << bit;
    int masked = value & mask;
    
    return masked >> bit;*/
    return (value >> bit) & 1;
}

/**
 * Modifie le bit demand� de la valeur donn�e
 *
 * @param value         Valeur dont on veut modifier un bit
 * @param bit           Bit d�sir�
 * @param bitValue      Nouvelle valeur
 *
 * @return              Nouvelle valeur avec le bit modifi�
 */
int setBit(int value, int bit, int bitValue)
{
    int masked;
    int mask = 1 << bit;
    
    if(bitValue)
        return value | mask;
    else
        return value & ~mask;
}