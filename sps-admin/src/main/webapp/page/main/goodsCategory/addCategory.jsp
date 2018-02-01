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

        <input type="hidden" name="parentFlag" id="parentFlag" value="">
        <input type="hidden" name="categoryParentName" id="categoryParentName" value="${categoryParentName}">
        <input type="hidden" name="categoryId" id="categoryId" value="${spsGoodCategory.categoryId}">
        <div class="layui-form-item ">
            <label class="layui-form-label">*分类名称：</label>
            <div class="layui-input-inline">
                <input id="categoryName" type="text" name="categoryName" lay-verify="required|categoryName"
                       placeholder="请输入分类名称"
                       autocomplete="off" class="layui-input" value="${spsGoodCategory.categoryName}">
            </div>
            <label class="layui-form-label">*权重：</label>
            <div class="layui-input-inline">
                <input id="categoryWeight" name="categoryWeight" type="text" lay-verify=”required|number|categoryWeight”
                       placeholder="请输入权重" autocomplete="off" class="layui-input"
                       value="${spsGoodCategory.categoryWeight}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*上级分类：</label>
            <div class="layui-input-inline">
                <input type="hidden" id="categoryParentId" name="categoryParentId"
                       autocomplete="off" class="layui-input"
                       value="${spsGoodCategory.categoryParentId}">
                <button class="layui-btn layui-btn-primary" id="showCategory">
                    <c:choose>
                        <c:when test="${categoryParentName eq ''}">
                            选择分类
                        </c:when>
                        <c:when test="${categoryParentName!= ''}">
                            ${categoryParentName}
                        </c:when>
                    </c:choose>
                </button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述：</label>
            <div class="layui-input-inline">
                <input id="categoryDes" type="text" name="categoryDes" lay-verify="categoryDes"
                       placeholder="请输入描述"
                       autocomplete="off" class="layui-input" value="${spsGoodCategory.categoryDes}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图片：</label>
            <div class="layui-input-inline">
                <input type="text" id="categoryUrl" name="categoryUrl" value="${spsGoodCategory.categoryUrl}"
                       placeholder="图片" class="layui-input"/>
                <button onclick="checkImgType()">上传图片</button>
                <%--  <input id="categoryUrl" type="hidden" name="categoryUrl"
                         value="${spsGoodCategory.categoryUrl}">
                  <button type="button" class="layui-btn" id="test1">上传图片</button>
                  <div class="layui-upload-list">
                      <img class="layui-upload-img" id="demo1"    style="padding-left: 109px;"  >
                      <p id="demoText"></p>--%>
            </div>
        </div>
        <div class="layui-form-item" align="center">
            <button class="layui-btn" lay-filter="submitCategory" lay-submit lay-filter="demo1" id="submit">立即提交
            </button>
            <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary">返回</button>
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

