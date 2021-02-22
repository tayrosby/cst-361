package business;

import java.util.List;

import beans.WeatherDataModel;

public interface WeatherManagerInterface {

	/**
	 * gets the weather data
	 * @return - list of weather info
	 */
	int addWeather(WeatherDataModel model);
	List<WeatherDataModel> getAllWeather();
}
