#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node* addr;
};
int main(){
    struct node *head=NULL;
    struct node *newnode;
    struct node *p;
    int i;
    for(i=0;i<10;i++){
        newnode=(struct node*)malloc(sizeof(struct node));
        printf("Enter data for node %d : ",i+1);
        scanf("%d",&newnode->data);
        newnode->addr=NULL;
        if(head==NULL){
            head=newnode;
            p=head;
        }else{
            p->addr=newnode;
            p=newnode;
        }
    }

    newnode = (struct node*)malloc(sizeof(struct node));
    printf("\nEnter data for the new first node: ");
    scanf("%d", &newnode->data);
    newnode->addr = head; 
    head = newnode;

    printf("\n Linked list elements : \n");
    p=head;
    while(p!=NULL){
        printf("Data : %d | Address : %p | Next : %p \n ",p->data,(void*)p,(void*)p->addr);
        p=p->addr;
    }
    return 0;
}