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
    <title>银行卡绑定</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"   content="width=device-width, initial-scale=1, maximum-scale=1">
   <link rel="stylesheet"
          href="<%=request.getContextPath()%>/page/static/plugins/layui/css/layui.css" media="all"/>
</head>
<body>
<div style="padding: 40px">

    <hr>
    <div class="layui-form layui-form-pane">
        <input type="hidden" name="phoneCode" id="phoneCode" value="">
        <div class="layui-form-item">
            <label class="layui-form-label">*持卡人姓名：</label>
            <div class="layui-input-inline">
                <input id="name" type="text" name="name" 
                       placeholder="请输入姓名"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*持卡人身份证号：</label>
            <div class="layui-input-inline">
                <input id="idNo" type="text" name="idNo" 
                       placeholder="请输入身份证号"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*绑定银行卡卡号：</label>
            <div class="layui-input-inline">
                <input id="bankCard" type="text" name="bankCard" 
                       placeholder="请输入银行卡卡号"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*开户行：</label>
            <div class="layui-input-inline">
                <input id="bankName" type="text" name="bankName" 
                       placeholder="请输入开户行"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*银行卡预留手机号：</label>
            <div class="layui-input-inline">
                <input id="mobile" type="text" name="mobile" 
                       placeholder="请输入银行卡预留手机号"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">*短信验证码：</label>
            <div class="layui-input-inline">
                <input id="verifyCode" type="text" name="verifyCode" 
                       placeholder=""
                       autocomplete="off" class="layui-input" value="">
            </div>
            <label class="layui-form-label" id="getVerifyCode">立即获取</label>
        </div>
    </div>
    <div class="layui-form-item" align="center">
        <button class="layui-btn" lay-filter="submitBankVerify" lay-submit lay-filter="demo1" id="submit">立即绑定</button>

    </div>
</div>

</div>

<script src="<%=request.getContextPath() %>/page/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath() %>/page/static/treeTable/layui.all.js"></script>
<script src="<%=request.getContextPath() %>/page/static/treeTable/layui.js"></script>

<script type="text/javascript">


    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        //提交
        var post_flag = false; //设置一个对象来控制是否进入AJAX过程
        form.on('submit(submitBankVerify)', function (data) {
            if (post_flag) return; //如果正在提交则直接返回，停止执行
            post_flag = true;//标记当前状态为正在提交状态
            var name = $('#name').val();
            var idNo = $('#idNo').val();
            var bankCard = $('#bankCard').val();
            var bankName = $('#bankName').val();
            var mobile = $('#mobile').val();
            var verifyCode = $('#verifyCode').val();

            $.ajax({
                data: {
                    name: name, idNo: idNo, bankCard: bankCard,
                    bankName: bankName, mobile: mobile, verifyCode: verifyCode
                },              
                url: "<%=path%>/account/bindBankCard",//提交连接
                type: 'post',
                dataType: 'json',
                success: function (result) {
                    post_flag = false; //在提交成功之后将标志标记为可提交状态
                    if (result.flag == '1') {
                        layer.msg("操作成功");
                        setTimeout(function () {
                          // window.location.href = "/sps-admin/category";
                        }, 1000);
                    } else {
                        post_flag = false; //在提交成功之后将标志标记为可提交状态
                        layer.msg("操作失败");
                    }
                }//回调方法
            });

        })
        $(document).on("click", "#getVerifyCode", function () {
            var mobile = $('#mobile').val();
            $.ajax({
                data: {mobile: mobile},
                url: "<%=path%>/account/getVerifyCode",//提交连接
                type: 'post',
                dataType: 'json',
                success: function (result) {
					//请求成功的话：$("#phoneCode").val(result.code);
					
                    post_flag = false; //在提交成功之后将标志标记为可提交状态
                    if (result.flag == '1') {
                        layer.msg("操作成功");
                        setTimeout(function () {
                          //  window.location.href = "/sps-admin/category";
                        }, 1000);
                    } else {
                        post_flag = false; //在提交成功之后将标志标记为可提交状态
                        layer.msg("操作失败");
                    }
                }//回调方法
            });
        })

	 //自定义验证规则
        form.verify({
            //验证只包含汉字
          /*   username: function (value) {
                var regex = /^[\u4e00-\u9fa5]+$/;
                if (!value.match(regex)) {
                    return '请输入正确的姓名';
                }
            }, */
            bankCardCheck: function (value) {
                var result= bankCardVerify(value);
				if(!result) return "请输入正确的银行卡号";
            },
            verifyPhoneCode: function (value) {
                if($("#verifyCode").val() != $("#phoneCode").val()){
					return "请输入正确的验证码";
				}
            }
        });
    }); 

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
		var luhn = 10 - k;s

		if (lastNum == luhn) {
			
			return true;
		} else {
			 
			return false;
		}
	} 

</script>
</body>
</html>