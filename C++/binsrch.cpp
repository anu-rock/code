#include<iostream>

using namespace std;

int binarysearch(int arr[],int start,int end,int data)
{
	int mid;
	mid=(start+end)/2;
	if (arr[mid]==data)
		return mid;
	else if (arr[mid]<data)
	{
		start=mid+1;
		if (start>end)
			return -1;
		else
			return binarysearch(arr,start,end,data);
	}
	else if (arr[mid]>data)
	{
		end=mid-1;
		if (start>end)
			return -1;
		else
			return binarysearch(arr,start,end,data);
	}
}


int main()
{
	int data;
	int arr[6]={12,45,78,88,98,123};
	cout<<"Enter the search term: ";
	cin>>data;
	int result = binarysearch(arr,0,5,data);
	cout<<endl;
	cout<<"Search term is at:"<<result<<endl;
	return(0);
	//use the function system("PAUSE") if you want to implement the functionality of getch()
}

