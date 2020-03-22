package org.codehaus.stax2.io;

import java.io.*;

/**
 * Simple implementation of {@link Stax2ReferentialResult}, which refers
 * to the specific file.
 */
public class Stax2FileResult
    extends Stax2ReferentialResult
{
    final File mFile;

    public Stax2FileResult(File f) {
        mFile = f;
    }

    /*
    /////////////////////////////////////////
    // Implementation of the Public API
    /////////////////////////////////////////
     */

    @Override
    public Writer constructWriter() throws IOException
    {
        String enc = getEncoding();
        if (enc != null && enc.length() > 0) {
            return new OutputStreamWriter(constructOutputStream(), enc);
        }
        // Sub-optimal; really shouldn't use the platform default encoding
        //return new FileWriter(mFile);
        throw new UnsupportedEncodingException("constructWriter");
    }

    @Override
    public OutputStream constructOutputStream() throws IOException
    {
        throw new UnsupportedEncodingException("constructOutputStream");

        //return new FileOutputStream(mFile);
    }

    /*
    /////////////////////////////////////////
    // Additional API for this Result
    /////////////////////////////////////////
     */

    public File getFile() {
        return mFile;
    }
}
