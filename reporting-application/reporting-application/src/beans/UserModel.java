package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserModel {
	
	//user attributes
	private String firstName;
	private String lastName;
	
	//user credentials
	private Credentials creds;
	
	/**
	 * constructor
	 */
	public UserModel() {
		this.firstName = "";
		this.lastName = "";
		this.creds = new Credentials();
	}
	
	/**
	 * constructor
	 * @param firstName - user first name
	 * @param lastName - user last name
	 * @param creds - user credentials
	 */
	public UserModel(String firstName, String lastName, Credentials creds) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.creds = creds;
	}

	//getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Credentials getCreds() {
		return creds;
	}

	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
	
	

}
