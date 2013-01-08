#include<iostream>

using namespace std;

int linearsearch(int[],int);

int main()
{
    cout<<"Q U I C K  S O R T"<<endl;
    cout<<"------------------"<<endl<<endl;
    int arr[10] = {34,45,78,1,5,2,76,32,65,28};
    int pivot, pivot_position, start, x, y, i, flag, nosmall=0, temp;
    for(i=0;i<10;i++)
    {
    start = 0;
    for(x=0; nosmall!=1; x++)
    {
             start = y;
            pivot = arr[start];
            flag=0;
            for(y=9; y>start; y--)
            {
                    if(arr[y]<pivot)
                    {
                                    pivot_position = linearsearch(arr,pivot);
                                    temp = arr[y];
                                    arr[y] = pivot;
                                    arr[pivot_position] = temp;
                                    flag = 1;
                    }
                    if(flag==1)
                               break;
            }
            start = y;
            pivot = arr[start];
            flag=0;
            for(y=0; y<start; y++)
            {
                    if(arr[y]<pivot)
                    {
                                    pivot_position = linearsearch(arr,pivot);
                                    temp = arr[y];
                                    arr[y] = pivot;
                                    arr[pivot_position] = temp;
                                    flag = 1;
                    }
                    if(flag==1)
                               break;
            }
            if(flag == 0)
                    nosmall = 1;
            else if(flag == 1)
                nosmall = 0;
    }
    }
    cout<<"The sorted elements are:"<<endl<<endl;
    for(int n=0;n<10;n++)
            cout<<arr[n]<<" ";
    cout<<"\n\n";
    system("PAUSE");
    return(0);
}

int linearsearch(int arr[], int key)
{
    for(int i=0; i<10; i++)
    {
            if(arr[i]==key)
                           return i;
    }
}
