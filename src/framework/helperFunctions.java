package framework;
import java.util.Random;
public class helperFunctions {
	
	public String nameGenerator() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	public String codeGenerator() {
		Random r = new Random( System.currentTimeMillis() );
	    int randomValue = ( 1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
		return  String.valueOf(randomValue);
	}
	
	public int  numGenerator() {
		Random rn = new Random();
		return rn.nextInt(6) + 1;
	}
}
