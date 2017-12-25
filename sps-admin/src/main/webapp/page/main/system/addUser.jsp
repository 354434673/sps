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
<title>密码修改</title>
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
<h3>用户信息</h3>
<hr>
<div class="layui-form "  >
  <div class="layui-form-item ">
    <label class="layui-form-label">*用户名:</label>
    <div class="layui-input-inline">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">*登录密码：</label>
    <div class="layui-input-inline">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*确认密码：</label>
    <div class="layui-input-inline">
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*姓名：</label>
    <div class="layui-input-inline">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">*联系电话：</label>
    <div class="layui-input-inline">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*电子邮箱：</label>
    <div class="layui-input-inline">
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>

<h3>角色信息</h3>
<hr>
	  <div class="layui-form-item ">
	    <label class="layui-form-label">*角色:</label>
	    <div class="layui-input-inline">
	      <select name="interest" lay-filter="aihao">
	        <option value="0">运营岗</option>
	        <option value="1">开发岗</option>
	      </select>
	    </div>
	    <label class="layui-form-label">*是否默认:</label>
	    <div class="layui-input-inline">
	      <select name="interest" lay-filter="aihao">
	        <option value="0">是</option>
	        <option value="1">否</option>
	      </select>
	    </div>
	    <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
	  </div>
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