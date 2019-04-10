package com.vsked.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.custvs.common.MyBatisTest;

public class TestFlow1 extends MyBatisTest{
	
	private static final Logger log = LoggerFactory.getLogger(TestFlow1.class);
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	RuntimeService runtimeService;
	
	Color HIGHLIGHT_COLOR = Color.RED;
	Stroke THICK_TASK_BORDER_STROKE = new BasicStroke(3.0f);
	
//	@Test
	public void deployTest1(){
		try{
		//测试部署工作流
		String fileName="e:/TestFlow1.bpmn";
		File flowFile=new File(fileName);
		InputStream is = new FileInputStream(flowFile);
		Deployment deployment = repositoryService.createDeployment().addInputStream("bpmn20.xml", is).name("holidayRequest").deploy();
		log.debug("deploy id|"+deployment.getId()+"");
		}catch(Exception e){
			e.printStackTrace();
			log.error("deploy ERROR",e);
		}
	}
	
//	@Test
	public void saveToImage(){
		try{
		//工作流生成图片
		String flowId="1";//工作流部署id
		String savePath="e:/testFlow1.png";//保存图片路径
		 ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService.createProcessDefinitionQuery().deploymentId(flowId).singleResult();
		// 获取流程图并生成文件
		 String diagramResourceName = processDefinition.getDiagramResourceName();
	     InputStream stream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), diagramResourceName);
	     OutputStream out = new FileOutputStream(savePath);
	     int len;
	     byte[] data = new byte[1024];
	     while ((len = stream.read(data)) != -1) {
	        out.write(data, 0, len); 
	     }
	     out.flush();
	     stream.close();
	     out.close();
	     
	     log.debug("processDefinition id|"+processDefinition.getId()+"|");
	     
		}catch(Exception e){
			e.printStackTrace();
			log.error("save pic error",e);
		}
	     
	}
	
//	@Test
	public void runFlow(){
		//启动流程
		String processDefinitionId="myProcess:1:4";
		//runtimeService.startProcessInstanceByKey("myProcess");
		runtimeService.startProcessInstanceById(processDefinitionId);
	}
	
	@Test
	public void searchTask(){
		String processDefinitionId="myProcess:1:4";
		//查询任务实例
        List<Task> taskList = taskService.createTaskQuery().processDefinitionId(processDefinitionId).list();
        Assert.assertNotNull(taskList == null);
        Assert.assertTrue(taskList.size() > 0);
        for (Task task : taskList) {
            log.debug("task name is " + task.getName() + " ,task key is " + task.getTaskDefinitionKey());
        }
        log.debug("search finish");
	}

}
