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
<!-- 发货登记页面 -->
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
      	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品列表</legend>
		</fieldset>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
		<div class="layui-form" >
			<div class="layui-form-item">
		    <label class="layui-form-label" style="width:130px">*物流公司：</label>
		    <div class="layui-input-inline">
		      <input disabled="disabled" id="logisticsCooperationName" type="logisticsCooperationName" name="name" lay-verify="required" placeholder="合作物流" autocomplete="off" class="layui-input">
		    </div>
		   		<button class="layui-btn layui-btn-primary" lay-filter="openExpress" id="openExpress">
			    <i class="layui-icon">&#xe608;</i> 搜索</button>
		   </div>
			<div class="layui-form-item">
		    <label class="layui-form-label" style="width:130px">*其他：</label>
		    <div class="layui-input-inline">
		      <input  id="logisticsOther" type="text" name="logisticsOther" placeholder="其他" autocomplete="off" class="layui-input">
		    </div>
		   </div>
			<div class="layui-form-item">
		    <label class="layui-form-label" style="width:130px">*物流单号：</label>
		    <div class="layui-input-inline">
		      <input  id="logisticsOther" lay-verify="required" type="text" name="logisticsOther" placeholder="物流单号" autocomplete="off" class="layui-input">
		    </div>
		   </div>
			<div class="layui-form-item">
		    <label class="layui-form-label" style="width:130px">物流单据：</label>
		    <div class="layui-input-inline">
		    	<button type="button" class="layui-btn layui-btn-primary" id="testList" style="width: 190px">选择多文件</button> 
		    </div>
		   </div>
		   <div class="layui-form-item">
		   </div>
		   <!-- 按钮 -->
    		 <div class="layui-form-item" align="center" id="btn" style="padding-top: 10px" >
				<button onclick="javascript:history.back(-1)" class="layui-btn" >返回</button>
				<button class="layui-btn layui-btn-primary" lay-filter="submit" lay-submit id="submit">提交</button>
			</div>
		</div>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
<script>
		layui.use(['laydate','table','form','layer','upload'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var form = layui.form;
			  var layer = layui.layer;
			  var $ = layui.jquery;
			  var upload=layui.upload;
			  $.post({//获得信息
				  url:'<%=path%>/order/showOrder.json'
				  ,dataType:'json'
				  ,data:{orderid:<%=request.getParameter("orderid")%>}
				  ,success:function(result){
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
				  }
			  })
			  	  //失去焦点
			  $('#logisticsOther').blur(function(){
				  var logisticsOther = $('#logisticsOther').val()
				  if(logisticsOther != ""){
					  $("#logisticsCooperationName").removeAttr("lay-verify","required");
					  $("#openExpress").attr("disabled","disabled");//不为空则说明其他有值,禁用物流按钮
					  $("#openExpress").addClass("layui-disabled");
				  }else{
					  $("#guaranteeDeposit").attr("lay-verify","required");
					  $("#openExpress").removeAttr("disabled")//为空则说明其他项没有填,恢复选择物流按钮
					  $("#openExpress").removeClass("layui-disabled");
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
				      ,{field: 'sku', title: 'SKU编号', align:'center'}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '规格', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				  });
			//点击提交按钮，则提交至风控，改变状态为待审核
<%-- 			  $(document).on("click","#submit",function(){
				 window.location.href='<%=path%>/order/updateDeliveryOrderFlag?flag=7&orderid='+<%=request.getParameter("orderid")%>;
			  }); --%>
				  //绑定原始文件域
				  upload.render({
				    elem: '#testList'
				    ,accept:'images'
				    ,url: '/upload/'
				    ,auto: false
				    ,multiple: true
				    ,bindAction:'#submit'
	 			    ,data:{type:'forms',types:3,channelNum:'111',status:'channel',accept:'images'}
				    ,url: '<%=path%>/merchant/uploadPic' //上传接口
				    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
				    	}else if(res.state == 'error'){
				    		layer.msg(res.msg,{icon: 2});
				    	}else if(res.state == 'max'){
				    		layer.msg(res.msg,{icon: 2});
				    	}
				    }
				    ,error: function(){
				    	layer.msg('图片失败',{icon: 2});
				    }
				  });
			//物流信息
			  $('#openExpress').on('click', function() {
				  layer.open({
					  type: 2, 
					  area: ['75%', '70%'],//宽高
					  content: ['<%=path%>/page/main/express/expressRedio.jsp'] ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
					  btn: ['确定','取消'],
				      yes: function(index, layero){
					  	  layer.close(layer.index);
						  var data = $(layero).find("iframe")[0].contentWindow.expressIds;
						  if(data.length != 0 || data != ""){
							  $('#logisticsCooperationName').val(data.name)
							  $('#logisticsOther').attr("disabled","disabled")
							  $('#logisticsOther').addClass("layui-disabled")
						  }
				  		},  
				  }); 
			  });
			  function getDate(data){
				    da = new Date(data);
				    var year = da.getFullYear();
				    var month = da.getMonth()+1;
				    var date = da.getDate();
				    return [year,month,date].join('-');
			  }
		});
	</script>
	
</body>
</html>