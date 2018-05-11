<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>파일 업로드</title>
</head>
<body>

	<h2>다중 파일 업로드 입력 완료 (리스트)</h2>
	
	<table border="1">
	<!-- iterator은 반복문과 비슷한 역할을 함 -->
	<s:iterator value="uploads" status="stat"> 
	<tr>
		<td> File<s:property value="%{#stat.index}"/></td>
		<td><s:property value="%{uploads[#stat.index]}"/></td>
	</tr>
	</s:iterator>
	</table>
	
	<br>
	
	<table border="1">
	<s:iterator value="uploadsFileName" status="stat">
	<tr>
		<td>File Name <s:property value="%{#stat.index}"/></td>
		<td><s:property value="%{uploadsFileName[#stat.index]}"/></td>
	</tr>
	</s:iterator>
	</table>
	
	</br>
	
	<table border="1">
	<s:iterator value="uploadsContentType" status="stat">
	<tr>
		<td>Content Type <s:property value="%{#stat.index}"/></td>
		<td><s:property value="%{uploadsContentType[#stat.index]}"/></td>
	</tr>
	</s:iterator>
	</table>
	

</body>
</html>