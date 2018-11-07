<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript">
	function changeImageCode(){
		 var url = "imageCode.do?a="+new Date().getMilliseconds();  
		    $("img").attr("src",url);
	}
	
</script>
</head>
<body>
	<div>${mesg}</div>
	<form action="login.do" method="post">
		<input type="text" name="userName"/>
		<input type="password" name="pwd"/>
		验证码：<input type="text" name="userCode">
		<img alt="验证码" src="imageCode.do"  onclick="changeImageCode()">
		<input type="submit" value="提交" />
	</form>
	
	<p><a href="initRegist.do">没有账号？立即注册</a></p>
</body>
</html>