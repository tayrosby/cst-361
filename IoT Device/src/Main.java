
/**
 * 
 * @author Victoria Fai and Taylor Rosby
 *
 */
//Cst-361
//2/7/21
//Main class
//this class is used to run the console program
public class Main {

	private static WeatherBusinessService service = new WeatherBusinessService();
	//method called to start the console and to call the WeatherBusinessService
	public static void main(String[] args) {

		while(true) {
			try {
					service.getApiData();
				} catch (IllegalMonitorStateException e) {
					e.printStackTrace();
			}
		}

	}
	/**
	 * the getter for the WeatherBusinessService
	 * @return it returns the WeatherBusinssService
	 */
	public WeatherBusinessService getService() {
		return service;
	}
	/**
	 * the setter for the WeatherBusinessService
	 * @param service
	 */
	public static void setService(WeatherBusinessService service) {
		Main.service = service;
	}

}


