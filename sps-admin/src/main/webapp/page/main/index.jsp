<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro"  uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>桔子分期</title>
<meta name="keywords" content="桔子分期,大学生分期,大学生分期网,手机分期,笔记本分期,相机分期,大学生分期付款,大学生兼职">
<meta name="description" content="桔子分期是一家专注于年轻人分期购物的在线商城及金融服务平台，所有商品100%正品行货,支持全网分期,产品以限时特卖、零首付分期付款为主，是国内领先的年轻人分期消费服务商。">
<link rel="shortcut icon" href="<%=path%>/page/static/images/logo1.png" type="image/x-icon" >
<link rel="stylesheet" type="text/css" href="../static/css/sys.public.css">
<link rel="stylesheet" type="text/css" href="../static/css/sys.main.css">
</head>
<body>
<div id="sys-head"><!-- load tlp --></div>
	<div id="sys-wrap">
		<div id="left-bar"><!-- load tlp --></div>
		<div id="main-wrap">
			<div class="clearfix" id="dataMains"><!-- load tlp --></div>
		</div>
	</div>
<!-- script -->
<script type="text/javascript" src="../static/js/JZFQ.ued.lib.js"></script>
<script type="text/javascript" src="../static/js/laydate/laydate.js"></script>
<script type="text/javascript">
$(function(){
})
</script>
</body>
</html>