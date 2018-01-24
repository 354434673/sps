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
<!-- 订单查询 -->
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
			    <label class="layui-form-label">核心商户名称:</label>
			    <div class="layui-input-inline">
			      <input id="orderid" type="text" name="orderid"  lay-verify="" placeholder="核心商户名称" autocomplete="off" class="layui-input">
			    </div>
			 </div>
			 <div class="layui-form-item">
			     <div class="layui-inline">
			     	<label class="layui-form-label">订单申请日期:</label>
			    	<div class="layui-input-inline">
			      		<input id="startTime" type="text" name="startTime"  lay-verify="" placeholder="起始日期 " autocomplete="off" class="layui-input">
			    	</div>
			     	<div class="layui-input-inline">
			      		<input id="endTime" type="text" name="endTime"  lay-verify="" placeholder="截止日期 " autocomplete="off" class="layui-input">
			    	</div>
			    </div>
			 </div>
			      <div class="layui-form-item">
				    <label class="layui-form-label">流程状态</label>
				    <div class="layui-input-inline">
				      <select name="flag" lay-filter="flag" id="flag">
				        <option value="" selected="selected">全部</option>
				        <option value="1">待确认</option>
				        <option value="2">已拒绝</option>
				        <option value="3">订单审核中</option>
				        <option value="4">订单审核不通过</option>
				        <option value="5">待支付</option>
				        <option value="6">待发货</option>
				        <option value="7">物流审核中</option>
				        <option value="8">物流审核不通过</option>
				        <!-- <option value="9">待还款</option> -->
				        <option value="9">已完成</option>
				        <option value="10">已退货</option>
				        <option value="11">已取消</option>
				      </select>
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
  <a class="layui-btn layui-btn-mini" lay-event="detail"  id="detail">详情</a>
  <a class="layui-btn layui-btn-mini" lay-event="express" id="express">查看物流</a>
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
<script type="text/html" id="state">
{{#  if(d.flag == 1){ }}
  待确定
{{#  } else if(d.flag == 2){ }}
  已拒绝
{{#  } else if(d.flag == 3){ }}
  订单审核中
{{#  } else if(d.flag == 4){ }}
  订单审核不通过
{{#  } else if(d.flag == 5){ }}
  待支付
{{#  } else if(d.flag == 6){ }}
  代发货
{{#  } else if(d.flag == 7){ }}
  物流审核中
{{#  } else if(d.flag == 8){ }}
  物流审核不通过
{{#  } else if(d.flag == 9){ }}
 已完成
{{#  } else if(d.flag == 10){ }}
  已退货
{{#  } else if(d.flag == 11){ }}
  已取消 
{{#  } else { }}
  {{d.flag}}
{{#  } }}  
</script>
	<script>
		layui.use(['table','laypage','layer','laydate','form'], function(){
			  var laydate = layui.laydate;
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var form = layui.form;
			  var $ = layui.jquery;
			  
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#startTime' //指定元素
			    , type:'datetime'
			    /* ,format:'yyyy-MM-dd HH:mm:ss' */
			  });
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#endTime' //指定元素
			    , type:'datetime'
			  /*   , format:'yyyy-MM-dd HH:mm:ss' */
			  });
			  table.render({
			    elem: '#orderList'
			    ,url: '<%=path%>/order/show.json' //数据接口
			    ,id:'orderOfAll'
			    ,page:true
			    ,cols: [[ //表头
		              {field: 'orderid', title: '订单编号', align:'center',sort:true}
				      ,{field: 'name', title: '店主名称', align:'center'}
				      ,{field: 'selfname', title: '店铺名称',align:'center'}
				      ,{field: 'money', title: '订单金额',align:'center'}
				      ,{field: 'servicemoney', title: '代销服务费',align:'center'}
				      ,{field: 'sumMoney',  title: '实销金额',align:'center'}
				      ,{field: 'createtime', title: '订单申请日期',templet:'#date',width:150, align:'center'}
				      ,{field: 'flag', title: '订单状态',templet:'#state',align:'center'}
				      ,{field: 'tool', title: '操作', width:200,align:'center',toolbar:'#bar'}
		    ]]
			  });
			  //查询
			  $('#queryOrders').on('click',function(){
				  var name = $ ('#name').val();
				  var orderid = $('#orderid').val();
				  var startTime = $('#startTime').val();
				  var endTime = $('#endTime').val();
				  var flag=$('#flag').val();
				  table.reload('orderOfAll', {
					  page:{
						  curr:1//重新从第一页开始
					  },
					  where: {name:name,orderid:orderid,startTime:startTime,endTime:endTime,flag:flag}
					});
			  });
			  //重置
			  $('#resetInput').on('click',function(){
				  $('input').val('');
			  });
			  //监听工作条
			 table.on('tool(orderTables)', function(obj){
					 var data = obj.data,  //获得当前行数据
					 layEvent = obj.event; //获得 lay-event 对应的值
					 if(layEvent=='detail'){//详情
						 window.location.href="<%=path%>/page/main/order/queryOfDetail.jsp?orderid="+data.orderid;
					 }else if(layEvent=='print'){//打印
						 window.location.href="<%=path%>/page/main/order/print.jsp?orderid="+data.orderid;
					 }else if(layEvent == 'express'){
						 window.location.href="<%=path%>/page/main/order/queryExpress.jsp?orderid="+data.orderid;
					 }
				});
			});
	</script>
	
</body>
</html>