#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <iomanip>

class Date {
private:
    int _year, _month, _day;

    int compare(const Date& rhs) const {
        if (_year != rhs._year) return _year - rhs._year;
        if (_month != rhs._month) return _month - rhs._month;
        return _day - rhs._day;
    }

public:
    Date(int year = 1970, int month = 1, int day = 1) 
        : _year(year), _month(month), _day(day) {}

    bool operator==(const Date& rhs) const { return compare(rhs) == 0; }
    bool operator!=(const Date& rhs) const { return compare(rhs) != 0; }
    bool operator<(const Date& rhs) const { return compare(rhs) < 0; }
    bool operator<=(const Date& rhs) const { return compare(rhs) <= 0; }
    bool operator>(const Date& rhs) const { return compare(rhs) > 0; }
    bool operator>=(const Date& rhs) const { return compare(rhs) >= 0; }

    friend std::ostream& operator<<(std::ostream& ost, const Date& date) {
        char old_setfill = ost.fill(); // Save the current fill character
        ost << std::setw(4) << date._year << '/'
            << std::setfill('0') << std::setw(2) << date._month << '/'
            << std::setw(2) << date._day << std::setfill(old_setfill);
        return ost;
    }
};

#endif
