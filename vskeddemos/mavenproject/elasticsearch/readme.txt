
示例请查看单元测试
com.vsked.service.ElasticSearchService

单个 Elastic 实例称为一个节点（node）。一组节点构成一个集群（cluster）。
Elastic 数据管理的顶层单位就叫做 Index（索引）。它是单个数据库的同义词。每个 Index （即数据库）的名字必须是小写。
Index 里面单条的记录称为 Document（文档）。许多条 Document 构成了一个 Index。
索引库（indices)	indices是index的复数，代表许多的索引，
文档（document）	存入索引库原始的数据。比如每一条商品信息，就是一个文档
字段（field）	文档中的属性
映射配置（mappings）	字段的数据类型、属性、是否索引、是否存储等特性
创建索引库（数据库）
"number_of_shards": 1 分片数
"number_of_replicas": 1 副本数

PUT people
{
  "settings": {
    "number_of_shards": 1,
    "number_of_replicas": 1
  }

}

删索引库
DELETE people

查询索引库
GET  people

查询索引库是否存在
EAD people

创建映射关系(数据库列)
type：类型，可以是text、long、short、date、integer、object等
index：是否索引，默认为true
store：是否存储，默认为false
analyzer：分词器，这里的ik_max_word即使用ik分词器

PUT people/_mapping
{
  "properties": {
    "name": {
      "type": "text",
      "analyzer": "ik_max_word"
    },
    "age": {
      "type": "integer",
      "index": "false"
    },
    "sex": {
      "type": "keyword"
    }
  }
}

查询映射关系
GET people/_mapping

添加 更新数据
我们也可以直接添加数据 这样系统会给我们默认生成一套映射关系
如果_doc 后面不指定id数 会默认生成随机id

POST people/_doc/1
{
  "name" : "小明",
  "age" : 18,
  "sex": "男"
}

使用相同的代码更改部分 即可更改
POST people/_doc/1
{
  "name" : "小红",
  "age" : 18,
  "sex": "女"
}

获取数据
GET people/_doc/1
或者查询所有
GET people/_search

删除数据
DELETE people/_doc/1

全部查询
GET /索引库名/_search
{
    "query":{
        "查询类型":{
            "查询条件":"查询条件值"
        }
    }
}

默认查询所有的people下的数据
GET people/_search

查询所有的people下的数据
GET people/_search
{
  "query": {
    "match_all": {}
  }
}

匹配查询
查询name是小王2的字段 默认情况为or （即包含小王字段的也会查询到）
GET people/_search
{
  "query": {
    "match": {
      "name": "小王2"
    }
  }
}