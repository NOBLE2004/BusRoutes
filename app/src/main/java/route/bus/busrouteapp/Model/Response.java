package route.bus.busrouteapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Response{

	@SerializedName("routes")
	private List<RoutesItem> routes;

	public void setRoutes(List<RoutesItem> routes){
		this.routes = routes;
	}

	public List<RoutesItem> getRoutes(){
		return routes;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"routes = '" + routes + '\'' + 
			"}";
		}
}