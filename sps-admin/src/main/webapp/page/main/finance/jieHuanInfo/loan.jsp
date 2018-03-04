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
	<title>借情况</title>
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
				<label class="layui-form-label">时间:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
				</div>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required">
				</div>
				<label class="layui-form-label">状态:</label>
				<div class="layui-input-inline">
					<select  id="status" lay-filter="withDrawState">
						<option value="0">全部</option>
						<option value="1">待还款</option>
						<option value="2">已结清</option>
						<option value="3">已逾期</option>
					</select>
				</div>

			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">订单编号:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="minAmount" lay-verify="required">
				</div>
				<label class="layui-form-label">借款人:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="account"  lay-verify="required">
				</div>
				<button class="layui-btn layui-btn-primary" id="search">查询</button>
				<button class="layui-btn layui-btn-primary" id="reset">重置</button>
			</div>

		</div>
		<table id="drawAudioList" lay-filter="drawAudioTables"></table>
	</div>
	<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
	<script type="text/html" id="bar">
		<a class="layui-btn layui-btn-mini" lay-event="detail">查看详情</a>
	</script>
	<script type="text/html" id="type">
		{{#    if(d.payType == '1'){  }}
		支出
		{{#  } else if(d.payType == '2'){ }}
		收入
		{{#  } }}

	</script>


	<script type="text/html" id="date">
		{{#
		var da = d.loanStartDate;
		da = new Date(da);
		var year = da.getFullYear();
		var month = da.getMonth()+1;
		var date = da.getDate();
		var hours= da.getHours();
		var minutes= da.getMinutes();
		var seconds= da.getSeconds();
		var daa=d.loanEndDate;
		daa = new Date(daa);
		var year = daa.getFullYear();
		var month = daa.getMonth()+1;
		var date = daa.getDate();
		var hours= daa.getHours();
		var minutes= daa.getMinutes();
		var seconds= daa.getSeconds();
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
				,url: '<%=path%>/loan/findLoanList' //数据接口
				,id:'id'
				,page:true
				,cols: [[ //表头
					{type:'numbers', title: '序号',align:'center'}
					,{field: 'orderNo', title: '订单编号', width:230, align:'center'}
					,{field: 'loanNo', title: '借据号',align:'center' }
					,{field: 'LoanName', title: '借款人',width:230,align:'center'}
					,{field: 'loanStartDate', title: '借款起始日', width:230, align:'center',templet: '#date'}
					,{field: 'loanEndDate', title: '借款到期日', width:230, align:'center',templet: '#date'}
					,{field: 'loanAmount', title: '借款金额',align:'center' }
					,{field: 'loanBalancel', title: '借款余额',align:'center' }
					,{field: 'shouXuFeiByDate', title: '手续费率（每日）',align:'center' }
					,{field: 'incomeShouXuFei', title: '应收手续费',align:'center' }
					,{field: 'daiXiaoFeilv ', title: '代销服务费率',align:'center' }
					,{field: 'daiXiaoFei', title: '代销服务费',align:'center' }
					,{field: 'status', title: '状态',align:'center'  ,templet: '#state' }
					,{field: 'tool', title: '还款情况',width:270,align:'center', event: 'setSign' ,toolbar:'#bar'}
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