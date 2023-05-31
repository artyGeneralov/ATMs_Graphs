
public class Coordinate {

	private double x, y;
	private static final double EARTH_R = 6371.0;

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Coordinate get() {
		return this;
	}

	public double[] getAsArray() {
		return new double[] { this.x, this.y };
	}
	
	public double distanceFrom(Coordinate c) {
		return GeoUtils.getDistance(this, c);
	}
	
	public String toString(){
		return String.format("(%f,%f)", x,y);
	}
}
