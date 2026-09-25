package net.quedoom.quet.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModRegistrator {
    private static String NAMESPACE = null;
    public static Logger LOGGER = null;

    /**
     * You need to set this in the beginning, where you see the <br>
     * {@code public static final String MOD_ID = "string";} it should be <br>
     * {@code public static final String MOD_ID = setNamespace("string");}
     * Make sure to extend this class in you {@link net.fabricmc.api.ModInitializer}
     * @return The parameter input, this is just a neat way of calling the method
     */
    public static String namespace() {
        if (NAMESPACE == null) {
            throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
        }
        return NAMESPACE;
    }
    public static Logger logger() {
        if (LOGGER == null) {
            if (NAMESPACE == null) {
                throw new NullPointerException("Unset namespace in " + ModRegistrator.class);
            }
            LOGGER = LoggerFactory.getLogger(NAMESPACE);
        }
        return LOGGER;
    }
    public static void logInfo(String string) {
        logger().info(string);
    }
    public static String setNamespace(String namespace) {
        ModRegistrator.NAMESPACE = namespace;
        return namespace;
    };

    public static Component translatable(String prefix, String suffix) {
        return Component.translatable(prefix + '.' + namespace() + '.' + suffix);
    }

    public static Identifier of(String path) {
        return Identifier.fromNamespaceAndPath(namespace(), path);
    }

    /**
     * Adds a register method to all classes that extends this Class (should be all Registration Classes)
     */
    public static void register() {}
}
