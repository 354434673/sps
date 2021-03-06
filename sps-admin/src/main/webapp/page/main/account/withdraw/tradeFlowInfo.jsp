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
    <title>交易流水</title>
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
                <div class="layui-input-inline" style="width: 300px;">
                    <input id="time"   readonly="" type="text" name="startTime"  lay-verify="" placeholder="选择范围 " autocomplete="off" class="layui-input">
                </div>
                <label class="layui-form-label">交易状态:</label>
                <div class="layui-input-inline">
                    <select  id="status" lay-filter="withDrawState">
                        <option value="">全部</option>
                        <option value="0">支出</option>
                        <option value="1">收入</option>
                    </select>
                </div>

            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">交易金额:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="minAmount" lay-verify="required">
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="maxAmount" lay-verify="required">
                </div>
                <label class="layui-form-label">交易方:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="account"  lay-verify="required">
                </div>

            </div>
            <div class="layui-form-item">

                <label class="layui-form-label">备注:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="beizhu" lay-verify="required">
                </div>
                <button class="layui-btn layui-btn-primary" id="search">查询</button>
                <button class="layui-btn layui-btn-primary" id="reset">重置</button>
            </div>
        </div>
        <table id="drawAudioList" lay-filter="drawAudioTables"></table>
    </div>
    <script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
    <script type="text/html" id="type">
        {{#    if(d.payType == '0'){  }}
        支出
        {{#  } else if(d.payType == '1'){ }}
        收入
        {{#  } }}

    </script>
    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    </script>


    <script type="text/html" id="date">
        {{#    if(d.payDate != null){  }}
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

        {{#  } }}


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
                ,url: '<%=path%>/tradeFlow/tradeFlowList' //数据接口
                ,id:'id'
                ,page:true
                ,cols: [[ //表头
                    {type:'numbers', title: '序号',align:'center'}
                    ,{field: 'payDate', title: '交易时间', width:230, align:'center',templet: '#date'}
                    ,{field: 'payType', title: '类型',align:'center' ,templet: '#type'}
                    ,{field: 'amount', title: '交易金额',width:230,align:'center'}
                    ,{field: 'tradeNo', title: '流水号',width:230,align:'center'}
                    ,{field: 'companyName', title: '交易方',align:'center' }
                    ,{field: 'remark', title: '备注',event: 'setStatus', width:140,align:'center'}
                    ,{field: 'tool', title: '交易明细',width:270,align:'center', event: 'setSign' ,toolbar:'#bar'}                ]]
            });
            //查询
            $('#search').on('click',function(){
                var date= $('#time').val().split('至');
                var startTime = date[0];
                var endTime = date[1];
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
                        payType:withDrawState,
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
            //监听工作条
            table.on('tool(drawAudioTables)', function(obj){
                var data = obj.data;
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if(layEvent === 'detail'){ //查看
                    if(data.orderId==undefined ){
                        if(data.remark=='提现'){
                            location.href = '<%=path%>/page/main/account/withdraw/withdrawDetail.jsp?tradeSerialNum='+data.auditSerialNum  ;
                        }
                        if( data.remark=='充值'){
                            location.href = '<%=path%>/page/main/account/recharge/rechargeDetail.jsp?tradeSerialNum='+data.auditSerialNum  ;
                        }
                    }else{
                        location.href = '<%=path%>/page/main/account/withdraw/tradeDetail.jsp?auditSerialNum='+data.auditSerialNum  ;

                    }
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
            var dat =[year,month,date].join('-');
            var tad = [23,59,59].join(':');
            return [dat,tad].join(' ');
        }
    </script>


</bod>

</html>