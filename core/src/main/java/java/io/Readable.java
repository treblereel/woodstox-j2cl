package java.io;

import java.nio.CharBuffer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/1/20
 */
public interface Readable {
    int read(CharBuffer var1) throws IOException;

}
