public class Main {
	
	static final String path = "atmMod.xlsx";
	public static void main(String[] args) {
		
		ATMGraph atms = new ATMGraph(path);
		atms.printATMS();
		atms.printDistancesGraphAs2D();
		
		
		
		
		
		
		
		
		
		
		/*Coordinate c1 = new Coordinate(31.985005, 34.768893);
		Coordinate c2 = new Coordinate(32.0253, 34.7455);
		double dist = GeoUtils.getDistance(c1, c2);
		System.out.println("Dist = " + dist);*/
		/*InputStream inp = null;
		try {
			inp = new FileInputStream("atm.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inp);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Sheet sheet = wb.getSheetAt(0);
        
        int cityCol = -1;
        Row titleRow = sheet.getRow(0);
        
        for(Cell cell: titleRow)
        	if(cell.getStringCellValue().equals("City")) {
        		cityCol = cell.getColumnIndex();
        		break;
        	}

        Row firstRow = sheet.getRow(1);
        Cell firstCity = firstRow.getCell(cityCol);
        String cityName = firstCity.getStringCellValue();
        String numsName = "";
        
        // print 1 city
        for(int i = 0; i < cityName.length(); i++) {
        	numsName += (int) cityName.charAt(i) + " ";
        }
        
        
        // print all cells
		for(Row row : sheet) {
			for(Cell c : row) {
				
				try {
					PrintStream out = new PrintStream(System.out, true, "UTF-8");
					out.printf("%s\t", c.getStringCellValue());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
			System.out.println();
		}*/
		
		
		

	}
	
	
	
	
	
}
