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
<!-- 审核与查看 -->
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
		    <label class="layui-form-label" style="width:152px">店主账号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="selfemployed"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">店主名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="name"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">收货人：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="takeName"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">收货人电话：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="phone"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">收货地址：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="address"> </div>
		    </div>
		     <label class="layui-form-label" style="width:152px">订单申请日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="createtime"> </div>
		    </div>
		 </div>
		 <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">核心商户账号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="shopkeeper"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">核心商户名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="shopkeepername"> </div>
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
		    	<div class="layui-form-mid layui-word-aux" id="sumMoney"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">账期（天）：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id=""> 7天</div>
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
      	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品信息</legend>
		</fieldset>
		<div style="padding: 5px 15px">
			<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
			</table>
		</div>
		<div id="button" style="display: none;">
			<div class="layui-form-item layui-form-text">
				<fieldset class="layui-elem-field layui-field-title" >
				<legend>说明</legend>
				  </fieldset>
		     	 	<textarea placeholder="请输入拒绝理由" class="layui-textarea" id="remark"></textarea>
	  		</div>
			<div align="center">
				<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-normal" >返回</button>
				<button id="refuse" class="layui-btn layui-btn-danger" >拒绝</button>
				<button id="agree" class="layui-btn layui-btn-warm" >同意</button>
			</div>
		</div>
		<div id="back" style="display: none;" align="center">
				<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" style="width: 100px">返回</button>
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
			  var isQuery = <%=request.getParameter("isQuery")%>
			  var isSubmit = false;//按钮是否生效,默认不生效,只有入口为审核时才生效
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
					  $('#selfemployed').html(result.data[0].selfemployed)//店主账号
					  $('#name').html(result.data[0].name)//店主名称
					  $('#takeName').html(result.data[0].name)//收货人
					  $('#phone').html(result.data[0].phone)//收货人电话
					  $('#address').html(result.data[0].address)//收货信息
					  $('#shopkeeper').html(result.data[0].shopkeeper)//核心商户账号
					  $('#shopkeepername').html(result.data[0].shopkeepername)//核心商户名称
					  $('#sumMoney').html(result.data[0].sumMoney)//实销金额
					  $('#money').html(result.data[0].money)//订单金额
					  $('#payment').html(result.data[0].payment)//订单首付
					  $('#sumMoney').html(result.data[0].sumMoney)//订单首付
					  $('#servicescale').html(result.data[0].servicescale)//代销服务费率
					  $('#servicemoney').html(result.data[0].servicemoney)//代销服务费
					  $('#name').html(result.data[0].name)//店主名称
					  var date = getDate(result.data[0].createtime)
					  $('#createtime').html(date)//订单申请日期
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
				      ,{field: 'color', title: '规格', align:'center'}
				      ,{field: 'price', title: '单价',align:'center'}
				      ,{field: 'amount', title: '订货量',align:'center'}
				      ,{field: 'summation', title: '金额',align:'center',sort:true}
				      ,{field: 'scale', title: '首付比例',align:'center',sort:true}
				      ,{field: 'payment', title: '首付',align:'center',sort:true}
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
					  content: '<%=path%>/page/main/order/orderGoods.jsp?orderid='+<%=request.getParameter("orderid")%>,
				  	  cancel: function(index, layero){ 
						  table.reload('orderGoods', {
							    cols: [[ //表头
									      {title: '序号', type:'numbers',align:'center'} 
									      ,{field: 'sku', title: 'SKU编号', align:'center',sort:true}
									      ,{field: 'skuname', title: '商品名称', align:'center'}
									      ,{field: 'color', title: '规格', align:'center'}
									      ,{field: 'prePrice', title: '修改前单价', width:130,align:'center'}
									      ,{field: 'price', title: '单价',align:'center'}
									      ,{field: 'preAmount', title: '修改前订货量', width:140,align:'center'}
									      ,{field: 'amount', title: '订货量',align:'center'}
									      ,{field: 'summation', title: '金额',align:'center',sort:true}
									    ]]
							}); 
						}    
				  }) 
			  });
			  $(document).on("click","#refuse",function(){
				  var remark = $('#remark').val()//拒绝理由
				  if(remark == '' || remark == null){
					  layer.msg('拒绝理由不可为空',{icon: 2});
				  }else if(remark.length >50){
					  layer.msg('最多为50字意见,请修改 ',{icon: 2});
				  }else{
					  //这里需要提交到后台处理，修改订单状态码为已拒绝，并将信息发送到风控
					  update(4,remark,"拒绝成功,1秒后跳转")
				  }
			  });
			  $(document).on("click","#agree",function(){
				  	//这里需要提交到后台处理，修改订单状态码为订单审核中，并将信息发送到风控
				  	//暂时这里不提交风控，只是修改状态，之后再进行提交风控
				  	 update(18,null,"订单已同意,1秒后跳转")
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
								  window.location.href='<%=path%>/page/main/order/orderToBeAudit.jsp'
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