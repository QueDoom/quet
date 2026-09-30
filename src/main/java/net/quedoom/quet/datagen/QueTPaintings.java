package net.quedoom.quet.datagen;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.quedoom.quet.init.ModRegistrator;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

public class QueTPaintings extends ModRegistrator {
    public QueTPaintings(@NonNull String namespace) {
        super(namespace);
    }

    protected ResourceKey<PaintingVariant> create(final String name) {
        return  ResourceKey.create(Registries.PAINTING_VARIANT, of(name));
    }

    protected void register(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final int width, final int height, final boolean hasAuthor) {
        context.register(key, new PaintingVariant(width, height, key.identifier(),
                Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW)),
                hasAuthor ? Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY)) : Optional.empty()));
    }

    protected void register1x1(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 1, 1, hasAuthor);
    }
    protected void register1x2(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 1, 2, hasAuthor);
    }
    protected void register2x1(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 2, 1, hasAuthor);
    }
    protected void register2x2(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 2, 2, hasAuthor);
    }
    protected void register3x4(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 3, 4, hasAuthor);
    }
    protected void register4x4(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 4, 4, hasAuthor);
    }
    protected void register3x3(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 3, 3, hasAuthor);
    }
    protected void register3x2(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final boolean hasAuthor) {
        register(context, key, 3, 2, hasAuthor);
    }
}
