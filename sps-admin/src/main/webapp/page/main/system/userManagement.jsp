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
	tr th{
		text-align: center;
	}
</style>
</head>
<body>
	<div style="margin: 15px;">
	    <div class="layui-form-item layui-form-pane">
		    <label class="layui-form-label">用户名:</label>
		    <div class="layui-input-inline">
		      <input type="text" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label">姓名:</label>
		    <div class="layui-input-inline">
		      <input type="text" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		    	<button class="layui-btn layui-btn-primary">查询</button>
		    	<button class="layui-btn layui-btn-primary">重置</button>
        </div>  
		<div>
			<blockquote class="layui-elem-quote">
				<a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
					<i class="layui-icon">&#xe608;</i> 新增用户
				</a>
			</blockquote>
		</div>
		<hr>
		<table lay-even class="layui-table ">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="250">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>用户名</th>
					<th>姓名</th>
					<th>联系电话</th>
					<th>电子邮箱</th>
					<th>角色</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>admin</td>
					<td>xxx</td>
					<td>135****4567</td>
					<td>35******@qq.com</td>
					<td>管理员</td>
					<td>
					<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 修改
					</a>
					<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 删除
					</a>
					<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 查看
					</a>
					</td>
				</tr>
				<tr>
					<td>admin</td>
					<td>xxx</td>
					<td>135****4567</td>
					<td>35******@qq.com</td>
					<td>管理员</td>
					<td>
					<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 修改
					</a>
					<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 删除
					</a>
					<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 查看
					</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
	<script>
		layui.use(['layer'], function(){
			  var layer = layui.layer
			  ,layer = layui.layer
		  layer.open({
			  type: 2, 
			  area: ['900px', '400px'],//宽高
			  content: '<%=path%>/page/main/system/addUser.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		  }); 
		});  
	</script>
</body>
</html>