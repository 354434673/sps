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
    <title>绑卡详情页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"   content="width=device-width, initial-scale=1, maximum-scale=1">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/page/static/plugins/layui/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 40px;width: 600px;">

    <hr>
    <div class="layui-form layui-form-pane"  style="padding-left: 200px;padding-right: 300px;width: 800px;">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">姓名 </label>
            <div class="layui-input-inline" >
                <input type="text" id="name"   autocomplete="off" class="layui-input layui-disabled" value=""/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">身份证号 </label>
            <div class="layui-input-inline" >
                <input type="text"id="idNo"   autocomplete="off" class="layui-input layui-disabled" value=""/>
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
    </div>
    
</div>


<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>


<script type="text/javascript">
    $(function(){
        $.ajax({
            url: "<%=path%>/bankCard/bankCardDetail",
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (result) {
                $("#name").val(result.bankCard.name);
                $("#idNo").val(result.bankCard.identity);
                $("#bankCard").val(result.bankCard.accounts);
                $("#bankName").val(result.bankCard.bank);
                $("#mobile").val(result.bankCard.phone);
            }
        });
    });

</script>
</body>
</html>