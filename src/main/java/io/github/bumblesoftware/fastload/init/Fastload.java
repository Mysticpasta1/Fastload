package io.github.bumblesoftware.fastload.init;

import io.github.bumblesoftware.fastload.client.FLClientEvents;
import io.github.bumblesoftware.fastload.common.FLCommonEvents;
import io.github.bumblesoftware.fastload.common.FLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.bumblesoftware.fastload.config.DefaultConfig.*;
import static io.github.bumblesoftware.fastload.config.FLMath.*;

@Mod(Fastload.MOD_ID)
public class Fastload {
    public static final String MOD_ID = "fastload";
    public static final String NAMESPACE = "Fastload";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

    public Fastload() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        FLCommonHandler.init();
        FLCommonEvents.init();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        io.github.bumblesoftware.fastload.config.FLConfig.init();
        FLClientEvents.init();
        LOGGER.info(logKey(DEBUG_KEY) + isDebugEnabled().toString().toUpperCase());
        LOGGER.info(logKey(CHUNK_TRY_LIMIT_KEY) + getChunkTryLimit());
    }

    private static String logKey(String key) {
        return key.toUpperCase() + ": ";
    }
}