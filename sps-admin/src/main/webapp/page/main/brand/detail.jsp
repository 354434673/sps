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
        <input type="hidden" name="categoryParentName" id="categoryParentName" value="${categoryParentName}">
        <input type="hidden" name="categoryId" id="brandId" value="${spsBrand.brandId}">
        <div class="layui-form-item ">
            <label class="layui-form-label">*品牌名称：</label>
            <div class="layui-input-inline">
               ${spsBrand.brandName}
            </div>
            <label class="layui-form-label">*英文名称：</label>
            <div class="layui-input-inline">
               ${spsBrand.brandEnglishName}
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*简称：</label>
            <div class="layui-input-inline">
                ${spsBrand.brandAbbreviation}
            </div>
            <label class="layui-form-label">*关联分类：</label>
            <div class="layui-input-inline">
                    <c:choose>
                        <c:when test="${spsBrand.brandCategoryNames eq ''}">
                            无
                        </c:when>
                        <c:when test="${spsBrand.brandCategoryNames!= ''}">
                            ${spsBrand.brandCategoryNames}
                        </c:when>
                    </c:choose>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*小图标：</label>
            <div class="layui-input-inline">
                <img class="img" src="D:/sps-ws/sps/sps-admin/src/main/webapp/upload/imgs/20171230/${spsGoodCategory.categoryUrl}" style="max-height: 50px;max-width: 50px" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*大图标：</label>
            <img class="img" src="D:/sps-ws/sps/sps-admin/src/main/webapp/upload/imgs/20171230/${spsGoodCategory.categoryUrl}" style="max-height: 50px;max-width: 50px" />
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">品牌描述</label>
        <div class="layui-input-block" style="padding-top: 10px;">${spsBrand.brandDes}
        </div>
    </div>
</div>
<div id="tree"></div>
</div>
<form id="upload" enctype="multipart/form-data">
    <input type="file" id='imgupl' name="file" style="display:none" onchange="validateFile()"/>
</form>
<script src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/page/static/treeTable/layui.all.js"></script>
<script src="<%=request.getContextPath() %>/page/static/treeTable/layui.js"></script>
</body>
</html>