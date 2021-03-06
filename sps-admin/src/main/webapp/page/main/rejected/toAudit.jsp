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
<!-- 退款审核中去审核页面-->
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
		    <label class="layui-form-label" style="width:152px">店主账号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="account"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">店主名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="name"> </div>
		    </div>
		 </div>
		 
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">核心商户账号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="c_acccount"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">核心商户名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="selfname22"> </div>
		    </div>
		 </div>
		 
		<div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">订单金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="money"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">订单首付：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="payment"> </div>
		    </div>
		 </div>
		 
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">店付金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="d_money"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">账期（天）：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="date"> </div>
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
		 <!--  
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">实销金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="sumMoney"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">退款金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="backSumMoney"> </div>
		    </div>
		 </div>
		 -->
		 
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">退货申请日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="modifytime"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">店付日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id=createtime> </div>
		    </div>
		 </div>
		 <!-- 
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
		  -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品信息</legend>
		</fieldset>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail"></table>
    	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>退货信息</legend>
		</fieldset>
		<div class="layui-form-item">
		 <label class="layui-form-label">退货原因:</label>
			    <div class="layui-input-inline">
					<div class="layui-form-mid layui-word-aux" id=""> 拒绝还需要理由?</div>	
			    </div>
		</div>
		<div class="layui-form-item">
		 <label class="layui-form-label">核心商户意见:</label>
			    <div class="layui-input-inline">
					<div class="layui-form-mid layui-word-aux" id=""> 同意</div>	
			    </div>
		</div>
		<div class="layui-form-item">
		<div class="layui-form-item layui-form-text">
			 <label class="layui-form-label">意见：</label>
	   		 <div class="layui-input-block">
	     	 	<textarea placeholder="请输入内容" class="layui-textarea" id="reson"></textarea>
	   		 </div>
		</div>	
		</div>
		<div align="center" style="display: none" id="button">
			<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-normal" >返回</button>
			<button id="refuse" class="layui-btn layui-btn-danger" >拒绝</button>
			<button id="agree" class="layui-btn layui-btn-warm" >同意</button>
		</div>
		<div align="center" style="display: none;" id="back" >
			<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-normal" style="width: 150px">返回</button>
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
			  var isSubmit = false;//按钮是否生效,默认不生效,只有入口为审核时才生效
			  var isQuery = <%=request.getParameter("isQuery")%>
			  if(isQuery == 1){//为1则为审核	
				  isSubmit = true
				  $('#button').show()
			  }else{
				  $('#back').show()
			  }
			  $.post({//获得信息
				  url:'<%=path%>/order/showOrder.json'
				  ,dataType:'json'
				  ,data:{orderid:<%=request.getParameter("orderid")%>}
				  ,success:function(result){
					  $('#payment').html(result.data[0].payment)//订单首付
					  $('#servicescale').html(result.data[0].servicescale)//代销服务费率
					  $('#servicemoney').html(result.data[0].servicemoney)//代销服务费
					  $('#money').html(result.data[0].sum_money)//订单金额
					  var date = getDate(result.data[0].createtime)
					  $('#createtime').html(date)
					  var date1 = getDate(result.data[0].modifytime)
					  $('#modifytime').html(date1)
					  $('#c_acccount').html(result.data[0].shopkeeper)//核心商户账号
					  $('#account').html(result.data[0].selfemployed)//店主账号
					  $('#name').html(result.data[0].name)//店主名称
					  //$('#phone').html(result.data[0].phone)//联系电话
					  $('#selfname').html(result.data[0].shopkeepername)//店铺名称
					  //$('#address').html(result.data[0].address)//收货信息
					  $('#date').html("7")//账期
					  $('#d_money').html(result.data[0].money)//店付金额
					  //$('#consignee').html(result.data[0].name)//店付金额
				  }
			  })
			  table.render({
				    elem: '#orderGoodsDetail'
				    ,url: '<%=path%>/order/showOrderGoods.json'//数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>} 
				    ,id:'orderGoods'
				    ,page:true
				    ,cols: [[ //表头
				       {field: 'sku', title: 'SKU编号', align:'center',sort:true}
				      ,{field: 'skuname', title: '商品名称', align:'center'}
				      ,{field: 'color', title: '颜色', align:'center'}
				      ,{field: 'memory', title: '尺寸', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				    ]]
				  });
			  $(document).on("click","#refuse",function(){
				  var remark = $('#reson').val()//拒绝理由
				  if(remark == '' || remark == null){
					  layer.msg('拒绝理由不可为空',{icon: 2});
				  }else{
					  //这里需要提交到后台处理，修改订单状态码为已拒绝，并将信息发送到风控
					  update(15,remark,"退货拒绝成功,1秒后跳转")
				  }
			  });
			  $(document).on("click","#agree",function(){
				  //这里需要提交到后台处理，修改订单状态码为订单审核中，并将信息发送到风控
				  //暂时这里不提交风控，只是修改状态，之后再进行提交风控
				  update(16,null,"审核通过,1秒后跳转")
			  });
			  //更改状态方法
			  function update(flag,remark,msg){
				  if(isSubmit){
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
								  window.location.href='<%=path%>/page/main/rejected/rejectedAudit.jsp'
							  },1000);
						  },
						  error:function(){
							  layer.msg('系统错误',{icon: 2});
						  }
					  })
				  }else{
					  layer.msg('按钮不合法',{icon: 2});
				  }
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