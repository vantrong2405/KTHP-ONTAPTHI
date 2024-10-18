#include <iostream>
#include <cmath>
using namespace std;

int inverseNumber(int n) {
    if (n == 0) {
        return 0;
    }
    
    return (n % 10) * pow(10, floor(log10(n))) + inverseNumber(n / 10);
}

int main() {
    int n;
    cout << "Nhap so nguyen n: ";
    cin >> n;

    int inverse = inverseNumber(n);
    cout << "Nghich dao cua so " << n << " la: " << inverse << endl;

    return 0;
}




//ham void




#include <iostream>
using namespace std;

void inverseNumberVoid(int n) {
    if (n == 0) {
        return;
    }
    
    cout << n % 10;
    inverseNumberVoid(n / 10);
}

int main() {
    int n;
    cout << "Nhap so nguyen n: ";
    cin >> n;

    cout << "Nghich dao cua so " << n << " la: ";
    inverseNumberVoid(n);
    cout << endl;

    return 0;
}