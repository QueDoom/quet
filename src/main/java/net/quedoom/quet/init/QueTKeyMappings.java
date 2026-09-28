package net.quedoom.quet.init;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class QueTKeyMappings extends ModRegistrator {

    protected static KeyMapping register(String name, int glfwDefaultKey, KeyMapping.Category category) {
        return KeyMappingHelper.registerKeyMapping(
                new KeyMapping(
                        ModRegistrator.translationString("key", name),
                        InputConstants.Type.KEYSYM,
                        glfwDefaultKey, category
                        )
        );
    }

}
