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
    <title>解绑银行卡</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"   content="width=device-width, initial-scale=1, maximum-scale=1">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/page/static/plugins/layui/css/layui.css" media="all"/>
 </head>
<body>
<div style="padding: 40px;width: 600px;">

    <hr>
    <form class="layui-form layui-form-pane"  style="padding-left: 200px;padding-right: 300px;width: 800px;">
        <input type="hidden" id="isDEL" name="bankCard" autocomplete="off" class="layui-input" value="${isDEL}"/>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">姓名 </label>
            <div class="layui-input-inline" >
                <input type="text" id="name"   autocomplete="off" class="layui-input layui-disabled" value=""/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">身份证号 </label>
            <div class="layui-input-inline" >
                <input type="text" id="idNo"   autocomplete="off" class="layui-input layui-disabled" value=""/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">银行卡号 </label>
            <div class="layui-input-inline"  >
                <input type="text" id="bankCard"   autocomplete="off" class="layui-input layui-disabled" value=""/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">开户行 </label>
            <div class="layui-input-inline"  >
                <input type="text" id="bankName"   autocomplete="off" class="layui-input layui-disabled" value=""/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">手机号 </label>
            <div class="layui-input-inline" >
                <input type="text" id="mobile"   autocomplete="off" class="layui-input layui-disabled" value=""/>
            </div>
        </div>
        <div class="layui-form-item" align="left" style="padding-left: 104px;">
            <button class="layui-btn" lay-filter="delete" lay-submit   id="delete">立即解绑</button>
        </div>

    </form>
    
</div>


<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>


<script type="text/javascript">
    $(function(){
        $.ajax({
            url: "<%=path%>/yopBingCard/bankCardDetail",
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (result) {
                $("#name").val(result.bankCard.name);
                $("#idNo").val(result.bankCard.identity);
                $("#bankCard").val(result.bankCard.accounts);
                $("#bankName").val(result.bankCard.bank);
                $("#mobile").val(result.bankCard.phone);
                $("#isDEL").val(result.isDEL);
            }
        });
    });
    var isDEL = $("#isDEL").val();
    var lock = true;
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer ;
        var form = layui.form();
        form.on('submit(delete)', function (data) {
            if(!lock){    // 2.判断该锁是否打开，如果是关闭的，则直接返回
                return false;
            }
            lock = false;  //3.进来后，立马把锁锁住
            //解绑银行卡请求
            $.ajax({
//                data: {isDEL:isDEL},
                url: "<%=path%>/yopBingCard/unbindBackCard?",
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (result) {
                    console.log(result);
                    var code =result.code;
                    var ok = result.ok;
                    layer.msg(result.msg,
                            {
                                icon: 16,
                                shade: 0.01,
                                time:1000
                            },function(){//关闭时，执行
                                //跳转至详情页
                                    if(result.body == true){
                                        layer.msg("解卡成功");
                                        window.location.reload();
                                    }else{
                                        layer.msg("解卡失敗");
                                        window.location.reload();
                                    }


                            });

                    lock = ture;
                }
            });
            return false;
        });
    });

</script>
</body>
</html>