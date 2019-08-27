package com.vsked.common;

public class RespCode {
	
	/**
	 * 统一状态码 000000 请求成功
	 */
	public static String commonSucc="000000";
	
	/**
	 * 统一状态码 999999 处理失败
	 */
	public static String commonFail="999999";
	
	/**
	 * 100000: 动态秘钥签发成功----issued tokenKey success
	 */
	public static String authKeySucc=commonSucc;
	/**
	 * 100001：动态秘钥签发失败----issued tokenKey fail
	 */
	public static String authKeyFail="100001";
	/**
	 * 100002：用户密码认证失败----login fail
	 */
	public static String authPassFail="100002";
	/**
	 * 100003: 用户密码认证成功,JWT 签发成功,返回jwt-----issued jwt success
	 */
	public static String authJwtSucc=commonSucc;
	/**
	 * 100004：JWT 签发失败----issued jwt fail
	 */
	public static String authJwtFail="100004";
	/**
	 * 100005: jwt_real_token过期,jwt_refresh_token还未过期,服务器返回新的jwt,客户端需携带新返回的jwt对这次请求重新发起----new jwt  
	 */
	public static String authJwtNew="100005";
	/**
	 * 100006: jwt_real_token过期,jwt_refresh_token过期(通知客户端重新登录)-----expired jwt
	 */
	public static String authJwtExpire="100006";
	/**
	 * 100007: jwt_token认证失败无效(包括用户认证失败或者jwt令牌错误无效或者用户未登录)----error jwt
	 */
	public static String authJwtError="100007";
	/**
	 * 100008: jwt token无权限访问此资源----no permission
	 */
	public static String authJwtNoPermission="100008";
	/**
	 * 100009 缺少参数用户名
	 */
	public static String noPhone="100009";
	/**
	 * 100010 缺少参数用户密码
	 */
	public static String noUserPass="100010";
	/**
	 * 100011 用户不存在
	 */
	public static String userNotExist="100011";
	
	/**
	 * 手机号已注册
	 */
	public static String phoneHasExist="100012";
	/**
	 * 100013 注册成功
	 */
	public static String phoneRegSuccess=commonSucc;
	/**
	 * 100014 注册失败
	 */
	public static String phoneRegFail="100014";
	
	/**
	 * 100015 缺少用户名参数
	 */
	public static String noUserName="100015";
	
	/**
	 * 000000 注销成功
	 */
	public static String logoutOk=commonSucc;
	
	/**
	 * 000000 添加用户成功 
	 */
	public static String addWebUserOk=commonSucc;
	
	/**
	 * 100016 添加用户失败
	 */
	public static String addWebUserFail="100016";
	/**
	 * 100017 缺少参数主页分类名称
	 */
	public static String noModuleTypeName="100017";
	
	/**
	 * 100018 主页分类添加失败
	 */
	public static String moduleTypeAddFail="100018";
	
