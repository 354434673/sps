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
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
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
    <h3>品牌信息</h3>
    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="goodsId" id="goodsId" value="${goodsId}">
        <input type="hidden" name="goodsNumberFlag" id="goodsNumberFlag">
        <div class="layui-form-item ">
            <label class="layui-form-label">*三级分类：</label>
            <div class="layui-input-inline">
                <input type="hidden" id="gCategoryIds" name="gCategoryIds" lay-verify="required"
                       autocomplete="off" class="layui-input">
                <input type="hidden" id="gCategoryNames" name="gCategoryNames" lay-verify="required"
                       autocomplete="off" class="layui-input">
                <button class="layui-btn layui-btn-primary" id="showCategory">
                    选择分类
                </button>
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*品牌：</label>
            <div class="layui-input-inline">
                <select id="gBrandId" name="gBrandId" lay-verify="">
                </select>
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU名称：</label>
            <div class="layui-input-inline">
                <input id="gSpuName" type="text" name="gSpuName" lay-verify="required" placeholder="请输入SPU名称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU编号：</label>
            <div class="layui-input-inline">
                <input id="gSpuNo" type="text" name="gSpuNo" lay-verify="required" placeholder="请输入SPU编号"
                       autocomplete="off" class="layui-input">
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
                    <th><a href="#" style="text-decoration: underline " id="addGoodSku">添加</a></th>
                </tr>
                </thead>
                <tbody id="content">
                <tr>
                    <td><input type="text" name="gSpuName" id="gColor" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gSize" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gNo" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gPrice"  class="tdStyle"></td>
                    <td width="208px"><input type="radio"  name="gPrice" value="1" title="按比例" checked>
                        <input type="radio" name="gPrice" value="0" title="按金额"></td>
                    <td><input type="text" name="gSpuName"  id="gType" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gScale" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gAprice" class="tdStyle">-<input type="text" name="gSpuName" id="gBprice" class="tdStyle"></td>
                    <td><a href="#" style="text-decoration: underline " id="adGoodSku">添加</a></td>
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
                <textarea placeholder="请输入内容" id="gDetails" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">包装清单</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" id="gRemark" class="layui-textarea"></textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">*主图：</label>
            <div class="layui-input-inline">
                <input type="hidden" name="gPic" id="gPic" value="">
                <input type="file" name="file"   style="padding-left: 5px;padding-top: 5px;" id="logoFile2"  onchange="setImg2(this);" multiple="multiple"/>
                <%-- <br/><font color="red">图片尺寸：750*300（支持多图批量上传）</font>--%>
                <%--   <input type="text" id="gPic" name="gPic"
                          placeholder="图片" class="layui-input"/>
                   <button onclick="checkImgType()">上传图片</button>--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*详情图：</label>
            <div class="layui-input-inline">
                <input type="hidden" name="gDpic" id="gDpic" value="">
                <input type="file" name="file" id="logoFile1"   style="padding-left: 5px;padding-top: 5px;" onchange="setImg1(this);" multiple="multiple"/ >
                <%-- <br/><font color="red">图片尺寸：750*300（支持多图批量上传）</font>--%>
                <%--   <input type="text" id="gPic" name="gPic"
                          placeholder="图片" class="layui-input"/>
                   <button onclick="checkImgType()">上传图片</button>--%>
            </div>
        </div>

        <div class="layui-form-item" align="center">
            <button class="layui-btn" lay-filter="submitGoods" lay-submit id="submit">立即提交
            </button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>
<div id="tree"></div>
</div>
<form id="upload" enctype="multipart/form-data">
    <input type="file" id='imgupl' name="file" style="display:none"  onchange="validateFile()"/>
</form>
<form id="upload1" enctype="multipart/form-data">
    <input type="file" id='imgup' name="file"  multiple="multiple"  style="display:none" onchange="validateFile1()"/>
