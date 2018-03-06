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
    <title>订单详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all"/>
    <style type="text/css">
    </style>
</head>
<bod>
    <div style="margin: 15px;">
        <div class="layui-form layui-form-pane">
            物流信息:
            <div class="layui-form-item">
                <label class="layui-form-label">物流公司:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="wuliuName" lay-verify="required">
                </div>
                <label class="layui-form-label">物流单号:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="wuOderNo"  lay-verify="required">
                </div>
            </div>
            基本信息
            <div class="layui-form-item">
                <label class="layui-form-label">订单编号:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="orderid" lay-verify="required">
                </div>
                <label class="layui-form-label">订单金额:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="money" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">代销服务费率:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="servicescale" lay-verify="required">
                </div>
                <label class="layui-form-label">代销服务费:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="servicemoney" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">单位:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="unit" lay-verify="required">
                </div>
                <label class="layui-form-label">订单申请日期:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="createtime" placeholder="年-月-日" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">店主名称:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="name" lay-verify="required">
                </div>
                <label class="layui-form-label">联系电话:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="phone"  lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">收货信息:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="address" lay-verify="required">
                </div>
                <label class="layui-form-label">订单备注:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="remark"  lay-verify="required">
                </div>
            </div>
        </div>
        商品列表:
         <table id="goodsList" lay-filter="drawAudioTables"></table>
        <label class="layui-form-label">说明:  同意</label>

    </div>
    <script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
    <script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
    <script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>

    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    </script>
    <script>
        $(function () {
            var auditSerialNum = getUrlParam("auditSerialNum");
            $.ajax({
                url:'<%=path%>/tradeFlow/queryTradeBasicInfo'
                ,type: 'post'
                ,dataType:'json'
                ,data:{tradeSeriNum:auditSerialNum}
                ,async:false
                ,success:function(result){
                    var body=result.body;
                    console.info(result);
                    $('#wuliuName').val(body.logs.logisticsName);
                    $("#wuOderNo").val(body.logs.logisticsNum);
                    $("#orderid").val(body.orderid);
                    $("#money").val(body.money);
                    $("#servicescale").val(body.servicescale);
                    $("#servicemoney").val(body.servicemoney);
                    $("#createtime").val(body.createtime);
                    $("#name").val(body.name);
                    $("#phone").val(body.phone);
                    $("#address").val(body.address);
                    $("#remark").val(body.remark);
                }
            });
        });
        //获得url参数
        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
        layui.use(['table', 'laypage', 'laydate', 'layer'], function () {
            var $ = layui.jquery;
            var table = layui.table;
            var laypage = layui.laypage;
            var layer = layui.layer ;
            var laydate = layui.laydate;
            var auditSerialNum1 = getUrlParam("auditSerialNum");
            table.render({
                elem: '#goodsList'
                ,height: 500
                ,url: '<%=path%>/tradeFlow/queryOrderGoods' //数据接口
                ,id:'gId'
                ,where: {tradeSeriNum:auditSerialNum1}
                ,page:true
                ,cols: [[ //表头
                     {type:'numbers', title: '序号',align:'center'}
                    ,{field: 'sku', title: 'SKU编号', align:'center'}
                    ,{field: 'gSpuName', title: '商品名称',align:'center'}
                    ,{field: 'skuname', title: '规格', width:230, align:'center'}
                    ,{field: 'price', title: '单价', width:230,align:'center'}
                    ,{field: 'amount', title: '订货量', width:230,align:'center'}
                    ,{field: 'summation', title: '金额', width:270,align:'center'}
                ]], done: function (res, page, count) {
                }
            });
        });
    </script>


</bod>

</html>