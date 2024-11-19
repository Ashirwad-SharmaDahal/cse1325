#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <iomanip>
#include <sstream>
#include <stdexcept>

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

    // Implementing operator>> to stream in the date in "YYYY/MM/DD" format
    friend std::istream& operator>>(std::istream& is, Date& date) {
        std::string dateStr;
        is >> dateStr;

        std::replace(dateStr.begin(), dateStr.end(), '/', ' '); // Replace '/' with space
        std::istringstream dateStream(dateStr);

        int year, month, day;
        if (!(dateStream >> year >> month >> day)) {
            is.setstate(std::ios::failbit); // Fail if format is wrong
            return is;
        }

        date._year = year;
        date._month = month;
        date._day = day;
        return is;
    }
};

#endif
