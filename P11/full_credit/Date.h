#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <iomanip>

class Date {
private:
    int _year;
    int _month;
    int _day;

public:
    Date(int year = 1970, int month = 1, int day = 1)
        : _year(year), _month(month), _day(day) {}

    // Comparison operators
    bool operator==(const Date& rhs) const {
        return _year == rhs._year && _month == rhs._month && _day == rhs._day;
    }
    bool operator!=(const Date& rhs) const {
        return !(*this == rhs);
    }
    bool operator<(const Date& rhs) const {
        if (_year != rhs._year) return _year < rhs._year;
        if (_month != rhs._month) return _month < rhs._month;
        return _day < rhs._day;
    }
    bool operator<=(const Date& rhs) const {
        return *this < rhs || *this == rhs;
    }
    bool operator>(const Date& rhs) const {
        return !(*this <= rhs);
    }
    bool operator>=(const Date& rhs) const {
        return !(*this < rhs);
    }

    friend std::ostream& operator<<(std::ostream& os, const Date& date) {
        char old_fill = os.fill('0');
        os << date._year << "/" 
           << std::setw(2) << date._month << "/"
           << std::setw(2) << date._day;
        os.fill(old_fill);
        return os;
    }
};

#endif 
