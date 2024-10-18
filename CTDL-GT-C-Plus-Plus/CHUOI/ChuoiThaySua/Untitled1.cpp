#include <iostream>
const int MAX_SIZE = 100;
using namespace std;
struct Stack {
    int arr[MAX_SIZE];
    int top;

    Stack() : top(-1) {}

    bool is_empty() {
        return top == -1;
    }

    bool is_full() {
        return top == MAX_SIZE - 1;
    }

    void push(int item) {
        if (is_full()) {
            cout << "Ngan xep da day. Khong the day them phan tu." << endl;
            return;
        }
        top++;
        arr[top] = item;
    }

    int pop() {
        if (is_empty()) {
            cout << "Ngan xep da rong. Khong the lay ra phan tu." << endl;
            return -1;
        }
        int item = arr[top];
        top--;
        return item;
    }

    int peek() {
        if (is_empty()) {
            cout << "Ngan xep da rong. Khong the xem phan tu o dau ngan xep." << endl;
            return -1;
        }
        return arr[top];
    }

    int size() {
        return top + 1;
    }
};

int main() {
    Stack stack;
    stack.push(10);
    stack.push(20);
    stack.push(30);
    cout << "Phan tu o dau ngan xep: " << stack.peek() << endl;
    cout << "Kich thuoc ngan xep: " << stack.size() << endl;
    stack.pop();
    cout << "Da lay ra mot phan tu" << endl;
    cout << "Phan tu o dau ngan xep sau khi lay ra: " << stack.peek() << endl;
    cout << "Kich thuoc ngan xep sau khi lay ra: " << stack.size() << endl;
    return 0;
}
