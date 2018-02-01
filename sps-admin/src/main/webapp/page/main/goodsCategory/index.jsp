<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
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
        //单击显示图片
        $(".immg").click(function(){
            var d = dialog({
                title:'大图',
                content: '<img width="300" height="450" src="'+$(this).attr('src')+'" value="1"/>',
                quickClose: true
            });
            d.show();
            $("div.ui-popup.ui-popup-modal.ui-popup-show.ui-popup-focus").css({'z-index':99999});
        });
    });



    var layout = [
        { name: '分类名称', treeNodes: true, headerClass: 'value_col', colClass: 'value_col', style: 'width: 60%' },
        {name: '权重', field: 'categoryWeight', headerClass: 'value_col', colClass: 'value_col', style: 'width: 10%'},
        {name: '描述', field: 'categoryDes', headerClass: 'value_col', colClass: 'value_col', style: 'width: 20%'},
        {
            name: '操作',
            headerClass: 'value_col',
            colClass: 'value_col',
            style: 'width: 20%',
            render: function(row) {
                return '<a class="layui-btn layui-btn-danger layui-btn-mini" onclick="toUpdate(' + row.id + ')"> 修改</a>'; //列渲染
            }

        },
        {
            name: '',
            style: 'width: 15%',
            render: function(row) {
                return '<a class="layui-btn layui-btn-danger layui-btn-mini" onclick="toDetail(' + row.id + ')"> 详情</a>'; //列渲染
            }

        },
    ];
    $.ajax({
        data: {},//提交的数据
        url: "<%=path%>/category/getCategory",//提交连接
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
        window.location.href="<%=path%>/category/toAddOrEdit";
    });
    function toUpdate(nodeId) {
        $.ajax({
            data: {id:nodeId},//提交的数据
            url: "<%=path%>/category/checkCategory",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    window.location.href="<%=path%>/category/toAddOrEdit?id="+nodeId;
                } else if (result.flag == '2') {
                    layer.msg("已有审核中商品在使用该分类，请重新选择！");
                }
            }
        })

    }
    function toDetail(nodeId) {
        window.location.href="<%=path%>/category/findEntity?id="+nodeId;
    }



</script>

</html>