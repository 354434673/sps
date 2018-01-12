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
    <title>自定义分类管理</title>
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
            <label class="layui-form-label">自定义分类名称:</label>
            <div class="layui-input-inline">
                <input id="queryCustomName" type="text" name="queryCustomName"  lay-verify="" placeholder="请输入自定义分类名称" autocomplete="off" class="layui-input">
            </div>
            <button class="layui-btn layui-btn-primary" id="queryUser">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetUser">重置</button>
        </div>
    </div>
    <div>
        <blockquote class="layui-elem-quote">
            <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                <i class="layui-icon">&#xe608;</i> 新增分类
            </a>
        </blockquote>
    </div>
    <table id="customList" lay-filter="customTables"></table>
</div>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
</script>
<script>
    layui.use(['table','laypage','layer'], function(){
        var table = layui.table;
        var laypage = layui.laypage;
        var layer = layui.layer
        var $ = layui.jquery
        $('#add').on('click', function() {
            layer.open({
                type: 2,
                area: ['50%', '80%'],//宽高
                content: '<%=path%>/page/main/custom/addCustomCategory.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                cancel: function(index, layero){
                    table.reload('userId', {
                    });
                }
            });
        });
        table.render({
            elem: '#customList'
            ,height: 350
            ,url: '<%=path%>/customCategory/customCategoryList' //数据接口
            ,id:'customId'
            ,page:true
            ,cols: [[ //表头
                {field: 'customId', title: 'ID', sort: true,width:50,align:'center'}
                ,{field: 'customName', title: '分类名称',align:'center'}
                ,{field: 'customWide', title: '优先级', width:230, align:'center'}
                ,{field: 'tool', title: '操作', width:270,align:'center',toolbar:'#bar'}
            ]]
        });
        //查询
        $('#queryUser').on('click',function(){
            var name = $('#queryCustomName').val()
            var brandEnglishName = $('#brandEnglishName').val()
            table.reload('customId', {
                where: {name:name}
            });
        })
        //重置
        $('#resetUser').on('click',function(){
            $('#queryCustomName').val('')
        })
        //监听工作条
        table.on('tool(customTables)', function(obj){
            var data = obj.data;
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
           if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(
                        $.ajax({
                            data: {id: data.customId},//提交的数据
                            url: "/sps-admin/customCategory/delCustomCategory",//提交连接
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
                //window.location.href="/sps-admin/brand/toAddOrEdit?id="+data.brandId;
                layer.open({
                    type: 2,
                    area: ['50%', '80%'],//宽高
                    content: '<%=path%>/page/main/custom/addCustomCategory.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function(layero, index){
                        var body = layer.getChildFrame('body', index);
                        //body.find('input').attr({"disabled":"disabled"});
                        body.find('#customId').val(data.customId)
                        body.find('#customName').val(data.customName)
                        body.find('#customWide').val(data.customWide)
                    }
                });
            }
        });
    });
</script>
</body>
</html>