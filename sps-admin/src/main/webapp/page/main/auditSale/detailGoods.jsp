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
    <title>商品详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 40px">
    <h3>商品信息</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="goodsId" id="goodsId" value="${goodsId}">
        <div class="layui-form-item ">
            <label class="layui-form-label">一级分类：</label>
            <div class="layui-input-inline">
                <input id="firstCategoryName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">二级级分类：</label>
            <div class="layui-input-inline">
                <input id="twoCategoryName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">三级分类：</label>
            <div class="layui-input-inline">
                <input id="threeCategoryName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">品牌：</label>
            <div class="layui-input-inline">
                <input id="brandName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">SPU名称：</label>
            <div class="layui-input-inline">
                <input id="gSpuName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">自定义分类：</label>
            <div class="layui-input-inline">
                <input id="gCategorySelf" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">是否推荐：</label>
            <div class="layui-input-inline">
                <input id="recommendFlag" type="text" name="gSpuNo" style="border-style:none ;margin-left: 10px;"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">是否上架：</label>
            <div class="layui-input-inline">
                <input id="groundingFlag" type="text" name="gSpuNo" style="border-style:none ;margin-left: 10px;"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="">规格：</label>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>颜色</th>
                    <th>尺寸</th>
                    <th>编号</th>
                    <th>售卖价</th>
                    <th>起订量</th>
                    <th>库存</th>
                    <th>代销服务费率</th>
                    <th>代销服务费(每件/元)</th>
                </tr>
                </thead>
                <tbody id="content">
                <tr>
                </tr>
                </tbody>
            </table>
            <div class="layui-form-item ">
                <label class="layui-form-label">意见：</label>
                <div class="layui-input-inline">
                    <textarea id="gOpinion" type="text" name="gOpinion" style="width: 1000px;height: 200px; border-style:none ;margin-left: 10px;"
                              class="layui-input"></textarea>
                </div>
            </div>
        </div>
        <div class="layui-form-item" align="center">
            <button id="back" onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" >返回</button>
        </div>
    </div>
</div>
</div>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script src="<%=path%>/page/static/js/ajaxfileupload.js"></script>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script src="<%=path%>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">
    $(function () {
        $("input").attr({"disabled": "disabled"});
        //修改时候获取数据
        if ($("#goodsId").val() != "") {
            getDate($("#goodsId").val());
        }
    })


    //获取数据
    function getDate(goodsId) {
        $.ajax({
            url: "<%=path%>/goodShop/findEntity",//提交连接
            type: 'post',
            dataType: 'json',
            async: false,
            data: {id: goodsId},
            success: function (json) {
                if (json.flag == "1") {
                    if (json.goods != null) {

                        $('#gOpinion').val(json.goods.gOpinion);
                        $('#gOpinion').attr({"disabled": "disabled"});
                        $('#firstCategoryName').val(json.firstCategory);
                        $('#twoCategoryName').val(json.twoCategory);
                        $('#threeCategoryName').val(json.threeCategory);
                        $('#gCategorySelf').val(json.customName);
                        $('#gSpuName').val(json.goods.gSpuName+'-'+json.goods.gSpuNo);
                       if(json.goods.gRecommend="1"){
                           $('#recommendFlag').val("是");
                       } else {
                           $('#recommendFlag').val("否");
                       }
                        if(json.goods.gGroundingFlag="1"){
                            $('#groundingFlag').val("是");
                        } else {
                            $('#groundingFlag').val("否");
                        }
                    }
                    if (json.brandName != null) {
                        $('#brandName').val(json.brandName);
                    }
                    if (json.skuList != null) {
                        if ($.isArray(json.skuList)) {
                            $.each(json.skuList, function (index, val) {
                                $('#content').append(
                                    "<tr >" +
                                    "<td >" + val.gColor + "</td>" +
                                    "<td >" + val.gSize + "</td>" +
                                    "<td >" + val.gSku + "</td>" +
                                    "<td >" + val.gPrice + "</td>" +
                                    "<td >" + val.gQuantity + "</td>" +
                                    "<td >" + val.gStock + "</td>" +
                                    "<td >" + val.gScale + "</td>" +
                                    "<td >" + val.gService + "</td>" +
                                    "</tr>");
                            })
                        }
                    }
                } else {
                    //layer.msg("操作失败")

                }
            }
        });

    }


</script>
</body>
</html>