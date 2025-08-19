#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    vector<int> numeros;
    string entrada;

    cout << "Ingrese el primer numero (o '.' para terminar): ";
    cin >> entrada;

    if (entrada == ".") {
        cout << "No se ingresaron numeros." << endl;
        return 0;
    }

    int num = stoi(entrada);
    numeros.push_back(num);

    while (true) {
        cout << "Ingrese un numero mayor que " << numeros.back () << ": ";
        cin >> entrada;

        if (entrada == ".") break;

        int siguiente = stoi(entrada);
        if (siguiente > numeros.back()) {
            numeros.push_back(siguiente);
        } else {
            cout << "El numero debe ser mayor. Intente de nuevo." << endl;
        }
    }

    cout << "\nArreglo ingresado: ";
    for (int n : numeros) {
        cout << n << " ";
    }
    cout << endl;

    return 0;
}