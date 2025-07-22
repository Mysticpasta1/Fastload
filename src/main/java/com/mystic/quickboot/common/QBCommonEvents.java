package com.mystic.quickboot.common;

import com.mystic.quickboot.api.event.core.AbstractEvent;
import com.mystic.quickboot.api.event.def.CapableEvent;
import com.mystic.quickboot.util.obj_holders.MutableObjectHolder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.level.ChunkPos;

import static com.mystic.quickboot.common.QBCommonEvents.Contexts.*;

/**
 * Stores important events based on {@link AbstractEvent} that fastload uses.
 * Common events.
 */
public interface QBCommonEvents {
    static void init() {}

    interface Events {
        AbstractEvent<MutableObjectHolder<Boolean>> BOOLEAN_EVENT = new CapableEvent<>();
        AbstractEvent<MutableObjectHolder<Integer>> INTEGER_EVENT = new CapableEvent<>();
        AbstractEvent<MutableObjectHolder<Runnable>> RUNNABLE_EVENT = new CapableEvent<>();
        AbstractEvent<EmptyContext> EMPTY_EVENT =  new CapableEvent<>();
        AbstractEvent<ProgressListenerContext> PROGRESS_LISTENER_EVENT = new CapableEvent<>();
        AbstractEvent<ServerContext<Boolean>> SERVER_EVENT = new CapableEvent<>();

    }
    interface Locations {
        String SERVER_TICK = "minecraft_server;server_tick;";
        String PREPARE_START_REGION = "minecraft_server;prepare_start_region;modify_constant_441;";
        String SERVER_PSR_LOADING_REDIRECT = "minecraft_server;prepare_start_region;is_loading;redirect";
    }

    interface Contexts {
        record EmptyContext() {}
        record ServerContext<T>(MinecraftServer server, MutableObjectHolder<T> returnValue) {}
        record ProgressListenerContext(ChunkProgressListener progressListener, ChunkPos chunkPos) {}
    }
}
