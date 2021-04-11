package business;

import beans.Credentials;
import beans.UserModel;

public interface LoginManagerInterface {
	
	/**
	 * logs in a user
	 * @param creds - user email, user password
	 * @return user info
	 */
	boolean loginUser(UserModel creds);

}
