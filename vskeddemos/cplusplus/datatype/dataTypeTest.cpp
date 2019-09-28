#include <stdio.h>
#include <windows.h>

int main(int argc, char *args[]){

    unsigned char c1='A'; //0~255
    printf("unsigned char type:%c,ascii:%d,size:%d \n",c1,c1,sizeof(c1));
    signed char c2='A'; //-128~127
    printf("signed char type:%c,ascii:%d,size:%d \n",c2,c2,sizeof(c2));

    unsigned short s1=123; //0~65535
    printf("unsigned short type:%d,size:%d \n",s1,sizeof(s1));
    signed short s2=123; //-32768~32767
    printf("signed short type:%d,size:%d \n",s2,sizeof(s2));

    unsigned int i1=123; //默认0~4294967295
    printf("unsigned int type:%d,size:%d \n",i1,sizeof(i1));
    signed int i2=123; //-2147483648~2147483647
    printf("signed int type:%d,size:%d \n",i2,sizeof(i2));

    unsigned long l1=1234; //0~4294967295
    printf("unsigned long type:%d,size:%d \n",l1,sizeof(l1));
    signed long l2=1234; //-2147483648~2147483647
    printf("signed long type:%d,size:%d \n",l2,sizeof(l2));

    long long ll1=12345;//0~18446744073709552000
    printf("unsigned long long type:%d,size:%d \n",ll1,sizeof(ll1));

    bool b1=true; //true   false
    printf("bool type:%d,size:%d \n",b1,sizeof(b1));

    wchar_t wc1='T';
    printf("wchar_t type:%c,size:%d \n",wc1,sizeof(wc1));

    float f1=1.23f;//打印时1.2f表示1位有效数字后面保留2位小数
    printf("float type:%1.2f,size:%d \n",f1,sizeof(f1));

    double d1=3.1415;//打印时1.4f表示1位有效数字后面保留4位小数
    printf("double type:%1.4lf,size:%d \n",d1,sizeof(d1));

    long double ld1=1.123;
    printf("long double type:%Lf,size:%d \n",ld1,sizeof(ld1));

    system("pause");
    return 0;
}