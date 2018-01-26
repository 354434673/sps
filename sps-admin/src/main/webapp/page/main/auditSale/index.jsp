<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <title>商品维护</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all"/>
    <style type="text/css">
    </style>
</head>
<body>
<div style="margin: 15px;">
    <div class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <label class="layui-form-label">核心商户名称:</label>
            <div class="layui-input-inline">
                <input id="shopName" type="text" name="shopName" lay-verify="" placeholder="请输入核心商户名称"
                       autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">核心商户账号:</label>
            <div class="layui-input-inline">
                <input id="shopNum" type="text" name="shopName" lay-verify="" placeholder="请输入核心商户账号"
                       autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">商品名称:</label>
            <div class="layui-input-inline">
                <input id="goodsName" type="text" name="goodsName" lay-verify="" placeholder="请输入商品名称"
                       autocomplete="off" class="layui-input">
            </div>


        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">修改时间:</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
            </div>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required">
            </div>
            <label class="layui-form-label">状态:</label>
            <div class="layui-input-inline">
                <select id="grounding" lay-filter="channelState">
                    <option value=""></option>
                    <option value="1">上架待审核</option>
                    <option value="2">上架审核通过</option>
                    <option value="3">上架审核不通过</option>
                </select>
            </div>
            <button class="layui-btn layui-btn-primary" id="queryGoods">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetGoods">重置</button>
        </div>
        <table id="goodsList" lay-filter="goodsTables"></table>
    </div>
    <script type="text/javascript"
            src="<%=path%>/page/layui/layui.js"></script>
    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
        <a class="layui-btn layui-btn-mini audit" lay-event="audit">审核</a>
    </script>

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
        return year + "-" + month + "-" + date + " " + hours+ ":" + minutes+ ":" + seconds;
        };
        }}
        {{ fn() }}
    </script>
    <script>
        layui.use(['table', 'laypage','laydate', 'layer'], function () {
            var table = layui.table;
            var laypage = layui.laypage;
            var layer = layui.layer
            var laydate = layui.laydate;
            var $ = layui.jquery;
            //加载日期框
            laydate.render({
                elem: '#startTime'
            });
            laydate.render({
                elem: '#endTime'
            });
            table.render({
                elem: '#goodsList'
                , height: 350
                , url: '<%=path%>/auditGood/goodsList' //数据接口
                , id: 'gId'
                , page: true
                , cols: [[ //表头
                      {field: 'gSpuName', title: '商品名称', width: 150, align: 'center'}
                    ,{field: 'gSpuNo', title: '商品编号', width: 150, align: 'center'}
                    ,{field: 'adminNum', title: '核心商户账号', width: 150, align: 'center'}
                    ,{field: 'companyName', title: '核心商户名称', width: 150, align: 'center'}
                    , {field: 'categoryName', title: '自定义分类', width: 100, align: 'center'}
                    , {field: 'gRecommend', title: '是否推荐', width: 80, align: 'center',}
                    , {field: 'gUpdateTime',  templet:'#date', title: '最后修改时间', width: 150, align: 'center'}
                    , {field: 'gStatus', title: '商品状态', width: 150, align: 'center'}
                 /*   , {field: 'gStatus', title: '流程状态', width: 150, align: 'center'}*/
                    ,{field: 'tool', title: '操作', width:270,align:'center',toolbar:'#bar'}
                ]], done: function (res, page, count) {
                    $("[data-field='gRecommend']").children().each(function () {
                        if ($(this).text() == '0') {
                            $(this).text("否")
                        } else if ($(this).text() == '1') {
                            $(this).text("是")
                        }
                    })
                    $("[data-field='gStatus']").children().each(function () {
                        if ($(this).text() == '0') {
                            $(this).text("待提交")
                            $(this).parent().parent().find(".audit").hide();
                        } else if ($(this).text() == '1') {
                            $(this).text("审核中")
                            $(this).parent().parent().find(".audit").hide();
                        } else if ($(this).text() == '2') {
                            $(this).text("审核通过")
                            $(this).parent().parent().find(".audit").show();
                        } else if ($(this).text() == '3') {
                            $(this).parent().parent().find(".audit").hide();
                            $(this).text("审核不通过")
                        }
                    })
                    $("[data-field='gGroundingFlag']").children().each(function () {
                        if ($(this).text() == '0') {
                            $(this).text("已下架")
                        } else if ($(this).text() == '1') {
                            $(this).text("上架待审核")
                        } else if ($(this).text() == '3') {
                            $(this).text("上架未通过")
                        } else if ($(this).text() == '4') {
                            $(this).text("上架已通过")
                        }
                    })


                }
            });
            //查询
            $('#queryGoods').on('click', function () {
                var shopName = $('#shopName').val();
                var shopNum = $('#shopNum').val();
                var endTime = $('#endTime').val();
                var startTime = $('#startTime').val();
                var goodsName = $('#goodsName').val();
                var grounding = $('#grounding').val();
                var status = $('#status').val();
                table.reload('gId', {
                    where: { goodsName: goodsName,endTime:endTime,startTime:startTime,shopStatus:grounding,flowStatus:status,shopName:shopName,shopNumber:shopNum}
                });
            })
            //重置
            $('#resetGoods').on('click', function () {
                $('#goodsName').val('')
                $('#skuNo').val('')
            })
            //监听工作条
            table.on('tool(goodsTables)', function (obj) {
                var data = obj.data;
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if (layEvent === 'detail') { //查看
                    window.location.href = "<%=path%>/auditGood/toGoodsDetail?id=" + data.gId;
                } else if (layEvent === 'del') { //删除
                    layer.confirm('真的删除行么', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(
                            $.ajax({
                                data: {id: data.gId},//提交的数据
                                url: "<%=path%>/goods/delGoods",//提交连接
                                type: 'post',
                                dataType: 'json',
                                success: function (result) {
                                    if (result.flag == '1') {
                                        layer.msg("删除成功");
                                    } else {
                                        layer.msg("操作失败");
                                    }
                                }
                            })
                        );
                        //向服务端发送删除指令
                    });
                } else if (layEvent === 'audit') { //编辑
                    window.location.href = "<%=path%>/auditGood/toAudit?id=" + data.gId;
                }
            });
        });
    </script>
</body>
</html>