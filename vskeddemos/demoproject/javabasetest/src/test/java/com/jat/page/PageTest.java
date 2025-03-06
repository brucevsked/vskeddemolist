package com.jat.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class PageTest {

    private static final Logger log = LoggerFactory.getLogger(PageTest.class);


    @Test
    public void test1(){
        // 当前第几页
        VPageIndex pageIndex = new VPageIndex(0);
        // 每页显示多少条
        VPageSize pageSize = new VPageSize(10);
        VPage page = new VPage<>(pageIndex, pageSize);

        // 传入查询的参数 任务名称
        String taskName="要查询的任务名";
        VQueryConditionName ctaskName = new VQueryConditionName("taskName");
        VQueryConditionValue ctaskNameValue = new VQueryConditionValue(taskName);
        VQueryCondition qctaskName = new VQueryCondition(ctaskName, ctaskNameValue);

        List<VQueryCondition> queryParaList = new LinkedList<VQueryCondition>();
        queryParaList.add(qctaskName);

        page.setConditions(queryParaList);
    }
}
