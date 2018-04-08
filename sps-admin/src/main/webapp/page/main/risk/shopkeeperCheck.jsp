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
<title>店主审核</title>
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
	<div style="margin: 15px;">
		<div class="layui-form layui-form-pane"  >
		    <div class="layui-form-item">
			    <label class="layui-form-label" style="width: 200px">店主账号:</label>
			    <div class="layui-input-inline">
			      <input id="account" type="text" name="account"  lay-verify="" placeholder="店主账号" autocomplete="off" class="layui-input">
			    </div>
			    <label class="layui-form-label" style="width: 200px" >店主名称:</label>
			    <div class="layui-input-inline">
			      <input id="shopkeeperName" type="text" name="shopkeeperName"  lay-verify="" placeholder="店主名称" autocomplete="off" class="layui-input">
			    </div>
			    	<button class="layui-btn layui-btn-primary" id="queryShopkeeper">查询</button>
			    	<button class="layui-btn layui-btn-primary" id="reset">重置</button>
	        </div>  
		    <div class="layui-form-item">
			    <label class="layui-form-label" style="width: 200px">状态:</label>
			    <div class="layui-input-inline" >
			    <select lay-filter="shopkeeperState" id="shopkeeperState"> 
				  <option value="">全部</option>
				  <option value="1">邀请中</option>
				  <option value="2">待激活</option>
				  <option value="3">运管审核中</option>
				  <option value="4">运管审核不通过</option>
				  <option value="5">风控审核中</option>
				  <option value="6">风控审核不通过</option>
				  <option value="7">已激活</option>
				  <option value="8">冻结</option>
		      	</select>
			    </div>
	        </div>  
        </div>
		<div>
		</div>
		<table id="shopkeeperList" lay-filter="shopkeeperTables" class="layui-fluid"></table>
	</div>
<script type="text/javascript"
		src="<%=path%>/page/static/plugins/layui/layui.all.js"></script>
<script type="text/javascript"
		src="<%=path%>/page/static/datas/area_data.js"></script>
<script type="text/html" id="bar">
 {{#  if(d.shopkeeperState == 6){ }}
  <a class="layui-btn layui-btn-mini" lay-event="edit" >修改</a>
{{#  } }}
  <a class="layui-btn layui-btn-mini" lay-event="detail">详情</a>
 {{#  if(d.shopkeeperState == 5){ }}
  <a class="layui-btn layui-btn-mini layui-btn-danger " lay-event="audit">审核</a>
{{#  } }}
</script>
<!-- 进行数据渲染 -->
<script type="text/html" id="channelTpl">
  {{}}
  {{#  if(d.shopkeeperState == 1){ }}
    	邀请中
  {{#  } else if(d.shopkeeperState == 2){ }}
    	待激活
  {{#  } else if(d.shopkeeperState == 3){ }}
    	运管审核中
  {{#  } else if(d.shopkeeperState == 4){ }}
    	运管审核不通过
  {{#  } else if(d.shopkeeperState == 5){ }}
    	风控审核中
  {{#  } else if(d.shopkeeperState == 6){ }}
    	风控审核不通过
  {{#  } else if(d.shopkeeperState == 7){ }}
    	已激活
  {{#  } else if(d.shopkeeperState == 8){ }}
    	冻结
  {{#  } }}
</script>
<script type="text/html" id="company">
{{d.company.companyShopName}}
</script>
<script type="text/html" id="personal">
{{d.personal.personalClientName}}
</script>
<script type="text/html" id="date">
{{#  
   var da = d.shopkeeperCreatTime;
    da = new Date(da);
    var year = da.getFullYear();
    var month = da.getMonth()+1;
    var date = da.getDate();
    console.log([year,month,date].join('-'));
  var fn = function(){
    return [year,month,date].join('-');
  }; 
}}
{{ fn() }}
</script>
	<script>
	layui.use(['table','layer','form'], function(){
			  var table = layui.table;
			  var layer = layui.layer
			  var form = layui.form
			  var $ = layui.jquery
			  $('#add').on('click', function() {
				  location.href = '<%=path%>/page/main/merchant/addMerchant.jsp'
			  });
			  table.render({
			    elem: '#shopkeeperList'
			    ,url: '<%=path%>/shopkeeper/getShopkeeperList.json' //数据接口
			    ,where:{shopkeeperState:5}
			    ,id:'shopkeeper'
			    ,page:true
			    ,cols: [[ //表头
			      {type:'numbers', title: '序号',align:'center'}
			      ,{field: 'shopkeeperUsername', title: '店主账号',width:230,align:'center'}
			      ,{field: 'personal', title: '店主名称',align:'center',templet: '#personal'}
			      ,{field: 'company', title: '店铺名称',align:'center' ,templet: '#company'}
			      ,{field: 'shopkeeperDefaultChannelNum', title: '默认核心商户名称', width:230, align:'center'}
			      ,{field: 'shopkeeperCreatTime', title: '邀请时间', width:230, align:'center',templet: '#date'}
			      ,{field: 'shopkeeperSalesmanName', title: '店付业务员姓名', width:230, align:'center'}
			      ,{field: 'shopkeeperState', title: '状态', width:140,align:'center',templet: '#channelTpl'} 
			      ,{field: 'tool', title: '操作',width:270,align:'center',toolbar:'#bar'}
			    ]]
			  });
			  //查询
			  $('#queryShopkeeper').on('click',function(){
				  var account = $('#account').val()
				  var shopkeeperName = $('#shopkeeperName').val()
				  var shopkeeperState = $('#shopkeeperState').val()
				  table.reload('shopkeeper', {
					  where: {
						  account:account,
						  shopkeeperName:shopkeeperName,
						  shopkeeperState:shopkeeperState,
						  }
					});
			  })
			  //重置
			  $('#reset').on('click',function(){
				  $('input').val('')
				  $('select').val('');
			  })
			  form.on('select(shopkeeperState)', function(data){
				  table.reload('shopkeeper', {
					  where: {shopkeeperState:data.value}
					}); 
			  });    
			  //监听工作条
				table.on('tool(shopkeeperTables)', function(obj){
					 var data = obj.data;
					 console.log(data.shopkeeperCustomerid)
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的DOM对象
					  if(layEvent === 'detail'){ //查看
						  location.href = '<%=path%>/page/main/risk/info.jsp?queryType=1&shopkeeperCustomerid='+data.shopkeeperCustomerid
					  } else if(layEvent === 'audit'){//审核
						  location.href = '<%=path%>/page/main/risk/info.jsp?queryType=2&shopkeeperCustomerid='+data.shopkeeperCustomerid
					  } else if(layEvent === 'edit'){ //修改
						  location.href = '<%=path%>/page/main/risk/info.jsp?queryType=3&shopkeeperCustomerid='+data.shopkeeperCustomerid
					  }
				});
			});
	</script>
</body>
</html>