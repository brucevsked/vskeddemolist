package com.vsked.test;

import org.junit.Test;

import com.googlecode.asyn4j.core.callback.AsynCallBack;
import com.googlecode.asyn4j.core.handler.CacheAsynWorkHandler;
import com.googlecode.asyn4j.service.AsynService;
import com.googlecode.asyn4j.service.AsynServiceImpl;
import com.vsked.callback.TargetBack;
import com.vsked.service.TargetService;

public class Test1 extends BaseTest {

	@Test
	public void test1() {
		System.out.println("hello 1 test ");
		// (maxCacheWork)最大工作队列缓存工作数 – 300(默认值)
		// (addWorkWaitTime)当工作队列满时添加工作等待时间-- Long.MAX_VALUE(默认值)
		// (workThreadNum)异步工作执行线程池大小  ---- CPU核数/2 +1(默认值)
		// (callBackThreadNum)回调执行线程池大小  --- CPU核数/2(默认值)
		// (closeServiceWaitTime) 服务关闭等待时间  ---- 60000s(默认值)
		AsynService asynService = AsynServiceImpl.getService(3000, 3000L, 10, 150, 6000L);
		// 设置队列大小
		asynService.setWorkQueueFullHandler(new CacheAsynWorkHandler(500));
		// 启动服务
		asynService.init();
		// 异步回调对象
		AsynCallBack back = new TargetBack();
		for (int i = 0; i < 3; i++) {
			// 添加加异步工作- TargetService 的 test 方法 ，方法参数 asynej+ i
			asynService.addWork(TargetService.class, "getUserById", new Object[] { "asyn4j" + i }, new TargetBack());

			// 实例化目标对象再调用
			TargetService targetService = new TargetService();
			asynService.addWork(targetService, "getUserById", new Object[] { "asyn4j" + i }, new TargetBack());

		}
	}

}
