#ifndef PURSE_H
#define PURSE_H

#include <iostream>
#include <string>

class Purse {
private:
    int _pounds;
    int _shillings;
    int _pence;

    void rationalize();

public:
    static const std::string pound_utf8; 
    Purse(int pounds = 0, int shillings = 0, int pence = 0);

    Purse operator+(const Purse& other) const;
    Purse operator-(const Purse& other) const;
    Purse& operator+=(const Purse& other);
    Purse& operator-=(const Purse& other);

    friend std::ostream& operator<<(std::ostream& os, const Purse& purse);
    friend std::istream& operator>>(std::istream& is, Purse& purse); 
};

#endif 
