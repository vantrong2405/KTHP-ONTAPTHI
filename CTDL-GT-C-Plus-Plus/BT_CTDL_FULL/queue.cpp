#include <iostream>
using namespace std;
struct sv {
	char hoten[100];	
};
struct Node {
	sv Data;
	Node *Next, *Prev;
};
typedef Node* List;
void nhap_sv(sv &x) {
	cout << "Nhap Ho Ten: "; fflush(stdin); cin.getline(x.hoten, 100);
}
void xuat_sv(sv x) {
	cout << "\nMoi ban, " << x.hoten << " len nop tien hoc lai!";
}
int emptyQueue(List F, List L) {
	if(F == NULL || L == NULL) {
		return true;
	}
	return false;
} 
void pushQueue(sv x, List &F, List &L) {
	List p  = new(Node);
	p->Data = x;
	p->Next = p->Prev = NULL;
	if(F == NULL) {
		F = L = p;
	} else {
		L->Next = p;
		p->Prev = L;
		L		= p;
	}
}
void delFirst(List &F, List & L) {
	List p = F;
	if(F == L) {
		F = L = NULL;
	} else {
		F 		= F->Next;
		F->Prev = NULL;
	}
	delete(p);
}
void topQueue(List F, List L) {
	if(emptyQueue(F, L)) {
		cout << "\nQueue Rong!!!";
	} else {
		xuat_sv(F->Data);
	}
}
void popQueue(List &F, List &L) {
	if(emptyQueue(F, L)) {
		cout << "\nQueue Rong!!!";
	} else {
		xuat_sv(F->Data);
		delFirst(F, L);
	}
}
main() {
	char c; List F = NULL, L = NULL;
	while(1) {
		cout << "\n1. Push Queue";
		cout << "\n2. Top  Queue";
		cout << "\n3. Pop  Queue";
		cout << "\nEnter... "; cin >> c;
		if(c == '1') {
			sv x;
			nhap_sv(x);
			pushQueue(x, F, L);
		} else if(c == '2') {
			topQueue(F, L);
		} else if(c == '3') {
			popQueue(F, L);
		} else {
			break;
		}
	}
}