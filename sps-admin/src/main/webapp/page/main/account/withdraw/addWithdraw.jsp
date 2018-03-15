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
    <title>新增页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
</head>
<body>
<div style="padding: 40px">
    <h3>新增页面</h3>
    <hr>
    <div class="layui-form layui-form-pane" style="padding-left: 200px;">
        <div class="layui-form-item ">
            <label class="layui-form-label"  style="width: 130px;">*可提现金额：</label>
            <div class="layui-input-inline" >

                <input id="withdrawAmt"   type="text"  value=" " 
                       placeholder="" autocomplete="off" class="layui-input layui-disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"  style="width: 130px;">*银行账号：</label>
            <div class="layui-input-inline">
                <input id="bankCard"   type="text"  value=" " 
                       placeholder="" autocomplete="off" class="layui-input layui-disabled">

            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"  style="width: 130px;">*开户银行：</label>
            <div class="layui-input-inline"  >
                <input id="bankName"   type="text"  value=" " 
                       placeholder="" autocomplete="off" class="layui-input layui-disabled">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"  style="width: 130px;">*提现金额：</label>
            <div class="layui-input-inline">
                <input id="amount" name="amount" type="text"  value=" " lay-verify="required"
                       placeholder="" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item"   style="padding-left: 200px;">
            <button class="layui-btn" lay-filter="next" lay-submit  id="next">下一步 </button>
            <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" >返回</button>
        </div>
    </div>
</div>

<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>

<script type="text/javascript">
    $(function () {
        $.ajax({
            url: '<%=path%>/withdraw/getAccount'
            ,type:'post'
            , dataType: 'json'
            , async: false
            , success: function (result) {
                $('#withdrawAmt').val(result.availableBalance);
                $('#bankName').val(result.bank);
                $('#bankCard').val(result.accounts);
            }
        });
    });
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
            var amount = $('#amount').val().trim();
            var withdrawAmt= $('#withdrawAmt').val();
            if( parseInt(withdrawAmt)>=parseInt(amount)){
                layer.msg('处理中...',
                        {
                            icon: 16,
                            shade: 0.01,
                            time:1200
                        },
                        function(){
                            $.ajax({
                                url: '<%=path%>/withdraw/queryExistTradePwd',
                                type: 'post',
                                dataType: 'json',
                                async: false,
                                success: function (result) {
                                    var code =result.code;
                                    var ok = result.ok;
                                    var  msg = result.msg;
//                                    layer.msg(msg);
                                    if(result.body == true){
                                        location.href = '<%=path%>/page/main/account/withdraw/inputTradePwd.jsp?withdrawAmt='+amount;
                                        //若已经设置交易密码，则跳转至输入交易密码页面
                                    }
                                    if(result.body == false){
                                        //则跳转至设置交易密码页面
                                        layer.msg(msg);
                                        location.href = '<%=path%>/page/main/account/withdraw/setTradePwd.jsp?withdrawAmt='+amount;

                                    }
                                }
                            });
                        }
                );
            }else{
                layer.msg("余额不足");
                location.href = '<%=path%>/page/main/account/recharge/index.jsp';
            }

            return false;
        });
        lock = true;
    });


</script>
</body>
</html>