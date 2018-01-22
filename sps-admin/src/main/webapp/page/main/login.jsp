<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6"><![endif]-->
<!--[if IE 7 ]><html class="ie ie7"><![endif]-->
<!--[if IE 8 ]><html class="ie ie8"><![endif]-->
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="standard">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0, minimal-ui" />
<meta name="format-detection" content="email=no" />
<meta name="format-detection" content="address=no" />
<meta name="format-detection" content="telephone=no" />
<meta name="copyright" content="Copyright (c) juzifenqi.com" />
<!-- for Twitter -->
<meta name="twitter:card" content="juzifenqi">
<meta name="twitter:site" content="@juzifenqi">
<meta name="twitter:creator" content="@juzifenqi">
<title>系统登录</title>
<meta name="keywords" content="系统登录">
<meta name="description" content="系统登录">
<link rel="shortcut icon" href="<%=path%>/page/static/images/1514199484(1).png" type="image/x-icon" >
<style type="text/css">
@charset "utf-8";

body, dl, dd, h1, h2, h3, h4, p {
	margin: 0;
	padding: 0;
}

html, body {
	height: 100%;
	overflow: hidden;
}

body, input, button, textarea, select, option, label {
	font-family: Tahoma, Arial, Roboto, "Droid Sans", "Helvetica Neue",
		"Droid Sans Fallback", "Heiti SC", "Hiragino Sans GB",
		'\5FAE\8F6F\96C5\9ED1', '\5B8B\4F53,\9ED1\4F53', sans-self;
	font-size: 14px;
	color: #696969;
}

img, a, a:active, a:focus {
	border: none;
	outline: none;
}

img {
	vertical-align: top;
}

ol, ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

em, i, b, strong {
	font-size: 100%;
	font-style: normal;
	font-weight: normal;
}

button::-moz-focus-inner, input::-moz-focus-inner {
	padding: 0;
	border: 0;
}

input, button, textarea, select, label, form {
	margin: 0;
	padding: 0;
	border: none;
	font-size: 100%;
	outline: none;
}

input, select {
	vertical-align: middle;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

.clearfix:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
	font-size: 0;
}

.clearfix {
	zoom: 1;
}

a {
	text-decoration: none;
	color: #4090d6;
}

h1 {
	display: none;
}

.jzfq-login-bg {
	background: #3083cc;
	background: -webkit-radial-gradient(center, #92d1f8, #3083cc);
	background-image: radial-gradient(center, #92d1f8, #3083cc);
}

.logo {
	display: block;
	width: 309px;
	height: 32px;
	position: absolute;
	z-index: 99;
	top: 20px;
	left: 20px;
	-webkit-animation: jzfqLogo .6s linear both;
	animation: jzfqLogo .6s linear both;
}

@
keyframes jzfqLogo {from { opacity:0;
	transform: scale(0, 0);
}

to {
	opacity: 1;
	transform: scale(1, 1);
}

}
.data-img-content {
	width: 600px;
	height: 310px;
	position: absolute;
	z-index: 1001;
	top: 50%;
	left: 50%;
	margin: -155px 0 0 -500px;
	-webkit-animation: imgContent .6s linear both;
	animation: imgContent .6s linear both;
}

@
keyframes imgContent {from { opacity:0;
	transform: translate3d(-200px, 0, 0);
}

to {
	opacity: 1;
	transform: translate3d(0, 0, 0);
}

}
.cont-img {
	display: block;
	padding-top: 10px;
	text-align: center;
}

.cont-img img {
	vertical-align: top;
}

.data-img-content p {
	padding-top: 10px;
	line-height: 170%;
	font-size: 16px;
	color: #fff;
	text-align: center
}

.login-form-main {
	width: 280px;
	height: 320px;
	padding: 0 20px;
	background: #fff;
	background: rgba(255, 255, 255, .8);
	border-radius: 6px;
	position: absolute;
	z-index: 1000;
	top: 50%;
	left: 50%;
	margin: -160px 0 0 160px;
	-webkit-animation: formMain .6s linear both;
	animation: formMain .6s linear both;
}

@
keyframes formMain {from { opacity:0;
	transform: translate3d(200px, 0, 0);
}

to {
	opacity: 1;
	transform: translate3d(0, 0, 0);
}

}
.login-aperture-box {
	display: block;
	width: 500px;
	height: 500px;
	position: absolute;
	z-index: 112;
	top: 50%;
	left: 50%;
	margin: -250px 0 0 -450px;
	border-radius: 50%;
}

.login-aperture {
	opacity: 0;
	width: 496px;
	height: 496px;
	border: 2px solid #fff;
	position: absolute;
	z-index: 111;
	top: 0;
	left: 0;
	border-radius: 50%;
}

@
keyframes rippleAni {from { opacity:.8;
	transform: scale(0, 0);
}

to {
	opacity: 0;
	transform: scale(1, 1);
}

}
.login-title {
	display: block;
	height: 40px;
	line-height: 40px;
	padding-top: 16px;
	font-size: 18px;
	color: #333;
	font-weight: 100;
}

.input-list {
	padding-top: 10px;
}

.input-list li {
	width: 280px;
	height: 42px;
	padding-bottom: 12px;
	position: relative;
	float: left;
}

.login-inpt {
	width: 266px;
	height: 28px;
	line-height: 28px;
	padding: 6px;
	border: 1px solid #92d1f8;
	border-radius: 4px;
	background: #fff;
	font-size: 14px;
	color: #666;
}

.login-inpt.wa {
	width: 106px;
}

.login-inpt.add-error {
	border-color: #0f6ac5;
	background: #fff2e5;
	box-shadow: 0 0 8px 0 #ccc inset;
}

.login-submit {
	width: 280px;
	height: 46px;
	line-height: 46px;
	background: #ef8833;
	border-radius: 6px;
	font-size: 16px;
	color: #fff;
	cursor: pointer;
}

.login-submit:hover {
	background: #ea822d;
}

#code {
	display: block;
	width: 144px;
	height: 40px;
	line-height: 40px;
	background: #fff;
	position: absolute;
	z-index: 98;
	top: 0;
	right: 0;
	border: 1px solid #92d1f8;
	border-radius: 6px;
	text-align: center;
}

#code img {
	width: 90%;
	max-height: 44px;
	margin: 0 5%;
	vertical-align: middle;
}

