/*
  Name: linked-list.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 04/10/08 18:01
  Description: Implementation of linked list using classes
*/


#include<iostream>

using namespace std;

class Node
{
      public:
             int data; //actual data stored by the node
             Node* pointer; //pointer to the next node
             Node() //initialize the node's attributes
             {
                   data = 0;
                   pointer = NULL; //a new node created will have its pointer set to NULL
             }
};

class LinkedList
{
      private:
              Node* firstNode;
      public:
             LinkedList()
             {
                         firstNode = NULL; //initially, the first node is pointing to nowhere
             }
             void insert(int);
			 void displayList();
};
    

void LinkedList::insert(int d)
{
	Node* newNode = new Node;
    newNode->data = d;
    //newNode->pointer = NULL;
    if(firstNode==NULL) //the first node isn't defined yet?
    {
		firstNode = newNode; //then our new node is the first node
    }
    else
    {
        Node* currentNode = firstNode; //we start from the first node
        while(true)
        {
           		if(currentNode->pointer==NULL) //is this the last node?
                {
           			currentNode->pointer = newNode; //the new node is appended in the list
           			return;
           		}
           		currentNode = currentNode->pointer;
       	}
    }
                                                                                      
}

void LinkedList::displayList()
{
	Node* presentNode = firstNode;
	while(presentNode->pointer!=NULL)
	{
		cout<<presentNode->data;
		cout<<" ";
		presentNode = presentNode->pointer;
	}
}

int main()
{
	int x;
	LinkedList list_1;
	while(true) //an indefinite loop
	{	
		cout<<"Enter a value to insert in the linked list: ";
		cin>>x;
		list_1.insert(x);
		if(x==0)
			break;
	}
	cout<<"\n\nThe linked list thus formed is:"<<endl;
	list_1.displayList();
	cout<<"\n\n";
	system("PAUSE");
	return(0);
}
