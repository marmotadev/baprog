package ba;


public class ShipPositions {

	private static char m = ActionSymbols.SEA.getSymbol();
	private static char k = ActionSymbols.SHIP.getSymbol();
	public static final String map1Code = "3c1z,4a2z,1h2,2c5z,1f5,3a7z,1i7z,2cz,1g9,2i4d";
	public static final String map2Code = "3h1d,1a2,1d2,3j3z,1g5,1c6,,2j7z,4a10d,2f10d,2i10d";
	public static final String map3Code = "1d1,1j2,1e4,1h6,3a8d,3e8d,2i8d,4a10d,2f10d,2i10d";
	public static final String map4Code = "1f1,1e4,1h5,1a6,3a8d,3e8d,2i8d,4a10d,2f10d,2i10d";

	public static String[][] ships1={
		{"h2"},
		{"i7"},
		{"g9"},
		{"f5"},
		{"i4","j4"},
		{"c5","c6"},
		{"c8","c9"},
		{"c1","c2","c3"},
		{"a7","a8","a9"},
		{"a2","a3","a4","a5"}
	};

	public static String[][] ships2={
		{"a2"},
		{"d2"},
		{"c6"},
		{"g5"},
		{"f10","g10"},
		{"j7","j8"},
		{"i10","j10"},
		{"j3","j4","j5"},
		{"h1","i1","j1"},
		{"a10","b10","c10","d10"}
	};

	public static String[][] ships3={
		{"d1"},
		{"j1"},
		{"e4"},
		{"h6"},
		{"i8","j8"},
		{"f10","g10"},
		{"i10","j10"},
		{"a8","",""},
		{"","",""},
		{"","","",""}
	};

	public static String[][] ships4={
		{""},
		{""},
		{""},
		{""},
		{"",""},
		{"",""},
		{"",""},
		{"","",""},
		{"","",""},
		{"","","",""}
	};
	public static char[][]map1={
	//   a b c d e f g h i j
		{m,m,k,m,m,m,m,m,m,m}, //1
		{k,m,k,m,m,m,m,k,m,m}, //2
		{k,m,k,m,m,m,m,m,m,m}, //3
		{k,m,m,m,m,m,m,m,k,k}, //4
		{k,m,k,m,m,k,m,m,m,m}, //5
		{m,m,k,m,m,m,m,m,m,m}, //6
		{k,m,m,m,m,m,m,m,k,m}, //7
		{k,m,k,m,m,m,m,m,m,m}, //8
		{k,m,k,m,m,m,k,m,m,m}, //9
		{m,m,m,m,m,m,m,m,m,m}, //10
	};

	public static char[][]map2={
	//   a b c d e f g h i j
		{m,m,m,m,m,m,m,k,k,k}, //1
		{k,m,m,k,m,m,m,m,m,m}, //2
		{m,m,m,m,m,m,m,m,m,k}, //3
		{m,m,m,m,m,m,m,m,m,k}, //4
		{m,m,m,m,m,m,k,m,m,k}, //5
		{m,m,k,m,m,m,m,m,m,m}, //6
		{m,m,m,m,m,m,m,m,m,k}, //7
		{m,m,m,m,m,m,m,m,m,k}, //8
		{m,m,m,m,m,m,m,m,m,m}, //9
		{k,k,k,k,m,k,k,m,k,k}, //10
	};

	public static char[][]map3={
	//   a b c d e f g h i j
		{m,m,m,k,m,m,m,m,m,m}, //1
		{m,m,m,m,m,m,m,m,m,k}, //2
		{m,m,m,m,m,m,m,m,m,m}, //3
		{m,m,m,m,k,m,m,m,m,m}, //4
		{m,m,m,m,m,m,m,m,m,m}, //5
		{m,m,m,m,m,m,m,k,m,m}, //6
		{m,m,m,m,m,m,m,m,m,m}, //7
		{k,k,k,m,k,k,k,m,k,k}, //8
		{m,m,m,m,m,m,m,m,m,m}, //9
		{k,k,k,k,m,k,k,m,k,k}, //10
	};

	public static char[][]map4={
	//   a b c d e f g h i j
		{m,m,m,m,m,k,m,m,m,m}, //1
		{m,m,m,m,m,m,m,m,m,m}, //2
		{m,m,m,m,m,m,m,m,m,m}, //3
		{m,m,m,m,k,m,m,m,m,m}, //4
		{m,m,m,m,m,m,m,k,m,m}, //5
		{k,m,m,m,m,m,m,m,m,m}, //6
		{m,m,m,m,m,m,m,m,m,m}, //7
		{k,k,k,m,k,k,k,m,k,k}, //8
		{m,m,m,m,m,m,m,m,m,m}, //9
		{k,k,k,k,m,k,k,m,k,k}, //10
	};

//	public static char[][]map5={
//	//   a b c d e f g h i j
//		{m,m,m,m,m,m,m,m,m,m}, //1
//		{m,m,m,m,m,m,m,m,m,m}, //2
//		{m,m,m,m,m,m,m,m,m,m}, //3
//		{m,m,m,m,m,m,m,m,m,m}, //4
//		{m,m,m,m,m,m,m,m,m,m}, //5
//		{m,m,m,m,m,m,m,m,m,m}, //6
//		{m,m,m,m,m,m,m,m,m,m}, //7
//		{m,m,m,m,m,m,m,m,m,m}, //8
//		{m,m,m,m,m,m,m,m,m,m}, //9
//		{m,m,m,m,m,m,m,m,m,m}, //10
//	};
//

	public static String getMapCode(int i){
		switch(i){
		case 1:
			return map1Code;
		case 2:
			return map2Code;
		case 3:
			return map3Code;
		case 4:
			return map4Code;
		default: return null;
		}
	}

	public static char[][] getMap(int i){
		switch(i){
		case 1:
			return map1;
		case 2:
			return map2;
		case 3:
			return map3;
		case 4:
			return map4;
		default: return null;
		}
	}

	public static String[][] getShip(int i){
		switch(i){
		case 1:
			return ships1;
		case 2:
			return ships2;
		case 3:
			return ships3;
		case 4:
			return ships4;
		default: return null;
		}
	}
	public static void main(String[] args) {
		char[][] m = map3;
		System.out.println("ABCDEFGHIJ");
		for (int i = 0; i < m.length; i++) {
			for (int ii = 0; ii < m[i].length; ii++) {
				System.out.print(m[i][ii]);
			}
			System.out.println(""+(i+1));
		}
		System.out.println("ABCDEFGHIJ");
	}
}
