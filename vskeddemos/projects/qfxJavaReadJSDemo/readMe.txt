1.这个是java调用js中函数的示例
2.目录结构：
	├─src
	│  └─com
	│      └─qfx
	│          ├─interfaces
	│          │      JavaScriptInterface.java //与JavaScript通信的接口
	│          │      
	│          └─test
	│                 ExecuteJavaScript.java //测试调用js的实现
	│                  
	└─static
	    └─js
	            dateUtil.js //js文件
	            main.js //js文件,此文件引用了dateUtil.js的函数
3.测试方法：
	直接执行 ExecuteJavaScript.java 中的mani方法即可