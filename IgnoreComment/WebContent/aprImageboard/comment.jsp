<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page errorPage="error_view.jsp"%>
<%@ page import="java.sql.Timestamp"%>

<%@ page import = "gallery.Theme" %>
<%@ page import = "gallery.ThemeManager" %>
<%@ page import = "gallery.ThemeManagerException" %>
<%@ page import = "gallery.Comment" %>
<%@ page import = "gallery.CommentManager" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<% 
	request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="cmt" scope="page" class="gallery.Comment">
	<jsp:setProperty name="cmt" property="*"/>
</jsp:useBean>


<%

	CommentManager cm = CommentManager.getInstance();
	cmt.setReg_date(new Timestamp(System.currentTimeMillis()));
	
	cm.insertComment(cmt);
	
	
	System.out.println(cmt.getContent_id());
	System.out.println(cmt.getComment_id());
	System.out.println(cmt.getCommenter());
	System.out.println(cmt.getCommentt());
	System.out.println(cmt.getPassword());
	System.out.println(cmt.getReg_date());
%>

<script>
alert("댓글등록했당");
location.href="list.jsp";
</script>

<%-- 
<%

	String content_num = request.getParameter("content_num");
	String p_num=request.getParameter("p_num");
	String url = "content.jsp?num="+content_num+"&pageNum="+p_num;
	response.sendRedirect(url);

%>
 --%>
