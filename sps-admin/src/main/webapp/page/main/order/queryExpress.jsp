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
<title>查看物流</title>
<!-- 查看物流页面 -->
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
	    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>订单流程</legend>
		</fieldset>
<ul class="layui-timeline" id = "express">
</ul>
			<div align="center" style="padding-top: 50px">
				<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" style="width: 100px" >返回</button>
			</div>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
		<script type="text/javascript"
		src="<%=path%>/page/static/js/order.js"></script>
	<script>
		layui.use(['laydate','table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var $ = layui.jquery;
			  var orderid = getUrlParam('orderid') 
			  $.post({//获得物流信息
				  url:'<%=path%>/order/getLogisticsTrack'
				  ,dataType:'json'
				  ,data:{orderId:orderid}
				  ,success:function(data){
					  console.log(data)
					  var list = "";
					  if(data.success){
						  if(data.result.traces.length != 0){
					 		 $.each(data.result.traces,function(i,item){
								  list +='<li class="layui-timeline-item">';
								  list +='<i class="layui-icon layui-timeline-axis">&#xe63f;</i>';
								  list +='<div class="layui-timeline-content layui-text">';
								  list +='<h3 class="layui-timeline-title">'+item.acceptTime+'</h3>';
								  list +='<p>'+item.acceptStation+'</p>';
								  list +='</div>';
								  list +='</li>';
								  $('#express').html(list)
							  	})
						  }else{
							  list +='<li class="layui-timeline-item">';
							  list +='<i class="layui-icon layui-timeline-axis">&#xe63f;</i>';
							  list +='<div class="layui-timeline-content layui-text">';
							  list +='<p>该订单暂无物流信息</p>';
							  list +='</div>';
							  list +='</li>';
							  $('#express').html(list)
						  }
					  }else{
							  list +='<li class="layui-timeline-item">';
							  list +='<i class="layui-icon layui-timeline-axis">&#xe63f;</i>';
							  list +='<div class="layui-timeline-content layui-text">';
							  list +='<p>请求异常</p>';
							  list +='</div>';
							  list +='</li>';
							  $('#express').html(list)
					  }
				  }
			  })
			});
	  
	</script>
	
</body>
</html>