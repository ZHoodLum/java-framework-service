# 关于springcloud的demo练习

## 工程说明
子项目名称|说明|链接
:----|:----|:----
docREAMDE|Spring Cloud学习脑图，Spring Cloud组件知识点|[链接](docREAMDE/DOCREAMDE.md)
cloud-api-commons|公共方法基础类、工具类、子工程公用的entity|[链接](cloud-api-commons)
cloud-consumer-feign-hystrix-order80|消费方订单模块 80——注册中心使用的eureka—请求转发使用的openfeign ，用于测试微服务降级 熔断 限流功能|[链接](cloud-consumer-feign-hystrix-order80)
cloud-consumer-feign-order80|消费方订单模块 80——注册中心使用的eureka—请求转发使用的openfeign|[链接](cloud-consumer-feign-order80)
cloud-consumer-order80|消费方订单模块 80——注册中心使用的eureka——请求转发使用的ribbon+restTemplate|[链接](cloud-consumer-order80)
cloud-consumerconsul-order80|消费方订单模块 80——注册中心使用的consul——请求转发使用的ribbon+restTemplate|[链接]( cloud-consumerconsul-order80)
cloud-consumerzk-order80|消费方订单模块 80——注册中心使用的zookeeper——请求转发使用的ribbon+restTemplate|[链接](cloud-consumerzk-order80)
cloud-eureka-server7001|eureka集群单点1——eureka7001|[链接](cloud-eureka-server7001)
cloud-eureka-server7002|eureka集群单点2——eureka7001|[链接](cloud-eureka-server7002)
cloud-provider-hystrix-payment8001|提供方集群节点3——支付系统8001——注册中心使用的eureka(7001 7002) ，用于测试微服务降级 熔断 限流功能|[链接](cloud-provider-hystrix-payment8001)
cloud-provider-payment8001|提供方集群节点1——支付系统8001——注册中心使用的eureka(7001 7002)|[链接](cloud-provider-payment8001)
cloud-provider-payment8001|提供方集群节点2——支付系统8002——注册中心使用的eureka(7001 7002)|[链接](cloud-provider-payment8002)
cloud-provider-payment8004|提供方集群节点4——支付系统8004——注册中心使用的zookeeper|[链接](cloud-provider-payment8004)
cloud-provider-payment8006|提供方集群节点6——支付系统8006——注册中心使用的consul|[链接](cloud-provider-payment8006)


