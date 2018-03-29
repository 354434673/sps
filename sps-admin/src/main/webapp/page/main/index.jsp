<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
<title>桔子分期店付</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="shortcut icon"
	href="<%=path%>/page/static/images/1514199484(1).png"
	type="image/x-icon">

<link rel="stylesheet"
	href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="<%=path%>/page/static/css/global.css"
	media="all">
<link rel="stylesheet"
	href="<%=path%>/page/static/plugins/font-awesome/css/font-awesome.min.css">

</head>

<body>
	<div class="layui-layout layui-layout-admin"
		style="border-bottom: solid 5px #1aa094;">
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<div class="admin-login-box">
					<a class="logo" style="left: 0;"
						href="http://beginner.zhengjinfan.cn/demo/beginner_admin/"> <span
						style="font-size: 22px;">桔子分期</span>
					</a>
					<div class="admin-side-toggle">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</div>
					<div class="admin-side-full">
						<i class="fa fa-life-bouy" aria-hidden="true"></i>
					</div>
				</div>
				<ul class="layui-nav admin-header-item">
					<li class="layui-nav-item"><a href="javascript:;" id="clearCached">清除缓存</a></li>
					<li class="layui-nav-item"><a href="javascript:;" class="admin-header-user">
						<img src="<%=path%>/page/static/images/0.jpg" /> 
						<span id="username"><shiro:principal /></span>
					</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;"><i class="fa fa-user-circle"
									aria-hidden="true"></i> 个人信息</a>
							</dd>
							<dd>
								<a href="javascript:;"><i class="fa fa-gear"
									aria-hidden="true"></i> 设置</a>
							</dd>
							<dd>
								<a href="<%=path %>/user/logout.html"><i class="fa fa-sign-out"
									aria-hidden="true"></i> 注销</a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav admin-header-item-mobile">
					<li class="layui-nav-item"><a href="/user/logout.html"><i
							class="fa fa-sign-out" aria-hidden="true"></i> 注销</a></li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black" id="admin-side">
			<div class="layui-side-scroll" id="admin-navbar-side"
				lay-filter="side"></div>
		</div>
		<div class="layui-body"
			style="bottom: 0; border-left: solid 2px #1AA094;" id="admin-body">
			<div class="layui-tab admin-nav-card layui-tab-brief"
				lay-filter="admin-tab">
				<ul class="layui-tab-title">
					<li class="layui-this"><i class="fa fa-dashboard"
						aria-hidden="true"></i> <cite>控制面板</cite>
						</li>
				</ul>
				<div class="layui-tab-content"
					style="min-height: 150px; padding: 5px 0 0 0;">
					<div class="layui-tab-item layui-show">
						<iframe src="<%=path%>/page/main/main.html"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-footer footer footer-demo" id="admin-footer">
			<div class="layui-main">
				<p>
					2017 &copy; <a href="http://m.zhengjinfan.cn/">桔子分期</a>
				</p>
			</div>
		</div>
		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>
</div>
<script type="text/javascript"
			src="<%=path%>/page/static/plugins/layui/layui.js"></script>
<script src="<%=path%>/page/static/js/index.js"></script>
<script>
			var pathStr = "${pageContext.request.contextPath}";//项目名称,方便js获取
			layui.use(['layer','navbar'], function() {
				var $ = layui.jquery, 
				layer = layui.layer;
				 navbar = layui.navbar();
				$('#pay').on('click', function() {
					layer.open({
						title : false,
						type : 1,
						content : '<img src="images/xx.png" />',
						area : [ '500px', '250px' ],
						shadeClose : true
					});
				});

			    //设置navbar
			    navbar.set({
			        spreadOne: true,
			        elem: '#admin-navbar-side',
			        cached: true,
			        //data: navs,
					/*cached:true,*/
					url: pathStr+'/menu/getMenu.json'
			    });
			    //渲染navbar
			    navbar.render();
			});
</script>
</body>
</html>