<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<!-- 待确认订单 -->
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
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
				     <label class="layui-form-label">申请日期:</label>
					    <div class="layui-input-inline">
					      <input id="time" readonly="" type="text" name="startTime"  lay-verify="" placeholder="选择范围" autocomplete="off" class="layui-input">
					    </div>
				</div>
			</div> 
			    	<button class="layui-btn layui-btn-primary" id="queryOrders">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
	       
		<table id="orderList" lay-filter="orderTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="confirm" id="confirm">去确认</a>
  <a class="layui-btn layui-btn-mini" lay-event="print" id="print">面单打印</a>
</script>
<script type="text/html" id="date">
{{#  
   var da = d.createtime;
    da = new Date(da);
    var year = da.getFullYear();
    var month = da.getMonth()+1;
    var date = da.getDate();
    console.log([year,month,date].join('-'));
  var fn = function(){
    return [year,month,date].join('-');
  }; 
}}
{{ fn() }}
</script>
	<script>
		layui.use(['laydate','table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var laydate = layui.laydate;
			  var $ = layui.jquery;
			  var newDate = new Date().setDate(new Date().getDate() - 60)//60天以前的日期
				//执行一个laydate实例
				  laydate.render({
				    elem: '#time', //指定元素
				    type:'date',
				    range: '至',
				    min: getDate(newDate),
				    max: getDate()
				  });
			  table.render({
			    elem: '#orderList'
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
			      ,{field: 'createtime', title: '订单申请日期', templet:'#date',width:230, align:'center'}
			      ,{field: 'tool', title: '操作', width:220,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  
			  //查询
			  $('#queryOrders').on('click',function(){
				  var date= $('#time').val().split('至')
			  	  var name = $('#name').val();
				  var orderid = $('#orderid').val();
				  var startTime = date[0];
				  var endTime = date[1];
				  var flag=1;//待确认订单1，已拒绝2，订单审核中3，订单审核不通过4，待签约5，待发货6......默认如果不输入的话查询全部
				  if(name.length>50){
					  layer.msg('字数不能超过50字',{icon: 2});
				  }else{
					  table.reload('orderToBeConfirmed', {
						  page:{
							  curr:1//重新从第一页开始
						  },
						  where: {name:name,orderid:orderid,startTime:startTime,endTime:endTime,flag:flag}
						});
				  }
			  })
			  //重置
			  $('#resetInput').on('click',function(){
				  $('input').val('');

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
			  //时间格式化
			  function getDate(data){
				  	if(data == null || data == ""){
					    da = new Date();
				  	}else{
				  		 da = new Date(data);
				  	}
				    var year = da.getFullYear();
				    var month = da.getMonth()+1;
				    var date = da.getDate();
				    return [year,month,date].join('-');
			  }
			});
	</script>
	
</body>
</html>