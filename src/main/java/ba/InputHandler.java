package ba;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputHandler {

	private Logic logic;

	public InputHandler(Logic logic) {
		this.logic = logic;
	}

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
	    	List<String> params = new ArrayList<String>();
	    	while (lineTokenizer.hasNext()) 
	    	{
		    	  String token = lineTokenizer.next();  // consume the valid token
		    	  if (cmd == null)
		    		  cmd = token;
		    	  else
		    		  params.add(token);
		    	  System.out.println("Token " + token);
		    }
//	    	con.printf("Here is your string %s", str);
	    	handleCommand(cmd, params);
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

	private void handleCommand(String cmd, List<String> params) {
		switch (cmd) {
			case "exit":
				System.exit(0);
			break;
			case "placeships":
				noParamsExpect(params);
				break;
			case "theymoved":
				break;
			case "theyshot":
				//<koordinate>
				break;
			case "last":
				//<hit|empty|dead>
				break;
			case "shoot":

				break;
			case "print":

				break;
			case "undo":
				//
				break;
				
		}
		
	}

	private boolean noParamsExpect(List<String> params) {
		if (params.size() > 0){
			System.out.println("No parameters expected! Reenter command!");
			return false;
		}
		return true;
		
	}

}
