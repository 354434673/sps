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
<title>订单管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
<style type="text/css">
	tr th{
		text-align: center;
	}
</style>
</head>
<body>
	<div style="margin: 15px;">
		<div class="layui-form layui-form-pane"  >
		    <div class="layui-form-item">
			    <label class="layui-form-label">店主名称:</label>
			    <div class="layui-input-inline">
			      <input id="name" type="text" name="name"  lay-verify="" placeholder="请输入店主名称" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label">订单编号:</label>
			    <div class="layui-input-inline">
			      <input id="orderid" type="text" name="orderid"  lay-verify="" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
			    </div>
			     <label class="layui-form-label">订单申请日期:</label>
			    <div class="layui-input-inline">
			      <input id="startTime" type="text" name="startTime"  lay-verify="" placeholder="起始日期 " autocomplete="off" class="layui-input">
			    </div>
			     <div class="layui-input-inline">
			      <input id="endTime" type="text" name="endTime"  lay-verify="" placeholder="截止日期 " autocomplete="off" class="layui-input">
			    </div>
			    	<button class="layui-btn layui-btn-primary" id="queryOrders">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
	        </div>  
        </div>
		<table id="orderList" lay-filter="orderTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="register" id="register">发货登记</a>
  <a class="layui-btn layui-btn-mini" lay-event="detail"  id="detail">详情</a>
  <a class="layui-btn layui-btn-mini" lay-event="print" id="print">打印</a>
</script>
	<script>
		layui.use(['table','laypage','layer','laydate'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var laydate = layui.laydate;
			  var $ = layui.jquery;
			  
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#startT	ime' //指定元素
			    , type:'datetime'
			   /*  , format:'yyyy-MM-dd HH:mm:ss' */
			  });
			
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#endTime' //指定元素
			    , type:'datetime'
			   /*  ,format:'yyyy-MM-dd HH:mm:ss' */
			  });
			  
			  table.render({
			    elem: '#orderList'
			    ,height: 350
			    ,url: '<%=path%>/order/show.json?flag=2' //数据接口
			    ,id:'orderToBeDelivery'
			    ,page:true
			    ,cols: [[ //表头
		              {field: 'orderid', title: '订单编号', align:'center'}
				      ,{field: 'name', title: '店主名称', align:'center'}
				      ,{field: 'selfname', title: '店铺名称', align:'center'}
				      ,{field: 'money', title: '订单金额',align:'center'}
				      ,{field: 'servicemoney', title: '代销服务费',align:'center'}
				      ,{field: 'sumMoney',  title: '实销金额',align:'center'}
				      ,{field: 'createtime', title: '订单申请日期', format:'yyyy-MM-dd HH:mm:ss', width:230, align:'center'}
				      ,{field: 'tool', title: '操作', width:270,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  //查询
			  $('#queryOrders').on('click',function(){
				  var name = $('#name').val();
				  var orderid = $('#orderid').val();
				  var startTime = $('#startTime').val();
				  var endTime = $('#endTime').val();
				  var flag=2;
				  table.reload('orderToBeDelivery', {
					  where: {name:name,orderid:orderid,startTime:startTime,endTime:endTime,flag:flag}
					});
			  })
			  //重置
			  $('#resetInput').on('click',function(){
				  $('#name').val('');
				  $('#orderid').val('');
				  $('#startTime').val('');
				  $('#endTime').val('');
			  })
			  //监听工作条
			 table.on('tool(orderTables)', function(obj){
					 var data = obj.data,  //获得当前行数据
					 layEvent = obj.event; //获得 lay-event 对应的值
					 if(layEvent=='register'){//发货登记
						 layer.alert('发货登记：<br>'+ JSON.stringify(data));
					 }else if(layEvent=='detail'){//详情
						 /* layer.alert('详情：<br>'+ JSON.stringify(data)); */
						 window.location.href="<%=path%>/page/main/order/confimed.jsp";
					 }else if(layEvent=='print'){
						 layer.msg('print');
					 } 
					 console.log(data)
				});
			});
	</script>
	
</body>
</html>