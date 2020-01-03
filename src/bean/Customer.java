package bean;

import java.io.Serializable;

public class Customer implements Serializable {
	// field
	private int id;
	private String login;
	private String password;
	// setter-getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
