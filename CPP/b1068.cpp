#include <iostream>
#include <vector>
using namespace std;

int cnt=0;

struct Node{
    int name;
    Node * left = NULL;
    Node * right = NULL;
};

void order(Node* root){
    if(root==NULL) return;
    if(root->left==NULL && root->right==NULL){
        cnt++;
        return;
    }
    order(root->left);
    order(root->right);
}

int main() {
    int n;
    int del;    
    cin>>n;
    Node * root;
    vector<Node> tree(n);
    for(int i=0; i<n; i++){
        int a;
        cin>>a;
        tree[i].name=i;
        if(a==-1){
            tree[0].name=i;
        } else{
            if(tree[a].left==NULL){
                tree[a].left=&tree[i];
            } else if(tree[a].right==NULL) {
                tree[a].right=&tree[i];
            }
        }
    }
    root=&tree[0];
    cin>>del;
    if(del==0) {cout<<"0"; return 0;}
    tree[del].left=NULL;
    tree[del].right=NULL;
    order(root);
    if(cnt==1) {cout<<"1"; return 0;}
    cout<<cnt-1;
}