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
        int pounds, shillings, pence;

        std::cout << "Enter account name: ";
        std::getline(std::cin, name);

        std::cout << "Enter initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore();

        vault[name] = Purse(pounds, shillings, pence);
    }

    Purse total;
    for (const auto& account : vault) {
        std::cout << account.first << ": " << account.second << std::endl;
        total += account.second;
    }

    std::cout << "Total in bank: " << total << std::endl;
    return 0;
}
