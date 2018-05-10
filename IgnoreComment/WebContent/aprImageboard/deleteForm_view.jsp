<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="gallery.Theme" %>
<%@ page import="gallery.ThemeManager" %>
<%@ page import="gallery.ThemeManagerException" %>

<%   
     String themeId = request.getParameter("id");
     ThemeManager manager = ThemeManager.getInstance();
     Theme theme = manager.select(Integer.parseInt(themeId));
%>
<c:set var="theme" value="<%= theme %>" />
<c:if test="${! empty theme}">
<script language="JavaScript">

function validate(form){
	if(form.password.value ==""){
		alert("암호를 입력하세요.");
		return false;
	}
}

</script>

<form action="delete.jsp" method="post" onSubmit="return validate(this)">
<input type="hidden" name="id" value="${theme.id}">
<table width="100%" border="1" cellpadding="1" cellspacing="0">
<tr>
   <td>제목</td>
   <td>${theme.title}</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${theme.name}</td>
</tr>
<tr>
	<td>암호</td>
	<td><input type="password" name="password" size="10" value=""></td>
</tr>
<c:if test="${!empty theme.image}">
<tr>
	<td>이미지</td>
	<td>
    <img src="/KH10GALLERY/image/${theme.image}" width="150" border="0">
    </td>
</tr>
</c:if>
<tr>
    <td colspan="2">
    <input type="submit" value="삭제">
    <input type="button" value="취소" onClick="javascript:history.go(-1)">
    </td>
</tr>
</table>
</form>
</c:if>

<c:if test="${empty theme}">
글이 존재하지 않습니다.
</c:if>

