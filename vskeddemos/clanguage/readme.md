# 环境配置

## C/C++ for Visual Studio Code  
第一步 安装C/C++ for Visual Studio Code扩展

## mingw
第二步 安装windows版本mingw  
https://sourceforge.net/projects/mingw-w64/files/  
选择这个版本x86_64-posix-seh  
下载完成后解压到D盘根目录如下  
D:\mingw64  

## 配置mingw环境变量
mingwhome  
D:\mingw64 

PATH后面新添加  
%mingwhome%\bin 
%mingwhome%\x86_64-w64-mingw32\bin  

验证环境变量  
gcc --version  

gcc (x86_64-posix-seh-rev0, Built by MinGW-W64 project) 8.1.0  
Copyright (C) 2018 Free Software Foundation, Inc.  
This is free software; see the source for copying conditions.  There is NO  
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  

说明配置正确了  

## 设置C/C++扩展选项
要运行某个程序时将vscodetemplate目录中配置好的.vscode目录复制到你的文件夹中即可  
