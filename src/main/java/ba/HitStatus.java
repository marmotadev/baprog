

package ba;

/**
 *
 * @author tlapinskas
 */
public enum HitStatus {
    MISSED(0),
    HIT(1),
    SINKED(2),
    FIRST(9);

    private int code;

	private HitStatus(int c) {
		code = c;
	}

    public int getStatus() {
		return code;
	}

}
