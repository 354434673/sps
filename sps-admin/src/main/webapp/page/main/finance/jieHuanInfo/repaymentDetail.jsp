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
	<title>借贷明细</title>
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
	<div class="layui-form-item" style="border-left-width: 525px;padding-left: 530px;">
		<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" >返回</button>
	</div>
	<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
	<script type="text/html" id="bar">
	</script>

	<script type="text/html" id="date">
		{{#
		var da = d.repayDate;
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
			var orderid = getUrlParam("orderid");
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
				,url: '<%=path%>/loan/queryLoanDetail' //数据接口
				,id:'id'
				,page:true
				,where: {orderid:orderid}
				,cols: [[ //表头
					{type:'numbers', title: '序号',align:'center'}
					,{field: 'repayDate', title: '还款日期', width:230, align:'center',templet: '#date'}
					,{field: 'repayAmount', title: '还款金额',align:'center' }
					,{field: 'repayBenAmount', title: '还本金金额',align:'center' }
					,{field: 'repayAccrualAmount', title: '还利息金额',align:'center' }
					,{field: 'rapayPoundage', title: '还逾期手续费金额',align:'center' }
					,{field: 'noRepayBenAmount ', title: '剩余未还本金',align:'center' }
					,{field: 'noReapayAccrualAmount', title: '剩余未还利息',align:'center' }
					,{field: 'noRepayPoundage', title: '剩余未还逾期手续费',align:'center'  ,templet: '#state' }
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
				table.reload('id', {
					where: {
						loanStartTime:startTime,
						loanEndTime:endTime,
						orderNo:minAmount,
						loanName:maxAmount,
						loanStatus:withDrawState,
						companyName:name

					}
				});
			});
			//重置
			$('#reset').on('click',function(){
				$('input').val('')
				$('select').val('');
			});
			//监听工作条
			table.on('tool(drawAudioTables)', function(obj){
				var data = obj.data;
				var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				var tr = obj.tr; //获得当前行 tr 的DOM对象
				if(layEvent === 'detail') { //查看
					location.href = '<%=path%>/page/main/finance/jieHuanInfo/repaymentDetail.jsp';
				}
			});
		});
	</script>


</bod>

</html>