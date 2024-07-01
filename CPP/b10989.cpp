#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
	cin.tie(NULL);
    int arr[10001] = {};
    int n;
    cin>>n;
    for(int i=1; i<=n; i++){
        int a;
        cin>>a;
        arr[a]+=1;
    }
    for(int i=1; i<10001; i++){
        for(int j=1; j<=arr[i]; j++){
            cout<<i<<"\n";
        }
    }
}