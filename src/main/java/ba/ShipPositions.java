package ba;


public class ShipPositions {

	private static char m = ActionSymbols.SEA.getSymbol();
	private static char k = ActionSymbols.SHIP.getSymbol();
	public static final String map1Code = "3c1z,4a2z,1h2,2c5z,1f5,3a7z,1i7z,2cz,1g9";
	public static final String map2Code = "3h1d,1a2,1d2,3j3z,1g5,1c6,,2j7z,4a10d,2f10d,2i10d";
	public static final String map3Code = "1d1,1j2,1e4,1h6,3a8d,3e8d,2i8d,4a10d,2f10d,2i10d";
	public static final String map4Code = "1f1,1e4,1h5,1a6,3a8d,3e8d,2i8d,4a10d,2f10d,2i10d";

	public static char[][]map1={
	//   a b c d e f g h i j
		{m,m,k,m,m,m,m,m,m,m}, //1
		{k,m,k,m,m,m,m,k,m,m}, //2
		{k,m,k,m,m,m,m,m,m,m}, //3
		{k,m,m,m,m,m,m,m,m,m}, //4
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


	public static void main(String[] args) {
		char[][] m = map4;
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
