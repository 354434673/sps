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
	<title>支出明细</title>
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
				<label class="layui-form-label">交易时间:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
				</div>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required">
				</div>
				<label class="layui-form-label">交易方:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="account"  lay-verify="required">
				</div>
				<button class="layui-btn layui-btn-primary" id="search">查询</button>
				<button class="layui-btn layui-btn-primary" id="reset">重置</button>

			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">交易金额:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="minAmount" lay-verify="required">
				</div>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="maxAmount" lay-verify="required">
				</div>
				<label class="layui-form-label">备注:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="beizhu" lay-verify="required">
				</div>

			</div>
		</div>
		<table id="drawAudioList" lay-filter="drawAudioTables"></table>
	</div>
	<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
	<script type="text/html" id="type">
		{{#    if(d.payType == '1'){  }}
		支出
		{{#  } else if(d.payType == '2'){ }}
		收入
		{{#  } }}

	</script>


	<script type="text/html" id="date">
		{{#
		var da = d.payDate;
		da = new Date(da);
		var year = da.getFullYear();
		var month = da.getMonth()+1;
		var date = da.getDate();
		var hours= da.getHours();
		var minutes= da.getMinutes();
		var seconds= da.getSeconds();
		console.log([year,month,date,hours,minutes,seconds].join('-'));
		var fn = function(){
		return year + "-" + month + "-" + date + " " + hours+ ":" + minutes+ ":" + seconds;
		};
		}}
		{{ fn() }}
	</script>
	<script>
		layui.use(['table', 'laypage', 'laydate', 'layer'], function () {

			var $ = layui.jquery;
			var table = layui.table;
			var laypage = layui.laypage;
			var layer = layui.layer ;
			var laydate = layui.laydate;
			//加载日期框
			laydate.render({
				elem: '#startTime',
				type: 'datetime'

			});
			laydate.render({
				elem: '#endTime',
				type: 'datetime'
			});
			table.render({
				elem: '#drawAudioList'
				,url: '<%=path%>/incomePayment/findPayment' //数据接口
				,id:'id'
				,page:true
				,cols: [[ //表头
					{type:'numbers', title: '序号',align:'center'}
					,{field: 'payDate', title: '交易时间', width:230, align:'center',templet: '#date'}
					,{field: 'payType', title: '收支类型',align:'center' ,templet: '#type'}
					,{field: 'amount', title: '交易金额',width:230,align:'center'}
					,{field: 'auditSerialNum', title: '流水号',width:230,align:'center'}
					,{field: 'companyName', title: '交易方',align:'center' }
					,{field: 'remark', title: '备注',event: 'setStatus', width:140,align:'center'}

				]]
			});
			//查询
			$('#search').on('click',function(){
				var startTime = $('#startTime').val();
				var endTime = $('#endTime').val();
				var minAmount = $('#minAmount').val();
				var maxAmount = $('#maxAmount').val();
				var withDrawState = $('#status').val();
				var name = $('#name').val();
				var reamrk = $('#beizhu').val();
				table.reload('id', {
					where: {
						applicationDate:startTime,
						payDate:endTime,
						minAmount:minAmount,
						maxAmount:maxAmount,
						companyName:name,
						reamrk:reamrk
					}
				});
			});
			//重置
			$('#reset').on('click',function(){
				$('input').val('')
				$('select').val('');
			});
		});
	</script>


</bod>

</html>