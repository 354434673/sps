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
<title>商户信息查看</title>
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
<div class="layui-tab layui-tab-brie" lay-filter ="tab" style="padding:10px;" >
  <ul class="layui-tab-title">
    <li lay-id="channelInfo" class="layui-this">基本信息</li>
    <li lay-id="goodsInfo" id="goodsInfo" >商品信息</li>
    <li lay-id="picInfo" id="goodsInfo" >额度信息</li>
    <li lay-id="picInfo" id="goodsInfo" >操作员信息</li>
    <li lay-id="picInfo" id="picInfo" >图片资料</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show" id="123">
	<div class="layui-form" style="margin-left: 100px;margin-right: 100px">
	    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>属性信息</legend>
		</fieldset>
		  <!-- 属性信息开始 -->
		  <div class="layui-form-item " >
		    <label class="layui-form-label" style="width:152px">*所在城市：</label>
		    <div class="layui-input-inline" >
		    	<div class="layui-form-mid layui-word-aux" id="address"> </div>
		    </div>
		  </div>
		  <div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px">*店付业务员姓名：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="channelSalesmanName"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*店付业务员身份证：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="channelSalesmanNum"> </div>
		    </div>
		  </div>
		  <div class="layui-form-item" id="passwordDiv">
		   <label class="layui-form-label" style="width:152px">*核心商户编号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="channelNum"></div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*核心商户状态：</label>
		    <div class="layui-input-inline">
		     <div class="layui-form-mid layui-word-aux" id="channelState"></div>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*上线时间：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="channelUpTime"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*冻结时间：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="channelFreezeTime"> </div>
		    </div>
		  </div>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>基本信息</legend>
		</fieldset>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*营业执照编号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="enterpriseBusinesslicenseNo"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*公司名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="enterpriseCompanyName"> </div>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">公司注册地址：</label>
		    <div class="layui-input-inline" >
		    	<div class="layui-form-mid layui-word-aux" id="registerAddress"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">公司实际地址：</label>
		    <div class="layui-input-inline" >
		    	<div class="layui-form-mid layui-word-aux" id="realAddress"> </div>
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*法人代表姓名：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="enterpriseCorp"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*经营年限(年)：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="enterpriseOperatioTime"></div>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*员工数量(人)：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="enterpriseEmployeeNum"> </div>
		    </div>
		  </div>
		<!-- 属性信息结束 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>业务信息</legend>
		</fieldset>
		<!-- 业务信息开始 -->
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">主营业务：</label>
		    <div class="layui-input-inline" style="width:600px" >
		    	<span class="layui-form-mid layui-breadcrumb" lay-separator="|" id="businessProduct">
				</span>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">主营商品类型：</label>
		    <div class="layui-input-inline" style="width:600px" >
		    	<span class="layui-form-mid layui-breadcrumb" lay-separator="|"  id="businessProduct">
				  <a href="javascript:;">首页</a>
				  <a href="">国际新闻</a>
				  <a href="">亚太地区</a>
				</span>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">主营品牌：</label>
		    <div class="layui-input-inline" style="width:600px" >
		    	<span class="layui-form-mid layui-breadcrumb" lay-separator="|" id="businessBrand">
				</span>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px	">业务覆盖地域范围：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="businessScope"></div>
		    </div>
		  </div>
		<!-- 业务信息结束 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>担保信息</legend>
		</fieldset>
		<!-- 担保信息开始 -->
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*担保形式：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeSituation"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*保证金金额：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeDeposit"> </div>
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*法人代表手机号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeCorpPhone"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*财务联系人姓名：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeFinanceContactname"> </div>
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*财务联系人手机号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeFinanceContactphone"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*业务负责人姓名：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeBusinessLeadername"> </div>
		    </div>
		  </div>
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*业务负责人手机号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeBusinessLeaderphone"> </div>
		    </div>
		    <label class="layui-form-label" style="width:152px">*业务负责人手机服务密码：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="guaranteeBusinessPhonePassword"> </div>
		    </div>
		  </div>
		<!-- 担保信息结束 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>收款信息</legend>
		</fieldset>
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
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>财务指标</legend>
		</fieldset>
		<!-- 财务指标开始 -->
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*上年销售额(万元)：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="targetLastSale"> </div>
		    </div>
		  </div>
		<!-- 财务指标结束 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>物流配送</legend>
		</fieldset>
		<!-- 物流配送开始 -->
		 <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px	">发货方式：</label>
		    	<div class="layui-form-mid layui-word-aux" id="logisticsWay"> </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*合作物流名称：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="logisticsCooperationName"> </div>
		    </div>
		    <label class="layui-form-label" >*其他：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="logisticsOther"> </div>
		    </div>
		   </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*年物流总费用(万元)：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="logisticsAllCost"> </div>
		    </div>
		   </div>
		<!-- 物流配送结束 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>开户信息</legend>
		</fieldset>
		<!-- 开户信息开始 -->
 		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*管理员账号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="openAdminNum"> </div>
		    </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*管理员手机号：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="openAdminPhone"> </div>
		    </div>
		</div> 
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*签约开始日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="openStartTime"> </div>
			 </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*签约结束日期：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="openEndTime"> </div>
			 </div>
		</div>