	/**
	 * 100019 获取当前用户编号失败
	 */
	public static String getCurrentUidFail="100019";
	/**
	 * 100020 请填写公告标题
	 */
	public static String noNoticeTitle="100020";
	/**
	 * 100021 请填写公告内容
	 */
	public static String noNoticeContent="100021";
	/**
	 * 100022 影星编号未传入
	 */
	public static String noHumanInfoId="100022";
	/**
	 * 100023 缺少设备类型参数
	 */
	public static String noDeviceType="100023";
	/**
	 * 100024获取视频编号失败
	 */
	public static String getAppVideoIdFail="100024";
	/**
	 * 100025添加播放记录失败
	 */
	public static String addAppUserPlayHisFail="100025";
	/**
	 * 100026记录搜索历史失败
	 */
	public static String addAppUserSearchHisFail="100026";
	/**
	 * 100027缺少搜索内容参数
	 */
	public static String noAppUserSearchHisContent="100027";
	/**
	 * 100028缺少用户搜索记录编号
	 */
	public static String noAppUserSearchHisId="100028";
	/**
	 * 100029删除用户搜索记录失败
	 */
	public static String delAppUserSearchHisFail="100029";
	/**
	 * 100030缺少参数banner类型
	 */
	public static String noBannerType="100030";
	/**
	 * 100031上传文件失败
	 */
	public static String addFileFail="100031";
	/**
	 * 100032 获取转账目标用户失败
	 */
	public static String touidFail="100032";
	/**
	 * 100033获取转账金额失败
	 */
	public static String getAmountFail="100033";
	/**
	 * 100034代理商余额不足
	 */
	public static String agentBalanceNotEnough="100034";
	/**
	 * 100035代理商状态不正常
	 */
	public static String agentStateFail="100035";
	/**
	 * 100036代理金额更新失败
	 */
	public static String agentBalanceUpdateFail="100036";
	/**
	 * 100037用户金额更新失败
	 */
	public static String appUserBalanceUpdateFail="100037";
	/**
	 * 100038记录余额历史失败
	 */
	public static String appUserBalanceHisFail="100038";
	/**
	 * 100039缺少参数视频编号
	 */
	public static String appVideoInfoIdNotExist="100039";
	/**
	 * 100040 视频资源不存在
	 */
	public static String appVideoInfoNotExist="100040";
	/**
	 * 100041用户余额不足
	 */
	public static String appUserBalanceNotEnough="100041";
	/**
	 * 100042用户状态非法
	 */
	public static String appUserStateError="100042";
	/**
	 * 100043无发送用户编号
	 */
	public static String appUserChatHisNoFrom="100043";
	/**
	 * 100044无目标用户编号
	 */
	public static String appUserChatHisNoTarget="100044";
	/**
	 * 100045无聊天内容
	 */
	public static String appUserChatHisNoContent="100045";
	/**
	 * 100046添加聊天记录失败
	 */
	public static String appUserChatHisAddFail="100046";
	/**
	 * 100047缺少vip购买等级编号
	 */
	public static String noAppUserVipPriceId="100047";
	/**
	 * 100048购买vip失败
	 */
	public static String appUserVipBuyFail="100048";
	/**
	 * 100049更新用户信息失败
	 */
	public static String appUseUpdateFail="100049";
	/**
	 * 100050缺少关注类型参数
	 */
	public static String noAppUserCollectType="100050";
	/**
	 * 100051缺少关注id参数
	 */
	public static String noAppUserCollectId="100051";
	/**
	 * 100052添加用户关注失败
	 */
	public static String appUserCollectAddFail="100052";
	/**
	 * 100053取消关注失败
	 */
	public static String appUserCollectDelFail="100053";
	/**
	 * 100054反馈内容不能为空
	 */
	public static String noAppUserFeedBackContent="100054";
	/**
	 * 100055添加用户反馈失败
	 */
	public static String appUserFeedBackAddFail="100055";
	/**
	 * 100056无法获取设备唯一标识
	 */
	public static String noDeviceIdentify="100056";
	/**
	 * 100057无明星信息
	 */
	public static String noHumanInfo="100057";
	/**
	 * 100058用户密码更新失败
	 */
	public static String appUserPassUpdateFail="100058";
	/**
	 * 100059用户状态更新失败
	 */
	public static String appUserStatusUpdateFail="100059";
	/**
	 * 100060获取修改用户编号失败
	 */
	public static String appUserStatusGetUidFail="100060";
	/**
	 * 100061 模块添加失败
	 */
	public static String moduleAddFail="100061";
	/**
	 * 100062金额必须大于0
	 */
	public static String priceMustMoreZero="100062";
	/**
	 * 100063缺少广告类型参数
	 */
	public static String noAdvertType1="100063";
	/**
	 * 100064 模块更新失败
	 */
	public static String moduleUpdateFail="100064";
	/**
	 * 100065 缺少参数广告类型名称
	 */
	public static String noAdvertTypeName="100065";
	/**
	 * 100066 广告类型添加失败
	 */
	public static String advertTypeAddFail="100066";
	/**
	 * 100067 广告类型更新失败
	 */
	public static String appAdvertTypeUpdateFail="100067";
	/**
	 * 100068验证码检测失败
	 */
	public static String checkVerifyCodeFail="100068";
	/**
	 * 100069缺少验证码参数
	 */
	public static String noVerifyCode="100069";
	/**
	 * 100070缺少旧密码
	 */
	public static String noOldPassword="100070";
	/**
	 * 100071缺少新密码
	 */
	public static String noNewPassword="100071";
	/**
	 * 100072旧密码输入错误
	 */
	public static String oldPasswordWrong="100072";
	/**
	 * 100073缺少浏览记录编号
	 */
	public static String noPlayHisId="100073";
	/**
	 * 100074删除浏览记录失败
	 */
	public static String delPlayHisFail="100074";
	/**
	 * 100075缺少参数消费订单编号
	 */
	public static String noUserBalanceHisOrderId="100075";
	/**
	 * 100076获取评论内容失败
	 */
	public static String getVideoCommentContentFail="100076";
	/**
	 * 100077添加评论失败
	 */
	public static String appVideoCommentAddFail="100077";
	/**
	 * 100078未传入广告编号
	 */
	public static String noAdvertInfoId="100078";
	/**
	 * 100079更新有效点击次数失败
	 */
	public static String advertClickTimeUpdateFail="100079";
	/**
	 * 100080缺少卡密参数
	 */
	public static String noCardCodeParam="100080";
	/**
	 * 100081卡密信息不存在
	 */
	public static String noCardCodeInfo="100081";
	/**
	 * 100082卡密已过期
	 */
	public static String cardCodeExpire="100082";
	/**
	 * 100083卡密激活失败
	 */
	public static String cardCodeActiveFail="100083";
	/**
	 * 100084获取提现金额失败
	 */
	public static String getCashAmountFail="100084";
	/**
	 * 100085低于最小提现金额
	 */
	public static String lessCashAmountFail="100085";
	/**
	 * 100086高于晨大提现金额
	 */
	public static String moreCashAmountFail="100086";
	/**
	 * 100087获取提现类型失败
	 */
	public static String getCashTypeFail="100087";
	/**
	 * 100088获取提现账号失败
	 */
	public static String getCashAccountFail="100088";
	/**
	 * 100089可提现余额不足
	 */
	public static String balanceCashFail="100089";
	/**
	 * 100090提现申请失败
	 */
	public static String reqCashFail="100090";
	/**
	 * 100091缺少站内信编号
	 */
	public static String noUserSiteMailId="100091";
	/**
	 * 100092更新站内信阅读状态失败
	 */
	public static String userSiteMailStateUpdateFail="100092";
	/**
	 * 100093 请填写站内信标题
	 */
	public static String noSiteMailTitle="100093";
	/**
	 * 100094 请填写站内信内容
	 */
	public static String noSiteMailContent="100094";
	/**
	 * 100095无系统参数编号
	 */
	public static String noSysParamId="100095";
	/**
	 * 100095无系统参数名称
	 */
	public static String noSysParamName="100096";
	/**
	 * 100097无系统参数值
	 */
	public static String noSysParamValue="100097";
	/**
	 * 100098有提现申请未处理不能再次发起提现
	 */
	public static String existUserCashReq="100098";
	
