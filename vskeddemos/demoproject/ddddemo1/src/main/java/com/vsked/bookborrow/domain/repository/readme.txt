
通常来说，仓储由应用服务层调用
Repository的职责仅是数据永久化。
它将数据永久化的部分抽象，
使domain层能够专注对业务逻辑的实现。那理所当然repository是不能够包含业务逻辑的

在repository中应该吧查询条件更加抽象化，而起到这个作用的便是我们之前讲到的Specification。

大家可以看到，使用jpa的话，在entity的类里要写一些与db映射的注解。
如果你有一些洁癖，不希望有这种依赖于db的信息，
因为它实际上暴露具体的数据库实现。
那自然而然你可能想要有一个专门与db映射的类，姑且称之为data object吧。
data object不是domain object，它没有业务的逻辑，只有关于db的一些信息。
那repository的实现就会变成

查询： 使用ORM查询得到data object, 将data object转化为domain object返回。
存储: domain object转化成data object, 使用ORM将它永久化。
而ddd关注的只是repository将domain object永久化的部分。
它并不强求你去定义专门映射db的data model的。
其实使用data model这个手段不仅增加了需要定义的类，
还增加了类转换的逻辑，而你能够得到的回报知识讲业务与数据的更大程度的分离。

领域层定义接口，基础设施层实现接口


