#include <iostream>
using namespace std;
void nhap_mang(int A[], int &n)
{
    cout << "Nhap vao n: ";
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> A[i];
    }
}
int day_tang(int A[], int n){
    int ht = 1, kq = 0;
    for (int i = 0; i < n; i++){
        if (A[i] > A[i + 1])
        {
            ht = 1;
        }
        else
        {
            ht++;
        }
        kq = max(kq, ht);
    }
    return kq; 
}


void inDay(int a[], int n)
{
    int kq = day_tang(a, n);
    int vt = 0, k = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] < a[i + 1])
        {
            k++;
        }
        if (k == kq)
        {
            vt = i;

            break;
        }
    }
    k = 0;
    for (int i = vt - 1; i <= n; i++)
    {
        cout << a[i] << " ";
        k++;
        if (k == kq)
        {
            break;
        }
    }
}
main()
{
    int A[100000], n;
    nhap_mang(A, n);
    inDay(A, n);
}
