#include <iostream>
using namespace std;

const int MAX = 1e6;
int cnt[MAX];

int main(){
  int n, m;


    cout << "nhap so dong: ";
    cin >> n;
    cout << "nhap so cot: ";
    cin >> m;


    int a[n][m];


    cout << "nhap cac phan tu cua mang a:" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << "a[" << i << "][" << j << "]: ";
            cin >> a[i][j];
        }
    }


	for(int i = 0;i < MAX; i++){
		if(cnt[i] > 0){
			cout << "Gia tri " << i << " xuat hien " << cnt[i] << " lan!\n";
		}
	}
}