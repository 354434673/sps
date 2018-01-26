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
<title>用户添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
	.layui-form-label{
		width: 150px
	}
</style>
</head>
<body>
<div class="layui-tab layui-tab-brie" lay-filter ="tab" style="padding:10px;" >
  <ul class="layui-tab-title">
    <li lay-id="channelInfo" class="layui-this">基本信息</li>
    <li lay-id="picInfo" id="picInfo" >图片资料</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
	<div class="layui-form " >
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>店主信息</legend>
		</fieldset>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*城市：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123</div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*客户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*城市：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*客户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10" >
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*店付业务员姓名：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*店付业务员身份证号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*业务类型：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*客户来源：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class=layui-col-md3>
			      	<label class="layui-form-label" >*默认核心商户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*默认核心商户名称：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			 </div>
			  <table id="gatherList" lay-filter="gatherTables"></table>
		<!-- 个人信息开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>个人信息</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*城市：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123</div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*客户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*城市：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*客户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10" >
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*店付业务员姓名：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*店付业务员身份证号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >*业务类型：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*客户来源：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class=layui-col-md3>
			      	<label class="layui-form-label" >*默认核心商户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >*默认核心商户名称：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">123123 </div>
				    </div>
			    </div>
			 </div>
		
	</div>
    </div>
    <!-- 额度信息开始 -->
    <div class="layui-tab-item">
    	<table id="gatherList" lay-filter="gatherTables"></table>
    </div>
  </div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
