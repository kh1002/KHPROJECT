package gallery;

import java.sql.Timestamp;


public class Theme {
	
	private int id;
	private int groupId;
	private int orderNo;
	private int levels;
	private int parentId;
	private Timestamp register;
	private String name;
	private String email;
	private String image;
	private String password;
	private String title;
	private String content;
	
	public int getId() {
		return id;
	}
	public int getGroupId() {
		return groupId;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public int getLevels() {
		return levels;
	}
	public int getParentId() {
		return parentId;
	}
	public Timestamp getRegister() {
		return register;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getImage() {
		return image;
	}
	public String getPassword() {
		return password;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}

	public void setEmail(String value) {
		email = value;
	}
	
	public void setGroupId(int value) {
		groupId = value;
	}
	
	public void setId(int value) {
		id = value;
	}
	
	public void setImage(String value) {
		image = value;
	}
	
	public void setLevels(int value) {
		levels = value;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public void setOrderNo(int value) {
		orderNo = value;	
	}
	
	public void setParentId(int value) {
		parentId = value;
	}
	
	public void setPassword(String value) {
		password = value;
	}
	
	public void setRegister(Timestamp value) {
		register = value;
	}
	
	public void setTitle(String value) {
		title = value;
	}
	
	public void setContent(String value) {
		content = value;
	}
	
	
	
	
}

	
	