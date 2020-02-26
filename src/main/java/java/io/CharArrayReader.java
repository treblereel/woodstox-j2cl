//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package java.io;

public class CharArrayReader extends Reader {
    protected char[] buf;
    protected int pos;
    protected int markedPos = 0;
    protected int count;

    public CharArrayReader(char[] buf) {
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }

    public CharArrayReader(char[] buf, int offset, int length) {
        if (offset >= 0 && offset <= buf.length && length >= 0 && offset + length >= 0) {
            this.buf = buf;
            this.pos = offset;
            this.count = Math.min(offset + length, buf.length);
            this.markedPos = offset;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void ensureOpen() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream closed");
        }
    }

    public int read() throws IOException {
            this.ensureOpen();
            return this.pos >= this.count ? -1 : this.buf[this.pos++];
    }

    public int read(char[] b, int off, int len) {
            if (off >= 0 && off <= b.length && len >= 0 && off + len <= b.length && off + len >= 0) {
                if (len == 0) {
                    return 0;
                } else if (this.pos >= this.count) {
                    return -1;
                } else {
                    int avail = this.count - this.pos;
                    if (len > avail) {
                        len = avail;
                    }

                    if (len <= 0) {
                        return 0;
                    } else {
                        System.arraycopy(this.buf, this.pos, b, off, len);
                        this.pos += len;
                        return len;
                    }
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
    }

    public long skip(long n) throws IOException {
            this.ensureOpen();
            long avail = (long)(this.count - this.pos);
            if (n > avail) {
                n = avail;
            }

            if (n < 0L) {
                return 0L;
            } else {
                this.pos = (int)((long)this.pos + n);
                return n;
            }
    }

    public boolean ready() throws IOException {
            this.ensureOpen();
            return this.count - this.pos > 0;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int readAheadLimit) throws IOException {
            this.ensureOpen();
            this.markedPos = this.pos;
    }

    public void reset() throws IOException {
            this.ensureOpen();
            this.pos = this.markedPos;
    }

    public void close() {
        this.buf = null;
    }
}
