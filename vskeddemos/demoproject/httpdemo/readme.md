
# java 发送http请求技术合集

## JDK 自带的 HttpURLConnection 标准库
可移植性高，但代码编写较多。需要一定编程功力才可掌控。

## Apache HttpComponents HttpClient, 以及基于该库的 wrapper, 如 Unirest
版本升级互不兼容，已经被其他方案替代。
http://hc.apache.org/httpcomponents-client-5.0.x/index.html
http client 是前身，不再维护了，可以理解为改名叫 http component，都是apache的项目

## Jodd-http 轻量级请求发送应用
用的人较少

## okhttp
httpclient替代方案。代码简洁，质量更高。多用于接口类数据请求。
## retrofit  
okhttp的进一步封装，使用更方便。多用于接口类数据请求。
## httpunit
用于网页内容抓取，可以抓取通过js生成的网页 
## jsoup
用于网页内容抓取，但不能抓取js生成后的网页  

## Jodd-http
未使用