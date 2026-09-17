package net.quedoom.quet.init;

public class ModRegistrator {
    private static String namespace = null;

    public static String namespace() {
        return namespace;
    }
    public static String setNamespace(String namespace) {
        ModRegistrator.namespace = namespace;
        return namespace;
    };

    public static void register() {}
}
