package net.quedoom.quet.api.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.terraformersmc.modmenu.util.NullScreenFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.options.OptionsScreen;

import java.util.Map;
import java.util.Objects;

public abstract class QTModMenuApi implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return Objects.requireNonNullElse(getConfigScreenFactory(), new NullScreenFactory<>());
    }

    protected abstract ConfigScreenFactory<?> getConfigScreenFactory();

    @Override
    public Map<String, ConfigScreenFactory<?>> getProvidedConfigScreenFactories() {
        return Map.of("minecraft", parent -> new OptionsScreen(parent, Minecraft.getInstance().options, false));
    }
}
