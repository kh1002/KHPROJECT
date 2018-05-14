<%@ page  pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<s:form action="checkbox">
	<s:checkbox name="male" value="true" label="남성"/>
	<s:checkbox name="female" value="false" label="여성"/>
	<s:submit/>
</s:form>


</body>
</html>