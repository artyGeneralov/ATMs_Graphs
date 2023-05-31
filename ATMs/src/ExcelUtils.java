import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private ExcelUtils() {
		throw new UnsupportedOperationException();
	}

	public static List<ATM> listATMS(Sheet sheet) {
		String[] types = { "Bank_Name", "City", "X_Coordinate", "Y_Coordinate" };
		Row titleRow = sheet.getRow(0);
		ArrayList<Integer> indexes = new ArrayList<>();
		List<ATM> atms = new ArrayList<>();
		int pos = 0;

		// generate list of positions for the titles
		while (pos < types.length) {
			for (Cell c : titleRow) {
				if (c.getStringCellValue().equals(types[pos])) {
					indexes.add(c.getColumnIndex());
					pos++;
					break;
				}
			}
		}

		// generate ATM object while possible
		for (Row r : sheet) {
			if (r.getRowNum() == 0 || r.getRowNum() == 1)
				continue;
			ATM atm = null;
			String name = r.getCell(indexes.get(0)).getStringCellValue();
			String city = r.getCell(indexes.get(1)).getStringCellValue();
			double x = 0.0, y = 0.0;
			try {
				x = Double.valueOf(r.getCell(indexes.get(2)).getStringCellValue());
				y = Double.valueOf(r.getCell(indexes.get(3)).getStringCellValue());
			}catch(NumberFormatException e)
			{
				// when cell is empty exceptions is thrown and ignored
			}

			if (name.isBlank() || city.isBlank() || x == 0.0 || y == 0.0)
				continue;
			else {
				atm = new ATM(name, city, x, y);
				atms.add(atm);
				HebPrinter.print("added: " + atm.getCityName() + "\n");
			}
		}
		return atms;
	}

	public static Sheet createSheetFromFile(String filePath) {
		InputStream inp = null;
		try {
			inp = new FileInputStream(filePath);
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
		return sheet;
	}

}
