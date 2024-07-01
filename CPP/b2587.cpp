#include <iostream>
#include <queue>
using namespace std;

int main(){
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<5; i++){
        int a;
        cin>>a;
        pq.push(a);
    }
    int arr[5];
    for(int i=0; i<5; i++){
        arr[i] = pq.top();
        pq.pop();
    }
    int sum = 0;
    for(int i=0; i<5; i++){
        sum += arr[i];
    }
    cout<<sum/5<<endl;
    cout<<arr[2];
}