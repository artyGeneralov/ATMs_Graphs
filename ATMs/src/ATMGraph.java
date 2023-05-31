import java.util.List;

public class ATMGraph {
	private final double SPEED_IN_CITY = 30.0;
	private final double SPEED_OUT_OF_CITY = 70.0;
	private List<ATM> atms;
	private double[][] graph_times;

	public ATMGraph(List<ATM> atms) {
		this.atms = atms;
		int n = atms.size();
		graph_times = new double[n][n];
		buildGraph();
	}

	public ATMGraph(String path) {
		this(ExcelUtils.listATMS(ExcelUtils.createSheetFromFile(path)));
	}

	private void buildGraph() {
		int n = atms.size();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i == j)
					graph_times[i][j] = 0;
				else {
					ATM atm1 = atms.get(i);
					ATM atm2 = atms.get(j);
					double distance = GeoUtils.getDistance(atm1.getCoord(), atm2.getCoord());
					double speed = atm1.getCityName().equals(atm2.getCityName()) ? SPEED_IN_CITY : SPEED_OUT_OF_CITY;
					graph_times[i][j] = distance / speed;
				}
			}
		
	//
	}

	public double[][] getGraph() {
		return graph_times;
	}

	public List<ATM> getAtms() {
		return atms;
	}

	public void printDistancesGraphAs2D() {
		String s = "";
		int columnWidth = 5;
		String spaces = "";
		for(int i = 0; i < columnWidth; i++)
			spaces += " ";
		for (int i = 0; i < graph_times.length; i++)
			s += String.format("%s%8d", spaces, i+1);
		s += "\n";
		for (int i = 0; i < graph_times.length; i++) {
			s += String.format("%2d",(i + 1));
			for (int j = 0; j < graph_times.length; j++)
				s += String.format("%s%f",spaces, graph_times[i][j]);
			
			s += "\n";
		}

		HebPrinter.print(s);
	}
	
	public void printATMS() {
		String s = "";
		int i = 1;
		for(ATM atm : atms) {
			s+= i++ + " " + atm.toString();
			s+="\n";
		}
		HebPrinter.print(s);
	}
}
