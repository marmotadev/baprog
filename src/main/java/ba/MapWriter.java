package ba;

public class MapWriter {

	private static final int TALL = 10;
	private static final int LENGTH = 10;

	private static String OURS = "OURS";
	private static String THEIRS = "THEIRS";

	private static String HEADER = "";
	private static String FOOTER = "";

	public static void print(char[][] ours, char theirs[][]) {

		StringBuilder sb = new StringBuilder();

		StringBuilder sbOurs = new StringBuilder();
		StringBuilder sbTheirs = new StringBuilder();

		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < TALL; j++) {
				sbOurs.append(ours[i]);
			}
		}

	}
}
