package business;

import java.util.List;

import beans.ChartModel;
import beans.WeatherDataModel;

public interface WeatherManagerInterface {

	/**
	 * gets the weather data
	 * @return - list of weather info
	 */
	List<WeatherDataModel> getAllWeather();
	
	/**
	 * adds weather data
	 * @param model
	 * @return - weather model
	 */
	int addWeather(WeatherDataModel model);
	
	/**
	 * gets weather chart
	 * @param model
	 * @return - chart data
	 */
	ChartModel getWeatherChart(ChartModel model);
}
