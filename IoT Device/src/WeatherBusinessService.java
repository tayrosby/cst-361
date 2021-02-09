import java.util.concurrent.TimeUnit;
/**
 * 
 * @author Victoria Fai and Taylor Rosby
 *
 */
//Cst-361
//2/7/21
//WeatherBusinessService class
//This is the business service that gets a call from the Main class and calls the weather data service
public class WeatherBusinessService {
	private WeatherDataService service = new WeatherDataService();
	/**
	 * this method is called to get to get the api information
	 */
	public void getApiData() {
		//converts an hour to milliseconds
		long milliseconds = TimeUnit.HOURS.toMillis(1);
		
		while (true) {
			//calls the WeatherDataService
			service.getApiData();
			try {
				Thread.sleep(milliseconds);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}
	/**
	 * getter for WeatherDataService
	 * @return it returns the service
	 */
	public WeatherDataService getService() {
		return service;
	}
	/**
	 * setter for WeatherDataService
	 * @param service takes in a WeatherDataService
	 */
	public void setService(WeatherDataService service) {
		this.service = service;
	}
}
