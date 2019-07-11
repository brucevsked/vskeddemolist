'use strict'

$(function(){
	$('#webUserLogoutBt1').on('click',webIndex.logout);
	$('#webUserLogoutBt2').on('click',webIndex.logout);
	$('#webUserListBt').on('click',webIndex.towebuserlist);
	$('#webRoleListBt').on('click',webIndex.towebrolelist);
	$('#webPermissionListBt').on('click',webIndex.towebpermissionlist);
	
	//---------------start app
	$('#appUserListBt').on('click',webIndex.toappuserlist);
	$('#appRoleListBt').on('click',webIndex.toapprolelist);
	$('#appPermissionListBt').on('click',webIndex.toapppermissionlist);
	$('#appSysParamListBt').on('click',webIndex.toappsysparamlist);
	$('#appModuleTypeListBt').on('click',webIndex.toappmoduletypelist);
	$('#appModuleListBt').on('click',webIndex.toappmodulelist);
	$('#appNoticeListBt').on('click',webIndex.toappnoticelist);
	$('#appBalanceReportBt').on('click',webIndex.tobalancereport);
	$('#appAdvertTypeListBt').on('click',webIndex.toappadverttypelist);
	$('#appAdvertInfoListBt').on('click',webIndex.toappadvertlist);
	$('#appFileListListBt').on('click',webIndex.toappfilelistlist);
	$('#appSiteMailBt').on('click',webIndex.tositemaillist);
	$('#appHumanTypeBt').on('click',webIndex.tohumantypelist);
	$('#appVideoTypeBt').on('click',webIndex.tovideotypelist);
	$('#appHumanInfoBt').on('click',webIndex.tohumanlist);
	$('#appVideoBt').on('click',webIndex.tovideolist);
	$('#appVideoCommentBt').on('click',webIndex.tovideocommentlist);
	$('#appCardCodeBt').on('click',webIndex.tocardcodelist);
	$('#appUserBalanceBt').on('click',webIndex.toappuserbalancehislist);
	$('#appUserPromotionBalanceBt').on('click',webIndex.toappusepromotionbalancehislist);
	$('#appUserCashBt').on('click',webIndex.toappusercashhislist);
	$('#appUserFeedBackBt').on('click',webIndex.toappuserfeedbacklist);
	$('#appVersionBt').on('click',webIndex.toappversionlist);
	$('#appUserChatHisBt').on('click',webIndex.toappuserchathislist);
	$('#appUseSearchHisBt').on('click',webIndex.toappusersearchhislist);
	$('#appUserPlayHisBt').on('click',webIndex.toappuserplayhislist);
	$('#appUserBuyBt').on('click',webIndex.toappuserbuylist);
	$('#appServerBt').on('click',webIndex.toappserverlist);
	$('#appVipPriceBt').on('click',webIndex.toappvippricelist);
	$('#appUserCollectBt').on('click',webIndex.toappusercollectlist);
	$('#appBannerTypeListBt').on('click',webIndex.toappbannertypelist);
	$('#appBannerListBt').on('click',webIndex.toappbannerlist);
	$('#appCacheBt').on('click',webIndex.toappcacheclean);
	
});

var webIndex=new Object({
	logout: function(){
		$(location).prop('href', basePath+'/webapi/v1/webuserlogout?token='+$('#servertoken').val());
	},
	towebuserlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/towebuserlist',{token: $('#servertoken').val() });
	},
	towebrolelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/towebrolelist',{token: $('#servertoken').val() });
	},
	towebpermissionlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/towebpermissionlist',{token: $('#servertoken').val() });
	},
	toappuserlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappuserlist',{token: $('#servertoken').val() });
	},
	toapprolelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toapprolelist',{token: $('#servertoken').val() });
	},
	toapppermissionlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toapppermissionlist',{token: $('#servertoken').val() });
	},
	toappsysparamlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappsysparamlist',{token: $('#servertoken').val() });
	},
	toappmoduletypelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappmoduletypelist',{token: $('#servertoken').val() });
	},
	toappmodulelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappmodulelist',{token: $('#servertoken').val() });
	},
	toappnoticelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappnoticelist',{token: $('#servertoken').val() });
	},
	tobalancereport:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/tobalancereport',{token: $('#servertoken').val() });
	},
	toappadverttypelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappadverttypelist',{token: $('#servertoken').val() });
	},
	toappadvertlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappadvertlist',{token: $('#servertoken').val() });
	},
	toappfilelistlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappfilelistlist',{token: $('#servertoken').val() });
	},
	tositemaillist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappsitemaillist',{token: $('#servertoken').val() });
	},
	tohumantypelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toapphumantypelist',{token: $('#servertoken').val() });
	},
	tovideotypelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappvideotypelist',{token: $('#servertoken').val() });
	},
	tohumanlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toapphumanlist',{token: $('#servertoken').val() });
	},
	tovideolist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappvideolist',{token: $('#servertoken').val() });
	},
	tovideocommentlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappvideocommentlist',{token: $('#servertoken').val() });
	},
	tocardcodelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappcardcodelist',{token: $('#servertoken').val() });
	},
	toappuserbalancehislist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappuserbalancehislist',{token: $('#servertoken').val() });
	},
	toappusepromotionbalancehislist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappusepromotionbalancehislist',{token: $('#servertoken').val() });
	},
	toappusercashhislist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappusercashhislist',{token: $('#servertoken').val() });
	},
	toappuserfeedbacklist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappuserfeedbacklist',{token: $('#servertoken').val() });
	},
	toappversionlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappversionlist',{token: $('#servertoken').val() });
	},
	toappuserchathislist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappuserchathislist',{token: $('#servertoken').val() });
	},
	toappusersearchhislist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappusersearchhislist',{token: $('#servertoken').val() });
	},
	toappuserplayhislist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappuserplayhislist',{token: $('#servertoken').val() });
	},
	toappuserbuylist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappuserbuylist',{token: $('#servertoken').val() });
	},
	toappserverlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappserverlist',{token: $('#servertoken').val() });
	},
	toappvippricelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappvippricelist',{token: $('#servertoken').val() });
	},
	toappusercollectlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappusercollectlist',{token: $('#servertoken').val() });
	},
	toappbannertypelist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappbannertypelist',{token: $('#servertoken').val() });
	},
	toappbannerlist:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappbannerlist',{token: $('#servertoken').val() });
	},
	toappcacheclean:function(){
		webCommon.menuActive(this);
		webCommon.loadPage('/webapi/v1/toappcacheclean',{token: $('#servertoken').val() });
	}
	
});