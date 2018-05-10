package hello2.action;

import com.opensymphony.xwork2.Action;

public class HelloWorld implements Action {
	private String name;
	private String msg;
	private String retMsg; //Ŭ���̾�Ʈ�� ���� ���� �޼����� ��� ���� ����
	
	public String getMsg() {
		return msg;
	}
	
	//���۵Ǵ� ���� name������ �������ִ� �޼���
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRetMsg() {
		return retMsg;
	}
	
	//��ȿ���� ���� - �̸����� �Է��Ѱ� ������ �ٽ� �Է¹޵��� ��
	public String execute() throws Exception  {
		if(name == null || "".equals(name)) {
			retMsg = "Enter Name!";
			return INPUT; //�ٽ� �Է¹ް� �ϴ� ���
		}
		msg = "Hello," +name;
		return SUCCESS;
	}

}
