#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds) 
    : _hours(hours), _minutes(minutes), _seconds(seconds) {
    // Validate hours, minutes, and seconds
    if (hours < 0 || hours > 23) {
        throw std::out_of_range("Hours must be between 0 and 23");
    }
    if (minutes < 0 || minutes > 59) {
        throw std::out_of_range("Minutes must be between 0 and 59");
    }
    if (seconds < 0 || seconds > 59) {
        throw std::out_of_range("Seconds must be between 0 and 59");
    }
}

void Clock::print() const {
   
    std::cout << std::setw(2) << std::setfill('0') << _hours << ":"
              << std::setw(2) << std::setfill('0') << _minutes << ":"
              << std::setw(2) << std::setfill('0') << _seconds << std::endl;
}

void Clock::tic() {
    
    _seconds++;
    if (_seconds == 60) {
        _seconds = 0;
        _minutes++;
        if (_minutes == 60) {
            _minutes = 0;
            _hours = (_hours + 1) % 24;
        }
    }
}
