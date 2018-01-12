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
<div style="padding: 40px" >
<h3>用户信息</h3>
<hr>
<div class="layui-form layui-form-pane"  >
  <div class="layui-form-item ">
    <label class="layui-form-label">*用户名：</label>
    <div class="layui-input-inline">
      <input id="username" type="text" name="username"  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
    <button style="display:none" class="layui-btn layui-btn-primary" id="resetPasssword">重置密码</button>
  </div>
  <div class="layui-form-item" id="passwordDiv">
   <label class="layui-form-label">*登录密码：</label>
    <div class="layui-input-inline">
      <input id="password" name="password" type="password"  lay-verify="required|minLength" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">*确认密码：</label>
    <div class="layui-input-inline">
      <input type="password"  lay-verify="required|minLength|verify" placeholder="请确认密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*姓名：</label>
    <div class="layui-input-inline">
      <input id="name" type="text" name="name"  lay-verify="required|IsChineseCharacter" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">*联系电话：</label>
    <div class="layui-input-inline">
      <input id="phone" type="text" name="phone" lay-verify="required|phone" placeholder="请输入电话" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">*电子邮箱：</label>
    <div class="layui-input-inline">
      <input id="email"  type="email" name="email" lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
    </div>
  </div>

<h3>角色信息</h3>
<hr>
  <div class="layui-form-item">
    <label class="layui-form-label">选择角色：</label>
    <div class="layui-input-block" id="checkList" name="check">
    </div>
  </div>
 	<div class="layui-form-item" align="center" id="btn" >
		<button class="layui-btn" lay-filter="submitAddUser" lay-submit id="submit">立即提交</button>
		<button style="display: none" class="layui-btn" lay-filter="submitUpdate" lay-submit id="submitUpdate">提交修改</button>
		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
</div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript">
	layui.use(['form','table'], function(){
	  var form = layui.form;
	  var $ = layui.jquery;
	  var table = layui.table;
	  var array = [];//选择的角色id
	  form.on('checkbox(encrypt)', function(data){
		  if(data.elem.checked){
		  	array.push(data.value)
		  }else{
			//防止多次添加同一个元素,很鸡肋的,其实在后台控制也可以
			for(var i=0; i<array.length; i++) {
				if(array[i] == data.value){
					array.splice(i, 1);
					break;
				}
			}
		  }
		}); 
	  $('#resetPasssword').on('click',function(){
		    layer.confirm('确认重置密码?', function(index){
			      layer.close(index);
					$.post({
						url:'<%=path%>/user/updatePassword',
						dataType:'json',
						success:function(data){
							layer.msg(data.msg,{icon: data.icon});
						}
					})
			    });
	  })
	  //添加
	  form.on('submit(submitAddUser)', function(data){
	 		 var username = $('#username').val()
	 		 var password = $('#password').val()
	 		 var name = $('#name').val()
	 		 var phone = $('#phone').val()
	 		 var email = $('#email').val()
	 		 if(array.length != 0){
		 		 $.post({
		 			 url:'<%=path%>/user/insertUser',
		 			 dataType:'json',
		 			 data:{username:username, password:password, 
		 				 name:name,phone:phone, email:email,
		 				 mark:0,roleList:array
		 			 },
		 			 success:function(data){
		 				 if(data.state == 'success'){
		 					layer.msg(data.msg,{icon: 1});
		 				 }else if(data.state == 'exist'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }else if(data.state == 'error'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }
		 			 }
		 		 })
	 		 }else{
	 			layer.msg('请选择该用户权限',{icon: 2});
	 		 }
	  })
	  //修改
	  form.on('submit(submitUpdate)', function(data){
		     var username = $('#username').val()
	 		 var password = $('#password').val()
	 		 var name = $('#name').val()
	 		 var phone = $('#phone').val()
	 		 var email = $('#email').val()
	 		 if(array.length != 0){
		 		 $.post({
		 			 url:'<%=path%>/user/updateUser',
		 			 dataType:'json',
		 			 data:{userUsername:username,userPassword:password, 
		 				 userName:name,userPhone:phone, userEmail:email,
		 				 roleList:array
		 			 },
		 			 success:function(data){
		 				 if(data.state == 'success'){
		 					layer.msg(data.msg,{icon: 1});
		 				 }else if(data.state == 'exist'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }else if(data.state == 'error'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }
		 			 }
		 		 }) 
	 		 }else{
	 			layer.msg('请选择该用户权限',{icon: 2});
	 		 }
	  })
	  $.post({//获取角色列表
		  url:'<%=path %>/role/roleList.json',
		  dataType:'json',
		  success:function(data){
			  var list = "";
			  $.each(data.data,function(i,item){
				  list +='<input type="checkbox" name="check" lay-filter="encrypt" title="'+item.roleName+'" value ="'+item.roleId+'">';
				  $('#checkList').html(list)
			  })
			  form.render('checkbox');
		  }
	  })
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
	});
</script>
</body>
</html>