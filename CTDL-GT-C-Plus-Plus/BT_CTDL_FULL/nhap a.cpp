//Cho mang A gom N phan tu. Hay viet hàm: Nhap vào Mang A gom N phan tu và xuat mang ðó lên màn hinh



#include <iostream>
using namespace std;

float tinh_trung_binh_so_chan(int A[], int N) {
    int tong = 0;
    int dem = 0;
    
    for (int i = 0; i < N; i++) {
        if (A[i] % 2 == 0) {
            tong += A[i];
            dem++;
        }
    }
    
    if (dem == 0) {
        cout << "Khong co so chan trong mang." << endl;
        return 0;
    }
    
    float trung_binh = static_cast<float>(tong) / dem;
    return trung_binh;
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

    float trung_binh_so_chan = tinh_trung_binh_so_chan(A, N);
    cout << "Trung binh cac so chan trong mang: " << trung_binh_so_chan << endl;

    return 0;
}