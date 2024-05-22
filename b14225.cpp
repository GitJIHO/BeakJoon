#include <iostream>
using namespace std;

int N;
int *arr;
int *check;

void bt(int i, int sum){
    check[sum]=1;
    if(i == N){
        return;
    }
    bt(i+1, sum);
    bt(i+1, sum+arr[i]);
}


int main() {
    
    cin>>N;
    int s;
    arr = new int[N];
    for(int i=0; i<N; i++){
        cin>>arr[i];
        s+=arr[i];
    }
    check = new int[s];
    bt(0,0);
    for(int i=0; i<s; i++){
        if(check[i]!=1){
            cout<<i;
            break;
        }
    }
}