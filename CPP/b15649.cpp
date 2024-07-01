#include <iostream>
#include <vector>
using namespace std;

int n,m;
int arr[9];
bool vec[9];

void DFS(int cnt){
    if(cnt==m){
        for(int i=0; i<m; i++){
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
        return;
    }else{
        for(int i=1; i<=n; i++){
            if(!vec[i]){
                vec[i] = true;
                arr[cnt] = i;
                DFS(cnt+1);
                vec[i] = false;
            }
        }
    }
}

int main() {
    cin>>n>>m;
    DFS(0);
}