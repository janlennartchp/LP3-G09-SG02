#include <iostream>
using namespace std;
int main() {
    int horas, minutos, segundos;
    int totalSegundos;
    cout << "Ingrese las horas: ";
    cin >> horas;
    cout << "Ingrese los minutos: ";
    cin >> minutos;
    cout << "Ingrese los segundos: ";
    cin >> segundos;
    totalSegundos = (horas * 3600) + (minutos * 60) + segundos;
    cout << "El equivalente en segundos es: " << totalSegundos << endl;
    return 0;
}