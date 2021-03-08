rem 环境切换脚本参数需要传入1个，可选值为dev,test,prod
rem 默认为开发环境dev,根据传参会选择test测试环境，prod生产环境

rem 设置当前环境参数
set curenv=%1

rem 如果不传值，默认环境为开发环境
if "%curenv%"=="" (
    echo 未传入参数，默认为开发环境
    goto dev
) else (
    echo 当前环境参数
    echo %curenv%
    goto %curenv%
)

:dev
echo 当前为开发环境

copy dev\application.yml D:\economy\project\mallrule\src\main\resources\application.yml
copy dev\application-dev.yml D:\economy\project\mallrule\src\main\resources\application-dev.yml
copy dev\log4j2.xml D:\economy\project\mallrule\src\main\resources\log4j2.xml
copy dev\webCommon.js D:\economy\project\mallrule\src\main\resources\static\js\lib\common\webCommon.js

pause
exit


:test
echo 当前为测试环境

copy test\application.yml D:\economy\project\mallrule\src\main\resources\application.yml
copy test\application-test.yml D:\economy\project\mallrule\src\main\resources\application-test.yml
copy test\log4j2.xml D:\economy\project\mallrule\src\main\resources\log4j2.xml
copy test\webCommon.js D:\economy\project\mallrule\src\main\resources\static\js\lib\common\webCommon.js
pause
exit

:prod
echo 当前为生产环境

copy prod\application.yml D:\economy\project\mallrule\src\main\resources\application.yml
copy prod\application-prod.yml D:\economy\project\mallrule\src\main\resources\application-prod.yml
copy prod\log4j2.xml D:\economy\project\mallrule\src\main\resources\log4j2.xml
copy prod\webCommon.js D:\economy\project\mallrule\src\main\resources\static\js\lib\common\webCommon.js

pause
exit

