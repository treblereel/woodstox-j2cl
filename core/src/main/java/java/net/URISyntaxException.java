//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package java.net;

public class URISyntaxException extends Exception {
    private static final long serialVersionUID = 2137979680897488891L;
    private String input;
    private int index;

    public URISyntaxException(String input, String reason, int index) {
        super(reason);
        if (input != null && reason != null) {
            if (index < -1) {
                throw new IllegalArgumentException();
            } else {
                this.input = input;
                this.index = index;
            }
        } else {
            throw new NullPointerException();
        }
    }

    public URISyntaxException(String input, String reason) {
        this(input, reason, -1);
    }

    public String getInput() {
        return this.input;
    }

    public String getReason() {
        return super.getMessage();
    }

    public int getIndex() {
        return this.index;
    }

    public String getMessage() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getReason());
        if (this.index > -1) {
            sb.append(" at index ");
            sb.append(this.index);
        }

        sb.append(": ");
        sb.append(this.input);
        return sb.toString();
    }
}
