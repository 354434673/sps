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
<title>物流信息</title>
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
	<div style="margin: 15px;">
		<div class="layui-form layui-form-pane"  >
		    <div class="layui-form-item">
			    <label class="layui-form-label" style="width: 200px">物流公司:</label>
			    <div class="layui-input-inline">
			      <input id="name" type="text" name="name"  lay-verify="" placeholder="物流公司" autocomplete="off" class="layui-input">
			    </div>
			    	<button class="layui-btn layui-btn-primary" id="queryName">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
	        </div>  
        </div>
		<table id="expressList" lay-filter="expressTables" class="layui-fluid"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<!-- 进行数据渲染 -->
<script type="text/html" id="channelTpl">
</script>
<script type="text/html" id="select">
<a class="layui-btn layui-btn-mini" lay-event="check">选择</a>
</script>
	<script>
	var expressIds = [];
	//var data = $(layero).find("iframe")[0].contentWindow.expressIds;父窗口获取参数
	layui.use(['table','layer','form'], function(){
			  var table = layui.table;
			  var layer = layui.layer
			  var form = layui.form
			  var $ = layui.jquery
			  table.render({
			    elem: '#expressList'
			    ,url: '<%=path%>/express/getExpressList.json' //数据接口
			    ,id:'express'
			    ,page:true
			    ,cols: [[ //表头
			      {type:'numbers',title: '序号',width:90,align:'center'}
			      ,{field: 'name', title: '物流公司',align:'center'}
			      ,{field: 'select', title: '选择',width:160,align:'center',toolbar:'#select'}
			    ]]
			  });
			  //查询
			  $('#queryName').on('click',function(){
				  var name = $('#name').val()
				  table.reload('express', {
					  where: {name:name}
					});
			  })
			  //重置
			  $('#reset').on('click',function(){
				  $('input').val('')
			  })
			  table.on('tool(expressTables)', function(obj){
				  var data = obj.data;
				  console.log(obj)
				  expressIds = data;
/* 				  if(obj.checked){
					  expressIds.push(obj.data.name)
					  console.log(expressIds)
				  }else{
						for(var i=0; i<expressIds.length; i++) {
							if(expressIds[i] == obj.data.name){
								expressIds.splice(i, 1);
								break;
							}
						}
				  } */
				}); 
			});
	</script>
</body>
</html>