#include <iostream>
using namespace std;
struct Node {
	int Data;
	Node *Next, *Prev;
};
typedef Node* List;
void pushStack(int x, List &F, List &L) {
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
void topStack(List L){
	if(L == NULL){
		cout<<"\nEmpty Stack!";
	}else{
		cout<<"\nData: " <<L->Data;
	}
}
int emptyStack(List F){
	if(F == NULL){
		return true;
	}else{
		return false;
	}
}
void delLast(List &F, List &L) {
	List p = L;
	if(F == L) {
		F = L = NULL;
	} else {
		L 		= L->Prev;
		L->Next = NULL;
	}
	delete(p);
}
void popStack(List &F, List &L){
	if(emptyStack(L)){
		cout<<"\nEmpty Stack!";
	}else{
		topStack(L);
		delLast(F, L);
	}
}
main(){
	char c; int x;
	List F = NULL, L = NULL;
	while(1){
		cout<<"\n1. Push Stack!";
		cout<<"\n2. Pop Stack!";
		cout<<"\n3. Top Stack!";
		cout<<"\nEnter..."; cin>>c;
		if(c == '1'){
			cout<<"Enter x: "; cin>> x;
			pushStack(x, F, L);
		}else if(c == '2'){
			popStack(F, L);
		}else if(c == '3'){
			topStack(L);
		}else{
			break;
		}
	}
}