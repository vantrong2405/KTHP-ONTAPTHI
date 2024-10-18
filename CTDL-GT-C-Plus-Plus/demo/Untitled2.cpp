#include<iostream>
using namespace std ;
struct Node {
	Node *next ; 
	int data;
}; 

//dinh nghia 
typedef Node* List;

void insertFirst(List &F , int x){
	List p = new(Node);
	p->data = x ; //tao p 
	p->next = NULL;
	p->next = F ; //tao cau noi qua F 
	F = p ;  
}

void insertLast(List &F , int x ){
	List p = new(Node);
	p->data = x ; 
   if(F == NULL){
   	F = p;
   }else{
   	List q = F ; 
   	while(q){
   		q = q ->next;
	}
	q->next = p ; 
   }
}

void deletFirst(List &F){
	List p = F ; 
	F = F->next;
	delete(p);
}

void deletLast(List &F){
	List p ;
	if(F == NULL){
		p = F ; 
		delete(p); 
	}else{
		List q = F ; 
		while(q->next != NULL){
			q = q->next;
		}
		delete(q); 
	}
}

void printList(List F){
	List p = F ; 
	cout<<"List : ";
	while(p != NULL){
		cout<<p->data<<"\t";
		p = p->next;
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
				cin>>a;
		
					insertLast(F , a);
				
				break;
			}
//			
//			case 2:{
//				deletFirst(F);
//				break;
//			}
//			
//			case 3:{
//				deletLast(F);
//				break;
//			}
//			
//			case 4 :{	
//				return 0 ;
//			}
			
		}
		
	}
	return 0 ;
}
