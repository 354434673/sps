## readme
1. groupId
	
		com.sps

2. artifactId
		
		sps-service ##接口
		sps-service-impl ##接口实现,dubbo-privoder
		
		sps-parent ##父pom
		
		sps-h5 ##提供接口
		sps-admin ##基础数据平台
		sps-api ##api接口
		sps-order ##订单
		sps-merchant ##商户
		sps-goods ##商品
		sps-crm ##crm
		sps-operation ##运营
		
		
3. 数据库表
		
		商户:
		 1.sps_channel 渠道属性
		 2.sps_channel_account 账户信息
		 3.sps_channel_business 业务信息
		 4.sps_channel_enterprise 企业基本信息
		 5.sps_channel_finance_target 财务指标
		 6.sps_channel_gather 收款账号
		 7.sps_channel_logistics 物流配送
		 8.sps_channel_guarantee 担保信息
		 9.sps_channel_statistics 统计信息
		 10.sps_channel_open_account 开户信息
		 11.sps_channel_salesman 业务员信息
		 12.sps_channel_pic 商户上传图片表
		 


## 注意:
		
		dubbox2.8.4无法通过maven从中心仓库下载,需要自己放到本地仓库即可
	
##技术选型

		Maven
		资源调度和治理中心(SOA)（dubbo-admin）
		Dubbo+Zookeeper分布式服务框架
		Zookeeper高可用集群方案
		dubbo服务设计原则、集群、负载均衡、线程模型
		Spring（IOC DI AOP 声明式事务处理）
		SpringMVC（支持Restful风格）
		Mybatis（最少配置方案）
		Quartz时间调度（待完善）
		统一的异常处理（待完善）
		Redis缓存（ProtoStuff序列化）
		Redis Sentinel主从高可用方案
		Redis Cluster集群高可用方案
		Druid（数据源配置 sql防注入 sql性能监控)
		前后端分离（Html替代Jsp）
		Nginx静态加载、负载均衡
		Tomcat集群（Redis共享Session）
		Sping Shiro权限控制
		
##退货状态数据库标示:

		12:待确认退货
		13:待确认退货未通过
		14:已确认退货审核
		15:已确认退货审核未通过
		16:待收货退款
		17:待退款退货
		18:风控审核中：订单在风控审核中
		19:风控审核不通过：订单在风控审核不通过
