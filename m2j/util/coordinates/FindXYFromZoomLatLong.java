package m2j.util.coordinates;

public class FindXYFromZoomLatLong {
	public static void main(String[] args) {
		
//		42.682906, -73.700997
		/*double lon = -89.08805;
		double lat = 30.6393;*/
		
	/*	double lon = -73.700997;
		double lat = 42.682906;*/
		
		// London
		/*double lon = -0.135658;
		double lat = 51.497495;*/
		
	//	-2.90082702896922,53.2021219646559
		
		double lon = -2.90082702896922;
		double lat = 53.2021219646559;
		
		double zoom = 18; // 6.5156731549786215 would be possible too

		double lon_rad = Math.toRadians(lon);
		double lat_rad = Math.toRadians(lat);
		double n = Math.pow(2.0, zoom);

		double tileX = (((lon + 180) / 360) * n);
		double tileY =  ((1 - (Math.log(Math.tan(lat_rad) + 1.0 / Math.cos(lat_rad)) / Math.PI)) * n / 2.0);
		

		System.out.println("tileX = " + tileX + " tileY = " + tileY);
	}

}
