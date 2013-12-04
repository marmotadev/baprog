package ba;

public enum ActionSymbols {
	SEA('~'), SHIP('#'), WOUNDED('x'), DEAD('X'), SHOT('*'), MOVED('?'), BORDER('|');

	private char code;

	private ActionSymbols(char c) {
		code = c;
	}

	public char getSymbol() {
		return code;
	}
}
