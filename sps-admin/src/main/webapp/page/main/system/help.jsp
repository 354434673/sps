<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>帮助与反馈录入信息页面</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/static/plugins/layui/css/layui.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
<h2><font color="GREEN"  style=" padding-left: 508px;">帮助与反馈录入信息</font></h2>
<div  style="padding: 40px;width: 1005px;border-left-width: 270px;margin-left: 417px;" >
    <div class="layui-form layui-form-pane"  >
        <div class="layui-form-item ">
            <label class="layui-form-label">*标题：</label>
            <div class="layui-input-inline">
                <input id="title" type="text" name="title"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" id="passwordDiv">
            <label class="layui-form-label">*内容：</label>
            <div class="layui-input-inline">
                <input id="content" name="content"   lay-verify="required"  placeholder="请输入内容" autocomplete="off" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item" align="left" style="padding-left: 104px;">
            <button class="layui-btn" lay-filter="submitBankVerify" lay-submit  id="submitBankVerify">提交</button>
        </div>
    </div>
</div>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>

<script type="text/javascript">
    var lock = true;
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer ;
        var form = layui.form();
        form.on('submit(submitBankVerify)', function (data) {
            if(!lock){    // 2.判断该锁是否打开，如果是关闭的，则直接返回
                return false;
            }
            lock = false;  //3.进来后，立马把锁锁住
            var title = $('#title').val().trim();
            var content = $('#content').val().trim();
            layer.msg('处理中...',
                    {
                        icon: 16,
                        shade: 0.01,
                        time:1200
                    },
                    function(){
                        $.ajax({
                            data: {tittle: title,content:content},
                            url: "<%=path%>/help/saveHelp",//绑定银行卡请求
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            success: function (result) {
                                    layer.msg(result.msg);

                            }
                        });
                    }
            );
        });
        lock = true;
    });
   </script>
</body>
</html>

