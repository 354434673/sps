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
            订单流程
            <div class="layui-form-item">
                <label class="layui-form-label">店主下单（时间）:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required">
                </div>
                <label class="layui-form-label">确认（时间）:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="comfirTime" placeholder="年-月-日" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">已支付（时间）:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="payTime" placeholder="年-月-日" lay-verify="required">
                </div>
                <label class="layui-form-label">发货（时间）:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="faHuoTime" placeholder="年-月-日" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">退货（时间）:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="tuihuoTime" placeholder="年-月-日" lay-verify="required">
                </div>
            </div>
        </div>
        <div class="layui-form layui-form-pane">
            <label class="layui-form-label">物流信息</label>
            <div class="layui-form-item">
                <label class="layui-form-label">物流公司:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="wuLiuName" lay-verify="required">
                </div>
                <label class="layui-form-label">物流单号:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="wuLiOrderNO"  lay-verify="required">
                </div>
            </div>

        </div>
        <div class="layui-form layui-form-pane">
            <label class="layui-form-label">基本信息</label>
            <div class="layui-form-item">
                <label class="layui-form-label">订单编号:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="ordeNo" lay-verify="required">
                </div>
                <label class="layui-form-label">订单金额:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="orderAmount" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">代销服务费率:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="serverLv" lay-verify="required">
                </div>
                <label class="layui-form-label">代销服务费:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="serverAmount" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">单位:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="per" lay-verify="required">
                </div>
                <label class="layui-form-label">订单申请日期:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="auditTime" placeholder="年-月-日" lay-verify="required">
                </div>
             </div>
            <div class="layui-form-item">
                <label class="layui-form-label">店主名称:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="companyNamme" lay-verify="required">
                </div>
                <label class="layui-form-label">联系电话:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="mobily"  lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">收货信息:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="orderAddr" lay-verify="required">
                </div>
                <label class="layui-form-label">订单备注:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="orderRemark"  lay-verify="required">
                </div>
            </div>
        </div>

        <label class="layui-form-label">商品列表</label>
         <table id="goodsList" lay-filter="drawAudioTables"></table>
        <label class="layui-form-label">说明:  同意</label>

    </div>
    <script type="text/javascript"  src="<%=path%>/page/layui/layui.js"></script>
    <script type="text/html" id="type">
        {{#    if(d.payType == '1'){  }}
        支出
        {{#  } else if(d.payType == '2'){ }}
        收入
        {{#  } }}

    </script>
    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    </script>

    <script type="text/html" id="date">
        {{#
        var da = d.payDate;
        da = new Date(da);
        var year = da.getFullYear();
        var month = da.getMonth()+1;
        var date = da.getDate();
        var hours= da.getHours();
        var minutes= da.getMinutes();
        var seconds= da.getSeconds();
        console.log([year,month,date,hours,minutes,seconds].join('-'));
        var fn = function(){
        return year + "-" + month + "-" + date + " " + hours+ ":" + minutes+ ":" + seconds;
        };
        }}
        {{ fn() }}
    </script>
    <script>
        layui.use(['table', 'laypage', 'laydate', 'layer'], function () {
            var $ = layui.jquery;
            var table = layui.table;
            var laypage = layui.laypage;
            var layer = layui.layer ;
            var laydate = layui.laydate;
            //加载日期框
            laydate.render({
                elem: '#startTime',
                type: 'datetime'

            });
            laydate.render({
                elem: '#endTime',
                type: 'datetime'
            });
            table.render({
                elem: '#goodsList'
                ,height: 500
                ,url: '<%=path%>/goods/goodsList' //数据接口
                ,id:'gId'
                ,page:true
                ,cols: [[ //表头
                     {type:'numbers', title: '序号',align:'center'}
                    ,{field: 'gSpuNo', title: 'SKU编号', align:'center'}
                    ,{field: 'gSpuName', title: '商品名称',align:'center'}
                    ,{field: 'gCategoryNames', title: '规格', width:230, align:'center'}
                    ,{field: 'per', title: '单价', width:230,align:'center'}
                    ,{field: 'orderAmount', title: '订货量', width:230,align:'center'}
                    ,{field: 'amount', title: '金额', width:270,align:'center',toolbar:'#bar'}
                ]], done: function (res, page, count) {
                    $("[data-field='flowStatus']").children().each(function () {
                        if ($(this).text() == '0') {
                            $(this).text("待提交")
                            $(this).parent().parent().find(".delete").show();
                            $(this).parent().parent().find(".update").show();
                        } else if ($(this).text() == '1') {
                            $(this).text("审核中")
                            $(this).parent().parent().find(".update").hide();
                            $(this).parent().parent().find(".delete").hide();
                        } else if ($(this).text() == '2') {
                            $(this).parent().parent().find(".update").show();
                            $(this).parent().parent().find(".delete").show();
                            $(this).text("审核不通过")
                        } else if ($(this).text() == '3') {
                            $(this).parent().parent().find(".update").show();
                            $(this).parent().parent().find(".delete").show();
                            $(this).text("审核通过")
                        }
                    })
                }
            });
        });
    </script>


</bod>

</html>