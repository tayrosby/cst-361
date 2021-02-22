package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDataModel extends ResponseModel{

	/**
	 *
	 */
	private Object data;
	/*
	 * default constructor for responseDataModel
	 */
	public ResponseDataModel() {
		super(0, "");
		this.data = null;
	}
	/**
	 * get the data model
	 * @return
	 */
	public Object getData() {
		return data;
	}
	/*
	 * Non-default constructor for the responseDataModel
	 */
	public ResponseDataModel(int status, String message, Object data) {
		super(status, message);
		this.data = data;
	}
	/**
	 * 
	 * @param data is the data model sent to the iot
	 * 
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
}
