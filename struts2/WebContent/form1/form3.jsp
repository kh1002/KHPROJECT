<%@ page pageEncoding="EUC-KR"%>
<html>
<body>
	<form action = "user3.action">
		이름 : <input type="text" name="name"/><br>
		주소 : <input type="text" name="addr"/><br>
		전화번호 : <input type="text" name="tel"/><br>	
		<input type="submit"/>
	</form>
</body>
</html>



<!-- 
<action name="user3" class="login.action.UserAction3">
		<interceptor-ref name="prepare"/> - 자바빈객체 생성
		<interceptor-ref name="modelDriven"/> - 객체를 메모리영역에서 액션보다 위에있는 영역에 올려준다
		<interceptor-ref name="params"/> - 자바빈 변수들을 세팅한다
		<result>/form1/save_ok2.jsp</result>
		<result name="error">/form1/error.jsp</result>
</action>
[메모리영역]
--------
자바빈객체(전송되는 값은 자바빈에 설정)
--------
액션(기존에는 전송되는값은 액션에서 설정했음)
 -->