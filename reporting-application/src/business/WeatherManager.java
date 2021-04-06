package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartSeries;

import beans.ChartModel;
import beans.WeatherDataModel;
import data.WeatherDataManager;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(WeatherManagerInterface.class)
@LocalBean
public class WeatherManager implements WeatherManagerInterface {
	
	@EJB
	WeatherDataManager service;
	
	private List<WeatherDataModel> weatherList = new ArrayList<WeatherDataModel>();

	/**
	 * gets the weather list
	 * @return - returns the weather list
	 */
	@Override
	public List<WeatherDataModel> getAllWeather() {
		this.weatherList = service.findAllWeather();
		return this.weatherList;
	}
	
	/**
	 * sets the weather list
	 * @param weatherList - list of weather data
	 */
	public void setWeatherList(List<WeatherDataModel> weatherList) {
		this.weatherList = weatherList;
	}
	
	/**
	 * makes a chart
	 * @param model - chart model
	 * @return - returns a chart
	 */
	public ChartModel getWeatherChart(ChartModel model)
	{
		//Create an instance of a WeatherData List
		List<WeatherDataModel> data = new ArrayList<WeatherDataModel>();
		data = getAllWeather();
		
		//Populate The Line Graph
		LineChartSeries series = new LineChartSeries();
		series.setLabel("Temp");
		for(WeatherDataModel weather : data)
		{
			series.set(weather.getTemp(), weather.getFeelsLike());
		}
		
		model.getModel().addSeries(series);
        model.getModel().setTitle("Temp Chart");
        model.getModel().setLegendPosition("e");
        model.getModel().setShowPointLabels(true);
        model.getModel().getAxes().put(AxisType.X, new CategoryAxis("Date"));
        Axis yAxis = model.getModel().getAxis(AxisType.Y);
        yAxis.setLabel("Temp");
        yAxis.setMin(0);
        yAxis.setMax(500);
		
        return model;
	}

	@Override
	public int addWeather(WeatherDataModel model) {
		int result = service.create(model);
		return result;
	}
}
