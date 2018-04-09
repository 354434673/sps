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
    <title>充值详情页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"   content="width=device-width, initial-scale=1, maximum-scale=1">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/page/static/plugins/layui/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 0px">
    <h3 style="padding-left: 327px;">充值成功</h3>
    <hr>
    <div class="layui-form layui-form-pane"  style="padding-left: 200px;padding-right: 300px;width: 800px;">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">银行账号： </label>
            <div class="layui-input-inline">
                <input id="bankCard" type="text" name="bankCard"  value=" "
                       placeholder="银行账号"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">开户银行：</label>
            <div class="layui-input-inline">
                <input id="bankName" type="text" name="bankName"  value=""
                       placeholder="请输入开户行"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">充值前余额：</label>
            <div class="layui-input-inline">
                <input id="amountBefore" type="tel" name="amountBefore" value=""
                       placeholder="充值前余额"
                       autocomplete="off" class="layui-input layui-disabled"  lay-verify="none" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">充值后余额：</label>
            <div class="layui-input-inline">
                <input id="amountAfter" type="text" name="amountAfter"  value=""
                       placeholder="充值后余额"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="required|identity">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">充值金额：</label>
            <div class="layui-input-inline">
                <input id="withdrawAmt" type="text" name="withdrawAmt"  value=""
                       placeholder="充值金额"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">充值状态：</label>
            <div class="layui-input-inline">
                <input id="state" type="text" name="state"  value=""
                       placeholder="充值状态"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">充值时间：</label>
            <div class="layui-input-inline">
                <input id="applyTime" type="text" name="applyTime"  value=""
                       placeholder="充值时间"
                       autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
          </div> 

        </div>
       
</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">
    $(function () {
 		var tradeSerialNum = getUrlParam("tradeSerialNum");

        $.ajax({
             url:'<%=path%>/recharge/rechargeDetail'
            ,type: 'post'
            ,dataType:'json'
            ,async:false
            ,data:{tradeSerialNum:tradeSerialNum}
            ,success:function(result){
                $('#withdrawAmt').val(result.tradeAmount);
                $('#bankName').val(result.cahnnelBank.bank);
                $('#bankCard').val(result.cahnnelBank.accounts);
                $('#amountBefore').val(result.tradeBeforeBalanc);
                $('#amountAfter').val(result.tradeAfterBalanc);
                $('#applyTime').val(dateFormate(result.applicationStartDate));
                var temp=result.rechargeStatus;
                if(temp==0){
                    $('#state').val("失败");
                }
                if(temp==1){
                    $('#state').val("成功");
                }
                if( temp==2){
                    $('#state').val("充值中");
                }
            }
        });
    });
    //获得url参数
    function getUrlParam(name) {
    	console.info(name);
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    function dateFormate(da) {
        if(da != null){
            da = new Date(da);
            var year = da.getFullYear();
            var month = da.getMonth()+1;
            var date = da.getDate();
            var hours= da.getHours();
            var minutes= da.getMinutes();
            var seconds= da.getSeconds();
            console.log([year,month,date,hours,minutes,seconds].join('-'));
            return [year,month,date].join('-') + " " + [hours,minutes,seconds].join(':');
        }
        return '';
    }

</script>
</body>
</html>