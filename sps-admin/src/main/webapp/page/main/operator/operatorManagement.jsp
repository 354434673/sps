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
			    <label class="layui-form-label">用户名:</label>
			    <div class="layui-input-inline">
			      <input id="queryUsername" type="text" name="username"  lay-verify="" placeholder="请输入用户名" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label">姓名:</label>
			    <div class="layui-input-inline">
			      <input id="queryName" type="text" name="name"  lay-verify="" placeholder="请输入姓名" autocomplete="off" class="layui-input">
			    </div>
			    	<button class="layui-btn layui-btn-primary" id="queryUser">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="resetUser">重置</button>
	        </div>  
        </div>
		<div>
			<blockquote class="layui-elem-quote">
				<a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
					<i class="layui-icon">&#xe608;</i> 新增用户
				</a>
			</blockquote>
		</div>
		<table id="userList" lay-filter="userTables"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="roleTpl">
  {{#  layui.each(d.role, function(index, item){ }}
    {{item.roleName}},
  {{#  }); }}
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
					  area: ['70%', '80%'],//宽高
					  content: '<%=path%>/page/main/system/addUser.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
					  cancel: function(index, layero){ 
						  table.reload('userId', {
							});
						}    
				  }); 
			  });
			  table.render({
			    elem: '#userList'
			    ,url: '<%=path%>/user/userList.json' //数据接口
			    ,id:'userId'
			    ,page:true
			    ,cols: [[ //表头
			      {field: 'userId',type:'numbers', title: 'ID', align:'center'}
			      ,{field: 'userUsername', title: '用户名', align:'center'}
			      ,{field: 'userName', title: '姓名',align:'center'}
			      ,{field: 'userPhone', title: '联系电话', width:230, align:'center'}
			      ,{field: 'userEmail', title: '电子邮箱', width:230,align:'center'} 
			      ,{field: 'role', title: '角色', align:'center',templet: '#roleTpl'}
			      ,{field: 'tool', title: '操作', width:270,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  //查询
			  $('#queryUser').on('click',function(){
				  var username = $('#queryUsername').val()
				  var name = $('#queryName').val()
				  table.reload('userId', {
					  where: {username:username, name:name}
					});
			  })
			  //重置
			  $('#resetUser').on('click',function(){
				  $('#queryUsername').val('')
				  $('#queryName').val('')
			  })
			  //监听工作条
				table.on('tool(userTables)', function(obj){
					 var data = obj.data;
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的DOM对象
					  if(layEvent === 'detail'){ //查看
						  layer.open({
							  type: 2, 
							  area: ['70%', '80%'],//宽高
							  content: '<%=path%>/page/main/system/addUser.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
							  success: function(layero, index){
								    var body = layer.getChildFrame('body', index);
								    body.find('input').attr({"disabled":"disabled"});
								    body.find('#username').val(data.userUsername)
								    body.find('#name').val(data.userName)
								    body.find('#phone').val(data.userPhone)
								    body.find('#email').val(data.userEmail)
								    body.find('#btn').hide();//隐藏提交按钮
								    body.find('#passwordDiv').hide();//隐藏密码输入框
								    body.find('#resetPasssword').show();//显示重置密码按钮

								}  
						  }); 
					  } else if(layEvent === 'del'){ //删除
					    layer.confirm('真的删除行么', function(index){
					      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					      layer.close(index);
  					  			$.post({
						 			 url:'/sps-admin/user/updateUserState',
						 			 dataType:'json',
						 			 data:{
						 				 userName:data.userUsername,
						 				 state:1
						 				 },
						 			 success:function(data){
								 		 var list = "";
								 		 $.each(data,function(i,item){
										  list +='<option value="'+item.areaId+'" title="'+item.name+'">'+item.name+'</option>';
										  $('#'+Id).html(list)
									  	})
									  	form.render('select');
						 			 }
						 		 })
					    });
					  } else if(layEvent === 'edit'){ //编辑
						  layer.open({
							  type: 2, 
							  area: ['70%', '80%'],//宽高
							  content: '<%=path%>/page/main/system/addUser.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
							  success: function(layero, index){
								    var body = layer.getChildFrame('body', index);
								    body.find('#username').attr({"disabled":"disabled"});
								    body.find('#username').val(data.userUsername)
								    body.find('#name').val(data.userName)
								    body.find('#phone').val(data.userPhone)
								    body.find('#email').val(data.userEmail)
								    body.find('#submit').hide();//显示重置密码按钮
								    body.find('#submitUpdate').show();//显示重置密码按钮
								},
							  cancel: function(index, layero){ 
								  table.reload('userId', {
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
			});
	</script>
</body>
</html>