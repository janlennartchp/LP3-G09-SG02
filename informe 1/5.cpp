#include <iostream>
using namespace std;
float calcularCargo(int horas) {
    float cargo;
    if (horas <= 1) {
        cargo = 3.0;
    } else {
        cargo = 3.0 + (horas - 1) * 0.5;
    }
    if (cargo > 12.0) {
        cargo = 12.0;
    }
    
    return cargo;
}
int main(){
    int horas;
    cout << "Ingrese el número de horas de estacionamiento: ";
    cin >> horas;
    cout << "El cargo es: S/" << calcularCargo(horas) << endl;
    return 0;
} 