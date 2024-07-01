#include <iostream>
using namespace std;

long long fac(int n){
    if(n<=1) return 1;
    return n*fac(n-1);
}

int main(){
    int N;
    cin>>N;
    if(N<0 || N>20){
        return 0;
    }
    else{
        cout<<fac(N);
    }

}