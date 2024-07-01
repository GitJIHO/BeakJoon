#include <iostream>
using namespace std;

int N;
int S;
int *arr;
int cnt = 0;
int sum = 0;

void dfs(int i, int sum){
    if(i==N){
        return;
    }
    if (sum + arr[i] == S) cnt++;
    
    dfs(i+1, sum);
    dfs(i+1, sum + arr[i]);
    //이진트리
}

int main() {
    
    cin>>N>>S;

    arr = new int[N];
    for(int i=0; i<N; i++){
        cin>>arr[i];
    }

    dfs(0,0);

    cout<<cnt;
    
}