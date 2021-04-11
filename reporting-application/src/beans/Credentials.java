package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class Credentials {
	
	//user credentials
	@NotNull(message =" Email Field can't be empty")
	@Size(min=2, max=50, message = "Please enter an email between 2 and 50 characters.")
	private String email;
	@NotNull(message =" Password Field can't be empty")
	@Size(min=2, max=50, message = "Please enter an Password between 2 and 50 characters.")
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

	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
