<%@ page pageEncoding="EUC-KR"%>
<html>
<body>
	<form action = "add.action">
		<input type="text" name="num1"/><br>
		<input type="text" name="num2"/><br>	
		<input type="submit"/>
	</form>
</body>
</html>


<!-- 
18번 staticParams예제를 추가했기 때문에 input폼에 아무것도 입력 안해도
struts.xml에서 설정한 값으로 덧셈기능을 동작한다.
-->