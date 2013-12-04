package ba;

public class Logic {

	IShootingStrategy shootingStrategy = new BasicShootingStrategy();
	private CombatField combatField = new CombatField();
	private Boolean ourTurn;
	private HitStatus lastShotResult = HitStatus.FIRST;
	private Coordinate ourLastShotTarget;
	private boolean placed = false;
	private int mapNo;

	public void placeShips() {
		mapNo = new Double(Math.random() * 4).intValue();
		System.out.println("placing ships by map " + mapNo);
		char[][] mmm = FieldMap.safeCopymap(ShipPositions.getMap(mapNo));
		combatField.getOurMap().setField(mmm);
		combatField.getEnemyMap().clearMap();
		placed = true;
		print();
		System.out.println(ShipPositions.getMapCode(mapNo));

	}

	private char[][] pickRandomMap() {
		
		return ShipPositions.map1;
	}

	public Boolean getOurTurn() {
		return ourTurn;
	}

	public static void notImplemented() {
		System.out.println("not implemented");
	}

	public void theyShot(Coordinate c) {
		if (getOurTurn() == null) {
			setOurTurn(false);
			System.out.println("Enemy is starting a game");
		}
		HitStatus theirShotResult;
		System.out.println("They shot at " + c);
		System.out.println("Symbol at coordinates : " + combatField.getOurMap().getSymbolAt(c));
		if (combatField.getOurMap().getSymbolAt(c) == ActionSymbols.SEA.getSymbol())
			theirShotResult = HitStatus.MISSED;
		else 
			theirShotResult = HitStatus.HIT;
		
		markTheirShot(theirShotResult, c);
		
		String msg = "";
		switch (theirShotResult) {
		case HIT:
			setOurTurn(false);
			msg = "They hit as!";
			break;
		case SINKED:
			setOurTurn(false);
			msg = "They sank our ship!";
			break;
		case MISSED:
			setOurTurn(true);
			msg = "Enemy missed!";
			break;
			default:
				throw new IllegalStateException("Can't handle: Their status is " + theirShotResult);
		}
		if (getOurTurn())
			shoot();
	}

	private void markTheirShot(HitStatus theirShotResult, Coordinate c) {
		char newSymbol = symbolForHitStatus(theirShotResult);
		combatField.getOurMap().changeSymbolTo(c.getX(), c.getY(), newSymbol);
	}

	public void theyMoved() {
		System.out.println("They moved, we take over turn");
		setOurTurn(true);
		shoot();
	}

	public void last(HitStatus s) {
		switch (s) {
		case MISSED:
			setOurTurn(false);
			break;
		case HIT:
			setOurTurn(true);
			break;
		case SINKED:
			setOurTurn(true);
			break;
		}
		lastShotResult = s;

		char newSymbol = symbolForHitStatus(lastShotResult);
		combatField.getEnemyMap().changeSymbolTo(ourLastShotTarget.getX(),
				ourLastShotTarget.getY(), newSymbol);

		if (getOurTurn())
			shoot();

	}

	// public void enemyShot(ActionSymbols s) {
	// if (ourTurn)
	// throw new IllegalStateException(
	// "Enemy cannot move - it is our turn!");
	// System.out.println("Our last action resulted:" + s);
	// switch (s) {
	// case DEAD:
	// lastShotResult = HitStatus.SINKED;
	// case SEA:
	// lastShotResult = HitStatus.MISSED;
	// case WOUNDED:
	// lastShotResult = HitStatus.HIT;
	// break;
	// default:
	// throw new IllegalArgumentException("Incoorect last shot result" + s);
	// }
	// char newSymbol = symbolForHitStatus(lastShotResult);
	// combatField.getEnemyMap().changeSymbolTo(ourLastShotTarget.getX(),
	// ourLastShotTarget.getY(), newSymbol);
	//
	// }

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
			setOurTurn(true);
		else {
			if (!getOurTurn())
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

	public void setOurTurn(Boolean ourTurn) {
		System.out.println("Changing our turn from " + this.ourTurn + " to " + ourTurn);
		this.ourTurn = ourTurn;
	}

}
