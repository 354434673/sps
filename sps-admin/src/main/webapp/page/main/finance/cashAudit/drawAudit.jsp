<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <meta charset="UTF-8">
	    <title>审核</title>
	    <meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport"
	          content="width=device-width, initial-scale=1, maximum-scale=1">
	    <link rel="stylesheet"
	          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all"/>
	    <style type="text/css">
    </style>
	</head>
	<bod>
		<div style="margin: 15px;">
			 <div class="layui-form layui-form-pane">
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">提现金额:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="drawAmount"  >
                    	</div>
                    	
			 		 	<label class="layui-form-label">银行卡号:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="bankCard"  >
                    	</div>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">提现申请时间:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="auditTime" >
                    	</div>
			 		 	<label class="layui-form-label">客户名称:</label>
                        <div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="name">
                    	</div>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">客户账号:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="account" >
                    	</div>
			 		 	<label class="layui-form-label">余额:</label>
                        <div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="balance">
                    	</div>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">近30日提款合计金额:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="ljAmount" >
                    	</div>
			 		 	<label class="layui-form-label">累计提款合计金额:</label>
                        <div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="totalAmount">
                    	</div>
			 	</div>
			 </div>
			 <table id="drawAudioList" lay-filter="drawAudioTables"></table>
	</div>
<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
<script type="text/html" id="bar">
		<a class="layui-btn layui-btn-mini" lay-event="edit">审核</a>
    	<a class="layui-btn layui-btn-mini" lay-event="detail">查看历史记录</a>
    	
    	<a class="layui-btn layui-btn-mini" lay-event="detele">查看详情</a>
</script>


        
</bod>
	
</html>