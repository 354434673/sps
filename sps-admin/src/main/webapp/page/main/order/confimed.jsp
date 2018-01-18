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
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>基本信息</legend>
		</fieldset>
		<table id="orderBasic" lay-filter="orderBasic">
		</table>
      	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品列表</legend>
		</fieldset>
		<div>
			<button id="updatePrice" class="layui-btn layui-btn-normal" >修改</button>
		</div>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
		<div class="layui-form-item layui-form-text">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>说明</legend>
			  </fieldset>
	   		 <div class="layui-input-block">
	     	 	<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
	   		 </div>
  		</div>
		<div>
			<button id="back" class="layui-btn layui-btn-normal" >返回</button>
			<button id="refuse" class="layui-btn layui-btn-danger" >拒绝</button>
			<button id="agree" class="layui-btn layui-btn-warm" >同意</button>
		</div>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
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
			        ,page:true
				    ,cols: /*[
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
				    ]]  */
				    
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
			  
			  //点击按钮进行展示弹出页面
			  $(document).on("click","#updatePrice",function(){
				  layer.open({
					  title: '修改单价与订货量',
					  type:2,
					  area:  ['700px', '460px']/* iframe自适应，但是并不好用，示例： parent.layer.iframeAuto(parent.layer.getFrameIndex(window.name))*/,
					  fixed: false, //不固定
					  maxmin: true,
					  content: '<%=path%>/page/main/order/orderGoods.jsp?orderid='+<%=request.getParameter("orderid")%>
				  }) 
			  });
			  
			  //点击返回按钮，则返回到待确认订单主页面
			  $(document).on("click","#back",function(){
				  window.location.href='<%=path%>/page/main/order/orderToBeConfimed.jsp';
			  });
			  
			  $(document).on("click","#refuse",function(){
				  //这里需要提交到后台处理，修改订单状态码为已拒绝，并将信息发送到风控
				  window.location.href='<%=path%>/order/updateConfirmOrderFlag?flag=2&orderid='+<%=request.getParameter("orderid")%>;
			  });
			  
			  $(document).on("click","#agree",function(){
				  //这里需要提交到后台处理，修改订单状态码为订单审核中，并将信息发送到风控
				  //暂时这里不提交风控，只是修改状态，之后再进行提交风控
				  window.location.href='<%=path%>/order/updateConfirmOrderFlag?flag=3&orderid='+<%=request.getParameter("orderid")%>;
				  <%-- window.location.href="<%=path%>/page/main/order/afterConfimed.jsp?orderid="+<%=request.getParameter("orderid")%>; --%>
			  });
			});
	</script>
	
</body>
</html>