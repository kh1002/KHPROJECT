package hello2.action;

import com.opensymphony.xwork2.Action;

public class HelloWorld implements Action {
	private String name;
	private String msg;
	private String retMsg; //클라이언트로 보낼 오류 메세지를 담기 위한 변수
	
	public String getMsg() {
		return msg;
	}
	
	//전송되는 값을 name변수에 설정해주는 메서드
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRetMsg() {
		return retMsg;
	}
	
	//유효성을 검증 - 이름으로 입력한게 없으면 다시 입력받도록 함
	public String execute() throws Exception  {
		if(name == null || "".equals(name)) {
			retMsg = "Enter Name!";
			return INPUT; //다시 입력받게 하는 상수
		}
		msg = "Hello," +name;
		return SUCCESS;
	}

}
