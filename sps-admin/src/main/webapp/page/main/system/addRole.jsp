<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
	
<style type="text/css">
</style>
</head>
<body>
<div style="margin-top: 20px;margin-left: 120px">
	<h3>角色添加</h3>
	<hr>
		<div class="layui-form "  >
		  <div class="layui-form-item ">
		    <label class="layui-form-label">*角色：</label>
		    <div class="layui-input-inline">
		      <input type="text" name="title" required  lay-verify="required" placeholder="角色名称" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">*角色描述：</label>
		    <div class="layui-input-inline" style="width: 400px">
				<textarea name="" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>
		    </div>
		  </div>
		
		<h3>权限分配</h3>
		<hr>
	</div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript">
	layui.use('form', function(){
	  var form = layui.form;
	});
</script>
</body>
</html>