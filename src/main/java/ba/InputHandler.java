package ba;

import java.io.Console;
import java.util.Scanner;

public class InputHandler {

	public void handleEvents() {
		System.out.println("Starting ");
		Console con;

	    con = System.console();

	    if (con == null)
	        throw new RuntimeException("no console");
	    
	    while (true) {
	    	String str = con.readLine(">");
	    	Scanner lineTokenizer = new Scanner(str);
	    	String cmd = null;
	    	while (lineTokenizer.hasNext()) 
	    	{
		    	  String token = lineTokenizer.next();  // consume the valid token
		    	  if (cmd == null)
		    		  cmd = token;
		    	  System.out.println("Token " + token);
		    }
	    	con.printf("Here is your string %s", str);
	    	cmd = null;
	    }
	    
//	    if(true) return;
//		
//		
//		Scanner sc = new Scanner(System.in);
//		 while (sc.hasNextLine()) {
//			 Scanner lineTokenizer = new Scanner(sc.nextLine());
//		      
//		      if (lineTokenizer.hasNext()) {
//		    	  String token = lineTokenizer.next();  // consume the valid token
//		    	  System.out.println("Token " + token);
//		      }
//		}
	}

}
