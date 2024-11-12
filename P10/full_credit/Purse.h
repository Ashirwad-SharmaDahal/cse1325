#ifndef PURSE_H
#define PURSE_H

#include <iostream>

class Purse {
private:
    int _pounds;
    int _shillings;
    int _pence;

    void rationalize();

public:
    Purse(int pounds = 0, int shillings = 0, int pence = 0);

    Purse operator+(const Purse& other) const;
    Purse operator-(const Purse& other) const;
    Purse& operator+=(const Purse& other);
    Purse& operator-=(const Purse& other);

    friend std::ostream& operator<<(std::ostream& os, const Purse& purse);
};

#endif 
