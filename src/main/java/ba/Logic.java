package ba;

public class Logic {

	IShootingStrategy shootingStrategy = new BasicShootingStrategy();
	private CombatField combatField = new CombatField();
	private Boolean ourTurn;
	private HitStatus lastShotResult = HitStatus.FIRST;
	private Coordinate ourLastShotTarget;

	public void placeShips() {
		System.out.println("placing ships");
		notImplemented();

	}

	public Boolean getOurTurn() {
		return ourTurn;
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
			lastShotResult = HitStatus.SINKED;
		case SEA:
			lastShotResult = HitStatus.MISSED;
		case WOUNDED:
			lastShotResult = HitStatus.HIT;
			break;
		default:
			throw new IllegalArgumentException("Incoorect last shot result" + s);
		}
	}

	public void shoot() {
		System.out.println("Now we shoot");
		if (getOurTurn() == null)
			ourTurn = false;
		else {
			if (!ourTurn)
				throw new IllegalStateException(
						"Cannot shoot - it is not our turn!");
		}
		String target = shootingStrategy.shoot(lastShotResult);
		if (target.equalsIgnoreCase(IShootingStrategy.NONE)) {
			throw new IllegalStateException("We've got nowhere to shoot - NONE");
		}
		ourLastShotTarget = parseTargetFromStrategy(target);
		System.out.println("We've shot at " + ourLastShotTarget);
	}

	private Coordinate parseTargetFromStrategy(String target) {
		String x = target.substring(0, 1);
		String y = target.substring(1);
		Coordinate targetCoord = new Coordinate(x, y);
		return targetCoord;
	}

	public void print() {
		notImplemented();
	}

	public void undo() {
		System.out.println("undoing last move");
		notImplemented();
	}

}
