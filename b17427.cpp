#include <iostream>
using namespace std;

// int resd(int n){
//     int sum=0;
//     for(int i=n; i>0; i--){
//         if(n%i==0){
//             sum+=i;
//         }
//     }
//     return sum;
// }

// int main(){
//     int n;
//     int res=0;
//     cin>>n;
//     for(iㅅout<<resd(i)<<endl;
//         res += resd(i);
//     }
//     cout<<res;
// }
//시간초과

int main(){
    int n;
    cin>>n;
    int res = 0;
    for(int i=1; i<=n; i++){
        res += (n/i)*i;
    }
    cout<<res;
}