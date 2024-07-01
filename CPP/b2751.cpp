#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(){
    int n;
    cin>>n;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<n; i++){
        int a;
        cin>>a;
        pq.push(a);
    }
    while(!pq.empty()){
        printf("%d\n", pq.top());
        pq.pop();
    }
}