#include <iostream>
#include <fstream>
#include <sstream>
#include <map>
#include <iomanip>
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>\n";
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream file(filename);
    if (!file) {
        std::cerr << "Can't open input file " << filename << "\n";
        return 1;
    }

    std::map<Date, Temp> temps;

    std::string line;
    while (std::getline(file, line)) {
        std::istringstream stream(line);
        std::string field;

        // Skip over the first three fields
        for (int i = 0; i < 4; ++i) {
            std::getline(stream, field, ',');
        }

        int month, day, year;
        std::getline(stream, field, ',');
        month = std::stoi(field);
        std::getline(stream, field, ',');
        day = std::stoi(field);
        std::getline(stream, field, ',');
        year = std::stoi(field);

        double temperature;
        std::getline(stream, field, ',');
        temperature = std::stod(field);

        temps[Date(year, month, day)] = temperature;
    }

    while (std::cin.good()) {
        std::cout << "Enter start date (YYYY/MM/DD): ";
        Date startDate;
        std::cin >> startDate;

        // Exit the program if input fails
        if (!std::cin.good()) {
            std::cerr << "Input failed. Exiting...\n";
            return 1;
        }

        // Check if the start date is in the map
        if (temps.find(startDate) == temps.end()) {
            std::cout << startDate << " is not in the database!" << std::endl;
            continue;
        }

        std::cout << "Enter end date (YYYY/MM/DD): ";
        Date endDate;
        std::cin >> endDate;

        // Exit the program if input fails
        if (!std::cin.good()) {
            std::cerr << "Input failed. Exiting...\n";
            return 1;
        }

        // Check if the end date is earlier than the start date
        if (endDate < startDate) {
            std::cout << endDate << " is earlier than " << startDate << std::endl;
            continue;
        }

        // If both dates are valid, display the temperature data
        auto it = temps.lower_bound(startDate);
        std::cout << std::setw(12) << "Date" << std::setw(12) << "Temperature\n";
        std::cout << "--------------------------\n";

        while (it != temps.end() && it->first <= endDate) {
            std::cout << std::setw(12) << it->first << " "
                      << std::setw(10) << std::fixed << std::setprecision(2) << it->second << "\n";
            ++it;
        }
    }

    return 0;
}
