# springdatajpademo

启动时自动执行建表语句与填充数据  
第一步准好建表脚本schema.sql与数据初始化文件data.sql  
第二步在spring boot的配置文件中声明数据库类型，可以写到最上面  
database: mysql
第三步在spring boot的配置文件中绑定要执行的脚本并设置每次都执行（适用于单元测试）  
  sql:
    init:
    schema-locations: "classpath:db/${database}/schema.sql"
    data-locations: "classpath:db/${database}/data.sql"
    encoding: UTF-8
    mode: always #每次都重新初始化

## 二 数据库连接
数据库名  
vskedtest
10.0.193.11  
3306  
root  
root

## 三 编程思路
面向业务编程  

单元测试时继续下面这个类是带事务管理的  
AbstractTransactionalTestNGSpringContextTests  

下面这个不带事务管理的  
AbstractTestNGSpringContextTests  

Spring Data JPA提供了三个存储库，如下所示：<br>
### CrudRepository：提供标准的创建，读取，更新和删除功能，其中包含诸如findOne()，findAll()，save()，delete()等方法。<br>
### PagingAndSortingRepository：它扩展了CrudRepository并添加了findAll方法。它能够以分页方式对数据进行排序和检索。<br>
### JpaRepository：这是一个JPA特定的存储库，它在Spring Data Jpa中定义。它扩展了存储库CrudRepository和PagingAndSortingRepository。它添加了特定于JPA的方法，例如flush()，以在持久性上下文上触发刷新。<br>
//更多请阅读：https://www.yiibai.com/spring-boot/spring-boot-starter-data-jpa.html


demo1 创建，读取，更新，删除示例CrudRepository,user表  
demo2 排序，分页示例PagingAndSortingRepository,employee表  
demo3 save,saveAndFlush区别JpaRepository,book表  
demo4 Specification(分页查询与排序，查询单个)与Example动态查询,account表  
demo5 关联关系示例（一对一，有中间表与无中间表两种情况）,driverCard,driverMan,IDCard,person表  
demo6 关联关系示例（一对多）,grade,school表  
demo7 关联关系示例（多对多）,course,student表  
demo8 唯一约束,desk表  
demo9 逻辑删除与查询 ,website表  
demo10 复合主键1(无外键约束),user1,card1,userCard1表  
demo11 关联关系一对多有中间表添加扩展列,action1,parameter1,actionParameter1表  
demo12 关联关系多对多有中间表添加扩展列,user2,role2,userRole2表<br>
demo13 关联关系多对多中间表无扩展列,双向关联(不推荐这种写法，除非场景内确实是双向关联操作),role3,permission3表  
demo14 关联关系多对多中间表无扩展表，单身关联,user4,role4,permission4表  
demo15 关联关系一对一有中间表，根据证书查询用户,user5,certificate5 userCertificate5表  
demo16 取指定列信息device表通过转换dto时获取而不在数据库获取指定字段    
demo17 specification查询条件为子对象中属性 user6,certificate6  
demo18 树，父子关系node表  
demo19 @Embeddable，@Embedded，@EmbeddedId相关使用,person,address(未完成，需要修正)  
demo20 复合主键2(带外键约束),中间表扩展字段，中间表多一个字段示例permission5,record5  
demo21 通过传入多个id获取多条记录也就是in的用法human
demo22 一对多关系查找，根据多的一方id查主对象user7,certificate7  
demo23 级联新增，级联删除测试（2级）user8,certificate8
demo24 级联删除，仅解绑关系，不删除实体数据,user9,role9,permission9  
demo25 级联删除(手动清理版本)，删除关系与实体数据,user10,certificate10  
demo26 id不相同名称相同，根据多个固定条件查询 role10  
demo27 数据类型保存测试datatest各类日期时间存储与获取对比  
demo28 Specification固定多条件查询  
demo29 Specification动态多条件查询  
demo30 结合hibernate自定义id生成策略sequenceTest  
demo31 CascadeType.DETACH示例中间表的新增，删除操作sysUser,sysRole,sysUserRole  



mappedBy单向关联说明(根据实际情况使用,慎用!)
在A表中写B bike;
在B表中写A ac;这里ac如果写上mapedBy时，保存B表数据不会保存ac数据与中间表数据


如果要删除中间表信息，可以将数据先设置为空，保存一次，再添加新数据，再保存一次  
示例：  
角色与权限是多对多的关系
要删除一个角色中多个权限
Set<Permission> permissions= new HashSet<>();
        RoleId roleId1=new RoleId(50000000000000001L);
        RoleName roleName1=new RoleName("超级管理员");
        Role role1=new Role(roleId1,roleName1);
        role1.addPermissions(permissions);
        roleManager.save(role1);

role1.addPermission(p1);//要添加的新权限

Map与List相关查询
@Query(value = "SELECT id, adminName, loginName FROM users WHERE id = :id", nativeQuery = true)
Map<String, Object> findUserAsMapByIdNative(@Param("id") Long id);

    @Query(value = "SELECT id, adminName, loginName FROM users ", nativeQuery = true)
    List<Map<String, Object>> findUserAsListByIdNative();

    @Test
    public void findMapByUserId(){
        Map<String, Object> map = usersRepository.findUserAsMapByIdNative(2L);
        log.info("查询结果a: {}", map);
    }

    @Test
    public void findList(){
        List<Map<String, Object>> list = usersRepository.findUserAsListByIdNative();
        log.info("查询结果b: {}", list);
    }