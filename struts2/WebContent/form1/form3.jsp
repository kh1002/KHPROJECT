<%@ page pageEncoding="EUC-KR"%>
<html>
<body>
	<form action = "user3.action">
		�̸� : <input type="text" name="name"/><br>
		�ּ� : <input type="text" name="addr"/><br>
		��ȭ��ȣ : <input type="text" name="tel"/><br>	
		<input type="submit"/>
	</form>
</body>
</html>



<!-- 
<action name="user3" class="login.action.UserAction3">
		<interceptor-ref name="prepare"/> - �ڹٺ�ü ����
		<interceptor-ref name="modelDriven"/> - ��ü�� �޸𸮿������� �׼Ǻ��� �����ִ� ������ �÷��ش�
		<interceptor-ref name="params"/> - �ڹٺ� �������� �����Ѵ�
		<result>/form1/save_ok2.jsp</result>
		<result name="error">/form1/error.jsp</result>
</action>
[�޸𸮿���]
--------
�ڹٺ�ü(���۵Ǵ� ���� �ڹٺ� ����)
--------
�׼�(�������� ���۵Ǵ°��� �׼ǿ��� ��������)
 -->