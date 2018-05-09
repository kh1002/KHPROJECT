package hello1.action;

//POJO 클래스를 이용해 만드는  Hello출력
//Action 인터페이스를 상속받지않음

public class HelloWorld {
	private String name;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception {
		msg = "Hello," +name;
		return "success";
	}
}
