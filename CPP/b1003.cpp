#include <iostream>
#include <vector>
using namespace std;

int fibo(int n){
    int a=0;
    int b=0;
    int c=1;
    if(n==-1) return 0;
    for(int i=0; i<n; i++){
        a=b;
        b=c;
        c=a+b;
    }
    return c;
}

// int fiboDP(int n, int* temp){
//     if(n<=1) return n;
//     temp[n]=fiboDP(n-1, temp)+fiboDP(n-2, temp);
//     return temp[n];
// }

int main() {
    int T;
    cin>>T;
    vector<int> arr;
    int *temp = new int[T];
    for(int i=0; i<T; i++){
        int a;
        cin>>a;
        arr.push_back(a);
    }
    for(int i=0; i<T; i++){
        if(arr[i]==0){
            cout<<"1 0\n";
        } else {
            cout<<fibo(arr[i]-2)<<" "<<fibo(arr[i]-1)<<"\n";
        }
    }
    // for(int i=0; i<T; i++){
    //     if(arr[i]==0){
    //         cout<<"1 0\n";
    //     } else {
    //         cout<<fiboDP((arr[i]-1),temp)<<" "<<fiboDP((arr[i]),temp)<<"\n";
    //     }
    // }
    
}