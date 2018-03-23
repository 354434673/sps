function formatState(flag) {//根据状态返回信息
	if (flag == 1) {
		return '待确认';
	} else if (flag == 2) {
		return '已拒绝';
	} else if (flag == 3) {
		return '订单审核中';
	} else if (flag == 4) {
		return '订单审核不通过';
	} else if (flag == 5) {
		return '待支付';
	} else if (flag == 6) {
		return '待发货';
	} else if (flag == 7) {
		return ' 物流审核中';
	} else if (flag == 8) {
		return '  物流审核不通过';
	} else if (flag == 9) {
		return '已放款';
	} else if (flag == 10) {
		return '已退货';
	} else if (flag == 11) {
		return '已取消';
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