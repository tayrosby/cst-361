package util;

import beans.ResponseDataModel;
import beans.ResponseModel;
import beans.WeatherDataModel;
/**
 * 
 * @author Victoria Fai and Taylor Rosby
 *
 */
//Cst-361
//4/4/21
//DTOFactory class
//this is the dto factory that is used with the responsedatamodel
public class DTOFactory {
	//constructor forthe dto
	public DTOFactory() {
		super();
	}
	//what the response model returns
	/**
	 * 
	 * @param status status of the model
	 * @param message message related to what happened. if it worked or not
	 * @param data data that was recieved
	 * @return
	 */
	public static ResponseModel getDTO(int status, String message, Object data) {
		//takes the information and returns it in a responsedatamodel
		return new ResponseDataModel(status, message, data);
	}
}
