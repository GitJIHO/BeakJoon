#include <iostream>
#include <vector>
using namespace std;

void selectionsort(vector<int> &arr, int size){
    for(int i=0; i<size-1; i++){
        int max = i;
        for(int j=i+1; j<size; j++){
            if(arr[max]<arr[j]) max = j;
        }
        int temp = arr[max];
        arr[max] = arr[i];
        arr[i] = temp;
    }
}

int main() {
    int n, k;
    vector<int> vec;
    cin>>n>>k;
    for(int i=0; i<n; i++){
        int temp;
        cin>>temp;
        vec.emplace_back(temp);
    }
    selectionsort(vec, vec.size());

    cout<<vec[k-1];
}