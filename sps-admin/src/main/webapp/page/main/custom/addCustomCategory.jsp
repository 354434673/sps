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
                <input id="customName" type="text" name="customName"  lay-verify="required" placeholder="请输入分类名称"
                       autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*优先级：</label>
            <div class="layui-input-inline">
                <input id="customWide" name="customWide" type="text" lay-verify="required"
                       placeholder="请输入优先级" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item" align="center">
            <button class="layui-btn" lay-filter="submitCategory" lay-submit  id="submit">立即提交
            </button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>
</div>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script src="<%=path%>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">
    $(function () {

    })
    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        //提交
        var post_flag = false; //设置一个对象来控制是否进入AJAX过程
        form.on('submit(submitCategory)', function (data) {
            var layer = layui.layer;
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态
            var customId = $('#customId').val()
            var customName = $('#customName').val()
            var customWide = $('#customWide').val();

            $.ajax(
                {
                    data: {
                        customId: customId,
                        customName: customName,
                        customWide: customWide
                    },
                    url: "<%=path%>/customCategory/saveOrUpdate",//提交连接
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        post_flag = false; //在提交成功之后将标志标记为可提交状态
                        if (result.flag == '1') {
                            layer.msg("操作成功",{icon: 1});
                            layer.closeAll();
                            setTimeout(function () {
                                layer.closeAll();
                            }, 1000);
                        } else {
                            layer.msg("操作失败");
                        }
                    }//回调方法
                });

        })

        //自定义验证规则
        form.verify({
            //验证只包含汉字
            IsChineseCharacter: function (value) {
                var regex = /^[\u4e00-\u9fa5]+$/;
                if (!value.match(regex)) {
                    return '请输入正确的姓名';
                }
            },
            minLength: function (value) {
                if (value.length < 6) {
                    return '最少为6位';
                }
            },
            verify: function (value) {
                var repass = $('#password').val();
                if (value != repass) {
                    return '两次输入的密码不一致!';
                }
            },
        });
    });
</script>
</body>
</html>