#systemTips {
	width: 300px;
	line-height: 150%;
	padding: 20px;
	box-sizing: border-box;
	background: rgba(0, 0, 0, .8);
	border: 1px solid #333;
	border-radius: 4px;
	position: absolute;
	z-index: 999999;
	top: 50%;
	left: 50%;
	transform: translateY(-50%);
	margin-left: -170px;
	font-size: 16px;
	text-align: center;
	color: #fff;
}
</style>
</head>
<body class="jzfq-login-bg">
	<h1>桔子分期-专注于年轻人分期购物</h1>
	<a class="logo" href="javascript:;"><img
		src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAATUAAAAgCAMAAABErR+qAAAApVBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+4/eNVAAAANnRSTlMAQL+AD+/Q3yCfMGBw+I+wUBwLt8vzlFlFCNjFpplL5xN6gyerBG0zaId0Oysj4zfrF4xju1REg7PsAAAJDklEQVRo3ryXe1vaMBSHT5Im6Y22U1QGKggKXhAv09/3/2jzhLRpmA62Pc/ef9ombRLennNC6f9TSEmenE8PIyFHKoh6T+dEJFRBOzRElSyI+OaqaijAzX9BmQmKGeklOZ6e76jlfuCw8xl1LA03+faEmMy+0OPmlB+uByfZIx2AAsgjgOgXxVTUozaCjcNQhwCEG08SSXi4w6AgCUUlFF8oCnAzCfQRYeqvps8Bk1DELc7JcYZjapnDY9Nu3egz/sZtU6xJYNguRD/+izWJGEmBBlDOGsR+awKG9SQaKRFQ7LcmERNPn1joNAp5Wr/ieE3fV/laQa7XqwU5HheLxWN6tulMlhjcf2s5mzrV+RTFegnzcmNwvHgyOD/UmkIEMYXqoYGK+uu2xLRHiocgiUwIUfqRDFIJVbGhFCgFk0bWhIdP+1NbSOUJsmugIaawfk0FmHmGjkvqsT7BipijDW4p8AQs6BKek1voGTee/LW1mKQGMgrUgGjjq/rcmupiNxVlIwwykYmcGngUd7jmvB/iXfAGq4ygQAWU5MjawG3sCQab+9fp84ZPPg4j6nOMH8QsgCizLQoaTQE7tBhMlq7e3AC0B4ktRjAlIBwUk1ugjEUr2lk4peU2jDIYEazFOmW4UF2HFIBq8daSDKJnLdFWkKcILzAxbareKEy/8ZF+oOZDjPTWkvo0jhizJpptMBcVDK2wGY1GBQaHWpO/1LVYkm4oUPD9YeEofqlrX1tzqcvlMI2sBbw1DdmzpoC0q0zIom2hW2NDR6uH9RyT/OkhLugN9HdyPBRnHc2C6IhNG7+2B2zRtIdcCMkBln9tLbWASSlQRTtYrlttAp54N2BqaFiVECWACvN4Kz7WJCwf0taC8P3eYSgVLrdFo1QldRv1E2BMV+j40CbOGsf71QDDy+YsJ/o2QJ9s5ordGOZtjAk9YDCZyOFBdc0Cua+/mU+V4CguXUwqO2lBW5b81loGyQ1aJQVQ8512xxr5IPU4UZnv9wod+IR8G3TAXWOG9fX1df02rmc0wi4vdHT6ZnByvMUA4xe2ZvHanDpr0x+3xdVea34+ncR7vYisxdfSOwqkxoki0dY1Sf09lPt1IuFqVu3iv4TcZ40jOvX9qe56LFo0/4VTqgSMC2ZYYE300Fw2ly4/F2/DLZNnYDMZDs/dsi8xIc9o497M9zGYyUEZGso5B08le+ScAy2uyHtStlwKxCSVTX5T1yR07hqESrexoVAFa2kTj+cFpZB5ay1D3pZUwSRx0S1pCeB0NKe1BKNV/FqvYW6Iia2xJk6rMY5PJSStMHh7O54cEGuJBpChph0UPsMVGRKIMNy2dWSklHbXWm5SSgrFRhvYChVJlJ01C9V8Zo3y/h5KX5JY2xBgkfE5bHZxcQ1cUZ+jaUiXpmeNDN4pudV4vTyFFSOM2TEGtA8FAyTaJAdaYxLxgYQRok3IeDeIrTna95IVOSzBx05eagClgnUjbUfM+x9UGnbnk0rswtFydbvE+ccBwyP64B0nM+pTY9mlJYbUMcQZFWiZO2uz/dZSrRVAKqfIzZd1LWBRUVyN4rrm4awKv75I3IPQoUgZwUPEI0l8gu/FLr3v0Az35HjGE/UZ4508Ze87dQEsKL24uDs/z+YX83dn7eWQf7mVcnf9qbUcaCJrcV3T8HBDPHIJIGvTU3NTjSztYi2nL2Ptd9ZKtnbnI3o1QEo97kLsraYh7B7N1uCIXV8JWmHMJxjvr2ppZ015kQdZy6Db22tyVKata1rmgAp7qBDaXVoUbs52QNFsJzNQKoqoAPfHRKsJNeD+Zztmupw2DEXhI7xvGBsMGDCYsENTtuS8/6PVEmpNMpmSkk7/0G9YNJcrLH/4Mr7iXP2Uo95rK3R0A77vFt2KBnmGIu9mHOYAklPRnR9ofZNBi3uMaWPHQb5uy+QbeE3cZc2v0+tBTUiKq3My6AAIaJla+FsrpPiytSU9AK8ZFS9HSEa8EIW4kJDtpG73GytULCba2or2keQJt/DNu6yZtjYAODR+tRmBEJeXkNT3Ij/bIx++xVALZ3htRZCmob/FuNfacTlTRXc2ptNpCxe+GZunivNznd+Holwa01CP0V8vkC4FFus+guken+Auax4Zan+kqDM93XbHtK/OyfdIOmT8Uzgt/8pKkw6+Yu2fcr810ya9upN36003T/3Fmy5p6Kl1+0jGrt6msKuc+mAOm1+2tgj2eEMe+MBrscSHtF7/mjWnobDqhZpSSPjeWmApaUJSjR1oYlW1rsXYI11ZsU3ysodkk5RPTwpvyRzbB0wp2hCqW9BHd25bew8kZtTFGxI+IeD30QIfYQ/wRX5z5+HqgIsrmjqjwQtBXbUt/X3KavizpYtVwIWoFOh9Jd+ShgM1PaYjJ2nutIbxM9IUyNPqkeZ5FUgWI+4APCcAUiAxUVEeUX263+FC6eq3hUpKS+Bo/pG1hqFwrhZqU9JETb1DGL5r+YTV1NXoepartwUCVcS23kVpQagI4Mt5rpRkmnYAGPR0p3HbWihqQm0t7YSIh0BzsJjz4Ey26PRCMluVDSsbpZi/eDz0gA2jrj3FKL7MKkh7p6KTMcTAm0SnjVz0bVwhlDxDQBHIgcave+Ua36z7Khc1V3kC13yU5L4NucLVi/Fxja/jNfV69CJ0QXr4HgFtmv11L2LryMIfclvak/2YIwzprSMLPc57HXZxiHR5bM4Z8zWLns2kz8NyyM46i/AgJCwwmABzlsCWW8zYxYlI+CLGFtFQRtN2ZKpPnAkqUnaA1TIfOMCK4Y5P2HKMNvEgJOwqazFTbLkBvlWBguWKnXm7OMO2pFFzGAH5L2sJY+kuzTpyfBLc4okC8QNZK2BHaTnJZBUixUxZO5acA+Mt7EwZbbKPkE1pbbFKF4dDCSNLRnzGmmPBKZ7Yf6Br7UgPGzrDKJuRTuf7yGcBaeOJc48FHAJt5m7GhsUTDhH6XKJH54VDzDKrzQ7GNLBhH42HsZZzhDwctcTWDKbGZnM2jR360xx4nccBECyB8RTwu4WIPARruKcVIIo4WACzUzvMkRg+fKOUeY/BuGAXn4Vz/EdS0J7hk+SDR7mWbvADNJS0qjlgHIoAAAAASUVORK5CYII="
		alt="桔子分期-数据平台" title="桔子分期-数据平台" /></a>
	<div class="data-img-content clearfix">
		<span class="cont-img"><img
			src="data:image/png;base64,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"
			alt="桔子分期-数据平台" /></span>
		<p>
			统一对内的数据服务，保障数据准确、准时、震撼，有效的传达数据的意义<br />助力公司业务发展，让业务更清晰，让决策更高效
		</p>
	</div>
	<div class="login-form-main">
		<form id="loginForm" action="javascript:;" target="_self">
			<h2 class="login-title">用户登录</h2>
			<ul class="input-list">
				<li><input type="text" class="login-inpt add-error"
					name="userName" placeholder="请输入用户名" /></li>
				<li><input type="password" class="login-inpt" name="password"
					placeholder="请输入密码" /></li>
				<li style="display: none"><input  value="1" type="text" class="login-inpt wa" name="code"
					placeholder="验证码" /><span id="code">验证码</span></li>
				<li><input type="submit" class="login-submit" value="登录" /></li>
			</ul>
		</form>
	</div>
	<div class="login-aperture-box" id="loginApertureBox">
		<div class="login-aperture"></div>
		<div class="login-aperture"></div>
		<div class="login-aperture"></div>
		<div class="login-aperture"></div>
		<div class="login-aperture"></div>
	</div>
	<script type="text/javascript">
	if (window != top) {
			alert('会话超时,请重新登陆')
			top.location.href = location.href;  
	} 
