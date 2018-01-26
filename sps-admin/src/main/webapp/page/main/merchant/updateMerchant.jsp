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
<title>商户信息修改</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=path%>/page/layui/css/layui.css" media="all" />
<style type="text/css">
 .spsImages{
 	height: 200px;
 	width: 400px;
 	background-color: #eee;
 }
 .imageSize{
  	height: 200px;
 	width: 400px;
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
	<div class="layui-form layui-form-pane" style="margin-left: 100px;margin-right: 100px">
		<h3>属性信息</h3>
		<hr>
		  <!-- 属性信息开始 -->
		  <div class="layui-form-item " >
		    <label class="layui-form-label" style="width:200px">*所在城市：</label>
		    <div class="layui-input-inline" >
		      <select name="province" lay-filter="province"  id="province" lay-verify="required"> 
		      </select>
		    </div>
		    <div class="layui-input-inline" >
		      <select name="city" lay-filter="city"   id="city" lay-verify="required"> 
				  <option value="" >市</option>
		      </select>
		    </div>
		    <div class="layui-input-inline" >
		      <select name="area" lay-filter="area"   id="area" lay-verify=""> 				  
		      	  <option value="">区</option>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:200px">*店付业务员姓名：</label>
		    <div class="layui-input-inline">
		      <input  id="channelSalesmanName" type="text" name="channelSalesmanName"  lay-verify="required|IsChineseCharacter" placeholder="请输入店付业务员姓名" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*店付业务员身份证：</label>
		    <div class="layui-input-inline">
		      <input  id="channelSalesmanNum" type="text" name="channelSalesmanNum"  lay-verify="required" placeholder="请输入店付业务员身份证" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item" id="passwordDiv">
		   <label class="layui-form-label" style="width:200px">*核心商户编号：</label>
		    <div class="layui-input-inline">
		      <input  id="channelNum" name="channelNum" disabled type="text" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*核心商户状态：</label>
		    <div class="layui-input-inline">
		    </div>
		     <div class="layui-form-mid layui-word-aux">&nbsp&nbsp&nbsp 未激活</div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*上线时间：</label>
		    <div class="layui-input-inline">
		      <input id="channelUpTime" type="text"  disabled name="channelUpTime"   autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*冻结时间：</label>
		    <div class="layui-input-inline">
		      <input id="channelFreezeTime"  type="text" disabled name="channelFreezeTime"  autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*营业执照编号：</label>
		    <div class="layui-input-inline">
		      <input  id="enterpriseBusinesslicenseNo" type="text" name="enterpriseBusinesslicenseNo"  lay-verify="required" placeholder="请输入营业执照编号" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*公司名称：</label>
		    <div class="layui-input-inline">
		      <input  id="enterpriseCompanyName" type="text" name="enterpriseCompanyName" lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">公司注册地址：</label>
		    <div class="layui-input-inline" >
		      <select id="registerProvince"name="registerProvince" lay-filter="registerProvince" lay-verify="required"> 
		      </select>
		    </div>
		    <div class="layui-input-inline" >
		      <select name="registerCity" lay-filter="registerCity" id="registerCity" lay-verify="required"> 
				  <option value="">市</option>
		      </select>
		    </div>
		    <div class="layui-input-inline" >
		      <select name="registerArea" lay-filter="registerArea" id="registerArea" lay-verify="required"> 
				  <option value="">区</option>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">公司实际地址：</label>
		    <div class="layui-input-inline" >
		      <select name="realProvince" lay-filter="realProvince" id="realProvince" lay-verify="required"> 
		      </select>
		    </div>
		    <div class="layui-input-inline" >
		      <select name="realCity" lay-filter="realCity" id="realCity" lay-verify="required"> 
				  <option value="">市</option>
		      </select>
		    </div>
		    <div class="layui-input-inline" >
		      <select name="realArea" lay-filter="realArea" id="realArea" lay-verify=""> 
				  <option value="">区</option>
		      </select>
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*法人代表姓名：</label>
		    <div class="layui-input-inline">
		      <input id="enterpriseCorp" type="text" name="enterpriseCorp"  lay-verify="required|IsChineseCharacter" placeholder="请输入法人代表姓名" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*经营年限(年)：</label>
		    <div class="layui-input-inline">
		      <input   id="enterpriseOperatioTime" type="text" name="enterpriseOperatioTime" lay-verify="required" placeholder="请输入经营年限(年)" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*员工数量(人)：</label>
		    <div class="layui-input-inline">
		      <input  id="enterpriseEmployeeNum" type="text" name="enterpriseEmployeeNum"  lay-verify="required" placeholder="请输入员工数量" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		<!-- 属性信息结束 -->
		<h3>业务信息</h3>
		<hr>
		<!-- 业务信息开始 -->
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">主营业务：</label>
		    <div class="layui-input-inline" style="width:600px" id="businessProduct">
		      <input type="checkbox"  title="一级分类名称1" value="1" lay-filter = "businessProduct">
		      <input type="checkbox"  title="一级分类名称2" value="2" lay-filter = "businessProduct">
		    </div>
		  </div>
		  <div class="layui-form-item"><!-- 树 -->
		    <label class="layui-form-label" style="width:200px">主营商品类型：</label>
		    <div class="layui-input-inline" style="width:600px" id="businessType">
		      <input type="checkbox" title="三级分类名称1" value="1" lay-filter = "businessType" >
		      <input type="checkbox" title="三级分类名称2" value="2" lay-filter = "businessType">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">主营品牌：</label>
		    <div class="layui-input-inline" style="width:600px" id="businessBrand">
		      <input type="checkbox"  title="品牌名称1" value="1" lay-filter = "businessBrand">
		      <input type="checkbox"  title="品牌名称2" value="2" lay-filter = "businessBrand">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px	">业务覆盖地域范围：</label>
		    <div class="layui-input-inline">
		     <select lay-verify="required" name="businessScope" lay-filter="businessScope" id="businessScope"> 
				  <option value="">请选择</option>
				  <option value="1">全国</option>
				  <option value="2">本省</option>
				  <option value="3">本市</option>
				  <option value="4">本县</option>
		      </select>
		    </div>
		  </div>
		<!-- 业务信息结束 -->
		<h3>担保信息</h3>
		<hr>
		<!-- 担保信息开始 -->
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*担保形式：</label>
		    <div class="layui-input-inline">
		     <select lay-verify="" name="guaranteeSituation" lay-filter="guaranteeSituation" id="guaranteeSituation"> 
				  <option value="">请选择担保形式</option>
				  <option value="1">保证金担保</option>
				  <option value="2">信用担保</option>
				  <option value="3">无担保</option>
		      </select>
		    </div>
		    <label class="layui-form-label" style="width:200px">*保证金金额：</label>
		    <div class="layui-input-inline">
		      <input  id="guaranteeDeposit" type="text" name="guaranteeDeposit" lay-verify="required" placeholder="请输入保证金金额" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*法人代表手机号：</label>
		    <div class="layui-input-inline">
		      <input id="guaranteeCorpPhone" type="text" name="guaranteeCorpPhone"  lay-verify="required|phone" placeholder="请输入法人手机号" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*财务联系人姓名：</label>
		    <div class="layui-input-inline">
		      <input id="guaranteeFinanceContactname" type="text" name="guaranteeFinanceContactname" lay-verify="required|IsChineseCharacter" placeholder="请输入财务联系人姓名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*财务联系人手机号：</label>
		    <div class="layui-input-inline">
		      <input id="guaranteeFinanceContactphone" type="text" name="guaranteeFinanceContactphone"  lay-verify="required|phone" placeholder="财务联系人手机号" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*业务负责人姓名：</label>
		    <div class="layui-input-inline">
		      <input id="guaranteeBusinessLeadername" type="text" name="guaranteeBusinessLeadername" lay-verify="required|IsChineseCharacter" placeholder="业务负责人姓名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*业务负责人手机号：</label>
		    <div class="layui-input-inline">
		      <input  id="guaranteeBusinessLeaderphone" type="text" name="guaranteeBusinessLeaderphone"  lay-verify="required|phone" placeholder="业务负责人手机号" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" style="width:200px">*业务负责人手机服务密码：</label>
		    <div class="layui-input-inline">
		      <input id="guaranteeBusinessPhonePassword" type="password" name="guaranteeBusinessPhonePassword"  lay-verify="required|minLength" placeholder="服务密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		<!-- 担保信息结束 -->
		<h3>收款信息</h3>
		<hr>
		<!-- 收款信息开始 -->
		<div>
			<blockquote class="layui-elem-quote">
				<a href="javascript:;" class="layui-btn layui-btn-warm" id="addBank">
					<i class="layui-icon">&#xe608;</i> 新增
				</a>
			</blockquote>
		</div>
		<table id="gatherList" lay-filter="gatherTables"></table>
		<!-- 收款信息结束 -->
		<h3>财务指标</h3>
		<hr>
		<!-- 财务指标开始 -->
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*上年销售额(万元)：</label>
		    <div class="layui-input-inline">
		      <input id="targetLastSale" type="text" name="targetLastSale"  lay-verify="required" placeholder="请输入上年销售额" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		<!-- 财务指标结束 -->
		<h3>物流配送</h3>
		<hr>
		<!-- 物流配送开始 -->
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px	">发货方式：</label>
		    <div class="layui-input-inline" style="width:400px" id= "logisticsWay">
		      <input type="checkbox" title="物流" value="0" lay-skin="primary" lay-filter="logisticsWay">
		      <input type="checkbox" title="自主派送" value="1" lay-skin="primary" lay-filter="logisticsWay">
		      <input type="checkbox" title="上门取货" value="2" lay-skin="primary" lay-filter="logisticsWay">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*合作物流名称：</label>
		    <div class="layui-input-inline">
		      <input id="logisticsCooperationName" type="logisticsCooperationName" name="name" lay-verify="required" placeholder="搜索" autocomplete="off" class="layui-input">
		    </div>
		    <label class="layui-form-label" >*其他：</label>
		    <div class="layui-input-inline">
		      <input  id="logisticsOther" type="text" name="logisticsOther" lay-verify="required" placeholder="其他" autocomplete="off" class="layui-input">
		    </div>
		   </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*年物流总费用(万元)：</label>
		    <div class="layui-input-inline">
		      <input  id="logisticsAllCost" type="text" name="logisticsAllCost" lay-verify="required" placeholder="请输入年物流总费用" autocomplete="off" class="layui-input">
		    </div>
		   </div>
		<!-- 物流配送结束 -->
		<h3>开户信息</h3>
		<hr>
		<!-- 开户信息开始 -->
<!-- 		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*管理员账号：</label>
		    <div class="layui-input-inline">
		      <input value = "18513967345" id="adminNum" type="text" name="adminNum" lay-verify="required" placeholder="请输入管理员账号" autocomplete="off" class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"> lili@juzifenqi</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*管理员手机号：</label>
		    <div class="layui-input-inline">
		      <input value = "18513967345" id="adminNum" type="text" name="adminNum" lay-verify="required" placeholder="请输入管理员账号" autocomplete="off" class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux"> lili@juzifenqi</div>
		</div> -->
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*签约开始日期：</label>
		    <div class="layui-input-inline">
			 <input type="text" class="layui-input" id="startTime" placeholder="年-月-日" lay-verify="required" >	    
			 </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*签约结束日期：</label>
		    <div class="layui-input-inline">
			 <input type="text" class="layui-input" id="endTime" placeholder="年-月-日" lay-verify="required" >		    
			 </div>
		</div>
<!-- 		<div class="layui-form-item" >
		    <label class="layui-form-label" style="width:200px	">适用产品：</label>
		    <div class="layui-input-inline" style="width:300px">
		      <input type="checkbox" title="7天包息" value="0" lay-skin="primary" lay-filter="openApplyProduct" >
		      <input type="checkbox" title="7天不包息" value="1" lay-skin="primary" lay-filter="openApplyProduct">
		    </div>
		  </div> -->
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:200px">*代销手续费率（%）：</label>
		    <div class="layui-input-inline">
		      <input   id="sell" type="text" name="sell" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		</div>
		<!-- 开户信息结束 -->
		 	<div class="layui-form-item" align="center" id="btn" >
				<button onclick="javascript:history.back(-1);" class="layui-btn layui-btn-primary">返回</button>
				<button class="layui-btn layui-btn-primary" lay-filter="submitAddChanel" lay-submit >保存并进入下一步</button>
				<button class="layui-btn layui-btn-primary" id="next" >下一步</button>
			</div>
	</div>
    </div>
    <div class="layui-tab-item">
   			<div align="center">
   				<div class="layui-row layui-col-space10">
   				<ul>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   						<img alt="" src="<%=path%>/page/static/images/404.png" class="imageSize">
		   					</a>
		   					<p>营业执照</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   						<img alt="" src="<%=path%>/page/static/images/404.png" class="imageSize">
		   					</a>
		   					<p>营业执照</p>
	   					</div>
	   				</li>
   				</ul>
			</div>
			<!-- 按钮 -->
    		 <div class="layui-form-item" align="center" id="btn" style="padding-top: 10px" >
				<button class="layui-btn layui-btn-primary" id="last">返回</button>
				<button class="layui-btn layui-btn-primary" lay-filter="" lay-submit >保存</button>
			</div>
    </div>
  </div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="del">删除</a>
</script>
<script type="text/javascript">
	layui.use(['form','table','laydate','flow','element','upload'], function(){
	  var element = layui.element;
	  var form = layui.form;
	  var $ = layui.jquery;
	  var table = layui.table;
	  var laydate = layui.laydate;
	  var flow = layui.flow;
	  var upload = layui.upload;
	  var businessProductArray = [];//主营业务数组
	  var businessTypeArray = [];//主营商品类型数组
	  var businessBrandArray = [];//主营品牌数组
	  var logisticsWay = [];//发货方式
	  var openApplyProduct = ['0'];//适用产品
	  var gatherListJson = null;
	  var channelNum ;//外键,很多地方能用到
	  getProvince(100000)//先加载省
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
		  console.log(data.value)
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
 /* 			  $.post({
				  url:'<%=path%>/merchant/insertGather.html',
				  dataType:'json',
				  data:{
					  gathers:gatherListJson,
					  }
				  });  */
				  $('#picInfo').removeAttr('style')
	     //addGather(gatherListJson,'1')
		  element.tabChange('tab','picInfo')

	  })
	  $('#last').on('click',function(){
		  element.tabChange('tab','channelInfo')

	  })
	  	  $.post({//获得物流配送信息
		  url:'<%=path%>/merchant/getLogistics'
		  ,dataType:'json'
		  ,data:{channelNum:channelNum}
		  ,success:function(result){
			  $('#logisticsWay').html(result.logisticsWay)//地址
			  $('#logisticsCooperationName').html(result.logisticsCooperationName)
			  $('#logisticsOther').html(result.logisticsOther)//业务员名称
			  $('#logisticsAllCost').html(result.logisticsAllCost)//业务员身份证
		  }
	  })
	  $.post({//获得属性信息和基本信息
		  url:'<%=path%>/merchant/getChannel'
		  ,dataType:'json'
		  ,data:{channelNum:channelNum}
		  ,success:function(result){
			  $('#address').html(result.channel.channelCity)//地址
			  $('#channelNum').html(result.channel.channelNum)
			  $('#channelSalesmanName').html(result.channel.channelSalesmanName)//业务员名称
			  $('#channelSalesmanNum').html(result.channel.channelSalesmanNum)//业务员身份证
			  $('#channelUpTime').html(result.channel.channelUpTime)//上线时间
			  $('#channelFreezeTime').html(result.channel.channelFreezeTime)//冻结时间
			  $('#enterpriseBusinesslicenseNo').html(result.enterpriseBusinesslicenseNo)//营业执照
			  $('#enterpriseCompanyName').html(result.enterpriseCompanyName)//公司名称
			  $('#realAddress').html(result.enterpriseCompanyRealitAddr)//实际地址
			  $('#registerAddress').html(result.enterpriseCompanyRegisterAddr)//注册地址
			  $('#enterpriseCompanyAbbreviation').html(result.enterpriseCompanyAbbreviation)//公司简称
			  $('#enterpriseCorp').html(result.enterpriseBusinesslicenseNo)//法人代表
			  $('#enterpriseOperatioTime').html(result.enterpriseOperatioTime)//经营年限
			  $('#enterpriseEmployeeNum').html(result.enterpriseEmployeeNum)//员工人数
		  }
	  })
	  $.post({//获得担保信息
		  url:'<%=path%>/merchant/getGuarantee'
		  ,dataType:'json'
		  ,data:{channelNum:channelNum}
		  ,success:function(result){
			  $('#guaranteeSituation').html(result.guaranteeSituation)//担保形式
			  $('#guaranteeDeposit').html(result.guaranteeDeposit)//担保形式
			  $('#guaranteeCorpPhone').html(result.guaranteeCorpPhone)//担保形式
			  $('#guaranteeFinanceContactname').html(result.guaranteeFinanceContactname)//担保形式
			  $('#guaranteeFinanceContactphone').html(result.guaranteeFinanceContactphone)//担保形式
			  $('#guaranteeBusinessLeadername').html(result.guaranteeBusinessLeadername)//担保形式
			  $('#guaranteeBusinessLeaderphone').html(result.guaranteeBusinessLeaderphone)//担保形式
			  $('#guaranteeBusinessPhonePassword').html(result.guaranteeBusinessPhonePassword)//担保形式
		  }
	  })
	  $.post({//获得财务指标
		  url:'<%=path%>/merchant/getFinanceTarget'
		  ,dataType:'json'
		  ,data:{channelNum:channelNum}
		  ,success:function(result){
			  $('#targetLastSale').html(result.targetLastSale)//上年销售额(万元)
		  }
	  })
	  $.post({//获得开户信息
		  url:'<%=path%>/merchant/getOpenAccount'
		  ,dataType:'json'
		  ,data:{channelNum:channelNum}
		  ,success:function(result){
			  $('#openAdminNum').html(result.openAdminNum)//管理员账号
			  $('#openAdminPhone').html(result.openAdminPhone)//管理员手机
			  $('#openStartTime').html(result.openStartTime)//签约开始日期
			  $('#openEndTime').html(result.openEndTime)//签约开始日期
			  //$('#openSellRate').html(result.openSellRate)//代销手续费率
		  }
	  })
	  //收款信息
	  table.render({
		    elem: '#gatherList'
		    //,url: '<%=path%>/merchant/getGatherList.html' //数据接口
		    ,id:'gather'
		    ,page:true
		    ,limit:5
		    ,limits:[5,10,15]
		    ,cols: [[ //表头
		      {field: 'gatherId', title: '序号', align:'center'}
		      ,{field: 'gatherBankId', title: '收款银行卡账号', align:'center'}
		      ,{field: 'gatherOwnerName', title: '所有人姓名',align:'center'}
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
		  	  var channelSalesmanName = $('#channelSalesmanName').val();//店付业务员姓名
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
			  var enterpriseOperatioTime = $('#enterpriseOperatioTime').val();//经营年限(年)
			  var enterpriseEmployeeNum = $('#enterpriseEmployeeNum').val();//员工数量(人)
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
				  url:'<%=path%>/merchant/insertChannel.html',
				  dataType:'json',
				  data:{
					  	//渠道信息
 		 				channelCity:address,
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
		 				//管理员账户为业务负责人手机号
 		 				openAdminNum:guaranteeBusinessLeaderphone,
		 				//管理员手机号为业务负责人手机号
		 				openAdminPhone:guaranteeBusinessLeaderphone,
		 				openStartTime:openStartTime,
		 				openEndTime:openEndTime,
		 				//openApplyProduct:openApplyProduct.toString(),
		 				openApplyProduct:openApplyProduct.toString(),
		 				openSellRate:openSellRate, 
				  },
				  success:function(result){
					  if(result.state == 'success'){
						  //信息添加成功后添加收款列表
						var state = addGather(gatherListJson,result.channelNum)
						layer.msg(result.msg,{icon: result.icon});
						channelNum = result.channelNum
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
/* 	  $.post({//获取角色列表
		  url:'<%=path %>/role/roleList.html',
		  dataType:'json',
		  success:function(data){
			  var list = "";
			  $.each(data.data,function(i,item){
				  list +='<input type="checkbox" name="check" lay-filter="encrypt" title="'+item.roleName+'" value ="'+item.roleId+'">';
				  $('#checkList').html(list)
			  })
			  form.render('checkbox');
		  }
	  }) */
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
	  });  
	  $('#addBank').on('click', function() {
		  layer.open({
			  type: 2, 
			  area: ['75%', '70%'],//宽高
			  content: ['addGather.html'] ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			  cancel: function(index, layero){ 
				  var data = $(layero).find("iframe")[0].contentWindow.gatherListJson;
				  console.log(data)
				  gatherListJson = data;
				  table.reload('gather', {
					  data:gatherListJson
					});
				}    
		  }); 
	  });
	  	function addGather(gatherListJson,channelNum){
	  		$.each(gatherListJson,function(i,data){
	  			$.post({
	  				url:'<%=path%>/merchant/insertGather.html',
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
 		 /*
 		 图片上传
 		 */
  		  upload.render({//营业执照
 			    elem: '#businesslicense' //绑定元素
 			    ,accept:'images'
 			    ,multiple:true//多文件上传
 			    ,data:{type:'businesslicense',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'statement',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'corpIdCardFront',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'corpIdCardReverse',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'salesmanIdCardFront',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'salesmanIdCardReverse',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'companyPanorama',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'companyGate',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'contract',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'signed',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
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
 			    ,data:{type:'lease',types:0,id:channelNum,status:'channel',accept:'images'}
 			    ,url: '<%=path%>/common/file/manyUpload' //上传接口
 			    ,done: function(res){
 			    	if(res.state == 'success'){
	 			    	layer.msg('图片上传成功',{icon: 1});
 			    	}else if(res.state == 'error'){
 			    		layer.msg('图片失败',{icon: 2});
 			    	}
 			    }
 			    ,error: function(){
 			    	layer.msg('图片失败',{icon: 2});
 			    }
 			  });  
	});
</script>
</body>
</html>