</script>
<script type="text/javascript">
	  var a = <%=request.getParameter("orderid")%>
	  var channelNum ;//外键,很多地方能用到
	  var businessProductArray = [];//主营业务数组,设为全局变量
	layui.use(['form','table','laydate','flow','element','upload'], function(){
	  var element = layui.element;
	  var form = layui.form;
	  var $ = layui.jquery;
	  var table = layui.table;
	  var laydate = layui.laydate;
	  var flow = layui.flow;
	  var upload = layui.upload;
	  var businessTypeArray = [];//主营商品类型数组
	  var businessBrandArray = [];//主营品牌数组
	  var logisticsWay = [];//发货方式
	  var openApplyProduct = ['0'];//适用产品
	  var gatherListJson = null;
	  getProvince(100000)//先加载省
	  getSalesman();
	  form.render(); 
	  //选择城市
	  form.on('select(province)', function(data){//选省
		  getCity(data.value,'city')
		  $('#area').html('')
	  });    
	  form.on('select(city)', function(data){//选省
		  getArea(data.value,'area')
	  });    
	  //公司注册地址
	  form.on('select(registerProvince)', function(data){//选省
		  getCity(data.value,'registerCity')
		  $('#registerArea').html('')
	  });    
	  form.on('select(registerCity)', function(data){//选省
		  getArea(data.value,'registerArea')
	  });   
	  //公司实际地址
	  form.on('select(realProvince)', function(data){//选省
		  getCity(data.value,'realCity')
		  $('#realArea').html('')
	  });    
	  form.on('select(realCity)', function(data){//选省
		  getArea(data.value,'realArea')
	  });  
	  form.on('select(channelSalesmanName)', function(data){//选省
		  $('#channelSalesmanNum').val(data.value)
	  });  
	  //加载日期框
	  laydate.render({
		    elem: '#startTime'
		  });
	  laydate.render({
		    elem: '#endTime'
		  });
	  form.on('checkbox(businessProduct)', function(data){
 		  if(data.elem.checked){
			  businessProductArray.push(data.value)
		  }else{
			//防止多次添加同一个元素,很鸡肋的,其实在后台控制也可以
			for(var i=0; i<businessProductArray.length; i++) {
				if(businessProductArray[i] == data.value){
					businessProductArray.splice(i, 1);
					break;
				}
			}
		  } 
		}); 	
	  form.on('checkbox(businessType)', function(data){
		  if(data.elem.checked){
			  businessTypeArray.push(data.value)
		  }else{
			//防止多次添加同一个元素,很鸡肋的,其实在后台控制也可以
			for(var i=0; i<businessTypeArray.length; i++) {
				if(businessTypeArray[i] == data.value){
					businessTypeArray.splice(i, 1);
					break;
				}
			}
		  }
		}); 	
	  form.on('checkbox(businessBrand)', function(data){
		  if(data.elem.checked){
			  businessBrandArray.push(data.value)
		  }else{
			//防止多次添加同一个元素,很鸡肋的,其实在后台控制也可以
			for(var i=0; i<businessBrandArray.length; i++) {
				if(array[i] == data.value){
					businessBrandArray.splice(i, 1);
					break;
				}
			}
		  }
		}); 	
	  form.on('checkbox(logisticsWay)', function(data){
		  if(data.elem.checked){
			  logisticsWay.push(data.value)
		  }else{
			//防止多次添加同一个元素,很鸡肋的,其实在后台控制也可以
			for(var i=0; i<logisticsWay.length; i++) {
				if(logisticsWay[i] == data.value){
					logisticsWay.splice(i, 1);
					break;
				}
			}
		  }
		}); 	
/* 	  form.on('checkbox(openApplyProduct)', function(data){
		  console.log(data.value)
		  if(data.elem.checked){
			  openApplyProduct.push(data.value)
		  }else{
			//防止多次添加同一个元素,很鸡肋的,其实在后台控制也可以
			for(var i=0; i<openApplyProduct.length; i++) {
				if(openApplyProduct[i] == data.value){
					openApplyProduct.splice(i, 1);
					break;
				}
			}
		  }
		});  */	
	  $('#next').on('click',function(){
		  
		  intoNext()

	  })
	  $('#last').on('click',function(){
		  element.tabChange('tab','channelInfo')

	  })
	  //收款信息
	  table.render({
		    elem: '#gatherList'
		    ,id:'gather'
		    ,page:true
		    ,limit:5
		    ,limits:[5,10,15]
		    ,cols: [[ //表头
		      {field: 'gatherId', title: '序号', align:'center'}
		      ,{field: 'gatherBankId', title: '收款银行卡账号',width:230,align:'center'}
		      ,{field: 'gatherOwnerName', title: '所有人姓名',width:230,align:'center'}
		      ,{field: 'gatherIdcard', title: '身份证号', width:230, align:'center'}
		      ,{field: 'gatherPhone', title: '银行卡绑定手机号码', width:130,align:'center'} 
		      ,{field: 'gatherDepositBank', title: '开户银行', width:170,align:'center'} 
		      ,{field: 'gatherBankBranch', title: '开户行分行', width:170,align:'center'} 
		      ,{field: 'gatherBankSubbranch', title: '开户行支行', width:170,align:'center'} 
		      ,{field: 'tool', title: '操作', width:200,align:'center',toolbar:'#bar'}
		    ]]
		  });
 	  form.on('submit(submitAddChanel)', function(data){
		  	  /*
		  	   	渠道属性
		  	  */
			  //地址
			  var address = $('#province').find("option:selected").text()+
			 				 $('#city').find("option:selected").text()+
			 				 $('#area').find("option:selected").text();
		  	  var channelSalesmanName = $('#channelSalesmanName').find("option:selected").text();//店付业务员姓名
		  	  var channelSalesmanNum = $('#channelSalesmanNum').val();//店付业务员编号
		  	  /*
		  	   	企业基本信息
		  	  */
			  var enterpriseBusinesslicenseNo = $('#enterpriseBusinesslicenseNo').val();//营业执照编号
			  var enterpriseCompanyName = $('#enterpriseCompanyName').val();//公司名称
			  //公司注册地址
			  var registerAddress = $('#registerProvince').find("option:selected").text()+
			 				 $('#registerCity').find("option:selected").text()+
			 				 $('#registerArea').find("option:selected").text();
			  //公司实际地址
			  var realAddress = $('#realProvince').find("option:selected").text()+
			 				 $('#realCity').find("option:selected").text()+
			 				 $('#realArea').find("option:selected").text();
			  var enterpriseCorp = $('#enterpriseCorp').val();//法人名称
			  var enterpriseCorpIdcard = $('#enterpriseCorpIdcard').val();//法人名称
			  var enterpriseOperatioTime = $('#enterpriseOperatioTime').val();//经营年限(年)
			  var enterpriseEmployeeNum = $('#enterpriseEmployeeNum').val();//员工数量(人)
			  var enterpriseCompanyAbbreviation = $('#enterpriseCompanyAbbreviation').val();//公司简称
		  	  /*
		  	   	业务信息
		  	  */
			  businessScope = $('#businessScope').find("option:selected").text();//业务覆盖地域范围
		  	  /*
		  	   	担保信息
		  	  */
			  var guaranteeSituation = $('#guaranteeSituation').find("option:selected").text();//担保形式
			  var guaranteeDeposit = $('#guaranteeDeposit').val();//保证金金额
			  var guaranteeCorpPhone = $('#guaranteeCorpPhone').val();//法人手机
			  var guaranteeFinanceContactname = $('#guaranteeFinanceContactname').val();//财务联系人姓名
			  var guaranteeFinanceContactphone = $('#guaranteeFinanceContactphone').val();//财务联系人手机号
			  var guaranteeBusinessLeadername = $('#guaranteeBusinessLeadername').val();//业务负责人姓名
			  var guaranteeBusinessLeaderphone = $('#guaranteeBusinessLeaderphone').val();//业务负责人手机
			  var guaranteeBusinessPhonePassword = $('#guaranteeBusinessPhonePassword').val();//服务密码
			  /*
		  	   	收款账号:窗口添加
		  	  */
		  	  //TODO:
		  	  /*
		  	   	财务指标
		  	  */
		  	  var targetLastSale = $('#targetLastSale').val();//保证金金额
		  	  /*
		  	   	物流配送
		  	  */
		  	  var logisticsCooperationName = $('#logisticsCooperationName').val();//合作物流：
		  	  var logisticsOther = $('#logisticsOther').val();//其他：
		  	  var logisticsAllCost = $('#logisticsAllCost').val();//年物流总费用(万元)：
		  	  /*
		  	   	开户信息
		  	  */
			  //var openAdminNum = $('#adminNum').val();//管理员账号
			  var openStartTime = $('#startTime').val();//起始时间
			  var openEndTime = $('#endTime').val();//结束时间
			  var openSellRate = $('#sell').val();//费率
			  
 			  $.post({
				  url:'<%=path%>/merchant/insertChannel',
				  dataType:'json',
				  data:{
					  	//渠道信息
 		 				channelCity:realAddress,
		 				channelSalesmanName:channelSalesmanName,
		 				channelSalesmanNum:channelSalesmanNum,
		 				channelState:0,
		 				//企业信息
  		 				enterpriseBusinesslicenseNo:enterpriseBusinesslicenseNo,
		 				enterpriseCompanyName:enterpriseCompanyName,
		 				enterpriseCompanyRegisterAddr:registerAddress,
		 				enterpriseCompanyRealitAddr:realAddress,
		 				enterpriseCorp:enterpriseCorp,
		 				enterpriseCorpIdcard:'123423',
		 				enterpriseOperatioTime:enterpriseOperatioTime,
		 				enterpriseEmployeeNum:enterpriseEmployeeNum,
		 				//业务信息
		 				businessProduct:businessProductArray.toString(),
		 				businessType:businessTypeArray.toString(),
		 				businessBrand:businessBrandArray.toString(),
		 				businessScope:businessScope,
		 				//担保信息
		 				guaranteeSituation:guaranteeSituation,
		 				guaranteeDeposit:guaranteeDeposit,
		 				guaranteeCorpPhone:guaranteeCorpPhone,
		 				guaranteeFinanceContactname:guaranteeFinanceContactname,
		 				guaranteeFinanceContactphone:guaranteeFinanceContactphone,
		 				guaranteeBusinessLeadername:guaranteeBusinessLeadername,
		 				guaranteeBusinessLeaderphone:guaranteeBusinessLeaderphone,
		 				guaranteeBusinessPhonePassword:guaranteeBusinessPhonePassword,
		 				//财务指标
		 				targetLastSale:targetLastSale,
		 				//物流配送
		 				logisticsWay:logisticsWay.toString(),
		 				logisticsCooperationName:logisticsCooperationName,
		 				logisticsAllCost:logisticsAllCost,
		 				logisticsOther:logisticsOther, 
		 				//开户
		 				//管理员账户为业务负责人手机号+@+公司简称
 		 				openAdminNum:guaranteeBusinessLeaderphone+'@'+enterpriseCompanyAbbreviation,
		 				//管理员手机号为业务负责人手机号
		 				openAdminPhone:guaranteeBusinessLeaderphone,
		 				openStartTime:openStartTime,
		 				openEndTime:openEndTime,
		 				//openApplyProduct:openApplyProduct.toString(),
		 				openApplyProduct:openApplyProduct.toString(),
		 				//openSellRate:openSellRate, 
		 				openSellRate:7, 
				  },
				  success:function(result){
					  if(result.state == 'success'){
						  //信息添加成功后添加收款列表
						var state = addGather(gatherListJson,result.channelNum)
						layer.msg(result.msg,{icon: result.icon});
						channelNum = result.channelNum
						intoNext();//添加成功后进入
					  }else if(result.state == 'error'){
						  layer.msg(result.msg,{icon: result.icon});
					  }else if(result.state == 'exit'){
						  layer.msg(result.msg,{icon: result.icon});
					  }
				  },
				  error:function(){
					  layer.msg('网络错误',{icon: 2});
				  }
			  }) 
	  }) 
 	  $.post({//获取主营业务
		  url:'<%=path%>/category/getFistCategory',
		  dataType:'json',
		  success:function(data){
			  var list = "";
			  $.each(data.categoryList,function(i,item){
				  list +='<input type="checkbox" name="businessProduct" lay-filter="businessProduct" title="'+item.categoryName+'" value ="'+item.categoryId+'">';
				  $('#businessProduct').html(list)
			  })
			  form.render('checkbox');
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
	  $('#addBank').on('click', function() {
		  layer.open({
			  type: 2, 
			  area: ['75%', '70%'],//宽高
			  content: ['addGather.jsp'] ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			  cancel: function(index, layero){ 
				  var data = $(layero).find("iframe")[0].contentWindow.gatherListJson;
				  gatherListJson = data;
				  table.reload('gather', {
					  data:gatherListJson
					});
				}    
		  }); 
	  });
	  $('#businessType').on('click', function() {
		  var html = '<div class="layui-form-mid layui-word-aux">&nbsp&nbsp&nbsp选择商品类型后可见</div>'
		  $('#businessBrand').html(html)
		  if(businessProductArray.length == 0){
			  layer.msg('请选择主营业务',{icon: 2});
		  }else{
			  layer.open({
				  type: 2, 
				  area: ['25%', '70%'],//宽高
				  content: ['addBusinessType.jsp'] ,
				  btn: ['确定','取消']
				  ,yes: function(index, layero){
					  var body = layer.getChildFrame('body', index);
					  var childrens = $(layero).find("iframe")[0].contentWindow.getCheck() 
					  businessTypeArray = childrens;
					  console.log(businessTypeArray.toString())
				 	  $.post({//获取主营业务
						  url:'<%=path%>/brand/getBrandList',
						  dataType:'json',
						  data:{categoryIds:businessTypeArray.toString()},
						  success:function(data){
							  console.log(data)
  				 			  var list = "";
							  $.each(data.data,function(i,item){
								  list +='<input type="checkbox" name="businessBrand" lay-filter="businessBrand" title="'+item.brandName+'" value ="'+item.brandId+'">';
								  $('#businessBrand').html(list)
							  })  
							  form.render('checkbox');
						  }
					  }) 
				  },
	 			  cancel: function(index, layero){ 
					}  
			  }); 
		  }
	  });
	  $('#openExpress').on('click', function() {
		  layer.open({
			  type: 2, 
			  area: ['75%', '70%'],//宽高
			  content: ['../express/expressManage.jsp'] ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			  cancel: function(index, layero){
				  var data = $(layero).find("iframe")[0].contentWindow.expressIds;
				  $('#logisticsCooperationName').val(data.toString())
				}    
		  }); 
	  });
	  	function addGather(gatherListJson,channelNum){
	  		$.each(gatherListJson,function(i,data){
	  			$.post({
	  				url:'<%=path%>/merchant/insertGather',
	  				dataType:'json',
	  				data:{
	  					gatherBankId:data.gatherBankId,
	  					gatherOwnerName:data.gatherOwnerName,
	  					gatherPhone:data.gatherPhone,
	  					gatherIdcard:data.gatherIdcard,
	  					gatherDepositBank:data.gatherDepositBank,
	  					gatherBankBranch:data.gatherBankBranch,
	  					gatherBankSubbranch:data.gatherBankSubbranch,
	  					channelNum:channelNum
	  				},
	  				success:function(result){},
	  				error:function(){
	  					layer.msg('收款信息添加异常',{icon: 2});
	  				}
	  			})
	  		})

	  	}
	  	//获得省
 		 function getProvince(parentId){
			$.getJSON({
	 			 url:'<%=path%>/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'">'+item.name+'</option>';
					  $('#province').html(list)
					  $('#registerProvince').html(list)
					  $('#realProvince').html(list)
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
 		//获得城市
 		 function getCity(parentId,Id){
			$.getJSON({
	 			 url:'<%=path%>/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'">'+item.name+'</option>';
					  $('#'+Id).html(list)
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
 		 
 		 //获得区
 		 function getArea(parentId,Id){
			$.getJSON({
	 			 url:'<%=path%>/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'" title="'+item.name+'">'+item.name+'</option>';
					  $('#'+Id).html(list)
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
 		 //获得业务员
 		 function getSalesman(){
			$.getJSON({
	 			 url:'<%=path%>/salesman/getSalesmanList.json',
	 			 dataType:'json',
	 			 data:{bei1:0},
	 			 success:function(data){
	 				 console.log(data)
			 		 var list = "<option value='' >请选择业务员</option>";
			 		 $.each(data.data,function(i,item){
			 			 console.log(item)
					  list +='<option value="'+item.salesmanIdcard+'" title="'+item.salesmanName+'">'+item.salesmanName+'</option>';
					  $('#channelSalesmanName').html(list)
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
 		 /*
 		 图片上传
 		 */
		  
		  function intoNext(){
			  $('#picInfo').removeAttr('style')
			  element.tabChange('tab','picInfo')
			  layui.use(['upload'], function(){
			  var upload = layui.upload;
	  		  upload.render({//营业执照
	 			    elem: '#businesslicense' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'businesslicense',types:0,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
	 			    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    } 
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//近12月对公流水法人流水
	 			    elem: '#statement' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'statement',types:1,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//法人身份证正面
	 			    elem: '#corpIdCardFront' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'corpIdCardFront',types:2,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//法人身份证反面
	 			    elem: '#corpIdCardReverse' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'corpIdCardReverse',types:3,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//业务负责人身份证正面
	 			    elem: '#salesmanIdCardFront' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'salesmanIdCardFront',types:4,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//业务负责人身份证反面
	 			    elem: '#salesmanIdCardReverse' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'salesmanIdCardReverse',types:5,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//公司全景照
	 			    elem: '#companyPanorama' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'companyPanorama',types:6,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//公司大门照
	 			    elem: '#companyGate' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'companyGate',types:7,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//核心商户合作合同
	 			    elem: '#contract' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'contract',types:8,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//签约合影照片
	 			    elem: '#signed' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'signed',types:9,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  }); 
	  		  upload.render({//经营地租赁协议
	 			    elem: '#lease' //绑定元素
	 			    ,accept:'images'
	 			    ,multiple:true//多文件上传
	 			    ,data:{type:'lease',types:10,channelNum:channelNum,status:'channel',accept:'images'}
	 			    ,url: '<%=path%>/merchant/uploadPic' //上传接口
	 			    ,done: function(res){
				    	if(res.state == 'success'){
		 			    	layer.msg(res.msg,{icon: 1});
	 			    	}else if(res.state == 'error'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}else if(res.state == 'max'){
	 			    		layer.msg(res.msg,{icon: 2});
	 			    	}
	 			    }
	 			    ,error: function(){
	 			    	layer.msg('图片失败',{icon: 2});
	 			    }
	 			  });  
			  })
		  }
	});
</script>
</body>
</html>