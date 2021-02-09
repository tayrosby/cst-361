package beans;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;


@ManagedBean
@ViewScoped
public class ChartModel {
	
	//model for line graph
	private LineChartModel model;
	
	/**
	 * constructor
	 */
	public ChartModel()
	{
		this.model = new LineChartModel();
	}
	
	//getters and setters
	public LineChartModel getModel()
	{
		return this.model;
	}
	
	public void setModel(LineChartModel model)
	{
		this.model = model;
	}
}
