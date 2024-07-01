#include <iostream>
#include <vector>
using namespace std;

int res1(int a, int b){
    vector<int> temp1;
    vector<int> temp2;
    vector<int> temp3;
    int size1, size2;
    int result=1;
    for(int i=1; i<=a; i++){
        if(a%i==0){
            temp1.emplace_back(i);
        }
    }
    for(int j=1; j<=b; j++){
        if(b%j==0){
            temp2.emplace_back(j);
        }
    }
    if(temp1.size()>temp2.size()){
        for(int i=0; i<temp1.size(); i++){
            for(int j=0; j<temp2.size(); j++){
                if(temp1[i]==temp2[j]) temp3.emplace_back(temp1[i]);
            }
        }
    } else{
        for(int i=0; i<temp2.size(); i++){
            for(int j=0; j<temp1.size(); j++){
                if(temp2[i]==temp1[j]) temp3.emplace_back(temp2[i]);
            }
        }
    }
    for(int i=0; i<temp3.size(); i++){
        if(result<temp3[i]) result = temp3[i];
    }
    return result;
}

int res2(int a, int b){
    int ra = a;
    int rb = b;
    int da = 0;
    int db = 0;
    while(ra!=rb){
        if(ra<rb){
            ra = a * ++da;
        } else{
            rb = b * ++db;
        }
    }
    return ra;
}

int res1_2(int res, int left){
    if(left==0){
        return res;
    }else{
        return res1_2(left,res%left);
    }
    //유클리드 호제법: 임의의 자연수 a, b가 있을 때, a를 b로 나눈 나머지와 b의 최대공약수는 a와 b의 최대공약수와 같다.
}

int res1_3(int a, int b){
    int c;
    while(c!=0){
        c = a%b;
        a = b;
        b = c;
    }
    return a;
}

int res2_2(int a, int b){
    // (a/res1_3(a,b))*(b/res1_3(a,b))*res1_3(a,b);
    return (a*b)/res1_3(a,b);
}

int main(){
    int a, b;
    cin>>a>>b;

    cout<<res1_3(a,b)<<"\n"<<res2(a,b);
}