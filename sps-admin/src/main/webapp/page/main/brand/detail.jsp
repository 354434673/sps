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
    <title>添加品牌</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/page/static/treeTable/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 40px">
    <h3>品牌信息</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <%--<input type="hidden" name="categoryParentName" id="categoryParentName" value="${categoryParentName}">--%>
        <input type="hidden"  id="brandId" >
        <div class="layui-form-item ">
            <label class="layui-form-label">品牌名称：</label>
            <div class="layui-input-inline" >
                <input id="brandName" type="text" style="border-style:none ;margin-left: 10px;" class="layui-input" >
            </div>
            <label class="layui-form-label">英文名称：</label>
            <div class="layui-input-inline" >
                <input id="brandEnglishName" type="text" style="border-style:none ;margin-left: 10px;" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">简称：</label>
            <div class="layui-input-inline" >
                <input id="brandAbbreviation"type="text"  style="border-style:none ;margin-left: 10px;"class="layui-input" >
            </div>
            <label class="layui-form-label">关联分类：</label>
            <div class="layui-input-inline" >
                <input id="brandCategoryNames"type="text"  style="border-style:none ;margin-left: 10px;" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">小图标：</label>
            <div class="layui-input-inline">
                <img class="img" src="D:/sps-ws/sps/sps-admin/src/main/webapp/upload/imgs/20171230/" style="max-height: 50px;max-width: 50px" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">大图标：</label>
            <img class="img" src="D:/sps-ws/sps/sps-admin/src/main/webapp/upload/imgs/20171230/" style="max-height: 50px;max-width: 50px" />
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">品牌描述：</label>
        <div class="layui-input-block"  >
            <input id="brandDes"type="text"  style="border-style:none" class="layui-input" >
        </div>
    </div>
</div>
</div>
<script src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/page/static/treeTable/layui.all.js"></script>
<script src="<%=request.getContextPath() %>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">
    /*$(function () {
        getData();
        alert($("#brandId").html())
    })
    function getData() {
        $.ajax({
            data: {id: $("#brandId").val()},//提交的数据
            url: "/sps-admin/brand/findEntity",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    console.log(result)

                } else {
                    layer.msg("获取数据失败");
                }
            }//回调方法
        });


    }*/
</script>
</body>
</html>