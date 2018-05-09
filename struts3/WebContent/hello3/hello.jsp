<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

 <h2>${fieldErrors.name}</h2>
<form action=/struts2/hello3/hello.action>
Input Your Name : <input type=text name=name>
<input type="submit">
</form>

</body>
</html>