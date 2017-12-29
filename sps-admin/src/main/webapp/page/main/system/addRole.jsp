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
<link rel="stylesheet"
	href="<%=path%>/page/static/css/style.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
<div style="padding: 40px" >
	<h3>角色添加</h3>
	<hr>
		<div class="layui-form " >
		  <div class="layui-form-item ">
		    <label class="layui-form-label">*角色：</label>
		    <div class="layui-input-inline">
		      <input id="roleName"type="text" name="roleName"  lay-verify="required" placeholder="角色名称" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">*角色描述：</label>
		    <div class="layui-input-inline" style="width: 400px">
				<textarea id="roleDescribe" name="roleDescribe" lay-verify="required|MaxLength" placeholder="请输入" class="layui-textarea"></textarea>
		    </div>
		  </div>
		
		<h3>权限分配</h3>
		<hr>
	<div class="layui-form-item">
		<div class="ty-transfer mt20 ml20" id="ued-transfer-1">
		    <div class="fl ty-transfer-list transfer-list-left" >
		        <div class="ty-transfer-list-head " >
		           	 权限菜单列表
		        </div>
		         <div class="ty-transfer-list-body" style="overflow: auto; overflow-y: scroll;">
		  		<div id="layui-xtree-demo1" style=""></div>
		  		</div>
		    </div>
		    <!-- 箭头 -->
		    <div class="fl ty-transfer-operation">
		        <span class="ty-transfer-btn-toright to-switch">
		        </span>
		        <span class="ty-transfer-btn-toleft to-switch">
		        </span>
		    </div>
		    <div class="fl ty-transfer-list transfer-list-right">
		        <div class="ty-transfer-list-head">
		     		   已选择的菜单权限
		        </div>
		        <div class="ty-transfer-list-body" style="overflow: auto; overflow-y: scroll;">
		        	<ul>
		        		<li>111
		        		<li>111
		        		<li>111
		        		<li>111
		        		
		        	</ul>
		        </div>
		    </div>
		</div>
		</div>
	 	<div class="layui-form-item" align="center">
		<button class="layui-btn" lay-filter="submitAddRole" lay-submit id="submit">立即提交</button>
		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript"
		src="<%=path%>/page/static/js/layui-xtree.js"></script>
<script type="text/javascript">
	layui.use('form', function(){
	 var form = layui.form;
	 var form2 = layui.form;
	 var $ = layui.jquery;
	 var json;
	$.post({
		url:'/sps-admin/menu/getMenu.json',
		dataType:'json',
		async:false,//同步,赋值给json,否则会找不到
		success:function(data){
			json= data
		}
	})
	form.on('submit(submitAddRole)', function(data){
	 		 var roleName = $('#roleName').val();//角色名称
	 		 var roleDescribe = $('#roleDescribe').val();//角色描述
		 		 $.post({
		 			 url:'<%=path%>/role/insertRole.html',
		 			 dataType:'json',
		 			 data:{roleName:roleName, describe:roleDescribe},
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
      //创建tree
      var xtree1 = new layuiXtree({
          elem: 'layui-xtree-demo1' //放xtree的容器（必填）
           , form: form              //layui form对象 （必填）
           , data: json              //数据，结构请参照下面 （必填）
           , isopen: false            //初次加载时全部展开，默认true （选填）
           , color: "#000"           //图标颜色 （选填）
           , icon: {                 //图标样式 （选填）
               open: "&#xe7a0;"      //节点打开的图标
               , close: "&#xe622;"   //节点关闭的图标
               , end: "&#xe621;"     //末尾节点的图标
           }
      });
	  //自定义验证规则  
	  form.verify({  
			MaxLength: function(value) {
				if(value.length>100) {
					return '最多为100个字';
				}
			},
	  });  
	});
</script>
</body>
</html>