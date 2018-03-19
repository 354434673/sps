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
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
<div >
			<div align="center" style="padding-top: 100px" id="pic">
			</div>
				 <div style="padding-top: 100px" align="center">
					 <button class="layui-btn layui-btn-primary" onclick="javascript:history.back(-1)">返回</button>
				 </div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
<script type="text/javascript">
	  var gatherListJson = []
	layui.use(['form','table','element','layer'], function(){
	  var form = layui.form;
	  var $ = layui.jquery;
	  var layer = layui.layer;
	  var element = layui.element;
	  var index = 1;
	  var channelNum = getUrlParam("channelNum")
	  var clientNum = getUrlParam("clientNum")
	  var src = "<%=path%>/shopkeeper/getQRcode?channelNum="+channelNum+"&clientNum="+clientNum
	  var img = "<img src='"+src+"' alt='二维码'>"
	  $('#pic').html(img)
	  	        //获得url参数
       function getUrlParam(name) {
                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]);
                return null;
       }
	});
</script>
</body>
</html>