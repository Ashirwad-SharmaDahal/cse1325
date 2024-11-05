#include "clock.h"
#include <iostream>
#include <stdexcept>

int main(int argc, char* argv[]) {
    
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Clock clock(hours, minutes, seconds);

        while (true) {
            clock.print(); 

            std::string input;
            std::cout << "Enter 'q' to quit or press Enter to tic: ";
            std::getline(std::cin, input);

            if (input == "q") break;

            clock.tic(); 
        }
    } catch (const std::out_of_range& e) {
        std::cerr << e.what() << std::endl;
        return -2;
    } catch (const std::invalid_argument&) {
        std::cerr << "Invalid time arguments provided." << std::endl;
        return -1;
    }

    return 0;
}
