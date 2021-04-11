package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class UserModel {
	
	//user attributes
	@NotNull(message = "First name field can't be empty")
	@Size(min=2, max=50, message = "Please enter an First Name between 2 and 50 characters.")
	private String firstName;
	@NotNull(message = "Last name field can't be empty")
	@Size(min=2, max=50, message = "Please enter an Last Name between 2 and 50 characters.")
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

	@Override
	public String toString() {
		return "UserModel [firstName=" + firstName + ", lastName=" + lastName + ", creds=" + creds.toString() + "]";
	}
	
	

}
