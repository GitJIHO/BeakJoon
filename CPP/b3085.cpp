#include <iostream>
#define MAX 50
using namespace std;

char arr[MAX][MAX];

void swap1(char& a, char& b){
    char temp = a;
    a = b;
    b = temp;
}

int main() {
    int num;
    int max = 0;
    cin>>num;

    for(int i=0; i<num; i++){
        for(int j=0; j<num; j++){
            cin>>arr[i][j];
        }
    }

    for(int i=0; i<num; i++){
        for(int j=0; j<num; j++){
            for(int p=0; p<num*num; p++){
                int t = 1;
                while(p>num){
                    p -= t*num;
                }
                swap1(arr[i][j], arr[p%num][p]);
            }
        }
    }
    // 0 1 2  3 4 5  6 7 8
    for(int i=0; i<num; i++){
        for(int j=0; j<num; j++){
            cout<<arr[i][j];
        }
        cout<<endl;
    }
}