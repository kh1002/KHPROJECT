<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>파일 업로드</title>
</head>
<body>
	<h2>다중 파일 업로드 입력 폼 (리스트)</h2>
	
	<s:form action="multiUploadListAction" method="post" enctype="multipart/form-data">
		<s:file label="File (1)" name="uploads"/>
		<s:file label="File (2)" name="uploads"/>
		<s:file label="File (3)" name="uploads"/>
		<s:submit/>
	</s:form>

</body>
</html>


<!-- /multiUploadListForm.action 로 실행 후 결과확인 -->