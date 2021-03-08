#!/bin/bash

#打开脚本调试
set -x

echo 环境切换脚本参数需要传入1个，可选值为dev,test,prod
echo 默认为开发环境dev,根据传参会选择test测试环境，prod生产环境

curenv=$1


case $curenv in
    "dev" | "")
    echo "未传入参数，默认为开发环境"
    cp dev/application.yml /data/svn/project/mallrule/src/main/resources/application.yml
    cp dev/application-dev.yml /data/svn/project/mallrule/src/main/resources/application-dev.yml
    cp dev/log4j2.xml /data/svn/project/mallrule/src/main/resources/log4j2.xml
    cp dev/webCommon.js /data/svn/project/mallrule/src/main/resources/static/js/lib/common/webCommon.js
    ;;
    "test")
    echo "当前为测试环境啦"
    cp test/application.yml /data/svn/project/mallrule/src/main/resources/application.yml
    cp test/application-test.yml /data/svn/project/mallrule/src/main/resources/application-test.yml
    cp test/log4j2.xml /data/svn/project/mallrule/src/main/resources/log4j2.xml
    cp test/webCommon.js /data/svn/project/mallrule/src/main/resources/static/js/lib/common/webCommon.js
    ;;
    "prod")
    echo "当前为生产环境呀"
    cp prod/application.yml /data/svn/project/mallrule/src/main/resources/application.yml
    cp prod/application-prod.yml /data/svn/project/mallrule/src/main/resources/application-prod.yml
    cp prod/log4j2.xml /data/svn/project/mallrule/src/main/resources/log4j2.xml
    cp prod/webCommon.js /data/svn/project/mallrule/src/main/resources/static/js/lib/common/webCommon.js
    ;;
esac



