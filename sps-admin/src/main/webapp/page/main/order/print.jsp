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
<!-- 面单打印页面 -->
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
		<table id="orderBasic" lay-filter="orderBasic">
		</table>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
		<div>
			总订货量：<input id="totalAmount" readonly="readonly" text="text">
			订单金额：<input id="totalSummation" readonly="readonly" text="text">
		</div>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
		<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
</script>
	<script>
		layui.use(['laydate','table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var $ = layui.jquery;
			  
				table.render({
				    elem: '#orderBasic'
				    ,height: 230
				    ,url: '<%=path%>/order/showOrder.json' //数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>} 
			        ,id:'orderBasic' 
			        /* ,page:true */
				    ,cols: 
 					 [[ //表头
 				      {field: 'orderid', title: '订单编号',align:'center'},
 				      {field: 'money', title: '订单金额',align:'center'},
 				      {field: 'servicescale', title: '代销服务费率',align:'center'},
 				      {field: 'servicemoney', title: '代销服务费',align:'center'},
 				      {field: 'sumMoney', title: '实销金额',align:'center'},
 				      {field: 'unit', title: '单位',align:'center'},
 				      {field: 'createtime', title: '订单申请日期', align:'center'},
 				      {field: 'name', title: '店主名称' ,align:'center'},
 				      {field: 'phone', title: '联系电话',align:'center'},
 				      {field: 'selfname', title: '店铺名称', align:'center'},
 				      {field: 'address', title: '收货信息',align:'center'}
 				      ]]    
				  });
			  
			  table.render({
				    elem: '#orderGoodsDetail'
				    ,height: 500
				    ,url: '<%=path%>/order/showOrderGoods.json'//数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>} 
				    ,id:'orderGoods'
				    ,page:true
				    ,cols: [[ //表头
				       {title: '序号', align:'center',templet:'#indexTpl'} 
				      ,{field: 'sku', title: 'SKU编号', align:'center',sort:true}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '规格', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				  });
			  
			  //计算总订货量与总金额
			 //$("#totalAmount").val(10);
		 	 	var totalAmount=0;
				$("#orderGoodsDetail tr").each(function(){
		 	 	alert(0);
					$(this).find('td:eq(4)').each(function(){
						alert($(this).text());
						totalAmount += parseFloat($(this).text());	
						$("#totalAmount").val(totalAmount);
					});
				});  
			  
			//需要引入jquery.PrintArea.js才可以使用
			/*  $(function(){
				 $("").click(){
					$().printArea(); 
				 }
			 }); */
				
			});
	  
	</script>
	
</body>
</html>