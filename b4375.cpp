#include <iostream>
using namespace std;

int main(){
    int n;
    int k=0;
    while(cin>>n){
        int num = 1;
        k=1;
        while(true){
            if(num%n==0){
                break;
            }
            else{
                k++;
                num = num*10+1;
                num %= n;
            }
        }
        cout<<k<<"\n";
    }
}