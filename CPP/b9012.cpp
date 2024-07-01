#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    int n;
    bool check = true;
    cin>>n;
    vector<string> vec;
    stack<char> sta;

    for(int i=0; i<n; i++){
        string s;
        cin>>s;
        vec.emplace_back(s);
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<vec[i].size(); j++){
            if(vec[i][j]=='('){
                sta.push(vec[i][j]);
            }else{
                if(sta.empty()){
                    check=false;
                    break;
                } else if(sta.top()=='('){
                    sta.pop();
                } else{
                    check=false;
                    break;
                }
            }
        }
        if(sta.empty()&&check){
            cout<<"YES"<<endl;
            while(!sta.empty()) sta.pop();
        }else{
            cout<<"NO"<<endl;
            while(!sta.empty()) sta.pop();
        }
        check=true;
    }
}