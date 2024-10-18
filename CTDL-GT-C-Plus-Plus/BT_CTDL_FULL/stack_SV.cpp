#include <iostream>
using namespace std;
struct sv{
			int msv;
	char hoten[100],xl;
	float cc,gk,ck,tk;
	};
		char tinh_xep_loai(float tk){
		char xl ;
		if(tk>= 8.5){
			xl='A'; 
		} else if(tk>7){
			xl='B'; 
		} else if(tk>=5.5){
			xl='c';
			 
		} else if(tk>= 4){
			xl ='d'; 
		} else{
			xl='f'; 
		} 
		return xl; 
	}
	void nhap_sv(sv &x){
	cout<< " nhap ma sv";cin>> x.msv ;
	cout << "nhap hoten";fflush(stdin);
	cin.getline(x.hoten ,1000);
	cout << " nhap diem cc";cin>> x.cc;
	cout << " nhap diem gk";cin>> x.gk;
	cout << " nhap diem ck";cin>> x.ck;
	x.tk =0.1*x.cc + 0.3 *x.gk + 0.6 *x.ck ;
	x.xl=tinh_xep_loai(x.tk); 
	} 
	 
	void xuat_sv(sv x){
	cout<< "\t thông tin sinh vien" ; 
	cout<< "\n\t msv" <<x.msv ;
	cout<< "\n\t hoten"  <<x.hoten; 
	cout<< "\n\ttong k?t "  << x.tk; 
	cout<<"\n|t xep loai"<<x.xl; 
	} 
struct Node {
	sv Data;
	Node *Next, *Prev;
};
typedef Node* List;
void pushStack(sv x, List &F, List &L) {
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
	//	cout<<"\nData: " <<;
	xuat_sv(L->Data); 
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
	char c; sv x;
	List F = NULL, L = NULL;
	while(1){
		cout<<"\n1. Push Stack!";
		cout<<"\n2. Pop Stack!";
		cout<<"\n3. Top Stack!";
		cout<<"\nEnter..."; cin>>c;
		if(c == '1'){
			//cout<<"Enter x: "; cin>> x;
			nhap_sv(x) ;
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