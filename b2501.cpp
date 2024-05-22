#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
    int n,k;
    cin>>n>>k;
    vector<int> arr;

    int N = sqrt(n);

    for(int i=1; i<=N; i++){
        if(n%i==0){
            arr.push_back(i);
            if(n/i!=i){
                arr.push_back(n/i);
            }
        }
    }
    sort(arr.begin(), arr.end());
    cout<<arr[k-1];
}