#include <stdio.h>

int N, M;
int arr[9]={0};
int vec[9]={0};

void DFS(int num, int cnt){
    if(cnt==M){
        for(int i=0; i<M; i++){
            printf("%d ",arr[i]);
        }
        printf("\n");
        return;
    }else{
        for(int i=num; i<=N; i++){
            if(!vec[i]){
                vec[i] = true;
                arr[cnt]=i;
                DFS(i+1, cnt+1);
                vec[i] = false;
            }
        }
    }
}

int main(){
    scanf("%d %d",&N, &M);
    DFS(1, 0);
}