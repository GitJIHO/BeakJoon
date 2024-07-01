#include <iostream>
#include <queue>
using namespace std;

int N;
int M;
int V;
int arr[1001][1001];
bool visited[1001];

void reset(){
    for(int i=1; i<=N; i++){
        visited[i] = false;
    }
}

void DFS(int v){
    visited[v] = true;
    cout<<v<<" ";

    for(int i=1; i<=N; i++){
        if(arr[v][i]==1 && visited[i]==0){
            DFS(i);
        }
    }
}

void BFS(int v){
    queue<int> q;
    q.push(v);
    visited[v]=true;
    cout<<v<<" ";

    while(!q.empty()){
        v = q.front();
        q.pop();

        for(int i=1; i<=N; i++){
            if(arr[v][i]==1 && visited[i]==false){
                q.push(i);
                visited[i]=true;
                cout<<i<<" ";
            }
        }
    }
}

int main() {
    cin>>N>>M>>V;
    for(int i=0; i<M; i++){
        int a;
        int b;
        cin>>a>>b;
        arr[a][b]=1;
        arr[b][a]=1;
    }

    reset();
    DFS(V);
    cout<<endl;
    reset();
    BFS(V);
    
}