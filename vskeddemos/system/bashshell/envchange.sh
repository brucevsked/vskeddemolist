#!/bin/bash

#打开脚本调试
set -x

echo 环境切换脚本参数需要传入1个，可选值为dev,test,prod
echo 默认为开发环境dev,根据传参会选择test测试环境，prod生产环境

curenv=$1

if [ ! $curenv || $curenv=dev ]; then
  echo "未传入参数，默认为开发环境"
  curenv=dev
  elif [  $curenv=dev ]; then
  echo 
else
  echo "当前环境参数不能识别"
  echo $curenv
fi

