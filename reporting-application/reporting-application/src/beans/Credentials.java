package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Credentials {
	
	//user credentials
	private String email;
	private String password;

	/**
	 * constructor
	 */
	public Credentials() {
		this.email = "";
		this.password = "";
	}
	
	/**
	 * constructor
	 * @param email - user email
	 * @param password - user password
	 */
	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
	}

	//getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
