<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<script>
function formSubmit() {
	var forms = document.getElementById("findform");
	
	if((form.MEMBER_NAME.value=="") || (form.MEMBER_NAME.value.length<=1)) {
		alert("�̸��� ��Ȯ�� �Է��� �ֽʽÿ�");
		form.MEMBER_NAME.focus();
		return false		
	}
	else if((form.MEMBER_JUMIN1.value=="") || (form.MEMBER_JUMIN1.value.length<6)) {
		alert("�ֹε�Ϲ�ȣ�� ��Ȯ�� �Է��� �ֽʽÿ�");
		form.MEMBER_JUMIN1.focus();
		return false		
	}
	else if((form.MEMBER_JUMIN2.value=="") || (form.MEMBER_JUMIN2.value.length<7)) {
		alert("�ֹε�Ϲ�ȣ�� ��Ȯ�� �Է��� �ֽʽÿ�");
		form.MEMBER_JUMIN2.focus();
		return false		
	}
	
	return true;
}
</script>
</head>
<body>
<table width="450px" height="20px">
	<tr>
		<td align="left">
			<b>���̵�/��й�ȣ ã��</b>
		</td>
	</tr>
</table>

<form action="./MemberFindAction.me" method="post" name="findform" onSubmit="return formSubmit();">

<table width="450px" cellspacing="0" cellpadding="0" border="0">
<thead>
	<font size="2">
	&nbsp;&nbsp;&nbsp;&nbsp;
	�̸��� �ֹε�Ϲ�ȣ�� ��Ȯ�� �Է����ּ���.
	<br/><br/><br/><br/></font>
</thead>	

<tr>
	<td height="29" bgcolor="#f3f3f3">
		<font size="2">�̸�</font>
	</td>
	<td>
		&nbsp;
		<input type="text" name="MEMBER_NAME" maxlength="12" size="14">
	</td>
</tr>		
<tr>
	<td colspan="2" height="1"></td>
</tr>
<tr>
	<td height="29" bgcolor="#f3f3f3">
		<font size="2">�ֹε�Ϲ�ȣ</font>
	</td>
	<td>
		&nbsp;
		<input type="password" name="MEMBER_JUMIN1" maxlength="6" size="12">-
		<input type="password" name="MEMBER_JUMIN2" maxlength="7" size="12">
	</td>		
</tr>	
<tr>
	<td colspan="2" style="padding:10px 0 20px 0" align="center">
	<input type="submit" value="Ȯ��">
	</td>
</tr>
</table>
</form>
</body>
</html>