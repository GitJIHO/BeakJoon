#include <iostream>
using namespace std;

int main() {
    vector<int> v;
    int M;
    int Q;
    int r1, r2, c1, c2;
    for (int i=1; i<1000; i++){
        v.emplace_back(i);
    }
    int **mat;
    mat = new int*[3];
    for(int j=0; j<v.size(); j++){
        cout<<v[j];
    }
}