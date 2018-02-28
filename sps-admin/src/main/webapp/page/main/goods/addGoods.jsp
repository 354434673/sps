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
        <input type="hidden" name="updateDetailFlag" id="updateDetailFlag">
        <input type="hidden" name="goodsNumberFlag" id="updatePicFlag">
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
                <input id="brandName" type="text" name="gSpuName" class="layui-input" style="display: none">
                <div id="brandId">
                    <select id="gBrandId" name="gBrandId" lay-filter="selFilter" lay-verify="required">

                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU名称：</label>
            <div class="layui-input-inline">
                <input id="gSpuName" type="text" name="gSpuName" lay-verify="required|gSpuName" placeholder="请输入SPU名称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU编号：</label>
            <div class="layui-input-inline">
                <input id="gSpuNo" type="text" name="gSpuNo" lay-verify="required|gSpuNo" placeholder="请输入SPU编号"
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
                    <th>审核状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" name="gSpuName" id="gColor" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gSize" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gNo" class="tdStyle"></td>
                    <td><input type="text" name="gSpuName" id="gPrice" class="tdStyle"></td>
                    <td width="208px"><input lay-filter="scale" type="radio" name="gType" value="1" title="按比例"
                                             class="type" checked>
                        <input type="radio" lay-filter="money" name="gType" value="0" title="按金额" class="type"></td>
                    <td><input type="text" name="gSpuName" id="gScale" class="tdStyle"><span id="number">%</span></td>
                    <td></td>
                    <td></td>
                    <td><a href="#" style="text-decoration: underline " id="adGoodSku">添加</a></td>
                </tr>
                </tbody>
                <tbody id="content">
                </tbody>

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
                <input value="" type="hidden" id="detail">
                <textarea placeholder="请输入内容" name="gDetails" lay-verify="maxDetailsLength" id="gDetails"
                          class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">*包装清单</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="gRemark" lay-verify="maxRemarkLength" id="gRemark"
                          class="layui-textarea"></textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">*主图：</label>
            <div class="layui-upload">
                <input type="text" name="gPic"  style="display: none"   id="gPic" class="layui-input" value="" <%--readonly="readonly"--%>>
                <input type="file" name="file" style="padding-left: 5px;padding-top: 5px;" id="logoFile2"
                       onchange="setImg2(this);" multiple="multiple"/>
                <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                    预览图：
                    <div class="layui-upload-list" id="demo2"></div>
                </blockquote>
            </div>
            <div style="padding-top: 10px"><span style="color: red">提示:最少一张，最多六张，单张大小不超过100K</span></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*详情图：</label>
            <div  class="layui-upload">
                <input type="text"  style="display: none" name="gDpic" id="gDpic" value="" class="layui-input" readonly="readonly">
                <input type="file" name="file" id="logoFile1" style="padding-left: 5px;padding-top: 5px;"
                       onchange="setImg1(this);" multiple="multiple">
                <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                    预览图：
                    <div class="layui-upload-list" id="demo"></div>
                </blockquote>
            </div>
            <div style="padding-top: 10px"><span style="color: red">提示:最多十张，单张大小不超过300K</span></div>
        </div>

        <div class="layui-form-item" align="center">
            <button class="layui-btn" lay-filter="submitGoods" lay-submit id="submit">提交
            </button>
            <button class="layui-btn" lay-filter="saveGoods" lay-submit id="saveGoods">保存
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
<form id="upload1" enctype="multipart/form-data">
    <input type="file" id='imgup' name="file" multiple="multiple" style="display:none" onchange="validateFile1()"/>
