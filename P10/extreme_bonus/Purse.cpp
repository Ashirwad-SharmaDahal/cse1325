#include "Purse.h"

const std::string Purse::pound_utf8 = "£";  

Purse::Purse(int pounds, int shillings, int pence)
    : _pounds(pounds), _shillings(shillings), _pence(pence) {
    rationalize();
}

void Purse::rationalize() {
    if (_pence >= 12) {
        _shillings += _pence / 12;
        _pence %= 12;
    }
    if (_shillings >= 20) {
        _pounds += _shillings / 20;
        _shillings %= 20;
    }
}

Purse Purse::operator+(const Purse& other) const {
    return Purse(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
}

Purse Purse::operator-(const Purse& other) const {
    return Purse(_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence);
}

Purse& Purse::operator+=(const Purse& other) {
    _pounds += other._pounds;
    _shillings += other._shillings;
    _pence += other._pence;
    rationalize();
    return *this;
}

Purse& Purse::operator-=(const Purse& other) {
    _pounds -= other._pounds;
    _shillings -= other._shillings;
    _pence -= other._pence;
    rationalize();
    return *this;
}

std::ostream& operator<<(std::ostream& os, const Purse& purse) {
    os << Purse::pound_utf8 << purse._pounds << " " << purse._shillings << "s " << purse._pence << "d";
    return os;
}

std::istream& operator>>(std::istream& is, Purse& purse) {
    std::string poundSymbol;
    char shillingSymbol, penceSymbol;

    is >> poundSymbol >> purse._pounds >> purse._shillings >> shillingSymbol >> purse._pence >> penceSymbol;
    
    if (poundSymbol == Purse::pound_utf8 && shillingSymbol == 's' && penceSymbol == 'd') {
        purse.rationalize();
    } else {
        is.setstate(std::ios::failbit);  
    }
    return is;
}
