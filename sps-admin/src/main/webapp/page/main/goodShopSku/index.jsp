<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品信息管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
    <style type="text/css">
    </style>
</head>
<body>
<div style="margin: 15px;">
    <div class="layui-form layui-form-pane"  >
        <div class="layui-form-item">
            <label class="layui-form-label">SPU编号:</label>
            <div class="layui-input-inline">
                <input id="goodsNo" type="text" name="goodsNo"  lay-verify="" placeholder="请输入SPU编号" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">商品名称:</label>
            <div class="layui-input-inline">
                <input id="goodsName" type="text" name="goodsName"  lay-verify="" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">规格:</label>
            <div class="layui-input-inline">
                <input id="spec" type="text" name="spec"  lay-verify="" placeholder="请输入商品规格" autocomplete="off" class="layui-input">
            </div>
            <button class="layui-btn layui-btn-primary" id="queryGoods">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetGoods">重置</button>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">修改时间:</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
            </div>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required">
            </div>

        </div>
    </div>
    <div>
            <button class="layui-btn" id="add" data-type="getCheckData">
                提交
            </button>
    </div>
    <table id="goodsList" lay-filter="goodsTables"></table>
</div>
<script type="text/html" id="date">
    {{#
    var da = d.gUpdateTime;
    da = new Date(da);
    var year = da.getFullYear();
    var month = da.getMonth()+1;
    var date = da.getDate();
    var hours= da.getHours();
    var minutes= da.getMinutes();
    var seconds= da.getSeconds();
    console.log([year,month,date,hours,minutes,seconds].join('-'));
    var fn = function(){
    return [year,month,date].join('-');
    };
    }}
    {{ fn() }}
</script>
<script type="text/javascript"
        src="/sps-admin/page/layui/layui.js"></script>
<script>
    layui.use(['table','laypage','laydate','layer'], function(){
        var table = layui.table;
        var laypage = layui.laypage;
        var layer = layui.layer
        var laydate = layui.laydate;
        var $ = layui.jquery

        //加载日期框
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        table.render({
            elem: '#goodsList'
            ,height: 350
            ,url: '<%=path%>/goodShopSku/goodsList' //数据接口
            ,id:'gId'
            ,page:true
            ,cols: [[ //表头
                {field: 'gId', title: '序号', align:'center'}
                ,{field: 'gSku', title: 'SPU编号', align:'center'}
                ,{field: 'spuName', title: '商品名称',align:'center'}
                ,{field: 'gSize', title: '规格', width:230, align:'center'}
                ,{field: 'gPrice', title: '价格', width:230,align:'center'}
                ,{field: 'gStock', title: '库存', width:230,align:'center'}
                , {field: 'gUpdateTime', templet:'#date', title: '最后修改时间', width: 230, align: 'center'}
            ]], done: function (res, page, count) {
                $("[data-field='flowStatus']").children().each(function () {
                    if ($(this).text() == '0') {
                        $(this).text("待提交")
                    } else if ($(this).text() == '1') {
                        $(this).text("审核中")
                    } else if ($(this).text() == '2') {
                        $(this).text("审核不通过")
                    } else if ($(this).text() == '3') {
                        $(this).text("审核通过")
                    }
                })
            }
        });
        //查询
        $('#queryGoods').on('click',function(){
            var endTime = $('#endTime').val();
            var startTime = $('#startTime').val();
            var goodsNo = $('#goodsNo').val();
            var goodsName = $('#goodsName').val();
            var spec = $('#spec').val();
            table.reload('gId', {
                where: {goodSku:goodsNo, goodsName:goodsName,endTime:endTime,startTime:startTime,spec:spec}
            });
        })
        //重置
        $('#resetGoods').on('click',function(){
            $('#goodsName').val('')
            $('#skuNo').val('')
        })
    });
</script>
</body>
</html>