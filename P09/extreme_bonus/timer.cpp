#include "timer.h"
#include "timer_expired.h"



void Timer::tic() {
    if (--_seconds < 0) {
        _seconds = 59;
        if (--_minutes < 0) {
            _minutes = 59;
            if (--_hours < 0) {
            
                throw Timer_expired();
            }
        }
    }
}
