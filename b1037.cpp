#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> vec;
    for(int i=0; i<n; i++){
        int a;
        cin>>a;
        vec.push_back(a);
    }
    sort(vec.begin(), vec.end());
    int a = *vec.begin();
    int b = *(vec.end()-1);
    cout<<a*b;
}