#include <iostream>
#include <string>
using namespace std;

void helper(string &&para)
{
    cout << "helper : " << para << endl;
}
void message(string &msg)
{
    cout << "lvalue reference : " << msg << endl;
}
void message(string &&msg)
{ // Rvalue Reference를 파라미터로 받는 함수
    cout << "rvalue reference : " << msg << endl;
    // helper(msg); //error, 매개변수 msg는 lvalue
    // helper(move(msg)); // move() : lvalue->rvalue
}
int main()
{
    string str = "apple ";
    string temp = "banana";
    message(str); // message(move(str))로 호출하면?
    message(str + temp);
    message("orange");
    return 0;
}