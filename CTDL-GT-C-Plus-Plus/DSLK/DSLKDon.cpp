#include<iostream>
using namespace std ; 
struct Node {
	int Data; 
	Node *Next;
};

typedef Node* List ; //dac ta Node co ten la List ( dac ta)
void insertFirst(int x , List &F ){
	List p  = new(Node);
	p->Data = x ;
	p->Next = NULL;
	//tao cau noi cua p voi F 
	p->Next = F ;//Thang P se tao cau noi voi first dau tien trong líst 
	F = p ; 
}

void insertLast(int x , List &F){
	List p = new(Node);
	p->Data = x ; 
	p->Next = NULL;
   if(F == NULL){
   	F = p ;
   } else{
   	 List q = F ; 
    while(q->Next){
    	q = q->Next;
	}
	q->Next = p ;
   }
}

void deletFirst(List &F){
	List p = F; //cho list p bang phan tu dau tien cua F
	F = F->Next; /// F tiep theo bang F2
	delete(p);//xoa p -> ma p tro toi F nên cung tuc la xoa F
}

void deletLast(List &F){
    List p = F , b ;
	while(p->Next){
		b = p ; //tuc la b sao chep cac phan tu cua b 
		p = b->Next; // p hien tai la : 0 0 0 0 0 0 0 0 
	} 
	b->Next = NULL;
	delete(p);
   
//   	List a = F, b;
//	while(a->Next) {
//		b = a;
//		a = b->Next;
//	}
//	b->Next = NULL;
//	delete(a);
}

void printList(List F){
	List p = F ; 
	cout<<"List : ";
	while(p != NULL){
		cout<<p->Data<<"\t";
		p = p->Next;
	}
	cout<<endl;
}
int main(){
	int a , luaChon;
	List F = NULL;
	while(true){
		cout<<"--------------Moi ban lua chon---------"<<endl;
		cout<<"0. In danh sach"<<endl;
		cout<<"1. Them moi danh sach"<<endl;
		cout<<"2. Xoa first"<<endl;
		cout<<"3. Xoa last"<<endl;
		cout<<"4. Thoat chuong trinh"<<endl;
		printList(F);
		cout<<"Nhap vao lua chon cua ban  : "; cin>>luaChon;
	    switch(luaChon){
	    	case 0 :{
	    		printList(F);
				break;
			}
		
			case 1 :{
				cout<<"Nhap a : ";
				a = 2 ; 
				a++;
				if(a % 2 == 1 ){
					insertLast(a , F);
				}else{
					insertFirst(a , F);
				}
				break;
			}
			
			case 2:{
				deletFirst(F);
				break;
			}
			
			case 3:{
				deletLast(F);
				break;
			}
			
			case 4 :{	
				return 0 ;
			}
			
		}
		
	}
	return 0 ;
}
