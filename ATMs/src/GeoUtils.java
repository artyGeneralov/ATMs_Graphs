
public class GeoUtils {
	private static final double EARTH_R = 6371.0;

	private GeoUtils() {
		throw new UnsupportedOperationException();
	}

	public static double getDistance(Coordinate c1, Coordinate c2) {

		double long1 = c1.getX();
		double long2 = c2.getX();
		double lat1 = c1.getY();
		double lat2 = c2.getY();

		double latDistance = Math.toRadians(lat2 - lat1);
		double longDistance = Math.toRadians(long2 - long1);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_R * c;
	}
}
