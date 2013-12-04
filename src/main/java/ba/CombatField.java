package ba;

import java.util.Arrays;

public class CombatField {
	private FieldMap ourMap = new FieldMap();
	private FieldMap enemyMap = new FieldMap();
	
	public FieldMap getOurMap() {
		return ourMap;
	}
	public void setOurMap(FieldMap ourMap) {
		this.ourMap = ourMap;
	}
	public FieldMap getEnemyMap() {
		return enemyMap;
	}
	public void setEnemyMap(FieldMap enemyMap) {
		this.enemyMap = enemyMap;
	}
	
   public void placeOurShips()	
   {
       this.ourMap.setField(ShipPositions.map1);
   }

}
