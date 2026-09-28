package net.quedoom.quet.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.quedoom.quet.init.ModRegistrator;

import java.util.function.BiFunction;

public abstract class QTBasicC2SPayload implements CustomPacketPayload {
    //region Could've been a record :)
    private final String name;
    private final int value;

    public QTBasicC2SPayload(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return this.name;
    }
    public int value() {
        return this.value;
    }
    //endregion Could've been a record :)

    public static <T extends QTBasicC2SPayload> StreamCodec<RegistryFriendlyByteBuf, T> basicStream(BiFunction<String, Integer, T> factory) {
        return StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                T::name,

                ByteBufCodecs.VAR_INT,
                T::value,

                factory
        );
    }

    protected <T extends CustomPacketPayload> Type<T> loadType(String name) {
        return new Type<>(ModRegistrator.of(name + "_payload"));
    }
}
