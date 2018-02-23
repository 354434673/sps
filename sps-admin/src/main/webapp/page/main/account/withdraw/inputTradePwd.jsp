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
    <title>输入密码页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
</head>
<body>
<div style="padding: 40px;width: 600px;">
    <h3>输入密码页面</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="customId" id="customId" >
        <div class="layui-form-item ">
            <label class="layui-form-label" style="width: 136px;padding-left: 28px;" >*姓名：</label>
            <div class="layui-input-inline" >
                <input id="name" style="width: 370px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;" >*账户信息：</label>
            <div class="layui-input-inline" >
                <input id="account"  style="width: 370px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;">*提现金额：</label>
            <div class="layui-input-inline" >
                <input id="withdrawAmt" style="width: 370px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;">*输入交易密码：</label>

            <div class="layui-input-block" >
                <input id="tradePwd" style="width: 300px;text-align: center;display: inline" type="password"  value=""  autocomplete="off" class="layui-input"    lay-verify="required|number">
                <button   style="color:red;" id="forgetPwd">忘记密码?</button>

            </div>
        </div>
        <div class="layui-form-item"   style="padding-left: 72px;">
            <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" >上一步</button>
            <button class="layui-btn" lay-filter="next" lay-submit  id="next">完成</button>
        </div>
    </div>
</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
    $(function () {
        var withdrawAmt = getUrlParam("withdrawAmt");
        $.ajax({
            url:'<%=path%>/bankCard/bankCardDetail'
            ,type: 'post'
            ,dataType:'json'
            ,async:false
            ,success:function(result){
                $('#withdrawAmt').val(withdrawAmt);
                $("#name").val(result.bankCard.name);
                $("#account").val(result.bankCard.bank+'('+result.bankCard.accounts+')');
            }
        });
    });
    $("#forgetPwd").on("click",function(){
        //跳转至找回密码页面，即设置交易密码页面；
        var withdrawAmt = getUrlParam("withdrawAmt");
        location.href='<%=path%>/page/main/account/withdraw/setTradePwd.jsp?withdrawAmt='+withdrawAmt;
    });
    //获得url参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    var lock =true;
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer ;
        var form = layui.form();
        form.on('submit(next)', function (data) {
            if(!lock){    // 2.判断该锁是否打开，如果是关闭的，则直接返回
                return false;
            }
            lock = false;  //3.进来后，立马把锁锁住
            var amount = $('#withdrawAmt').val().trim();
            layer.msg('处理中...',
                    {
                        icon: 16,
                        shade: 0.01,
                        time:1200
                    },
                    function(){
                        var psw = $('#tradePwd').val().trim();
                        $.ajax({
                            data:{psw:psw},
                            url:"<%=path%>/withdraw/queryTradePwd",
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            success: function (result) {
                                console.log(result);

                                var  msg = result.msg;
                                layer.msg(msg);
                               //若密码正确，则进行提现操作
                                if(result.body.flag==0){
                                    //若已经设置交易密码，则跳转至输入交易密码页面
                                    $.ajax({
                                        data:{withdrawAmt: amount},
                                        url: "/withdraw/save",//保存交易记录，并提交提现申请调用易宝接口
                                        type: 'post',
                                        dataType: 'json',
                                        async: false,
                                        success: function (result) {
                                            console.log(result);
                                            var code =result.code;
                                            var ok = result.ok;
                                            var  msg = result.msg;
                                            layer.msg(msg);
                                            if(code == ok){
                                                if(result.body == true){
                                                    //若交易成功，则跳转至提现首页列表
                                                     location.href='/page/main/account/withdraw/index.jsp';
                                                }
                                                if(result.body ==  false){
                                                    //则进行交易失败处理
                                                }
                                            }
                                            if(code == result.fail){
                                               // layer.msg(msg);
                                                lock = true;
                                            }
                                        }
                                    });
                                }
                                //若密码不正确则，重新输入密码
                                if(result.body.flag == 1){
                                    lock = true;
                                    return  ;
                                }
                                //若密码未设置，则跳转至设置页面
                                if(result.body.flag == 2){
                                    //则跳转至设置交易密码页面
                                    location.href='/page/main/account/withdraw/setTradePwd.jsp';
                                }

                            }
                        });
                            /*data:{withdrawAmt: amount},
                            url: "/withdraw/save",//保存交易记录，并提交提现申请调用易宝接口
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            success: function (result) {
                                console.log(result);
                                var code =result.code;
                                var ok = result.ok;
                                var  msg = result.msg;
                                layer.msg(msg);
                                if(code == ok){
                                    if(result.body == true){
                                        //若交易成功，则跳转至提现首页列表
                                       // location.href='/page/main/account/withdraw/index.jsp';
                                    }
                                    if(result.body ==  false){
                                        //则跳转至设置交易密码页面
                                    }
                                }
                                if(code == result.fail){
                                    layer.msg(msg);
                                    lock = true;
                                }
                            }
                        });*/
                    }
            );
            return false;
        });
        lock = true;
    });


</script>
</body>
</html>