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
<!-- 详情页面 -->
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
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>基本信息</legend>
		</fieldset>
		<table id="orderBasic" lay-filter="orderBasic">
		</table>
      	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品列表</legend>
		</fieldset>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
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
				 /*    ,page:true */
				    ,cols: /* [
				      [ //表头
				      {field: 'orderid', title: '订单编号', width:250,align:'center'}
				      ],
				      [{field: 'money', title: '订单金额',width:250,align:'center'}
				      ],
				      [{field: 'servicescale', title: '代销服务费率',width:250,align:'center'}
				      ],
				      [{field: 'servicemoney', title: '代销服务费',width:250,align:'center'}
				      ],
				      [{field: 'sumMoney', title: '实销金额',width:250,align:'center'}
				      ],
				      [{field: 'unit', title: '单位',width:250,align:'center'}
				      ],
				      [{field: 'createtime', title: '订单申请日期', width:250, align:'center'}
				      ],
				      [{field: 'name', title: '店主名称',width:250, align:'center'}
				      ],
				      [{field: 'phone', title: '联系电话',width:250,align:'center'}
				      ],
				      [{field: 'selfname', title: '店铺名称',width:250, align:'center'}
				   	  ],
				      [{field: 'address', title: '收货信息',width:250,align:'center'}
				    ]] */
				    
				    
 					[[ //表头
 				      {field: 'orderid', title: '订单编号',align:'center',sort:true},
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
				      ,{field: 'sku', title: 'SKU编号', align:'center'}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '规格', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				  });
			 
			});
	</script>
	
</body>
</html>