<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>银行卡绑定</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"   content="width=device-width, initial-scale=1, maximum-scale=1">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/page/static/plugins/layui/css/layui.css" media="all"/>
    <style type="text/css">
        * html label{
            float:none;display:inline;padding:5px 15px 10px 18px;margin-right:10px;vertical-align:middle;
        }
    </style>
</head>
<body>
<div style="padding: 40px;width: 600px;">

    <hr>
    <form class="layui-form layui-form-pane"  style="padding-left: 200px;padding-right: 300px;width: 800px;">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">姓名 </label>
            <div class="layui-input-inline">
                <input id="userName" type="text" name="userName"  value=""
                       placeholder="请输入持卡人姓名"
                       autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">身份证号 </label>
            <div class="layui-input-inline">
                <input id="idNo" type="text" name="identity"  value=""
                       placeholder="请输入身份证号"
                       autocomplete="off" class="layui-input" lay-verify="required|identity">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">银行卡号 </label>
            <div class="layui-input-inline">
                <input id="bankCard" type="text" name="accounts"  value=""
                       placeholder="请输入银行卡卡号"
                       autocomplete="off" class="layui-input" lay-verify="required|number|bankCardCheck">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">开户行 </label>
            <div class="layui-input-inline">
                <input id="bankName" type="text" name="bank"  value=""
                       placeholder="请输入开户行"
                       autocomplete="off" class="layui-input"  lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 130px;">手机号 </label>
            <div class="layui-input-inline">
                <input id="mobile" type="tel" name="phone" value=""
                       placeholder="请输入银行卡预留手机号"
                       autocomplete="off" class="layui-input" lay-verify="required|phone" >
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 136px;">短信验证码：</label>

            <div class="layui-input-block" >
                <input id="tradePwd" style="width: 187px;text-align: center;display: inline;"   value=""  autocomplete="off" class="layui-input"    lay-verify="required">
                <button   style="color:red;" id="findSms">立即获取?</button>

            </div>
        </div>
        <div class="layui-form-item" align="left" style="padding-left: 104px;">
           <button class="layui-btn" lay-filter="submitBankVerify" lay-submit  id="submitBankVerify">立即绑定</button>
        </div>
    </form>
    
</div>


<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script language="JavaScript"   src="<%=request.getContextPath() %>/page/static/plugins/layui/lay/dest/layui.all.js"></script>
<script language="JavaScript"  src="<%=request.getContextPath() %>/page/static/plugins/layui/layui.js"></script>


