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
<title>用户管理</title>
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
			    <label class="layui-form-label">业务员姓名:</label>
			    <div class="layui-input-inline">
			      <input id="salesmanName" type="text" name="salesmanName"  placeholder="请输入业务员名称" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label">身份证号码:</label>
			    <div class="layui-input-inline">
			      <input id="salesmanIdcard" type="text" name="salesmanIdcard"  placeholder="请输入身份证" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label">手机号:</label>
			    <div class="layui-input-inline">
			      <input id="salesmanPhone" type="text" name="salesmanPhone"  placeholder="请输入手机" autocomplete="off" class="layui-input">
			    </div>
			    
			    <label class="layui-form-label">状态:</label>
			    <div class="layui-input-inline" >
			    <select lay-filter="salesState" id="status"> 
				  <option value="">全部</option>
				  <option value="1">正常</option>
				  <option value="2">停用</option>
		      	</select>
	        </div>  
        </div>
	         <div class="layui-form-item">
			    	<button class="layui-btn layui-btn-primary" id="queryUser">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetUser">重置</button>
	         </div>
		<div>
			<blockquote class="layui-elem-quote">
				<a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
					<i class="layui-icon">&#xe608;</i> 新增用户
				</a>
			</blockquote>
		</div>
		<table id="salesmanList" lay-filter="salesmanTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
{{#  if(d.bei1 == 1){ }}
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="freeze">冻结</a>
{{#  } else if(d.bei1 == 2){ }}
<a class="layui-btn layui-btn-mini " lay-event="recover">恢复</a>
{{#  } }}  
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="roleTpl">
  {{#  layui.each(d.role, function(index, item){ }}
    {{item.roleName}},
  {{#  }); }}
</script>
<script type="text/html" id="state">
{{#  if(d.bei1 == 1){ }}
 正常
{{#  } else if(d.bei1 == 2){ }}
 停用
{{#  } else { }}
  {{d.bei1}}
{{#  } }}  
</script>

	<script>
		layui.use(['table','laypage','layer'], function(){
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var layer = layui.layer
			  var $ = layui.jquery
			  $('#add').on('click', function() {
				  layer.open({
					  type: 2, 
					  title:'新增业务员',
					  area: ['65%', '65%'],//宽高
					  content: '<%=path%>/page/main/salesman/addSales.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
					  cancel: function(index, layero){ 
						  table.reload('salesmanId', {
							});
						}    
				  }); 
			  });
			  table.render({
			    elem: '#salesmanList'
			    ,url: '<%=path%>/salesman/getSalesmanList.json' //数据接口
			    ,id:'salesmanId'
			    ,page:true
			    ,cols: [[ //表头
			      {field: 'salesmanId', type:'numbers',title: '序号', align:'center'}
			      ,{field: 'salesmanName', title: '业务员姓名', align:'center'}
			      ,{field: 'salesmanIdcard', title: '身份证号码',align:'center'}
			      ,{field: 'salesmanPhone', title: '手机号', width:230, align:'center'}
			      ,{field: 'salesmanEmail', title: '电子邮箱', width:230,align:'center'} 
			      ,{field: 'salesmanCity', title: '城市', align:'center'}
			      ,{field: 'bei1', title: '状态', align:'center',templet:'#state'}
			      ,{field: 'tool', title: '操作', width:330,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  //查询
			  $('#queryUser').on('click',function(){
				  var salesmanName = $('#salesmanName').val()
				  var salesmanIdcard = $('#salesmanIdcard').val()
				  var salesmanPhone = $('#salesmanPhone').val()
				  var salesState = $('#status').val()
				  table.reload('salesmanId', {
					  where: {salesmanName:salesmanName,
						  salesmanIdcard:salesmanIdcard,
						  salesmanPhone:salesmanPhone,
						  bei1:salesState}
					});
			  })
			  //重置
			  $('#resetUser').on('click',function(){
				  $('input').val('')
				  $('select').val('')
			  })
			  //监听工作条
				table.on('tool(salesmanTables)', function(obj){
					 var data = obj.data;
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的DOM对象
					  if(layEvent === 'detail'){ //查看
						  layer.open({
							  type: 2, 
							  title:'查看业务员',
							  area: ['70%', '80%'],//宽高
							  content: '<%=path%>/page/main/salesman/addSales.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
							  success: function(layero, index){
								    var body = layer.getChildFrame('body', index);
								    body.find('input').attr({"disabled":"disabled"});
								    body.find('#salesmanName').val(data.salesmanName)
								    body.find('#salesmanIdcard').val(data.salesmanIdcard)
								    body.find('#salesmanPhone').val(data.salesmanPhone)
								    body.find('#salesmanEmail').val(data.salesmanEmail)
								    body.find('#btn').hide();//隐藏提交按钮
								    body.find('#passwordDiv').hide();//隐藏密码输入框
								    body.find('#resetPasssword').show();//显示重置密码按钮
								}  
						  }); 
					  } else if(layEvent === 'del'){ //删除
					    layer.confirm('确认删除该业务员？', function(index){
					      layer.close(
					    		  updateState(3, data.salesmanId, null)
						  );
					      //向服务端发送删除指令
					    });
					  } else if(layEvent == 'freeze'){//冻结
	 					    layer.confirm('确定冻结该商户么', function(index){
		 					    updateState(2,data.salesmanId,null)
		 					   }); 
						} else if(layEvent == 'recover'){
		 					    layer.confirm('恢复该冻结商户么', function(index){
			 					    updateState(1,data.salesmanId,null)
		 					   }); 
						} else if(layEvent === 'edit'){ //编辑
						  layer.open({
							  type: 2, 
							  title:'修改业务员',
							  area: ['70%', '80%'],//宽高
							  content: '<%=path%>/page/main/salesman/addSales.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
							  success: function(layero, index){
								    var body = layer.getChildFrame('body', index);
								    body.find('#salesmanId').val(data.salesmanId)
								    body.find('#salesmanName').val(data.salesmanName)
								    body.find('#salesmanIdcard').val(data.salesmanIdcard)
								    body.find('#salesmanPhone').val(data.salesmanPhone)
								    body.find('#salesmanEmail').val(data.salesmanEmail)
								    //body.find('#submit').hide();//显示重置密码按钮
								    body.find('#submit').hide();//显示重置密码按钮
								    body.find('#submitUpdate').show();//显示重置密码按钮
								},
							  cancel: function(index, layero){ 
								  table.reload('salesmanId', {
									});
								}   
						  }); 
					    
					    //同步更新缓存对应的值
/* 					    obj.update({
					      username: '123'
					      ,title: 'xxx'
					    }); */
					  }
				});
			  	//更改状态
			  	function updateState(state, id, msg){
			  			$.post({
				 			 url:'<%=path%>/salesman/updateSalesmanState',
				 			 dataType:'json',
				 			 data:{
				 				 id:id,
				 				 state:state
				 				 },
				 			 success:function(data){
				 				 if(data.state == 'success'){
				 					layer.msg(data.msg,{icon: 1});
				 					table.reload('salesmanId', {})
				 				 }else{
				 					layer.msg(data.msg,{icon: 2});
				 				 }
				 			 },
				 			 error:function(){
				 				layer.msg('系统错误',{icon: 2});
				 			 }
				 		 })
			  	}
			});
	</script>
</body>
</html>