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
<!-- 修改订单商品页面 -->
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
        <div class="layui-form-item">
			    <label class="layui-form-label">sku:</label>
			    <div class="layui-input-inline">
			      <input id="sku" type="text" name="sku"  lay-verify="" placeholder="sku编号" autocomplete="off" class="layui-input">
			    </div>
			    <button class="layui-btn layui-btn-primary" id="queryOrderGoodsBySku">查询</button>
			    <button class="layui-btn layui-btn-primary" id="resetInput">重置</button>
		</div>
		<!-- <form> -->
				<table id="orderGoodsDetailUpdate" lay-filter="orderGoodsDetailUpdate">
				</table>
				<div align="center">
			    	<button class="layui-btn layui-btn-primary" id="submit">提交</button>
			    	<button class="layui-btn layui-btn-primary" id="closeWindow">取消</button>
		    	</div>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.all.js"></script>
		<script type="text/javascript"
		src="<%=path%>/page/static/js/order.js"></script>
	<script>
		layui.use(['laydate','table','laypage','layer','form'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer;
			  var form = layui.form;
			  var $ = layui.jquery;
			  
			  table.render({
				    elem: '#orderGoodsDetailUpdate'
				    ,url: '<%=path%>/order/showOrderGoods.json'//数据接口
				    ,where:{orderid:<%=request.getParameter("orderid")%>}
				    ,id:'orderGoodsUpdate'
				    ,page:true
				    ,cols: [[ //表头
				      {title: '序号', align:'center',type:'numbers'} 
				      ,{field: 'sku', title: 'SKU编号', width:100,edit: 'text',align:'center',sort:true}
				      ,{field: 'skuname', title: '商品名称',  width:90,align:'center'}
				      ,{field: 'color', title: '规格', width:90, align:'center'}
				      ,{field: 'prePrice', title: '修改前单价', width:130,align:'center'}
				      ,{field: 'price', title: '单价', width:90,align:'center',edit: 'text',event: 'setPrice', style:'cursor: pointer;'}
				      ,{field: 'preAmount', title: '修改前订货量', width:140,align:'center'}
				      ,{field: 'amount', title: '订货量', width:90,align:'center',edit: 'text',event: 'setAmount',style:'cursor: pointer;'}
				      ,{field: 'summation', title: '金额', width:90,align:'center',sort:true}
				    ]]
				  });
			  
			  //查询
			  $('#queryOrderGoodsBySku').on('click',function(){
				  var sku = $('#sku').val();
				  table.reload('orderGoodsUpdate', {
					  page:{
						  curr:1//重新从第一页开始
					  },
					  where: {sku:sku}
					});
			  })
			  //重置查询参数
			  $('#resetInput').on('click',function(){
				  $('#sku').val('');
			  });
			  
			  
			  table.on('tool(orderGoodsDetailUpdate)',function(obj){
				  var data = obj.data;
				  if(obj.event == 'setPrice'){
				      layer.prompt({
				        formType: 2
				        ,title: '修改价格'
				        ,value: data.price
				      }, function(value, index){
				    	  if(value<0){
					      		layer.msg('价格需为正数',{icon: 2});
					      	}else{
					      		layer.close(index);
						      	var aaa= value*data.amount;
					      	//这里一般是发送修改的Ajax请求
							       //console.log(aaa);
							        //同步更新表格和缓存对应的值
							        obj.update({
							        	price:value,
							        	summation: aaa
							        });
					      	}
				      });
				    }
				  if(obj.event == 'setAmount'){
				      layer.prompt({
				        formType: 2
				        ,title: '修改订货量'
				        ,value: data.amount
				      }, function(value, index){
				    	  var regex = /^[0-9]*[1-9][0-9]*$/;
				    	  if(!regex.test(value)){
					      		layer.msg('订货量需为正整数',{icon: 2});
					      	}else{
					      		 layer.close(index);
							        var aaa= data.price*value;
							        //这里一般是发送修改的Ajax请求
							        //同步更新表格和缓存对应的值
							        obj.update({
							        	amount:value,
							        	summation: aaa
							        });
					      	}
				      });
				    }
				  //layer.msg('[sku: '+ data.sku +'] ' + field + ' 字段更改为：'+ value+'更改后的summation为：'+summation);
			  });		  
			  //关闭当前iframe，并设置超时时间为1毫秒
			  $(document).on('click',"#closeWindow",function(){
				  var index=parent.layer.getFrameIndex(window.name);
				  setTimeout(function(){
					  parent.layer.close(index)
				  },1);
			  });		  
			  $("#submit").click(function(){
 				var orderGoods = table.cache.orderGoodsUpdate;
				 $.ajax({
					  type:'POST',
					  url:"<%=path%>/order/updatePriceBeath",
					  dataType:"json",
					  contentType: 'application/json;charset=utf-8',
					  data: JSON.stringify(orderGoods),
					  success:function(data){
						  if(data.state == 'success'){
							  layer.msg(data.msg,{icon: 1});
						  }else{
							  layer.msg('修改失败',{icon: 2});
						  }
					  },
					  error:function(request){
						  layer.msg('系统异常',{icon: 2});
					  }	
				  });
			  }); 
			});
	</script>
	
</body>
</html>