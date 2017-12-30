<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/page/static/treeTable/css/layui.css" media="all" />
</head>
<body>
<div style="margin: 15px;">
    <%--<div class="layui-form-item layui-form-pane" id="searchForm">
        <label class="layui-form-label">分类名称:</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="" placeholder="请输入分类名称" autocomplete="off" class="layui-input">
        </div>
        <button class="layui-btn layui-btn-primary">查询</button>
        <button class="layui-btn layui-btn-primary">重置</button>
    </div>--%>
    <div>
            <a href="javascript:;" class="layui-btn layui-btn-warm" id="add">
                <i class="layui-icon">&#xe608;</i> 新增分类
            </a>
    </div>
</div>
<div id="tree"></div>
</body>

<script src="<%=request.getContextPath() %>/page/static/treeTable/layui.js"></script>
<script src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(document).on("keyup", "#searchForm input", function (e) {
            if (e.keyCode == 13) {
            }
        });
    });



    var layout = [
        { name: '菜单名称', treeNodes: true, headerClass: 'value_col', colClass: 'value_col', style: 'width: 40%' },
        {name: '权重', field: 'categoryWeight', headerClass: 'value_col', colClass: 'value_col', style: 'width: 10%'},
        {name: '描述', field: 'categoryDes', headerClass: 'value_col', colClass: 'value_col', style: 'width: 20%'},
        {name: '图片', field: 'categoryUrl', headerClass: 'value_col', colClass: 'value_col', style: 'width: 20%'},
        {
            name: '操作',
            headerClass: 'value_col',
            colClass: 'value_col',
            style: 'width: 20%',
            render: function(row) {
                return '<a class="layui-btn layui-btn-danger layui-btn-mini" onclick="toUpdate(' + row.id + ')"><i class="layui-icon">&#xe640;</i> 修改</a>'; //列渲染
            }
        },
    ];
    $.ajax({
        data: {},//提交的数据
        url: "/sps-admin/category/getCategory",//提交连接
        type: 'post',
        dataType: 'json',
        success: function (result) {
            layui.use(['tree', 'layer'], function() {
                var layer = layui.layer;
                layui.treeGird({
                    elem: '#tree', //传入元素选择器
                    nodes: eval(result),
                    layout: layout
                });
            });
        }//回调方法
    });
    //进入新增页面
    $(document).on("click", "#add", function () {
        window.location.href="/sps-admin/category/toAddOrEdit";
    });
    function toUpdate(nodeId) {
        window.location.href="/sps-admin/category/toAddOrEdit?id="+nodeId;
    }



</script>

</html>