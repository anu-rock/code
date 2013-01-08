/*
  Name: caesar-cipher.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 02-09-08 12:23
  Description: This program demostrates the working of Caesar Cipher (a symmetric cipher)
*/


#include<iostream>
#include<string>

using namespace std;

int main()
{
    char data[100], cipher[100];
    int key;
    cout<<"Enter plain text [max 100 characters]: ";
    gets(data);
    cout<<"\n";
    cout<<"Enter key [1-25]: ";
    cin>>key;
    cout<<"\n\nThe encrypted text is:"<<endl;
    for(int i=0;data[i]!='\0';i++)
            data[i] = toupper(data[i]); //we convert the input text in upper case, as that's what we are dealing with
    for(int x=0;data[x]!='\0';x++)
    {
            if(data[x]==' ')
                          cipher[x] = data[x];
            else
                          cipher[x] = ((int(data[x]+key)%65)%26) + 65; //integer equivalent of 1st alphabet 'A' is 65
                          cipher[x+1] = '\0'; //we keep on updating the end the last element to NULL 
                                              //as this loop will not put \0 in cipher array itself
    }
    for(int y=0;cipher[y]!='\0';y++)
                        cout<<cipher[y];
    cout<<"\n\n";
    system("PAUSE");
    return(0);
}
