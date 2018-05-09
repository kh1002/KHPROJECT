package hello3.action;

import com.opensymphony.xwork2.ActionSupport;


//ActionSupport Ŭ������ ��ӹ޾� ������ hello�� ����ϴ� HelloWorld Ŭ���� 
public class HelloWorld extends ActionSupport {
	private String name;
	private String msg;
	
	//��ȿ�� �˻�. �׷��� execute()���� ��������� ����. ���ͷ�Ʈ���� ����ç �� �˻����
	public void validate() {
		if(name == null || "".equals(name)) {
			addFieldError("name", "Enter �����̸���");
		}
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception {
		msg = "Hello," +name;
		return SUCCESS;
	}

}
