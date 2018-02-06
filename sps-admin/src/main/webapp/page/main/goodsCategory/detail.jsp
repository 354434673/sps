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
    <title>添加分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/page/static/treeTable/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 40px">
    <h3>分类信息</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="categoryParentName" id="categoryParentName" value="${categoryParentName}">
        <input type="hidden" name="categoryId" id="categoryId" value="${spsGoodCategory.categoryId}">
        <div class="layui-form-item ">
            <label class="layui-form-label">分类名称：</label>
            <div class="layui-input-inline" style="    padding-left: 10px;    padding-top: 8px">${spsGoodCategory.categoryName}
            </div>
            <label class="layui-form-label">权重：</label>
            <div class="layui-input-inline" style="    padding-left: 10px;    padding-top: 8px">
                ${spsGoodCategory.categoryWeight}
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">上级分类：</label>
            <div class="layui-input-inline" style="    padding-left: 10px;    padding-top: 8px">
                <input type="hidden" id="categoryParentId" name="categoryParentId"
                       autocomplete="off" class="layui-input"
                       value="${spsGoodCategory.categoryParentId}">
                    <c:choose>
                        <c:when test="${spsGoodCategory.categoryParentId eq 0}">
                            无
                        </c:when>
                        <c:when test="${categoryParentName!= ''}">
                            ${categoryParentName}
                        </c:when>
                    </c:choose>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述：</label>
            <div class="layui-input-inline" style="    padding-left: 10px;    padding-top: 8px">
                ${spsGoodCategory.categoryDes}
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图片：</label>
            <div class="layui-input-inline" style="    padding-left: 10px;     padding-top: 8px">
                <img class="img" src="D:\backups\1.11\ws-juzi\sps\sps-admin\target\sps-admin\upload\imgs/${spsGoodCategory.categoryUrl}" style="max-height: 50px;max-width: 50px" />
            </div>
        </div>
        <div class="layui-form-item" align="center">
            <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary">返回</button>
        </div>
    </div>
</div>
</div>
<form id="upload" enctype="multipart/form-data">
    <input type="file" id='imgupl' name="file" style="display:none" onchange="validateFile()"/>
</form>
<script src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/page/static/treeTable/layui.all.js"></script>
<script src="<%=request.getContextPath() %>/page/static/treeTable/layui.js"></script>

<script type="text/javascript">
    $(function () {
        $("#tree").hide();
        if ($("#categoryParentName").val() == "") {
            $("#showCategory").html("选择分类")
        }
        if ($("#categoryParentId").val() != "" && $("#categoryParentId").val() == 0) {
            $("#showCategory").html("无")
            $("#showCategory").attr("disabled", "true");
        }

    })
</script>
</body>
</html>