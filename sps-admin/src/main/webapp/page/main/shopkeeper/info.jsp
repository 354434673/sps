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
    <li lay-id="limitInfo" id="limitInfo" >额度信息</li>
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
			      	<label class="layui-form-label" >城市：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperCity"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >客户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperCustomerid"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >店付业务员姓名：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperSalesmanName"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >店付业务员身份证号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperSalesmanIdcard"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10" >
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >业务类型：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperBusinessType"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >客户来源：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperClientSource"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >默认核心商户编号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperDefaultChannelNum"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >默认核心商户名称：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperDefaultChannelName"> </div>
				    </div>
			    </div>
			  </div>
			  <!-- <table id="gatherList" lay-filter="gatherTables"></table> -->
		<!-- 个人信息开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>个人信息</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >姓名：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalClientName"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >身份证号码：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalIdcard"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >性别：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalSex"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >年龄：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalAge"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10" >
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >婚姻状况：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalMaritalStatus"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >手机号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalPhone"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >户籍地址：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalPlaceofdomicile"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >现居住状况：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalLivingCondition"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class=layui-col-md3>
			      	<label class="layui-form-label" >现居住地址：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="personalLivingAddress"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >是否为法人代表：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id=""> </div>
				    </div>
			    </div>
			 </div>
		<!-- 公司信息开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>公司信息</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >公司名称：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyName"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >店铺名称：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyShopName"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >实际经营地址：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyBusinessAddr"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >法人姓名：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyCorpName"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10" >
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >经营年限(年)：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyOperatioTime"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >经营场地所有权：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyBusinessAddrOwnership"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >经营面积（m2）：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyBusinessArea"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >员工数量(人)：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="companyEmployeeNum"> </div>
				    </div>
			    </div>
			  </div>
		<!-- 业务信息开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>业务信息</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >主营业务：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperProduct"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >主营商品类型：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperCommodityType"> </div>
				    </div>
			    </div>
			  </div>
			  <div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >经营模式：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperBusinessModel"> </div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >主营品牌：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="shopkeeperBrand"> </div>
				    </div>
			    </div>
			  </div>
		<!-- 营业收入开始 -->
