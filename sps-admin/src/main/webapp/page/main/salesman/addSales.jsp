<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户添加</title>
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
<div style="padding: 20px" >
<h3>业务员信息</h3>
<hr>
<div class="layui-form layui-form-pane" >
	<div >
	  <div class="layui-form-item " id="passwordDiv">
	   <label class="layui-form-label">*姓名：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanName" name="salesmanName" type="text"  lay-verify="required|IsChineseCharacter|max20Length" placeholder="请输入业务员姓名" autocomplete="off" class="layui-input">
	    </div>
	    <label class="layui-form-label">*身份证号：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanIdcard" name="salesmanIdcard" type="text"  lay-verify="required|IsIDCard" placeholder="请确认身份证号码" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">*手机号：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanPhone" type="text" name="salesmanPhone"  lay-verify="required|isPhone|max20Length" placeholder="请输入手机号" autocomplete="off" class="layui-input">
	    </div>
	    <label class="layui-form-label">*电子邮箱：</label>
	    <div class="layui-input-inline">
	      <input id="salesmanEmail" type="text" name="salesmanEmail" lay-verify="required|email" placeholder="请输入电子邮箱" autocomplete="off" class="layui-input">
	    </div>
	  </div>
		  <div class="layui-form-item " >
		    <label class="layui-form-label" >*城市：</label>
		    <div class="layui-input-inline" style="width: 150px">
		      <select name="province" lay-filter="province"  id="province" lay-verify="required"> 
		      </select>
		    </div>
		    <div class="layui-input-inline" style="width: 150px">
		      <select name="city" lay-filter="city"   id="city" lay-verify="required"> 
				  <option value="" >市</option>
		      </select>
		    </div>
		    <div class="layui-input-inline" style="width: 150px">
		      <select name="area" lay-filter="area"   id="area" lay-verify=""> 				  
		      	  <option value="">区</option>
		      </select>
		    </div>
		  </div>
  </div>
 	<div class="layui-form-item" align="center" id="btn" style="padding-top: 40px">
		<button class="layui-btn" lay-filter="submitSalesMan" lay-submit id="submit">提交</button>
		<button style="display: none" class="layui-btn" lay-filter="submitUpdate" lay-submit id="submitUpdate">立即修改</button>
		<button id="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
</div>
</div>

		<script type="text/javascript"
		src="<%=path%>/page/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','table'], function(){
	  var form = layui.form;
	  var $ = layui.jquery;
	  var table = layui.table;
	  getProvince(100000)//先加载省
	  
	  //选择城市
	  form.on('select(province)', function(data){//选省
		  getCity(data.value)
		  $('#area').html('')
	  });    
	  form.on('select(city)', function(data){//选省
		  getArea(data.value)
	  });    
	  $('#resetPasssword').on('click',function(){
		    layer.confirm('确认重置密码?', function(index){
			      layer.close(index);
					$.post({
						url:'<%=path%>/user/updatePassword.html',
						dataType:'json',
						success:function(data){
							layer.msg(data.msg,{icon: data.icon});
						}
					})
			    });
	  })
	  $('#reset').click(function(){
		  $('input').val('')
	  })
	  //添加
	  form.on('submit(submitSalesMan)', function(data){
	 		 var salesmanName = $('#salesmanName').val()
	 		 var salesmanIdcard = $('#salesmanIdcard').val()
	 		 var salesmanPhone = $('#salesmanPhone').val()
	 		 var salesmanEmail = $('#salesmanEmail').val()
	 		 var salesmanCity = $('#province').find("option:selected").text()+
			 			 $('#city').find("option:selected").text()+
			 			$('#area').find("option:selected").text();
		 		 $.post({
		 			 url:'<%=path%>/salesman/insertSalesman',
		 			 dataType:'json',
		 			 data:{
		 			 	salesmanName:salesmanName,
		 			 	salesmanIdcard:salesmanIdcard,
		 			 	salesmanPhone:salesmanPhone,
		 			 	salesmanEmail:salesmanEmail,
		 			 	salesmanCity:salesmanCity,
		 			 	bei1:0
		 			 },
		 			 success:function(data){
		 				 if(data.state == 'success'){
		 					layer.msg(data.msg,{icon: 1});
		 				 }else if(data.state == 'exist'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }else if(data.state == 'error'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }
		 			 }
		 		 })
	  })
	  //修改
	  form.on('submit(submitUpdate)', function(data){
		     var username = $('#username').val()
	 		 var password = $('#password').val()
	 		 var name = $('#name').val()
	 		 var phone = $('#phone').val()
	 		 var email = $('#email').val()
	 		 if(array.length != 0){
		 		 $.post({
		 			 url:'<%=path%>/user/updateUser.html',
		 			 dataType:'json',
		 			 data:{userUsername:username,userPassword:password, 
		 				 userName:name,userPhone:phone, userEmail:email,
		 				 roleList:array
		 			 },
		 			 success:function(data){
		 				 if(data.state == 'success'){
		 					layer.msg(data.msg,{icon: 1});
		 				 }else if(data.state == 'exist'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }else if(data.state == 'error'){
		 					layer.msg(data.msg,{icon: 2});
		 				 }
		 			 }
		 		 }) 
	 		 }else{
	 			layer.msg('请选择该用户权限',{icon: 2});
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
				if(value.length<8 || value.length>12) {
					return '密码为8-12位';
				}
			},
			maxLength: function(value) {
				if(value.length>50) {
					return '最多为50位';
				}
			},
			max20Length: function(value) {
				if(value.length>20) {
					return '最多为20位';
				}
			},
			verify: function(value) {
				var repass = $('#password').val();
				if(value != repass) {
					return '两次输入的密码不一致!';
				}
			},
			isPhone: function(value) {
				var regex = /^1[3|4|5|8][0-9]\d{4,8}$/;
				if(!value.match(regex)) {
					return '手机号格式不正确!';
				}
			},
			
             //验证身份证号 [可验证一代或二代身份证]  
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
						return '请输入正确的身份证';
					}
					return false;
				}
				return '请输入正确的身份证';
			}
	  }); 
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
					  getCity($('#province').val())
			 		  
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
		//获得城市
		 function getCity(parentId){
			$.getJSON({
	 			url:'<%=path%>/getAreasList.json',
	 			 dataType:'json', 
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'">'+item.name+'</option>';
					  $('#city').html(list)
					  getArea($('#city').val())
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
		 
		 //获得区
		 function getArea(parentId){
			$.getJSON({
				url:'<%=path%>/getAreasList.json',
	 			 dataType:'json',
	 			 data:{parentId:parentId},
	 			 success:function(data){
			 		 var list = "";
			 		 $.each(data,function(i,item){
					  list +='<option value="'+item.areaId+'" title="'+item.name+'">'+item.name+'</option>';
					  $('#area').html(list)
				  	})
				  	form.render('select');
	 			 }
	 		 })
		}
	});
</script>
</body>
</html>