#include <iostream>
using namespace std;

void swap(int& a, int& b){
    int temp = a;
    a = b;
    b = temp;
}

void makeheap(int* arr, int size){
    for(int i=size/2; i>=1; i--){
        int p = i;
        for(int j=2*p; j<=size; j*=2){
            if(j<size && arr[j]>arr[j+1]) j=j+1;
            if(arr[p]>arr[j]){
                swap(arr[p],arr[j]);
                p=j;
            }
        }
    }
}


void insertheap(int* arr, int n, int& size){
    size++;
    arr[size]=n;
    makeheap(arr, size);
}

void heapsort(int* arr, int& size){
    swap(arr[1],arr[size]);
    size--;
    makeheap(arr, size);
}

int main(){
    int n;
    int *ar;
    int *arr;
    cin>>n;
    ar = new int[n];
    arr = new int[n+1];
    int size=0;
    for(int i=0; i<n; i++){
        cin>>ar[i];
    }
    for(int j=0; j<n; j++){
        if(ar[j]==0) cout<<"0"<<endl;
        else{
            insertheap(arr, ar[j], size);
        }
    }
    for(int i=1; i<=size; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
    heapsort(arr, size);
    for(int i=1; i<=size; i++){
        cout<<arr[i]<<" ";
    }    
    
}