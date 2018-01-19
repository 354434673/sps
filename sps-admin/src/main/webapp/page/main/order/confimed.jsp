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
<!-- 去确认页面 -->
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
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">订单编号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="orderid"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">订单金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="money"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">代销服务费率：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="servicescale"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">代销服务费：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="servicemoney"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">实销金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="sumMoney"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">单位：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="unit"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">订单申请日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="createtime"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">店主名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="name"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">联系电话：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="phone"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">店铺名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="selfname"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">收货信息：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="address"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">订单备注：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id=""> </div>
		    </div>
		 </div>
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
			  
			  $.post({//获得担保信息
				  url:'<%=path%>/order/showOrder.json'
				  ,dataType:'json'
				  ,data:{orderid:<%=request.getParameter("orderid")%>}
				  ,success:function(result){
					  console.log(result.data[0])
					  $('#orderid').html(result.data[0].orderid)//订单编号
					  $('#money').html(result.data[0].money)//订单金额
					  $('#servicescale').html(result.data[0].servicescale)//代销服务费率
					  $('#servicemoney').html(result.data[0].servicemoney)//代销服务费
					  $('#sumMoney').html(result.data[0].sumMoney)//实销金额
					  $('#unit').html(result.data[0].unit)//单位
					  $('#createtime').html(result.data[0].createtime)//订单申请日期
					  $('#name').html(result.data[0].name)//店主名称
					  $('#phone').html(result.data[0].phone)//联系电话
					  $('#selfname').html(result.data[0].selfname)//店铺名称
					  $('#address').html(result.data[0].address)//收货信息
				  }
			  })
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
			  });
			});
	</script>
	
</body>
</html>