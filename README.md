#### **项目简介**

一个基于SpringBoot 2.1.0、SpringCloud、Solr、Redis、ActiveMQ、Angular的前后端分离的分布式商城系统

#### 项目简介

商品管理：对商品的规格、品牌、模板进行CRUD操作，通过select2插件对分类的商品进行层级检索

商品审核：使用ActiveMQ作为消息中间件，给后台发送相关信息，完成相应的业务

广告管理:   使用Redis对图片进行存储，实现首页轮播广告功能

搜索服务:   使用solr搜索引擎进行查询，把相关数据上传到solr库

#### 项目结构

1.后台架构

- Springcloud的Eureka注册服务器 shopping-server
- 商城的聚合工程 shopping-parent
- pojo模块 shopping-pojo
- mapper模块 shopping-mapper
- 网关模块 shopping-zuul
- 商品管理微服务 shopping-goods-ms
- 商品搜索微服务 shopping-search-ms
- 消息中间件微服务 shopping-page-ms

2.前端应用

- 供应商后台系统 pingyougo-manager-web
- 搜索页面 pingyougo-search-web
- 商家后台系统 pingguoyou-protal-web
- 门户网站 pingyougo-shop-web

#### 系统预览

![1590740885258](C:\Users\ACER\AppData\Roaming\Typora\typora-user-images\1590740885258.png)

![1590740929775](C:\Users\ACER\AppData\Roaming\Typora\typora-user-images\1590740929775.png)

![1590740964676](C:\Users\ACER\AppData\Roaming\Typora\typora-user-images\1590740964676.png)

![1590740989289](C:\Users\ACER\AppData\Roaming\Typora\typora-user-images\1590740989289.png)

