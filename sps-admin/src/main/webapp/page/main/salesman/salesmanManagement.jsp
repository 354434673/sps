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
			    <label class="layui-form-label">业务员名称:</label>
			    <div class="layui-input-inline">
			      <input id="salesmanName" type="text" name="salesmanName"  lay-verify="" placeholder="请输入业务员名称" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label">身份证号码:</label>
			    <div class="layui-input-inline">
			      <input id="salesmanIdCard" type="text" name="salesmanIdCard"  lay-verify="" placeholder="请输入身份证" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label">手机号:</label>
			    <div class="layui-input-inline">
			      <input id="salesmanPhone" type="text" name="salesmanPhone"  lay-verify="" placeholder="请输入手机" autocomplete="off" class="layui-input">
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
		<table id="salesmanList" lay-filter="salesmanTables"></table>
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
					  area: ['60%', '60%'],//宽高
					  content: '<%=path%>/page/main/salesman/addSales.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
					  cancel: function(index, layero){ 
						  table.reload('userId', {
							});
						}    
				  }); 
			  });
			  table.render({
			    elem: '#salesmanList'
			    ,url: '<%=path%>/salesman/getSalesmanList.json' //数据接口
			    ,id:'userId'
			    ,page:true
			    ,cols: [[ //表头
			      {field: 'userId', title: '序号', align:'center'}
			      ,{field: 'userUsername', title: '业务员姓名', align:'center'}
			      ,{field: 'userName', title: '身份证号码',align:'center'}
			      ,{field: 'userPhone', title: '手机号', width:230, align:'center'}
			      ,{field: 'userEmail', title: '电子邮箱', width:230,align:'center'} 
			      ,{field: 'role', title: '城市', align:'center',templet: '#roleTpl'}
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
					 	console.log(data)
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
					      layer.close(

						  );
					      //向服务端发送删除指令
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