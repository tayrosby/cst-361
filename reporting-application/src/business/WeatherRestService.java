package business;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.ResponseModel;
import beans.WeatherDataModel;

@ManagedBean
@ViewScoped
@Path("/weather")
//@RequestScoped
//@Produces({ "application/xml", "application/json" })
//@Consumes({ "application/xml", "application/json" })
public class WeatherRestService {
	WeatherManager service = new WeatherManager();
	//weather rest service constructor
	public WeatherRestService()
	{
	}
	@POST
	@Path("/addweatherJ")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	/**
	 * 
	 * @param weather WeatherDataModel is the information from the iot device that's put into the weather model
	 * @return it returns the user response DTO
	 */
	public ResponseModel addWeatherJ(WeatherDataModel weather) {

		System.out.println("In Weather API call from rest service");

		// placeholder for result
		int result = 0;
		
		System.out.println(weather.toString());
		result = service.addWeather(weather);
		ResponseModel response = new ResponseModel();
		if (result == 1) {
			response.setMessage("Weather added"); // if successful, return positive response
			response.setStatus(1);
		}else {
			response.setMessage("Weather not added"); // if successful, return positive response
			response.setStatus(-1);
		}
		return response;
	}
	
	//instance of weather manager
	WeatherManager manager = new WeatherManager();


	
	
}
