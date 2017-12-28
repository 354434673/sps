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
<div style="padding-left: 40%;margin-top: 100px" >
<div class="layui-form" >
  <div class="layui-form-item">
    <label class="layui-form-label">原始密码</label>
    <div class="layui-input-inline">
      <input id ="oldPassword" type="password" name="oldPassword"  lay-verify="required|minLength" placeholder="请输入原始密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">新密码</label>
    <div class="layui-input-inline">
      <input id="password" type="password" name="password" lay-verify="required|minLength" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input id="verifyPwd" type="password" lay-verify="required|verify" placeholder="请确认密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="submitUpdatePwd" id="updatePassword">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript">
layui.use(['form','table'], function(){
		var form = layui.form;
		var $ = layui.jquery;
		form.on('submit(submitUpdatePwd)', function(data){
			var oldPassword = $('#oldPassword').val();
			var newPassword = $('#password').val();
			var verifyPwd = $('#verifyPwd').val();
				$.post({
					url:'<%=path%>/user/updatePassword.html',
					dataType:'json',
					data:{oldPassword:oldPassword,newPassword:newPassword},
					success:function(data){
						layer.msg(data.msg,{icon: data.icon});
					}
				})
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
	  //自定义验证规则  
	  form.verify({  
			//验证只包含汉字  
			IsChineseCharacter: function(value) {
				var regex = /^[\u4e00-\u9fa5]+$/;
				if(!value.match(regex)) {
					return '请输入正确的姓名';
				}
			},
			minLength: function(value) {
				if(value.length<6) {
					return '最少为6位';
				}
			},
			verify: function(value) {
				var repass = $('#password').val();
				if(value != repass) {
					return '两次输入的密码不一致!';
				}
			},
	  });  
})
</script>
</body>

</html>