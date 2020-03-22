package java.net;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 2/25/20
 */
public class URLConnection {

    public URLConnection openConnection() throws IOException {
        throw new UnsupportedOperationException();
    }

    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException("protocol doesn't support output");
    }

}
