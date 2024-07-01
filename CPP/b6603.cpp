#include <iostream>
#define MAX 13
using namespace std;

int lotto[MAX];
int combi[MAX];
int k;

void dfs(int start, int depth){
    if(depth == 6){
        for(int i=0; i<6; i++){
           cout << combi[i] << " ";
        }
        cout<<endl;
        return;
    }

    for(int i=start; i<k; i++){
        combi[depth] = lotto[i];
        dfs(i+1, depth+1);
    }
    
}

int main() {
    
    while(1){
        cin>>k;
        if(k==0) break;
        for(int i=0; i<k; i++){
            cin>>lotto[i];
        }
        dfs(0,0);
        cout<<endl;
    }
}