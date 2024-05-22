#include <iostream>
#include <vector>
using namespace std;

struct Node{
    char c;
    Node *left = NULL;
    Node *right = NULL;
};

void preorder(Node * root){
    cout<<root->c;
    if(root->left!=NULL){
        preorder(root->left);}
    if(root->right!=NULL){
        preorder(root->right);}
}

void inorder(Node * root){
    if(root->left!=NULL){
        inorder(root->left);
    }
    cout<<root->c;
    if(root->right!=NULL){
        inorder(root->right);
    }
}

void postorder(Node * root){
    if(root->left!=NULL){
        postorder(root->left);
    }
    if(root->right!=NULL){
        postorder(root->right);
    }
    cout<<root->c;    
}

int main() {
    int N;
    vector<Node> arr(26);
    cin>>N;
    Node * root;

    for(int i=0; i<N; i++){
        char node, left, right;
        cin>>node>>left>>right;
        arr[node-'A'].c = node;
        if(left!='.') arr[node-'A'].left = &arr[left-'A'];
        if(right!='.') arr[node-'A'].right = &arr[right-'A'];
    }
    root = &arr[0];
    preorder(root);
    cout<<endl;
    inorder(root);
    cout<<endl;
    postorder(root);
}