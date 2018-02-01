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

        <input type="hidden" id="platformGoodId">
        <input type="hidden" name="goodsId" id="goodsId" value="${goodsId}">
        <input type="hidden" name="goodsNumberFlag" id="goodsNumberFlag">
        <input type="hidden" id="skuIds">
        <input type="hidden" name="categoryIds" id="categoryIds">
        <div class="layui-form-item ">
            <label class="layui-form-label">*一级分类：</label>
            <div class="layui-input-inline">
                <input id="firstCategoryName" type="text" class="layui-input" name="gSpuName"
                       style="display: none;">
                <div id="first">
                    <select id="firstCategory" name="firstCategory" lay-filter="firstFilter">
                        <%--    <option value="">请选择</option>
                            <option value="1">1212</option>
                            <option value="47">父类</option>
                            <option value="51">2323</option>
                            <option value="82">手机</option>--%>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">*二级分类：</label>
            <div class="layui-input-inline">
                <input id="twoCategoryName" type="text" class="layui-input" name="gSpuName"
                       style="display: none;">
                <div id="second">
                    <select id="secondCategory" name="secondCategory" lay-filter="secondFilter">
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">*三级分类：</label>
            <div class="layui-input-inline">
                <input id="threeCategoryName" type="text" class="layui-input " name="gSpuName"
                       style="display: none;">
                <div id="three">
                    <select id="threeCategory" name="threeCategory" lay-filter="threeFilter">

                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item ">
            <label class="layui-form-label">*关联品牌：</label>
            <div class="layui-input-inline">
                <input id="brandName" type="text" class="layui-input" name="gSpuName"
                       style="display: none;">
                <div id="brand">
                    <select id="gBrandId" name="gBrandId" lay-filter="selFilter">

                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item ">
            <label class="layui-form-label">*SPU：</label>
            <input type="hidden" id="spu">
            <div class="layui-input-inline">
                <input id="gSpuName" type="text" class="layui-input" name="gSpuName"
                       style="display: none;">
                <div id="spuName">
                    <select id="spuNo" name="gBrandId" lay-filter="spuFilter">

                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item" align="center">
            <button type="reset" id="next" class="layui-btn layui-btn-primary">下一步</button>
        </div>


        <div id="two" style="display: none">
            <div class="layui-form-item ">
                <label class="layui-form-label">自定义分类：</label>
                <div class="layui-input-inline">
                    <select id="customCategory" name="customCategory" lay-filter="customFilter">
                    </select>
                </div>
            </div>
            <div class="layui-form-item ">
                <label class="layui-form-label">*是否推荐：</label>
                <div class="layui-input-inline">
                    <input lay-filter="scale" type="radio" name="gRecommend" value="1" title="是" class="type" checked>
                    <input type="radio" lay-filter="money" name="gRecommend" value="0" title="否" class="type">
                </div>
            </div>
            <div class="layui-form-item ">
                <label class="layui-form-label">*是否上架：</label>
                <div class="layui-input-inline">
                    <input lay-filter="scale" type="radio" name="gGroundingFlag" value="1" title="是" class="type"
                           checked>
                    <input type="radio" lay-filter="money" name="gGroundingFlag" value="0" title="否" class="type">
                </div>
            </div>
            <div class="layui-form-item ">
                <label class="">*规格：</label>
                <table class="layui-table">
                    <thead>
                    <tr>
                        <th></th>
                        <th>颜色</th>
                        <th>尺寸</th>
                        <th>sku编号</th>
                        <th>售卖价(元)</th>
                        <th>起订量</th>
                        <th>库存</th>
                        <th>代销服务费率</th>
                        <th>代销服务费(每件)</th>
                    </tr>
                    </thead>
                    <tbody id="content">
                    </tbody>

                </table>
            </div>
            <div id="showStatus" style="display: none">
                <div class="layui-form-item   ">
                    <label class="layui-form-label">拒绝意见：</label>
                        <span id="opinion"></span>
                </div>
            </div>

            <div class="layui-form-item" align="center">
                <button class="layui-btn" lay-filter="submitGoods" lay-submit id="submit">提交</button>
                <button class="layui-btn" lay-filter="saveGoods" lay-submit id="saveGoods">保存</button>
                <button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary">返回</button>
            </div>
        </div>
    </div>
