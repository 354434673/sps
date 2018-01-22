<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shiro login</title>
</head>
<body>
<form action="${ctx }/login/auth" method="post">
用 户 名:<input type="text" name="loginname" /><br/>
密 码:<input type="text" name="password" /><br/>
验 证 码（暂可不输入）:<input type="text" name="captcha" /><img src="${ctx }/genCaptcha" /><br/>
<input type="submit" value="登录" />
</form>
</body>
</html>