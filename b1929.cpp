#include <iostream>
#include <cmath>
using namespace std;
#define MAX 1000001

bool arr[MAX] = {0};

int main(){
    int M,N;
    cin>>M>>N;
    
    for(int i=2; i<=sqrt(N); i++){
        if(!arr[i]){
            for(int j=i*i; j<=N; j+=i){
                arr[j]=true;
            }
        }
    }
    for(int j=M; j<=N; j++){
        if(!arr[j]&&j>1){
            cout<<j<<"\n";
        }
    }
    return 0;
}