<!-- 		<div class="layui-form-item" >
		    <label class="layui-form-label" style="width:152px	">适用产品：</label>
		    <div class="layui-input-inline" style="width:300px">
		      <input type="checkbox" title="7天包息" value="0" lay-skin="primary" lay-filter="openApplyProduct" >
		      <input type="checkbox" title="7天不包息" value="1" lay-skin="primary" lay-filter="openApplyProduct">
		    </div>
		  </div> -->
 		<div class="layui-form-item">
		    <label class="layui-form-label" style="width:152px">*代销手续费率（%）：</label>
		    <div class="layui-input-inline">
		    	<div class="layui-form-mid layui-word-aux" id="openSellRate">7%(默认)</div>
		    </div>
		</div>
	</div>
    </div>
    <!-- 商品信息 -->
    <div class="layui-tab-item">
    	
    </div>
    <!-- 额度信息 -->
    <div class="layui-tab-item">
    </div>
    <!-- 操作员信息 -->
    <div class="layui-tab-item">
    	<table id="gatherList2" lay-filter="gatherTables2"></table>
    </div>
    <!-- 图片资料 -->
    <div class="layui-tab-item">
   			<div align="center">
   				<div class="layui-row layui-col-space10">
    				<ul id='imageList'>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="business" lay-filter="business">
							  <div carousel-item id="businessList">
							  	<img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>营业执照</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="corpIdCard-front" lay-filter="corpIdCard-front">
							  <div carousel-item id="corpIdCard-frontList">	
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>法人身份证正面</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="corpIdCard-reverse" lay-filter="corpIdCard-reverse">
							  <div carousel-item id="corpIdCard-reverseList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>法人身份证反面</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="businessIdCard-front" lay-filter="businessIdCard-front">
							  <div carousel-item id="businessIdCard-frontList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>业务负责人身份证正面</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="businessIdCard-reverse" lay-filter="businessIdCard-reverse">
							  <div carousel-item id="businessIdCard-reverseList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>业务负责人身份证反面</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="panorama" lay-filter="panorama">
							  <div carousel-item id="panoramaList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>公司全景照</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="gate" lay-filter="gate">
							  <div carousel-item id="gateList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>公司大门照</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="contract" lay-filter="contract">
							  <div carousel-item id="contractList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>合作合同（必须加盖公司公章</p>
	   					</div>
	   				</li>
	   				<li>
	   					<div class="layui-col-md4">
		   					<a href="javascript:void(0)" class="spsImages" >
		   					<div class="layui-carousel" id="photo" lay-filter="photo">
							  <div carousel-item id="photoList">
							    <img alt="" lay-src="<%=path%>/page/static/images/404.png">
							  </div>
							</div>
							</a>
		   					<p>签约合影照片</p>
	   					</div>
	   				</li>
   				</ul>
   				</div>
			</div>
    </div>
  </div>
  			<div class="layui-form-item" align="center"  >
				<button onclick="javascript:history.back(-1);" class="layui-btn layui-btn-primary">返回</button>
			</div>
