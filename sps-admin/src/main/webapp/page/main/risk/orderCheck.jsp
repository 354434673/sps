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
<title>订单审核</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
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
			    <label class="layui-form-label" style="width: 150px">核心商户名称:</label>
			    <div class="layui-input-inline">
			      <input id="channelName" type="text" name="channelName"  lay-verify="" placeholder="请输入核心商户名称" autocomplete="off" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
			     <div class="layui-inline">
				     <label class="layui-form-label">申请日期:</label>
					    <div class="layui-input-inline">
					      <input id="time" readonly="" type="text" name="time"  lay-verify="" placeholder="选择范围" autocomplete="off" class="layui-input">
					    </div>
				</div>
			</div> 
			<div class="layui-form-item">
				    <label class="layui-form-label">流程状态</label>
				    <div class="layui-input-inline">
				      <select name="flag" lay-filter="flag" id="flag">
				        <option value="3,4,18" selected="selected">全部</option>
				        <option value="3">待审核</option>
				        <option value="18">审核通过</option>
				        <option value="4">审核不通过</option>
				      </select>
				    </div>
				  </div>
			    	<button class="layui-btn layui-btn-primary" id="queryOrders">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
	       
		<table id="orderList" lay-filter="orderTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
<script type="text/html" id="bar">
{{#  if(d.flag == 18){ }}
<a class="layui-btn layui-btn-mini" lay-event="query" id="query">查看</a>
{{#  } else if(d.flag == 4){ }}
<a class="layui-btn layui-btn-mini" lay-event="query" id="query">查看</a>
{{#  } else { }}
  <a class="layui-btn layui-btn-mini" lay-event="audit" id="audit">审核</a>
 <a class="layui-btn layui-btn-mini" lay-event="query" id="query">查看</a>
  {{#  } }} 
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
{{#  if(d.flag == 3){ }}
待审核
{{#  } else if(d.flag == 18){ }}
审核通过
{{#  } else if(d.flag == 4){ }}
审核不通过
{{#  } else { }}
  {{d.flag}}
{{#  } }}  
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
			    ,where:{flag:'3,4,18'}
			    ,id:'orderToBeAudit'
			    ,page:true
			    ,cols: [[ //表头
			      {title: '序号', type:'numbers',width:70,align:'center',sort:true}
			      ,{field: 'orderid', title: '订单编号',align:'center',sort:true}
			      ,{field: 'name', title: '店主名称',align:'center'}
			      ,{field: 'shopkeeper', title: '核心商户名称',align:'center'}
			      ,{field: 'money', title: '订单金额',align:'center'}
			      ,{field: 'payment', title: '订单首付',align:'center'}
			      ,{field: 'sumMoney',  title: '店付金额',align:'center'}
			      ,{field: 'createtime', title: '订单申请日期',templet:'#date', width:230, align:'center'}
			      ,{field: 'flag', title: '订单状态',align:'center',templet:'#state'}
			      ,{field: 'tool', title: '操作', width:210,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  
			  //查询
			  $('#queryOrders').on('click',function(){
				  var date= $('#time').val().split('至')
			  	  var name = $('#name').val();
			  	  var channelName = $('#channelName').val();
				  var orderid = $('#orderid').val();
				  var startTime = date[0];
				  var endTime = date[1];
				  var flag=$('#flag').val();
				  if(flag == ''){
					  flag = '1'
				  }
				  if(orderid.length>50){
					  layer.msg('订单编号字数不能超过50字',{icon: 2});
				  }else if(name.length>50){
					  layer.msg('字数不能超过50字',{icon: 2});
				  }else{
					  table.reload('orderToBeAudit', {
						  page:{
							  curr:1//重新从第一页开始
						  },
						  where: {name:name,orderid:orderid,startTime:startTime,endTime:endTime,flag:flag,channelName:channelName}
						});
				  }
			  })
			  //重置
			  $('#resetInput').on('click',function(){
				  $('input').val('');
				  $('select').val('3,4,18');
			  });
			  //监听工作条
			 table.on('tool(orderTables)', function(obj){
					 var data = obj.data,  //获得当前行数据
					 layEvent = obj.event; //获得 lay-event 对应的值
					 if(layEvent=='audit'){//审核
						   window.location.href="<%=path%>/page/main/order/audit.jsp?isQuery=1&orderid="+data.orderid; 
					 }else if(layEvent=='query'){//查看
						 window.location.href="<%=path%>/page/main/order/audit.jsp?orderid="+data.orderid;
					 } 
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