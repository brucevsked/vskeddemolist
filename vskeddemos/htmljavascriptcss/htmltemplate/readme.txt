

本示例解决前后端分离时js与css引入问题

第一步所有界面必须都引入项目主css
<link rel="stylesheet" href="css/maincss.css" >

第二步如果项目中有单独样式需要处理，界面中可以引入单独css,非强制要求
<link rel="stylesheet" href="css/project/userList.css" >

第三步所有界面必须引入项目主javascript与jquery
  <!-- 项目通用jquery 脚本 -->
  <script language="javascript" type="text/javascript" src="js/lib/jquery.min.js"></script>
  <!-- 项目通用主脚本 此脚本会引入其他公用脚本 -->
  <script language="javascript" type="text/javascript" src="js/mainjs.js" ></script>
	<!-- 项目通用工具脚本  -->
	<script language="javascript" type="text/javascript" src="js/project/common.js" ></script>

第四步如果项目中本模块有单独脚本处理，界面中可以引入单独javascript,非强要求，一般都会有
	<!-- 本界面模块专用脚本 -->
	<script language="javascript" type="text/javascript" src="js/project/user/userList.js" ></script>

第五步，如果要添加新的项目公用css时，只需要修改maincss.css即可

第六步，如果要添加新的项目公用javascript时，只需要修改main.js脚本即可

第七步，如果模块界面中只用到某一个控件就只在那一个界面中引入，如向导，复选框美化，表格等插件。


