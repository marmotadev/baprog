package ba;


public class Logic {

	IShootingStrategy shootingStrategy = new BasicShootingStrategy();
	private CombatField combatField = new CombatField();
	private Boolean ourTurn;
	private HitStatus lastShotResult = HitStatus.FIRST;
	private Coordinate ourLastShotTarget;
	private boolean placed = false;

	public void placeShips() {
		System.out.println("placing ships");
		char[][] mmm = FieldMap.safeCopymap(ShipPositions.map1);
		combatField.getOurMap().setField(mmm);
		combatField.getEnemyMap().clearMap();
		placed = true;
		print();

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

	public void last(HitStatus s) {
		lastShotResult = s;

		char newSymbol = symbolForHitStatus(lastShotResult);
		combatField.getEnemyMap().changeSymbolTo(ourLastShotTarget.getX(),
				ourLastShotTarget.getY(), newSymbol);
		
		if (ourTurn)
			shoot();

	}

//	public void enemyShot(ActionSymbols s) {
//		if (ourTurn)
//			throw new IllegalStateException(
//					"Enemy cannot move - it is our turn!");
//		System.out.println("Our last action resulted:" + s);
//		switch (s) {
//		case DEAD:
//			lastShotResult = HitStatus.SINKED;
//		case SEA:
//			lastShotResult = HitStatus.MISSED;
//		case WOUNDED:
//			lastShotResult = HitStatus.HIT;
//			break;
//		default:
//			throw new IllegalArgumentException("Incoorect last shot result" + s);
//		}
//		char newSymbol = symbolForHitStatus(lastShotResult);
//		combatField.getEnemyMap().changeSymbolTo(ourLastShotTarget.getX(),
//				ourLastShotTarget.getY(), newSymbol);
//
//	}

	private char symbolForHitStatus(HitStatus lastShotResult2) {
		switch (lastShotResult2) {
		case HIT:
			return ActionSymbols.WOUNDED.getSymbol();
		case MISSED:
			return ActionSymbols.SHOT.getSymbol();
		case SINKED:
			return ActionSymbols.DEAD.getSymbol();
		default:
			throw new IllegalArgumentException("Incoorect last shot result"
					+ lastShotResult2);
		}
	}

	public void ourActionResult() {

	}

	public void shoot() {
		System.out.println("Now we shoot");
		if (getOurTurn() == null)
			ourTurn = true;
		else {
			if (!ourTurn)
				throw new IllegalStateException(
						"Cannot shoot - it is not our turn!");
		}
		String target = shootingStrategy.shoot(combatField, lastShotResult);
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
		FieldMapWriter.print(combatField.getOurMap().getField(), combatField
				.getEnemyMap().getField());
	}

	public void undo() {
		System.out.println("undoing last move");
		notImplemented();
	}

}
