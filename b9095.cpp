#include <iostream>
#include <vector>
using namespace std;

void DFS(int num, int n, int& cnt){
    if(num>n) return;
    if(num==n){
        cnt++;
        return;
    }
    DFS(num+1, n, cnt);
    DFS(num+2, n, cnt);
    DFS(num+3, n, cnt);
    
}

int main() {
    int n;
    vector<int> vec;
    cin>>n;
    for(int i=0; i<n; i++){
        int a;
        cin>>a;
        vec.push_back(a);
    }
    for(int i=0; i<vec.size(); i++){
        int cnt=0;
        DFS(0,vec[i],cnt);
        cout<<cnt<<"\n";
    }
}