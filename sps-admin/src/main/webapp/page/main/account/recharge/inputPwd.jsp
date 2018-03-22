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
    <title>充值页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
</head>
<body>
<div style="padding: 40px;width: 600px;">
    <h3 style="padding-left: 199px;">输入密码页面</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="customId" id="customId" >
        <div class="layui-form-item " style="padding-left: 47px;">
            <label class="layui-form-label" style="width: 136px;padding-left: 28px;" >*姓名：</label>
            <div class="layui-input-inline" >
                <input id="name" style="width: 370px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item"  style="padding-left: 47px;">
            <label class="layui-form-label" style="width: 136px;" >*账户信息：</label>
            <div class="layui-input-inline" >
                <input id="account"  style="width: 370px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item"  style="padding-left: 47px;">
            <label class="layui-form-label" style="width: 136px;">*充值金额：</label>
            <div class="layui-input-inline" >
                <input id="withdrawAmt" style="width: 370px;text-align: center;" type="text"    value=""  autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item"  style="padding-left: 47px;">
            <label class="layui-form-label" style="width: 136px;">*输入交易密码：</label>

            <div class="layui-input-block" >
                <input id="tradePwd" style="width: 300px;text-align: center;display: inline" type="password"  value=""  autocomplete="off" class="layui-input"    lay-verify="required|number">
                <button   style="color:red;" id="forgetPwd">忘记密码?</button>

            </div>
        </div>
        <div class="layui-form-item"   style="padding-left: 150px;">
            <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" >上一步</button>
            <button class="layui-btn" lay-filter="next" lay-submit  id="next">确认充值</button>
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
    var layer = null;
    var lock =true;
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        layer = layui.layer ;
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
                        data:{withdrawAmt: amount,tradePwd:psw},
                        url: "<%=path%>/recharge/save",//保存交易记录，并提交提现申请调用易宝接口
                        type: 'post',
                        dataType: 'json',
                        async: false,
                        success: function (result) {
                            var  msg = result.msg;
                            var tradeSerialNum = result.body;
                            if(tradeSerialNum != ''){
                                //若交易成功，跳转至详情页
                                location.href='<%=path%>/page/main/account/recharge/rechargeDetail.jsp?tradeSerialNum='+tradeSerialNum;
                            }
                            if(tradeSerialNum ==  ''){
                                lock = true;
                                //则进行交易失败处理
                                layer.msg(msg);
                            }
                        }
                    });

                }
            );
            return false;
        });
        lock = true;
    });


    $("#forgetPwd").on("click",function(){
        //跳转至找回密码页面，即设置交易密码页面；
        var withdrawAmt = getUrlParam("withdrawAmt");
        window.location.href='<%=path%>/page/main/account/recharge/modifyTradePwd.jsp?withdrawAmt='+withdrawAmt;

    });
    //获得url参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }



</script>
</body>
</html>