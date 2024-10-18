#include<iostream>
using namespace std ; 

struct Book{
	char tenSach[100];
	int maSach;
	int soLuong ; 
	double donGia , thanhTien ;
};

struct Node{
	Node *next ; 
	Book data ; 
};

typedef Node * List ;
Book A[100];
List F = NULL;
int n ;

void insertFirst(Book x , List &F){
	List p = new(Node);
	p->data =  x; 
	p->next = NULL ; 
       if(F == NULL){
       	    F = p ; 
	   }else{
	   	p->next = F ; 
	   	F = p ; 
	}
}




void themMoiSach(Book &x){
	cout<<"Nhap ma sach : ";
	cin>>x.maSach;
	cout<<"Nhap ten sach : "; 
	fflush(stdin);
	cin.getline(x.tenSach,100);
	cout<<"Nhap so luong : ";
	cin>>x.soLuong; 
	cout<<"Nhap don gia : ";
	cin>>x.donGia; 
    insertFirst(x , F);
}

void deletFirst(List F){
	List q = F ; 
	F = F->next;
    delete(q);
}
void output(Book x){
	cout<<x.maSach<<endl;
    cout<<x.tenSach<<endl;
    cout<<x.soLuong<<endl;
	cout<<x.donGia<<endl;	
	double TT = x.soLuong * x.donGia;
	x.thanhTien = TT ; 
	cout<<x.thanhTien<<endl;
}
void printfList(List F ){
	List p = F ; // coppy thang dau tien
	cout<<"List : "; 
	while(p){
	    output(p->data);
		p = p->next;
	}
	deletFirst(F);
}

int main(){
  
    cout<<"Nhap so luong sach : ";
    cin>>n ;
    for(int i = 0 ; i<n ; i++){
    		cout<<"Nhap thong tin sach thu "<<(i+1)<<endl;
    	themMoiSach(A[i]);
	}
	cout<<"-------------------------Thong tin sach---------------------------"<<endl;

printfList(F);
	return 0 ; 
}