<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
		<!-- 进行数据渲染 -->
<script type="text/html" id="roleTpl">
  {{#  layui.each(d.role, function(index, item){ }}
    {{item.roleName}},
  {{#  }); }}
</script>
<script type="text/javascript">
	layui.use(['form','table','flow','element','carousel'], function(){
	  var element = layui.element;
	  var form = layui.form;
	  var $ = layui.jquery;
	  var table = layui.table;
	  var flow = layui.flow;
	  var carousel = layui.carousel;
	  var channelNum = getUrlParam('channelNum');
	  form.render(); 
	  flow.lazyimg();
	  //收款信息
	  table.render({
		    elem: '#gatherList'
		    ,url: '<%=path%>/merchant/getGatherList.json' //数据接口
		    ,where:{channelNum:channelNum}
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
		    ]]
		  });
	  table.render({
		    elem: '#gatherList2'
		    ,url: '<%=path%>/user/userList.json' //数据接口
		    ,where:{channelNum:'DF20180136191770'}
		    ,id:'gather1'
		    ,page:true
		    ,limit:5
		    ,limits:[5,10,15]
		    ,cols: [[ //表头
				      {field: 'userId',type:'numbers', title: '序号', align:'center'}
				      ,{field: 'userName', title: '姓名',align:'center'}
				      ,{field: 'userPhone', title: '联系电话', width:230, align:'center'}
				      ,{field: 'userUsername', title: '登录名', align:'center'}
				      ,{field: 'role', title: '备注', align:'center',templet: '#roleTpl'}
				    ]]
		  });
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
			  
			  var state ;
			  var channelState = result.channel.channelState
			  if(channelState == 0){
				  state = '未激活'
			  }else if(channelState == 1){
				  state = '正常'
			  }else if(channelState == 2){
				  state = '冻结'
			  }
			  $('#channelState').html(state)//状态
			  $('#channelFreezeTime').html(result.channel.channelFreezeTime)//冻结时间
			  $('#enterpriseBusinesslicenseNo').html(result.enterpriseBusinesslicenseNo)//营业执照
			  $('#enterpriseCompanyName').html(result.enterpriseCompanyName)//公司名称
			  $('#realAddress').html(result.enterpriseCompanyRealitAddr)//实际地址
			  $('#registerAddress').html(result.enterpriseCompanyRegisterAddr)//注册地址
			  $('#enterpriseCompanyAbbreviation').html(result.enterpriseCompanyAbbreviation)//公司简称
			  $('#enterpriseCorp').html(result.enterpriseCorp)//法人代表
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
		  $.post({//获得业务信息
				  url:'<%=path%>/merchant/getBusiness'
				  ,dataType:'json'
				  ,data:{channelNum:channelNum}
				  ,success:function(result){
					  console.log(result)
					  $('#businessScope').html(result.businessScope)
					  getProduct(result.businessProduct);
					  getType(result.businessType);
					  getBrand(result.businessBrand);
				  }
		  }) 
		$('#addBank').on('click', function() {
		  layer.open({
			  type: 2, 
			  area: ['75%', '70%'],//宽高
			  content: ['addGather.jsp?type=1'] ,//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			  cancel: function(index, layero){ 
				  var data = $(layero).find("iframe")[0].contentWindow.gatherListJson;
				  gatherListJson = data;
				  table.reload('gather', {
					  data:gatherListJson
					});
				}    
		  }); 
	  });
	  function getProduct(ids){
		  $.post({//获取主营业务
			  url:'<%=path%>/category/getFistCategory',
			  dataType:'json',
			  data:{ids:ids},
			  success:function(data){
 				  var list = "";
				  $.each(data.categoryList,function(i,item){
					  list += '<a href="javascript:;">'+item[0].categoryName+'</a>'
 					  $('#businessProduct').html(list) 
				  }) 
				  element.render('breadcrumb');
			  }
		  }) 
		  }
 	function getType(ids){
	 	  $.post({//主营商品类型
			  url:'<%=path%>/category/getChildrenCategorys',
			  dataType:'json',
			  data:{ids:ids},
			  success:function(data){
				  console.log(eval(data))
 				  var list = "";
/* 				  $.each(eval(data),function(i,item){
					  list += '<a href="javascript:;">'+item[0].categoryName+'</a>'
					  $('#businessProduct').html(list)
				  })  */
				  element.render('breadcrumb');
			  }
		  }) 
	} 
	function getBrand(categoryIds){
	 	  $.post({//获取主营业务
			  url:'<%=path%>/brand/getBrandList',
			  dataType:'json',
			  data:{categoryIds:categoryIds},
			  success:function(data){
 				  console.log(data)
		 			  var list = "";
 				  $.each(data.data,function(i,item){
					  list += '<a href="javascript:;">'+item.brandName+'</a>'
					  $('#businessBrand').html(list)
				  }) 
				  element.render('breadcrumb');
			  }
		  }) 
	}
	  $.post({//获得图片
		  url:'<%=path%>/merchant/getPicList'
		  ,dataType:'json'
		  ,async:false//同步,赋值给json,否则会找不到
		  ,data:{channelNum:channelNum}
		  ,success:function(result){
			  var businessList = '';
			  var corpIdCardfrontList = '';
			  var corpIdCardreverseList = '';
			  var businessIdCardfrontList = '';
			  var businessIdCardreverseList = '';
			  var panoramaList = '';
			  var gateList = '';
			  var contractList = '';
			  var photoList = '';
				  $.each(result,function(i,data){
					  if(data.picType == 0){
						  businessList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#businessList').html(businessList)
					  }else if(data.picType == 1){
						  corpIdCardfrontList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#corpIdCard-frontList').html(corpIdCardfrontList)
					  }else if(data.picType == 2){
						  corpIdCardreverseList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#corpIdCard-reverseList').html(corpIdCardreverseList)
					  }else if(data.picType == 3){
						  businessIdCardfrontList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#businessIdCard-frontList').html(businessIdCardfrontList)
					  }else if(data.picType == 4){
						  businessIdCardreverseList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#businessIdCard-reverseList').html(businessIdCardreverseList)
					  }else if(data.picType == 5){
						  panoramaList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#panoramaList').html(panoramaList)
					  }else if(data.picType == 6){
						  gateList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#gateList').html(gateList)
					  }else if(data.picType == 7){
						  contractList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#contractList').html(contractList)
					  }else if(data.picType == 8){
						  photoList += '<img alt="" src="<%=path%>/upload/'+data.picSrc+data.picNewName+'">'
			  			$('#photoList').html(photoList)
					  }
				  })
		  }
	  })
 	  //获得url参数
     function getUrlParam(name) {
          var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
          var r = window.location.search.substr(1).match(reg);
          if (r != null) return unescape(r[2]); return null;
      }
	  var isId= $('#imageList li div.layui-carousel')//可以获得id,动态加载
	  var listId= $('#imageList li div[carousel-item]')//可以获得id,动态加载
	   $.each(isId,function(i,data){
	 	  carousel.render({//轮播初始化
			    elem: '#'+data.id
			    ,height:'152'
			    ,width: '312' //设置容器宽度
			    ,arrow: 'always' //始终显示箭头
			    //,anim: 'updown' //切换动画方式
			  });
	 	 $('#'+listId[i].id).on('click',function(){//点击图片出现相册查看
			  layer.photos({
				  photos: '#'+data.id
				  ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
				}); 
		  })
	   })
	});
</script>
</body>
</html>