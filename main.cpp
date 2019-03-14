#include<iostream>
using namespace std;
int main()
{
	int a[102];
	int n=0;
	int x=0;
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
	}
	cin>>x;
	int temp=a[n];
	for(int i=n+1;i>=x+1;i--)
	{
		a[i]=a[i-1];
	}
	a[x]=temp;
	for(int i=1;i<=n-1;i++)
	{
		cout<<a[i]<<" ";
	}
	cout<<a[n]<<endl;
	return 0;
}