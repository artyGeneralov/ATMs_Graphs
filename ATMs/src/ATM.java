
public class ATM {
	private String bankName, cityName;
	private Coordinate coord;
	
	public ATM(String bankName, String cityName, double x, double y) {
		this.bankName = bankName;
		this.cityName = cityName;
		this.coord = new Coordinate(x, y);
	}

	public String getBankName() {
		return bankName;
	}

	public String getCityName() {
		return cityName;
	}

	public Coordinate getCoord() {
		return coord;
	}
	
	public void printATM() {
		HebPrinter.print(toString());
	}

	public String toString() {
		return String.format("%s\t%s\t%s", bankName, cityName, coord.toString());
	}
	
	
	
}
