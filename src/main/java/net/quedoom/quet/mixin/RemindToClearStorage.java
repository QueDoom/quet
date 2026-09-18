package net.quedoom.quet.mixin;

import net.minecraft.client.main.Main;
import net.minecraft.server.MinecraftServer;
import net.quedoom.quet.QueT;
import net.quedoom.quet.misc.QueTObjectStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Main.class)
public class RemindToClearStorage {
	@Inject(at = @At(value = "INVOKE", target = "Ljoptsimple/OptionParser;parse([Ljava/lang/String;)Ljoptsimple/OptionSet;"), method = "main")
	private static void remind(CallbackInfo info) {
		if (!QueTObjectStorage.HAS_CLEARED) QueT.LOGGER.warn("Please remember to clear the Storage in your DataGenerator main class (at the end)!");
	}
}