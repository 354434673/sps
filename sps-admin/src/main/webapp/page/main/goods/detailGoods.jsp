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
    <title>添加商品</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all"/>
    <style type="text/css">
        .tdStyle {
            width: 80px
        }
    </style>
</head>
<body>
<div style="padding: 40px">
    <h3>商品信息</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="goodsId" id="goodsId" value="${goodsId}">
        <input type="hidden" name="goodsNumberFlag" id="goodsNumberFlag">
        <div class="layui-form-item ">
            <label class="layui-form-label">*三级分类：</label>
            <div class="layui-input-inline">
                <input id="gCategoryNames" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*品牌：</label>
            <div class="layui-input-inline">
                <input id="brandName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU名称：</label>
            <div class="layui-input-inline">
                <input id="gSpuName" type="text" class="layui-input" name="gSpuName"
                       style="border-style:none ;margin-left: 10px;">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU编号：</label>
            <div class="layui-input-inline">
                <input id="gSpuNo" type="text" name="gSpuNo" style="border-style:none ;margin-left: 10px;"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="">*规格：</label>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>颜色</th>
                    <th>尺寸</th>
                    <th>编号</th>
                    <th>基准价</th>
                    <th>波动方式</th>
                    <th>波动值</th>
                    <th>波动区间</th>
                </tr>
                </thead>
                <tbody id="content">
                <tr>
                    <%--<td><input type="text" name="gSpuName" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" class="tdStyle"></td>
                    <td width="208px"><input type="radio" name="sex" value="1" title="按比例" checked>
                        <input type="radio" name="sex" value="0" title="按金额"></td>
                    <td><input type="text" name="gSpuName" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" class="tdStyle"></td>
                    <td><a href="#" style="text-decoration: underline " id="adGoodSku">添加</a></td>--%>
                </tr>
                </tbody>
                <%--      <input type="button" value="提交数据" id="btnSubmit" onclick="SaveData()"/>--%>
            </table>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">*单位：</label>
            <div class="layui-input-inline" style="padding-top: 10px;padding-left: 10px;">
                元
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">*商品描述</label>
            <div class="layui-input-block">
                <input id="gDetails" type="text" style="border-style:none ; margin-top: 5px" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">包装清单</label>
            <div class="layui-input-block">
                <input id="gRemark" type="text" style="border-style:none; margin-top: 5px" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">*主图：</label>
            <div class="layui-input-inline">
                <input type="hidden" name="gPic" id="gPic" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*详情图：</label>
            <div class="layui-input-inline">
                <input type="hidden" name="gDpic" id="gDpic" value="">
            </div>
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
        $("#tree").hide();
        if ($("#brandCategoryNames").val() == "") {
            $("#showCategory").html("关联分类")
        } else {
            $("#showCategory").html($("#brandCategoryNames").val())
        }


    })


    //修改获取数据
    function getDate(goodsId) {
        $.ajax({
            url: "/sps-admin/goods/findEntity",//提交连接
            type: 'post',
            dataType: 'json',
            async: false,
            data: {id: goodsId},
            success: function (json) {
                if (json.flag == "1") {
                    if (json.goods != null) {
                        $('#gCategoryIds').val(json.goods.gCategoryIds);
                        $('#gCategoryNames').val(json.goods.gCategoryNames);
                        $("#showCategory").html(json.goods.gCategoryNames);
                        $('#gBrandId').val(json.goods.gBrandId);
                        $('#gSpuName').val(json.goods.gSpuName);
                        $('#gSpuNo').val(json.goods.gSpuNo);
                        $('#gDetails').val(json.goods.gDetails);
                        $('#gRemark').val(json.goods.gRemark);
                        $('#gDpic').val(json.goods.gDpic);
                        $('#gPic').val(json.goods.gPic);
                    }
                    if (json.brandName != null) {
                        $('#brandName').val(json.brandName);
                    }
                    if (json.skuList != null) {
                        if ($.isArray(json.skuList)) {
                            $.each(json.skuList, function (index, val) {
                                $('#content').append(
                                    "<tr >" +
                                    "<input type='hidden'  value=''></td>" +
                                    "<td >" + val.gColor + "</td>" +
                                    "<td >" + val.gSize + "</td>" +
                                    "<td >" + val.gNo + "</td>" +
                                    "<td >" + val.gPrice + "</td>" +
                                    "<td >" + val.gType + "</td>" +
                                    "<td >" + val.gScale + "</td>" +
                                    "<td >" + val.gScale + "</td>" +
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