package ba;

public class Logic {

	public void placeShips() {
		System.out.println("placing ships");
		notImplemented();

	}

	public static void notImplemented() {
		System.out.println("not implemented");
	}

	public void theyShot(Coordinate c) {
		System.out.println("They shot at " + c);
		notImplemented();
	}

	public void theyMoved() {
		System.out.println("They moved");
		notImplemented();
	}

	public void lastMoveFromEnemy(ActionSymbols s) {
		System.out.println("Our last action resulted:" + s);
		switch (s) {
		case DEAD:
			break;
		case SEA:
			break;
		case WOUNDED:
			break;
		}
		notImplemented();

	}

	public void shoot() {
		System.out.println("Now we shoot");
		notImplemented();
	}

	public void print() {
		notImplemented();
	}

	public void undo() {
		System.out.println("undoing last move");
		notImplemented();
	}

}
