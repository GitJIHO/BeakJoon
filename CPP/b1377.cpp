#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<pair<int,int>> arr;
    arr.push_back(make_pair(0,0));
    int cnt=1;
    for(int i=1; i<=n; i++){
        int a;
        cin>>a;
        arr.push_back(make_pair(a,i));
    }
    sort(arr.begin()+1, arr.end());
    int num = -1;
    for(int i=1; i<=n; i++){
        if(num<arr[i].second-i){
            num = arr[i].second-i;
        }
    }
    cout<<num+1;
}