package java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 2/25/20
 */
public class URL {

    public URL(String spec) throws MalformedURLException {
        throw new UnsupportedOperationException("URL");
    }

    public URL(URL context, String spec) throws MalformedURLException {
        throw new UnsupportedOperationException("URL");
    }

    public URL(String protocol, String host, String file) throws MalformedURLException {
        throw new UnsupportedOperationException("URL");
    }

    public String getPath() {
        throw new UnsupportedOperationException("getPath");
    }

    public String getProtocol() {
        throw new UnsupportedOperationException("getProtocol");
    }

    public String toExternalForm() {
        throw new UnsupportedOperationException("toExternalForm");
    }

    public String getHost() {
        throw new UnsupportedOperationException("getHost");
    }

    public String getFile() {
        throw new UnsupportedOperationException("getFile");
    }

    public String getRef() {
        throw new UnsupportedOperationException("getRef");
    }

    public URLConnection openConnection() throws IOException {
        throw new UnsupportedOperationException("openStream");
    }

    public final InputStream openStream() throws IOException {
        throw new UnsupportedOperationException("openStream");
    }
}
