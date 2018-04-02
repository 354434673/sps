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
    <title>提现申请</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"  href="<%=path%>/page/layui/css/layui.css" media="all" />
    <style type="text/css">
        tr th{
            text-align: center;
        }
    </style>
</head>
<body>
 <div style="margin: 15px;">
        <div class="layui-form layui-form-pane">
            <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">提现时间:</label>
                <div class="layui-input-inline" style="width: 300px;">
                    <input id="time"   readonly="" type="text" name="startTime"  lay-verify="" placeholder="选择范围 " autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
            <div class="layui-form-item">
                  <label class="layui-form-label">状态:</label>
                  <div class="layui-input-inline" style="width: 300px;">
                      <select   id="status" lay-filter="withDrawState" >
                          <option value="">全部</option>
                          <option value="0">待提交</option>
                          <option value="1">审核中</option>
                          <option value="2">审核通过</option>
                          <option value="3">审核失败</option>
                      </select>
                  </div>
              </div>
            <div class="layui-form-item" >
                  <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                      <i class="layui-icon">&#xe608;</i> 新增
                  </a>

                  <button class="layui-btn layui-btn-primary" id="search">查询</button>
                  <button class="layui-btn layui-btn-primary" id="reset">重置</button>

                  <%--  <blockquote class="layui-elem-quote">
                        <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                            <i class="layui-icon">&#xe608;</i> 新增
                        </a>
                    </blockquote>--%>
              </div>
        </div>
     <table id="withdrawList" lay-filter="withdrawTables"></table>
</div>
 <script type="text/javascript" src="<%=path%>/page/layui/layui.all.js"></script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
</script>
<script type="text/html" id="withDrawStateTpl">
    {{#    if(d.tradeStatus == '0'){  }}
    待提交
    {{#  } else if(d.tradeStatus == '1'){ }}
    审核中
    {{#  } else if(d.tradeStatus == '2'){ }}
    审核通过
    {{#  } else if(d.tradeStatus == '3'){ }}
    审核失败
    {{#  } }}
</script>
<script type="text/html" id="date">
    {{#
    var da = d.applicationStartDate;
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
        var newDate = new Date().setDate(new Date().getDate() - 60)//60天以前的日期
        //执行一个laydate实例
        laydate.render({
            elem: '#time', //指定元素
            type:'datetime',
            range: '至',
            min: getDate(newDate),
            max: getDate()
        });

        $('#add').on('click', function() {
            /*
            *
            * */
            window.location.href="<%=path%>/page/main/account/withdraw/addWithdraw.jsp";
           <%--  window.location.href= '<%=path%>/page/main/account/withdraw/inputTradePwd.jsp?withdrawAmt=1'; --%>
        });
        table.render({
            elem: '#withdrawList'
            ,url: '<%=path%>/withdraw/findBankTradeList' //数据接口
            ,id:'tradeSerialNum'
            ,page:true
            ,cols: [[ //表头
                 {type:'numbers', title: '序号',align:'center'}
                ,{field: 'tradeSerialNum', title: '序列号', width:230, align:'center'}
                ,{field: 'applicationStartDate', title: '申请日期', width:230, align:'center',templet: '#date'}
                ,{field: 'tradeBeforeBalanc', title: '提现前余额',width:230,align:'center'}
                ,{field: 'tradeAfterBalanc', title: '提现后余额',align:'center' }
                ,{field: 'tradeAmount', title: '提现额度',align:'center'  }
                ,{field: 'tradeStatus', title: '状态', width:140,align:'center',templet: '#withDrawStateTpl'}
                ,{field: 'tool', title: '操作',width:270,align:'center',toolbar:'#bar'}
            ]] , done: function (res, page, count) {
            	 $("[data-field='tradeSerialNum']").css('display','none'); 
            }
        });

        //查询
        $('#search').on('click',function(){
            var date= $('#time').val().split('至');
            var startTime = date[0];
            var endTime = date[1];
            var withDrawState = $('#status').val();
            table.reload('tradeSerialNum', {
                where: {
                	applicationStartDate:startTime,
                    paymentDate:endTime,
                	tradeStatus:withDrawState
                }
            });
        });
        //重置
        $('#reset').on('click',function(){
            $('input').val('')
            $('select').val('');
        });
        //监听工作条
        table.on('tool(withdrawTables)', function(obj){
            var data = obj.data;
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'detail'){ //查看
 					location.href = '<%=path%>/page/main/account/withdraw/withdrawDetail.jsp?tradeSerialNum='+data.tradeSerialNum  ;
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
</body>
</html>