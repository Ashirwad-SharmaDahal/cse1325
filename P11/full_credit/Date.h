#ifndef DATE_H
#define DATE_H

#include <iostream>
#include<iomanip>

class Date{
private:
	int _year, int _month, int _day;

	int compare(const Date& other) const{
		if(_year != other._year){
			return _year < other._year? -1 : 1;
		}
		if(_month != other._month){
			return _month < other._month? -1 : 1;	
		}
		if(_day != other._day){
			return _day < other._day? -1 : 1;
		}	
		return 0;
	}

public:
	Date(int year = 1970, int month = 1, int day = 1)
		: _year(year), _month(month), _day(day) {}

	bool operator==(const Date& other) const { return compare(other) == 0; }
	bool operator!=(const Date& other) const {return compare(other) !=  0; }
	bool operator<(const Date& other) const { return compare(other) < 0; }
	bool operator<=(const Date& other) const{ return compare(other) <= 0; }
	bool operator>(const Date& other) const { return compare(other) > 0; }
	bool operator>=(const Date& other) const { return compare(other) >= 0; }		
		
	friend std::ostream& operator<<(std::ostream& os, const Date& date){
		char old_fill = os.fill();
		os << std::setw(4) << std::setfill('0') << date._year << "/"
		   << std::setw(2) << std::setfill('0') << date._month << "/"
		   << std::setw(2) << std::setfill('0') << date._day << "/"
		os.fill(old_fill);
		return os;
	}
};
#endif