</form>
<script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
<script src="<%=path%>/page/static/js/ajaxfileupload.js"></script>
<script src="<%=path%>/page/static/treeTable/layui.js"></script>
<script type="text/javascript">
    $(function () {
        // initBrandList();
        initTree();
        $("#tree").hide();
        $('input[type=radio][name=gType]').change(function () {
            if (this.value == 'allot') {
            }
            else if (this.value == 'transfer') {
            }
        });
        //修改时候获取数据
        if ($("#goodsId").val() != "") {
            getDate($("#goodsId").val());
            $("#brandName").attr({"disabled": "disabled"});
            $("#showCategory").attr({"disabled": "disabled"});
            $("#gBrandId").attr({"disabled": "disabled"});
            $("#gSpuName").attr({"disabled": "disabled"});
            $("#gSpuNo").attr({"disabled": "disabled"});
        }

    })

    layui.use(['form', 'table', 'layedit', 'flow', 'element'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        var laydate = layui.laydate;
        var flow = layui.flow;
        var element = layui.element;
        var layedit = layui.layedit;
        var layedits = layui.layedit;
        var index=layedit.build('gDetails', {
            tool: ['strong','italic','underline','del', '|', 'left', 'center', 'right']
            ,height: 200
        })
        var indexes = layedits.build('gRemark', {
            tool: ['strong','italic','underline','del', '|', 'left', 'center', 'right']
            ,height: 200
        })
        form.on('radio(scale)', function () {
            $("#number").show();
        })
        form.on('radio(money)', function () {
            $("#number").hide();
        })

        form.on('submit(saveGoods)', function (data) {
            var type = true;
            if ($('#goodsNumberFlag').val() == "1") {
                layer.msg("SKU编号已经存在！");
                return false;
            }
            var names = $('#gCategoryNames').val().split('>')
            if (names.length < 3) {
                layer.msg("请选择到三级分类！");
                return false;
            }
            var i = 0;
            $('#content tr').each(function () {
                if ($(this).find("td:eq(0)").html() != '') {
                    i++
                }
            })
            if (i == 0) {
                layer.msg("请填写规格信息");
                return false;
            }
            if (layedit.getText(index) == "") {
                layer.msg("商品描述不能为空！");
                return false;
            }
            if (layedits.getText(indexes) == "") {
                layer.msg("包装清单不能为空！");
                return false;
            }
            if ($('#gDpic').val() == "") {
                layer.msg("详情图不能为空！");
                return false;
            }
            if ($('#gPic').val() == "") {
                layer.msg("主图不能为空！");
                return false;
            }
            if (layedit.getText(index).length>1000) {
                layer.msg("商品描述不能超过1000位！");
                return false;
            }
            if (layedits.getText(indexes).length>1000) {
                layer.msg("包装清单不能超过1000位！");
                return false;
            }
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态\
            if (type) {
                layedit.sync(index)
                $.ajax(
                    {
                        data: {
                            flowStatus: 0,
                            gId: $('#goodsId').val(),
                            gCategoryIds: $('#gCategoryIds').val(),
                            gCategoryNames: $('#gCategoryNames').val(),
                            gBrandId: $('#gBrandId').val(),
                            gSpuName: $('#gSpuName').val(),
                            gSpuNo: $('#gSpuNo').val(),
                            gDetails: layedit.getContent(index),
                            gRemark: layedits.getContent(indexes),
                            goodsDpic: $('#gDpic').val(),
                            goodsPic: $('#gPic').val(),
                            updateDetailFlag: $("#updateDetailFlag").val(),
                            updatePicFlag: $("#updatePicFlag").val()
                        },
                        url: "<%=path%>/goods/saveOrUpdate",//提交连接
                        type: 'post',
                        dataType: 'json',
                        success: function (result) {
                            post_flag = false; //在提交成功之后将标志标记为可提交状态
                            if (result.flag == '1') {
                                //如果为空则为新增  给goodsId赋值 不为空则为修改 不改变goodsId
                                if ($('#goodsId').val() == "") {
                                    $('#goodsId').val(result.goodsId)
                                }
                                //插入sku商品
                                waitSaveData()
                                layer.msg("操作成功");
                                setTimeout(function () {
                                    window.location.href = "<%=path%>/page/main/goods/index.jsp";
                                }, 1000);
                            } else if (result.flag == '2') {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("详情图最多为10张");
                            } else if (result.flag == '3') {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("主图最多为6张");
                            }else {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("操作失败")
                            }
                        }//回调方法
                    });
            }
            return false;
        })


        var post_flag = false; //设置一个对象来控制是否进入AJAX过程
        form.on('submit(submitGoods)', function (data) {
            var type = true;
            if ($('#goodsNumberFlag').val() == "1") {
                layer.msg("SKU编号已经存在！");
                return false;
            }
            var names = $('#gCategoryNames').val().split('>')
            if (names.length < 3) {
                layer.msg("请选择到三级分类！");
                return false;
            }
            var i = 0;
            $('#content tr').each(function () {
                if ($(this).find("td:eq(0)").html() != '') {
                    i++
                }
            })
            if (i == 0) {
                layer.msg("请填写规格信息");
                return false;
            }

            if (layedit.getContent(index) == "") {
                layer.msg("商品描述不能为空！");
                return false;
            }
            if (layedits.getContent(indexes) == "") {
                layer.msg("包装清单不能为空！");
                return false;
            }
            if ($('#gDpic').val() == "") {
                layer.msg("详情图不能为空！");
                return false;
            }
            if ($('#gPic').val() == "") {
                layer.msg("主图不能为空！");
                return false;
            }
            if (layedit.getText(index).length>1000) {
                layer.msg("商品描述不能超过1000位！");
                return false;
            }
            if (layedits.getText(indexes).length>1000) {
                layer.msg("包装清单不能超过1000位！");
                return false;
            }
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态\
            if (type) {
                layedit.sync(index)
                $.ajax(
                    {
                        data: {
                            gDetails: layedit.getContext(index),
                            gRemark: layedits.getContext(indexes),
                            flowStatus: 1,
                            gId: $('#goodsId').val(),
                            gCategoryIds: $('#gCategoryIds').val(),
                            gCategoryNames: $('#gCategoryNames').val(),
                            gBrandId: $('#gBrandId').val(),
                            gSpuName: $('#gSpuName').val(),
                            gSpuNo: $('#gSpuNo').val(),
                            goodsDpic: $('#gDpic').val(),
                            goodsPic: $('#gPic').val(),
                            updateDetailFlag: $("#updateDetailFlag").val(),
                            updatePicFlag: $("#updatePicFlag").val()
                        },
                        url: "<%=path%>/goods/saveOrUpdate",//提交连接
                        type: 'post',
                        dataType: 'json',
                        success: function (result) {
                            post_flag = false; //在提交成功之后将标志标记为可提交状态
                            if (result.flag == '1') {
                                //如果为空则为新增  给goodsId赋值 不为空则为修改 不改变goodsId
                                if ($('#goodsId').val() == "") {
                                    $('#goodsId').val(result.goodsId)
                                }
                                //插入sku商品
                                SaveData()
                                layer.msg("操作成功");
                                setTimeout(function () {
                                    window.location.href = "<%=path%>/page/main/goods/index.jsp";
                                }, 1000);
                            } else if (result.flag == '2') {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("详情图最多为10张");
                            } else if (result.flag == '3') {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("主图最多为6张");
                            }else {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("操作失败")
                            }
                        }//回调方法
                    });
            }
            return false;
        })
        //自定义验证规则
        form.verify({
            gSpuName: function (value) {
                if (value.length > 20) {
                    return 'spu名称最多输入20个字符';
                }
            }, gSpuNo: function (value) {
                if (value.length > 20) {
                    return 'spu编号最多输入20个字符';
                }
            }, gDetails: function (value) {
                if (value.length > 1000) {
                    return '商品描述最多输入1000个字符';
                }
            }

        });
    });
    /*  layui.use(['form'], function () {
          var form = layui.form;
          var $ = layui.jquery;
          form.on('select()', function (da) {

          });
      });*/
    /*  layui.use(["form"], function(){
          var form= layui.form();
          form.on("select(selFilter)", function(data){
              var OptionIndex = data.elem.selectedIndex; //得到选中的下标
              var text = data.elem.options[OptionIndex].text; //得到选中下标的文本信息
              console.log(data.elem); //得到select原始DOM对象
              console.log(data.value); //得到被选中的值
          });
      });*/

    function setImg2(obj) {//用于进行图片上传，返回地址
        var f = $(obj).val();
        if (f == null || f == undefined || f == '') {
            return false;
        } else if (!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)) {
            layer.msg("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        } else {
            //批量上传图片
            $.ajaxFileUpload({
                type: 'POST',
                url: '<%=path%>/common/file/manyUpload',
                secureuri: false,
                cache: false,
                fileElementId: "logoFile2",//文件选择框的id属性  ,//文件选择框的id属性
                dataType: 'json',   //json
                contentType: false,    //不可缺
                processData: false,    //不可缺
                success: function (data) {
                    if (data.code == 0) {
                        console.log(data.fileName)
                        $('#demo2').find("img").remove();
                        $("#gPic").val(data.fileName);
                            $.each(data.fileName, function (index, val) {
                                $('#demo2').append(
                                    "<img style='width: 300px;'  src='<%=path%>/upload/imgs/" + val+ "' />"
                                )
                            })

                       /* $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')*/
                        //如果重新调用过上传图片的方法 则表示商品主图修改过，后台删掉重新添加
                        $("#updatePicFlag").val(0);
                        // $("#pic").val(data.fileName);
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
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg("上传失败，请检查网络后重试");
                    $("#url").val("");
                    $(obj).val('');
                }
            });
        }
    }

    function setImg1(obj) {//用于进行图片上传，返回地址
        var f = $(obj).val();
        if (f == null || f == undefined || f == '') {
            return false;
        } else if (!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)) {
            layer.msg("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
            $(obj).val('');
            return false;
        } else {
            //批量上传图片
            $.ajaxFileUpload({
                type: 'POST',
                url: '<%=path%>/common/file/manyUpload',
                secureuri: false,
                cache: false,
                fileElementId: "logoFile1",//文件选择框的id属性  ,//文件选择框的id属性
                dataType: 'json',   //json
                contentType: false,    //不可缺
                processData: false,    //不可缺
                success: function (data) {
                    if (data.code == 0) {
                        $('#demo').find("img").remove();
                        $.each(data.fileName, function (index, val) {
                            $('#demo').append(
                                "<img style='width: 300px;'  src='<%=path%>/upload/imgs/" + val+ "' />"
                            )
                        })
                        $("#gDpic").val(data.fileName);
                        //如果重新调用过上传图片的方法 则表示商品详情图修改过，后台删掉重新添加
                        $("#updateDetailFlag").val(1);
                    } else {
                        layer.msg('上传失败');
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg("上传失败，请检查网络后重试");
                    $("#url").val("");
                    $(obj).val('');
                }
            });
        }
    }

    //上传之后如果感觉有张上传错了，想删除怎么办：
    function delespan1(id) {
        $('#P' + id).remove();
    }

    function getBrand(id) {
        //获取品牌数据
        if ($("#gCategoryIds").val() != "") {
            $.ajax({
                data: {categoryId: id},
                url: "<%=path%>/brand/findBrandList",//提交连接
                type: 'post',
                dataType: 'json',
                success: function (result) {
                    if (result.flag == '1') {
                        if ($.isArray(result.data)) {
                            var html = '<option value="">请选择</option>';
                            $.each(result.data, function (index, val) {
                                html += '<option value="' + val.brandId + '">' + val.brandName + '</option>';
                            })
                            $("#gBrandId").html(html);
                        }
                        layui.form.render('select');
                    } else {
                        $("#gBrandId").html(html);
                    }
                }//回调方法
            });
        }

    }

    //修改获取数据
    function getDate(goodsId) {
        $.ajax({
            url: "<%=path%>/goods/findEntity",//提交连接
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
                        /* $("#gBrandId").find("option[text="+json.goods.gBrandId+"]").attr("selected",true);*/
                        $('#gSpuName').val(json.goods.gSpuName);
                        $('#gSpuNo').val(json.goods.gSpuNo);
                        $('#gDetails').val(json.goods.gDetails);
                        $('#gRemark').val(json.goods.gRemark);
                        $('#gBrandId').val(json.goods.gBrandId);
                    }
                    if (json.brandName != null) {
                        $("#brandName").val(json.brandName);
                        $("#brandId").hide();
                        $("#brandName").show();

                        //   $("#gBrandId").addClass("layui-hide");
                        //document.getElementById("gBrandId").style.display="none";
                        //  $('#gBrandId').addClass("display","block");
                        /* layer.select("selFilter").setValue(json.brandName);*/
                        /*  $("#gBrandId").val(json.brandName)
                          layui.form().render('select')
                          $(select).val(option[json.brandName]);*/

                        /* $("#brandName").attr("display","block");
                         $("#gBrandId").attr("display","none");
                         $("#brandName").val(json.brandName)e
                         $("#gBrandId option[text="+json.brandName+"]").attr("selected", "selected");*/
                        // $("#gBrandId").html('<option value="">' + json.brandName + '</option>');
                        /* var html = '<option value="">' + json.brandName + '</option>';
                         $("#gBrandId").html(html);*/
                    }
                    if (json.detailList != null) {
                        var picVal = "";
                        if ($.isArray(json.detailList)) {
                            $.each(json.detailList, function (index, val) {
                                $('#demo').append(
                                    "<img style='width: 300px;'  src='<%=path%>/upload/imgs/" + val.albumUrl+ "' />"
                                )
                                if (index != json.detailList.length - 1) {
                                    picVal += val.albumUrl + ","
                                } else {
                                    picVal += val.albumUrl
                                }
                            })
                        }
                        $('#gDpic').val(picVal)
                    }
                    if (json.picList != null) {
                        var picVal = "";
                        if ($.isArray(json.picList)) {
                            $.each(json.picList, function (index, val) {
                                $('#demo2').append(
                                    "<img style='width: 300px;'  src='<%=path%>/upload/imgs/" + val.albumUrl+ "' />"
                                )
                                if (index != json.picList.length - 1) {
                                    picVal += val.albumUrl + ","
                                } else {
                                    picVal += val.albumUrl
                                }
                            })
                        }
                        $('#gPic').val(picVal)

                    }
                    if (json.skuList != null) {
                        if ($.isArray(json.skuList)) {
                            $.each(json.skuList, function (index, val) {
                                if (val.gType == "0") {
                                    val.gType = "按金额"
                                } else if (val.gType == "1") {
                                    val.gType = "按比例"
                                }
                                if (val.gAuditStatus == "0") {
                                    val.gAuditStatus = "待提交"
                                } else if (val.gAuditStatus == "1") {
                                    val.gAuditStatus = "审核中"
                                } else if (val.gAuditStatus == "2") {
                                    val.gAuditStatus = "审核不通过"
                                } else if (val.gAuditStatus == "3") {
                                    val.gAuditStatus = "审核通过"
                                } else if (val.gAuditStatus == undefined) {
                                    val.gAuditStatus = "-"
                                }
                                $('#content').append(
                                    "<tr >" +
                                    "<td > " + val.gColor + "</td>" +
                                    "<td >" + val.gSize + "</td>" +
                                    "<td >" + val.gNo + "</td>" +
                                    "<td >" + val.gPrice + "</td>" +
                                    "<td >" + val.gType + "</td>" +
                                    "<td >" + val.gScale + "</td>" +
                                    "<td >" + val.gAprice + "-" + val.gBprice + "</td>" +
                                    "<td >" + val.gAuditStatus + "</td>" +
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
                    url: "<%=path%>/goods/checkGoodsNumber",//提交连接
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
    $(document).on('click', '#adGoodSku', function (e) {

        if ($("#gSpuNo").val() != "") {
            if ($("#gColor").val() == "") {
                layer.msg("颜色不能为空！")
                $("#gColor").focus()
                return false;
            }
            if ($("#gSize").val() == "") {
                layer.msg(" 尺寸不能为空！")
                $("#gSize").focus()
                return false;
            }
            if ($("#gNo").val() == "") {
                layer.msg("编号不能为空！")
                $("#gNo").focus()
                return false;
            }
            if ($("#gPrice").val() == "") {
                layer.msg("基准价不能为空！")
                $("#gPrice").focus()
                return false;
            }
            var p=/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/; //正数
            if(!p.test($("#gPrice").val())){
                layer.msg("基准价输入正数且小数位不超过2位！");
                return false;
            }
            if ($("#gScale").val() == "") {
                layer.msg("波动值不能为空！")
                $("#gScale").focus()
                return false;
            }
            var no = $("#gSpuNo").val();
            var gColor = $("#gColor").val();
            var gSize = $("#gSize").val();
            var gNo = $("#gNo").val();
            var gPrice = $("#gPrice").val();
            var gType = $("input[type='radio']:checked").val();
            var gScale = $("#gScale").val();
            var gAprice;
            var gBprice;
            if (gType == "1") {
                gType = '按比例';
                gAprice = accSub(gPrice, accMul(gPrice, accDiv(gScale, 100)));
                gBprice = accAdd(gPrice, accMul(gPrice, accDiv(gScale, 100)));
                gAprice = parseFloat(gAprice).toFixed(2);
                gBprice = parseFloat(gBprice).toFixed(2);
                gScale = gScale + "%";
            } else if (gType == "0") {
                gType = '按金额';
                gAprice = accSub(gPrice, gScale);
                gBprice = accAdd(gPrice, gScale);
                gAprice = parseFloat(gAprice).toFixed(2);
                gBprice = parseFloat(gBprice).toFixed(2);
            }
            $('#content').append(
                "<tr >" +
                "<td > " + gColor + "</td>" +
                "<td >" + gSize + "</td>" +
                "<td >" + no + '-' + gNo + "</td>" +
                "<td >" + gPrice + "</td>" +
                "<td >" + gType + "</td>" +
                "<td >" + gScale + "</td>" +
                "<td >" + gAprice + "-" + gBprice + "</td>" +
                "<td ></td>" +
                "<td >" +
                "<span onclick='remove_line(this);'>删除</span> " +
                "</td>" +
                "</tr>");
        } else {
            layer.msg("请先输入spu编号")
        }
    });
    $(document).on('change', '#addGoodSku', function (e) {

    })


    //动态添加表格
    $(document).on('click', '#addGoodSku', function (e) {
        var no = $("#gSpuNo").val();
        var gColor = $("#gColor").val();
        var gSize = $("#gSize").val();
        var gNo = $("#gNo").val();
        var gPrice = $("#gPrice").val();
        var gType = $("input[type='radio']:checked").val();
        var gScale = $("#gSpuNo").val();
        var gAprice = $("#gSpuNo").val();
        var gBprice = $("#gBprice").val();
        $('#content').append(
            "<tr >" +
            "<td > " + gColor + "</td>" +
            "<td >" + gSize + "</td>" +
            "<td >" + no + -+gNo + "</td>" +
            "<td >" + gPrice + "</td>" +
            "<td >" + gType + "</td>" +
            "<td >" + gScale + "</td>" +
            "<td >" + gBprice - gAprice + "</td>" +
            "<td >" +
            "<span onclick='remove_line(this);'>删除</span> " +
            "</td>" +
            "</tr>");

    });

    //删除选择记录
    function remove_line(index) {
        layer.confirm('真的删除行么？', {
            btn: ['删除', '取消'], //按钮
            shade: false //不显示遮罩
        }, function (index1) {
            $(index).parent().parent().remove();
            // 提交表单的代码，需要你自己写，然后用 layer.close 关闭就可以了，取消可以省略
            layer.close(index1);
        });
    }

    //保存sku数据
    function SaveData() {

        $('#content tr').each(function () {
            var aprice = $(this).find("td:eq(6)").html().split('-')[0];
            var bprice = $(this).find("td:eq(6)").html().split('-')[1];
            var scale = $(this).find("td:eq(5)").html();
            var tag = '%';
            if (scale.indexOf(tag) != -1) {
                scale = scale.split('%')[0];
            }
            var waveType;
            if ($(this).find("td:eq(4)").html() == "按比例") {
                waveType = "1";
            } else if ($(this).find("td:eq(4)").html() == "按金额") {
                waveType = "0";
            }
            var no = $(this).find("td:eq(2)").html();
            var goodNo = no.split("-")[0];
            $.ajax({
                data: {
                    gGoodNo: goodNo,
                    gAuditStatus: 1,
                    gType: waveType,
                    gBprice: bprice,
                    gAprice: aprice,
                    gGid: $("#goodsId").val(),
                    gColor: $(this).find("td:eq(0)").html(),
                    gSize: $(this).find("td:eq(1)").html(),
                    gNo: $(this).find("td:eq(2)").html(),
                    gPrice: $(this).find("td:eq(3)").html(),
                    gScale: scale
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

    //保存sku数据
    function waitSaveData() {

        $('#content tr').each(function () {
            var aprice = $(this).find("td:eq(6)").html().split('-')[0];
            var bprice = $(this).find("td:eq(6)").html().split('-')[1];
            var scale = $(this).find("td:eq(5)").html();
            var tag = '%';
            if (scale.indexOf(tag) != -1) {
                scale = scale.split('%')[0];
            }
            var waveType;
            if ($(this).find("td:eq(4)").html() == "按比例") {
                waveType = "1";
            } else if ($(this).find("td:eq(4)").html() == "按金额") {
                waveType = "0";
            }
            var no = $(this).find("td:eq(2)").html();
            var goodNo = no.split("-")[0];
            $.ajax({
                data: {
                    gGoodNo: goodNo,
                    gAuditStatus: 0,
                    gType: waveType,
                    gBprice: bprice,
                    gAprice: aprice,
                    gGid: $("#goodsId").val(),
                    gColor: $(this).find("td:eq(0)").html(),
                    gSize: $(this).find("td:eq(1)").html(),
                    gNo: $(this).find("td:eq(2)").html(),
                    gPrice: $(this).find("td:eq(3)").html(),
                    gScale: scale
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
            url: "<%=path%>/category/getCategoryName",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    $("#showCategory").html(result.name);
                    $("#gCategoryIds").val(result.ids);
                    $("#gCategoryNames").val(result.name);
                    getBrand(id);

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
                            $("#tree").hide();
                            layer.closeAll();
                        },
                        nodes: eval(result),
                    });
                });
            }//回调方法
        });

    }

    //获取品牌数据
    var html = '<option value="">请选择</option>';

    function initBrandList() {
        $.ajax({
            url: "<%=path%>/brand/findBrandList",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
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
            gSpuName: function (value) {
                if (value.length > 20) {
                    return 'SPU名称最多为20位';
                }
            },
            gSpuNo: function (value) {
                if (value.length > 20) {
                    return 'SPU编号最多为20位';
                }
            },
            maxDetailsLength: function (value) {
                if (value.length > 1000) {
                    return '商品详情最多为1000位';
                }
            },
            maxRemarkLength: function (value) {
                if (value.length > 1000) {
                    return '包装清单最多为1000位';
                }
            },

        });
    });


    // 两个浮点数求和
    function accAdd(num1, num2) {
        var r1, r2, m;
        try {
            r1 = num1.toString().split('.')[1].length;
        } catch (e) {
            r1 = 0;
        }
        try {
            r2 = num2.toString().split(".")[1].length;
        } catch (e) {
            r2 = 0;
        }
        m = Math.pow(10, Math.max(r1, r2));
        // return (num1*m+num2*m)/m;
        return Math.round(num1 * m + num2 * m) / m;
    }

    // 两个浮点数相减
    function accSub(num1, num2) {
        var r1, r2, m;
        try {
            r1 = num1.toString().split('.')[1].length;
        } catch (e) {
            r1 = 0;
        }
        try {
            r2 = num2.toString().split(".")[1].length;
        } catch (e) {
            r2 = 0;
        }
        m = Math.pow(10, Math.max(r1, r2));
        n = (r1 >= r2) ? r1 : r2;
        return (Math.round(num1 * m - num2 * m) / m).toFixed(n);
    }

    // 两数相除
    function accDiv(num1, num2) {
        var t1, t2, r1, r2;
        try {
            t1 = num1.toString().split('.')[1].length;
        } catch (e) {
            t1 = 0;
        }
        try {
            t2 = num2.toString().split(".")[1].length;
        } catch (e) {
            t2 = 0;
        }
        r1 = Number(num1.toString().replace(".", ""));
        r2 = Number(num2.toString().replace(".", ""));
        return (r1 / r2) * Math.pow(10, t2 - t1);
    }

    function accMul(num1, num2) {
        var m = 0, s1 = num1.toString(), s2 = num2.toString();
        try {
            m += s1.split(".")[1].length
        } catch (e) {
        }
        ;
        try {
            m += s2.split(".")[1].length
        } catch (e) {
        }
        ;
        return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
    }
</script>
</body>
</html>