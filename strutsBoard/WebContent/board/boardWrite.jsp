<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>스트러츠2 게시판</title>
	<link rel="stylesheet" href="/strutsBoard/board/common/css/css.css" type="text/css">
	
	<script type="text/javascript">
		function validation() {
			var frm = document.forms(0);
			
			if(frm.subject.value == "") {
				alert("제목을 입력해주세요.");
				return false;
			}
			else if(frm.name.value == "") {
				alert("이름을 입력해주세요.");
				return false;
			}
			else if(frm.password.value == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			else if(frm.content.value == "") {
				alert("내용을 입력해주세요.");
				return false;
			}
			
			return true;
		}
		
	</script>
</head>


<body>
	<table width="600" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center"><h2>스트러츠2 게시판</h2></td>
		</tr>
	</table>
	
	<s:if test="resultClass == NULL">
		<form action="writeAction.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
	</s:if>	
	
	<s:else>
		<form action="modifyAction.action" method="post" enctype="multipart/form-data">
		<s:hidden name="no" value="%{resultClass.no}"/>
		<s:hidden name="currentPage" value="%{currentPage}"/>
		<s:hidden name="old_file" value="%{resultClass.file_savname}"/>
	</s:else>
	
	<table width="600" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="right" colspan="2">
				<font color="#ff0000">*</font>는 필수 입력사항입니다.
			</td>
		</tr>
		<tr  bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
<!-- 제목칸을 나타내는 소스코드 -->		
		<tr>
			<td width="100" bgcolor="#f4f4f4"><font color="#ff0000">*</font> 제목</td>
			<td width="500" bgcolor="#ffffff">
				<s:textfield name="subject" theme="simple" value="%{resultClass.subject}"
							 cssStyle="width:370px" maxlength="50"/>
			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
<!-- 이름칸을 나타내는 소스코드 -->		
		<tr>
			<td bgcolor="#f4f4f4"><font color="#ff0000">*</font> 이름</td>
			<td bgcolor="#ffffff">
				<s:textfield name="name" theme="simple" value="%{resultClass.name}"
							 cssStyle="width:100px" maxlength="20"/>
			</td>
		</tr>
		<tr  bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
<!-- 비밀번호칸을 나타내는 소스코드 -->		
		<tr>
			<td bgcolor="#f4f4f4"><font color="#ff0000">*</font> 비밀번호</td>
			<td bgcolor="#ffffff">
				<s:textfield name="password" theme="simple" value="%{resultClass.password}"
							 cssStyle="width:100px" maxlength="20"/>
			</td>
		</tr>
		<tr  bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
<!-- 내용칸을 나타내는 소스코드 -->		
		<tr>
			<td bgcolor="#f4f4f4"><font color="#ff0000">*</font> 내용</td>
			<td bgcolor="#ffffff">
				<s:textarea name="content" theme="simple" value="%{resultClass.content}" 
							cols="50" rows="10"/>
			</td>
		</tr>
		<tr  bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
<!-- 첨부파일칸을 나타내는 소스코드 -->		
		<tr>
			<td bgcolor="#f4f4f4"> 첨부파일</td>
			<td bgcolor="#ffffff">
				<s:file name="upload" theme="simple"/> 
					
				<s:if test="resultClass.file_orgname != NULL" > <!-- 파일첨부가 되어있으면 수행-->
					&nbsp; * <s:property value="resultClass.file_orgname" />
					파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
				</s:if>			
			</td>
		</tr>
		<tr  bgcolor="#777777">
			<td height="1" colspan="2"></td>
		</tr>
		
		 <tr>
          <td height="10" colspan="2"></td>
        </tr>
		
<!-- 버튼들 나타내는 소스코드 -->
		<tr>
			<td align="right" colspan="2">
				<input name="submit" type="submit" value="작성완료" class="inputb">
				<input name="list" type="button" value="목록" class="inputb"
						onclick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage"/>'">
			</td>
		</tr>
	</table> 
</form>
</body>
</html>