	/**
	 * 100099获取修改用户编号失败
	 */
    public static String webNoFixUid="100099";
    /**
     * 100100用户金额更新失败
     */
    public static String webAppUserBalanceFail="100100";
    /**
     * 100101获取唯一标识失败
     */
    public static String webGetIdFail="100101";
    /**
     * 100102未找到需要处理数据
     */
    public static String webNoProcData="100102";
    /**
     * 100103缺少提现处理结果状态
     */
    public static String webUserCashReviewNoState="100103";
    /**
     * 100104验证失败,提现金额与冻结金额不一致
     */
    public static String webUserCashFreezeCheckFail="100104";
    /**
     * 100105我方打款账号不能为空
     */
    public static String webUserCashOpAccountEmpty="100105";
    /**
     * 100106视频类型名称不能为空
     */
    public static String webVideoTypeNameEmpty="100106";
    /**
     * 100107视频描述不能为空
     */
    public static String webVideoTypDescriptionEmpty="100107";
    /**
     * 100108视频类型等级不能为空
     */
    public static String webVideoTypeLevelEmpty="100108";
    /**
     * 100109上级视频类型编号不能为空
     */
    public static String webVideoTypeParentIdEmpty="100109";
    /**
     * 100110视频类型已存在不能重复添加
     */
    public static String webVideoTypeNameExists="100110";
    /**
     * 100111邀请码已存在
     */
    public static String webMyInvitationCodeExists="100111";
    /**
     * 100112邀请码参数不能为空
     */
    public static String webMyInvitationCodeEmpty="100112";
    /**
     * 100113影星类型名称不能为空
     */
    public static String webHumanTypeNameEmpty="100113";
    /**
     * 100114影星描述不能为空
     */
    public static String webHumanTypDescriptionEmpty="100114";
    /**
     * 100115影星类型等级不能为空
     */
    public static String webHumanTypeLevelEmpty="100115";
    /**
     * 100116上级影星类型编号不能为空
     */
    public static String webHumanTypeParentIdEmpty="100116";
    /**
     * 100117影星类型已存在不能重复添加
     */
    public static String webHumanTypeNameExists="100117";
    /**
     * 100118影星姓名不能为空
     */
    public static String webHumanNameEmpty="100118";
    /**
     * 100119影星描述不能为空
     */
    public static String webHumanDescriptionEmpty="100119";
    /**
     * 100120影星图片不能为空
     */
    public static String webHumanPicEmpty="100120";
    /**
     * 100121影片1级分类不能为空
     */
    public static String webVideoType1Empty="100121";
    /**
     * 100122影片2级分类不能为空
     */
    public static String webVideoType2Empty="100122";
    /**
     * 100123影片名称不能为空
     */
    public static String webVideoNameEmpty="100123";
    /**
     * 100124影片描述不能为空
     */
    public static String webVideoDescriptionEmpty="100124";
    /**
     * 100125影片价格不能为空
     */
    public static String webVideoPriceEmpty="100125";
    /**
     * 100126影片封面图片地址不能为空
     */
    public static String webVideoCoverUrlsEmpty="100126";
    /**
     * 100127影片是否收费不能为空
     */
    public static String webVideoIsPriceEmpty="100127";
    /**
     * 100128影片是否热播不能为空
     */
    public static String webVideoIsHotEmpty="100128";
    /**
     * 100129影片是否推荐不能为空
     */
    public static String webVideoIsCommendEmpty="100129";
    /**
     * 100130vip名称不能为空
     */
    public static String webVipPriceNameEmpty="100130";
    /**
     * 100131vip等级不能为空
     */
    public static String webVipPriceLevelEmpty="100131";
    /**
     * 100132vip天数不能为空
     */
    public static String webVipPriceDaysEmpty="100132";
    /**
     * 100133vip价格不能为空
     */
    public static String webVipPricePriceEmpty="100133";
    /**
     * 100134vip名称已存在不能重复添加
     */
    public static String webVipPriceNameExists="100134";
    /**
     * 100135缺少上传文件类型参数
     */
    public static String appFileUploadTypeEmpty="100135";
    /**
     * 100136卡密绑定vip卡编号为空
     */
    public static String webCardCodeVipPriceIdEmpty="100136";
    /**
     * 100137初始化数量为空
     */
    public static String webCardCodeCountEmpty="100137";
    /**
     * 100138卡密过期时间为空
     */
    public static String webCardCodeExpireEmpty="100138";
    /**
     * 100139版本名称不能为空
     */
    public static String webVersionNameEmpty="100139";
    /**
     * 100140版本代码不能为空
     */
    public static String webVersionCodeEmpty="100140";
    /**
     * 100141版本更新内容不能为空
     */
    public static String webVersionUpContentEmpty="100141";
    /**
     * 100142版本号不能为空
     */
    public static String webVersionEmpty="100142";
    /**
     * 100143版本唯一标识不能为空
     */
    public static String webVersionIdentifyEmpty="100143";
    /**
     * 100144服务端版本不能为空
     */
    public static String webServerVersionEmpty="100144";
    /**
     * 100145更新地址不能为空
     */
    public static String webUpdateUrlEmpty="100145";
    /**
     * 100146模块类型名称不能为空
     */
    public static String webModuleTypeNameEmpty="100146";
    /**
     * 100147模块类型描述不能为空
     */
    public static String webModuleTypeDescriptionEmpty="100147";
    /**
     * 100148模块类型序列不能为空
     */
    public static String webModuleTypeSeqEmpty="100148";
    /**
     * 100149模块类型状态不能为空
     */
    public static String webModuleTypeStateEmpty="100149";
	/**
	 * 100150 缺少参数广告类型描述
	 */
	public static String noAdvertTypeDescription="100150";
	/**
	 * 100151缺少广告名称
	 */
	public static String noAdvertName="100151";
	/**
	 * 100152缺少广告目标类型
	 */
	public static String noAdvertTargetType="100152";
	/**
	 * 100153缺少广告目标链接
	 */
	public static String noAdvertTarget="100153";
	/**
	 * 100154缺少广告序列
	 */
	public static String noAdvertSeq="100154";
	/**
	 * 100155缺少广告图片
	 */
	public static String noAdvertStoreUrl="100155";
	/**
	 * 100156缺少banner类型名称
	 */
	public static String noBannerTypeName="100156";
	/**
	 * 100157缺少banner类型描述
	 */
	public static String noBannerTypeDescription="100157";
	/**
	 * 100158缺少banner类型
	 */
	public static String webNoBannerType="100158";
	/**
	 * 100159缺少banner名称
	 */
	public static String webNoBannerName="100159";
	/**
	 * 100160缺少banner描述
	 */
	public static String webNoBannerDescription="100160";
	/**
	 * 100161缺少banner序列
	 */
	public static String webNoBannerSeq="100161";
	/**
	 * 100162缺少banner目标类型
	 */
	public static String webNoBannerTargetType="100162";
	/**
	 * 100163缺少banner目标地址
	 */
	public static String webNoBannerTarget="100163";
	/**
	 * 100164缺少banner加载地址
	 */
	public static String webNoBannerUrl="100164";
	/**
	 * 100165缺少系统参数类型
	 */
	public static String webNoSysParamType="100165";
	/**
	 * 100166缺少系统参数编码
	 */
	public static String webNoSysParamCode="100166";
	/**
	 * 100167缺少参数服务器组
	 */
	public static String webNoServerGroup="100167";
	/**
	 * 100168缺少参数服务器IP
	 */
	public static String webNoServerIp="100168";
	/**
	 * 100169缺少参数服务器域名
	 */
	public static String webNoServerDomain="100169";
	/**
	 * 100170缺少参数服务器名称
	 */
	public static String webNoServerName="100170";
	/**
	 * 100171缺少参数服务器运营商
	 */
	public static String webNoServerIsp="100171";
	/**
	 * 100172缺少参数服务器地区码
	 */
	public static String webNoServerAreaCode="100172";
	/**
	 * 100173缺少参数服务器状态
	 */
	public static String webNoServerState="100173";
	/**
	 * 100174缺少参数用户角色
	 */
	public static String webNoUserRole="100174";
	/**
	 * 100175缺少参数模块类型
	 */
	public static String webNoModuleType="100175";
	/**
	 * 100176缺少参数模块名称
	 */
	public static String webNoModuleName="100176";
	/**
	 * 100177缺少参数模块编码
	 */
	public static String webNoModuleCode="100177";
	/**
	 * 100178缺少参数模块样式
	 */
	public static String webNoModuleStyle="100178";
	/**
	 * 100179缺少参数模块api
	 */
	public static String webNoModuleApi="100179";
	/**
	 * 100180缺少参数模块表名
	 */
	public static String webNoModuleTbName="100180";
	/**
	 * 100181缺少参数模块参数名
	 */
	public static String webNoModuleTbParam="100181";
	/**
	 * 100182缺少参数模块序列
	 */
	public static String webNoModuleSeq="100182";
	/**
	 * 100183缺少参数模块状态
	 */
	public static String webNoModuleState="100183";
	/**
	 * 100184缺少模块头部隐藏显示状态
	 */
	public static String webNoModuleHeadViewState="100184";
	/**
	 * 100185缺少缓存清理类型参数
	 */
	public static String webNoCacheCleanType="100185";
	/**
	 * 100186缺少参数web权限编码
	 */
	public static String webNoWebPermissionCode="100186";
	/**
	 * 100187缺少参数web权限名称
	 */
	public static String webNoWebPermissionName="100187";
	/**
	 * 100188缺少参数web权限uri
	 */
	public static String webNoWebPermissionUri="100188";
	/**
	 * 100189缺少参数web角色编码
	 */
	public static String webNoWebRoleCode="100189";
	/**
	 * 100190缺少参数web角色名称
	 */
	public static String webNoWebRoleName="100190";
	/**
	 * 100191缺少参数app权限编码
	 */
	public static String webNoAppPermissionCode="100191";
	/**
	 * 100192缺少参数app权限名称
	 */
	public static String webNoAppPermissionName="100192";
	/**
	 * 100193缺少参数app权限uri
	 */
	public static String webNoAppPermissionUri="100193";
	/**
	 * 100194缺少参数app角色编码
	 */
	public static String webNoAppRoleCode="100194";
	/**
	 * 100195缺少参数app角色名称
	 */
	public static String webNoAppRoleName="100195";
	/**
	 * 100196缺少参数手机号
	 */
	public static String webNoPhone="100196";
	/**
	 * 100197金额不能为空
	 */
	public static String webNoAmount="100197";

