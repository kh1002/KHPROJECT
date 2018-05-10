<%-- <%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import = "gallery.Theme" %>
<%@ page import = "gallery.ThemeManager" %>
<%@ page import = "gallery.ThemeManagerException" %>
<%@ page import = "gallery.Comment" %>
<%@ page import = "gallery.CommentManager" %>


<%
    String themeId = request.getParameter("id");
    ThemeManager manager = ThemeManager.getInstance();
    Theme theme = manager.select(Integer.parseInt(themeId));
    CommentManager cmanager = CommentManager.getInstance();
    
    /* 
    ArrayList comments = cmanager.getComments(theme.getId(), startRow, endRow); */
    
%> 

<c:set var="theme" value="<%= theme %>" />
<c:if test="${!empty theme}">


<script language="JavaScript">
function validate(form) {

    if (form.commenter.value == "") {
        alert("이름을 입력하세요.");
        return false;
    } 
    else if (form.password.value == "") {
        alert("암호를 입력하세요.");
        return false;
    } 
    else if (form.commentt.value == "") {
        alert("내용을 입력하세요");
        return false;
    }
}
</script>

<form action="comment.jsp" method="post" onSubmit="return validate(this)">
<table width="100%" border="1" cellpadding="1" cellspacing="0">
<input type="hidden" name="content_id" value="<%=theme.getId() %>">
<input type="hidden" name="comment_id" value="<%=2 %>"> 


<tr>
    <td>작성자</td>
    <td><input type=text name=commenter ></td>
</tr>
<tr> 
    <td>비밀번호</td>
    <td><input type=password name=password></td>
</tr>

<tr>
    <td>내용</td>
    <td>
    <textarea name=commentt cols="40" rows="8"></textarea>
    </td>
</tr>

<tr>
    <td colspan="2">
    <input type="submit" value="댓글작성">
    <input type="button" value="취소" onClick="javascript:history.go(-1)">
    </td>
</tr>
</form>
</table>

<input type="hidden" name="page" value="${param.page}">

 --%>