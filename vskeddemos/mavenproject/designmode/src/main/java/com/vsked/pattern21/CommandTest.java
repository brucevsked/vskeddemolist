package com.vsked.pattern21;

public class CommandTest {

	public static void main(String[] args) {
		Receiver receiver=new Receiver();//第一步准备一步士兵 他有一个方法执行命令
		Command command=new MyCommand(receiver);//第二步创建一条命令 并指明士兵要去执行
		Invoker invoker=new Invoker(command);//第三步司令准备好命令
		invoker.action();//第四步司令下命令 命令传到要执行的士兵那儿士兵执行接收到的命令
	}

}
