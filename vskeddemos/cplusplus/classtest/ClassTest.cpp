#include <stdio.h>
#include <windows.h>
#include <iostream>
using namespace std;

class Box {
    public:
        int width;
        int height;
        int length;
        Box();
        void setWidth(int inWith);
        int getWidth();


};

Box::Box(){
    cout << "构造函数" << endl;
};

void Box::setWidth(int inWith){
    width=inWith;
};

int Box::getWidth(){
    return width;
}



int main(int argc, char *args[]){
    Box b1;
    b1.height=20;
    b1.setWidth(60);
    b1.length=50;
    cout << b1.width << endl;

    int myWidth1=b1.getWidth();//第一种调用方法对象.方法
    cout << myWidth1 << endl;

    Box *b1Point=&b1;
    int myWidth2=b1Point->getWidth();//第二种调用方法 指针->方法名
    cout << myWidth2 << endl;

    system("pause");
}