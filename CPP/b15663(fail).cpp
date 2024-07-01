#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b){
    return *(int *)a - *(int *)b;
}

int main(){
    int n,m,size,index;
    int a=-1;
    int *arr;
    int *arr2;
    int **mat;
    scanf("%d %d",&n, &m);
    arr=(int*)malloc(n*sizeof(int));
    for(int i=0; i<n; i++){
        scanf("%d",&arr[i]);
    }
    qsort(arr, n, sizeof(int), compare);  
    size=n;
    index=0;
    
    for(int j=0; j<n; j++){
        if(arr[j]==a){
            size--;
        } else {
            arr2[index++]=arr[j];
            a=arr[j];
        }
    }
}