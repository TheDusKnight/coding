package OOD.Logging;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggings {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLoggings.class);
        log.info("start...");
        log.warn("end.");

        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            log.fatal("null", e);
        }
    }
}
