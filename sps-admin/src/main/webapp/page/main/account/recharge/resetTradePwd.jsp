<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"   content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/page/layui/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 40px;width: 600px;">

    <h3 style="padding-left: 260px;">设置交易密码</h3>
    <hr>
    <div class="layui-form layui-form-pane" style="padding-left: 150px;padding-right: 300px;width: 800px;">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">输入交易密码:</label>
            <div class="layui-input-inline">
                <input id="tradePwd" type="password" name="tradePwd"  value=""
                       placeholder="请输入6位数字的密码"
                       autocomplete="off" class="layui-input" lay-verify="required|pwdCheck">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">确认交易密码 </label>
            <div class="layui-input-inline">
                <input id="confirmPwd" type="password" name="confirmPwd"  value=""
                       placeholder="请再输入一次密码"
                       autocomplete="off" class="layui-input" lay-verify="required|pwdCheck">
            </div>
        </div>
        <div class="layui-form-item"   style="padding-left: 103px;">
            <button class="layui-btn" lay-filter="next" lay-submit  id="next">完成 </button>
        </div>
    </div>
</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>

<script type="text/javascript">
    var lock = true;
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form();
        //自定义验证规则
        form.verify({
            pwdCheck: function (value) {
                var re = /^[0-9]{6}$/;
                if (!re.test(value)) return "请输入六位数字密码";
            }
        });
        form.on('submit(next)', function (data) {
            if(!lock){    // 2.判断该锁是否打开，如果是关闭的，则直接返回
                return false;
            }
            lock = false;  //3.进来后，立马把锁锁住
            var tradePwd = $("#tradePwd").val();
            var confirmPwd = $("#confirmPwd").val();
            if(tradePwd != confirmPwd){
                layer.msg('两次输入密码不一致');
                lock = true;
                return ;
            }
            layer.msg('处理中...',
                {
                    icon: 16,
                    shade: 0.01,
                    time:1200
                },
                function(){
                    $.ajax({
                        data:{tradePwd:tradePwd},
                        url: "<%=path%>/recharge/setTradePwd",//设置交易密码
                        type: 'post',
                        dataType: 'json',
                        async: false,
                        success: function (result) {
                            var msg = result.msg;
                            if(result.body == true){
                                //若设置成功，刷新当前页面
                                layer.msg(msg,
                                    {
                                        icon: 16,
                                        shade: 0.01,
                                        time:1200
                                    },
                                    function(){
                                        history.back(-1);
                                    });
                            }
                            if(result.body ==  false){
                                //则设置不成功，则从新设置
                                layer.msg(msg);
                                lock =true;
                            }
                        }
                    });
                });
        });
    });
</script>
</body>
</html>