<!-- 		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>营业收入</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >月均营业额：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id=""></div>
				    </div>
			    </div>
			  </div> -->
		<!-- 联系人信息开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>联系人信息</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
				<table id="contactList" lay-filter="contactTables"></table>
			  </div>
		<!-- 房产资产开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>房产资产</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >面积：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="houseArea"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >房屋地址：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="houseAddr"> </div>
				    </div>
			    </div>
			  </div>
		
		<!-- 车产资产开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>车产资产</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >车架号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="carChassisNum"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >车牌号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="carPlateNum"> </div>
				    </div>
			    </div>
			  </div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >号牌种类：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="carBrand"></div>
				    </div>
			    </div>
			</div>
		<!-- 还款卡号开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>还款卡号</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >银行卡账号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="repaymentBankid"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >开户银行：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="repaymentDepositBank"> </div>
				    </div>
			    </div>
			  </div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >绑定手机号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="repaymentPhone"></div>
				    </div>
			    </div>
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >服务密码：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="">******</div>
				    </div>
			    </div>
			</div>
		<!-- 征信授权开始 -->
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>征信授权</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >账号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="creditUsername"></div>
				    </div>
			    </div>
			    <div class="layui-col-md9">
			     	<label class="layui-form-label" >密码：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="creditPassword"> </div>
				    </div>
			    </div>
			  </div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >身份验证码：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="creditVerify"></div>
				    </div>
			    </div>
			</div>
		<!-- 账户信息开始 -->
		<div id = "account">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
 			<legend>账户信息</legend>
		</fieldset>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >最低首付比例（%）：</label>
				    <div class="layui-input-inline">
				   	<select name="accountDownPayment"  id="accountDownPayment"> 
						  <option value="">0</option>
						  <option value="10">10</option>
						  <option value="20">20</option>
						  <option value="30">30</option>
						  <option value="40">40</option>
						  <option value="50">50</option>
						  <option value="60">60</option>
						  <option value="70">70</option>
						  <option value="80">80</option>
						  <option value="90">90</option>
				      </select>
				    </div>
			    </div>
			  </div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >账号：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="accountNum"></div>
				    </div>
			    </div>
			</div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >账户开通日期：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="accountStartTime"></div>
				    </div>
			    </div>
			  </div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >账户到期日期：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="accountEndTime"></div>
				    </div>
			    </div>
			</div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >授信有效期：</label>
				    <div class="layui-input-inline">
				    	<div class="layui-form-mid layui-word-aux" id="accountValidity"></div>
				    </div>
			    </div>
			</div>
			<div class="layui-row layui-col-space10">
			    <div class="layui-col-md3">
			      	<label class="layui-form-label" >账户状态：</label>
				    <div class="layui-input-inline">
				    	<select name="accountState" id="accountState"> 
							  <option value="">请选择</option>
							  <option value="1">激活</option>
							  <option value="2">冻结</option>
					      </select>
				    </div>
			    </div>
			</div>
		</div>
			<div class="layui-form-item layui-form-text" id="remakeDiv" style="display: none">
				<fieldset class="layui-elem-field layui-field-title" >
				<legend>说明</legend>
				  </fieldset>
		     	 	<textarea placeholder="请输入拒绝理由" class="layui-textarea" id="remark"></textarea>
	  		</div>
			 	<div class="layui-form-item" align="center" id="update" style="padding-top: 40px;display: none;" >
					<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary">返回</button>
					<button class="layui-btn" lay-filter="sumbit" lay-submit id="submit">提交</button>
				</div>
			 	<div class="layui-form-item" align="center" id="back" style="padding-top: 40px;display: none;" >
					<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary" style="width: 150px">返回</button>
				</div>
			 	<div class="layui-form-item" align="center" id="audit" style="padding-top: 40px;display: none;" >
					<button onclick="javascript:history.back(-1)" class="layui-btn layui-btn-primary">返回</button>
					<button class="layui-btn layui-btn-danger"  id="refuse">拒绝</button>
					<button class="layui-btn" id="agree">同意</button>
				</div>
	</div>
    </div>
    <!-- 额度信息开始 -->
    <div class="layui-tab-item">
				<table id="limitList" lay-filter="limitTables"></table>
    </div>
    <!-- 图片资料开始 -->
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
		   					<p>房本照片</p>
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
		   					<p>行驶证正本照片</p>
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
	layui.use(['form','table','laydate','flow','element','upload','carousel'], function(){
	  var element = layui.element;
	  var form = layui.form;
	  var $ = layui.jquery;
	  var carousel = layui.carousel;
	  var table = layui.table;
	  var laydate = layui.laydate;
	  var flow = layui.flow;
	  var upload = layui.upload;
	  var shopkeeperCustomerid = getUrlParam('shopkeeperCustomerid')
	  form.render(); 
	  flow.lazyimg();
	  var queryType = getUrlParam('queryType')
	  var isUpdate = false;//按钮是否生效,默认不生效,只有入口为修改时才生效
	  var isAudit = false;//按钮是否生效,默认不生效,只有入口为审核时才生效
	  if(queryType == 2){//为2则为审核
		  isAudit = true;
		  $('#audit').show()
		  $('#account').hide()
		  $('#remakeDiv').show()
	  }else if(queryType == 3){//3为修改
		  isUpdate = true;
		  $('#update').show()
	  }else if(queryType == 1){
		  $('#back').show()
	  }
	  //收款信息
	  table.render({
		    elem: '#gatherList'
		    ,url: '<%=path%>/merchant/getGatherList.json' //数据接口
		    ,id:'gather'
		    ,page:true
		    ,limit:5
		    ,limits:[5,10,15]
		    ,cols: [[ //表头
		      {type:'numbers', title: '序号', align:'center'}
		      ,{field: 'gatherBankId', title: '已合作核心商户编号',align:'center'}
		      ,{field: 'gatherOwnerName', title: '已合作核心商户名称',align:'center'}
		    ]]
		  });
	  //联系人信息
	  table.render({
		    elem: '#contactList'
		    ,url: '<%=path%>/shopkeeper/getShopkeeperContact' //数据接口
		    ,where:{shopkeeperCustomerid:shopkeeperCustomerid}
		    ,id:'contactId'
		    ,page:true
		    ,limit:5
		    ,limits:[5,10,15]
		    ,cols: [[ //表头
		      {type:'numbers', title: '序号', align:'center'}
		      ,{field: 'contactName', title: '姓名',align:'center'}
		      ,{field: 'contactPhone', title: '手机号',align:'center'}
		      ,{field: 'contactRelation', title: '关系', align:'center'}
		    ]]
		  });
	  //收款信息
	  table.render({
		    elem: '#limitList'
		    ,url: '<%=path%>/merchant/getGatherList.json' //数据接口
		    ,id:'gather'
		    ,page:true
		    ,limit:5
		    ,limits:[5,10,15]
		    ,cols: [[ //表头
		      {field: 'gatherBankId3', title: '额度类型', align:'center'}
		      ,{field: 'gatherBankId', title: '额度起始日',align:'center'}
		      ,{field: 'gatherOwnerName', title: '额度到期日',align:'center'}
		      ,{field: 'gatherIdcard', title: '总授信额', align:'center'}
		      ,{field: 'gatherBankId1', title: '当前可用额度',align:'center'}
		      ,{field: 'gatherOwnerNam2e', title: '已用额度',align:'center'}
		      ,{field: 'gatherIdcard3', title: '额度状态', align:'center'}
		    ]]
		  });
	  $('#submit').click(function(){
		  	 var accountDownPayment = $('#accountDownPayment').val()
		  	 var accountState = $('#accountState').val()
		  	 
		  	 console.log(accountDownPayment)
		  	 console.log(accountState)
	 		 if(isUpdate){
	 			  $.post({
					  url:'<%=path%>/shopkeeper/updateAccount',
					  dataType:'json',
					  data:{
						  shopkeeperCustomerid:shopkeeperCustomerid,
						  accountDownPayment:accountDownPayment,
						  accountState:accountState
					  },
					  success:function(result){
						  if(result.state == 'success'){
							layer.msg(result.msg,{icon: 1});
						  }else if(result.state == 'error'){
							  layer.msg(result.msg,{icon: 2});
						  }
					  },
					  error:function(){
						  layer.msg('网络错误',{icon: 2});
					  }
				  }) 
	 		 }else{
				  layer.msg('按钮不合法',{icon: 2});
			  }
	  })
	  $('#agree').click(function(){
				  layer.msg('已同意',{icon: 1});
	  })
	  $('#refuse').click(function(){
		  	 var remark = $('#remark').val()
	 		 if(isAudit){
<%-- 	 			  $.post({
					  url:'<%=path%>/shopkeeper/updateAccount',
					  dataType:'json',
					  data:{
						  shopkeeperCustomerid:shopkeeperCustomerid,
						  accountDownPayment:accountDownPayment,
						  accountState:accountState
					  },
					  success:function(result){
						  if(result.state == 'success'){
							layer.msg(result.msg,{icon: 1});
						  }else if(result.state == 'error'){
							  layer.msg(result.msg,{icon: 2});
						  }
					  },
					  error:function(){
						  layer.msg('网络错误',{icon: 2});
					  }
				  })  --%>
				layer.msg('已拒绝',{icon: 2});
	 		 }else if(remark == '' || remark == null){
				  layer.msg('拒绝理由不能为空',{icon: 2});
			 }else{
				  layer.msg('按钮不合法',{icon: 2});
			  }
	  })
	  $.post({//申请信息与业务信息
		  url:'<%=path%>/shopkeeper/getShopkeeper'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#shopkeeperCity').html(result.data.shopkeeperCity)
			  $('#shopkeeperCustomerid').html(result.data.shopkeeperCustomerid)
			  $('#shopkeeperSalesmanName').html(result.data.shopkeeperSalesmanName)
			  $('#shopkeeperSalesmanIdcard').html(result.data.shopkeeperSalesmanIdcard)
			  $('#shopkeeperBusinessType').html(result.data.shopkeeperBusinessType)
			  $('#shopkeeperClientSource').html(result.data.shopkeeperClientSource)
			  $('#shopkeeperDefaultChannelNum').html(result.data.shopkeeperDefaultChannelNum)
			  $('#shopkeeperDefaultChannelName').html(result.data.shopkeeperDefaultChannelName)
			  //业务信息
			  $('#shopkeeperProduct').html(result.data.shopkeeperProduct)
			  $('#shopkeeperCommodityType').html(result.data.shopkeeperCommodityType)
			  $('#shopkeeperBusinessModel').html(result.data.shopkeeperBusinessModel)
			  $('#shopkeeperBrand').html(result.data.shopkeeperBrand)

		  }
	  })
	  $.post({//公司信息
		  url:'<%=path%>/shopkeeper/getShopkeeperCompany'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#companyName').html(result.data.companyName)
			  $('#companyShopName').html(result.data.companyShopName)
			  $('#companyBusinessAddr').html(result.data.companyBusinessAddr)
			  $('#companyCorpName').html(result.data.companyCorpName)
			  $('#companyOperatioTime').html(result.data.companyOperatioTime)
			  $('#companyBusinessArea').html(result.data.companyBusinessArea)
			  $('#companyBusinessAddrOwnership').html(result.data.companyBusinessAddrOwnership)
			  $('#companyEmployeeNum').html(result.data.companyEmployeeNum)
		  }
	  })
	  $.post({//个人信息
		  url:'<%=path%>/shopkeeper/getShopkeeperPersonal'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#personalClientName').html(result.data.personalClientName)
			  $('#personalIdcard').html(result.data.personalIdcard)
			  $('#personalSex').html(result.data.personalSex)
			  $('#personalAge').html(result.data.personalAge)
			  $('#personalMaritalStatus').html(result.data.personalMaritalStatus)
			  $('#personalPhone').html(result.data.personalPhone)
			  $('#personalPlaceofdomicile').html(result.data.personalPlaceofdomicile)
			  $('#personalLivingAddress').html(result.data.personalLivingAddress)
			  $('#personalLivingCondition').html(result.data.personalLivingCondition)
		  }
	  })
	  $.post({//房产
		  url:'<%=path%>/shopkeeper/getShopkeeperHouseProperty'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#houseArea').html(result.data.houseArea)
			  $('#houseAddr').html(result.data.houseAddr)
		  }
	  })
	  $.post({//车产
		  url:'<%=path%>/shopkeeper/getShopkeeperCarProperty'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#carChassisNum').html(result.data.carChassisNum)
			  $('#carPlateNum').html(result.data.carPlateNum)
			  $('#carBrand').html(result.data.carBrand)
		  }
	  })
	  $.post({//还款卡号
		  url:'<%=path%>/shopkeeper/getShopkeeperRepayment'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#repaymentBankid').html(result.data.repaymentBankid)
			  $('#repaymentDepositBank').html(result.data.repaymentDepositBank)
			  $('#repaymentPhone').html(result.data.repaymentPhone)
		  }
	  })
	  $.post({//征信
		  url:'<%=path%>/shopkeeper/getShopkeeperCredit'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#creditUsername').html(result.data.creditUsername)
			  $('#creditPassword').html(result.data.creditPassword)
			  $('#creditVerify').html(result.data.creditVerify)
		  }
	  })
	  $.post({//账户信息
		  url:'<%=path%>/shopkeeper/getShopkeeperAccount'
		  ,dataType:'json'
		  ,data:{shopkeeperCustomerid:shopkeeperCustomerid}
		  ,success:function(result){
			  $('#accountNum').html(result.data.accountNum)
			  var startTime = getDate(result.data.accountStartTime)
			  var endTime = getDate(result.data.accountEndTime)
			  var validity = getDate(result.data.accountValidity)
			  $('#accountStartTime').html(startTime)
			  $('#accountEndTime').html(endTime)
			  $('#accountValidity').html(validity)
			  var accountDownPaymentList = $("#accountDownPayment").find("option"); //获取select下拉框的所有值
			  var accountStateList = $("#accountState").find("option"); //获取select下拉框的所有值
			  getSelect(accountDownPaymentList, result.data.accountDownPayment)
			  getSelect(accountStateList, result.data.accountState)
			  form.render('select');
		  }
	  })
 		  $.post({//获得图片
 			  url:'<%=path%>/merchant/getPicList'
 			  ,dataType:'json'
 			  ,async:false//同步,赋值给json,否则会找不到
 			  ,data:{channelNum:'DF20180134589040'}
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
 		    	  //获得url参数
     function getUrlParam(name) {
          var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
          var r = window.location.search.substr(1).match(reg);
          if (r != null) return unescape(r[2]); return null;
      }
	  function getSelect(numbers, data){
		  for (var j = 1; j < numbers.length; j++) {
			  if ($(numbers[j]).val() == data) {
			  $(numbers[j]).attr("selected", "selected");
			  }
		  } 
	  }
	  //时间格式化
	  function getDate(data){
		    da = new Date(data);
		    var year = da.getFullYear();
		    var month = da.getMonth()+1;
		    var date = da.getDate();
		    var hours = da.getHours();
		    var minutes = da.getMinutes();
		    var seconds = da.getSeconds();
		    return [year,month,date].join('-')+"  "+[hours,minutes,seconds].join(':');
	  }
	});
</script>
</body>
</html>