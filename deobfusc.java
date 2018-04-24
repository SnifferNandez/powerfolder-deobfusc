// Based on https://github.com/powerfolder/PF-CORE/blob/30f7d3f35c715b772afb47d3b031fb113383d5a1/src/main/de/dal33t/powerfolder/util/LoginUtil.java
import java.util.Base64;
import java.util.Arrays;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class MyClass {
    public static void main(String args[]) {
        int OBF_BYTE = 0xAA;
        String passwordOBF = "SecretString";
            byte[] buf = Base64.getDecoder().decode(passwordOBF);
            for (int i = 0; i < buf.length; i++) {
                buf[i] = (byte) (buf[i] - 127);
                buf[i] = (byte) (buf[i] ^ OBF_BYTE);
            }
            ByteBuffer bBuf = ByteBuffer.wrap(buf);
            char[] ca = new char[buf.length];
            CharBuffer cBuf = CharBuffer.wrap(ca);
            Charset charset = Charset.forName("UTF8"); 
            CharsetDecoder dec = charset.newDecoder();
            dec.decode(bBuf, cBuf, true);
            int len = cBuf.position();
            if (len != ca.length) {
                ca = Arrays.copyOf(ca, len);
            }
        System.out.println("Password = "  + new String(ca));
    }
}
