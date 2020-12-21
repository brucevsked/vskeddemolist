#include <stdio.h>

int main(){
    int a=10;
    int *p=&a;
    a=a+1;
    printf("Value is:%d",*p);

    return 0;
}
