#include <iostream>
using namespace std;
#define MAX 1001

int arr[MAX][MAX];
bool visited[MAX];
int n, m;
int num = 0;

void DFS(int u){
    visited[u] = true;

    for(int v=1; v<=n; v++){
        if(visited[v]==false && arr[u][v]==1){
            DFS(v);
        }
    }
    
}

int main(){
    cin>>n>>m;
    int a,b;
    for(int i=1; i<=m; i++){
        cin>>a>>b;
        arr[a][b]=1;
        arr[b][a]=1;
    }

    for(int j=1; j<=n; j++){
        visited[j]=false;
    }
    
    for(int k=1; k<=n; k++){
        if(visited[k] == false){
            num++;
            DFS(k);
        }
    }
    cout<<num;
}
