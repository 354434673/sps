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
    <title>设置交易页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
</head>
<body>
<div style="padding: 40px;width: 600px;">
    <h3>设置交易密码</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <div class="layui-form-item ">
            <label class="layui-form-label" style="width: 136px;padding-left: 28px;" >*手机号：</label>
            <div class="layui-input-inline" >
                <input id="phone" style="width: 255px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;" >*手机验证码：</label>
            <div class="layui-input-block" >
                <input id="phoneCode"  style="width: 255px;text-align: center;display: inline" type="text"    value=""  autocomplete="off" class="layui-input"    lay-verify="required">
                <button   style="color:red;" id="getVerifyCode">获取验证码</button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;">*请输入验证码：</label>
            <div class="layui-input-block" >
                <input id="imgCode" style="width: 170px;text-align: center;display: inline" type="text"    value=""  autocomplete="off" class="layui-input"    lay-verify="required">
                <img src="<%=path%>/withdraw/imageCode" id="img" style="width: 80px; height: 38px;"/>
                <span  >看不清？<span style="color: cornflowerblue" id="changeImg">换一张</span></span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;">*输入交易密码：</label>
            <div class="layui-input-block" >
                <input id="tradePwd" style="width: 255px;text-align: center;display: inline" type="password"  value=""  autocomplete="off" class="layui-input"    lay-verify="required|number">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;">*确认交易密码：</label>
            <div class="layui-input-block" >
                <input id="confirmPwd" style="width: 255px;text-align: center;display: inline" type="password"  value=""  autocomplete="off" class="layui-input"    lay-verify="required|number">
            </div>
        </div>
        <div class="layui-form-item"   style="padding-left: 72px;">
            <button class="layui-btn" lay-filter="next" lay-submit  id="next">完成</button>
        </div>
    </div>
</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
    $(function () {
       // var withdrawAmt = getUrlParam("withdrawAmt");
        $.ajax({
            url:'<%=path%>/withdraw/getPhone'
            ,type: 'post'
            ,dataType:'json'
            ,async:false
            ,success:function(result){
                $('#phone').val(result.body['phone']);
            }
        });
    });
    $("#getVerifyCode").on("click",function(){
        var phone = $('#phone').val();
        $.ajax({
            data: {phone: phone},
            url: "<%=path%>/withdraw/getVerifyCode",//获取手机验证码
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (result) {
                var code =result.code;
                var ok = result.ok;
                var  msg = result.msg;
                if(code == ok){
                    layui.layer.alert(result.body);
                }
                if(code == result.fail){
                    layui.layer.msg(msg);
                }
            }
        });
    });
    $("#changeImg").on("click",function(){
        var imgSrc = $("#img");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    });
    //加入时间戳，去缓存机制
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();if ((url.indexOf("&") >= 0)) {
            url = url + "&timestamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
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
            var phoneCode = $('#phoneCode').val().trim();
            var imgCode = $('#imgCode').val().trim();
            var tradePwd = $('#tradePwd').val().trim();
            var confirmPwd = $('#confirmPwd').val().trim();
            var withdrawAmt = getUrlParam("withdrawAmt");
            if(tradePwd === confirmPwd){
                layer.msg('处理中...',
                        {
                            icon: 16,
                            shade: 0.01,
                            time:1200
                        },
                        function(){
                            $.ajax({
                                data: {phoneCode: phoneCode,imgCode:imgCode,tradePwd:tradePwd},
                                url: "<%=path%>/withdraw/setTradePwd",//设置交易密码
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
                                            //若设置成功，则跳转至输入交易密码页面进行交易
                                            location.href='<%=path%>/page/main/account/recharge/inputPwd.jsp?withdrawAmt='+withdrawAmt;
                                        }
                                        if(result.body ==  false){
                                            //则设置不成功，则从新设置
                                            lock =true;
                                        }
                                    }
                                    if(code == result.fail){//若异常，则提示
                                           lock = true;
                                    }
                                }
                            });
                        }
                );
                lock = true;
                return false;
            }else{
                layer.msg('两次输入的交易密码不一致');
                lock = true;
            }
        });

    });
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }

</script>
</body>
</html>