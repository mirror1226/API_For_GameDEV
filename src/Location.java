
public class Location {
	private double latitude;
	private double longitude;
	
	public Location(double lat, double lng) {
		latitude = lat;
		longitude = lng;
	}
	
	public double GetLat() {
		return latitude;
	}
	
	public double GetLng() {
		return longitude;
	}

}
