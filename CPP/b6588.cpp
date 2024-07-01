#include <iostream>
#include <vector> 
#define MAX 1000001
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    vector<bool> vec(MAX+1, true);
    for(int i=2; i*i<=MAX; i++){
        if(vec[i]){
            for(int j=i*i; j<=MAX; j+=i){
                vec[j]=false;
            }
        }
    }
    
    int a=-1;
    cin>>a;
    while(a!=0){
        bool check = false;
        for(int i=3; i<a; i+=2){
            if(vec[i]&&vec[i]%2==1){
                if(vec[a-i]&&vec[a-i]%2==1){
                    cout<<a<<" = "<<i<<" + "<<a-i<<"\n";
                    check = true;
                    break;
                }
            } 
        }
        if(!check) cout<<"Goldbach's conjecture is wrong.\n";
        cin>>a;
    }
}