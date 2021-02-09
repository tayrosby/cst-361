package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.WeatherDataModel;

@Path("/weather")
@RequestScoped
@Produces()
@Consumes()
public class WeatherRestService {
	
	//instance of weather manager
	WeatherManager manager = new WeatherManager();

	/**
	 * constructor
	 */
	public WeatherRestService()
	{
	}
	
	@GET
	@Path("/weatherData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * get api data
	 * @return weather list
	 */
	public List<WeatherDataModel> getWeather()
	{
		return manager.getAllWeather();
	}
	
	
}
