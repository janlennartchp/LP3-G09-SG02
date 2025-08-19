#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main() {
    srand(time(0));
    int frecuencia[6] = {0};

    for (int i = 0; i < 20000; i++) {
        int cara = rand() % 6; // 0 a 5
        frecuencia[cara]++;
    }

    cout << "Frecuencia de cada cara:\n";
    for (int i = 0; i < 6; i++) {
        cout << "Cara " << (i+1) << ": " << frecuencia[i] << endl;
    }
    return 0;
}