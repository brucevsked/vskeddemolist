package com.vsked.common;

public class RespMsg {
	/**
	 * 统一状态码 000000 处理成功
	 */
	public static String commonSucc="处理成功";
	
	/**
	 * 统一状态码 999999 处理失败
	 */
	public static String commonFail="处理失败";
	
	/**
	 * 100000: 动态秘钥签发成功----issued tokenKey success
	 */
	public static String authKeySucc="动态秘钥签发成功";
	/**
	 * 100001：动态秘钥签发失败----issued tokenKey fail
	 */
	public static String authKeyFail="动态秘钥签发失败";
	/**
	 * 100002：用户密码认证失败----login fail
	 */
	public static String authPassFail="用户密码认证失败";
	/**
	 * 100003: 用户密码认证成功,JWT 签发成功,返回jwt-----issued jwt success
	 */
	public static String authJwtSucc="用户密码认证成功";
	/**
	 * 100004：JWT 签发失败----issued jwt fail
	 */
	public static String authJwtFail="JWT 签发失败";
	/**
	 * 100005: jwt_real_token过期,jwt_refresh_token还未过期,服务器返回新的jwt,客户端需携带新返回的jwt对这次请求重新发起----new jwt  
	 */
	public static String authJwtNew="JWT 刷新成功";
	/**
	 * 100006: jwt_real_token过期,jwt_refresh_token过期(通知客户端重新登录)-----expired jwt
	 */
	public static String authJwtExpire="JWT 过期";
	/**
	 * 100007: jwt_token认证失败无效(包括用户认证失败或者jwt令牌错误无效或者用户未登录)----error jwt
	 */
	public static String authJwtError="jwt_token认证失败无效";
	/**
	 * 100008: jwt token无权限访问此资源----no permission
	 */
	public static String authJwtNoPermission="jwt token无权限访问此资源";
	/**
	 * 100009 缺少参数用户名
	 */
	public static String noPhone="缺少用户名参数";
	/**
	 * 100010 缺少参数用户密码
	 */
	public static String noUserPass="缺少用户密码参数";
	/**
	 * 100011 用户不存在
	 */
	public static String userNotExist="用户名不存在";
	
	/**
	 * 100012 手机号已注册
	 */
	public static String phoneHasExist="手机号已注册";
	/**
	 * 100013 注册成功
	 */
	public static String phoneRegSuccess="注册成功";
	/**
	 * 100014 注册失败
	 */
	public static String phoneRegFail="注册失败";
	
	/**
	 * 100015 缺少用户名参数
	 */
	public static String noUserName="缺少用户名参数";
	
	/**
	 * 000000 注销成功
	 */
	public static String logoutOk="注销成功";
	
	/**
	 * 000000 添加用户成功 
	 */
	public static String addWebUserOk="添加用户成功";
	
	/**
	 * 100016 添加用户失败
	 */
	public static String addWebUserFail="添加用户失败";
	
	/**
	 * 100017 缺少参数主页分类名称
	 */
	public static String noModuleTypeName="缺少参数主页分类名称";
	/**
	 * 100018 主页分类添加失败
	 */
	public static String moduleTypeAddFail="主页分类添加失败";
	
	/**
	 * 100019 获取当前用户编号失败
	 */
	public static String getCurrentUidFail="获取当前用户编号失败";
	/**
	 * 100020 请填写公告标题
	 */
	public static String noNoticeTitle="请填写公告标题";
	/**
	 * 100021 请填写公告内容
	 */
	public static String noNoticeContent="请填写公告内容";
	
