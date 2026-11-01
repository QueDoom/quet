package net.quedoom.quet.api.modmenu;

import com.terraformersmc.modmenu.ModMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;
import net.quedoom.quet.api.prickle.QTConfigManager;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;

import java.util.List;

public abstract class QTOptionsScreen<C> extends OptionsSubScreen {
    private final String modid;
    private final String configName;
    private final Class<?> clazz;
    private final C config;

    public QTOptionsScreen(Screen lastScreenDoNotTouch, String modid, Class<?> clazz, C config) {
        super(lastScreenDoNotTouch, Minecraft.getInstance().options, Component.translatable("options." + modid));
        this.modid = modid;
        this.configName = modid;
        this.clazz = clazz;
        this.config = config;
    }

    public QTOptionsScreen(Screen lastScreenDoNotTouch, String modid, String configName, Class<C> clazz, C config) {
        super(lastScreenDoNotTouch, Minecraft.getInstance().options, Component.translatable("options." + modid));
        this.modid = modid;
        this.configName = configName;
        this.clazz = clazz;
        this.config = config;
    }

    @Override
    protected void addOptions() {
        if (this.list == null) return;
        List<AbstractWidget> widgets = QTConfigManager.asWidgets(this.options, this.clazz, this.config, this.modid);
        for (int i = 0; i < widgets.size(); i += 2) {
            AbstractWidget left = widgets.get(i);
            AbstractWidget right = i + 1 < widgets.size() ? widgets.get(i + 1) : null;
            this.list.addSmall(left, right);
        }
    }

    @Override
    public void added() {
        ModMenu.LOGGER.info("Opened Config Screen for {}", QTTranslationBuilder.snakeToTitleCase(this.modid));
    }
    @Override
    public void removed() {
        QTConfigManager.save(QTConfigManager.path(this.configName), this.clazz, this.config);
        load(this.configName, this.clazz, this.config);
    }
    protected abstract void load(String configName, Class<?> clazz, C config);
}
