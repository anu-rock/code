#include<iostream>

using namespace std;

int main()
{
    char name1[20];
    cout<<"1:";
    cin>>name1;
    char name2[20];
    cout<<"2:";
    cin>>name2;
    char name3[20];
    cout<<"3:";
    cin>>name3;
    char name4[20];
    cout<<"4:";
    cin>>name4;
    char name5[20];
    cout<<"5:";
    cin>>name5;
    char name6[20];
    cout<<"6:";
    cin>>name6;
    char name7[20];
    cout<<"7:";
    cin>>name7;
    cout<<"\n\n";
    int x = 0;
    while(x!=-1)
    {
              for(int i=0; i<20; i++)
                      cout<<name1[i]<<"  "<<name2[i]<<"  "<<name3[i]<<"  "<<name4[i]
                      <<"  "<<name5[i]<<"  "<<name6[i]<<"  "<<name7[i]<<endl;
              x++;
    }
    cout<<"\n";
    system("PAUSE");
    return(0);
}
