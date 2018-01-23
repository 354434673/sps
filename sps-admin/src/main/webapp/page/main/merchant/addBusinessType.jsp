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
	href="/sps-admin/page/static/plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet"
	href="/sps-admin/page/static/css/style.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
<div >
	<div class="layui-form " >
		<div class="layui-form-item" >
		  		<div id="layui-xtree-demo1" style=""></div>
		</div>
</div>
<script type="text/javascript"
		src="/sps-admin/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript"
		src="/sps-admin/page/static/js/layui-xtree2.js"></script>
<script type="text/javascript">
	 var ids = [];
	 var children = [];
	 var xtree ;
	layui.use(['form','layer'], function(){
	 var form = layui.form;
	 var $ = layui.jquery;
	 var layer = layui.layer;
	 var json ;
	 console.log(window.parent.businessProductArray)
	 ids = window.parent.businessProductArray;
	 //获得树json
    $.post({
		url:'<%=path%>/category/getChildrenCategorys',
		data:{ids:ids.toString()},
		dataType:'json',
		async:false,//同步,赋值给json,否则会找不到
		success:function(data){
			json= eval(data);
		}
	})  
      //创建tree
      xtree = new layuiXtree({
          elem: 'layui-xtree-demo1' //放xtree的容器（必填）
           , form: form              //layui form对象 （必填）
           , data: json            //数据，结构请参照下面 （必填）
           , isopen: false            //初次加载时全部展开，默认true （选填）
           , color: "#000"           //图标颜色 （选填）
           , icon: {                 //图标样式 （选填）
               open: "&#xe7a0;"      //节点打开的图标
               , close: "&#xe622;"   //节点关闭的图标
               , end: "&#xe621;"     //末尾节点的图标
           }
      });
	});
    function getCheck(){
        var oCks = xtree.GetChecked(); //获取全部选中的末级节点checkbox对象
        for (var i = 0; i < oCks.length; i++) {
      	  children.push(oCks[i].value);
        }
        return children;
    } 
</script>
</body>
</html>