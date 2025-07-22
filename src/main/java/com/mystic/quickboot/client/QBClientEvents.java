package com.mystic.quickboot.client;

import com.mystic.quickboot.api.event.core.AbstractEvent;
import com.mystic.quickboot.api.event.def.CapableEvent;
import com.mystic.quickboot.client.QBClientEvents.Contexts.BoxBooleanContext;
import com.mystic.quickboot.client.QBClientEvents.Contexts.PlayerJoinEventContext;
import com.mystic.quickboot.client.QBClientEvents.Contexts.SetScreenEventContext;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Stores important events based on {@link AbstractEvent} that fastload uses.
 * Client events.
 */
public interface QBClientEvents {
    static void init() {}

    interface Events {
        AbstractEvent<SetScreenEventContext> SET_SCREEN_EVENT = new CapableEvent<>();
        AbstractEvent<PlayerJoinEventContext> PLAYER_JOIN_EVENT = new CapableEvent<>();
        AbstractEvent<BoxBooleanContext> BOX_BOOLEAN_EVENT = new CapableEvent<>();
    }

    interface Locations {
        String LLS_441_REDIRECT = "level_loading_screen;441;redirect;";
        String RESPAWN_DTS_REDIRECT = "respawn_dts_redirect;";
        String DTS_GAME_JOIN_REDIRECT = "client_player_network_handler;on_game_join;downloading_terrain_screen;" +
                "redirect";
        String PROGRESS_SCREEN_JOIN_WORLD_REDIRECT = "minecraft_client;join_world;progress_screen;redirect";
        String CLIENT_PLAYER_INIT = "client_player;init;";
        String RENDER_TICK = "minecraft_client;render_tick;";
        String RP_SEND_RUNNABLE = "client_play_network_handler;on_resource_pack_send;execute_runnable;redirect";
        String DTS_TICK = "dts_tick;";
        String FRUSTUM_BOX_BOOL = "frustum_box_bool";
        String WORLD_ICON = "world_icon;";
    }

    interface Contexts {
        record PlayerJoinEventContext(ClientboundLoginPacket packet) {}
        record BoxBooleanContext(AABB box, CallbackInfoReturnable<Boolean> cir ) {}
        record SetScreenEventContext(Screen screen, CallbackInfo ci) {}
    }
}
