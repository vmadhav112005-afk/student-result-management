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



    int pos,count=0;
    p=head;
    while(p!=NULL){
        count++;
        p=p->addr;
    }
    printf("\nTotal nodes = %d\n", count);
     printf("Enter position to insert new node (1 to %d): ", count+1);
    scanf("%d", &pos);
    if(pos<1||pos>count+1){
        printf("Invalid position!\n");
        return 1;
    }
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("Enter data for new node: ");
    scanf("%d", &newnode->data);
    if(pos==1){
        newnode->addr=head;
        head=newnode;
    }else{
        p=head;
        for(i=1;i<pos-1;i++){
            p=p->addr;
        }
        newnode->addr=p->addr;
        p->addr=newnode;
    }



    printf("\n Linked list elements : \n");
    p=head;
    while(p!=NULL){
        printf("Data : %d | Address : %p | Next : %p \n ",p->data,p,p->addr);
        p=p->addr;
    }
    return 0;
}