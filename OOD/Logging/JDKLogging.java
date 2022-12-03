package OOD.Logging;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class JDKLogging {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JDKLogging.class.getName());
        logger.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            logger.severe("null");
        }
        logger.info("Process end.");
    }
}
