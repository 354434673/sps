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
	    <title>历史记录信息</title>
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
			<table id="drawAudioList" lay-filter="drawAudioTables"></table>

		</div>
		<div class="layui-form-item" align="left" style="padding-left: 260px;">
			<button class="layui-btn" lay-filter="submitBankVerify" lay-submit  id="submitBankVerify">返回</button>
		</div>
	<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
	<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
	<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>
	<script type="text/javascript">

		function getUrlParam(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null) return unescape(r[2]); return null;
		}

		layui.use(['table', 'laypage', 'laydate', 'layer'], function () {
			var $ = layui.jquery;
			var table = layui.table;
			var laypage = layui.laypage;
			var layer = layui.layer ;
			var laydate = layui.laydate;
			var userName = getUrlParam("userName");
			//获得url参数
			table.render({
				elem: '#drawAudioList'
				,url: '<%=path%>/cashAudit/findAuditDetail'//数据接口
				,id:'id'
				,page:true
				,where: {userName:userName}
				,cols: [[ //表头
					{field: 'applicationDate', title: '提现申请日期', width:230, align:'center',templet: '#date'}
					,{field: 'amount', title: '提现金额',width:230,align:'center'}
				]]
			});
			var form = layui.form();
				form.on('submit(submitBankVerify)',function (data) {
					window.location.href = "<%=path%>/page/main/finance/cashAudit/index.jsp";
				});
			});


	</script>
</bod>
	
</html>