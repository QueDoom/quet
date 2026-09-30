package net.quedoom.quet.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModRegistrator {
    private final String NAMESPACE;
    public final Logger LOGGER;

    public ModRegistrator(@NonNull String namespace) {
        this.NAMESPACE = namespace;
        this.LOGGER = LoggerFactory.getLogger(namespace);
    }

    /**
     * You need to set this in the beginning, where you see the <br>
     * {@code public static final String MOD_ID = "string";} it should be <br>
     * {@code public static final String MOD_ID = setNamespace("string");}
     * Make sure to extend this class in you {@link net.fabricmc.api.ModInitializer}
     * @return The parameter input, this is just a neat way of calling the method
     */
    public String namespace() {
        return NAMESPACE;
    }

    public Component translatable(String prefix, String suffix) {
        return Component.translatable(prefix + '.' + namespace() + '.' + suffix);
    }

    public Identifier of(String path) {
        return Identifier.fromNamespaceAndPath(namespace(), path);
    }

    public String translationString(String prefix, String suffix) {
        return prefix + '.' + namespace() + '.' + suffix;
    }

    public void logInfo(String toLog) {
        LOGGER.info(toLog);
    }
}
