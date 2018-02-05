<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>添加自定义分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
</head>
<body>
<div style="padding: 40px">
    <h3>自定义分类</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="customId" id="customId" >
        <div class="layui-form-item ">
            <label class="layui-form-label">*分类名称：</label>
            <div class="layui-input-inline">
                <input id="customName" type="text" name="customName"  lay-verify="required|maxLength" placeholder="请输入分类名称" autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*优先级：</label>
            <div class="layui-input-inline">
                <input id="customWide" name="customWide" type="text" lay-verify="required|number|customWide" placeholder="请输入优先级" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" align="center">
            <button class="layui-btn" lay-filter="submitCategory" lay-submit  id="submit">立即提交
            </button>
            <button id="back" class="layui-btn layui-btn-primary" >返回</button>
        </div>
    </div>
</div>
</div>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script src="<%=path%>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        var a_num =0;
        form.on('submit(submitCategory)', function (data) {
         /*   if($('#customWide').val().length>10){
                layer.msg("sfsdfsdf")
                return false;
            }
            if($('#customName').val().length>50){
                layer.msg("sfsdfs22222222222df")
                return false;
            }*/
            a_num+=1;
            if(a_num==1){

                $.ajax(
                    {
                        data: {
                            customId: $('#customId').val(),
                            customName: $('#customName').val(),
                            customWide: $('#customWide').val()
                        },
                        url: "<%=path%>/customCategory/saveOrUpdate",//提交连接
                        type: 'post',
                        dataType: 'json',
                        success: function (result) {
                            if (result.flag == '1') {
                                layer.msg("操作成功",{icon: 1});
                                setTimeout(function () {
                                    parent.window.location.href = "<%=path%>/page/main/custom/index.jsp";
                                    //parent.layer.closeAll();

                                }, 1000);
                            } else {
                                layer.msg("操作失败");
                            }
                        }//回调方法
                    });
            }
            return false;
        })
        //自定义验证规则收
        form.verify({
            customWide: function (value) {
                if (value.length >10) {
                    return '优先级最多为10位';
                }
            },
            maxLength: function(value) {
                if(value.length>50) {
                    return '分类名称最多为50位';
                }
            },

        });
        $(document).on("click", "#back", function () {
            parent.layer.closeAll();
        })
    });
</script>
</body>
</html>