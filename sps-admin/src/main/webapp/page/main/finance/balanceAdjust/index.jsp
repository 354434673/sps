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
	    <title>余额调整</title>
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
			 			<label class="layui-form-label">客户编号:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="kehuNo"  lay-verify="required">
                    	</div>
                    	
			 		 	<label class="layui-form-label">客户名称:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="kehuName"  lay-verify="required">
                    	</div>
                    	<button class="layui-btn layui-btn-primary" id="search">查询</button>
                    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">调整日期:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
                    	</div>
                    	<div class="layui-input-inline">
                        	<input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required">
                    	</div>
			 	</div>
				 <div>
					 <blockquote class="layui-elem-quote">
						 <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
							 <i class="layui-icon">&#xe608;</i> 新增
						 </a>
					 </blockquote>
				 </div>
			 </div>
			 <table id="balanceAudioList" lay-filter="balanceAdjustTables"></table>
	</div>
<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
<script type="text/html" id="bar">
		<a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
</script>


<script type="text/html" id="date">
    {{#
    var da = d.applicationDate;
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
            ,url: '<%=path%>/cashAudit/findAudioList' //数据接口
            ,id:'id'
            ,page:true
            ,cols: [[ //表头
				 {field: 'kehuNo', title: '客户编号',align:'center'  }
                ,{field: 'kehuName', title: '客户名称',align:'center'  }
                ,{field: 'eforeBalance', title: '调整前余额',width:230,align:'center'}
                ,{field: 'afterBalance', title: '调整后余额', width:230, align:'center'}
                ,{field: 'adjustAmount', title: '调整金额',width:230,align:'center'}
                ,{field: 'adjustTime', title: '调整日期',align:'center' ,templet: '#date'}
                ,{field: 'tool', title: '操作',width:270,align:'center', event: 'setSign' ,toolbar:'#bar'}
            ]]
        });
      //查询
        $('#search').on('click',function(){
            var kehuNo = $('#kehuNo').val();
            var kehuName = $('#kehuName').val();
            var startTime = $('#startTime').val();
            var name = $('#endTime').val();
            table.reload('id', {
                where: {
					applicationDate:startTime,
					payDate:endTime,
					status:withDrawState,
					companyName:name,
					userName:account
                }
            });
        });
		$('#add').on('click', function() {
			window.location.href="<%=path%>page/main/finance/balanceAdjust/add.jsp";
		});
        //重置
        $('#reset').on('click',function(){
            $('input').val('')
            $('select').val('');
        });
      //监听工作条
        table.on('tool(balanceAdjustTables)', function(obj){
            var data = obj.data;
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'detail'){ //查看
                location.href = '<%=path%>/page/main/finance/cashAudit/historyInfo.jsp?userName='+data.userName;
            }
        });
    });
</script>    	 
        
        
</bod>
	
</html>