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
<!-- 待收货退货申请去确认页面-->
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
 			<legend>订单信息</legend>
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
		    <label class="layui-form-label" style="width:152px">退货申请日期：</label>
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
		  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>退货信息</legend>
		  </fieldset>
		  		<div class="layui-form-item">
		 <label class="layui-form-label">退货原因:</label>
			    <div class="layui-input-inline">
			      <input id="reson" type="text" name="reson"  lay-verify="" placeholder="" autocomplete="off" class="layui-input">
			    </div>
		</div>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品信息</legend>
		  </fieldset>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
		<div align="center">
			<button onclick="javascript:history.back(-1)" id="back" class="layui-btn layui-btn-normal" >返回</button>
			<button id="confirm" class="layui-btn layui-btn-warm" >确认收货</button>
		</div>
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
					  $('#money').html(result.data[0].money)//订单金额
					  var date = getDate(result.data[0].createtime)
					  $('#createtime').html(date)//退货申请日期
					  $('#name').html(result.data[0].name)//店主名称
					  $('#phone').html(result.data[0].phone)//联系电话
					  $('#selfname').html(result.data[0].selfname)//店铺名称
				  }
			  })
			  table.render({
				    elem: '#orderGoodsDetail'
				    ,url: '<%=path%>/order/showOrderGoods.json'//数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>} 
				    ,id:'orderGoods'
				    ,page:true
				    ,cols: [[ //表头
				       {title: '序号', align:'center',type:'numbers'} 
		 			  ,{field: 'sku', title: 'SKU编号', align:'center',sort:true}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '规格', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				  });
			  $(document).on("click","#confirm",function(){//确认收货
				  //这里需要提交到后台处理，修改订单状态码为订单审核中，并将信息发送到风控
				  //暂时这里不提交风控，只是修改状态，之后再进行提交风控
				  update(17,null,"已确认收货,1秒后跳转")
			  });
			  //更改状态方法
			  function update(flag,remark,msg){
				  $.post({
					  url:'<%=path%>/order/updateConfirmOrderFlag',
					  dataType:'json',
					  data:{remark:remark,
						  orderid:<%=request.getParameter("orderid")%>,
						  flag:flag},
					  success:function(data){
						  layer.msg(msg,{icon: 1});
						  setTimeout(function(){
							  //跳转到上一页
							  window.location.href='<%=path%>/page/main/rejected/orderToBeConfirmRejected.jsp'
						  },1000);
					  },
					  error:function(){
						  layer.msg('系统错误',{icon: 2});
					  }
				  })
			  }
			  //时间格式化
			  function getDate(data){
				    da = new Date(data);
				    var year = da.getFullYear();
				    var month = da.getMonth()+1;
				    var date = da.getDate();
				    var hours = da.getHours();
				    var minutes = da.getMinutes();
				    var seconds = da.getSeconds();
				    return [year,month,date].join('-')+"  "+[hours,minutes,seconds].join(':');
			  }
			});
	</script>
	
</body>
</html>