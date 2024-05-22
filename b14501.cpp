#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n=0;
int maxb=0;

void DFS(vector<pair<int, int>> &arr, int index, int benefit){
    if(index==n){
        if(benefit>maxb){
            maxb = benefit;
        }
        return;
    }
    if(index>n)return;
    if(benefit>maxb){
        maxb = benefit;
    }
    DFS(arr, index+arr[index].first, benefit+arr[index].second);
    DFS(arr, index+1, benefit);
}

int main() {
    cin>>n;
    vector<pair<int, int>> arr;
    for(int i=0; i<n; i++){
        int a,b;
        cin>>a>>b;
        arr.push_back(make_pair(a,b));
    }
    DFS(arr,0,0);
    cout<<maxb;
}