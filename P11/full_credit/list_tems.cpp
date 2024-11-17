#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <map>
#include "Date.h"

typedef double Temp;

int main(int argc[], char* argv[]) {
	if(argc != 2){
		std::cout << "Usage: " <<argv[0] << " <data file> " << std::endl;
		return 1;
	}

	std::ifstream infile(argv[1]);
	if (!infile) {
		std::cerr << "Cannot open input file" << argv[1] << std::endl;
		return 1;
	}

	std::map<Date, Temp> temps;

	std::string line;
	while (std::getline(infile, line)) {
		std::stringstream ss(line);
		std::string, date_str, temp_str;

		std::getline(ss, date_str, ',');
		std::getline(ss, temp_str);

		Date date(date_str);
		Temp temperature = std::stod(temp_str);

		temps[date] = temperature;
	}

	std::cout << "Enter start date(YYYY/MM/DD): ";
	std::string start_date_str;
	std::cin >> start_date_str;

	std::cout << "Enter end date(YYYY/MM/DD): ";
	std::string end_date_str;
	std::cin >> end_date_str;

	Date start_date(start_date_str);
	Date end_date(end_date_str);

	auto it = temps.lower_bound(start_date);
	while(it != temps.end && it->first <= end_date){
		std::cout << it->first << ": " << it->second << std::endl;
		++it;

	}

	return 0;

	
}