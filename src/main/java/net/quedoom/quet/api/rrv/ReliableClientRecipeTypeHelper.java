package net.quedoom.quet.api.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.quedoom.quet.init.ModRegistrator;
import org.jspecify.annotations.Nullable;

import java.util.List;

public abstract class ReliableClientRecipeTypeHelper implements ReliableClientRecipeType {
    private final Component display;
    private final String name;
    private final List<ItemStack> displayAndWorkstation;
    private final int width, height;

    protected abstract String namespace();
    protected ModRegistrator registrator() {
        return new ModRegistrator(namespace());
    }

    protected ReliableClientRecipeTypeHelper(Component displayName, String name,
                                             List<ItemStack> displayAndWorkstation, int width, int height) {
        this.display = displayName;
        this.name = name;
        this.displayAndWorkstation = displayAndWorkstation;
        this.width = width;
        this.height = height;
    }

    protected ReliableClientRecipeTypeHelper(String name, List<ItemStack> displayAndWorkstation, int width, int height) {
        this.display = registrator().translatable("rrv", name);
        this.name = name;
        this.displayAndWorkstation = displayAndWorkstation;
        this.width = width;
        this.height = height;
    }

    @Override
    public Component getDisplayName() {
        return this.display;
    }

    @Override
    public int getDisplayWidth() {
        return this.width;
    }

    @Override
    public int getDisplayHeight() {
        return this.height;
    }

    @Override
    public @Nullable Identifier getGuiTexture() {
        return registrator().of("textures/rrv/" + this.name + ".png");
    }

    @Override
    public Identifier getId() {
        return registrator().of(name);
    }

    @Override
    public ItemStack getIcon() {
        return this.displayAndWorkstation.getFirst();
    }

    @Override
    public List<ItemStack> getCraftReferences() {
        return this.displayAndWorkstation;
    }
}
