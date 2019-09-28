#include <stdio.h>
#include <windows.h>
#include <iostream>
using namespace std;

void testRef(int &v1Ref){
    // 在这里，我们就不用担心refence是否为空
    v1Ref=v1Ref+11;//修改引用的值会修改原始变量值
    cout << "a|testRef改变值v1 值:";
    cout << v1Ref << endl;
}

void testPoint(int *v1Point){
    // 为了代码的稳健和安全，我们需要判断指针是否有效,通常做法是判断指针是否为空，其他的判断就需要根据函数的具体功能来判断了
    if(NULL != v1Point){
       *v1Point=*v1Point+10;
        cout << "c|testPoint改变值v1 值:";
        cout << *v1Point << endl;
    }
}

int main(int argc, char *args[]){
    int v1=1;
    int& v1Ref=v1; //引用

    cout << "b0|v1 原始值:";
    cout << v1 << endl;
    testRef(v1Ref);
    cout << "b|改变引用改变值v1 值:";
    cout << v1 << endl;

    int v2=2;
    int *v2Point=&v2;

    cout << "d0|v2 原始值:";
    cout << v2 << endl;
    testPoint(v2Point);
    cout << "d|改变指针后v2 值:";
    cout << v2 << endl;


    system("pause");
    return 0;
}
