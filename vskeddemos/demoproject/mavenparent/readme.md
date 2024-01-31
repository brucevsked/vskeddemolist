

platform 平台端
  platformapplication 平台端应用，springboot启动

user 用户相关代码
  userbusiness 用户业务层
  userpersistance 用户持久层 依赖用户业务层定义的respository接口
  userapi 用户控制器相当于控制层依赖业务层
  usertest 用户测试层 依赖用户业务层与用户持久层