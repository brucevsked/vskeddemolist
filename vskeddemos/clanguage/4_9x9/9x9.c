#include <stdio.h>

int main(){
    for(int row=1;row<10;row++){
        for(int column=1;column<=row;column++){
            printf("%d*%d=%d\t",column,row,row*column);
        }
        printf("\n");
    }
    return 0;
}
