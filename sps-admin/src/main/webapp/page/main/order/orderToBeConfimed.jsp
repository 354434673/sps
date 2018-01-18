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
			</div>
			<div class="layui-form-item">
			     <div class="layui-inline">
				     <label class="layui-form-label">订单申请日期:</label>
					    <div class="layui-input-inline">
					      <input id="startTime" type="text" name="startTime"  lay-verify="" placeholder="起始日期" autocomplete="off" class="layui-input">
					    </div>
					     <div class="layui-input-inline">
					     <input id="endTime" type="text" name="endTime"  lay-verify="" placeholder="截止日期" autocomplete="off" class="layui-input">
				    	</div>
				</div>
			</div> 
			    	<button class="layui-btn layui-btn-primary" id="queryOrders">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
	       
		<table id="orderList" lay-filter="orderTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="confirm" id="confirm">去确认</a>
  <a class="layui-btn layui-btn-mini" lay-event="detail"  id="detail">详情</a>
  <a class="layui-btn layui-btn-mini" lay-event="print" id="print">打印</a>
</script>
	<script>
		layui.use(['laydate','table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var laydate = layui.laydate;
			  var $ = layui.jquery;
			 /*  
			  var options={
					 min: '2010-01-01 00:00:00',
		             max: '2099-06-16 23:59:59',
		             event : 'click',
		             istoday: false 
			  };
			  
			  document.getElementById("startTime").onclick=function(){
				  opitons.elem=this;
				  options.format="yyyy-MM-dd HH:mm:ss";
				  laydate(options);
			  }
			  document.getElementById("endTime").onclick=function(){
				  opitons.elem=this;
				  options.format="yyyy-MM-dd HH:mm:ss";
				  laydate(options);
			  } */
			  
				//执行一个laydate实例
				  laydate.render({
				    elem: '#startTime', //指定元素
				  /*   event:'click',//触发事件 */
				    type:'datetime'
				  /*   ,format:'yyyy-MM-dd HH:mm:ss' */
				  });
				
				  //执行一个laydate实例
				  laydate.render({
				    elem: '#endTime', //指定元素
				  /*   event:'click',//触发事件 */
				    type:'datetime'/* ,
				    format:'yyyy-MM-dd HH:mm:ss' */
				  }); 
			  
			  table.render({
			    elem: '#orderList'
			    ,height: 500
			    ,url: '<%=path%>/order/show.json' //数据接口
			    ,where:{flag:1} 
			    ,id:'orderToBeConfirmed'
			    ,page:true
			    ,cols: [[ //表头
			      {field: 'orderid', title: '订单编号', align:'center',sort:true}
			      ,{field: 'name', title: '店主名称', align:'center'}
			      ,{field: 'selfname', title: '店铺名称', align:'center'}
			      ,{field: 'money', title: '订单金额',align:'center'}
			      ,{field: 'servicemoney', title: '代销服务费',align:'center'}
			      ,{field: 'sumMoney',  title: '实销金额',align:'center'}
			      ,{field: 'createtime', title: '订单申请日期', type:'datetime', width:230, align:'center'}
			      ,{field: 'tool', title: '操作', width:270,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  
			  //查询
			  $('#queryOrders').on('click',function(){
				  var name = $('#name').val();
				  var orderid = $('#orderid').val();
				  var startTime = $('#startTime').val();
				  var endTime = $('#endTime').val();
				  var flag=1;//待确认订单1，已拒绝2，订单审核中3，订单审核不通过4，待签约5，待发货6......默认如果不输入的话查询全部
				  table.reload('orderToBeConfirmed', {
					  page:{
						  curr:1//重新从第一页开始
					  },
					  where: {name:name,orderid:orderid,startTime:startTime,endTime:endTime,flag:flag}
					});
			  })
			  //重置
			  $('#resetInput').on('click',function(){
				  $('#name').val('');
				  $('#orderid').val('');
				  $('#startTime').val('');
				  $('#endTime').val('');
			  });
			  //监听工作条
			 table.on('tool(orderTables)', function(obj){
					 var data = obj.data,  //获得当前行数据
					 layEvent = obj.event; //获得 lay-event 对应的值
					 if(layEvent=='confirm'){//确认
						/*  layer.msg('确认'); */
						 //layer.alert('确认：<br>'+ JSON.stringify(data)); 
						<%-- window.location.href='<%=path%>/order/showOrderGoods='+data.orderid;   --%>
						<%-- window.location.href='<%=path%>/order/showSingle.json?orderid='+data.orderid; --%>
						   /* layer.msg(data.orderid); */
						   window.location.href="<%=path%>/page/main/order/confimed.jsp?orderid="+data.orderid; 
					 }else if(layEvent=='detail'){//详情
						 /* layer.msg('详情');  */
						  window.location.href="<%=path%>/page/main/order/detail.jsp?orderid="+data.orderid;
						<%--  window.location.href='<%=path%>/order/showOrderGoods.json?orderid='+data.orderid; --%>
						 /* layer.alert('详情：<br>'+ JSON.stringify(data)+"<br>"+"orderid:"+data.orderid) */
					 }else if(layEvent=='print'){
						/*  layer.msg('print'); */	
						 /* layer.alert('打印：<br>'+ JSON.stringify(data)) */
						 window.location.href="<%=path%>/page/main/order/print.jsp?orderid="+data.orderid;
					 } 
					 //console.log(data);
				});
			});
	</script>
	
</body>
</html>