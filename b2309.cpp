#include <iostream>
#include <algorithm>
using namespace std;

int main() {

    int arr[10];    
    int sum = 0;

    for(int i=0; i<9; i++){
        cin>>arr[i];
        sum+=arr[i];
    }

    sort(arr,arr+sizeof(arr)/sizeof(int)-1);

    for(int i=0; i<9; i++){
        int a = arr[i];
        for(int j=1; j<9; j++){
            int b = arr[j];
            if(sum-a-b == 100){
                for(int p=0; p<9; p++){
                    if(arr[p]!=a && arr[p]!=b){
                        cout<<arr[p]<<"\n";
                    }
                }
                return 0;
            }
        }
    }
    return 0;
}