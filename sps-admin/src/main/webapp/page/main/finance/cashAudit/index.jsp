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
	    <title>提现审核</title>
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
			 			<label class="layui-form-label">客户账号:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="account"  lay-verify="required">
                    	</div>
                    	
			 		 	<label class="layui-form-label">客户名称:</label>
                    	<div class="layui-input-inline">
                       	 	<input type="text" class="layui-input" id="name"  lay-verify="required">
                    	</div>
                    	<button class="layui-btn layui-btn-primary" id="search">查询</button>
                    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
			 	</div>
			 	<div class="layui-form-item">
			 			<label class="layui-form-label">提现时间:</label>
						<div class="layui-input-inline" style="width: 300px;">
							<input id="time"   readonly="" type="text" name="startTime"  lay-verify="" placeholder="选择范围 " autocomplete="off" class="layui-input">
						</div>

			 		 	<label class="layui-form-label">状态:</label>
                        <div class="layui-input-inline">
                            <select  id="status" lay-filter="withDrawState">
                            <option value="0">待审核</option>
							<option value="1">审核不通过</option>
                            <option value="2">审核通过</option>
							<option value="">全部</option>
                            </select>
                        </div>
			 	</div>
			 </div>
			 <table id="drawAudioList" lay-filter="drawAudioTables"></table>
	</div>
<script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
<script type="text/html" id="bar">
	{{#    if(d.status != '2'){  }}
		<a class="layui-btn layui-btn-mini" lay-event="edit">审核</a>
		<a class="layui-btn layui-btn-mini" lay-event="delete">查看历史记录</a>
	{{#  }  }}
	{{#    if(d.status == '2'){  }}
		<a class="layui-btn layui-btn-mini" lay-event="delete">查看历史记录</a>
	{{#  }  }}

</script>
<script type="text/html" id="withDrawStateTpl">
		{{#    if(d.status == '0'){  }}
		待审核
		{{#  } else if(d.status == '1'){ }}
		审核不通过
		{{#  } else if(d.status == '2'){ }}
		审核通过
		{{#  } }}
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
            ,url: '<%=path%>/cashAudit/findAudioList' //数据接口
            ,id:'id'
            ,page:true
            ,cols: [[ //表头
                 {type:'numbers', title: '序号',align:'center'}
				,{field: 'id', title: 'id',align:'center'  }
                ,{field: 'userName', title: '客户账号',align:'center'  }
                ,{field: 'companyName', title: '客户名称',align:'center'  }
                ,{field: 'amount', title: '提现金额',width:230,align:'center'}
                ,{field: 'applicationDate', title: '提现申请日期', width:230, align:'center',templet: '#date'}
                ,{field: 'moneyAmount', title: '近30日提款合计金额',width:230,align:'center'}
                ,{field: 'totalAmount', title: '累计提款合计金额',align:'center' }
                ,{field: 'status', title: '流程状态',event: 'setStatus', width:140,align:'center',templet: '#withDrawStateTpl'}
                ,{field: 'tool', title: '操作',width:270,align:'center', event: 'setSign' ,toolbar:'#bar'}
            ]], done: function (res, page, count) {
				$("[data-field='id']").css('display','none');
			}
        });
      //查询
        $('#search').on('click',function(){
            var date= $('#time').val().split('至');
            var startTime = date[0];
            var endTime = date[1];
            var withDrawState = $('#status').val();
            var name = $('#name').val();
            var account = $('#account').val();
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
			/*if(obj.event === 'setStatus'){
				if(data.status==='2'){
					var bar=$("#bar").find("a").get(0);
					bar.attr("visible", false);

				}*/
            if(layEvent === 'delete'){ //查看
                location.href = '<%=path%>/page/main/finance/cashAudit/historyInfo.jsp?userName='+data.userName;
            }
            if(layEvent === 'edit'){ //跳转至审核页面
                location.href = '<%=path%>/page/main/finance/cashAudit/drawAudit.jsp?id='+data.id;
            }
        });
    });
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