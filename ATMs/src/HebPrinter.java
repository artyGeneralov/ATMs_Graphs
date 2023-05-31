import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class HebPrinter {

	private HebPrinter() {
		throw new UnsupportedOperationException();
	}
	
	public static void print(String s) {
		try {
			PrintStream out = new PrintStream(System.out, true, "UTF-8");
			out.printf("%s", s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
