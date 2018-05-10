<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	request.setCharacterEncoding("euc-kr");
%>

<jsp:forward page="template.jsp">
	<jsp:param value="updateForm_view.jsp"  name="CONTENTPAGE"/>
</jsp:forward>