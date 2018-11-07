<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>注册界面</title>
</head>
<body>
		<form action="regist.do" method="post">
		名字<input type="text" name="userName"  value="" />
		密码<input type="password" name="pwd"  value="" />
		再次输入密码<input type="password" name="rePwd" id="" value="" />
		<div>${mesg}</div>
		<input type="submit"  name="注册" />
		</form>
</body>
</html>