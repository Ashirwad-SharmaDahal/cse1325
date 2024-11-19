#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <map>
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream infile(filename);

    if (!infile) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;

    std::string line;
    while (std::getline(infile, line)) {
        std::istringstream ss(line);
        std::string continent, country, state, region;
        std::string month_str, day_str, year_str, temp_str;

        std::getline(ss, continent, ',');
        std::getline(ss, country, ',');
        std::getline(ss, state, ',');
        std::getline(ss, region, ',');
        std::getline(ss, month_str, ',');
        std::getline(ss, day_str, ',');
        std::getline(ss, year_str, ',');
        std::getline(ss, temp_str, ',');

        int year = std::stoi(year_str);
        int month = std::stoi(month_str);
        int day = std::stoi(day_str);
        double temperature = std::stod(temp_str);

        Date date(year, month, day);
        temps[date] = temperature;
    }

    infile.close();

    while (true) {
        std::cout << "Enter starting date (YYYY MM DD): ";
        int start_year, start_month, start_day;
        if (!(std::cin >> start_year >> start_month >> start_day)) break;

        std::cout << "Enter ending date (YYYY MM DD): ";
        int end_year, end_month, end_day;
        if (!(std::cin >> end_year >> end_month >> end_day)) break;

        Date start_date(start_year, start_month, start_day);
        Date end_date(end_year, end_month, end_day);

        auto it = temps.lower_bound(start_date);
        std::cout << "Date        Temperature (°F)\n";
        std::cout << "=============================\n";
        for (; it != temps.end() && it->first <= end_date; ++it) {
            std::cout << it->first << "    " << it->second << std::endl;
        }
    }

    return 0;
}
