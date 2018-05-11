<%@ page pageEncoding="EUC-KR"%>
<html>
<body>
	<form action = "fileupload.action" method="post" enctype="multipart/form-data">
		name : <input type="text" name="num1"/><br>
		age : <input type="text" name="num2"/><br>	
		photo : <input type="file" name="doc"/><br>
		<input type="submit"/>
	</form>
</body>
</html>