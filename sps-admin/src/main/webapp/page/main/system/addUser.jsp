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
<title>用户添加</title>
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
<div style="margin-top: 20px;margin-left: 120px" >
<h3>用户信息</h3>
<hr>
<form class="layui-form" action="<%=path %>/user/userList.html" method="post">
  <div class="layui-form-item ">
    <label class="layui-form-label">*用户名:</label>
    <div class="layui-input-inline">
      <input id="username" type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">*登录密码：</label>
    <div class="layui-input-inline">
      <input name="password" type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*确认密码：</label>
    <div class="layui-input-inline">
      <input type="password"  required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*姓名：</label>
    <div class="layui-input-inline">
      <input type="text" name="name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">*联系电话：</label>
    <div class="layui-input-inline">
      <input type="text" name="phone" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*电子邮箱：</label>
    <div class="layui-input-inline">
      <input type="email" name="email" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>

<h3>角色信息</h3>
<hr>
  <div class="layui-form-item">
    <label class="layui-form-label">选择角色：</label>
    <div class="layui-input-block" id="checkList" name="check">
    </div>
  </div>
 	<div class="layui-form-item" align="center">
		<button class="layui-btn" lay-submit="" lay-filter="demo1" id="submit">立即提交</button>
		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
</form>
</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript">
	layui.use('form', function(){
	  var form = layui.form;
	  var $ = layui.jquery;
	  var array = [];
	  form.on('checkbox(encrypt)', function(data){
		  array.push(data.value)
		  console.log(data.value); //复选框value值，也可以通过data.elem.value得到
		});        
 	  form.on('submit(demo1)', function(data){
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});	
 	  $('#submit').on('click',function(){
		  
	  }) 
	  $.post({
		  url:'<%=path %>/role/roleList.html',
		  dataType:'json',
		  success:function(data){
			  var list = "";
			  $.each(data,function(i,item){
				  list +='<input type="checkbox" name="check" lay-filter="encrypt" title="'+item.roleName+'" value ="'+item.roleId+'">';
				  $('#checkList').html(list)
			  })
			  form.render('checkbox');
		  }
	  })
	});
</script>
</body>
</html>