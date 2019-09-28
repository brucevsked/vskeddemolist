#include <stdio.h>
#include <windows.h>
#include <iostream>
using namespace std;

int main(int argc, char *args[]){
    int v1=666;
    int *v1Point;
    char cArray[5]={'H','E','L','L','O'};

    int v2Array[5]={5,2,3,1,5};
    int *v2ArrayPoint;

    cout << "变量v1内存地址:";
    cout << &v1 << endl;

    cout << "变量cArray内存地址:";
    cout << &cArray << endl;

    v1Point=&v1;

    // 访问指针中地址的值
    cout << "变量v1内存地址:";
    cout << &v1 << ",还可以表示为:";
    cout << v1Point << endl;

    cout << "变量v1值为:";
    cout << v1 << "用指针取值为:";
    cout << *v1Point << endl;

    //循环指针
    v2ArrayPoint=v2Array;

    for(int i=0;i<5;i++){
      cout << "内存地址[" << i << "] = ";
      cout << v2ArrayPoint << endl;
      cout << "值[" << i << "] = ";
      cout << *v2ArrayPoint << endl;
      v2ArrayPoint++;
    }


    system("pause");
    return 0;
}