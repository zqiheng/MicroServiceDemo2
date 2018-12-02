# MicroServiceDemo

# 微服务项目Demo2（代码重构版）

**任务要求：**
- 包含Eureka服务
- 包含Feign client的调用，并实现负载均衡
- 包含config server
- 数据库使用Oracle 12c版本
- Maven构建项目
- 代码存放在远程仓库中

## 配置说明

|服务名|备注|端口|接口格式|数据库|
|:--:|:--:|:--:|:--|:--:|
|eureka-server|服务注册中心|**10001**|port/eureka|无|
|service-user|用户服务|**10010**|port/api/v1/user/|fa_microservice_user|
|service-product|商品服务|**10020**|port/api/v1/product/|fa_microservice_product|
|service-order|订单服务|**10030**|port/api/v1/order/|fa_microservice_order|
|config-server|配置中心|**10003**|port/服务名/配置名.yml|无|
|zuul-server|网关服务|**99**|port/服务名/接口名...|无|

## 采用技术

Jdk 1.8 + Maven + SpringBoot 2.1.1.RELEASE  + SpringCloud Greenwich.M3 + JAP + Hibernate + Mysql

## 开发工具

- idea 2018.1
- postman

## 代码托管

- GitHub

## 远程配置中心

- Gitee（码云）

# 业务说明

本次采用一个简单的电商系统为例，模拟的三个微服务的实现与调用（用户服务、商品服务、订单服务）。

## 开发采用框架

- Eureka：服务注册中心
- Zuul：路由网关
- Confg：配置中心




