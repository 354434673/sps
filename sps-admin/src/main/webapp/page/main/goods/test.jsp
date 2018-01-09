
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
    <title>jquery表格操作</title>
    <script src="<%=path%>/page/static/js/jquery-1.10.2.min.js"></script>
    <script language="javascript" src="jquery.table.tr.js"></script>
    <style type="text/css">
        table
        {
            border: black solid 1px;
            border-collapse: collapse;
        }
        td
        {
            border: black solid 1px;
            padding: 3px;
        }
        .td_Num
        {
            width: 60px;
            text-align: center;
        }
        .td_Item
        {
            width: 160px;
            text-align: center;
        }
        .td_Oper
        {
            width: 120px;
            text-align: center;
        }
        .td_Oper span
        {
            cursor: pointer;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td class='td_Num'>
            序号
        </td>
        <td class='td_Item'>
            步骤名称
        </td>
        <td class='td_Item'>
            步骤描述
        </td>
        <td class='td_Oper'>
            相关操作 <a href="#" onclick="add_line();">添加</a>
        </td>
    </tr>
</table>
<table id="content">
</table>
<input type="button" value="提交数据" id="btnSubmit" onclick="SaveData()" />
</body>
</html>
<script type="text/javascript">
    var currentStep = 0;
    var max_line_num = 0;
    //添加新记录
    function add_line() {
        max_line_num = $("#content tr:last-child").children("td").html();
        if (max_line_num == null) {
            max_line_num = 1;
        }
        else {
            max_line_num = parseInt(max_line_num);
            max_line_num += 1;
        }
        $('#content').append(
            "<tr id='line" + max_line_num + "'>" +
            "<td class='td_Num'>" + max_line_num + "</td>" +
            "<td class='td_Item'><input type='text' class='stepName' value=''></input></td>" +
            "<td class='td_Item'><input type='text' class='stepDescription' value=''></td>" +
            "<td class='td_Oper'>" +
            "<span onclick='remove_line(this);'>删除</span> " +
            "</td>" +
            "</tr>");
    }
    //删除选择记录
    function remove_line(index) {
        if (index != null) {
            currentStep = $(index).parent().parent().find("td:first-child").html();
        }
        if (currentStep == 0) {
            alert('请选择一项!');
            return false;
        }
        if (confirm("确定要删除改记录吗？")) {
            $("#content tr").each(function () {
                var seq = parseInt($(this).children("td").html());
                if (seq == currentStep) { $(this).remove(); }
                if (seq > currentStep) { $(this).children("td").each(function (i) { if (i == 0) $(this).html(seq - 1); }); }
            });
        }
    }
    /*//上移
    function up_exchange_line(index) {
        if (index != null) {
            currentStep = $(index).parent().parent().find("td:first-child").html();
        }
        if (currentStep == 0) {
            alert('请选择一项!');
            return false;
        }
        if (currentStep <= 1) {
            alert('已经是最顶项了!');
            return false;
        }
        var upStep = currentStep - 1;
        //修改序号
        $('#line' + upStep + " td:first-child").html(currentStep);
        $('#line' + currentStep + " td:first-child").html(upStep);
        //取得两行的内容
        var upContent = $('#line' + upStep).html();
        var currentContent = $('#line' + currentStep).html();
        $('#line' + upStep).html(currentContent);
        //交换当前行与上一行内容
        $('#line' + currentStep).html(upContent);
        $('#content tr').each(function () { $(this).css("background-color", "#ffffff"); });
        $('#line' + upStep).css("background-color", "yellow");
        event.stopPropagation(); //阻止事件冒泡
    }
    //下移
    function down_exchange_line(index) {
        if (index != null) {
            currentStep = $(index).parent().parent().find("td:first-child").html();
        }
        if (currentStep == 0) {
            alert('请选择一项!');
            return false;
        }
        if (currentStep >= max_line_num) {
            alert('已经是最后一项了!');
            return false;
        }
        var nextStep = parseInt(currentStep) + 1;
        //修改序号
        $('#line' + nextStep + " td:first-child").html(currentStep);
        $('#line' + currentStep + " td:first-child").html(nextStep);
        //取得两行的内容
        var nextContent = $('#line' + nextStep).html();
        var currentContent = $('#line' + currentStep).html();
        //交换当前行与上一行内容
        $('#line' + nextStep).html(currentContent);
        $('#line' + currentStep).html(nextContent);
        $('#content tr').each(function () { $(this).css("background-color", "#ffffff"); });
        $('#line' + nextStep).css("background-color", "yellow");
        event.stopPropagation(); //阻止事件冒泡
    }*/
    //保存数据
    function SaveData() {
        var data = "<root>";
        $('#content tr').each(function () {
            data += "<item>";
            var stepName = $(this).find("td:eq(1)").find("input").val();
            var stepDescription = $(this).find("td:eq(2)").find("input").val();
            data += "   <stepName>" + stepName + "</stepName>";
            data += "   <stepDescription>" + stepDescription + "</stepDescription>";
            data += "<item>";
        });
        data += "</root>";
        alert(data);
    }
</script>