#include <iostream>
#include <queue>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
	cin.tie(NULL);
    int n;
    cin>>n;
    priority_queue<long long int> pq;
    for(int i=0; i<n; i++){
        long long int a;
        cin>>a;
        pq.push(a);
    }
    int cnt=0;
    int max=0;
    long long int num;
    while(!pq.empty()){
        long long int temp = pq.top();
        pq.pop();
        if(temp==pq.top()){
            cnt++;
            if(max<cnt){
                max = cnt;
                num = pq.top();
            }
        } else{
            cnt=0;
        }
    }
    cout<<num;
}