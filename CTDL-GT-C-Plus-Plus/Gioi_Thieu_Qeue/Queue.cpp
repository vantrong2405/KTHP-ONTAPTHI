void xoa_k(int A[], int &n) {
    if (n <= 0) {
        return;
    }
    for (int i = 0; i < n - 1; i++) {
        A[i] = A[i + 1];
    }
    n--;
}
