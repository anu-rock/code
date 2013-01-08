#include<iostream>

using namespace std;

int main()
{
	char in[100], out[100];
	int char_int_value;
	cout<<"Enter input: ";
	gets(in);
	for(int i=0; in[i]!='\0'; i++)
	{
		char_int_value = int(in[i]);
		if(97<=char_int_value<=122)
			out[i] = in[i];
	}
	cout<<"Extracted text is:"<<endl<<endl;
	for(int j=0; out[j]!='\0'; j++)
		cout<<out[j];
	cout<<"\n\n";
	return(0);
}