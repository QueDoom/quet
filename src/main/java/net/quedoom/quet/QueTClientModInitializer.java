package net.quedoom.quet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.function.Consumer;

public abstract class QueTClientModInitializer implements ClientModInitializer {
    protected static void processEndTick(Consumer<Minecraft> handler) {
        ClientTickEvents.END_CLIENT_TICK.register(handler::accept);
    }

    protected static void sendC2SPacket(CustomPacketPayload payload) {
        ClientPlayNetworking.send(payload);
    }
}
