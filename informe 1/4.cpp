#include <iostream>
using namespace std;
float menor(float a, float b, float c){
    if(a <= b && a <=c)
        return a;
    else if (b <= a && b<=c)
        return b;
    else
        return c;
}
int main(){
    float x, y, z;
    cout << "Ingrese tres números decimales: ";
    cin >> x >> y >> z;
    cout << "El menor de los tres es: " << menor(x, y, z) << endl;
    return 0; 
}