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
    <title>品牌管理</title>
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
            <label class="layui-form-label">品牌名称:</label>
            <div class="layui-input-inline">
                <input id="querybrandName" type="text" name="username" lay-verify="" placeholder="请输入品牌名称"
                       autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">英文名称:</label>
            <div class="layui-input-inline">
                <input id="brandEnglishName" type="text" name="name" lay-verify="" placeholder="请输入英文名称"
                       autocomplete="off" class="layui-input">
            </div>
            <button class="layui-btn layui-btn-primary" id="queryUser">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetUser">重置</button>
        </div>
    </div>
    <div>
        <blockquote class="layui-elem-quote">
            <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                <i class="layui-icon">&#xe608;</i> 新增品牌
            </a>
        </blockquote>
    </div>
    <table id="brandList" lay-filter="brandTables"></table>
</div>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="roleTpl">
    {{#  layui.each(d.role, function(index, item){ }}
    {{item.roleName}},
    {{#  }); }}
</script>
<script>
    /*  $(function () {
          $('#queryUser').html("查询");
          $('#brandEnglishName').val(" ")
      })*/
    layui.use(['table', 'laypage', 'layer'], function () {
        var table = layui.table;
        var laypage = layui.laypage;
        var layer = layui.layer
        var $ = layui.jquery
        $('#add').on('click', function () {
            window.location.href = "<%=path%>/brand/toAddOrEdit";
        });
        table.render({
            elem: '#brandList'
            , height: 500
            , url: '<%=path%>/brand/brandList' //数据接口
            , id: 'brandId'
            , page: true
            , cols: [[ //表头
                {field: 'brandName', title: '品牌名称', align: 'center'}
                , {field: 'brandEnglishName', title: '英文名称', align: 'center'}
                , {field: 'brandAbbreviation', title: '简称', width: 230, align: 'center'}
                , {field: 'brandCategoryNames', title: '关联类目', width: 230, align: 'center'}
                /*  ,{field: 'role', title: '角色', align:'center',templet: '#roleTpl'}*/
                , {field: 'tool', title: '操作', width: 270, align: 'center', toolbar: '#bar'}
            ]]
        });
        //查询
        $('#queryUser').on('click', function () {
            var brandName = $('#querybrandName').val()
            var brandEnglishName = $('#brandEnglishName').val()
            table.reload('brandId', {
                where: {brandName: brandName, brandEnglishName: brandEnglishName}
            });
        })
        //重置
        $('#resetUser').on('click', function () {
            $('#querybrandName').val('')
            $('#brandEnglishName').val('')
        })
        //监听工作条
        table.on('tool(brandTables)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            /* console.log(data)*/
            if (layEvent === 'detail') { //查看
                // window.location.href="/sps-admin/brand/findEntity?id="+data.brandId;
                layer.open({
                    type: 2,
                    area: ['100%', '100%'],//宽高
                    content: '<%=path%>/page/main/brand/detail.jsp',//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function (layero, index) {
                        var body = layer.getChildFrame('body', index);
                        body.find('input').attr({"disabled": "disabled"});
                        body.find('#brandId').val(data.brandId)
                        body.find('#big').attr('src',"<%=path%>/upload/imgs/"+data.brandBigUrl);
                        body.find('#small').attr('src',"<%=path%>/upload/imgs/"+data.brandSmallUrl);
                        body.find('#brandName').val(data.brandName)
                        body.find('#brandEnglishName').val(data.brandEnglishName)
                        body.find('#brandAbbreviation').val(data.brandAbbreviation)
                        body.find('#brandCategoryNames').val(data.brandCategoryNames)
                        body.find('#categoryParentId').val(data.categoryParentId)
                        body.find('#brandDes').val(data.brandDes)
                    }
                });
            } else if (layEvent === 'del') { //删除
                $.ajax({
                    data: {id: data.brandId},//提交的数据
                    url: "<%=path%>/brand/checkBrand",//提交连接
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        if (result.flag == '1') {
                            layer.confirm('真的删除行么', function (index) {
                                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                layer.close(
                                    //向服务端发送删除指令
                                    $.ajax({
                                        data: {id: data.brandId},//提交的数据
                                        url: "<%=path%>/brand/delBrand",//提交连接
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
                            });
                        } else if (result.flag == '2') {
                            layer.msg("已有商品在使用该品牌，请重新选择！");
                        }
                    }
                })

            } else if (layEvent === 'edit') { //编辑
                //window.location.href="/sps-admin/brand/toAddOrEdit?id="+data.brandId;
                $.ajax({
                    data: {id: data.brandId},//提交的数据
                    url: "<%=path%>/brand/findEntity",//提交连接
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        if (result.flag == '1') {
                            layer.open({
                                type: 2,
                                area: ['100%', '100%'],//宽高
                                content: '<%=path%>/page/main/brand/addBrand.jsp',//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                                success: function (layero, index) {
                                    var body = layer.getChildFrame('body', index);
                                    //body.find('input').attr({"disabled":"disabled"});
                                    body.find("#showCategory").attr({"disabled": "disabled"});
                                    body.find('#brandId').val(data.brandId)
                                    body.find('#brandCategoryIds').val(data.brandCategoryIds)
                                    body.find('#brandName').val(data.brandName)
                                    body.find('#brandSmallUrl').val(data.brandSmallUrl)
                                    body.find('#brandBigUrl').val(data.brandBigUrl)
                                    body.find('#brandEnglishName').val(data.brandEnglishName)
                                    body.find('#brandCategoryNames').val(data.brandCategoryNames)
                                    body.find('#brandAbbreviation').val(data.brandAbbreviation)
                                    body.find('button').eq(0).html(data.brandCategoryNames)
                                    body.find('#brandDes').val(data.brandDes)
                                }
                            });
                        } else if (result.flag == '2') {
                            layer.msg("已有审核中的商品在使用该品牌，请审核通过后修改");
                        }
                    }
                })

            }
        });
    });
</script>
</body>
</html>