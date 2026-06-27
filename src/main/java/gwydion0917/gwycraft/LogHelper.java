package gwydion0917.gwycraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    private static final Logger LOGGER = LogManager.getLogger(Gwycraft.MOD_ID);

    public static void info(Object msg)  { LOGGER.info(String.valueOf(msg)); }
    public static void debug(Object msg) { LOGGER.debug(String.valueOf(msg)); }
    public static void warn(Object msg)  { LOGGER.warn(String.valueOf(msg)); }
    public static void error(Object msg) { LOGGER.error(String.valueOf(msg)); }
    public static void trace(Object msg) { LOGGER.info("[Trace] " + msg); }
}
