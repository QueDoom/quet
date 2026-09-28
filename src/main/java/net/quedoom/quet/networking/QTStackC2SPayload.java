package net.quedoom.quet.networking;

import com.mojang.datafixers.util.Function3;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiFunction;

public abstract class QTStackC2SPayload extends QTBasicC2SPayload {
    private final ItemStack stack;

    public QTStackC2SPayload(String name, int value, ItemStack stack) {
        super(name, value);
        this.stack = stack;
    }

    public ItemStack stack() {
        return stack;
    }

    public static <T extends QTStackC2SPayload> StreamCodec<RegistryFriendlyByteBuf, T> stackStream(Function3<String, Integer, ItemStack, T> factory) {
        return StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                T::name,

                ByteBufCodecs.VAR_INT,
                T::value,

                ItemStack.STREAM_CODEC,
                T::stack,

                factory
        );
    }
}
