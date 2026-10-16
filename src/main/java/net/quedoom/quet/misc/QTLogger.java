package net.quedoom.quet.misc;

import net.quedoom.quet.QueT;

/**
 * Should only be used to test as it uses QueT's {@link org.apache.logging.log4j.Logger}
 */
public class QTLogger {
    public static <T> T logAndReturn(T value) {
        QueT.LOGGER.info(value.toString());
        return value;
    }

    public static <T> T logAndReturn(String prefix, T value) {
        QueT.LOGGER.info("{} {}", prefix, value.toString());
        return value;
    }
}
