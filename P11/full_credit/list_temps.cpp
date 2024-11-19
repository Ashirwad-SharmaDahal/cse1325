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
    std::ifstream file(filename);

    if (!file) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;
    std::string line;

    // Read data from file
    while (std::getline(file, line)) {
        std::istringstream stream(line);
        std::string continent, country, state, region;
        int year, month, day;
        Temp temperature;

        // Extract and ignore the first 4 fields
        std::getline(stream, continent, ',');
        std::getline(stream, country, ',');
        std::getline(stream, state, ',');
        std::getline(stream, region, ',');

        // Extract the remaining fields
        std::string month_str, day_str, year_str, temp_str;
        std::getline(stream, month_str, ',');
        std::getline(stream, day_str, ',');
        std::getline(stream, year_str, ',');
        std::getline(stream, temp_str, ',');

        month = std::stoi(month_str);
        day = std::stoi(day_str);
        year = std::stoi(year_str);
        temperature = std::stod(temp_str);

        temps[Date(year, month, day)] = temperature;
    }

    // Main loop
    while (true) {
        std::cout << "Enter start date (YYYY/MM/DD): ";
        int sYear, sMonth, sDay;
        char sep1, sep2;
        std::cin >> sYear >> sep1 >> sMonth >> sep2 >> sDay;

        if (!std::cin.good())
            break;

        std::cout << "Enter end date (YYYY/MM/DD): ";
        int eYear, eMonth, eDay;
        std::cin >> eYear >> sep1 >> eMonth >> sep2 >> eDay;

        if (!std::cin.good())
            break;

        Date start(sYear, sMonth, sDay), end(eYear, eMonth, eDay);

        // Print results
        std::cout << "Date\t\tTemperature (°F)" << std::endl;
        std::cout << "----------------------------" << std::endl;

        for (auto it = temps.lower_bound(start); it != temps.end() && it->first <= end; ++it) {
            std::cout << it->first << "\t" << std::fixed << std::setprecision(1) << it->second << std::endl;
        }
    }

    return 0;
}
