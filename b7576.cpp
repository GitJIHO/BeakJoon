#include <iostream>
#include <queue>
using namespace std;

int arr[999][999];
int M, N;
int res = 0;
queue<pair<int, int>> q;
int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,-1,1};

void cal(int x, int y){
    q.push(make_pair(x,y));

    while(!q.empty()){
        x = q.front().first;
        y = q.front().second;
        q.pop();
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny<0 || nx>N || ny>M){
                continue;
            }
            if(arr[nx][ny]==-1){
                continue;
            }
            if(arr[nx][ny]==0){
                arr[nx][ny]=1;
                q.push(make_pair(nx,ny));
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==0){
                    break;
                }
                res++;
            }
        }
    }    
}

int main(){
    cin>>M>>N;
    for(int i=0; i<M; i++){
        for(int j=0; j<N; j++){
            cin>>arr[i][j];
        }
    }

    for(int i=0; i<M; i++){
        for(int j=0; j<N; j++){
            if(arr[i][j]==1){
                cal(i,j);
            }
        }
    }
    cout<<res;
}