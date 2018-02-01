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
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
</head>
<body>
<div style="padding: 40px">
    <h3>品牌信息</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="categoryId" id="brandId" >
        <div class="layui-form-item ">
            <label class="layui-form-label">*品牌名称：</label>
            <div class="layui-input-inline">
                <input id="brandName" type="text" name="brandName"   lay-verify="brandName" placeholder="请输入品牌名称"
                       autocomplete="off" class="layui-input" >
            </div>
            <label class="layui-form-label">*英文名称：</label>
            <div class="layui-input-inline">
                <input id="brandEnglishName" name="brandEnglishName" lay-verify="brandEnglishName" type="text"
                       placeholder="请输入英文名称" autocomplete="off" class="layui-input"
                       >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*简称：</label>
            <div class="layui-input-inline">
                <input id="brandAbbreviation" name="brandAbbreviation" type="text" lay-verify="brandAbbreviation"
                       placeholder="请输入简称" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">*关联分类：</label>
            <div class="layui-input-inline">
                <input type="hidden" id="brandCategoryIds" name="categoryParentId"  lay-verify="required"
                       autocomplete="off" class="layui-input">
                <input type="hidden" id="brandCategoryNames" name="brandCategoryNames"
                       autocomplete="off" class="layui-input">
                <button class="layui-btn layui-btn-primary" id="showCategory">
                </button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*小图标：</label>
            <div class="layui-input-inline">
                <input type="text" id="brandSmallUrl" name="brandSmallUrl" lay-verify="required"
                       placeholder="小图标" class="layui-input"/>
                <button onclick="checkImgType()">上传图片</button>
            </div>
            <span style="color: red">提示:尺寸是1：1 大小200k以内</span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*大图标：</label>
            <div class="layui-input-inline">
                <input type="text" id="brandBigUrl" name="brandBigUrl"  placeholder="大图标" lay-verify="required"
                       class="layui-input"/>
                <button onclick="checkImgType1()">上传图片</button>
            </div>
            <span style="color: red">提示:尺寸是1：1 大小200k以内</span>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">品牌描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入品牌描述" id="brandDes" class="layui-textarea" lay-verify="brandDes"></textarea>
            </div>
        </div>
        <div class="layui-form-item" align="center">
            <button class="layui-btn" lay-filter="submitCategory" lay-submit  id="submit">立即提交
            </button>
            <button id="back" class="layui-btn layui-btn-primary" >返回</button>
        </div>
    </div>
</div>
<div id="tree"></div>
</div>
<form id="upload" enctype="multipart/form-data">
    <input type="file" id='imgupl' name="file" style="display:none" onchange="validateFile()"/>
</form>
<form id="upload1" enctype="multipart/form-data">
    <input type="file" id='imgup' name="file" style="display:none" onchange="validateFile1()"/>
</form>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script src="<%=path%>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">
    $(function () {
        $(".import").on("click", function () {
            $('#imgupl').click();
        });
        $(".import").on("click", function () {
            $('#imgup').click();
        });
        initTree();
        $("#tree").hide();
        if ($("#brandCategoryNames").val() == "") {
            $("#showCategory").html("关联分类")
        }else {
            $("#showCategory").html($("#brandCategoryNames").val())
        }

    })


    // 图片截取
    function checkImgType() {
        $("#imgupl").click();
    }
    // 图片截取
    function checkImgType1() {
        $("#imgup").click();
    }

    // 验证图片格式及上传
    function validateFile() {
        var filename = $('#imgupl').val();
        var f = filename.split(".");
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
                        $("#brandSmallUrl").val(res.fileName);
                        // $("#imgShow").attr('src',data.data.avatar);
                    } else {
                        layer.msg('上传失败');
                    }
                }
            });
        } else {
            $.layer.confirm('提示', '文件格式必须是‘jpg，jpeg，png’');
            $('#brandSmallUrl').val('');
        }
    }
    // 验证图片格式及上传
    function validateFile1() {
        var filename = $('#imgup').val();
        var f = filename.split(".");
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
                        $("#brandBigUrl").val(res.fileName);
                        // $("#imgShow").attr('src',data.data.avatar);
                    } else {
                        layer.msg('上传失败');
                    }
                }
            });
        } else {
            $.layer.confirm('提示', '文件格式必须是‘jpg，jpeg，png’');
            $('#brandBigUrl').val('');
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

    //从后台再查一次
    function getCategoryName(pId, id) {
        $.ajax({
            data: {pId: pId, id: id},//提交的数据
            url: "<%=path%>/category/getCategoryName",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    $("#showCategory").html(result.name);
                    $("#brandCategoryIds").val(result.ids)
                    $("#brandCategoryNames").val(result.name)
                } else {
                    layer.msg("操作失败");
                }
            }
        });

    }
    $(document).on("click", "#back", function () {
        parent.layer.closeAll();
    })

    function initTree() {
        $.ajax({
            data: {},//提交的数据
            url: "<%=path%>/category/getCategory",//提交连接
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
                            //根据pid和id 到后台拼接分类名称和ids
                            getCategoryName(item.pid, item.id);
                            $("#tree").hide()
                            layer.closeAll()
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
            var names= $('#brandCategoryNames').val().split('>')
            if(names.length<3){
                layer.msg("请选择到三级分类！");
                return false;
            }
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态
            var brandId = $('#brandId').val()
            var brandName = $('#brandName').val()
            var brandCategoryNames = $('#brandCategoryNames').val()
            var brandEnglishName = $('#brandEnglishName').val()
            var brandCategoryIds = $('#brandCategoryIds').val()
            var brandAbbreviation = $('#brandAbbreviation').val();
            var brandDes = $('#brandDes').val();
            var brandSmallUrl = $('#brandSmallUrl').val()
            var brandBigUrl = $('#brandBigUrl').val()
            //layer.load(1, {shade: [0.5, '#000']});
            $.ajax(
                {
                    data: {
                        brandId: brandId,
                        brandName: brandName,
                        brandCategoryNames: brandCategoryNames,
                        brandEnglishName: brandEnglishName,
                        brandCategoryIds: brandCategoryIds,
                        brandAbbreviation: brandAbbreviation,
                        brandDes: brandDes,
                        brandSmallUrl: brandSmallUrl,
                        brandBigUrl: brandBigUrl
                    },
                    url: "<%=path%>/brand/saveOrUpdate",//提交连接
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        post_flag = false; //在提交成功之后将标志标记为可提交状态
                        if (result.flag == '1') {
                            layer.msg("操作成功");
                            setTimeout(function () {
                                window.location.href = "<%=path%>/page/main/brand/index.jsp";
                                //parent.layer.closeAll();

                            }, 1000);
                        } else {
                            post_flag = false; //在提交成功之后将标志标记为可提交状态
                            layer.msg("操作失败");
                        }
                    }//回调方法
                });

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
            brandName: function(value){
                if(value.length > 20){
                    return '品牌名称最多输入20个字符';
                }
            }, brandEnglishName: function(value){
                if(value.length > 50){
                    return '英文名称最多输入50个字符';
                }
            }, brandAbbreviation: function(value){
                if(value.length > 20){
                    return '简称最多输入20个字符';
                }
            }
        });
    });
</script>
</body>
</html>