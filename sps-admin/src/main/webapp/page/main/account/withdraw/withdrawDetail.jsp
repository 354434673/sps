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
   <link rel="stylesheet" href="<%=request.getContextPath()%>/page/static/plugins/layui/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 100px">
    <hr>
    <div class="layui-form layui-form-pane" style="padding-left: 200px;padding-right: 300px;width: 800px;">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">银行账号： </label>
            <div class="layui-input-inline">
                <input id="bankCard" type="text" name="bankCard"  value=" "
                       placeholder="银行账号"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">开户银行 </label>
            <div class="layui-input-inline">
                <input id="bankName" type="text" name="bankName"  value=""
                       placeholder="请输入开户行"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">提现前余额</label>
            <div class="layui-input-inline">
                <input id="amountBefore" type="tel" name="amountBefore" value=""
                       placeholder="提现前余额"
                       autocomplete="off" class="layui-input layui-disabled"  lay-verify="none" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">提现后余额</label>
            <div class="layui-input-inline">
                <input id="amountAfter" type="text" name="amountAfter"  value=""
                       placeholder="提现后余额"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="required|identity">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">提现金额：</label>
            <div class="layui-input-inline">
                <input id="withdrawAmt" type="text" name="withdrawAmt"  value=""
                       placeholder="提现金额"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">提现申请时间</label>
            <div class="layui-input-inline">
                <input id="applyTime" type="text" name="applyTime"  value=""
                       placeholder="提现申请时间："
                       autocomplete="off" class="layui-input layui-disabled"    lay-verify="none">
            </div>
          </div> 
           <div class="layui-form-item"> 
            <label class="layui-form-label" style="width: 130px;">审核通过时间</label>
            <div class="layui-input-inline">
                <input id="passTime" type="text" name="identity"  value=" "
                       placeholder="审核通过时间"
                       autocomplete="off" class="layui-input layui-disabled"  lay-verify="none">
            </div>
            </div>
             <div class="layui-form-item"> 
            	<label class="layui-form-label" style="width: 130px;">到账时间</label>
           			 <div class="layui-input-inline">
                		<input id="incomeTime" type="text" name="incomeTime"  value=""
                       placeholder="到账时间"
                       autocomplete="off" class="layui-input layui-disabled"   lay-verify="none">
            		</div>
            </div>
        <div class="layui-form-item" style="border-left-width: 525px;padding-left: 175px;width: 10px;">
            <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" >返回</button>
        </div>
       </div>
    </form>
</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function () {
 		var tradeSerialNum = getUrlParam("tradeSerialNum");

        $.ajax({
             url:'<%=path%>/withdraw/withdrawDetail'
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
                $('#passTime').val(dateFormate(result.auditDate));
                $('#incomeTime').val(dateFormate(result.paymentDate));
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