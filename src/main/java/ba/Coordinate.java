package ba;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {
	private char x;
	private int y;
	private static final Map<String, Integer> coordinateMapping = new HashMap<>();
	static {
		coordinateMapping.put("a", 0);
		coordinateMapping.put("b", 1);
		coordinateMapping.put("c", 2);
		coordinateMapping.put("d", 3);
		coordinateMapping.put("e", 4);
		coordinateMapping.put("f", 5);
		coordinateMapping.put("g", 6);
		coordinateMapping.put("h", 7);
		coordinateMapping.put("i", 8);
		coordinateMapping.put("j", 9);
	}

	public Coordinate(String x, String y) {
		super();
		this.x = x.charAt(0);
		this.y = Integer.parseInt(y);
	}

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

	

}
