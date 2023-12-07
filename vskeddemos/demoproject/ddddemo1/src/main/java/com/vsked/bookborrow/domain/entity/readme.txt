

具有生命周期
只在聚合根内有本地唯一标识（这个唯一标识不能是基本数据类型）
可以放业务逻辑比如判断之类的

entity是一类可识别的可追踪的对象。
说简单了，它必须有identifier，再简单点id（可识别，可被追踪）。
另外它是有可变对象，mutable。但即使状态变化了之后，entity还是原来的entity。

id类 vs String/Long
  如果id类都是Long或者String，那彼此之间是不能区别的。
  搞不清楚id究竟是哪个entity的id。特意定义id类，
  可以在一些方法要传递好多id时防止一些认为错误。
  比如getAnObject(Long objAId, Long objBId)。
  参数上objAId，objBId是不能搞错的。
  但如果数据类型都是Long，那编译器是核对不了的～

