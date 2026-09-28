package net.quedoom.quet.networking;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class QueTPackets {
    protected static <T extends CustomPacketPayload> void clientbound(
            CustomPacketPayload.Type<T> type,
            StreamCodec<? super RegistryFriendlyByteBuf, T> codec) {
        PayloadTypeRegistry.clientboundPlay().register(type, codec);
    }

    protected static <T extends CustomPacketPayload> void serverbound(
            CustomPacketPayload.Type<T> type,
            StreamCodec<? super RegistryFriendlyByteBuf, T> codec,
            ServerPlayNetworking.PlayPayloadHandler<T> handler) {
        PayloadTypeRegistry.serverboundPlay().register(type, codec);
        ServerPlayNetworking.registerGlobalReceiver(type, handler);
    }

//    public static void registerPackets() {
//        serverbound(QTBasicC2SPayload.TYPE, QTBasicC2SPayload.STREAM_CODEC, QueTServerboundPacket::handleTestPayload);
//    }
}