</div>
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
        //修改时候获取数据
        if ($("#goodsId").val() != "") {
            $('#firstCategoryName').show()
            $('#twoCategoryName').show()
            $('#threeCategoryName').show()
            $('#gSpuName').show();
            $("#brandName").show();

            $('#first').hide();
            $('#second').hide();
            $('#three').hide();
            $('#spuName').hide();
            $("#brand").hide();

            $('#firstCategoryName').attr({"disabled": "disabled"});
            $('#twoCategoryName').attr({"disabled": "disabled"});
            $('#threeCategoryName').attr({"disabled": "disabled"});
            $('#gSpuName').attr({"disabled": "disabled"});
            $('#brandName').attr({"disabled": "disabled"});

            $("#firstCategory").attr({"disabled": "disabled"});
            $("#secondCategory").attr({"disabled": "disabled"});
            $("#threeCategory").attr({"disabled": "disabled"});
            $("#gBrandId").attr({"disabled": "disabled"});
            $("#spuNo").attr({"disabled": "disabled"});
            getDate($("#goodsId").val());

        }
        initFirstCategory();

    })

    layui.use(['form', 'table', 'layedit', 'flow', 'element'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        var laydate = layui.laydate;
        var flow = layui.flow;
        var element = layui.element;
        form.render('checkbox');
        //从数组中移除元素
        Array.prototype.indexOf = function (val) {
            for (var i = 0; i < this.length; i++) {
                if (this[i] == val) return i;
            }
            return -1;
        };
        Array.prototype.remove = function (val) {
            var index = this.indexOf(val);
            if (index > -1) {
                this.splice(index, 1);
            }
        };

        //如果 存在返回true , 不存在返回false
        function contains(arr, obj) {
            var i = arr.length;
            while (i--) {
                if (arr[i] === obj) {
                    return true;
                }
            }
            return false;
        }

        var ids = new Array();
        //对象转数组
        var skuIds = $("#skuIds").val().split(',')
        for (var i in skuIds) {
            ids.push(skuIds[i]); //属性
        }
        ids.pop(ids.length - 1);
        form.on('checkbox(sscale)', function (data) {
            if (data.elem.checked == true) {
                if ($("#goodsId").val() != '') {
                    //判断是否存在
                    var arr = contains(ids, data.value)
                    if (!arr) {
                        ids.push(data.value);
                        $("#skuIds").val(ids);
                    }
                } else {
                    ids.push(data.value);
                    $("#skuIds").val(ids)
                }
            } else {
                ids.remove(data.value);
                $("#skuIds").val(ids)
            }
            /* getChildren(data.value, 'secondCategory')*/
        })


        form.on('select(firstFilter)', function (data) {
            getChildren(data.value, 'secondCategory')
        })
        form.on('select(secondFilter)', function (data) {
            getChildren(data.value, 'threeCategory')
        })
        form.on('select(threeFilter)', function (data) {
            getBrand(data.value)
        })
        form.on('select(selFilter)', function (data) {
            getSpuGoods(data.value)
        })
        form.on('select(spuFilter)', function (data) {
            id = data.value;
            name = data.elem[data.elem.selectedIndex].text;
            $("#spu").val(name);
            $("#platformGoodId").val(id);
            checkSpu(name, id)
        })

        $(document).on("click", "#next", function (e) {
            if ($("#goodsNumberFlag").val() == "1") {
                layer.msg("当前sup已经存在,请重新选择！")
                return false;
            }
            if ($("#firstCategory").val() == ""||$("#firstCategory").val() == null) {
                layer.msg("一级分类不能为空！")
                return false;
            }
            if ($("#secondCategory").val() == ""||$("#secondCategory").val() == null) {
                layer.msg(" 二级分类不能为空！")
                return false;
            }
            if ($("#threeCategory").val() == ""||$("#threeCategory").val() == null) {
                layer.msg("三级分类不能为空！")
                return false;
            }
            if ($("#gBrandId").val() == ""||$("#gBrandId").val() == null) {
                layer.msg("品牌不能为空！")
                return false;
            }
            if ($("#spuNo").val() == ""||$("#spuNo").val() == null) {
                layer.msg("SPU不能为空！")
                return false;
            }
            initCustomCategory();
            $("#two").show();
            $("#next").hide();
            $("#categoryIds").val($("#firstCategory").val() + ',' + $("#secondCategory").val() + ',' + $("#threeCategory").val());
            $("#firstCategory").attr({"disabled": "disabled"});
            $("#secondCategory").attr({"disabled": "disabled"});
            $("#threeCategory").attr({"disabled": "disabled"});
            $("#gBrandId").attr({"disabled": "disabled"});
            $("#spuNo").attr({"disabled": "disabled"});
        });
        var post_flag = false; //设置一个对象来控制是否进入AJAX过程
        form.on('submit(saveGoods)', function (data) {
            if ($("#skuIds").val() == "") {
                layer.msg("请选择规格！");
                return false;
            }
            var i = 1;
            var flag=true
            $("input:checkbox[name='sscale']:checked").each(function() { // 遍历name=test的多选框
                var r = /^[0-9]*[1-9][0-9]*$/　　//正整数
                var p=/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/; //正数
                var gQuantity = $(this).parent().parent().find("td:eq(5)").find("input").val();
                var gStock =  $(this).parent().parent().find("td:eq(6)").find("input").val()
                var gPrice =  $(this).parent().parent().find("td:eq(4)").find("input").val()
                if(gQuantity==''||gStock==''||gPrice==''){
                    layer.msg("第" + i + "行规格参数不能为空！");
                    flag= false;
                } else if(!r.test(gQuantity)||!r.test(gStock)){
                    layer.msg("第" + i + "请输入正整数！");
                    flag= false;
                }else if(!p.test(gPrice)){
                    layer.msg("第" + i + "价格输入正数且小数位不超过2位！");
                    flag= false;
                }
                if (gQuantity != '' && gStock != '') {
                    if (parseInt(gQuantity) > parseInt(gStock)) {
                        layer.msg("第" + i + "行起订量不能大于库存！");
                        flag= false;
                    }
                }
                i++;
            });
            if(flag==false){
                return false;
            }
            var type = true;
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态\
            var gSpuName = $('#spu').val().split("-")[1];
            var gSpuNo = $('#spu').val().split("-")[0];
            var skuId = $("#skuIds").val();
            if (skuId.substr(0, 1) == ',') {
                skuId = skuId.substr(1);
            }
            if (type) {
                $.ajax(
                    {
                        data: {
                            gGoodsId: $('#platformGoodId').val(),
                            gStatus: 0,
                            gSkuIds: skuId,
                            gId: $('#goodsId').val(),
                            gCategoryIds: $('#categoryIds').val(),
                            gBrandId: $('#gBrandId').val(),
                            gSpuName: gSpuName,
                            gSpuNo: gSpuNo,
                            gCategorySelf: $('#customCategory').val(),
                            gRecommend: $("input[name='gRecommend']:checked").val(),
                            gGroundingFlag: $("input[name='gGroundingFlag']:checked").val()
                        },
                        url: "<%=path%>/goodShop/saveOrUpdate",//提交连接
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
                                    window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                }, 1000);
                            } else {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("操作失败");
                            }
                        }//回调方法
                    });
            }
        })
        form.on('submit(submitGoods)', function (data) {
            if ($("#skuIds").val() == "") {
                layer.msg("请选择规格！");
                return false;
            }
            var i = 1;
            var flag=true
            $("input:checkbox[name='sscale']:checked").each(function() { // 遍历name=test的多选框
                var r = /^[0-9]*[1-9][0-9]*$/　　//正整数
                var p=/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/; //正数
                var gQuantity = $(this).parent().parent().find("td:eq(5)").find("input").val();
                var gStock =  $(this).parent().parent().find("td:eq(6)").find("input").val()
                var gPrice =  $(this).parent().parent().find("td:eq(4)").find("input").val()
                if(gQuantity==''||gStock==''||gPrice==''){
                    layer.msg("第" + i + "行规格参数不能为空！");
                    flag= false;
                } else if(!r.test(gQuantity)||!r.test(gStock)){
                    layer.msg("第" + i + "请输入正整数！");
                    flag= false;
                }else if(!p.test(gPrice)){
                    layer.msg("第" + i + "价格输入正数且小数位不超过2位！");
                    flag= false;
                }
                if (gQuantity != '' && gStock != '') {
                    if (parseInt(gQuantity) > parseInt(gStock)) {
                        layer.msg("第" + i + "行起订量不能大于库存！");
                        flag= false;
                    }
                }
                i++;
            });
            if(flag==false){
                return false;
            }
            if ($("input[name='gGroundingFlag']:checked").val() == "0") {
                layer.msg("提交申请上架状态必须为是！");
                return false;
            }
            var type = true;
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态\
            var gSpuName = $('#spu').val().split("-")[1];
            var gSpuNo = $('#spu').val().split("-")[0];
            var skuId = $("#skuIds").val();
            if (skuId.substr(0, 1) == ',') {
                skuId = skuId.substr(1);
            }
            if (type) {
                $.ajax(
                    {
                        data: {
                            gGoodsId: $('#platformGoodId').val(),
                            gStatus: 1,
                            gSkuIds: skuId,
                            gId: $('#goodsId').val(),
                            gCategoryIds: $('#categoryIds').val(),
                            gBrandId: $('#gBrandId').val(),
                            gSpuName: gSpuName,
                            gSpuNo: gSpuNo,
                            gCategorySelf: $('#customCategory').val(),
                            gRecommend: $("input[name='gRecommend']:checked").val(),
                            gGroundingFlag: $("input[name='gGroundingFlag']:checked").val()
                        },
                        url: "<%=path%>/goodShop/saveOrUpdate",//提交连接
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
                                     window.location.href = "<%=path%>/page/main/goodShop/index.jsp";
                                }, 1000);
                            } else {
                                post_flag = false; //在提交成功之后将标志标记为可提交状态
                                layer.msg("操作失败");
                            }
                        }//回调方法
                    });
            }

        })
    });

    function initFirstCategory() {
        $.ajax({
            url: "<%=path%>/category/getFistCategory",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.code == '0') {
                    if ($.isArray(result.categoryList)) {
                        var html = '<option value="">请选择</option>';
                        $.each(result.categoryList, function (index, val) {
                            html += '<option value="' + val.categoryId + '">' + val.categoryName + '</option>';
                        })
                        $("#firstCategory").html(html);
                    }
                    layui.form.render('select');
                } else {
                    $("#firstCategory").html(html);
                }
            }//回调方法
        });
    }

    function initCustomCategory() {
        $.ajax({
            url: "<%=path%>/customCategory/findCustomCategoryList",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    if ($.isArray(result.data)) {
                        var html = '<option value="">请选择</option>';
                        $.each(result.data, function (index, val) {
                            html += '<option value="' + val.customId + '">' + val.customName + '</option>';
                        })
                        $("#customCategory").html(html);
                    }
                    layui.form.render('select');
                } else {
                    $("#customCategory").html(html);
                }
            }//回调方法
        });
    }


    //获得分类
    function getChildren(parentId, Id) {
        $.ajax(
            {
                type: 'post',
                url: '<%=path%>/category/getNextCategory',
                dataType: 'json',
                data: {parentId: parentId},
                success: function (data) {
                    var list = '<option value="">请选择</option>';
                    $.each(data.categoryList, function (i, item) {
                        list += '<option value="' + item.categoryId + '">' + item.categoryName + '</option>';
                        $('#' + Id).html(list)
                    })
                    layui.form.render('select');
                }
            })
    }

    function getBrand(id) {
        //获取品牌数据
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

    function getSpuGoods(id) {
        //获取品牌数据
        $.ajax({
            data: {id: id},
            url: "<%=path%>/goods/findBrandGoods",//提交连接
            type: 'post',
            dataType: 'json',
            success: function (result) {
                if (result.flag == '1') {
                    if ($.isArray(result.goodsList)) {
                        var html = '<option value="">请选择</option>';
                        $.each(result.goodsList, function (index, val) {
                            html += '<option value="' + val.gId + '">' + val.gSpuNo + '-' + val.gSpuName + '</option>';
                        })
                        $("#spuNo").html(html);
                    }
                    layui.form.render('select');
                } else {
                    $("#spuNo").html(html);
                }
            }//回调方法
        });

    }


    //判断spu是否存在
    function checkSpu(name, id) {
        getGoodSku(id);
        //getGoodSku(id);
        /* var spuNo = name.split('-')[0];
         var spuName = name.split('-')[1];
         $.ajax({
             url: "


















        <%=path%>/goodShop/checkGoodsNumber",//提交连接
            type: 'post',
            dataType: 'json',
            async: false,
            data: {gSpuNo: spuNo, spuName: spuName},
            success: function (json) {
                if (json.flag == "1") {
                    layer.msg("SPU编号已经存在！")
                    $('#goodsNumberFlag').val("1")
                } else {
                    //获取商品sku
                    getGoodSku(id);
                    $('#goodsNumberFlag').val("0")
                }
            }
        });*/

    }

    function getGoodSku(id) {
        /* //最后重新加载一下就可以了
         layui.use('form', function(){
             var form = layui.form();
             //根据的type类型修改
             form.render('checkbox');
         });
         */

        $.ajax({
            url: "<%=path%>/goods/findEntity",//提交连接
            type: 'post',
            dataType: 'json',
            async: false,
            data: {id: id},
            success: function (json) {
                if (json.flag == "1") {
                    if (json.skuList != null) {
                        if ($.isArray(json.skuList)) {
                            $.each(json.skuList, function (index, val) {
                                $('#content').append(
                                    "<tr >" +
                                    "<td > <input  lay-filter='sscale' name='sscale' type='checkbox' value=" + val.gId + "></td>" +
                                    "<td > " + val.gColor + "</td>" +
                                    "<td >" + val.gSize + "</td>" +
                                    "<td >" + val.gNo + "</td>" +
                                    "<td ><input type='text'onchange='countService(this);'></td>" +
                                    "<td ><input type='text'></td>" +
                                    "<td ><input type='text'></td>" +
                                    "<td >0.7%</td>" +
                                    "<td ><span>0</span></td>" +
                                    "<input type='hidden'  class='gId' value=" + val.gId + " >" +
                                    "</tr>");
                            })

                        }
                        layui.form.render();
                    }
                } else {
                    //layer.msg("操作失败")

                }
            }
        });


    }

    function countService(obj) {
        var priceVal = $(obj).val();
        var rate = $(obj).parent().next().next().next().html();
        var priceRate = rate.split('%')[0];
        var b = accMul(priceVal, priceRate)
        $(obj).parent().next().next().next().next().html(accMul(b, 0.01));
    }

    //修改获取数据
    function getDate(goodsId) {
        initCustomCategory()
        $.ajax({
            url: "<%=path%>/goodShop/findEntity",//提交连接
            type: 'post',
            dataType: 'json',
            async: false,
            data: {id: goodsId},
            success: function (json) {
                if (json.flag == "1") {
                    $("#two").show();
                    $("#next").hide();
                    if (json.goods != null) {
                        $('#firstCategoryName').val(json.firstCategory);
                        $('#twoCategoryName').val(json.twoCategory);
                        $('#threeCategoryName').val(json.threeCategory);
                        $('#customCategory').val(json.goods.gCategorySelf);
                       // $("select[name=customCategory]").next().find("li[lay-value="+json.goods.gCategorySelf+"]").click();
                       // layer.select("customCategory").setValue(json.goods.gCategorySelf)
                        //$("#customCategory").find("option[text='1']").attr("selected",true);
                        $(":radio[name='gRecommend'][value='" + json.goods.gRecommend + "']").prop("checked", "checked");
                        $(":radio[name='gGroundingFlag'][value='" + json.goods.gGroundingFlag + "']").prop("checked", "checked");
                        // layer.select('').setValue(json.customName);
                        $('#skuIds').val(json.goods.gSkuIds);
                        if(typeof(json.goods.gOpinion)!="undefined"){
                            $('#opinion').html(json.goods.gOpinion);
                            $('#showStatus').show();
                        }

                        $('#gSpuName').val(json.goods.gSpuName + '-' + json.goods.gSpuNo);

                        //layui.form.render();
                    }
                    if (json.brandName != null) {
                        $("#brandName").val(json.brandName);

                    }

                    if (json.newList != null) {
                        if ($.isArray(json.newList)) {
                            $.each(json.newList, function (index, val) {
                                $('#content').append(
                                    $('#content').append(
                                        "<tr >" +
                                        "<td > <input  lay-filter='sscale' type='checkbox' value=" + val.gId + "></td>" +
                                        "<td > " + val.gColor + "</td>" +
                                        "<td >" + val.gSize + "</td>" +
                                        "<td >" + val.gNo + "</td>" +
                                        "<td ><input type='text'onchange='countService(this);'></td>" +
                                        "<td ><input type='text'></td>" +
                                        "<td ><input type='text'></td>" +
                                        "<td >0.7%</td>" +
                                        "<td ><span>0</span></td>" +
                                        "<input type='hidden'  class='gId' value=" + val.gId + " >" +
                                        "</tr>"));
                            })
                        }
                    }
                    if (json.skuList != null) {
                        if ($.isArray(json.skuList)) {
                            $.each(json.skuList, function (index, val) {
                                $('#content').append(
                                    "<tr >" +
                                    "<td > <input  lay-filter='sscale' name='sscale' type='checkbox'value=" + val.gSkuId + "><div class='layui-unselect layui-form-checkbox layui-form-checked' lay-skin='primary'><i class='layui-icon'></i></div></td>" +
                                    "<td >" + val.gColor + "</td>" +
                                    "<td >" + val.gSize + "</td>" +
                                    "<td >" + val.gSku + "</td>" +
                                    "<td ><input type='text'onchange='countService(this);' value= " + val.gPrice + "></td>" +
                                    "<td ><input type='text'  value= " + val.gQuantity + "></td>" +
                                    "<td ><input type='text'  value= " + val.gStock + "></td>" +
                                    "<td >" + val.gScale + "%</td>" +
                                    "<td >" + val.gService + "</td>" +
                                    "<input type='hidden'  class='gId' value=" + val.gSkuId + " >" +
                                    "</tr>");
                            })

                            $("input[name='sscale']").attr("checked","true");
                            layui.form.render();

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
                    url: "<%=path%>/goodShop/checkGoodsNumber",//提交连接
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

    //保存sku数据
    function SaveData() {
        $('#content tr ').each(function () {
            console.log($(this).length)
            var scale = $(this).find("td:eq(7)").html();
            var tag = '%';
            if (scale.indexOf(tag) != -1) {
                scale = scale.split('%')[0];
            }
            $.ajax({
                data: {
                    gGoodsId: $('#platformGoodId').val(),
                    gGid: $("#goodsId").val(),
                    gColor: $(this).find("td:eq(1)").html(),
                    gSize: $(this).find("td:eq(2)").html(),
                    gSku: $(this).find("td:eq(3)").html(),
                    gPrice: $(this).find("td:eq(4)").find("input").val(),
                    gQuantity: $(this).find("td:eq(5)").find("input").val(),
                    gStock: $(this).find("td:eq(6)").find("input").val(),
                    gScale: scale,
                    gService: $(this).find("td:eq(8)").html(),
                    gSkuId: $(this).find("input:last").val()
                },//提交的数据
                url: "<%=path%>/goodShopSku/saveOrUpdate",//提交连接
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
            }//回调方法    4000 6000 5000 3000
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