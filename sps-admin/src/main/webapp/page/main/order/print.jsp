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
			 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">订单编号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="orderid"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">收货人：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="name"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">联系电话：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="phone"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">收货地址：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="address"> </div>
		    </div>
		 </div>
		 <div style="margin-left: 100px;margin-right: 100px">
			<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
			</table>
			<div style="padding-top: 10px">
				总订货量：<span id="amountTotle"></span> 件
				 / 
				 订单金额：<span id="priceTotle"></span> ￥
			</div>
		 </div>
	</div>
		<div align="center" style="padding-top: 10px">
			<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-normal" >返回</button>
			<button id="agree" class="layui-btn layui-btn-warm" >导出PDF</button>
		</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
	<script>
		layui.use(['laydate','table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var $ = layui.jquery;
			  
			  $.post({//获得信息
				  url:'<%=path%>/order/showOrder.json'
				  ,dataType:'json'
				  ,data:{orderid:<%=request.getParameter("orderid")%>}
				  ,success:function(result){
					  $('#orderid').html(result.data[0].orderid)//订单编号
					  $('#name').html(result.data[0].name)//店主名称
					  $('#phone').html(result.data[0].phone)//联系电话
					  $('#address').html(result.data[0].address)//收货信息
				  }
			  })
			  $.post({//获得信息
				  url:'<%=path%>/order/showOrderGoods.json'
				  ,dataType:'json'
				  ,data:{orderid:<%=request.getParameter("orderid")%>}
				  ,success:function(result){
					  $('#amountTotle').html(result.amountTotle)
					  $('#priceTotle').html(result.priceTotle)
				  }
			  })
			  
			  table.render({
				    elem: '#orderGoodsDetail'
				    ,url: '<%=path%>/order/showOrderGoods.json'//数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>} 
				    ,id:'orderGoods'
				    ,page:true
				    ,skin:'row'
				    ,even:true
				    ,cols: [[ //表头
				       {title: '序号', type:'numbers',align:'center'} 
				      ,{field: 'sku', title: 'SKU编号', align:'center',sort:true}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '规格', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				    ,response: {
				    	  statusName: 'code' //数据状态的字段名称，默认：code
				    	  ,msgName: 'msg' //状态信息的字段名称，默认：msg
				    	  ,countName: 'count' //数据总数的字段名称，默认：count
				    	  ,dataName: 'data' //数据列表的字段名称，默认：data
				    	}  
				  });
			  //计算总订货量与总金额
		 	 	var totalAmount=0;
				$("#orderGoodsDetail tr").each(function(){
		 	 	alert(0);
					$(this).find('td:eq(4)').each(function(){
						alert($(this).text());
						totalAmount += parseFloat($(this).text());	
						$("#totalAmount").val(totalAmount);
					});
				});  
			});
	  
	</script>
	
</body>
</html>