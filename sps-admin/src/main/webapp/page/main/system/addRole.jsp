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
<div style="padding: 40px" >
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
		 <div id="layui-xtree-demo1" style="width:300px;height:500px; border:1px solid black; margin:20px;"></div>
		 <div id="layui-xtree-demo2" style="width:300px;height:500px; border:1px solid black; margin:20px;"></div>
		<hr>
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
      //创建tree
      var xtree2 = new layuiXtree({
          elem: 'layui-xtree-demo2' //放xtree的容器（必填）
           , form: form2              //layui form对象 （必填）
           , data: json              //数据，结构请参照下面 （必填）
           , isopen: false            //初次加载时全部展开，默认true （选填）
           , color: "#000"           //图标颜色 （选填）
           , icon: {                 //图标样式 （选填）
               open: "&#xe7a0;"      //节点打开的图标
               , close: "&#xe622;"   //节点关闭的图标
               , end: "&#xe621;"     //末尾节点的图标
           }
      });
	});
</script>
</body>
</html>