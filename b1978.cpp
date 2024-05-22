#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main(){
    int n;
    int cnt=0;
    cin>>n;
    vector<int> arr;
    for(int i=0; i<n; i++){
        int a;
        cin>>a;
        arr.emplace_back(a);
    }
    for(int i=0; i<n; i++){
        bool check = true;
        int N = sqrt(arr[i]);
        if(arr[i]==1) check=false;
        for(int j=2; j<=N; j++){
            if(arr[i]%j==0) check=false;
        }
        if(check) cnt++;
    }
    cout<<cnt;
}