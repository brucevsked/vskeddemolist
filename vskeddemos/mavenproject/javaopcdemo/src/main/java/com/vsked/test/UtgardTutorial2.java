package com.vsked.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.core.JIVariant;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.AccessBase;
import org.openscada.opc.lib.da.DataCallback;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.openscada.opc.lib.da.SyncAccess;
 
public class UtgardTutorial2 {
    
    public static void main(String[] args) throws Exception {
 
        // 连接信息 
        final ConnectionInformation ci = new ConnectionInformation();
        
        ci.setHost("127.0.0.1");          // 电脑IP
        ci.setDomain("");                   // 域，为空就行
        ci.setUser("OPCUser");              // 用户名，配置DCOM时配置的
        ci.setPassword("Y4yhl9tbf110");           // 密码
        
        // 使用MatrikonOPC Server的配置
        // ci.setClsid("F8582CF2-88FB-11D0-B850-00C0F0104305"); // MatrikonOPC的注册表ID，可以在“组件服务”里看到
        // final String itemId = "u.u";    // 项的名字按实际
 
        // 使用KEPServer的配置
        ci.setClsid("7BC0CC8E-482C-47CA-ABDC-0FE7F9C6E729"); // KEPServer的注册表ID，可以在“组件服务”里看到
        final String itemId = "通道1.设备1.标记1";    // 项的名字按实际，没有实际PLC，用的模拟器：simulator
        // final String itemId = "通道 1.设备 1.标记 1";
        
        // create a new server，启动服务
        final Server server = new Server(ci, Executors.newSingleThreadScheduledExecutor());
        try {
            // connect to server，连接到服务
            server.connect();
 
            // add sync access, poll every 500 ms，启动一个同步的access用来读取地址上的值，线程池每500ms读值一次
            // 这个是用来循环读值的，只读一次值不用这样
            final AccessBase access = new SyncAccess(server, 500);
            // 这是个回调函数，就是读到值后执行再执行下面的代码，是用匿名类写的，当然也可以写到外面去
            access.addItem(itemId, new DataCallback() {
                @Override
                public void changed(Item item, ItemState state) {
                    // also dump value
                    try {
                        if (state.getValue().getType() == JIVariant.VT_UI4) { // 如果读到的值类型时UnsignedInteger，即无符号整形数值
                            System.out.println("<<< " + state + " / value = " + state.getValue().getObjectAsUnsigned().getValue());
                        } else {
                            System.out.println("<<< " + state + " / value = " + state.getValue().getObject());
                        }
                    } catch (JIException e) {
                        e.printStackTrace();
                    }
                }
            });
 
            // Add a new group，添加一个组，这个用来就读值或者写值一次，而不是循环读取或者写入
            // 组的名字随意，给组起名字是因为，server可以addGroup也可以removeGroup，读一次值，就先添加组，然后移除组，再读一次就再添加然后删除
            final Group group = server.addGroup("test"); 
            // Add a new item to the group，
            // 将一个item加入到组，item名字就是MatrikonOPC Server或者KEPServer上面建的项的名字比如：u.u.TAG1，PLC.S7-300.TAG1
            final Item item = group.addItem(itemId);
 
            // start reading，开始循环读值
            access.bind();
 
            // add a thread for writing a value every 3 seconds
            // 写入一次就是item.write(value)，循环写入就起个线程一直执行item.write(value)
            ScheduledExecutorService writeThread = Executors.newSingleThreadScheduledExecutor();
            writeThread.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    final JIVariant value = new JIVariant("24");  // 写入24
                    try {
                        System.out.println(">>> " + "写入值：  " + "24");
                        item.write(value);
                    } catch (JIException e) {
                        e.printStackTrace();
                    }
                }
            }, 5, 3, TimeUnit.SECONDS); // 启动后5秒第一次执行代码，以后每3秒执行一次代码
 
            // wait a little bit ，延时20秒
            Thread.sleep(20 * 1000);
            writeThread.shutdownNow();  // 关掉一直写入的线程
            // stop reading，停止循环读取数值
            access.unbind();
        } catch (final JIException e) {
            System.out.println(String.format("%08X: %s", e.getErrorCode(), server.getErrorMessage(e.getErrorCode())));
        }
    }
}