
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:forward page="template.jsp">
	<jsp:param name="CONTENTPAGE" value="list_view.jsp" />
</jsp:forward>