import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 * @author Victoria Fai and Taylor Rosby
 *
 */
//Cst-361
//2/7/21
//WeatherDataService class
//this class to get the information for the weatherApi 
public class WeatherDataService {
	/**
	 * this method gets the information from the api
	 */
	public void getApiData() {
		//the url used to call the api
		String apiURL = "http://api.openweathermap.org/data/2.5/weather?q=phoenix&units=imperial&APPID=01f66960a55d73ed06c9125fd6610fe2";

		try {
			String result = "";
			//takes the string and turns it into the URL
			URL url = new URL(apiURL);
			//makes the connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//sets the request to a get and make it be returned as json
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			//makes the reader
			InputStreamReader inputReader = new InputStreamReader(connection.getInputStream());
			BufferedReader bufferReader = new BufferedReader(inputReader);
			
			String output;
			//takes the information that was sent and puts it in result
			while ((output = bufferReader.readLine()) != null) {
				result += output;
			}
			//closes the connection
			connection.disconnect();
			
			Object object = null;
			
			try {
				object = new JSONParser().parse(result);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONObject jsonObject = (JSONObject) object;
	
			@SuppressWarnings("unchecked")
			Map<String, Object> main = ((Map<String, Object>) jsonObject.get("main"));
			//gets the results as strings
			String tempStr = main.get("temp").toString();
			String feels_likeStr = main.get("feels_like").toString();
			String temp_minStr = main.get("temp_min").toString();
			String temp_maxStr = main.get("temp_max").toString();
			String pressureStr = main.get("pressure").toString();
			String humidityStr = main.get("humidity").toString();
			//create the weather model
			WeatherModel weather =new WeatherModel();
			//sets the values of the weather from the map
			weather.setTemp(Float.parseFloat(tempStr));
			weather.setFeels_like(Float.parseFloat(feels_likeStr));
			weather.setTemp_min(Float.parseFloat(temp_minStr));
			weather.setTemp_max(Float.parseFloat(temp_maxStr));
			weather.setPressure(Float.parseFloat(pressureStr));
			weather.setHumidity(Float.parseFloat(humidityStr));
			
			System.out.println(weather.toString());
			//calls the post method to send to the web applciation
			//sendApiData(weather);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param weather weather stands for the weather information found from the weather api site 
	 * @throws Exception exception in case a problem occurs.
	 */
	public void sendApiData(WeatherModel weather) throws Exception {
		//takes the weather model and changes it to json
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(weather);

		System.out.println(json);
		//url of the web application
		String webAppURL = "";

		try {
			
			OkHttpClient client = new OkHttpClient();
			//sets the requestBody and makes the request
			RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
			Request request = new Request.Builder().url(webAppURL).post(requestBody).build();
			//makes the call
			Call call = client.newCall(request);
			Response response = call.execute();
			System.out.println("Response code: " + response.code());
			//closes the response
			response.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
