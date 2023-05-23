import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class geolocationTest {
	  public static void main(String[] args) {
	        // Replace "YOUR_API_KEY" with your actual API key
	        String apiKey = "YOUR_API_KEY";
	        
	        // Replace "CITY_NAME" with the city you want to retrieve coordinates for
	        String city = "CITY_NAME";
	        
	        // Set up the GeoApiContext
	        GeoApiContext context = new GeoApiContext.Builder()
	                .apiKey(apiKey)
	                .build();
	        
	        try {
	            // Perform the geocoding request
	            GeocodingResult[] results = GeocodingApi.geocode(context, city).await();
	            
	            // Extract the latitude and longitude coordinates from the first result
	            if (results.length > 0) {
	                LatLng location = results[0].geometry.location;
	                double latitude = location.lat;
	                double longitude = location.lng;
	                
	                // Print the latitude and longitude coordinates
	                System.out.println("Latitude: " + latitude);
	                System.out.println("Longitude: " + longitude);
	            } else {
	                System.out.println("No results found.");
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }
}