<script type="text/javascript">
    $(function () {
        $(".import").on("click", function () {
            $('#imgupl').click();
        });
        initTree();
        $("#tree").hide();
        if ($("#categoryParentName").val() == "") {
            $("#showCategory").html("选择分类")
        }
        if ($("#categoryParentId").val() != "" && $("#categoryParentId").val() == 0) {
            $("#showCategory").html("无")
            $("#showCategory").attr("disabled", "true");
        }

    })


    // 图片截取
    function checkImgType() {
        $("#imgupl").click();
    }

    // 验证图片格式及上传
    function validateFile() {
        var filename = $('#imgupl').val();
        var f = filename.split(".");
        if ($('#categoryParentId').val() == '') {
            layer.msg("请先选择分类")
            return false;
        }
        if ($('#parentFlag').val() == '0') {
            layer.msg("只有三级分类才可以上传图片")
            return false;
        }


        if (f.length == 2 && (f[1] == 'jpg' || f[1] == 'jpeg' || f[1] == 'png')) {
            var formData = new FormData($('#upload')[0]);
            $.ajax({
                url: '<%=path%>/common/file/upload',
                type: 'POST',
                dataType: 'json',
                data: formData,
                cache: false,
                contentType: false,    //不可缺
                processData: false,    //不可缺
                success: function (res) {
                    if (res.code == 0) {
                        $("#categoryUrl").val(res.fileName);
                        // $("#imgShow").attr('src',data.data.avatar);
                    } else {
                        layer.msg('上传失败');
                    }
                }
            });
        } else {
            $.layer.confirm('提示', '文件格式必须是‘jpg，jpeg，png’');
            $('#categoryUrl').val('');
        }
    }


    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: '/upload/'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });


    function initTree() {
        $.ajax({
            data: {},//提交的数据
            url: "<%=path%>/category/getTwoCategory",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                layui.use(['tree', 'layer'], function () {
                    var layer = layui.layer;
                    layui.tree({
                        elem: '#tree',
                        //check: 'checkbox',              //输入checkbox则生成带checkbox的tree, 默认不带checkbox
                        skin: 'as',                     //设定皮肤
                        drag: true,                     //点击每一项时是否生成提示信息
                        checkboxName: 'selectedArr',    //复选框的name属性值
                        checkboxStyle: "",              //设置复选框的样式，必须为字符串，css样式怎么写就怎么写
                        click: function (item) {          //节点点击事件
                            $("#showCategory").html(item.name)
                            console.log(item);
                            if (item.name == '无') {
                                $("#parentFlag").val("0")
                            }

                            $("#categoryParentId").val(item.id)
                            $("#tree").hide()
                            layer.closeAll()
                            // layer.msg('当前节名称：'+ item.name + '<br>全部参数：'+ JSON.stringify(item));
                            //console.log(item);
                        },
                        nodes: eval(result),
                    });
                });


            }//回调方法
        });

    }

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;

        //提交
        var post_flag = false; //设置一个对象来控制是否进入AJAX过程
        form.on('submit(submitCategory)', function (data) {
            if ($("#showCategory").html() == "选择分类") {
                layer.msg("请选择上级分类！");
                return false;
            }
            var type = true;
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态\
            var categoryName = $('#categoryName').val()
            var categoryWeight = $('#categoryWeight').val()
            var categoryParentId = $('#categoryParentId').val()
            var categoryDes = $('#categoryDes').val()
            var categoryUrl = $('#categoryUrl').val()
            var categoryId = $('#categoryId').val()
            //layer.load(1, {shade: [0.5, '#000']});
            if (type) {
                $.ajax({
                    data: {
                        categoryName: categoryName, categoryWeight: categoryWeight, categoryParentId: categoryParentId,
                        categoryDes: categoryDes, categoryUrl: categoryUrl, categoryId: categoryId
                    },
                    url: "<%=path%>/category/saveOrUpdate",//提交连接
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        post_flag = true; //在提交成功之后将标志标记为可提交状态
                        if (result.flag == '1') {
                            layer.msg("操作成功");
                            setTimeout(function () {
                                window.location.href = "<%=path%>/category";
                            }, 1000);
                        } else {
                            post_flag = false; //在提交成功之后将标志标记为可提交状态
                            layer.msg("操作失败");
                        }
                    }//回调方法
                });
            }

        })
        $(document).on("click", "#showCategory", function () {
            layer.open({
                type: 1,
                area: ['600px', '400px'],
                shade: false,
                title: false,
                skin: 'yourclass',
                content: $('#tree') //这里content是一个DOM，这个元素要放在body根节点下
            });
        })


        //自定义验证规则
        form.verify({
            categoryName: function (value) {
                if (value.length > 20) {
                    return '分类名称最多输入20个字符';
                }
            }, categoryWeight: function (value) {
                if (value > 9999 || value == 0) {
                    return '权重必须为0-9999的数字';
                }
            }, categoryDes: function (value) {
                if (value.length > 20) {
                    return '描述最多输入20个字符';
                }
            }
        });
    });

    //提交
    /* function saveOrUpdate() {
         var data = $("#dataForm").serialize();
         layer.load(1, {shade: [0.5, '#000']});
         $.ajax({
             data: data,//提交的数据
             url: "<%=path%>/category/saveOrUpdate",//提交连接
             type: 'post',
             dataType: 'json',
             success: function (result) {
                 if (result.flag == '1') {
                     layer.msg("操作成功");
                     setTimeout(function () {
                         window.location.href = "<%=path%>/category";
                     }, 1000);
                 } else {
                     layer.msg("操作失败");
                 }
             }//回调方法
         });
     }*/
    /*$(document).on("click", "#add", function () {
        layer.open({
            type: 1,
            area: ['600px', '400px'],
            shade: false,
            title: false,
            skin: 'yourclass',
            content: $('#tree') //这里content是一个DOM，这个元素要放在body根节点下
        });

    });*/

</script>
</body>
</html>