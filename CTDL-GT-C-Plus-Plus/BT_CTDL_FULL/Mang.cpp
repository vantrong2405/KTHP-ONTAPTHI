//Bài 3: Cho m?ng A g?m N ph?n t?. H?y ð?m xem trong m?ng A có bao nhiêu s? nguyên t?
#include <iostream>
#include <cmath>
using namespace std;

bool kiem_tra_so_nguyen_to(int num) {
    if (num <= 1) {
        return false;
    }

    int square_root = sqrt(num);
    for (int i = 2; i <= square_root; i++) {
        if (num % i == 0) {
            return false;
        }
    }

    return true;
}

int dem_so_nguyen_to(int A[], int N) {
    int count = 0; // S? lu?ng s? nguyên t?

    for (int i = 0; i < N; i++) {
        if (kiem_tra_so_nguyen_to(A[i])) {
            count++;
        }
    }

    return count;
}

int main() {
    int N;
    cout << "Nhap so luong phan tu cua mang: ";
    cin >> N;

    int A[N];
    cout << "Nhap cac phan tu cua mang A:" << endl;
    
    for (int i = 0; i < N; i++) {
        cout << "Nhap phan tu thu " << i + 1 << ": ";
        cin >> A[i];
    }

    int so_nguyen_to = dem_so_nguyen_to(A, N);
    cout << "So luong so nguyen to trong mang A la: " << so_nguyen_to << endl;

    return 0;
}