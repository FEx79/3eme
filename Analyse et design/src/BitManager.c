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
    return (value >> bit) & 1;
}

/**
 * Modifie le bit demand� de la valeur donn�e
 *
 * @param value         Pointeur de la variable dont
 *                      on veut modifier un bit
 * @param bit           Bit d�sir�
 * @param bitValue      Nouvelle valeur
 */
void setBit(int* value, int bit, int bitValue)
{
    int masked;
    int mask = 1 << bit;
    
    if(bitValue)
        *value |= mask;
    else
        *value &= ~mask;
}