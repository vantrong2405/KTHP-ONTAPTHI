// Cho m?ng A g?m N ph?n t? và 1 s? nguyên K. H?y t?m xem s? K ðó có trong m?ng A hay không?
#include <iostream>


using namespace std;

bool tim_so_trong_mang(int A[], int N, int K) {
    for (int i = 0; i < N; i++) {
        if (A[i] == K) {
            return true;
        }
    }
    
    return false;
}

int main() {
    int N;
    cout << "Nhap so luong phan tu trong mang: ";
    cin >> N;

    int A[N];
    cout << "Nhap mang A gom " << N << " phan tu:\n";
    for (int i = 0; i < N; i++) {
        cout << "Nhap phan tu thu " << i + 1 << ": ";
        cin >> A[i];
    }

    int K;
    cout << "Nhap so nguyen K: ";
    cin >> K;

    bool tim_thay = tim_so_trong_mang(A, N, K);
    if (tim_thay) {
        cout << "So " << K << " co trong mang." << endl;
    } else {
        cout << "So " << K << " khong co trong mang." << endl;
    }

    return 0;
}