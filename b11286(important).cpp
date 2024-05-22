#include <iostream>
#include <queue>
#include <vector>
using namespace std;
//https://huilife.tistory.com/entry/C-Priority-Queue%EC%9D%98-custom-sort
class compare{
public:
    bool operator()(int a, int b){
       if(abs(a)==abs(b)){
            return a>b;
        } else {
            return abs(a)>abs(b);
        }
    }
};

int main() {
    priority_queue<int, vector<int>, compare> pq;
    int n;
    cin>>n;
    for(int i=0; i<n; i++){
        int num;
        cin>>num;
        if(num==0){
            if(pq.empty()) cout<<"0"<<"\n";
            else{
                cout<<pq.top()<<"\n";
                pq.pop();
            }
        }
        else{
            pq.push(num);
        }
    }
}
