package ba;

import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;

public class FieldMapWriter {

	private static final int LENGTH = 10;
	private static final int TALL = 10;

	private static final String INDENT = "  ";
	private static final String SEPARATING_LINE = "+-+-+-+-+-+-+-+-+-+-+";

	private static String OURS = "OURS";
	private static String THEIRS = "THEIRS";

	private static String TOP_SIDE = "+A+B+C+D+E+F+G+H+I+J+";;

	public static	void
					print(	char[][] ours,
							char theirs[][]) {

		String output = buildMap(ours, theirs);

		PrintWriter pw = new PrintWriter(System.out);
		pw.print(output);
		
		System.out.print(output);
	}

	private static	String
					buildMap(	char[][] ours,
								char[][] theirs) {

		StringBuilder sb = new StringBuilder();

		sb.append(StringUtils.rightPad(OURS, 30, " "))
			.append(StringUtils.rightPad(THEIRS, 30, " "))
			.append("\n")

			.append(StringUtils.rightPad(INDENT + TOP_SIDE, 30, " "))
			.append(StringUtils.rightPad(TOP_SIDE, 30, " "))
			.append("\n")

			.append(StringUtils.rightPad(INDENT + SEPARATING_LINE, 30, " "))
			.append(StringUtils.rightPad(SEPARATING_LINE, 30, " "))
			.append("\n");

		for (int i = 0; i < TALL; i++) {

			StringBuilder sbOurs = new StringBuilder();
			StringBuilder sbTheirs = new StringBuilder();

			sbTheirs.append(StringUtils.rightPad(Integer.toString(i + 1), 2, " "));
			sbOurs.append(StringUtils.rightPad(Integer.toString(i + 1), 2, " "));

			for (int j = 0; j < LENGTH; j++) {
				sbTheirs.append("|")
						.append(ours[i][j]);

				sbOurs.append("|")
						.append(ours[i][j]);
			}

			sbOurs.append("|")
					.append(Integer.toString(i + 1))
					.append(" ");

			sbTheirs.append("|")
					.append(Integer.toString(i + 1))
					.append(" ");

			sb.append(StringUtils.rightPad(sbOurs.toString(), 30, " "))
				.append(StringUtils.rightPad(sbTheirs.toString(), 30, " "))
				.append("\n")
				.append(StringUtils.rightPad(SEPARATING_LINE, 30, " "))
				.append(StringUtils.rightPad(SEPARATING_LINE, 30, " "))
				.append("\n");
		}

		sb.append(StringUtils.rightPad(INDENT + TOP_SIDE, 30, " "))
			.append(StringUtils.rightPad(TOP_SIDE, 30, " "))
			.append("\n");
		return sb.toString();
	}

	public static	void
					main(String[] args) {
		FirldMap map = new FirldMap();
		FieldMapWriter.print(map.getField(), map.getField());
	}

}
