#include <stdio.h>

int N, M;
int arr[8]={0};

void DFS(int cnt){
    if(cnt==M){
        for(int i=0; i<M; i++){
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    for(int i=1; i<=N; i++){
        arr[cnt]=i;
        DFS(cnt+1);
    }
    
}

int main() {
    scanf("%d %d",&N, &M);
    DFS(0);
}