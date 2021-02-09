package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Credentials;
import beans.UserModel;
import data.UserDataManager;

@Stateless
@Local(LoginManagerInterface.class)
@LocalBean
public class LoginManager implements LoginManagerInterface {
	
	//instance of the data service
	UserDataManager DAO = new UserDataManager();
	
	/**
	 * constructor
	 */
	public LoginManager() {
		
	}

	/**
	 * passes email and password to data service
	 * returns user info
	 */
	@Override
	public UserModel loginUser(Credentials creds) {
		UserModel user = DAO.findUserByCreds(creds);
		
		return user;
	}

}
