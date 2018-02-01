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

            <label class="layui-form-label">商品名称:</label>
            <div class="layui-input-inline">
                <input id="goodsName" type="text" name="goodsName" lay-verify="" placeholder="请输入商品名称"
                       autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">修改时间:</label>
            <div class="layui-input-inline">
                <%-- <input id="updateTime" type="text" name="goodsName" lay-verify="" placeholder="请输入商品名称"
                        autocomplete="off" class="layui-input">--%>
                <input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
            </div>
            <div class="layui-input-inline">
                <%-- <input id="updateTime" type="text" name="goodsName" lay-verify="" placeholder="请输入商品名称"
                        autocomplete="off" class="layui-input">--%>
                <input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品状态:</label>
            <div class="layui-input-inline">
                <select id="grounding" lay-filter="channelState">
                    <option value=""></option>
                    <option value="0">已下架</option>
                    <option value="1">已上架</option>
                    <option value="2">已删除</option>
                    <option value="3">未生效</option>
                </select>
            </div>
            <label class="layui-form-label">流程状态:</label>
            <div class="layui-input-inline">
                <select id="status" lay-filter="channelFlowState">
                    <option value=""></option>
                    <option value="0">待提交</option>
                    <option value="1">审核中</option>
                    <option value="2">审核通过</option>
                    <option value="3">审核失败</option>
                </select>

            </div>
            <button class="layui-btn layui-btn-primary" id="queryGoods">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetGoods">重置</button>
        </div>
        <div class="demoTable">
            <a href="javascript:;" class="layui-btn" id="add">
                新增商品
            </a>
            <button class="layui-btn" id="onSale" data-type="getCheckData">
                上架
            </button>
            <a href="javascript:;" class="layui-btn" id="noSale" data-type="noSale">
                下架
            </a>
            <a href="javascript:;" class="layui-btn" data-type="update">
                修改
            </a>
            <a href="javascript:;" class="layui-btn" data-type="detail">
                查看
            </a>
            <a href="javascript:;" class="layui-btn" id="onRecommend" data-type="onRecommend">
                置为推荐
            </a>
            <a href="javascript:;" class="layui-btn" id="noRecommend" data-type="noRecommend">
                取消推荐
            </a>
        </div>
        <table id="goodsList" lay-filter="goodsTables"></table>
    </div>
    <script type="text/javascript"
            src="<%=path%>/page/layui/layui.js"></script>
    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
        <a class="layui-btn layui-btn-mini" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
    </script>
    <script>
        layui.use(['table','form', 'laypage', 'laydate', 'layer'], function () {
            //时间戳的处理
            layui.laytpl.toDateString = function(d, format){
                if(d!=null){
                    var date = new Date(d || new Date())
                        ,ymd = [
                        this.digit(date.getFullYear(), 4)
                        ,this.digit(date.getMonth() + 1)
                        ,this.digit(date.getDate())
                    ]
                        ,hms = [
                        this.digit(date.getHours())
                        ,this.digit(date.getMinutes())
                        ,this.digit(date.getSeconds())
                    ];
                    format = format || 'yyyy-MM-dd HH:mm:ss';
                    return format.replace(/yyyy/g, ymd[0])
                        .replace(/MM/g, ymd[1])
                        .replace(/dd/g, ymd[2])
                        .replace(/HH/g, hms[0])
                        .replace(/mm/g, hms[1])
                        .replace(/ss/g, hms[2]);
                }else {
                    return '--';
                }

            }

            //数字前置补零
            layui.laytpl.digit = function(num, length, end){
                var str = '';
                num = String(num);
                length = length || 2;
                for(var i = num.length; i < length; i++){
                    str += '0';
                }
                return num < Math.pow(10, length) ? str + (num|0) : num;
            };
            var form = layui.form;
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

            $('#add').on('click', function () {
                window.location.href = "<%=path%>/page/main/goodShop/addGoods.jsp";
            });

            table.render({
                elem: '#goodsList'
                , height: 500
                , url: '<%=path%>/goodShop/goodsList' //数据接口
                , id: 'gId'
                , page: true
                , cols: [[ //表头
                    {field: 'gId', type: 'checkbox'}
                    /*    ,{field:'id', width:80, title: '', sort: true}*/
                    , {field: 'gSpuName', title: '商品名称', width: 230, align: 'center'}
                    , {field: 'categoryName', title: '自定义分类', width: 230, align: 'center'}
                    , {field: 'gRecommend', title: '是否推荐', width: 230, align: 'center'},
                    {field: 'gUpdateTime', title: '最后修改时间', templet: '<div>{{ layui.laytpl.toDateString(d.gUpdateTime) }}</div>'}
                 /*   , {field: 'gUpdateTime', templet: '#date', title: '最后修改时间', width: 230, align: 'center'}*/
                    , {field: 'gGroundingFlag', title: '商品状态', width: 163, align: 'center'}
                    , {field: 'gStatus', title: '流程状态', width: 164, align: 'center'}
                ]], done: function (res, page, count) {
                    //如果是异步请求数据方式，res即为你接口返回的信息。
                    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                    //分类显示中文名称

                    /* $("[data-field='gUpdateTime']").children().each(function(){
                         if($(this).text()!=''){
                             $(this).text(getLocalTime($(this).text()))
                         }
                     })*/

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
                        } else if ($(this).text() == '1') {
                            $(this).text("审核中")
                        } else if ($(this).text() == '2') {
                            $(this).text("审核通过")
                        } else if ($(this).text() == '3') {
                            $(this).text("审核不通过")
                        }
                    })
                    $("[data-field='gGroundingFlag']").children().each(function () {
                        if ($(this).text() == '0') {
                            $(this).text("已下架")
                        } else if ($(this).text() == '1') {
                            $(this).text("已上架")
                        } else if ($(this).text() == '2') {
                            $(this).text("已删除")
                        } else if ($(this).text() == '3') {
                            $(this).text("未生效")
                        }
                    })
                }
            });

            table.on('checkbox(goodsTables)', function (obj) {
                console.log(obj);
                console.log(obj.data.gId)
                console.log(obj.type);
            })
            var $ = layui.$, active = {
                getCheckData: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    list = "";
                    for (var i = 0; i < checkStatus.data.length; i++) {
                        if (i != checkStatus.data.length - 1) {
                            list += checkStatus.data[i].gId + ',';
                        } else {
                            list += checkStatus.data[i].gId
                        }
                    }
                    if (list != null && list != "") {
                        $.ajax({
                            url: "<%=path%>/goodShop/onSale",//提交连接
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            data: {ids: list, state: 1},
                            success: function (json) {
                                if (json.flag == "1") {
                                    layer.msg("上架成功");
                                    setTimeout(function () {
                                        window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                    }, 1000);
                                } else if (json.flag == "2") {
                                    layer.msg("请选择审核通过的商品");
                                }else if (json.flag == "3") {
                                    layer.msg("已有商品为上架状态，请重新选择");
                                }
                            }
                        });
                    }

                },
                noSale: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    list = "";
                    for (var i = 0; i < checkStatus.data.length; i++) {
                        if (i != checkStatus.data.length - 1) {
                            list += checkStatus.data[i].gId + ',';
                        } else {
                            list += checkStatus.data[i].gId
                        }
                    }
                    if (list != null && list != "") {
                        $.ajax({
                            url: "<%=path%>/goodShop/onSale",//提交连接
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            data: {ids: list, state: 0},
                            success: function (json) {
                                if (json.flag == "1") {
                                    layer.msg("下架成功");
                                    setTimeout(function () {
                                        window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                    }, 1000);
                                } else if (json.flag == "2") {
                                    layer.msg("请选择审核通过的商品");
                                }
                            }
                        });
                    }

                },
                onRecommend: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    list = "";
                    for (var i = 0; i < checkStatus.data.length; i++) {
                        if (i != checkStatus.data.length - 1) {
                            list += checkStatus.data[i].gId + ',';
                        } else {
                            list += checkStatus.data[i].gId
                        }
                    }
                    if (list != null && list != "") {
                        $.ajax({
                            url: "<%=path%>/goodShop/onRecommend",//提交连接
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            data: {ids: list, state: 1},
                            success: function (json) {
                                if (json.flag == "1") {
                                    layer.msg("推荐成功");
                                    setTimeout(function () {
                                        window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                    }, 1000);
                                } else if (json.flag == "2") {
                                    layer.msg("请选择审核通过的商品");
                                }else if (json.flag == "3") {
                                    layer.msg("已有商品为推荐状态，请重新选择");
                                }
                            }
                        });
                    }

                },
                noRecommend: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    list = "";
                    for (var i = 0; i < checkStatus.data.length; i++) {
                        if (i != checkStatus.data.length - 1) {
                            list += checkStatus.data[i].gId + ',';
                        } else {
                            list += checkStatus.data[i].gId
                        }
                    }
                    if (list != null && list != "") {
                        $.ajax({
                            url: "<%=path%>/goodShop/onRecommend",//提交连接
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            data: {ids: list, state: 0},
                            success: function (json) {
                                if (json.flag == "1") {
                                    layer.msg("取消推荐成功");
                                    setTimeout(function () {
                                        window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                    }, 1000);
                                } else if (json.flag == "2") {
                                    layer.msg("请选择审核通过的商品");
                                }
                            }
                        });
                    }

                },

                noRecommend: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    list = "";
                    for (var i = 0; i < checkStatus.data.length; i++) {
                        if (i != checkStatus.data.length - 1) {
                            list += checkStatus.data[i].gId + ',';
                        } else {
                            list += checkStatus.data[i].gId
                        }
                    }
                    if (list != null && list != "") {
                        $.ajax({
                            url: "<%=path%>/goodShop/onRecommend",//提交连接
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            data: {ids: list, state: 0},
                            success: function (json) {
                                if (json.flag == "1") {
                                    layer.msg("取消推荐成功");
                                    setTimeout(function () {
                                        window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                    }, 1000);
                                } else if (json.flag == "2") {
                                    layer.msg("请选择审核通过的商品");
                                }
                            }
                        });
                    }

                },
                detail: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    list = "";
                    if (checkStatus.data.length > 1) {
                        layer.msg("请选择一条商品信息")
                    } else {
                        list = checkStatus.data[0].gId
                    }
                    if (list != null && list != "") {
                        window.location.href = "<%=path%>/goodShop/toGoodsDetail?id=" + list;
                    }

                },
                update: function () { //获取选中数据
                    var checkStatus = table.checkStatus('gId')
                        , data = checkStatus.data;
                    if(data[0].gStatus==1){
                        layer.msg("审核中商品不允许修改，请重新选择！");
                        return false;
                    }
                    list = "";
                    if (checkStatus.data.length > 1) {
                        layer.msg("请选择一条商品信息")
                    } else {
                        list = checkStatus.data[0].gId
                    }
                    if (list != null && list != "") {
                        window.location.href = "<%=path%>/goodShop/toAddOrEdit?id=" + list;
                    }
                }



                /*,getCheckLength: function(){ //获取选中数目
                    var checkStatus = table.checkStatus('idTest')
                        ,data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                }
                ,isAll: function(){ //验证是否全选
                    var checkStatus = table.checkStatus('idTest');
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                }*/
            };
            $('.demoTable .layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });


            //查询
            $('#queryGoods').on('click', function () {
                var endTime = $('#endTime').val();
                var startTime = $('#startTime').val();
                var goodsName = $('#goodsName').val();
                var grounding = $('#grounding').val();
                var status = $('#status').val();
                if(endTime!=''&&startTime!=''){
                    if(endTime<startTime){
                        layer.msg("结束时间不能小于开始时间")
                        return false;
                    }
                }


                table.reload('gId', {
                    where: {
                        goodsName: goodsName,
                        endTime: endTime,
                        startTime: startTime,
                        shopStatus: grounding,
                        flowStatus: status
                    }
                });
            })
            //重置
            $('#resetGoods').on('click', function () {
                $('#endTime').val('');
                $('#startTime').val('');
                $('#goodsName').val('');
                $('#grounding').val('');
                $('#status').val('');
                form.render('select')
            })
            //监听工作条
            table.on('tool(goodsTables)', function (obj) {
                var data = obj.data;
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if (layEvent === 'detail') { //查看
                    window.location.href = "<%=path%>/goods/toGoodsDetail?id=" + data.gId;
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
                } else if (layEvent === 'edit') { //编辑
                    window.location.href = "<%=path%>/goods/toAddOrEdit?id=" + data.gId;
                }
            });
        });
    </script>
</body>
</html>