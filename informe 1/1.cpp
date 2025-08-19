#include <iostream>
using namespace std;

int sumarElementos(int arreglo[], int n) {
    int suma = 0;
    for (int i = 0; i < n; i++) {
        suma += arreglo[i];
    }
    return suma;
}

int main() {
    int numeros[] = {1, 2, 3, 4, 5};
    int n = sizeof(numeros)/sizeof(numeros[0]);
    cout << "La suma es: " << sumarElementos(numeros, n) << endl;
    return 0;
}