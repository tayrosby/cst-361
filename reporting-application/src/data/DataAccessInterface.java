package data;

import java.util.List;

import beans.Credentials;
import beans.UserModel;
import beans.WeatherDataModel;

public interface DataAccessInterface {
	
	/**
	 * finds a user based on credentials
	 * @param creds - user email and user password
	 * @return
	 */
	boolean findUserByCreds(Credentials creds);
	
	/**
	 * creates a user
	 * @param user
	 * @return - user info
	 */
	boolean createUser(UserModel user);
	
	/**
	 * creates a weather model
	 * @param model
	 * @return - weather model
	 */
	int create(WeatherDataModel model);

	/**
	 * finds all weather data
	 * @return - list of weather data
	 */
	List<WeatherDataModel> findAllWeather();

}
