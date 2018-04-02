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
    <title>菜单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
    <style type="text/css">
        tr th{
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin: 15px;">
    <div class="layui-form-item layui-form-pane">
        <label class="layui-form-label">菜单名称:</label>
        <div class="layui-input-inline">
            <input id="menuName" type="text" name="menuName" lay-verify="required" placeholder="请输入查询菜单名称" autocomplete="off" class="layui-input">
        </div>
        <button class="layui-btn layui-btn-primary" id="queryMenu">查询</button>
        <button class="layui-btn layui-btn-primary" id="resetMenu">重置</button>
    </div>
    <div>
        <blockquote class="layui-elem-quote">
            <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                <i class="layui-icon">&#xe608;</i> 新增菜单
            </a>
        </blockquote>
    </div>
    <hr>
    <table id="menuList" lay-filter="menuTables"></table>
</div>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
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
                title:'新增角色',
                area: ['80%', '80%'],//宽高
                content: '<%=path%>/page/main/system/addRole.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                cancel: function(index, layero){
                    table.reload('roleId', {
                    });
                }
            });
        });
        table.render({
            elem: '#menuList'
            ,url:'<%=path %>/menu/getMenu.json'
            ,id:'menuId'
            ,page:true
            ,cols: [[ //表头
                {field: 'menuId', type:'numbers',title: 'ID', sort: true,width:50,align:'center'}
                ,{field: 'menuName', title: '菜单名称', align:'center'}
                ,{field: 'menuUrl', title: '功能地址',align:'center'}
                ,{field: 'menuMark', title: '操作端',align:'center'}
                ,{field: 'tool', title: '操作' ,align :'center',toolbar:'#bar'}
            ]]
        });
        //查询
        $('#queryMenu').on('click',function(){
            var menuName = $('#menuName').val()
            table.reload('roleId', {
                where: {menuName:menuName}
            });
        })
        //重置
        $('#resetMenu').on('click',function(){
            $('#menuName').val('')
        })

        //监听工作条
        table.on('tool(menuTables)', function(obj){
            var data = obj.data;
            console.log(data)
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'detail'){ //查看
                layer.open({
                    type: 2,
                    title:'查看角色',
                    area: ['70%', '80%'],//宽高
                    content: '<%=path%>/page/main/system/addRole.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function(layero, index){
                        var body = layer.getChildFrame('body', index);
                        body.find('input').attr({"disabled":"disabled"});
                        body.find('#roleName').val(data.roleName)
                        body.find('#roleDescribe').val(data.roleDescribe)
                    }
                });
            } else if(layEvent === 'del'){ //删除
                if(data.roleName == '管理员'){
                    layer.msg('管理员角色不可删除')
                }else{
                    layer.confirm('确认删除该角色？', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        $.post({
                            url:'<%=path%>/role/deleteRole',
                            dataType:'json',
                            data:{
                                roleID:index,
                                state:1
                            },
                            success:function(data){
                                if(data.state == 'success'){
                                    layer.msg(data.msg,{icon: 1});
                                }else{
                                    layer.msg(data.msg,{icon: 1});
                                }
                            },
                            error:function(){
                                layer.msg('系统错误',{icon: 2});
                            }
                        })
                    });
                }
            } else if(layEvent === 'edit'){ //编辑
                if(data.roleName == '管理员'){
                    layer.msg('管理员角色不可修改')
                }else{
                    layer.open({
                        type: 2,
                        title:'角色修改',
                        area: ['70%', '80%'],//宽高
                        content: '<%=path%>/page/main/system/addRole.jsp' ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                        success: function(layero, index){
                            var body = layer.getChildFrame('body', index);
                            body.find('#roleName').val(data.roleName)
                            body.find('#roleDescribe').val(data.roleDescribe)
                        },
                        cancel: function(index, layero){
                            table.reload('roleID', {
                            });
                        }
                    });
                }
            }
        });
    });
</script>

</body>

</html>