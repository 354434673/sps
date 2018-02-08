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
<!-- 待发货订单 -->
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
				      <input id="time" readonly="" type="text" name="startTime"  lay-verify="" placeholder="选择范围 " autocomplete="off" class="layui-input">
				    </div>
			    </div>
			    </div>	
			    	<button class="layui-btn layui-btn-primary" id="queryOrders">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
        </div>
		<table id="orderList" lay-filter="orderTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="register" id="register">发货登记</a>
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
		layui.use(['table','laypage','layer','laydate'], function(){
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
			    ,where:{flag:6}
			    ,id:'orderToBeDelivery'
			    ,page:true
			    ,cols: [[ //表头
		              {field: 'orderid', title: '订单编号', align:'center',sort:true}
				      ,{field: 'name', title: '店主名称', align:'center'}
				      ,{field: 'selfname', title: '店铺名称', align:'center'}
				      ,{field: 'money', title: '订单金额',align:'center'}
				      ,{field: 'servicemoney', title: '代销服务费',align:'center'}
				      ,{field: 'sumMoney',  title: '实销金额',align:'center'}
				      ,{field: 'createtime', title: '订单申请日期',templet:'#date',width:230, align:'center'}
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
				  if(startTime==''||startTime==null){
					  endTime='';
				  }
				  
				  var flag=6;
				  table.reload('orderToBeDelivery', {
					  page:{
						  curr:1//重新从第一页开始
					  },
					  where: {name:name,orderid:orderid,startTime:startTime,endTime:endTime,flag:flag}
					});
			  })
			  //重置
			  $('#resetInput').on('click',function(){
				  $('input').val('');
				  $('#time').val('');
			  })
			  //监听工作条
			 table.on('tool(orderTables)', function(obj){
					 var data = obj.data,  //获得当前行数据
					 layEvent = obj.event; //获得 lay-event 对应的值
					 if(layEvent=='register'){//发货登记
						 window.location.href="<%=path%>/page/main/order/register.jsp?orderid="+data.orderid;
					 }else if(layEvent=='detail'){//详情
						 window.location.href="<%=path%>/page/main/order/detail.jsp?orderid="+data.orderid;
					 }else if(layEvent=='print'){
						 /* layer.msg('print'); */
						 window.location.href="<%=path%>/page/main/order/print.jsp?orderid="+data.orderid;
					 } 
					 //console.log(data)
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