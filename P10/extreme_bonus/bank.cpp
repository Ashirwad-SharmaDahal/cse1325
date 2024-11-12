#include <iostream>
#include <string>
#include <map>
#include "Purse.h"

int main() {
    std::map<std::string, Purse> vault;

    int numAccounts;
    std::cout << "How many accounts to create? ";
    std::cin >> numAccounts;
    std::cin.ignore(); 

    for (int i = 0; i < numAccounts; ++i) {
        std::string name;
        Purse deposit;

        std::cout << "Enter account name: ";
        std::getline(std::cin, name);

        std::cout << "Enter initial deposit (format: £ pounds shillings s pence d): ";
        std::cin >> deposit;
        std::cin.ignore();

        vault[name] = deposit;
    }

    Purse total;
    for (const auto& account : vault) {
        std::cout << account.first << ": " << account.second << std::endl;
        total += account.second;
    }

    std::cout << "Total in bank: " << total << std::endl;
    return 0;
}
