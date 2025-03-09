package org.teamvoided.scriptor_shush.mixin;

import com.ssblur.scriptor.data.saved_data.DictionarySavedData;
import de.erdbeerbaerlp.dcintegration.common.DiscordIntegration;
import de.erdbeerbaerlp.dcintegration.fabric.DiscordIntegrationMod;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Debug(export = true)
@Mixin(DiscordIntegrationMod.class)
public class DiscordIntegrationModMixin {

    @Inject(method = "handleChatMessage", at = @At("HEAD"), cancellable = true)
    private static void cancelScriptorMessages(PlayerChatMessage message, ServerPlayer player, CallbackInfoReturnable<PlayerChatMessage> cir) {
        if (DiscordIntegration.INSTANCE != null && DictionarySavedData.computeIfAbsent(player.serverLevel()).parse(message.signedContent()) != null)
            cir.setReturnValue(message);
    }
}
