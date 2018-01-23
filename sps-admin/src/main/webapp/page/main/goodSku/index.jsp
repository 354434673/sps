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
    <title>商品信息管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all"/>
    <style type="text/css">
    </style>
</head>
<body>
<div style="margin: 15px;">
    <div class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <label class="layui-form-label">SPU编号:</label>
            <div class="layui-input-inline">
                <input id="spuNo" type="text" name="goodsNo" lay-verify="" placeholder="请输入SPU编号" autocomplete="off"
                       class="layui-input">
            </div>
            <label class="layui-form-label">商品名称:</label>
            <div class="layui-input-inline">
                <input id="goodsName" type="text" name="goodsName" lay-verify="" placeholder="请输入商品名称"
                       autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">规格:</label>
            <div class="layui-input-inline">
                <input id="size" type="text" name="spec" lay-verify="" placeholder="请输入尺寸或颜色" autocomplete="off"
                       class="layui-input">
            </div>
            <button class="layui-btn layui-btn-primary" id="queryGoods">查询</button>
            <button class="layui-btn layui-btn-primary" id="resetGoods">重置</button>
        </div>
    </div>
    <div>
        <button class="layui-btn" id="submit" data-type="getCheckData">
            提交
        </button>
    </div>
    <table id="goodList" lay-filter="goodList"></table>
</div>
<div id="div" style="   padding-top: 40px;padding-left: 45px;"> <input type="radio" name="gType" value="1" checked>按比例
    <input type="radio" name="gType" value="0"  >按金额</div>
<script type="text/html" id="date">
    {{#
    var da = d.gUpdateTime;
    da = new Date(da);
    var year = da.getFullYear();
    var month = da.getMonth()+1;
    var date = da.getDate();
    var hours= da.getHours();
    var minutes= da.getMinutes();
    var seconds= da.getSeconds();
    console.log([year,month,date,hours,minutes,seconds].join('-'));
    var fn = function(){
    return [year,month,date].join('-');
    };
    }}
    {{ fn() }}
</script>
<%--<script type="text/html" id="switchTpl">
    <input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="按金額|按比例" lay-filter="sexDemo" {{ d.id == 10003 ? 'checked' : '' }}>
</script>--%>
<script type="text/javascript"
        src="<%=path%>/page/layui/layui.all.js"></script>
<script>
    layui.use(['table', 'laypage', 'laydate', 'layer'], function () {
        var table = layui.table;
        var laypage = layui.laypage;
        var layer = layui.layer
        var laydate = layui.laydate;
        var $ = layui.jquery




        //加载日期框
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        table.render({
            elem: '#goodList'
            , height: 350
            , url: '<%=path%>/goodSku/goodSkuList' //数据接口
            , id: 'gId'
            , page: true
            , cols: [[ //表头
                {type:'numbers'}
                , {field: 'gNo', title: 'SPU编号', width: 150, align: 'center'}
                , {field: 'supName', title: '商品名称', width: 150, align: 'center'}
                , {field: 'gSize', title: '尺寸', align: 'center', width: 150}
                , {field: 'gColor', title: '颜色', align: 'center', width: 150}
                , {field: 'gPrice', title: '基准价', width: 150, align: 'center',edit: 'text',event: 'setPrice', style:'cursor: pointer;' }
              /*  ,{field:'gType', title:'波动方式', width:185, templet: '#switchTpl', unresize: true}*/
                , {field: 'gType', title: '波动方式', width: 150, align: 'center',event: 'setType', style:'cursor: pointer;' }
                , {field: 'gScale', title: '波动值', width: 150, align: 'center',edit: 'text',event: 'setStock', style:'cursor: pointer;'},
                {field: 'gScale', title: '波动区间', width: 230, align: 'center'}
                , {field: 'gUpdateTime', templet: '#date', title: '最后修改时间', width: 230, align: 'center'}
            ]], done: function (res, page, count) {
                $("[data-field='gType']").children().each(function () {
                    if ($(this).text() == '0') {
                        $(this).text("按金额")
                    } else if ($(this).text() == '1') {
                        $(this).text("按比例")
                    }
                })
              /*  $("[data-field='gColor']").css('display','none');
                $("[data-field='gSize']").css('display','none');*/
                /*$("[data-field='spec']").children().each(function () {
                        $(this).text($(this).parents().find(".layui-table-cell laytable-cell-1-gSize").text()+$(this).parents().find(".layui-table-cell laytable-cell-1-gColor").text())
                })*/
            }
        });
        //监听单元格事件
        table.on('tool(goodList)', function(obj){
            var data = obj.data;
            /*if(obj.event === 'setType'){
                layer.open({
                    type: 1,
                    area: ['340px', '150px'],
                    shade: false,
                    title: '修改商品名为 ['+ data.supName +'] 的波动方式',
                    skin: 'yourclass',
                    content: $('#div'),
                    value: data.gType
                });*/
                layer.prompt({
                    formType: 1
                    ,title: '修改商品名为 ['+ data.supName +'] 的波动方式'
                    ,value: data.sign
                }, function(value, index){
                    layer.close(index);

                    //这里一般是发送修改的Ajax请求

                    //同步更新表格和缓存对应的值
                    obj.update({
                        sign: value
                    });
                });
        });



        //查询
        $('#queryGoods').on('click', function () {
            var spuNo = $('#spuNo').val();
            var goodsName = $('#goodsName').val();
            var size = $('#size').val();
            table.reload('gId', {
                where: {spuNo: spuNo, goodsName: goodsName, size: size}
            });
        })
        //重置
        $('#resetGoods').on('click', function () {
            $('#goodsName').val('')
            $('#skuNo').val('')
        });
        $("#submit").click(function(){
            var goods = table.cache.gId;
            $.ajax({
                type:'POST',
                url:"<%=path%>/goodSku/updatePrice",
                dataType:"json",
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(goods),
                success:function(data){
                    if(data.state == 'success'){
                        layer.msg(data.msg,{icon: 1});
                    }else{
                        layer.msg('修改失败',{icon: 2});
                    }
                },
                error:function(request){
                    layer.msg('系统异常',{icon: 2});
                }
            });
        });

        /*  table.on('tool(goodsList)',function(obj){
              var data = obj.data;
              if(obj.event == 'setPrice'){
                  layer.prompt({
                      formType: 2
                      ,title: '修改价格'
                      ,value: data.price
                  }, function(value, index){
                      layer.close(index);
                      var aaa= value*data.amount;
                      //这里一般是发送修改的Ajax请求
                      //console.log(aaa);
                      //同步更新表格和缓存对应的值
                      obj.update({
                          price:value,
                          summation: aaa
                      });
                  });
              }
              if(obj.event == 'setStock'){
                  layer.prompt({
                      formType: 2
                      ,title: '修改库存'
                      ,value: data.amount
                  }, function(value, index){
                      layer.close(index);
                      var aaa= data.price*value;
                      //这里一般是发送修改的Ajax请求
                      //同步更新表格和缓存对应的值
                      obj.update({
                          amount:value,
                          summation: aaa
                      });
                  });
              }

          });*/
    });
</script>
</body>
</html>