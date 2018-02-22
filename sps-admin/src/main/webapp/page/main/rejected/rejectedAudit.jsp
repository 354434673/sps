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
<title>退货管理</title>
<!-- 退货审核 -->
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
		<div class="layui-form layui-form-pane" >
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
				    <label class="layui-form-label">流程状态</label>
				    <div class="layui-input-inline">
				      <select name="flag" lay-filter="flag" id="flag">
				      <option value="14,15,16" selected="selected">全部</option>
				        <option value="14">待审核</option>
				        <option value="16">审核通过</option>
				        <option value="15">审核不通过</option>
				      </select>
				    </div>
				  </div>
			    	<button class="layui-btn layui-btn-primary" id="queryOrders">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
	       
		<table id="orderList" lay-filter="orderTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/html" id="bar">
{{#  if(d.flag == 15||d.flag == 16){ }}
  <a class="layui-btn layui-btn-mini" lay-event="audit" id="audit">审核</a>
{{#  } }} 
  <a class="layui-btn layui-btn-mini" lay-event="detail" id="detail">详情</a>
</script>
<script type="text/html" id="date">
{{#  
   var da = d.createtime;
    da = new Date(da);
    var year = da.getFullYear();
    var month = da.getMonth()+1;
    var date = da.getDate();
  var fn = function(){
    return [year,month,date].join('-');
  }; 
}}
{{ fn() }}
</script>
<script type="text/html" id="state">
{{#  if(d.flag == 14){ }}
  待审核
{{#  } else if(d.flag == 16){ }}
  审核通过
{{#  } else if(d.flag == 15){ }}
  审核不通过
{{#  } }} 
</script>
	<script>
		layui.use(['laydate','table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var laydate = layui.laydate;
			  var $ = layui.jquery;
				//执行一个laydate实例
				  laydate.render({
				    elem: '#startTime', //指定元素
				    type:'datetime'
				  });
				  //执行一个laydate实例
				  laydate.render({
				    elem: '#endTime', //指定元素
				    type:'datetime'
				  }); 
			  table.render({
			    elem: '#orderList'
			    ,url: '<%=path%>/order/show.json' //数据接口
			    ,where:{flag:'14,15,16'} 
			    ,id:'orderToBeRejected'
			    ,page:true
			    ,cols: [[ //表头
			       {title: '序号', align:'center',type:'numbers'} 
	 			  ,{field: 'orderid', title: '订单编号', align:'center',sort:true}
			      ,{field: 'name', title: '店主名称', align:'center'}
			      ,{field: 'selfname', title: '店铺名称', align:'center'}
			      ,{field: 'shopkeepername', title: '核心商户名称', align:'center'}
			      ,{field: 'createtime', title: '退货申请日期', templet:'#date', width:230, align:'center'}
			      ,{field: 'flag', title: '流程状态', templet:'#state', width:230, align:'center'}
			      ,{field: 'tool', title: '操作', width:180,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  
			  //查询
			  $('#queryOrders').on('click',function(){
				  var name = $('#name').val();
				  var selfname = $('#selfname').val();
				  var orderid = $('#orderid').val();
				  var startTime = $('#startTime').val();
				  var endTime = $('#endTime').val();
				  var flag=$('#flag').val();
				  //待确认的退货申请，flag未确定
				  table.reload('orderToBeRejected', {
					  page:{
						  curr:1//重新从第一页开始
					  },
					  where: {name:name,selfname:selfname,orderid:orderid,startTime:startTime,endTime:endTime, flag:flag}
					});
			  })
			  //重置
			  $('#resetInput').on('click',function(){
				  $('input').val('');
				  $('select').val('14,15,16');
			  });
			  //监听工作条
			 table.on('tool(orderTables)', function(obj){
					 var data = obj.data,  //获得当前行数据
					 layEvent = obj.event; //获得 lay-event 对应的值
					 if(layEvent=='detail'){//详情
						   window.location.href="<%=path%>/page/main/rejected/toAudit.jsp?orderid="+data.orderid; 
					 }else if(layEvent=='audit'){//审核
						   window.location.href="<%=path%>/page/main/rejected/toAudit.jsp?isQuery=1&orderid="+data.orderid; 
					 }
				});
			});
	</script>
	
</body>
</html>