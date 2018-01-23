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
<div id="tree"></div>
</body>

<script src="<%=request.getContextPath() %>/page/static/treeTable/layui.js"></script>
<script src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    var data='';
    $(function () {
        initTree()
    })
    function initTree() {
        $.ajax({
            data: {},//提交的数据
            url: "<%=path%>/category/getCategory",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                data=result;
            }//回调方法
        });

    }



    layui.use(['tree', 'layer'], function(){
        var layer = layui.layer;
        layui.tree({
            elem: '#tree',
            check: 'checkbox',              //输入checkbox则生成带checkbox的tree, 默认不带checkbox
            skin: 'as',                     //设定皮肤
            drag: true,                     //点击每一项时是否生成提示信息
            checkboxName: 'selectedArr',    //复选框的name属性值
            checkboxStyle: "",              //设置复选框的样式，必须为字符串，css样式怎么写就怎么写
            click: function(item){          //节点点击事件
                $("#add").html(item.name)
               // layer.msg('当前节名称：'+ item.name + '<br>全部参数：'+ JSON.stringify(item));
                //console.log(item);
            },
            nodes:eval(data),
        });
    });




</script>

</html>