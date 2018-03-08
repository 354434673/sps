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
<title>收款信息添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
<div >
        <fieldset class="layui-elem-field layui-field-title">
 			<legend>店主信息</legend>
		</fieldset>
		<div class="layui-form">
				  <div class="layui-form-item">
				    <label class="layui-form-label" style="width: 150px">*店主名称：</label>
				    <div class="layui-input-inline">
				      <input id="name" type="text" name="name"  lay-verify="required|IsChineseCharacter" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label" style="width: 150px">*联系电话：</label>
				    <div class="layui-input-inline">
				      <input id="phone" type="phone" name="gatherBankId"  lay-verify="required|isPhone" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				   	<div class="layui-form-item" align="center" id="btn" style="padding-top: 10px">
						<button class="layui-btn layui-btn-primary" id="close">返回</button>
						<button class="layui-btn layui-btn-primary" lay-submit  lay-filter="submit"  id="submit">扫码邀请</button>
					</div>
					</div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
<script type="text/javascript">
	  var gatherListJson = []
	layui.use(['form','table','element'], function(){
	  var form = layui.form;
	  var $ = layui.jquery;
	  var element = layui.element;
	  var index = 1;
  	  form.on('submit(submit)', function(data){
			 var name = $('#name').val()
			 var phone = $('#phone').val()
			 	$.post({
		 			 url:'<%=path%>/shopkeeper/insertInvitation',
		 			 dataType:'json',
		 			 data:{
		 				invitationName:name, 
		 				invitationPhone:phone, 
		 			 },
		 			 success:function(data){
		 				 //data.result 返回生成的客户编号
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
	  //自定义验证规则  
	  form.verify({  
			//验证只包含汉字  
			IsChineseCharacter: function(value) {
				var regex = /^[\u4e00-\u9fa5]+$/;
				if(!value.match(regex)) {
					return '请输入正确的姓名';
				}
			},			
			isPhone: function(value) {
				var regex = /^1[3|4|5|8][0-9]\d{4,8}$/;
				if(!value.match(regex)) {
					return '手机号格式不正确!';
				}
			},
	  });  
	});
</script>
</body>
</html>