<script type="text/javascript">
    var timer ;
    var lock = true;
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer ;
        var form = layui.form();
        //自定义验证规则
        form.verify({
            bankCardCheck: function (value) {
                var result= bankCardVerify(value);
                if(!result) return "请输入正确的银行卡号";
            }
        });
        form.on('submit(submitBankVerify)', function (data) {
            if(!lock){    // 2.判断该锁是否打开，如果是关闭的，则直接返回
                return false;
            }
            lock = false;  //3.进来后，立马把锁锁住
            var name = $('#userName').val().trim();
            var idNo = $('#idNo').val().trim();
            var bankCard = $('#bankCard').val().trim();
            var bankName = $('#bankName').val().trim();
            var mobile = $('#mobile').val().trim();
            layer.msg('处理中...',
                {
                    icon: 16,
                    shade: 0.01,
                    time:1200
                },
                function(){
                    $.ajax({
                        data: {
                            name: name, identity: idNo, accounts: bankCard,
                            bank: bankName, phone: mobile
                        },
                        url: "<%=path%>/yopBingCard/bindBankCard",//绑定银行卡请求
                        type: 'post',
                        dataType: 'json',
                        async: false,
                        success: function (result) {
                            console.log(result);
                            var code =result.code;
                            var ok = result.ok;
                            var  msg = result.msg;
                            if(code == ok){
                                var resendCount = 0;
                                smsConfirm(layer,result,resendCount);
                            }
                            if(code == result.fail){
                                layer.msg(msg);
                                window.location.href="<%=path%>/page/main/account/bankCard/unbindBankCard.jsp";
                            }
                        }
                    });
                }
            );

            return false;
        });
        lock = true;
    });
    $("#findSms").on("click",function(){
        var mobile = $('#mobile').val().trim();
        //发送ajax请求
        $.ajax({
            data: {phone:mobile},
            url: "%=path%/bankCard/getVerifyCode",//确认请求
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (res) {
                alert(res.result);
                if(res.result){
                    layer.msg('获取验证码成功', {
                        icon: 2,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                }

            }
        });

    });
    //短信验证码确认请求
    function smsConfirm(layer,result,resendCount){
        layer.prompt(
                {
                    title: '请输入短信验证码，并确认',
                    formType: 0, //prompt风格，支持0-2
                    btn2: function(){//点击取消按钮时，执行如下操作
                        window.clearTimeout(timer);
                        lock =true;
                        return;
                    },
                    cancel: function(){//点击关闭按钮时，执行如下操作
                        window.clearTimeout(timer);
                        lock =true;
                        return;
                    }
                },
                function(value, index, elem){
                    layer.msg('绑卡成功', {
                        icon: 2,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                    window.location.href = "<%=path%>/page/main/account/bankCard/bankCardDetail.jsp";
                   /* var reg = new RegExp("^[0-9]{6}$");
                    if(!reg.test(value)){
                        layer.msg('请输入六位数字的短信验证码', {
                            icon: 2,
                            time: 1000 //2秒关闭（如果不配置，默认是3秒）
                        });
                    }
                    if(reg.test(value)){
                        console.log(result);
                        layer.close(index);
                        //发短信验证码确认情求
                        $.ajax({
                            data: {validatecode:value.trim(),requestno:result.body.requestno,yborderid:result.body.yborderid},
                            url: "%=path%/bankCard/confirm",//确认请求
                            type: 'post',
                            dataType: 'json',
                            async: false,
                            success: function (res) {
                                console.log(res);
                                if(res.code == res.ok){
                                    if(res.body.code == 1){ //绑卡成功
                                        layer.msg(res.msg,
                                                {
                                                    icon: 16,
                                                    shade: 0.01,
                                                    time:1000
                                                },function(){//关闭时，执行
                                                    //跳转至详情页
                                                });

                                        return ;
                                    }
                                    if(res.body.code == 2){
                                        //重发短信请求
                                        resend(layer,res,resendCount);
                                    }

                                }
                                if(res.code == res.fail){
                                    window.clearTimeout(timer);
                                    layer.msg(msg);
                                    return ;
                                }

                            }
                        });
                    }*/
                }
        );
    }

    //最多发三次短信验证码
    function resend(layer,res,resendCount){
        var continueFlag = true;
        resendCount++;
        if(resendCount > 3) {
            continueFlag = confirmFrame('已超过次数，请重新操作',layer,continueFlag);
            //重新加载页面
            //window.location.reload();
            return ;
        }
        if(resendCount <= 3){
            continueFlag = confirmFrame('短信验证码错误，需要重发短信验证码吗？',layer,continueFlag);
            if(continueFlag){
                timer = window.setTimeout(function(){
                    $.ajax({
                        data: {requestno:res.body.requestno,yborderid:res.body.yborderid},
                        url: "<%=path%>/bankCard/resend",
                        type: 'post',
                        dataType: 'json',
                        async: false,
                        success: function (result) {
                            console.log(result);
                            var code =result.code;
                            var ok = result.ok;
                            var  msg = result.msg;
                            layer.msg(msg);
                            if(code == ok){
                                smsConfirm(layer,result,resendCount);
                            }
                            return ;

                        }
                    });
                },5000);
            }
        }
    }
    //确认框操作
    function confirmFrame(text,layer,continueFlag){
        layer.confirm(text,
                {
                    icon: 1,
                    title: '温馨提示' ,
                    btn:['确定','取消'],
                    btn2:function () {//若点击取消，则执行
                        window.clearTimeout(timer);
                        lock = true;
                        continueFlag = false;
                        return ;
                    },
                    cancel:function () {//若点击右上角x按钮，则执行
                        window.clearTimeout(timer);
                        lock = true;
                        continueFlag = false;
                        return ;
                    }
                },
                function (index) {//若点击确定,则执行
                    layer.close(index);
                    lock = true;

                }
        );
        return continueFlag;
    }
	//银行卡号码检测
	 function bankCardVerify(bankno) {
		var lastNum = bankno.substr(bankno.length - 1, 1); //取出最后一位（与luhn进行比较）
		var first15Num = bankno.substr(0, bankno.length - 1); //前15或18位
		var newArr = new Array();
		for (var i = first15Num.length - 1; i > -1; i--) { //前15或18位倒序存进数组
			newArr.push(first15Num.substr(i, 1));
		}
		var arrJiShu = new Array(); //奇数位*2的积 <9
		var arrJiShu2 = new Array(); //奇数位*2的积 >9
		var arrOuShu = new Array(); //偶数位数组
		for (var j = 0; j < newArr.length; j++) {
			if ((j + 1) % 2 == 1) { //奇数位
				if (parseInt(newArr[j]) * 2 < 9) arrJiShu.push(parseInt(newArr[j]) * 2);
				else arrJiShu2.push(parseInt(newArr[j]) * 2);
			} else //偶数位
			arrOuShu.push(newArr[j]);
		}

		var jishu_child1 = new Array(); //奇数位*2 >9 的分割之后的数组个位数
		var jishu_child2 = new Array(); //奇数位*2 >9 的分割之后的数组十位数
		for (var h = 0; h < arrJiShu2.length; h++) {
			jishu_child1.push(parseInt(arrJiShu2[h]) % 10);
			jishu_child2.push(parseInt(arrJiShu2[h]) / 10);
		}

		var sumJiShu = 0; //奇数位*2 < 9 的数组之和
		var sumOuShu = 0; //偶数位数组之和
		var sumJiShuChild1 = 0; //奇数位*2 >9 的分割之后的数组个位数之和
		var sumJiShuChild2 = 0; //奇数位*2 >9 的分割之后的数组十位数之和
		var sumTotal = 0;
		for (var m = 0; m < arrJiShu.length; m++) {
			sumJiShu = sumJiShu + parseInt(arrJiShu[m]);
		}

		for (var n = 0; n < arrOuShu.length; n++) {
			sumOuShu = sumOuShu + parseInt(arrOuShu[n]);
		}

		for (var p = 0; p < jishu_child1.length; p++) {
			sumJiShuChild1 = sumJiShuChild1 + parseInt(jishu_child1[p]);
			sumJiShuChild2 = sumJiShuChild2 + parseInt(jishu_child2[p]);
		}
		//计算总和
		sumTotal = parseInt(sumJiShu) + parseInt(sumOuShu) + parseInt(sumJiShuChild1) + parseInt(sumJiShuChild2);

		//计算luhn值
		var k = parseInt(sumTotal) % 10 == 0 ? 10 : parseInt(sumTotal) % 10;
		var luhn = 10 - k;

		if (lastNum == luhn) {
			
			return true;
		} else {
			 
			return false;
		}
	} 

</script>
</body>
</html>