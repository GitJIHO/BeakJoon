#include <iostream>
using namespace std;

int main() {
    int N, K;
    int x=0, y=0;
    cin>>N>>K;
    char *way;
    way = new char[K];
    cin>>way;
    int max;
    int **arr = new int*[N];
    for(int i=0; i<N; i++){
        arr[i] = new int[2];
        cin>>arr[i][0]>>arr[i][1];
        if(max<arr[i][0]) max = arr[i][0];
        if(max<arr[i][1]) max = arr[i][1];
    }
    cout<<max;
    for(int j=0; j<K; j++) {
        char v = way[j];
        if(v == 'A'){
            for(int k=0; k<N; k++){
                for(int q=0; q<=max; q++){
                    if((x+q)==arr[k][0] && (y+q)==arr[k][1]){
                        x = x+q;
                        y = y+q;
                        arr[k][0] = arr[k][1] = -1;
                    }
                }
            }
        }
        else if(v == 'B'){
            for(int k=0; k<N; k++){
                for(int q=0; q<=max; q++){
                    if((x+q)==arr[k][0] && (y-q)==arr[k][1]){
                        x = x+q;
                        y = y-q;
                        arr[k][0] = arr[k][1] = -1;
                    }
                }
            }
        }
        else if(v == 'C'){
            for(int k=0; k<N; k++){
                for(int q=0; q<=max; q++){
                    if((x-q)==arr[k][0] && (y+q)==arr[k][1]){
                        x = x-q;
                        y = y+q;
                        arr[k][0] = arr[k][1] = -1;
                    }
                }
            }
        }
        else{
            for(int k=0; k<N; k++){
                for(int q=0; q<=max; q++){
                    if((x-q)==arr[k][0] && (y-q)==arr[k][1]){
                        x = x-q;
                        y = y-q;
                        arr[k][0] = arr[k][1] = -1;
                    }
                }
            }
        }

    }

    cout<<x<<" "<<y;

    delete[] way;
    delete[] arr;
}