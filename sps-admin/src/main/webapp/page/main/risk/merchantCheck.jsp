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
<title>商户审核</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
	<div style="margin: 15px;">
		<div class="layui-form layui-form-pane"  >
		    <div class="layui-form-item">
			    <label class="layui-form-label" style="width: 200px">核心商户编号:</label>
			    <div class="layui-input-inline">
			      <input id="channelNum" type="text" name="username"  lay-verify="" placeholder="请输入用户名" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label" style="width: 200px" >核心商户名称:</label>
			    <div class="layui-input-inline">
			      <input id="queryName" type="text" name="name"  lay-verify="" placeholder="请输入姓名" autocomplete="off" class="layui-input">
			    </div>
			    	<button class="layui-btn layui-btn-primary" id="queryChannelNum">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
	        </div>  
		    <div class="layui-form-item">
			    <label class="layui-form-label" style="width: 200px">核心商户状态:</label>
			    <div class="layui-input-inline" >
			    <select lay-filter="channelState"> 
				  <option value=""></option>
				  <option value="0">未激活</option>
				  <option value="1">正常</option>
				  <option value="2">冻结</option>
				  <option value="3">激活失败</option>
		      	</select>
			    </div>
			    <label class="layui-form-label" style="width: 200px">流程状态:</label>
			    <div class="layui-input-inline" >
			    <select lay-filter="channelFlowState"> 
				  <option value=""></option>
				  <option value="0">待提交</option>
				  <option value="1">风控审核中</option>
				  <option value="2">风控审核通过</option>
				  <option value="3">风控审核失败</option>
		      	</select>
			    </div>
	        </div>  
        </div>
		<div>
			<blockquote class="layui-elem-quote">
				<a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
					<i class="layui-icon">&#xe608;</i> 新增用户
				</a>

			</blockquote>
		</div>
		<table id="channelList" lay-filter="channelTables" class="layui-fluid"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript"
		src="<%=path%>/page/static/datas/area_data.js"></script>
<script type="text/html" id="bar">
	
  <a class="layui-btn layui-btn-mini" lay-event="risk">审核</a>
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="channelTpl">
  {{}}
  {{#  if(d.channel.channelState == 0){ }}
    	未激活
  {{#  } else if(d.channel.channelState == 1){ }}
    	正常
  {{#  } else if(d.channel.channelState == 2){ }}
    	冻结
  {{#  } }}
</script>
	<script>
	layui.use(['table','layer','form'], function(){
			  var table = layui.table;
			  var layer = layui.layer
			  var form = layui.form
			  var $ = layui.jquery
			  $('#add').on('click', function() {
				  location.href = '<%=path%>/page/main/merchant/addMerchant.jsp'
			  });
			  table.render({
			    elem: '#channelList'
			    ,url: '<%=path%>/merchant/getChannelList.json' //数据接口
			    ,id:'enterpriseId'
			    ,page:true
			    ,cols: [[ //表头
			      {field: 'enterpriseId', type:'numbers', title: '序号',align:'center'}
			      ,{field: 'channelNum', title: '核心账户编号',align:'center'}
			      ,{field: 'enterpriseCompanyName', title: '公司名称',width:240,align:'center'}
			      ,{field: 'enterpriseBusinesslicenseNo', title: '营业执照编号', width:230, align:'center'}
			      ,{field: 'channel', title: '核心商户状态', align:'center',templet: '#channelTpl'} 
			      ,{field: 'tool', title: '操作',align:'center',toolbar:'#bar'}
			    ]]
			  });
			  //查询
			  $('#queryChannelNum').on('click',function(){
				  var channelNum = $('#channelNum').val()
				  table.reload('enterpriseId', {
					  where: {channelNum:channelNum}
					});
			  })
			  //重置
			  $('#reset').on('click',function(){
				  $('input').val('')
			  })
			  form.on('select(channelState)', function(data){
				  
				  table.reload('enterpriseId', {
					  where: {channelState:data.value}
					}); 
			  });    
			  form.on('select(channelFlowState)', function(data){
				  console.log(data.value)
				  table.reload('enterpriseId', {
					  where: {channelFlowState:data.value}
					}); 
			  });    
			  //监听工作条
				table.on('tool(channelTables)', function(obj){
					 var data = obj.data;
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的DOM对象
					  if(layEvent === 'detail'){ //查看
						  location.href = '<%=path%>/page/main/merchant/queryMerchant.jsp?channelNum='+data.channelNum
					  } else if(layEvent === 'del'){ //删除
	 					    layer.confirm('真的删除该商户么', function(index){
						      layer.close(index);
						      updateState(3,data.channelNum,'删除')
						    }); 
					  } else if(layEvent === 'edit'){ //编辑
						  	location.href = '<%=path%>/page/main/merchant/updateMerchant.jsp?channelNum='+data.channelNum
					  } else if(layEvent == 'freeze'){//冻结
	 					    layer.confirm('确定冻结该商户么', function(index){
	 					    updateState(2,data.channelNum,'冻结')
	 					   }); 
					  } else if(layEvent == 'recover'){
	 					    layer.confirm('恢复该冻结商户么', function(index){
		 					    updateState(0,data.channelNum,'恢复')
	 					   }); 
					  }
				});
					  //更改状态
			  	function updateState(state, channelNum, msg){
						$.post({
								url:'<%=path%>/merchant/deleteChannel',
								dataType:'json',
								data:{
									state:state,
									channelNum:channelNum
								},
								success:function(result){
									layer.msg(msg+"成功")
									table.reload('enterpriseId', {})
								}
							})
			  	}
			});
	</script>
</body>
</html>