package ba;

import java.util.HashMap;

public class Coordinate {
	private String x;
	private String y;
	
	public Coordinate(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	public int getMapX() {
//		Map<String> m = new HashMap<>();
//		m.
		return 0;
		
	}
	public int getMapY() {
		return Integer.parseInt(y);
	}
	

}
