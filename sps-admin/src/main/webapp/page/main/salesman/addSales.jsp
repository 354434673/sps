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
<div style="padding: 20px" >
<h3>用户信息</h3>
<hr>
<div class="layui-form layui-form-pane" >
	<div style="padding-left: 13%">
	  <div class="layui-form-item" id="passwordDiv">
	   <label class="layui-form-label">*业务员姓名：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanName" name="salesmanName" type="text"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
	    </div>
	    <label class="layui-form-label">*身份证号码：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanIdcard" name="salesmanIdcard" type="text"  lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">*手机号：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanPhone" type="text" name="salesmanPhone"  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
	    </div>
	    <label class="layui-form-label">*电子邮箱：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanEmail" type="text" name="salesmanEmail" lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
	    </div>
	  </div>
		  <div class="layui-form-item " >
		    <label class="layui-form-label" >*城市：</label>
		    <div class="layui-input-inline" style="width: 150px">
		      <select name="province" lay-filter="province"  id="province" lay-verify="required"> 
		      </select>
		    </div>
		    <div class="layui-input-inline" style="width: 150px">
		      <select name="city" lay-filter="city"   id="city" lay-verify="required"> 
				  <option value="" >市</option>
		      </select>
		    </div>
		    <div class="layui-input-inline" style="width: 150px">
		      <select name="area" lay-filter="area"   id="area" lay-verify=""> 				  
		      	  <option value="">区</option>
		      </select>
		    </div>
		  </div>
  </div>
 	<div class="layui-form-item" align="center" id="btn" style="padding-top: 40px">
		<button class="layui-btn" lay-filter="submitSalesMan" lay-submit id="submit">立即提交</button>
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
	  getProvince(100000)//先加载省
	  
	  //选择城市
	  form.on('select(province)', function(data){//选省
		  getCity(data.value)
		  $('#area').html('')
	  });    
	  form.on('select(city)', function(data){//选省
		  getArea(data.value)
	  });    
	  $('#resetPasssword').on('click',function(){
		    layer.confirm('确认重置密码?', function(index){
			      layer.close(index);
					$.post({
						url:'<%=path%>/user/updatePassword.html',
						dataType:'json',
						success:function(data){
							layer.msg(data.msg,{icon: data.icon});
						}
					})
			    });
	  })
	  //添加
	  form.on('submit(submitSalesMan)', function(data){
	 		 var salesmanName = $('#salesmanName').val()
	 		 var salesmanIdcard = $('#salesmanIdcard').val()
	 		 var salesmanPhone = $('#salesmanPhone').val()
	 		 var salesmanEmail = $('#salesmanEmail').val()
	 		 var salesmanCity = $('#province').find("option:selected").text()+
			 			 $('#city').find("option:selected").text()+
			 			$('#area').find("option:selected").text();
		 		 $.post({
		 			 url:'<%=path%>/salesman/insertSalesman',
		 			 dataType:'json',
		 			 data:{
		 			 	salesmanName:salesmanName,
		 			 	salesmanIdcard:salesmanIdcard,
		 			 	salesmanPhone:salesmanPhone,
		 			 	salesmanEmail:salesmanEmail,
		 			 	salesmanCity:salesmanCity,
		 			 	bei1:0
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
		 			 url:'<%=path%>/user/updateUser.html',
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
	  	//获得省
		 function getProvince(parentId){
			$.getJSON({
	 			 url:'/sps-admin/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'">'+item.name+'</option>';
					  $('#province').html(list)
					  getCity($('#province').val())
			 		  
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
		//获得城市
		 function getCity(parentId){
			$.getJSON({
	 			 url:'/sps-admin/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'">'+item.name+'</option>';
					  $('#city').html(list)
					  getArea($('#city').val())
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
		 
		 //获得区
		 function getArea(parentId){
			$.getJSON({
	 			 url:'/sps-admin/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'" title="'+item.name+'">'+item.name+'</option>';
					  $('#area').html(list)
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
	});
</script>
</body>
</html>