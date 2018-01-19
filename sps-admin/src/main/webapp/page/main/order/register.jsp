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
		<table id="orderBasic" lay-filter="orderBasic">
		</table>
      	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>商品列表</legend>
		</fieldset>
		<table id="orderGoodsDetail" lay-filter="orderGoodsDetail">
		</table>
		
		
		<div class="layui-form-item">
	    <label class="layui-form-label">*物流公司：</label>
	    <div class="layui-input-inline">
	      <input name="expressConpany" lay-verify="" autocomplete="off" placeholder="物流公司" class="layui-input" type="text" width="130">
    	</div>
    	<div class="layui-form-item">
	    <label class="layui-form-label">*物流单号：</label>
	    <div class="layui-input-inline">
	      <input name="trackingNumber"  lay-verify="" autocomplete="off" placeholder="物流单号" class="layui-input" type="text" width="130">
    	</div>
    	<div class="layui-form-item">
    	 	<div class="layui-inline">
    			<label class="layui-form-label">物流单据：</label>
    			<div class="layui-input-inline">
      				<input name="expressDocuments" lay-verify="" autocomplete="off" placeholder="物流单据" class="layui-input" type="text" width="130">
      			</div>
    		</div>	
    	</div>
    	<div class="layui-upload">
				  <button type="button" class="layui-btn" id="test1">上传图片</button>
				  <div class="layui-upload-list">
				    <img class="layui-upload-img" id="signed">
				    <p id="demoText"></p>
				  </div>
				</div>   
    	<button class="layui-btn layui-btn-primary" id="back">返回</button>
		<button class="layui-btn layui-btn-primary" id="submit">提交</button>
    	
  </div>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
<script type="text/html" id="indexTpl">
    {{d.LAY_TABLE_INDEX+1}}
</script>
	<script>
		layui.use(['laydate','table','laypage','layer','upload'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var $ = layui.jquery;
			  var upload=layui.upload;
			  
				table.render({
				    elem: '#orderBasic'
				    ,height: 230
				    ,url: '<%=path%>/order/showOrder.json' //数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>} 
				    /* ,page:false  */
				    ,cols: 
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
			  
			  //点击返回按钮，则返回到待确认订单主页面
			  $(document).on("click","#back",function(){
				  window.location.href='<%=path%>/page/main/order/orderToBeDelivery.jsp';
			  });
			  
			//点击提交按钮，则提交至风控，改变状态为待审核
			  $(document).on("click","#submit",function(){
				 window.location.href='<%=path%>/order/updateDeliveryOrderFlag?flag=7&orderid='+<%=request.getParameter("orderid")%>;
			  });
			 
			
			//普通图片上传
			/* var uploadInst = upload.render({
			    elem: '#test1'
			    ,url: '/upload/'
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			        $('#demo1').attr('src', result); //图片链接（base64）
			      });
			    }
			    ,done: function(res){
			      //如果上传失败
			      if(res.code > 0){
			        return layer.msg('上传失败');
			      }
			      //上传成功
			    }
			    ,error: function(){
			      //演示失败状态，并实现重传
			      var demoText = $('#demoText');
			      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
			      demoText.find('.demo-reload').on('click', function(){
			        uploadInst.upload();
			      });
			    }
			  }); */
			
			
			  upload.render({//签约合影照片
	 			    elem: '#test1' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    //,data:{type:'signed',types:9,id:channelNum,status:'channel',accept:'images'}
	 			    ,url: '/sps-admin/common/file/manyUpload' //上传接口
	 			    ,done: function(res){
	 			    	if(res.state == 'success'){
		 			    	layer.msg('图片上传成功',{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg('图片失败',{icon: 2});
	 			    	}
	 			    }
			});
		});
	</script>
	
</body>
</html>