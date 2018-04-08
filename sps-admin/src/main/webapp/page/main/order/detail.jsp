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
<title>订单管理</title>
<!-- 详情页面 -->
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
	/*横向时间轴*/
.time-horizontal {
    list-style-type: none;
    border-top: 1px solid #707070;
    padding: 0px;
    margin: 0px;
}
 
.time-horizontal li {
    float: left;
    position: relative;
    text-align: center;
    width: 20%;
    padding-top: 10px;
}
 
.time-horizontal li b:before {
    content: '';
    position: absolute;
    top: -10px;
    left: 47%;
    width: 12px;
    height: 12px;
    border: 2px solid #4c4c4c;
    border-radius: 8px;
    background: #4c4c4c;
}
/*纵向时间轴*/
.time-vertical {
    list-style-type: none;
    border-left: 1px solid #707070;
    padding: 0px;
    height: 400px;
}
 
.time-vertical li {
    height: 100px;
    position: relative;
}
 
.time-vertical li a {
    display: inline-block;
    margin-left: 20px;
    margin-top: 15px;
    text-decoration: none;
    color: #000;
}
 
.time-vertical li b:before {
    content: '';
    position: absolute;
    top: 15px;
    left: -12px;
    width: 18px;
    height: 18px;
    border: 2px solid #98FB98;
    border-radius: 10px;
    background: #98FB98;
}
 
.time-vertical li span {
    position: absolute;
    color: #fff;
    top: 18px;
    left: -6px;
}
</style>
</head>
<body>
	<div style="margin: 15px;">
  <!--      <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
 			<legend>订单流程</legend>
		</fieldset>
 		<div class="container" align="center" >
		    <ul class="time-horizontal" id="flow">
		    </ul>
		</div> -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>基本信息</legend>
		</fieldset>
		<input type="hidden" id="orderNum" value="<%=request.getParameter("orderid")%>">
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
		    <label class="layui-form-label" style="width:152px">单位：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="sumMoney"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">订单申请日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="createtime"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">店主名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="name"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">联系电话：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="phone"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
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
      	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品列表</legend>
		</fieldset>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
			<div class="layui-form-item" >
			    <label class="layui-form-label" style="width:152px">说明  ：</label>
			    <div class="layui-input-inline">
			    	<div class="layui-form-mid layui-word-aux" id="state"> </div>
			    </div>
		    </div>
			<div align="center">
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

			  $.post({//获得信息
				  url:'<%=path%>/order/showOrder.json'
				  ,dataType:'json'
				  ,data:{orderid:$('#orderNum').val()}
				  ,success:function(result){
					  console.log(result.data[0])
					  $('#orderid').html(result.data[0].orderid)//订单编号
					  $('#money').html(result.data[0].money)//订单金额
					  $('#servicescale').html(result.data[0].servicescale)//代销服务费率
					  $('#servicemoney').html(result.data[0].servicemoney)//代销服务费
					  $('#sumMoney').html(result.data[0].sumMoney)//实销金额
					  $('#unit').html(result.data[0].unit)//单位
					  var date = getDate(result.data[0].createtime)
					  $('#createtime').html(date)//订单申请日期
					  $('#name').html(result.data[0].name)//店主名称
					  $('#phone').html(result.data[0].phone)//联系电话
					  $('#selfname').html(result.data[0].selfname)//店铺名称
					  $('#address').html(result.data[0].address)//收货信息
					  $('#state').html(result.data[0].remark)
				  }
			  })
			  table.render({
				    elem: '#orderGoodsDetail'
				    ,url: '<%=path%>/order/showOrderGoods.json'//数据接口
				    ,where:{orderid:orderid}  
				    ,id:'orderGoods'
				    ,page:true
				    ,cols: [[ //表头
				      {title: '序号', align:'center',type:'numbers'} 
				      ,{field: 'sku', title: 'SKU编号', align:'center'}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '颜色', align:'center'}
				      ,{field: 'memory', title: '尺寸', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				  });
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
			 var list = "";
			  for(var i=0;i<5;i++){
				  list += "<li>"+
						  "<b></b>"+
						  "<span>店主下单"+i+"</span><br>"+
						  "<span>2017.11.29  12:00</span>"+
						  "</li>"
			  }
			 $('#flow').html(list)
			});
	</script>
	
</body>
</html>