</form>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script src="<%=path%>/page/static/js/ajaxfileupload.js"></script>
<script type="text/javascript"
        src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script src="<%=path%>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">
    $(function () {
        //修改时候获取数据
        if ($("#goodsId").val() != "") {
            getDate($("#goodsId").val());
            $("#showCategory").attr({"disabled":"disabled"});
            $("#gBrandId").attr({"disabled":"disabled"});
            $("#gSpuName").attr({"disabled":"disabled"});
            $("#gSpuNo").attr({"disabled":"disabled"});
        }
        initBrandList();
        initTree();
        $("#tree").hide();
        if ($("#brandCategoryNames").val() == "") {
            $("#showCategory").html("关联分类")
        } else {
            $("#showCategory").html($("#brandCategoryNames").val())
        }


    })

    function setImg2(obj){//用于进行图片上传，返回地址
        var f=$(obj).val();
        if(f == null || f ==undefined || f == ''){
            return false;
        }else if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
        {
            layer.msg("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        }else{
            //批量上传图片
            $.ajaxFileUpload({
                type: 'POST',
                url: '/sps-admin/common/file/manyUpload',
                secureuri:false,
                cache: false,
                fileElementId:"logoFile2",//文件选择框的id属性  ,//文件选择框的id属性
                dataType: 'json',   //json
                contentType: false,    //不可缺
                processData: false,    //不可缺
                success: function (data){
                    if (data.code == 0) {
                        $("#gPic").val(data.fileName);
                        // $("#brandSmallUrl").val(res.fileName);
                        // $("#imgShow").attr('src',data.data.avatar);
                    } else {
                        layer.msg('上传失败');
                    }
                    /* if(data!=null){
                         $.each(data,function(i,url){
                             //拼接图片列表
                             var id = $('#detailImgs li:last').attr('id');
                             id = id.substr(1);
                             id = parseInt(id) + 1;
                             var ids=id;
                             id = 'P'+id;
                             var a_hidden="<li id='"+ id +"'><input type='hidden' value='"+url+"' name='imgs'>";
                             var img_html="<img  src='"+url+"'  onclick='showOriginal(this)' original='"+url+"'>";
                             var a_html="<a href='javascript:void(0);' onclick='delespan1("+ids+")'>删除</a>";
                             var li_html="</li>";
                             $('#detailImgs').append(a_hidden+img_html+a_html+li_html);
                         });
                     }else{
                         layer.msg("上传失败");
                         $("#url").val("");
                         $(obj).val('');
                     }*/
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    layer.msg("上传失败，请检查网络后重试");
                    $("#url").val("");
                    $(obj).val('');
                }
            });
        }
    }
    function setImg1(obj){//用于进行图片上传，返回地址
        var f=$(obj).val();
        if(f == null || f ==undefined || f == ''){
            return false;
        }else if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
        {
            layer.msg("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        }else{
            //批量上传图片
            $.ajaxFileUpload({
                type: 'POST',
                url: '/sps-admin/common/file/manyUpload',
                secureuri:false,
                cache: false,
                fileElementId:"logoFile1",//文件选择框的id属性  ,//文件选择框的id属性
                dataType: 'json',   //json
                contentType: false,    //不可缺
                processData: false,    //不可缺
                success: function (data){
                    if (data.code == 0) {
                        $("#gDpic").val(data.fileName);
                    } else {
                        layer.msg('上传失败');
                    }
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    layer.msg("上传失败，请检查网络后重试");
                    $("#url").val("");
                    $(obj).val('');
                }
            });
        }
    }
    //上传之后如果感觉有张上传错了，想删除怎么办：
    function delespan1(id){
        $('#P'+id).remove();
    }

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
                    if (json.skuList != null) {
                        if ($.isArray(json.skuList)) {
                            $.each(json.skuList, function (index, val) {
                                $('#content').append(
                                    "<tr >" +
                                    "<input type='hidden'  value=''></td>" +
                                    "<td ><input type='text'   class='tdStyle' value=" + val.gColor + "></td>" +
                                    "<td ><input type='text' class='tdStyle' value=" + val.gSize + "></td>" +
                                    "<td ><input type='text' class='tdStyle' value=" + val.gNo + "></td>" +
                                    "<td ><input type='text' class='tdStyle' value=" + val.gPrice + "></td>" +
                                    "<td >" +
                                    "<input type='radio' value='0' name='type' title='按比例' checked>" +
                                    "<input type='radio' value='1'  name='type' title='按金额'  >" +
                                    "</td >" +
                                    "<td ><input type='text' class='tdStyle' value=" + val.gScale + "></td>" +
                                    "<td ><input type='text' class='tdStyle' value=" + val.gScale + "></td>" +
                                    "<td >" +
                                    "<span onclick='remove_line(this);'>删除</span> " +
                                    "</td>" +
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

    $(document).on("mouseleave", "input[name=gSpuNo]", function (e) {
        if ($("#goodsId").val() == "") {
            if ($("#gSpuNo").val() != undefined && $("#gSpuNo").val() != "" && $("#gSpuNo").val() != null) {
                $.ajax({
                    url: "/sps-admin/goods/checkGoodsNumber",//提交连接
                    type: 'post',
                    dataType: 'json',
                    async: false,
                    data: {gSpuNo: $("#gSpuNo").val()},
                    success: function (json) {
                        if (json.flag == "1") {
                            layer.msg("SPU编号已经存在！")
                            $('#goodsNumberFlag').val("1")
                        } else {
                            $('#goodsNumberFlag').val("0")
                        }
                    }
                });
            }
        }
    });

    //动态添加表格
    $(document).on('click', '#addGoodSku', function (e) {
        var no = $("#gSpuNo").val()+'-';
        $('#content').append(
            "<tr >" +
            "<input type='hidden'  value=''></td>" +
            "<td ><input type='text'   class='tdStyle' value=''></td>" +
            "<td ><input type='text' class='tdStyle' value=''></td>" +
            "<td >" + no + "<input type='text' style='width: 30px' value=''></td>" +
            "<td ><input type='text' class='tdStyle' value=''></td>" +
            "<td >" +
            "<input type='radio' value='0' name='type' title='按比例'>" +
            "<input type='radio' value='1'  name='type' title='按金额'  >" +
            "</td >" +
            "<td ><input type='text' class='tdStyle' value=''></td>" +
            "<td ><input type='text' class='tdStyle' value=''></td>" +
            "<td >" +
            "<span onclick='remove_line(this);'>删除</span> " +
            "</td>" +
            "</tr>");
    });


    //动态添加表格
    $(document).on('click', '#adGoodSku', function (e) {
        var no = $("#gSpuNo").val();
        var gColor = $("#gColor").val();
        var gSize = $("#gSize").val();
        var gNo = $("#gNo").val();
        var gPrice = $("#gPrice").val();
        var gType = $("#gType").val();
        var gScale = $("#gSpuNo").val();
        var gAprice = $("#gSpuNo").val();
        var gBprice = $("#gBprice").val();


        $('#content').append(
            "<tr >" +
            "<input type='hidden'  value=''></td>" +
            "<td > " + gColor + "</td>" +
            "<td >" + gSize + "</td>" +
            "<td >" + no +-+gNo+"</td>" +
            "<td >" + gPrice + "</td>" +
            "<td >" + gType + "</td>" +
            "<td >" + gScale + "</td>" +
            "<td >" + gBprice- gAprice+ "</td>" +
            "<td >" +
            "<span onclick='remove_line(this);'>删除</span> " +
            "</td>" +
            "</tr>");
    });
    //删除选择记录
    function remove_line(index) {
        $(index).parent().parent().remove();
    }

    //保存sku数据
    function SaveData() {
        $('#content tr').each(function () {
            /* var json = {};
             json.gColor = $(this).find("td:eq(0)").find("input").val();
             json.gSize = $(this).find("td:eq(1)").find("input").val();
             json.gNo = $(this).find("td:eq(2)").find("input").val();
             json.gPrice = $(this).find("td:eq(3)").find("input").val();
             json.gType = $(this).find("td:eq(4)").find("input").val();
             json.gScale = $(this).find("td:eq(5)").find("input").val();
             json.certno = $(this).find("td:eq(6)").find("input").val();
             var jsonStr = JSON.stringify(json);*/
            $.ajax({
                data: {
                    gGid: $("#goodsId").val(),
                    gColor: $(this).find("td:eq(0)").find("input").val(),
                    gSize: $(this).find("td:eq(1)").find("input").val(),
                    gNo: $(this).find("td:eq(2)").find("input").val(),
                    gPrice: $(this).find("td:eq(3)").find("input").val(),
                    gType: $(this).find("td:eq(4)").find("input").val(),
                    gScale: $(this).find("td:eq(5)").find("input").val(),
                },//提交的数据
                url: "<%=path%>/goodSku/saveOrUpdate",//提交连接
                type: 'post',
                dataType: 'json',
                success: function (result) {
                    if (result.flag == '1') {

                    } else {
                        layer.msg("操作失败");
                    }
                }
            });
        });

    }
    //从后台再查一次
    function getCategoryName(pId, id) {
        $.ajax({
            data: {pId: pId, id: id},//提交的数据
            url: "/sps-admin/category/getCategoryName",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    $("#showCategory").html(result.name);
                    $("#gCategoryIds").val(result.ids)
                    $("#gCategoryNames").val(result.name)
                } else {
                    layer.msg("操作失败");
                }
            }
        });

    }

    //获取树
    function initTree() {
        $.ajax({
            data: {},//提交的数据
            url: "/sps-admin/category/getCategory",//提交连接
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

    //获取品牌数据
    function initBrandList() {
        $.ajax({
            data: {},//提交的数据
            url: "/sps-admin/brand/findBrandList",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                var html = '<option value="">请选择</option>';
                if (result.flag == '1') {
                    if ($.isArray(result.data)) {
                        $.each(result.data, function (index, val) {
                            html += '<option value="' + val.brandId + '">' + val.brandName + '</option>';
                        })
                    }
                    $("#gBrandId").html(html);
                } else {
                    $("#gBrandId").html(html);
                }
            }//回调方法
        });

    }


    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        //提交
        var post_flag = false; //设置一个对象来控制是否进入AJAX过程
        form.on('submit(submitGoods)', function (data) {
            var type = true;
            if ($('#goodsNumberFlag').val() == "1") {
                layer.msg("SKU编号已经存在！");
                type = false;
            }
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态\
            if (type) {
                $.ajax(
                    {
                        data: {
                            gId: $('#goodsId').val(),
                            gCategoryIds: $('#gCategoryIds').val(),
                            gCategoryNames: $('#gCategoryNames').val(),
                            gBrandId: $('#gBrandId').val(),
                            gSpuName: $('#gSpuName').val(),
                            gSpuNo: $('#gSpuNo').val(),
                            gDetails: $('#gDetails').val(),
                            gRemark: $('#gRemark').val(),
                            gDpic: $('#gDpic').val(),
                            gPic: $('#gPic').val()
                        },
                        url: "/sps-admin/goods/saveOrUpdate",//提交连接
                        type: 'post',
                        dataType: 'json',
                        success: function (result) {
                            post_flag = false; //在提交成功之后将标志标记为可提交状态
                            if (result.flag == '1') {
                                $('#goodsId').val(result.goodsId)
                                //插入sku商品
                                SaveData()
                                layer.msg("操作成功");
                                setTimeout(function () {
                                    /* window.location.href = "/sps-admin//page/main/goods/index.jsp";*/
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
            //验证只包含汉字
            IsChineseCharacter: function (value) {
                var regex = /^[\u4e00-\u9fa5]+$/;
                if (!value.match(regex)) {
                    return '请输入正确的姓名';
                }
            },
            minLength: function (value) {
                if (value.length < 6) {
                    return '最少为6位';
                }
            },
            verify: function (value) {
                var repass = $('#password').val();
                if (value != repass) {
                    return '两次输入的密码不一致!';
                }
            },
        });
    });
</script>
</body>
</html>