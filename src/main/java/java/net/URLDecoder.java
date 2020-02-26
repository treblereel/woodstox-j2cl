//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package java.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class URLDecoder {
    static String dfltEncName = StandardCharsets.UTF_8.toString();

    public URLDecoder() {
    }

    /** @deprecated */
    @Deprecated
    public static String decode(String s) {
        String str = null;

        try {
            str = decode(s, dfltEncName);
        } catch (UnsupportedEncodingException var3) {
        }

        return str;
    }

    public static String decode(String s, String enc) throws UnsupportedEncodingException {
        boolean needToChange = false;
        int numChars = s.length();
        StringBuffer sb = new StringBuffer(numChars > 500 ? numChars / 2 : numChars);
        int i = 0;
        if (enc.length() == 0) {
            throw new UnsupportedEncodingException("URLDecoder: empty string enc parameter");
        } else {
            byte[] bytes = null;

            while(true) {
                while(i < numChars) {
                    char c = s.charAt(i);
                    switch(c) {
                        case '%':
                            try {
                                if (bytes == null) {
                                    bytes = new byte[(numChars - i) / 3];
                                }

                                int pos = 0;

                                while(i + 2 < numChars && c == '%') {
                                    int v = Integer.parseInt(s.substring(i + 1, i + 3), 16);
                                    if (v < 0) {
                                        throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - negative value");
                                    }

                                    bytes[pos++] = (byte)v;
                                    i += 3;
                                    if (i < numChars) {
                                        c = s.charAt(i);
                                    }
                                }

                                if (i < numChars && c == '%') {
                                    throw new IllegalArgumentException("URLDecoder: Incomplete trailing escape (%) pattern");
                                }

                                sb.append(new String(bytes, 0, pos, enc));
                            } catch (NumberFormatException var10) {
                                throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - " + var10.getMessage());
                            }

                            needToChange = true;
                            break;
                        case '+':
                            sb.append(' ');
                            ++i;
                            needToChange = true;
                            break;
                        default:
                            sb.append(c);
                            ++i;
                    }
                }

                return needToChange ? sb.toString() : s;
            }
        }
    }

}
