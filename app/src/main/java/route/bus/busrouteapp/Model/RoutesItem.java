package route.bus.busrouteapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RoutesItem implements Serializable {
	@SerializedName("accessible")
	private boolean accessible;

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("stops")
	private List<StopsItem> stops;

	public void setAccessible(boolean accessible){
		this.accessible = accessible;
	}

	public boolean getAccessible(){
		return accessible;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStops(List<StopsItem> stops){
		this.stops = stops;
	}

	public List<StopsItem> getStops(){
		return stops;
	}

	@Override
 	public String toString(){
		return 
			"RoutesItem{" + 
			"accessible = '" + accessible + '\'' + 
			",image = '" + image + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",stops = '" + stops + '\'' + 
			"}";
		}
}