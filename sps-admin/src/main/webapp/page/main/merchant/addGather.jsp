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
<title>收款信息添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
</style>
</head>
<body>
<div style="padding-left:5%;padding-top: 30px">
	<div class="layui-form layui-form-pane" >
		<div class="layui-row layui-col-space10" >
			<div class="layui-col-md12 " >
				  <div class="layui-form-item">
				    <label class="layui-form-label" style="width: 150px">收款银行卡账号：</label>
				    <div class="layui-input-inline">
				      <input id="gatherBankId" type="text" name="gatherBankId"  lay-verify="required|IsBank|haveBank" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				    <div class="layui-form-mid layui-word-aux" >
				    <font color="red">
				    	注：请添加企业主要走账流水银行卡
				    </font>
				    </div>
				  </div>
		    </div>
			<div class="layui-col-md12 " >
				  <div class="layui-form-item">
				    <label class="layui-form-label" style="width: 150px">*所有人姓名：</label>
				    <div class="layui-input-inline">
				      <input id="gatherOwnerName" type="text" name="gatherOwnerName"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				    <label class="layui-form-label" style="width: 150px">*身份证号：</label>
				    <div class="layui-input-inline">
				      <input id="gatherIdcard" type="text" name="gatherIdcard"  lay-verify="required|IsIDCard" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				  </div>
		    </div>
			<div class="layui-col-md12 " >
				  <div class="layui-form-item">
				    <label class="layui-form-label" style="width: 150px">*银行卡绑定手机号：</label>
				    <div class="layui-input-inline">
				      <input id="gatherPhone" type="text" name="gatherPhone"  lay-verify="required|phone" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				    <label class="layui-form-label" style="width: 150px">*开户银行：</label>
				    <div class="layui-input-inline">
				      <input id="gatherDepositBank" type="text" name="gatherDepositBank"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				  </div>
		    </div>
			<div class="layui-col-md12 " >
				  <div class="layui-form-item">
				    <label class="layui-form-label" style="width: 150px">*开户行分行：</label>
				    <div class="layui-input-inline">
				      <input id="gatherBankBranch" type="text" name="gatherBankBranch"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				    <label class="layui-form-label" style="width: 150px">*开户行支行：</label>
				    <div class="layui-input-inline">
				      <input id="gatherBankSubbranch" type="text" name="gatherBankSubbranch"  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
				    </div>
				  </div>
		    </div>
		</div>
		<!-- 按钮 -->
    		 <div class="layui-form-item" align="center" id="btn" style="padding-top: 10px" >
				<button class="layui-btn layui-btn-primary">取消</button>
				<button class="layui-btn layui-btn-primary" lay-filter="insertGather" id="insertGather" lay-submit>保存</button>
				<!-- <button class="layui-btn layui-btn-primary" lay-filter="insertGather" id="test" >aaa</button> -->
			</div>
	</div>
