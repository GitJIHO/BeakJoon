#include <iostream>
using namespace std;

void selectionsort(int *arr, int size){
    for(int i=0; i<size-1; i++){
        int max = i;
        for(int j=i+1; j<size; j++){
            if(arr[max] < arr[j]) max = j;
        }
        int temp = arr[max];
        arr[max] = arr[i];
        arr[i] = temp;
    }
}

int result(int *arr){
    int res = 0;
    for(int i=0; i<3; i++){
        res += arr[i];
    }
    return res;
}

int main() {
    int a[10];
    int b[10];

    for(int i=0; i<10; i++){
        cin>>a[i];
    }
    for(int j=0; j<10; j++){
        cin>>b[j];
    }

    selectionsort(a, sizeof(a)/sizeof(a[0]));
    selectionsort(b, sizeof(b)/sizeof(b[0]));

    cout<<result(a)<<" "<<result(b);
}