	/**
	 * 100022 影星编号未传入
	 */
	public static String noHumanInfoId="影星编号未传入";
	/**
	 * 100023 缺少设备类型参数
	 */
	public static String noDeviceType="缺少设备类型参数";
	/**
	 * 100024获取视频编号失败
	 */
	public static String getAppVideoIdFail="获取视频编号失败";
	/**
	 * 100025添加播放记录失败
	 */
	public static String addAppUserPlayHisFail="添加播放记录失败";
	/**
	 * 100026记录搜索历史失败
	 */
	public static String addAppUserSearchHisFail="记录搜索历史失败";
	/**
	 * 100027缺少搜索内容参数
	 */
	public static String noAppUserSearchHisContent="缺少搜索内容参数";
	/**
	 * 100028缺少用户搜索记录编号
	 */
	public static String noAppUserSearchHisId="缺少用户搜索记录编号";
	/**
	 * 100029删除用户搜索记录失败
	 */
	public static String delAppUserSearchHisFail="删除用户搜索记录失败";
	/**
	 * 100030缺少参数banner类型
	 */
	public static String noBannerType="缺少参数banner类型";
	/**
	 * 100031上传文件失败
	 */
	public static String addFileFail="上传文件失败";
	/**
	 * 100032 获取转账目标用户失败
	 */
	public static String touidFail="获取转账目标用户失败";
	/**
	 * 100033获取转账金额失败
	 */
	public static String getAmountFail="获取转账金额失败";
	/**
	 * 100034代理商余额不足
	 */
	public static String agentBalanceNotEnough="代理商余额不足";
	/**
	 * 100035代理商状态不正常
	 */
	public static String agentStateFail="代理商状态不正常";
	/**
	 * 100036代理金额更新失败
	 */
	public static String agentBalanceUpdateFail="代理金额更新失败";
	/**
	 * 100037用户金额更新失败
	 */
	public static String appUserBalanceUpdateFail="用户金额更新失败";
	/**
	 * 100038记录余额历史失败
	 */
	public static String appUserBalanceHisFail="记录余额历史失败";
	/**
	 * 100039缺少参数视频编号
	 */
	public static String appVideoInfoIdNotExist="缺少参数视频编号";
	/**
	 * 100040 视频资源不存在
	 */
	public static String appVideoInfoNotExist="视频资源不存在";
	/**
	 * 100041用户余额不足
	 */
	public static String appUserBalanceNotEnough="用户余额不足";
	/**
	 * 100042用户状态非法
	 */
	public static String appUserStateError="用户状态非法";
	/**
	 * 100043无发送用户编号
	 */
	public static String appUserChatHisNoFrom="无发送用户编号";
	/**
	 * 100044无目标用户编号
	 */
	public static String appUserChatHisNoTarget="无目标用户编号";
	/**
	 * 100045无聊天内容
	 */
	public static String appUserChatHisNoContent="无聊天内容";
	/**
	 * 100046添加聊天记录失败
	 */
	public static String appUserChatHisAddFail="添加聊天记录失败";
	/**
	 * 100047缺少vip购买等级编号
	 */
	public static String noAppUserVipPriceId="缺少vip购买等级编号";
	/**
	 * 100048购买vip失败
	 */
	public static String appUserVipBuyFail="购买vip失败";
	/**
	 * 100049更新用户信息失败
	 */
	public static String appUseUpdateFail="更新用户信息失败";
	/**
	 * 100050缺少关注类型参数
	 */
	public static String noAppUserCollectType="缺少关注类型参数";
	/**
	 * 100051缺少关注id参数
	 */
	public static String noAppUserCollectId="缺少关注id参数";
	/**
	 * 100052添加用户关注失败
	 */
	public static String appUserCollectAddFail="添加用户关注失败";
	/**
	 * 100053取消关注失败
	 */
	public static String appUserCollectDelFail="取消关注失败";
	/**
	 * 100054反馈内容不能为空
	 */
	public static String noAppUserFeedBackContent="反馈内容不能为空";
	/**
	 * 100055添加用户反馈失败
	 */
	public static String appUserFeedBackAddFail="添加用户反馈失败";
	/**
	 * 100056无法获取设备唯一标识
	 */
	public static String noDeviceIdentify="无法获取设备唯一标识";
	/**
	 * 100057无明星信息
	 */
	public static String noHumanInfo="无明星信息";
	/**
	 * 100058用户密码更新失败
	 */
	public static String appUserPassUpdateFail="用户密码更新失败";
	/**
	 * 100059用户状态更新失败
	 */
	public static String appUserStatusUpdateFail="用户状态更新失败";
	/**
	 * 100060获取修改用户编号失败
	 */
	public static String appUserStatusGetUidFail="获取修改用户编号失败";
	/**
	 * 100061 模块添加失败
	 */
	public static String moduleAddFail="模块添加失败";
	/**
	 * 100062金额必须大于0
	 */
	public static String priceMustMoreZero="金额必须大于0";
	/**
	 * 100063缺少广告类型参数
	 */
	public static String noAdvertType1="缺少广告类型参数";
	/**
	 * 100064 模块更新失败
	 */
	public static String moduleUpdateFail="模块更新失败";
	/**
	 * 100065 缺少参数广告类型名称
	 */
	public static String noAdvertTypeName="缺少参数广告类型名称";
	/**
	 * 100066 广告类型添加失败
	 */
	public static String advertTypeAddFail="广告类型添加失败";
	/**
	 * 100067 广告类型更新失败
	 */
	public static String appAdvertTypeUpdateFail=" 广告类型更新失败";
	/**
	 * 100068验证码检测失败
	 */
	public static String checkVerifyCodeFail="验证码检测失败";
	/**
	 * 100069缺少验证码参数
	 */
	public static String noVerifyCode="缺少验证码参数";
	/**
	 * 100070缺少旧密码
	 */
	public static String noOldPassword="缺少旧密码";
	/**
	 * 100071缺少新密码
	 */
	public static String noNewPassword="缺少新密码";
	/**
	 * 100072旧密码输入错误
	 */
	public static String oldPasswordWrong="旧密码输入错误";
	/**
	 * 100073缺少浏览记录编号
	 */
	public static String noPlayHisId="缺少浏览记录编号";
	/**
	 * 100074删除浏览记录失败
	 */
	public static String delPlayHisFail="删除浏览记录失败";
	/**
	 * 100075缺少参数消费订单编号
	 */
	public static String noUserBalanceHisOrderId="缺少参数消费订单编号";
	/**
	 * 100076获取评论内容失败
	 */
	public static String getVideoCommentContentFail="获取评论内容失败";
	/**
	 * 100077添加评论失败
	 */
	public static String appVideoCommentAddFail="添加评论失败";
	/**
	 * 100078未传入广告编号
	 */
	public static String noAdvertInfoId="未传入广告编号";
	/**
	 * 100079更新有效点击次数失败
	 */
	public static String advertClickTimeUpdateFail="更新有效点击次数失败";
	/**
	 * 100080缺少卡密参数
	 */
	public static String noCardCodeParam="缺少卡密参数";
	/**
	 * 100081卡密信息不存在
	 */
	public static String noCardCodeInfo="卡密信息不存在";
	/**
	 * 100082卡密已过期
	 */
	public static String cardCodeExpire="卡密已过期";
	/**
	 * 100083卡密激活失败
	 */
	public static String cardCodeActiveFail="卡密激活失败";
	/**
	 * 100084获取提现金额失败
	 */
	public static String getCashAmountFail="获取提现金额失败";
	/**
	 * 100085低于最小提现金额
	 */
	public static String lessCashAmountFail="低于最小提现金额";
	/**
	 * 100086高于晨大提现金额
	 */
	public static String moreCashAmountFail="高于晨大提现金额";
	/**
	 * 100087获取提现类型失败
	 */
	public static String getCashTypeFail="获取提现类型失败";
	/**
	 * 100088获取提现账号失败
	 */
	public static String getCashAccountFail="获取提现账号失败";
	/**
	 * 100089可提现余额不足
	 */
	public static String balanceCashFail="可提现余额不足";
	/**
	 * 100090提现申请失败
	 */
	public static String reqCashFail="提现申请失败";
	/**
	 * 100091缺少站内信编号
	 */
	public static String noUserSiteMailId="缺少站内信编号";
	/**
	 * 100092更新站内信阅读状态失败
	 */
	public static String userSiteMailStateUpdateFail="更新站内信阅读状态失败";
	/**
	 * 100093 请填写站内信标题
	 */
	public static String noSiteMailTitle=" 请填写站内信标题";
	/**
	 * 100094 请填写站内信内容
	 */
	public static String noSiteMailContent=" 请填写站内信内容";
	/**
	 * 100095无系统参数编号
	 */
	public static String noSysParamId="无系统参数编号";
	/**
	 * 100095无系统参数名称
	 */
	public static String noSysParamName="无系统参数名称";
	/**
	 * 100097无系统参数值
	 */
	public static String noSysParamValue="无系统参数值";
	/**
	 * 100098有提现申请未处理不能再次发起提现
	 */
	public static String existUserCashReq="有提现申请未处理不能再次发起提现";
	
	
	/**
	 * 100099获取修改用户编号失败
	 */
    public static String webNoFixUid="获取修改用户编号失败";
    /**
     * 100100用户金额更新失败
     */
    public static String webAppUserBalanceFail="用户金额更新失败";
    /**
     * 100101获取唯一标识失败
     */
    public static String webGetIdFail="获取唯一标识失败";
    /**
     * 100102未找到需要处理数据
     */
    public static String webNoProcData="未找到需要处理数据";
    /**
     * 100103缺少提现处理结果状态
     */
    public static String webUserCashReviewNoState="缺少提现处理结果状态";
    /**
     * 100104验证失败,提现金额与冻结金额不一致
     */
    public static String webUserCashFreezeCheckFail="验证失败,提现金额与冻结金额不一致";
    /**
     * 100105我方打款账号不能为空
     */
    public static String webUserCashOpAccountEmpty="我方打款账号不能为空";
    /**
     * 100106视频类型名称不能为空
     */
    public static String webVideoTypeNameEmpty="视频类型名称不能为空";
    /**
     * 100107视频描述不能为空
     */
    public static String webVideoTypDescriptionEmpty="视频描述不能为空";
    /**
     * 100108视频类型等级不能为空
     */
    public static String webVideoTypeLevelEmpty="视频类型等级不能为空";
    /**
     * 100109上级视频类型编号不能为空
     */
    public static String webVideoTypeParentIdEmpty="上级视频类型编号不能为空";
    /**
     * 100110视频类型已存在不能重复添加
     */
    public static String webVideoTypeNameExists="视频类型已存在不能重复添加";
    /**
     * 100111邀请码已存在
     */
    public static String webMyInvitationCodeExists="邀请码已存在";
    /**
     * 100112邀请码参数不能为空
     */
    public static String webMyInvitationCodeEmpty="邀请码参数不能为空";
    /**
     * 100113影星类型名称不能为空
     */
    public static String webHumanTypeNameEmpty="影星类型名称不能为空";
    /**
     * 100114影星描述不能为空
     */
    public static String webHumanTypDescriptionEmpty="影星描述不能为空";
    /**
     * 100115影星类型等级不能为空
     */
    public static String webHumanTypeLevelEmpty="影星类型等级不能为空";
    /**
     * 100116上级影星类型编号不能为空
     */
    public static String webHumanTypeParentIdEmpty="上级影星类型编号不能为空";
    /**
     * 100117影星类型已存在不能重复添加
     */
    public static String webHumanTypeNameExists="影星类型已存在不能重复添加";
    /**
     * 100118影星姓名不能为空
     */
    public static String webHumanNameEmpty="影星姓名不能为空";
    /**
     * 100119影星描述不能为空
     */
    public static String webHumanDescriptionEmpty="影星描述不能为空";
    /**
     * 100120影星图片不能为空
     */
    public static String webHumanPicEmpty="影星图片不能为空";
    /**
     * 100121影片1级分类不能为空
     */
    public static String webVideoType1Empty="影片1级分类不能为空";
    /**
     * 100122影片2级分类不能为空
     */
    public static String webVideoType2Empty="影片2级分类不能为空";
    /**
     * 100123影片名称不能为空
     */
    public static String webVideoNameEmpty="影片名称不能为空";
    /**
     * 100124影片描述不能为空
     */
    public static String webVideoDescriptionEmpty="影片描述不能为空";
    /**
     * 100125影片价格不能为空
     */
    public static String webVideoPriceEmpty="影片价格不能为空";
    /**
     * 100126影片封面图片地址不能为空
     */
    public static String webVideoCoverUrlsEmpty="影片封面图片地址不能为空";
    /**
     * 100127影片是否收费不能为空
     */
    public static String webVideoIsPriceEmpty="影片是否收费不能为空";
    /**
     * 100128影片是否热播不能为空
     */
    public static String webVideoIsHotEmpty="影片是否热播不能为空";
    /**
     * 100129影片是否推荐不能为空
     */
    public static String webVideoIsCommendEmpty="影片是否推荐不能为空";
    /**
     * 100130vip名称不能为空
     */
    public static String webVipPriceNameEmpty="vip名称不能为空";
    /**
     * 100131vip等级不能为空
     */
    public static String webVipPriceLevelEmpty="vip等级不能为空";
    /**
     * 100132vip天数不能为空
     */
    public static String webVipPriceDaysEmpty="vip天数不能为空";
    /**
     * 100133vip价格不能为空
     */
    public static String webVipPricePriceEmpty="3vip价格不能为空";
    /**
     * 100134vip名称已存在不能重复添加
     */
    public static String webVipPriceNameExists="vip名称已存在不能重复添加";
    /**
     * 100135缺少上传文件类型参数
     */
    public static String appFileUploadTypeEmpty="缺少上传文件类型参数";
    /**
     * 100136卡密绑定vip卡编号为空
     */
    public static String webCardCodeVipPriceIdEmpty="卡密绑定vip卡编号为空";
    /**
     * 100137初始化数量为空
     */
    public static String webCardCodeCountEmpty="初始化数量为空";
    /**
     * 100138卡密过期时间为空
     */
    public static String webCardCodeExpireEmpty="卡密过期时间为空";
    /**
     * 100139版本名称不能为空
     */
    public static String webVersionNameEmpty="版本名称不能为空";
    /**
     * 100140版本代码不能为空
     */
    public static String webVersionCodeEmpty="版本代码不能为空";
    /**
     * 100141版本更新内容不能为空
     */
    public static String webVersionUpContentEmpty="版本更新内容不能为空";
    /**
     * 100142版本号不能为空
     */
    public static String webVersionEmpty="版本号不能为空";
    /**
     * 100143版本唯一标识不能为空
     */
    public static String webVersionIdentifyEmpty="版本唯一标识不能为空";
    /**
     * 100144服务端版本不能为空
     */
    public static String webServerVersionEmpty="服务端版本不能为空";
    /**
     * 100145更新地址不能为空
     */
    public static String webUpdateUrlEmpty="更新地址不能为空";
    /**
     * 100146模块类型名称不能为空
     */
    public static String webModuleTypeNameEmpty="模块类型名称不能为空";
    /**
     * 100147模块类型描述不能为空
     */
    public static String webModuleTypeDescriptionEmpty="模块类型描述不能为空";
    /**
     * 100148模块类型序列不能为空
     */
    public static String webModuleTypeSeqEmpty="模块类型序列不能为空";
    /**
     * 100149模块类型状态不能为空
     */
    public static String webModuleTypeStateEmpty="模块类型状态不能为空";
	/**
	 * 100150 缺少参数广告类型描述
	 */
	public static String noAdvertTypeDescription="缺少参数广告类型描述";
	/**
	 * 100151缺少广告名称
	 */
	public static String noAdvertName="缺少广告名称";
	/**
	 * 100152缺少广告目标类型
	 */
	public static String noAdvertTargetType="缺少广告目标类型";
	/**
	 * 100153缺少广告目标链接
	 */
	public static String noAdvertTarget="缺少广告目标链接";
	/**
	 * 100154缺少广告序列
	 */
	public static String noAdvertSeq="缺少广告序列";
	/**
	 * 100155缺少广告图片
	 */
	public static String noAdvertStoreUrl="缺少广告图片";
	/**
	 * 100156缺少banner类型名称
	 */
	public static String noBannerTypeName="缺少banner类型名称";
	/**
	 * 100157缺少banner类型描述
	 */
	public static String noBannerTypeDescription="缺少banner类型描述";
	/**
	 * 100158缺少banner类型
	 */
	public static String webNoBannerType="缺少banner类型";
	/**
	 * 100159缺少banner名称
	 */
	public static String webNoBannerName="缺少banner名称";
	/**
	 * 100160缺少banner描述
	 */
	public static String webNoBannerDescription="缺少banner描述";
	/**
	 * 100161缺少banner序列
	 */
	public static String webNoBannerSeq="缺少banner序列";
	/**
	 * 100162缺少banner目标类型
	 */
	public static String webNoBannerTargetType="缺少banner目标类型";
	/**
	 * 100163缺少banner目标地址
	 */
	public static String webNoBannerTarget="缺少banner目标地址";
	/**
	 * 100164缺少banner加载地址
	 */
	public static String webNoBannerUrl="缺少banner加载地址";
	/**
	 * 100165缺少系统参数类型
	 */
	public static String webNoSysParamType="缺少系统参数类型";
	/**
	 * 100166缺少系统参数编码
	 */
	public static String webNoSysParamCode="缺少系统参数编码";
	/**
	 * 100167缺少参数服务器组
	 */
	public static String webNoServerGroup="缺少参数服务器组";
	/**
	 * 100168缺少参数服务器IP
	 */
	public static String webNoServerIp="缺少参数服务器IP";
	/**
	 * 100169缺少参数服务器域名
	 */
	public static String webNoServerDomain="缺少参数服务器域名";
	/**
	 * 100170缺少参数服务器名称
	 */
	public static String webNoServerName="缺少参数服务器名称";
	/**
	 * 100171缺少参数服务器运营商
	 */
	public static String webNoServerIsp="缺少参数服务器运营商";
	/**
	 * 100172缺少参数服务器地区码
	 */
	public static String webNoServerAreaCode="缺少参数服务器地区码";
	/**
	 * 100173缺少参数服务器状态
	 */
	public static String webNoServerState="缺少参数服务器状态";
	/**
	 * 100174缺少参数用户角色
	 */
	public static String webNoUserRole="缺少参数用户角色";
	/**
	 * 100175缺少参数模块类型
	 */
	public static String webNoModuleType="缺少参数模块类型";
	/**
	 * 100176缺少参数模块名称
	 */
	public static String webNoModuleName="缺少参数模块名称";
	/**
	 * 100177缺少参数模块编码
	 */
	public static String webNoModuleCode="缺少参数模块编码";
	/**
	 * 100178缺少参数模块样式
	 */
	public static String webNoModuleStyle="缺少参数模块样式";
	/**
	 * 100179缺少参数模块api
	 */
	public static String webNoModuleApi="缺少参数模块api";
	/**
	 * 100180缺少参数模块表名
	 */
	public static String webNoModuleTbName="缺少参数模块表名";
	/**
	 * 100181缺少参数模块参数名
	 */
	public static String webNoModuleTbParam="缺少参数模块参数名";
	/**
	 * 100182缺少参数模块序列
	 */
	public static String webNoModuleSeq="缺少参数模块序列";
	/**
	 * 100183缺少参数模块状态
	 */
	public static String webNoModuleState="缺少参数模块状态";
	/**
	 * 100184缺少模块头部隐藏显示状态
	 */
	public static String webNoModuleHeadViewState="缺少模块头部隐藏显示状态";
	/**
	 * 100185缺少缓存清理类型参数
	 */
	public static String webNoCacheCleanType="缺少缓存清理类型参数";
	/**
	 * 100186缺少参数web权限编码
	 */
	public static String webNoWebPermissionCode="缺少参数web权限编码";
	/**
	 * 100187缺少参数web权限名称
	 */
	public static String webNoWebPermissionName="缺少参数web权限名称";
	/**
	 * 100188缺少参数web权限uri
	 */
	public static String webNoWebPermissionUri="缺少参数web权限uri";
	/**
	 * 100189缺少参数web角色编码
	 */
	public static String webNoWebRoleCode="缺少参数web角色编码";
	/**
	 * 100190缺少参数web角色名称
	 */
	public static String webNoWebRoleName="缺少参数web角色名称";
	/**
	 * 100191缺少参数app权限编码
	 */
	public static String webNoAppPermissionCode="缺少参数app权限编码";
	/**
	 * 100192缺少参数app权限名称
	 */
	public static String webNoAppPermissionName="缺少参数app权限名称";
	/**
	 * 100193缺少参数app权限uri
	 */
	public static String webNoAppPermissionUri="缺少参数app权限uri";
	/**
	 * 100194缺少参数app角色编码
	 */
	public static String webNoAppRoleCode="缺少参数app角色编码";
	/**
	 * 100195缺少参数app角色名称
	 */
	public static String webNoAppRoleName="缺少参数app角色名称";
	/**
	 * 100196缺少参数手机号
	 */
	public static String webNoPhone="缺少参数手机号";
	/**
	 * 100197金额不能为空
	 */
	public static String webNoAmount="金额不能为空";
	//------------------------------------------------------------------exception code start-----------------------------------
	/**
	 * 900000服务器错误,请联系管理员
	 */
	public static String serverException="服务器错误,请联系管理员";
	
