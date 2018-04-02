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
<title>店主邀请</title>
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
			    <label class="layui-form-label" style="width: 200px" >店主名称:</label>
			    <div class="layui-input-inline">
			      <input id="name" type="text" name="name"  lay-verify="" placeholder="店主名称" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label" style="width: 200px" >联系电话:</label>
			    <div class="layui-input-inline">
			      <input id="phone" type="text" name="phone"  lay-verify="" placeholder="联系电话" autocomplete="off" class="layui-input">
			    </div>
	        </div>  
		    <div class="layui-form-item">
			    <label class="layui-form-label" style="width: 200px">状态:</label>
			    <div class="layui-input-inline" >
			    <select lay-filter="state" id="state"> 
				  <option value="">全部</option>
				  <option value="0">待接受</option>
				  <option value="1">已接收</option>
		      	</select>
			    </div>
			    	<button class="layui-btn layui-btn-primary" id="queryInvitation">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
	        </div>  
        </div>
		<div>
			<blockquote class="layui-elem-quote">
				<a href="javascript:;" class="layui-btn layui-btn-primary" id="add">
					<i class="layui-icon">&#xe608;</i> 新增
				</a>
				<a href="<%=path %>/shopkeeper/exportExcel" target="_self" class="layui-btn layui-btn-normal">
					<i class="layui-icon">&#xe601;</i> 模板下载
				</a>
				<a href="<%=path%>/page/main/shopkeeper/QRcode.jsp" target="_self" class="layui-btn">
					<i class="layui-icon">&#xe601;</i> 二维码
				</a>
				<a href="javascript:;" class="layui-btn layui-btn-warm" id="upload">
					<i class="layui-icon">&#xe608;</i> 批量新增
				</a>
			</blockquote>
		</div>
		<table id="invitationList" lay-filter="invitationTables" class="layui-fluid"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript"
		src="<%=path%>/page/static/datas/area_data.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
  <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="audit">审核</a>
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="channelTpl">
  {{}}
  {{#  if(d.invitationState == 0){ }}
    	待接受
  {{#  } else if(d.invitationState == 1){ }}
    	已接收
  {{#  } }}
</script>
	<script type="text/html" id="dateTpl">
{{#  
   var da = d.invitationTime;
    da = new Date(da);
				    var year = da.getFullYear();
				    var month = da.getMonth()+1;
				    var date = da.getDate();
				    var hours = da.getHours();
				    var minutes = da.getMinutes();
				    var seconds = da.getSeconds();
  var fn = function(){
    return [year,month,date].join('-')+"  "+[hours,minutes,seconds].join(':');
  }; 
}}
{{ fn() }}
</script>
	<script>
	layui.use(['table','layer','form','upload'], function(){
			  var table = layui.table;
			  var layer = layui.layer
			  var form = layui.form
			  var $ = layui.jquery
			  var upload = layui.upload;
			  $('#add').on('click', function() {
				  location.href = '<%=path%>/page/main/shopkeeper/addInvitation.jsp'
<%-- 				  layer.open({
					  type: 2, 
					  title:'店主邀请新增',
					  area: ['30%', '40%'],//宽高
					  content: '<%=path%>/page/main/shopkeeper/addInvitation.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
				  });  --%>
			  });
			  table.render({
			    elem: '#invitationList'
			    ,url: '<%=path%>/shopkeeper/queryInvitationList.json' //数据接口
			    ,id:'invitation'
			    ,page:true
			    ,cols: [[ //表头
			      {type:'numbers', title: '序号',align:'center'}
			      ,{field: 'invitationName', title: '店主名称',align:'center'}
			      ,{field: 'invitationPhone', title: '联系电话',align:'center' }
			      ,{field: 'invitationTime', title: '邀请时间',align:'center',templet: '#dateTpl'}
			      ,{field: 'invitationState', title: '状态', width:140,align:'center',templet: '#channelTpl'} 
			    ]]
			  });
			  //查询
			  $('#queryInvitation').on('click',function(){
				  var name = $('#name').val()
				  var phone = $('#phone').val()
				  var state = $('#state').val()
				  table.reload('invitation', {
					  where: {
						  name:name,
						  phone:phone,
						  state:state,
						  }
					});
			  })
			  //重置
			  $('#reset').on('click',function(){
				  $('input').val('')
				  $('select').val('');
			  })
			  form.on('select(shopkeeperState)', function(data){
				  table.reload('shopkeeper', {
					  where: {shopkeeperState:data.value}
					}); 
			  });   
			  //执行实例
			  var uploadInst = upload.render({
			    elem: '#upload' //绑定元素
			    ,accept:'file'
			    ,exts:'xls|xlsx'
			    ,url: '<%=path %>/shopkeeper/importExcel' //上传接口
			    ,done: function(res){
			    	if(res.state == "success"){
			    		layer.msg(data.msg,{icon: 1});
			    	}else{
			    		layer.msg(data.msg,{icon: 2});
			    	}
			    }
			    ,error: function(){
			    	layer.msg('系统异常',{icon: 2});
			    }
			  });
			  //监听工作条
<%-- 				table.on('tool(shopkeeperTables)', function(obj){
					 var data = obj.data;
					 console.log(data.shopkeeperCustomerid)
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的DOM对象
					  if(layEvent === 'detail'){ //查看
						  location.href = '<%=path%>/page/main/shopkeeper/info.jsp?queryType=1&shopkeeperCustomerid='+data.shopkeeperCustomerid
					  } else if(layEvent === 'audit'){//审核
						  location.href = '<%=path%>/page/main/shopkeeper/info.jsp?queryType=2&shopkeeperCustomerid='+data.shopkeeperCustomerid
					  } else if(layEvent === 'edit'){ //修改
						  location.href = '<%=path%>/page/main/shopkeeper/info.jsp?queryType=3&shopkeeperCustomerid='+data.shopkeeperCustomerid
					  }
				}); --%>
			});
	</script>
</body>
</html>