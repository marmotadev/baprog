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
			while (lineTokenizer.hasNext()) {
				String token = lineTokenizer.next(); // consume the valid token
				if (cmd == null)
					cmd = token;
				else
					params.add(token);
//				System.out.println("Token " + token);
			}
			// con.printf("Here is your string %s", str);
			try {
				handleCommand(cmd, params);
			}
			catch (IllegalArgumentException e)
			{
				System.err.println("Illegal command provided:" + e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Fucked up, try again");
				e.printStackTrace();
			}
			cmd = null;
		}

		// if(true) return;
		//
		//
		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNextLine()) {
		// Scanner lineTokenizer = new Scanner(sc.nextLine());
		//
		// if (lineTokenizer.hasNext()) {
		// String token = lineTokenizer.next(); // consume the valid token
		// System.out.println("Token " + token);
		// }
		// }
	}

	private void handleCommand(String cmd, List<String> params) {
		if (cmd == null) {
			return;
		}
		switch (cmd) {
		case "exit":
			System.exit(0);
			break;
		case "placeships":
			noParamsExpect(params);
			logic.placeShips();
			break;
		case "theymoved":
			logic.theyMoved();
			break;
		case "theyshot":
			// <koordinate>
			expectParams(params, 2, "syntax: theyshot E 5");
			Coordinate c = parseCoords(params);
			logic.theyShot(c);
			break;
		case "last":
			expectParams(params, 1, "syntax: last  <hit|empty|dead>");
			ActionSymbols s = parseSymbol(params.get(0));
			logic.ourLastActionResult(s);
			break;
		case "shoot":
			logic.shoot();
			break;
		case "print":
			logic.print();
			break;
		case "undo":
			logic.undo();
			break;
		default:
			System.err.println("Did not understand command");
		}
			

	}

	private ActionSymbols parseSymbol(String string) {
		switch (string) {
		case "hit":
			return ActionSymbols.WOUNDED;

		case "empty":
			return ActionSymbols.SEA;

		case "dead":
			return ActionSymbols.SHOT;
		default:
			throw new IllegalArgumentException(string);
		}
	}

	private Coordinate parseCoords(List<String> params) {
		return new Coordinate(params.get(0), params.get(1));
	}

	private void expectParams(List<String> params, int i, String msg) {
		if (params.size() != i) {
			throw new IllegalArgumentException("Expected param count: " + i + ", " + msg);
		}
	}

	private void noParamsExpect(List<String> params) {
		if (params.size() > 0) {
			throw new IllegalArgumentException("No parameters expected! Reenter command!");
		}

	}

}