</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
<script type="text/javascript">
	  var gatherListJson = []
	layui.use(['form','table','element','layer'], function(){
	  var form = layui.form;
	  var $ = layui.jquery;
	  var element = layui.element;
	  var layer = layui.layer;
	  var index = 1;
	  var add = false;
  	  $('#test').on('click',function(){
			 var gatherBankId = $('#gatherBankId').val()
			 var gatherOwnerName = $('#gatherOwnerName').val()
			 var gatherPhone = $('#gatherPhone').val()
			 var gatherIdcard = $('#gatherIdcard').val()
			 var gatherDepositBank = $('#gatherDepositBank').val()
			 var gatherBankBranch = $('#gatherBankBranch').val()
			 var gatherBankSubbranch = $('#gatherBankSubbranch').val()
			 gatherListJson.push({
				 gatherId:index++,
				 gatherBankId:gatherBankId,
				 gatherOwnerName:gatherOwnerName,
				 gatherPhone:gatherPhone,
				 gatherIdcard:gatherIdcard,
				 gatherDepositBank:gatherDepositBank,
				 gatherBankBranch:gatherBankBranch,
				 gatherBankSubbranch:gatherBankSubbranch,
				 })
				$('input').val('')
				console.log(gatherListJson)
	  })  
	   
	  $('#gatherBankId').blur(function(){
		  var gatherBankId = $('#gatherBankId').val()
		    $.ajax({
				url:'<%=path%>/merchant/queryGather',
				data:{gatherBankId:gatherBankId},
				success:function(result){
					if(eval(result) == 'exist'){
						add = false;
						layer.msg("该银行卡已添加",{icon: 2})
					}else{
						add = true;
					}
				}
			})  
	  })
	  	  form.on('submit(insertGather)', function(data){
	  		  if(add){
				 var gatherBankId = $('#gatherBankId').val()
				 var gatherOwnerName = $('#gatherOwnerName').val()
				 var gatherPhone = $('#gatherPhone').val()
				 var gatherIdcard = $('#gatherIdcard').val()
				 var gatherDepositBank = $('#gatherDepositBank').val()
				 var gatherBankBranch = $('#gatherBankBranch').val()
				 var gatherBankSubbranch = $('#gatherBankSubbranch').val()
				 gatherListJson.push({
					 gatherId:index++,
					 gatherBankId:gatherBankId,
					 gatherOwnerName:gatherOwnerName,
					 gatherPhone:gatherPhone,
					 gatherIdcard:gatherIdcard,
					 gatherDepositBank:gatherDepositBank,
					 gatherBankBranch:gatherBankBranch,
					 gatherBankSubbranch:gatherBankSubbranch,
					 })
			      $('input').val('')
	  		  }else{
	  			layer.msg("该银行卡已添加",{icon: 2})
	  		  }
		  })  
	  //自定义验证规则  
	  form.verify({  
			//验证只包含汉字  
			IsChineseCharacter: function(value) {
				var regex = /^[\u4e00-\u9fa5]+$/;
				if(!value.match(regex)) {
					return '请输入正确的姓名';
				}
			},
			IsBank: function(value) {
				var regex = /^([1-9]{1})(\d{18})$/;
				if(!value.match(regex)) {
					return '请输入正确的银行卡';
				}
			},
			minLength: function(value) {
				if(value.length<6) {
					return '最少为6位';
				}
			},
			IsIDCard: function(input) {
				input = input.toUpperCase();
				//验证身份证号码格式 [一代身份证号码为15位的数字；二代身份证号码为18位的数字或17位的数字加字母X]  
				if(!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/i.test(input))) {
					return '请输入正确的身份证';
				}
				//验证省份  
				var arrCity = {
					11: '北京',
					12: '天津',
					13: '河北',
					14: '山西',
					15: '内蒙古',
					21: '辽宁',
					22: '吉林',
					23: '黑龙江 ',
					31: '上海',
					32: '江苏',
					33: '浙江',
					34: '安徽',
					35: '福建',
					36: '江西',
					37: '山东',
					41: '河南',
					42: '湖北',
					43: '湖南',
					44: '广东',
					45: '广西',
					46: '海南',
					50: '重庆',
					51: '四川',
					52: '贵州',
					53: '云南',
					54: '西藏',
					61: '陕西',
					62: '甘肃',
					63: '青海',
					64: '宁夏',
					65: '新疆',
					71: '台湾',
					81: '香港',
					82: '澳门',
					91: '国外'
				};
				if(arrCity[parseInt(input.substr(0, 2))] == null) {
					return '请输入正确的身份证';
				}
				//验证出生日期  
				var regBirth, birthSplit, birth;
				var len = input.length;
				if(len == 15) {
					regBirth = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
					birthSplit = input.match(regBirth);
					birth = new Date('19' + birthSplit[2] + '/' + birthSplit[3] + '/' + birthSplit[4]);
					if(!(birth.getYear() == Number(birthSplit[2]) && (birth.getMonth() + 1) == Number(birthSplit[3]) && birth.getDate() == Number(birthSplit[4]))) {
						console.log('3')
						return '请输入正确的身份证';
					}
					return false;
				} else if(len == 18) {
					regBirth = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/i);
					birthSplit = input.match(regBirth);
					birth = new Date(birthSplit[2] + '/' + birthSplit[3] + '/' + birthSplit[4]);
					if(!(birth.getFullYear() == Number(birthSplit[2]) && (birth.getMonth() + 1) == Number(birthSplit[3]) && birth.getDate() == Number(birthSplit[4]))) {
						console.log('4')
						return '请输入正确的身份证';
					}
					//验证校验码  
					var valnum;
					var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
					var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
					var nTemp = 0,
						i;
					for(i = 0; i < 17; i++) {
						nTemp += input.substr(i, 1) * arrInt[i];
					}
					valnum = arrCh[nTemp % 11];
					if(valnum != input.substr(17, 1)) {
						console.log('5')
						return '请输入正确的身份证';
					}
					return false;
				}
				return '请输入正确的身份证';
			}
	  });  
	});
</script>
</body>
</html>