package com.mystic.quickboot.mixin.client;

import com.mystic.quickboot.common.QBCommonEvents.Contexts.EmptyContext;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static com.mystic.quickboot.client.QBClientEvents.Locations.CLIENT_PLAYER_INIT;
import static com.mystic.quickboot.common.QBCommonEvents.Events.EMPTY_EVENT;

/**
 * Sets playerLoaded to true when... player loads
 */
@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Inject(method = "resetPos", at = @At("HEAD"))
    private void onClientPlayerEntityMixinInitEvent(CallbackInfo ci) {
        if (EMPTY_EVENT.isNotEmpty())
            EMPTY_EVENT.execute(List.of(CLIENT_PLAYER_INIT), new EmptyContext());
    }
}
