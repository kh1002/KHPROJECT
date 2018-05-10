<%@ page contentType="text/html; charset=euc-kr" %>
<%

    request.setCharacterEncoding("euc-kr");
%>

<jsp:forward page="template.jsp">
   <jsp:param name="CONTENTPAGE" value="read_view.jsp" />
</jsp:forward>