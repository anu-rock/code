/*
  Name: vigenere-cihper.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 04/09/08 20:28
  Description: This program implements Vigenere Cipher (a polyalphabetic cipher)
*/


#include<iostream>
#include<string>

using namespace std;

char caesar(char, int);

int main()
{
    char data[100], cipher[100], key[100];
    int k;
    cout<<"Enter plain text [max 100 characters]: ";
    gets(data);
    for(int a=0;data[a]!='\0';a++)
            data[a] = toupper(data[a]); //we convert the input text in upper case, as that's what we are dealing with
    cout<<"\n";
    cout<<"Enter key: ";
    cin>>key;
    for(int b=0;key[b]!='\0';b++)
            key[b] = toupper(key[b]); //we convert the key in upper case, as that's what we are dealing with
    cout<<"\n\nThe encrypted text is:"<<endl;
    int i = 0;
    for(int x=0;data[x]!='\0';x++)
    {
            k = int(key[i]-'A');
            cipher[x] = caesar(data[x],k);
            if(i<(strlen(key)-1))
                        ++i;
            else if(i==(strlen(key)-1))
                 i = 0;
    }
    for(int y=0;cipher[y]!='\0';y++)
                        cout<<cipher[y];
    cout<<"\n\n";
    system("PAUSE");
    return(0);
}

char caesar(char p, int k)
{
            if(p==' ')
                          p = ' ';
            else
                          p = ((int(p+k)%65)%26) + 65; //integer equivalent of 1st alphabet 'A' is 65
            return p;
}
