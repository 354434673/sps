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
			 		 	<label class="layui-form-label">客户名称:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="kehuName"  lay-verify="required">
                    	</div>
						<label class="layui-form-label">客户账号:</label>
						<div class="layui-input-inline">
							<input type="text" class="layui-input" id="kehuNo"  lay-verify="required">
						</div>
                    	<button class="layui-btn layui-btn-primary" id="search">查询</button>
                    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
			 	</div>
			 <table id="balanceAudioList" lay-filter="balanceAdjustTables"></table>
				 <button class="layui-btn layui-btn-primary" id="cancel">取消</button>
				 <button class="layui-btn layui-btn-primary" id="confirm">确认</button>
	</div>
<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
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
				 {field: 'number', title: '选择',align:'center'  }
                ,{field: 'kehuName', title: '客户账号',align:'center'  }
                ,{field: 'eforeBalance', title: '客户名称',width:230,align:'center'}
                ,{field: 'afterBalance', title: '组织机构代码', width:230, align:'center'}
            ]]
        });
      //查询
        $('#search').on('click',function(){
            var kehuName = $('#kehuName').val();
            var kehuNo = $('#kehuNo').val();
            table.reload('id', {
                where: {
					kehuName:kehuName,
					kehuNo:kehuNo
                }
            });
        });
		$('#cancel').on('click', function() {
			window.location.href="<%=path%>page/main/finance/balanceAdjust/add.jsp";
		});
		$('#confirm').on('click', function() {
			window.location.href="<%=path%>page/main/finance/balanceAdjust/add.jsp";
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