	/**
	 * 900001 注册服务器异常,请联系管理员
	 */
	public static String regException="注册服务器异常,请联系管理员";
	/**
	 * 900002用户登录服务器异常，请联系管理员
	 */
	public static String loginException="用户登录服务器异常，请联系管理员";
	
	/**
	 * 900003 添加用户异常
	 */
	public static String addWebUserException="添加用户异常";
	
	/**
	 * 900004 获取app用户信息异常
	 */
	public static String getAppUserInfoException="获取app用户信息异常";
	
	/**
	 * 900005 获取模块类型异常
	 */
	public static String getAppModuleTypeException="获取首页分类信息异常";
	/**
	 * 900006 主页分类添加异常
	 */
	public static String appModuleTypeAddException="主页分类添加异常";
	/**
	 * 900007 获取用户公告异常
	 */
	public static String appUserNoticeException="获取用户消息异常";
	/**
	 * 900008 添加公告异常
	 */
	public static String appNoticeAddException="添加公告异常";
	/**
	 * 900009 影星列表异常
	 */
	public static String appHumanListException="影星列表异常";
	/**
	 * 900010 影星信息异常
	 */
	public static String appHumanInfoException="影星信息异常";
	/**
	 * 900011 模块列表异常
	 */
	public static String appModuleListException="模块列表异常";
	/**
	 * 900012 广告类型异常
	 */
	public static String appAdvertTypeException="广告类型异常";
	/**
	 * 900013广告列表异常
	 */
	public static String appAdvertListException="广告列表异常";
	/**
	 * 900014 公告获取异常
	 */
	public static String appNoticeException="公告获取异常";
	/**
	 * 900015 获取版本信息异常
	 */
	public static String appVersionException="获取版本信息异常";
	/**
	 * 900016 获取用户列表异常
	 */
	public static String appUserListException="获取用户列表异常";
	/**
	 * 900017 获取播放记录异常
	 */
	public static String appUserPlayHisException="获取播放记录异常";
	/**
	 * 900018添加播放记录异常
	 */
	public static String addAppUserPlayHisException="添加播放记录异常";
	/**
	 * 900019用户搜索列表异常
	 */
	public static String AppUserSearchHisException="用户搜索列表异常";
	/**
	 * 900020记录搜索历史异常
	 */
	public static String addAppUserSearchHisException="记录搜索历史异常";
	/**
	 * 900021删除用户搜索记录异常
	 */
	public static String delAppUserSearchHisException="删除用户搜索记录异常";
	/**
	 * 900022获取banner异常
	 */
	public static String getBannerException="获取banner异常";
	/**
	 * 900023上传文件异常
	 */
	public static String addFileException="上传文件异常";
	/**
	 * 900024转账异常
	 */
	public static String appUserTransferException="转账异常";
	/**
	 * 900025获取影片类型异常
	 */
	public static String appVideoTypeException="获取影片类型异常";
	/**
	 * 900026获取视频列表异常
	 */
	public static String appVideoInfoListException="获取视频列表异常";
	/**
	 * 900027获取播放地址异常
	 */
	public static String appVideoInfoUrlException="获取播放地址异常";
    /**
     * 900028添加消息记录异常
     */
	public static String appUserChatHisAddException="添加消息记录异常";
    /**
     * 900029用户消费列表异常
     */
	public static String appUserBalanceHisListException="用户消费列表异常";
	/**
	 * 900030获取vip价格列表异常
	 */
	public static String appVipPriceListException="获取vip价格列表异常";
	/**
	 * 900032用户更新异常
	 */
	public static String appUserUpdateException="用户更新异常";
	/**
	 * 900033获取用户收藏列表异常
	 */
	public static String appUserCollectListException="获取用户收藏列表异常";
	/**
	 * 900034用户反馈添加异常
	 */
	public static String appUserFeedBackAddException="用户反馈添加异常";
	/**
	 * 900035取消关注异常
	 */
	public static String appUserCollectDelException="取消关注异常";
	/**
	 * 900036用户密码更新异常
	 */
	public static String appUserPassUpdateException="用户密码更新异常";
	/**
	 * 900037用户状态更新异常
	 */
	public static String appUserStatusUpdateException="用户状态更新异常";
	/**
	 * 900038获取用户状态异常
	 */
	public static String appUserStatusGetException="获取用户状态异常";
	/**
	 * 900039消息回调异常
	 */
	public static String imCallBackException="消息回调异常";
	/**
	 * 900040模块添加异常
	 */
	public static String appModuleAddException="模块添加异常";
	/**
	 * 900041用户注销异常
	 */
	public static String appLogoutException="用户注销异常";
	/**
	 * 900042获取广告信息异常
	 */
	public static String appAdvertInfoByTypeException="获取广告信息异常";
	/**
	 * 900043模块更新异常
	 */
	public static String appModuleUpdateException="模块更新异常";
	/**
	 * 900044广告模块类型添加异常
	 */
	public static String appAdvertTypeAddException="广告模块类型添加异常";
	/**
	 * 900045广告类型更新异常
	 */
	public static String appAdvertTypeUpdateException="广告类型更新异常";
	/**
	 * 900046验证码发送异常
	 */
	public static String getVerifyCodeException="验证码发送异常";
	/**
	 * 900047检查验证码异常
	 */
	public static String checkVerifyCodeException="检查验证码异常";
	/**
	 * 900048删除浏览记录异常
	 */
	public static String delPlayHisException="删除浏览记录异常";
	/**
	 * 900049订阅异常
	 */
	public static String imSubException="订阅异常";
	/**
	 * 900050取消订阅异常
	 */
	public static String imUnSubException="取消订阅异常";
	/**
	 * 900051消费详情获取异常
	 */
	public static String userBalanceHisGetException="消费详情获取异常";
	/**
	 * 900052影片评论异常
	 */
	public static String appVideoCommentListException="影片评论异常";
	/**
	 * 900053影片评论添加异常
	 */
	public static String appVideoCommentAddException="影片评论添加异常";
	/**
	 * 900054获取代理信息异常
	 */
	public static String getAgentInfoException="获取代理信息异常";
	/**
	 * 900055更新广告有效点击次数异常
	 */
	public static String advertClickTimeUpdateException="更新广告有效点击次数异常";
	/**
	 * 900056卡密激活异常请联系管理员
	 */
	public static String cardCodeActiveException="卡密激活异常请联系管理员";
	/**
	 * 900057代理在线状态更新异常
	 */
	public static String agentOnlineStateException="代理在线状态更新异常";
	/**
	 * 900058获取推广收益信息异常
	 */
	public static String getPromotionInfoException="获取推广收益信息异常";
	/**
	 * 900059申请提现异常
	 */
	public static String reqCashException="申请提现异常";
	/**
	 * 900060获取站内信列表失败
	 */
	public static String siteMailListException="获取站内信列表失败";
	/**
	 * 900061站内信读取状态更新异常
	 */
	public static String siteMailStateException="站内信读取状态更新异常";
	/**
	 * 900062获取站内信未读数异常
	 */
	public static String siteMailNoReadException="获取站内信未读数异常";
	/**
	 * 900063推广界面信息获取异常
	 */
	public static String promotionUIInfoException="推广界面信息获取异常";
	/**
	 * 900064我的界面图片文字获取异常
	 */
	public static String myUIInfoException="我的界面图片文字获取异常";
	/**
	 * 900065添加站内信异常
	 */
	public static String siteMailAddException="添加站内信异常";
	/**
	 * 900066系统参数更新异常
	 */
	public static String sysparamUpdateException="系统参数更新异常";
	/**
	 * 900067获取游客观影次数异常
	 */
	public static String guestUserViewCountGetException="获取游客观影次数异常";
	/**
	 * 900068搜索异常
	 */
	public static String appSearchException="搜索异常";
	/**
	 * 900069转向用户更新界面异常
	 */
	public static String webToAppUserUpdateException="转向用户更新界面异常";
	/**
	 * 900070用户金额更新异常
	 */
	public static String webUserBalanceUpdatException="用户金额更新异常";
	/**
	 * 900071系统参数获取异常
	 */
	public static String appSysConfigGetException="系统参数获取异常";
	/**
	 * 900072提现审核处理异常
	 */
	public static String webAppUserCashReviewException="提现审核处理异常";
	/**
	 * 900073载入影片类型添加界面异常
	 */
	public static String webToVideoTypeAddPageException="载入影片类型添加界面异常";
	/**
	 * 900074影片类型添加异常
	 */
	public static String webVideoTypeAddException="影片类型添加异常";
	/**
	 * 900075影片类型更新异常
	 */
	public static String webVideoTypeUpdateException="影片类型更新异常";
	/**
	 * 900076影星类型添加异常
	 */
	public static String webHumanTypeAddException="影星类型添加异常";
	/**
	 * 900077影星类型更新异常
	 */
	public static String webHumanTypeUpdateException="影星类型更新异常";
	/**
	 * 900078载入影星类型添加界面异常
	 */
	public static String webToHumanTypeAddPageException="载入影星类型添加界面异常";
	/**
	 * 900079载入影星更新界面异常
	 */
	public static String webToHumanTypeUpdatePageException="载入影星更新界面异常";
	/**
	 * 900080载入影片类型更新界面异常
	 */
	public static String webToVideoTypeUpdatePageException="载入影片类型更新界面异常";
	/**
	 * 900081影星添加异常
	 */
	public static String webHumanAddException="影星添加异常";
	/**
	 * 900082载入影星添加界面异常
	 */
	public static String webToHumanAddPageException="载入影星添加界面异常";
	/**
	 * 900083载入影片添加界面异常
	 */
	public static String webToVideoAddPageException="载入影片添加界面异常";
	/**
	 * 900084影片添加异常
	 */
	public static String webVideoAddException="影片添加异常";
	/**
	 * 900085载入影片修改界面异常
	 */
	public static String webToVideoUpdatePageException="载入影片修改界面异常";
	/**
	 * 900086影片更新异常
	 */
	public static String webVideoUpdateException="影片更新异常";
	/**
	 * 900087载入影片影星绑定界面异常
	 */
	public static String webToHumanVideoInfoBindPageException="载入影片影星绑定界面异常";
	/**
	 * 900088影片影星绑定异常
	 */
	public static String webHumanVideoInfoBindException="影片影星绑定异常";
	/**
	 * 900089影片播放地址绑定异常
	 */
	public static String webVideoStoreUrlBindException="影片播放地址绑定异常";
	/**
	 * 900090删除影片评论异常
	 */
	public static String webVideoCommentDelException="删除影片评论异常";
	/**
	 * 900091载入vip价格添加界面异常
	 */
	public static String webToVipPriceAddPageException="载入vip价格添加界面异常";
	/**
	 * 900092载入vip价格更新界面异常
	 */
	public static String webToVipPriceUpdatePageException="载入vip价格更新界面异常";
	/**
	 * 900093vip添加添加异常
	 */
	public static String webVipPriceAddException="vip添加添加异常";
	/**
	 * 900094vip更新异常
	 */
	public static String webVipPriceUpdateException="vip更新异常";
	/**
	 * 900095载入文件上传界面异常
	 */
	public static String webToFileListAddPageException="载入文件上传界面异常";
	/**
	 * 900096文件删除异常
	 */
	public static String webFileListDelException="文件删除异常";
	/**
	 * 900097载入公告更新界面异常
	 */
	public static String webToNoticeUpdatePageException="载入公告更新界面异常";
	/**
	 * 900098公告更新异常
	 */
	public static String webNoticeUpdateException="公告更新异常";
	/**
	 * 900099载入站内信添加界面异常
	 */
	public static String webToSiteMailAddPageException="载入站内信添加界面异常";
	/**
	 * 900100站内信更新异常
	 */
	public static String webSiteMailUpdateException="站内信更新异常";
	/**
	 * 900101载入站内信发布界面失败
	 */
	public static String webToSiteMailPublishPageException="载入站内信发布界面失败";
	/**
	 * 900102站内信发布异常
	 */
	public static String webSiteMailPublishException="站内信发布异常";
	/**
	 * 900103载入影星更新界面异常
	 */
	public static String webToHumanUpdatePageException="载入影星更新界面异常";
	/**
	 * 900104载入站内信更新界面异常
	 */
	public static String webToSiteMailUpdatePageException="载入站内信更新界面异常";
	/**
	 * 900105载入提现审核界面异常
	 */
	public static String webToUserCashReviewPageException="载入提现审核界面异常";
	/**
	 * 900106载入影片地址绑定界面异常
	 */
	public static String webToVideoStoreUrlBindPageException="载入影片地址绑定界面异常";
	/**
	 * 900107载入卡密添加界面异常
	 */
	public static String webToCardCodeAddPageException="载入卡密添加界面异常";
	/**
	 * 900108载入版本添加界面异常
	 */
	public static String webToVersionAddPageException="载入版本添加界面异常";
	/**
	 * 900109版本添加异常
	 */
	public static String webVersionAddException="版本添加异常";
	/**
	 * 900110版本更新异常
	 */
	public static String webVersionUpdateException="版本更新异常";
	/**
	 * 900111删除播放记录异常
	 */
	public static String webUserPlayHisDelException="删除播放记录异常";
	/**
	 * 900112删除搜索记录异常
	 */
	public static String webUserSearchHisDelException="删除搜索记录异常";
	/**
	 * 900113删除用户购买记录异常
	 */
	public static String webUserBuyDelException="删除用户购买记录异常";
	/**
	 * 900114载入模块类型更新界面失败
	 */
	public static String webToModuleTypeUpdateException="载入模块类型更新界面失败";
	/**
	 * 900115模块类型更新异常
	 */
	public static String webModuleTypeUpdateException="模块类型更新异常";
	/**
	 * 900116载入广告类型更新界面异常
	 */
	public static String webToAdvertTypeUpdatePageException="载入广告类型更新界面异常";
	/**
	 * 900117载入广告添加界面异常
	 */
	public static String webToAdvertAddPageException="载入广告添加界面异常";
	/**
	 * 900118添加广告异常
	 */
	public static String webAdvertAddException="添加广告异常";
	/**
	 * 900119更新广告数据异常
	 */
	public static String webAdvertUpdateException="更新广告数据异常";
	/**
	 * 900120载入广告更新界面异常
	 */
	public static String webToAdvertUpdatePageException="载入广告更新界面异常";
	/**
	 * 900121载入banner类型添加界面异常
	 */
	public static String webToBannerTypeAddPageException="载入banner类型添加界面异常";
	/**
	 * 900122载入banner类型更新界面异常
	 */
	public static String webToBannerTypeUpdatePageException="载入banner类型更新界面异常";
	/**
	 * 900123banner类型添加异常
	 */
	public static String webBannerTypeAddException="banner类型添加异常";
	/**
	 * 900124banner类型更新异常
	 */
	public static String webBannerTypeUpdateException="banner类型更新异常";
	/**
	 * 900125载入banner添加界面异常
	 */
	public static String webToBannerAddPageException="载入banner添加界面异常";
	/**
	 * 900126载入banner更新界面异常
	 */
	public static String webToBannerUpdatePageException="载入banner更新界面异常";
	/**
	 * 900127banner添加异常
	 */
	public static String webBannerAddException="banner添加异常";
	/**
	 * 900128banner更新异常
	 */
	public static String webBannerUpdateException="banner更新异常";
	/**
	 * 900129载入系统参数添加界面异常
	 */
	public static String webToSysParamAddPageException="载入系统参数添加界面异常";
	/**
	 * 900130载入系统参数更新界面异常
	 */
	public static String webToSysParamUpdatePageException="载入系统参数更新界面异常";
	/**
	 * 900131系统参数添加异常
	 */
	public static String webSysParamAddException="系统参数添加异常";
	/**
	 * 900132系统参数更新异常
	 */
	public static String webSysParamUpdateException="系统参数更新异常";
	/**
	 * 900133载入服务器添加界面异常
	 */
	public static String webToServerAddPageException="载入服务器添加界面异常";
	/**
	 * 900134载入服务器修改界面异常
	 */
	public static String webToServerUpdatePageException="载入服务器修改界面异常";
	/**
	 * 900135服务器添加异常
	 */
	public static String webServerAddException="5服务器添加异常";
	/**
	 * 900136服务器更新异常
	 */
	public static String webServerUpdateException="服务器更新异常";
	/**
	 * 900137载入用户密码重置界面异常
	 */
	public static String webToUserPassResetPageException="载入用户密码重置界面异常";
	/**
	 * 900138客户端密码重置异常
	 */
	public static String webUserPassResetException="客户端密码重置异常";
	/**
	 * 900139服务端用户密码重置异常
	 */
	public static String webServerUserPassResetException="服务端用户密码重置异常";
	/**
	 * 900140载入模块修改界面异常
	 */
	public static String webToModuleUpdatePageException="载入模块修改界面异常";
	/**
	 * 900141模块删除异常
	 */
	public static String webModuleDelException="模块删除异常";
	/**
	 * 900142载入缓存清理界面异常
	 */
	public static String webToCacheCleanPageException="载入缓存清理界面异常";
	/**
	 * 900143缓存清理异常
	 */
	public static String webCacheCleanException="缓存清理异常";
	/**
	 * 900144载入web权限添加界面异常
	 */
	public static String webToWebPermissionAddPageException="载入web权限添加界面异常";
	/**
	 * 900145web权限添加异常
	 */
	public static String webWebPermissionAddException="web权限添加异常";
	/**
	 * 900146载入web权限添加界面异常
	 */
	public static String webToWebPermissionUpdatePageException="载入web权限添加界面异常";
	/**
	 * 900147web权限添加异常
	 */
	public static String webWebPermissionUpdateException="web权限添加异常";
	/**
	 * 900148载入web角色添加界面异常
	 */
	public static String webToWebRoleAddPageException="8载入web角色添加界面异常";
	/**
	 * 900149web角色添加异常
	 */
	public static String webWebRoleAddException="web角色添加异常";
	/**
	 * 900150载入web角色添加界面异常
	 */
	public static String webToWebRoleUpdatePageException="载入web角色添加界面异常";
	/**
	 * 900151web角色添加异常
	 */
	public static String webWebRoleUpdateException="web角色添加异常";
	/**
	 * 900152web角色权限绑定异常
	 */
	public static String webWebRolePermissionBindException="web角色权限绑定异常";
	/**
	 * 900153载入web角色权限绑定界面异常
	 */
	public static String webToWebRolePermissionBindPageException="载入web角色权限绑定界面异常";
	/**
	 * 900154载入web用户更新界面异常
	 */
	public static String webToWebUserUpdatePageException="载入web用户更新界面异常";
	/**
	 * 900155web用户更新异常
	 */
	public static String webWebUserUpdateException="用户更新异常";
	/**
	 * 900156载入app权限添加界面异常
	 */
	public static String webToAppPermissionAddPageException="载入app权限添加界面异常";
	/**
	 * 900157app权限添加异常
	 */
	public static String webAppPermissionAddException="app权限添加异常";
	/**
	 * 900158载入app权限添加界面异常
	 */
	public static String webToAppPermissionUpdatePageException="载入app权限添加界面异常";
	/**
	 * 900159app权限添加异常
	 */
	public static String webAppPermissionUpdateException="app权限添加异常";
	/**
	 * 900160载入app角色添加界面异常
	 */
	public static String webToAppRoleAddPageException="载入app角色添加界面异常";
	/**
	 * 900161app角色添加异常
	 */
	public static String webAppRoleAddException="app角色添加异常";
	/**
	 * 900162载入app角色添加界面异常
	 */
	public static String webToAppRoleUpdatePageException="载入app角色添加界面异常";
	/**
	 * 900163app角色添加异常
	 */
	public static String webAppRoleUpdateException="app角色添加异常";
	/**
	 * 900164载入app角色权限绑定界面异常
	 */
	public static String webToAppRolePermissionBindPageException="载入app角色权限绑定界面异常";
	/**
	 * 900165绑定app角色权限异常
	 */
	public static String webAppRolePermissionBindException="绑定app角色权限异常";
	/**
	 * 900166删除广告信息异常
	 */
	public static String webDelAdvertException="删除广告信息异常";
	/**
	 * 900167删除banner信息异常
	 */
	public static String webDelAppBannerException="删除banner信息异常";
	/**
	 * 900168删除代理商聊天记录异常
	 */
	public static String webDelAppUserChatHisException="删除代理商聊天记录异常";
	/**
	 * 900169获取用户余额报表异常
	 */
	public static String webGetBalanceReportException="获取用户余额报表异常";
}
