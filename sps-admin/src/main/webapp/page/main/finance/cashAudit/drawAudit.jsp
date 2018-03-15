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
<body>
		<div style="margin: 15px;">
			 <div class="layui-form layui-form-pane">
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">提现金额:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="amount"  >
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
                       	 	<input type="text" class="layui-input" id="companyName">
                    	</div>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">客户账号:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="userName" >
                    	</div>
			 		 	<label class="layui-form-label">余额:</label>
                        <div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="balance">
                    	</div>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">近30日提款合计金额:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="moneyAmount" >
                    	</div>
			 		 	<label class="layui-form-label">累计提款合计金额:</label>
                        <div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="totalAmount">
                    	</div>
			 	</div>
				 <div class="layui-form-item">

					 <div class="layui-input-inline">
						 <button class="layui-btn" lay-submit="" id="history">查看历史记录</button>					 </div>

				 </div>
				 <div class="layui-form-item layui-form-text">

					 <div class="layui-input-block">
						意见： <textarea placeholder="请输入内容" class="layui-textarea" id="content"></textarea></span>

					 </div>
				 </div>
				 <div class="layui-form-item">
					 <div class="layui-input-block">
						 <button class="layui-btn" lay-submit="" lay-filter="submit1">同意</button>
						 <button class="layui-btn" lay-submit="" id="refuse">拒绝</button>
						 <button class="layui-btn" lay-submit="" id="back">返回</button>
					 </div>
				 </div>
			 </div>

	</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>


		<script type="text/javascript">
			$(function () {
				var id=getUrlParam("id");
				$.ajax({
					url: '<%=path%>/cashAudit/findAuditDetailByApplicationDate'
					,type:'post'
					, dataType: 'json'
					, async: false
					,data:{id:id}
					, success: function (result) {
						$('#amount').val(result.amount);
						$('#bankCard').val(result.bankCard);
						$('#auditTime').val(result.applicationDate);
						$('#companyName').val(result.companyName);
						$('#userName').val(result.userName);
						$('#balance').val(result.balance);
						$('#moneyAmount').val(result.moneyAmount);
						$('#totalAmount').val(result.totalAmount);
					}
				});
			});
			function getUrlParam(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
				var r = window.location.search.substr(1).match(reg);
				if (r != null) return unescape(r[2]); return null;
			}
			var timer ;
			var lock = true;
			layui.use(['layer', 'form'], function () {
				var $ = layui.jquery;
				var layer = layui.layer ;
				var form = layui.form();
				var type;
				var id=getUrlParam("id");
				form.on('submit(submit1)',function (data) {
					if(!lock){    // 2.判断该锁是否打开，如果是关闭的，则直接返回
						return false;
					}
					lock = false;  //3.进来后，立马把锁锁住
					layer.msg('处理中...',
							{
								icon: 16,
								shade: 0.01,
								time:1200
							},
							function(){
								//发送一部请求到后台，保存审核状态
								$.ajax({
									url: '<%=path%>/cashAudit/saveAuditStatus'
									,type:'post'
									, dataType: 'json'
									, async: false
									,data:{id:id,type:'2'}
									, success: function (result) {
										var  msg = result.msg;
										layer.msg(msg)
										window.location.href = "<%=path%>/page/main/finance/cashAudit/index.jsp";
									}
								});


							}
					);

					return false;
				});

				lock = true;

                //返回
                $('#back').on('click',function(){
                    window.location.href = "<%=path%>/page/main/finance/cashAudit/index.jsp";
                });
				$('#history').on('click',function(){
					var userName=$('#userName').val();
					location.href = '<%=path%>/page/main/finance/cashAudit/historyInfo.jsp?userName='+userName;
				});


                //拒绝
                $('#refuse').on('click',function(){
                    //监听文本输入框是否有值
                     var content= $("#content").val();
                    if(content=='' || content==null){
                        layer.alert('拒绝时意见不可为空', {
                            icon: 5,
                            title: "提示"
                        });
                    }else{
						$.ajax({
							url: '<%=path%>/cashAudit/saveAuditStatus'
							,type:'post'
							,dataType: 'json'
							,async: false
							,data:{id:id,type:'1',content:content}
							, success: function (result) {
								window.location.href = "<%=path%>/page/main/finance/cashAudit/index.jsp";
							}
						});
					}
                });
			});


		</script>
</body>

	
</html>