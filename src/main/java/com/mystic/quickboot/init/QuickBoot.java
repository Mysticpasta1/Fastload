package com.mystic.quickboot.init;

import com.mystic.quickboot.client.QBClientEvents;
import com.mystic.quickboot.common.QBCommonEvents;
import com.mystic.quickboot.common.QBCommonHandler;
import com.mystic.quickboot.config.QBConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mystic.quickboot.config.DefaultConfig.*;
import static com.mystic.quickboot.config.QBMath.*;

@Mod(QuickBoot.MOD_ID)
public class QuickBoot {
    public static final String MOD_ID = "quickboot";
    public static final String NAMESPACE = "Quick Boot";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

    public QuickBoot(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        QBCommonHandler.init();
        QBCommonEvents.init();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        QBConfig.init();
        QBClientEvents.init();
        LOGGER.info(logKey(DEBUG_KEY) + isDebugEnabled().toString().toUpperCase());
        LOGGER.info(logKey(CHUNK_TRY_LIMIT_KEY) + getChunkTryLimit());
    }

    private static String logKey(String key) {
        return key.toUpperCase() + ": ";
    }
}