package data;

import beans.Credentials;
import beans.UserModel;
import beans.WeatherDataModel;

public interface DataAccessInterface {
	
	/**
	 * finds a user based on credentials
	 * @param creds - user email and user password
	 * @return
	 */
	UserModel findUserByCreds(Credentials creds);
	
	/**
	 * creates a user
	 * @param user
	 * @return - user info
	 */
	UserModel createUser(UserModel user);
	int create(WeatherDataModel model);
}
