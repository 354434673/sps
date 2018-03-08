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
	<title>借款情况</title>
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
				<div class="layui-input-inline" style="width: 300px;">
					<input id="time"   readonly="" type="text" name="startTime"  lay-verify="" placeholder="选择范围 " autocomplete="off" class="layui-input">
				</div>

				<label class="layui-form-label">状态:</label>
				<div class="layui-input-inline">
					<select  id="loanStatus" lay-filter="withDrawState">
						<option value="0">全部</option>
						<option value="10">待还款</option>
						<option value="11">已结清</option>
						<option value="12">已逾期</option>
					</select>
				</div>

			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">订单编号:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="orderNo" lay-verify="required">
				</div>
				<label class="layui-form-label">借款人:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="loanName"  lay-verify="required">
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
	<script type="text/html" id="flag">
		{{#    if(d.flag == 10){  }}
		待还款
		{{#  } else if(d.flag == 11){ }}
		已结清
		{{#  } else if(d.flag == 12){ }}
		已逾期
		{{#  } }}
	</script>


	<script type="text/html" id="date">
		{{#
		var da = d.loanStartTime;
		da = new Date(da);
		var year = da.getFullYear();
		var month = da.getMonth()+1;
		var date = da.getDate();
		var hours= da.getHours();
		var minutes= da.getMinutes();
		var seconds= da.getSeconds();
		var daa=d.loanEndTime;
		console.log([year,month,date,hours,minutes,seconds].join('-'));
		var fn = function(){
		return year + "-" + month + "-" + date + " " + hours+ ":" + minutes+ ":" + seconds;
		};
		}}
		{{ fn() }}
	</script>
	<script type="text/html" id="date1">
		{{#
		var daa=d.loanEndTime;
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
            var newDate = new Date().setDate(new Date().getDate() - 60)//60天以前的日期
            //执行一个laydate实例
            laydate.render({
                elem: '#time', //指定元素
                type:'datetime',
                range: '至',
                min: getDate(newDate),
                max: getDate()
            });
			table.render({
				elem: '#drawAudioList'
				,url: '<%=path%>/loan/findLoanList'  //数据接口
				,id:'id'
				,page:true
				,cols: [[ //表头
					{type:'numbers', title: '序号',align:'center'}
					,{field: 'orderid', title: '订单编号', width:230, align:'center'}
					,{field: 'loanCode', title: '借据号',align:'center' }
					,{field: 'shopkeeper', title: '借款人',width:230,align:'center'}
					,{field: 'loanStartTime', title: '借款起始日', width:230, align:'center',templet: '#date'}
					,{field: 'loanEndTime', title: '借款到期日', width:230, align:'center',templet: '#date1'}
					,{field: 'payment', title: '借款金额',align:'center' }
					,{field: 'loanBalance', title: '借款余额',align:'center' }
					,{field: 'formalityRate', title: '手续费率（每日）',align:'center' }
					,{field: 'serviceCharge', title: '应收手续费',align:'center' }
					,{field: 'servicescale', title: '代销服务费率',align:'center' }
					,{field: 'servicemoney', title: '代销服务费',align:'center' }
					,{field: 'flag', title: '状态',align:'center'  ,templet: '#state', templet: '#flag' }
					,{field: 'tool', title: '还款情况',width:270,align:'center', event: 'setSign' ,toolbar:'#bar'}
				]]
			});
			//查询
			$('#search').on('click',function(){
                var date= $('#time').val().split('至');
                var startTime = date[0];
                var endTime = date[1];
				var orderNo = $('#orderNo').val();
				var loanStatus = $('#loanStatus').val();
				var loanName = $('#loanName').val();
				table.reload('id', {
					where: {
						loanStartTime:startTime,
						loanEndTime:endTime,
						orderNo:orderNo,
						loanName:loanName,
						loanStatus:loanStatus
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
					location.href = '<%=path%>/page/main/finance/jieHuanInfo/repaymentDetail.jsp?orderid='+data.orderid;
				}
			});
		});
        //时间格式化
        function getDate(data){
            if(data == null || data == ""){
                da = new Date();
            }else{
                da = new Date(data);
            }
            var year = da.getFullYear();
            var month = da.getMonth()+1;
            var date = da.getDate();
			/*var hours= da.getHours();
			 var minutes= da.getMinutes();
			 var seconds= da.getSeconds();*/

            var dat =[year,month,date].join('-');
            var tad = [23,59,59].join(':');
            return [dat,tad].join(' ');
        }
	</script>


</bod>

</html>