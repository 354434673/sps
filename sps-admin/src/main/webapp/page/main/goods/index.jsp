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
            <label class="layui-form-label">流程状态:</label>
            <div class="layui-input-inline">
                <select   id="status" lay-filter="channelFlowState">
                    <option value=""></option>
                    <option value="0">待提交</option>
                    <option value="1">审核中</option>
                    <option value="2">审核不通过</option>
                    <option value="3">审核通过</option>
                </select>

            </div>
            <button class="layui-btn layui-btn-primary" id="queryGoods">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetGoods">重置</button>
        </div>
    </div>
    <div>
        <blockquote class="layui-elem-quote">
            <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                <i class="layui-icon">&#xe608;</i> 新增商品
            </a>
        </blockquote>
    </div>
    <table id="goodsList" lay-filter="goodsTables"></table>
</div>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="roleTpl">
    {{#  layui.each(d.role, function(index, item){ }}
    {{item.roleName}},
    {{#  }); }}
</script>
<script>
    layui.use(['table','laypage','layer'], function(){
        var table = layui.table;
        var form = layui.form;
        var laypage = layui.laypage;
        var layer = layui.layer
        var $ = layui.jquery
        $('#add').on('click', function() {
            window.location.href="<%=path%>/page/main/goods/addGoods.jsp";
        });
        table.render({
            elem: '#goodsList'
            ,height: 350
            ,url: '<%=path%>/goods/goodsList' //数据接口
            ,id:'gId'
            ,page:true
            ,cols: [[ //表头
                 {field: 'gSpuNo', title: 'SPU编号', align:'center'}
                ,{field: 'gSpuName', title: '商品名称',align:'center'}
                ,{field: 'gCategoryNames', title: '分类', width:230, align:'center'}
                ,{field: 'brandName', title: '品牌', width:230,align:'center'}
                ,{field: 'flowStatus', title: '流程状态', width:230,align:'center'}
                ,{field: 'tool', title: '操作', width:270,align:'center',toolbar:'#bar'}
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
            var goodsNo = $('#goodsNo').val();
            var goodsName = $('#goodsName').val();
            var status =$('#status').val();
            table.reload('gId', {
                where: {goodsNo:goodsNo, goodsName:goodsName,flowStatus:status}
            });
        })
        //重置
        $('#resetGoods').on('click',function(){
            $('#goodsName').val('')
            $('#goodsNo').val('')
            $('#status').val('')
            form.render('select');
        })
        //监听工作条
        table.on('tool(goodsTables)', function(obj){
            var data = obj.data;
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'detail'){ //查看
               window.location.href="<%=path%>/goods/toGoodsDetail?id="+data.gId;
            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
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
            } else if(layEvent === 'edit'){ //编辑
                window.location.href="<%=path%>/goods/toAddOrEdit?id="+data.gId;
            }
        });
    });
</script>
</body>
</html>