!function(ROOT, callback) {
    var testStyle = document.createElement("div").style, camelCase = function(a) {
        return a.replace(/^-ms-/, "ms-").replace(/-([a-z]|[0-9])/gi, function(a, b) {
            return (b + "").toUpperCase();
        });
    }, cssVendor = function() {
        var a = testStyle, b = [ "-o-", "-webkit-", "-moz-", "-ms-", "" ], c = 0;
        do {
            if (camelCase(b[c] + "transform") in a) {
                return b[c];
            }
        } while (++c < b.length);
        return "";
    }(), transitionend = function() {
        return {
            "-o-":"otransitionend",
            "-webkit-":"webkitTransitionEnd",
            "-moz-":"transitionend",
            "-ms-":"MSTransitionEnd transitionend",
            "":"transitionend"
        }[cssVendor];
    }(), isCSS3 = function(a) {
        var b = testStyle, c = camelCase(a), d = camelCase(cssVendor + a);
        return c in b && c || d in b && d || "";
    }, newFunction = new Function();
    newFunction.fn = newFunction.prototype = {
        constructor:newFunction,
        init:function(a, b, c, d, e) {
            this.animation(), this.bindEvent(a, b, c, d, e);
        },
        animation:function() {
            var a, b, c = isCSS3("animation");
            if (c) {
                for (a = document.querySelectorAll("#loginApertureBox .login-aperture"), b = 0; b < a.length; b++) {
                    a[b].style.animation = "rippleAni " + 2 * a.length + "s ease " + 2 * b + "s normal none infinite";
                }
            } else {
                document.getElementById("loginApertureBox").style.display = "none";
            }
        },
        ajax:function(opts) {
            var key, str, oXhr, k, defaults = {
                type:"GET",
                url:"",
                data:"",
                dataType:"json",
                async:!0,
                cache:!0,
                contentType:"application/x-www-form-urlencoded;charset=utf-8",
                success:function() {},
                error:function() {}
            };
            for (key in opts) {
                defaults[key] = opts[key];
            }
            if ("object" == typeof defaults.data) {
                str = "";
                for (key in defaults.data) {
                    str += key + "=" + defaults.data[key] + "&";
                }
                defaults.data = str.substring(0, str.length - 1);
            }
            if (defaults["type "] = defaults.type.toUpperCase(), defaults.cache = defaults.cache ? "" :"&" + new Date().getTime(), 
            "GET" === defaults.type && (defaults.data || defaults.cache) && (defaults.url += "?" + defaults.data + defaults.cache), 
            oXhr = window.XMLHttpRequest ? new XMLHttpRequest() :new ActiveXObject("Microsoft.XMLHTTP"), 
            oXhr.open(defaults.type, defaults.url, defaults.async), defaults.headers) {
                for (k in defaults.headers) {
                    oXhr.setRequestHeader(k, defaults.headers[k]);
                }
            }
            "GET" === defaults.type ? oXhr.send(null) :(oXhr.setRequestHeader("Content-type", defaults.contentType), 
            oXhr.send(defaults.data)), "undefined" != typeof defaults.setToken && "function" == typeof defaults.setToken && defaults.setToken(oXhr), 
            oXhr.onreadystatechange = function() {
                if (4 === oXhr.readyState) {
                    if (200 === oXhr.status) {
                        if ("function" == typeof defaults.success) {
                            if ("json" == defaults.dataType) {
                                try {
                                    defaults.success.call(oXhr, eval("(" + oXhr.responseText + ")"));
                                } catch (e) {}
                            } else {
                                try {
                                    defaults.success.call(oXhr, oXhr.responseText);
                                } catch (e) {}
                            }
                        }
                    } else {
                        "function" == typeof defaults.error && defaults.error();
                    }
                }
            };
        },
        tips: function(txt){
            if(txt && txt != ''){
                var tout = null;
                var createDiv = document.createElement('div');
                createDiv.id = 'systemTips';
                createDiv.innerHTML = txt.toString() || '';
                document.querySelectorAll('body')[0].appendChild(createDiv);
                tout = setTimeout(function(){
                    var getSystemTips = document.getElementById('systemTips');
                    if(getSystemTips.parentNode){
                        getSystemTips.parentNode.removeChild(getSystemTips);
                        clearTimeout(tout);
                    }
                },2000);
            }
        },
        bindEvent:function(a, b) {
            var c = this;
            document.getElementById("loginForm").addEventListener("submit", function() {
                function d(a) {
                    for (var b = 0; b < e.length; b++) {
                        e[b].classList.remove("add-error");
                    }
                    "undefined" != typeof a && (e[a].classList.add("add-error"), e[a].focus());
                }
                var e = document.querySelectorAll(".login-inpt");
                return "" == e[0].value ? (d(0), !1) :"" == e[1].value ? (d(1), !1) :e[1].value.length < 6 ? (d(1), 
                !1) :"" == e[2].value ? (d(2), !1) :(d(), c.ajax({
                    url:a,
                    type:b,
                    dataType:"json",
                    data:{
                        user:e[0].value,
                        pass:e[1].value,
                        code:e[2].value
                    },
                    success:function(data) {
                        /* ajax 提交成功-操作跳转 */
                        if(data == 'success'){
                            c.tips('登录成功！跳转中...');
                            setTimeout(function(){
                                location.href = "<%=path%>/page/main/index.jsp";
                            },1000);
                        }else if(data == 'inexistence'){
                        	c.tips("用户名或密码错误")
                            //c.tips(data.msg);
                        }
                    },
                    error:function() {
                    	c.tips("异常,请联系管理员")
                        console.log("ajax error");
                    }
                }), void 0);
            }, !1);
        }
    }, ROOT.sysLogin = newFunction.fn, "function" == typeof callback && callback.call(this, ROOT.sysLogin);
}(window, function() {
    return window.sysLogin;
});
document.addEventListener('DOMContentLoaded',function(){
    sysLogin.init('<%=path%>/user/userLogin','post','userName','password','code');
},false);
</script>
</body>
</html>