	//------------------------------------------------------------------exception code start-----------------------------------
	/**
	 * 900000服务器错误,请联系管理员
	 */
	public static String serverException="900000";
	
	/**
	 * 900001 注册服务器异常,请联系管理员
	 */
	public static String regException="900001";
	/**
	 * 900002用户登录服务器异常，请联系管理员
	 */
	public static String loginException="900002";
	
	/**
	 * 900003 添加用户异常
	 */
	public static String addWebUserException="900003";
	
	/**
	 * 900004 获取app用户信息异常
	 */
	public static String getAppUserInfoException="900004";
	
	/**
	 * 900005 获取模块类型异常
	 */
	public static String getAppModuleTypeException="900005";
	/**
	 * 900006 主页分类添加异常
	 */
	public static String appModuleTypeAddException="900006";
	/**
	 * 900007 获取用户公告异常
	 */
	public static String appUserNoticeException="900007";
	/**
	 * 900008 添加公告异常
	 */
	public static String appNoticeAddException="900008";
	/**
	 * 900009 影星列表异常
	 */
	public static String appHumanListException="900009";
	/**
	 * 900010 影星信息异常
	 */
	public static String appHumanInfoException="900010";
	/**
	 * 900011 模块列表异常
	 */
	public static String appModuleListException="900011";
	/**
	 * 900012 广告类型异常
	 */
	public static String appAdvertTypeException="900012";
	/**
	 * 900013广告列表异常
	 */
	public static String appAdvertListException="900013";
	/**
	 * 900014 公告获取异常
	 */
	public static String appNoticeException="900014";
	/**
	 * 900015 获取版本信息异常
	 */
	public static String appVersionException="900015";
	/**
	 * 900016 获取用户列表异常
	 */
	public static String appUserListException="900016";
	/**
	 * 900017 获取播放记录异常
	 */
	public static String appUserPlayHisException="900017";
	/**
	 * 900018添加播放记录异常
	 */
	public static String addAppUserPlayHisException="900018";
	/**
	 * 900019用户搜索列表异常
	 */
	public static String AppUserSearchHisException="900019";
	/**
	 * 900020记录搜索历史异常
	 */
	public static String addAppUserSearchHisException="900020";
	/**
	 * 900021删除用户搜索记录异常
	 */
	public static String delAppUserSearchHisException="900021";
	/**
	 * 900022获取banner异常
	 */
	public static String getBannerException="900022";
	/**
	 * 900023上传文件异常
	 */
	public static String addFileException="900023";
	/**
	 * 900024转账异常
	 */
	public static String appUserTransferException="900024";
	/**
	 * 900025获取影片类型异常
	 */
	public static String appVideoTypeException="900025";
	/**
	 * 900026获取视频列表异常
	 */
	public static String appVideoInfoListException="900026";
	/**
	 * 900027获取播放地址异常
	 */
	public static String appVideoInfoUrlException="900027";
    /**
     * 900028添加消息记录异常
     */
	public static String appUserChatHisAddException="900028";
    /**
     * 900029用户消费列表异常
     */
	public static String appUserBalanceHisListException="900029";
	/**
	 * 900030获取vip价格列表异常
	 */
	public static String appVipPriceListException="900030";
	/**
	 * 900031购买vip异常
	 */
	public static String appUserBuyVipException="900031";
	/**
	 * 900032用户更新异常
	 */
	public static String appUserUpdateException="900032";
	/**
	 * 900033获取用户收藏列表异常
	 */
	public static String appUserCollectListException="900033";
	/**
	 * 900034用户反馈添加异常
	 */
	public static String appUserFeedBackAddException="900034";
	/**
	 * 900035取消关注异常
	 */
	public static String appUserCollectDelException="900035";
	/**
	 * 900036用户密码更新异常
	 */
	public static String appUserPassUpdateException="900036";
	/**
	 * 900037用户状态更新异常
	 */
	public static String appUserStatusUpdateException="900037";
	/**
	 * 900038获取用户状态异常
	 */
	public static String appUserStatusGetException="900038";
	/**
	 * 900039消息回调异常
	 */
	public static String imCallBackException="900039";
	/**
	 * 900040模块添加异常
	 */
	public static String appModuleAddException="900040";
	/**
	 * 900041用户注销异常
	 */
	public static String appLogoutException="900041";
	/**
	 * 900042获取广告信息异常
	 */
	public static String appAdvertInfoByTypeException="900042";
	/**
	 * 900043模块更新异常
	 */
	public static String appModuleUpdateException="900043";
	/**
	 * 900044广告模块类型添加异常
	 */
	public static String appAdvertTypeAddException="900044";
	/**
	 * 900045广告类型更新异常
	 */
	public static String appAdvertTypeUpdateException="900045";
	/**
	 * 900046验证码发送异常
	 */
	public static String getVerifyCodeException="900046";
	/**
	 * 900047检查验证码异常
	 */
	public static String checkVerifyCodeException="900047";
	/**
	 * 900048删除浏览记录异常
	 */
	public static String delPlayHisException="900048";
	/**
	 * 900049订阅异常
	 */
	public static String imSubException="900049";
	/**
	 * 900050取消订阅异常
	 */
	public static String imUnSubException="900050";
	/**
	 * 900051消费详情获取异常
	 */
	public static String userBalanceHisGetException="900051";
	/**
	 * 900052影片评论异常
	 */
	public static String appVideoCommentListException="900052";
	/**
	 * 900053影片评论添加异常
	 */
	public static String appVideoCommentAddException="900053";
	/**
	 * 900054获取代理信息异常
	 */
	public static String getAgentInfoException="900054";
	/**
	 * 900055更新广告有效点击次数异常
	 */
	public static String advertClickTimeUpdateException="900055";
	/**
	 * 900056卡密激活异常请联系管理员
	 */
	public static String cardCodeActiveException="900056";
	/**
	 * 900057代理在线状态更新异常
	 */
	public static String agentOnlineStateException="900057";
	/**
	 * 900058获取推广收益信息异常
	 */
	public static String getPromotionInfoException="900058";
	/**
	 * 900059申请提现异常
	 */
	public static String reqCashException="900059";
	/**
	 * 900060获取站内信列表失败
	 */
	public static String siteMailListException="900060";
	/**
	 * 900061站内信读取状态更新异常
	 */
	public static String siteMailStateException="900061";
	/**
	 * 900062获取站内信未读数异常
	 */
	public static String siteMailNoReadException="900062";
	/**
	 * 900063推广界面信息获取异常
	 */
	public static String promotionUIInfoException="900063";
	/**
	 * 900064我的界面图片文字获取异常
	 */
	public static String myUIInfoException="900064";
	/**
	 * 900065添加站内信异常
	 */
	public static String siteMailAddException="900065";
	/**
	 * 900066系统参数更新异常
	 */
	public static String sysparamUpdateException="900066";
	/**
	 * 900067获取游客观影次数异常
	 */
	public static String guestUserViewCountGetException="900067";
	/**
	 * 900068搜索异常
	 */
	public static String appSearchException="900068";
	/**
	 * 900069转向用户更新界面异常
	 */
	public static String webToAppUserUpdateException="900069";
	/**
	 * 900070用户金额更新异常
	 */
	public static String webUserBalanceUpdatException="900070";
	/**
	 * 900071系统参数获取异常
	 */
	public static String appSysConfigGetException="900071";
	/**
	 * 900072提现审核处理异常
	 */
	public static String webAppUserCashReviewException="900072";
	/**
	 * 900073载入影片类型添加界面异常
	 */
	public static String webToVideoTypeAddPageException="900073";
	/**
	 * 900074影片类型添加异常
	 */
	public static String webVideoTypeAddException="900074";
	/**
	 * 900075影片类型更新异常
	 */
	public static String webVideoTypeUpdateException="900075";
	/**
	 * 900076影星类型添加异常
	 */
	public static String webHumanTypeAddException="900076";
	/**
	 * 900077影星类型更新异常
	 */
	public static String webHumanTypeUpdateException="900077";
	/**
	 * 900078载入影星类型添加界面异常
	 */
	public static String webToHumanTypeAddPageException="900078";
	/**
	 * 900079载入影星更新界面异常
	 */
	public static String webToHumanTypeUpdatePageException="900079";
	/**
	 * 900080载入影片类型更新界面异常
	 */
	public static String webToVideoTypeUpdatePageException="900080";
	/**
	 * 900081影星添加异常
	 */
	public static String webHumanAddException="900081";
	/**
	 * 900082载入影星添加界面异常
	 */
	public static String webToHumanAddPageException="900082";
	/**
	 * 900083载入影片添加界面异常
	 */
	public static String webToVideoAddPageException="900083";
	/**
	 * 900084影片添加异常
	 */
	public static String webVideoAddException="900084";
	/**
	 * 900085载入影片修改界面异常
	 */
	public static String webToVideoUpdatePageException="900085";
	/**
	 * 900086影片更新异常
	 */
	public static String webVideoUpdateException="900086";
	/**
	 * 900087载入影片影星绑定界面异常
	 */
	public static String webToHumanVideoInfoBindPageException="900087";
	/**
	 * 900088影片影星绑定异常
	 */
	public static String webHumanVideoInfoBindException="900088";
	/**
	 * 900089影片播放地址绑定异常
	 */
	public static String webVideoStoreUrlBindException="900089";
	/**
	 * 900090删除影片评论异常
	 */
	public static String webVideoCommentDelException="900090";
	/**
	 * 900091载入vip价格添加界面异常
	 */
	public static String webToVipPriceAddPageException="900091";
	/**
	 * 900092载入vip价格更新界面异常
	 */
	public static String webToVipPriceUpdatePageException="900092";
	/**
	 * 900093vip添加添加异常
	 */
	public static String webVipPriceAddException="900093";
	/**
	 * 900094vip更新异常
	 */
	public static String webVipPriceUpdateException="900094";
	/**
	 * 900095载入文件上传界面异常
	 */
	public static String webToFileListAddPageException="900095";
	/**
	 * 900096文件删除异常
	 */
	public static String webFileListDelException="900096";
	/**
	 * 900097载入公告更新界面异常
	 */
	public static String webToNoticeUpdatePageException="900097";
	/**
	 * 900098公告更新异常
	 */
	public static String webNoticeUpdateException="900098";
	/**
	 * 900099载入站内信添加界面异常
	 */
	public static String webToSiteMailAddPageException="900099";
	/**
	 * 900100站内信更新异常
	 */
	public static String webSiteMailUpdateException="900100";
	/**
	 * 900101载入站内信发布界面失败
	 */
	public static String webToSiteMailPublishPageException="900101";
	/**
	 * 900102站内信发布异常
	 */
	public static String webSiteMailPublishException="900102";
	/**
	 * 900103载入影星更新界面异常
	 */
	public static String webToHumanUpdatePageException="900103";
	/**
	 * 900104载入站内信更新界面异常
	 */
	public static String webToSiteMailUpdatePageException="900104";
	/**
	 * 900105载入提现审核界面异常
	 */
	public static String webToUserCashReviewPageException="900105";
	/**
	 * 900106载入影片地址绑定界面异常
	 */
	public static String webToVideoStoreUrlBindPageException="900106";
	/**
	 * 900107载入卡密添加界面异常
	 */
	public static String webToCardCodeAddPageException="900107";
	/**
	 * 900108载入版本添加界面异常
	 */
	public static String webToVersionAddPageException="900108";
	/**
	 * 900109版本添加异常
	 */
	public static String webVersionAddException="900109";
	/**
	 * 900110版本更新异常
	 */
	public static String webVersionUpdateException="900110";
	/**
	 * 900111删除播放记录异常
	 */
	public static String webUserPlayHisDelException="900111";
	/**
	 * 900112删除搜索记录异常
	 */
	public static String webUserSearchHisDelException="900112";
	/**
	 * 900113删除用户购买记录异常
	 */
	public static String webUserBuyDelException="900113";
	/**
	 * 900114载入模块类型更新界面失败
	 */
	public static String webToModuleTypeUpdateException="900114";
	/**
	 * 900115模块类型更新异常
	 */
	public static String webModuleTypeUpdateException="900115";
	/**
	 * 900116载入广告类型更新界面异常
	 */
	public static String webToAdvertTypeUpdatePageException="900116";
	/**
	 * 900117载入广告添加界面异常
	 */
	public static String webToAdvertAddPageException="900117";
	/**
	 * 900118添加广告异常
	 */
	public static String webAdvertAddException="900118";
	/**
	 * 900119更新广告数据异常
	 */
	public static String webAdvertUpdateException="900119";
	/**
	 * 900120载入广告更新界面异常
	 */
	public static String webToAdvertUpdatePageException="900120";
	/**
	 * 900121载入banner类型添加界面异常
	 */
	public static String webToBannerTypeAddPageException="900121";
	/**
	 * 900122载入banner类型更新界面异常
	 */
	public static String webToBannerTypeUpdatePageException="900122";
	/**
	 * 900123banner类型添加异常
	 */
	public static String webBannerTypeAddException="900123";
	/**
	 * 900124banner类型更新异常
	 */
	public static String webBannerTypeUpdateException="900124";
	/**
	 * 900125载入banner添加界面异常
	 */
	public static String webToBannerAddPageException="900125";
	/**
	 * 900126载入banner更新界面异常
	 */
	public static String webToBannerUpdatePageException="900126";
	/**
	 * 900127banner添加异常
	 */
	public static String webBannerAddException="900127";
	/**
	 * 900128banner更新异常
	 */
	public static String webBannerUpdateException="900128";
	/**
	 * 900129载入系统参数添加界面异常
	 */
	public static String webToSysParamAddPageException="900129";
	/**
	 * 900130载入系统参数更新界面异常
	 */
	public static String webToSysParamUpdatePageException="900130";
	/**
	 * 900131系统参数添加异常
	 */
	public static String webSysParamAddException="900131";
	/**
	 * 900132系统参数更新异常
	 */
	public static String webSysParamUpdateException="900132";
	/**
	 * 900133载入服务器添加界面异常
	 */
	public static String webToServerAddPageException="900133";
	/**
	 * 900134载入服务器修改界面异常
	 */
	public static String webToServerUpdatePageException="900134";
	/**
	 * 900135服务器添加异常
	 */
	public static String webServerAddException="900135";
	/**
	 * 900136服务器更新异常
	 */
	public static String webServerUpdateException="900136";
	/**
	 * 900137载入用户密码重置界面异常
	 */
	public static String webToUserPassResetPageException="900137";
	/**
	 * 900138客户端密码重置异常
	 */
	public static String webUserPassResetException="900138";
	/**
	 * 900139服务端用户密码重置异常
	 */
	public static String webServerUserPassResetException="900139";
	/**
	 * 900140载入模块修改界面异常
	 */
	public static String webToModuleUpdatePageException="900140";
	/**
	 * 900141模块删除异常
	 */
	public static String webModuleDelException="900141";
	/**
	 * 900142载入缓存清理界面异常
	 */
	public static String webToCacheCleanPageException="900142";
	/**
	 * 900143缓存清理异常
	 */
	public static String webCacheCleanException="900143";
	/**
	 * 900144载入web权限添加界面异常
	 */
	public static String webToWebPermissionAddPageException="900144";
	/**
	 * 900145web权限添加异常
	 */
	public static String webWebPermissionAddException="900145";
	/**
	 * 900146载入web权限添加界面异常
	 */
	public static String webToWebPermissionUpdatePageException="900146";
	/**
	 * 900147web权限添加异常
	 */
	public static String webWebPermissionUpdateException="900147";
	/**
	 * 900148载入web角色添加界面异常
	 */
	public static String webToWebRoleAddPageException="900148";
	/**
	 * 900149web角色添加异常
	 */
	public static String webWebRoleAddException="900149";
	/**
	 * 900150载入web角色添加界面异常
	 */
	public static String webToWebRoleUpdatePageException="900150";
	/**
	 * 900151web角色添加异常
	 */
	public static String webWebRoleUpdateException="900151";
	/**
	 * 900152web角色权限绑定异常
	 */
	public static String webWebRolePermissionBindException="900152";
	/**
	 * 900153载入web角色权限绑定界面异常
	 */
	public static String webToWebRolePermissionBindPageException="900153";
	/**
	 * 900154载入web用户更新界面异常
	 */
	public static String webToWebUserUpdatePageException="900154";
	/**
	 * 900155web用户更新异常
	 */
	public static String webWebUserUpdateException="900155";
	/**
	 * 900156载入app权限添加界面异常
	 */
	public static String webToAppPermissionAddPageException="900156";
	/**
	 * 900157app权限添加异常
	 */
	public static String webAppPermissionAddException="900157";
	/**
	 * 900158载入app权限添加界面异常
	 */
	public static String webToAppPermissionUpdatePageException="900158";
	/**
	 * 900159app权限添加异常
	 */
	public static String webAppPermissionUpdateException="900159";
	/**
	 * 900160载入app角色添加界面异常
	 */
	public static String webToAppRoleAddPageException="900160";
	/**
	 * 900161app角色添加异常
	 */
	public static String webAppRoleAddException="900161";
	/**
	 * 900162载入app角色添加界面异常
	 */
	public static String webToAppRoleUpdatePageException="900162";
	/**
	 * 900163app角色添加异常
	 */
	public static String webAppRoleUpdateException="900163";
	/**
	 * 900164载入app角色权限绑定界面异常
	 */
	public static String webToAppRolePermissionBindPageException="900164";
	/**
	 * 900165绑定app角色权限异常
	 */
	public static String webAppRolePermissionBindException="900165";
	/**
	 * 900166删除广告信息异常
	 */
	public static String webDelAdvertException="900166";
	/**
	 * 900167删除banner信息异常
	 */
	public static String webDelAppBannerException="900167";
	/**
	 * 900168删除代理商聊天记录异常
	 */
	public static String webDelAppUserChatHisException="900168";
	/**
	 * 900169获取用户余额报表异常
	 */
	public static String webGetBalanceReportException="900169";
}
