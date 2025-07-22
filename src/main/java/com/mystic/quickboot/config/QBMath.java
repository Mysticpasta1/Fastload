package com.mystic.quickboot.config;

import com.mystic.quickboot.util.lambda.LambdaIf;

import static com.mystic.quickboot.config.DefaultConfig.CHUNK_TRY_LIMIT_BOUND;
import static com.mystic.quickboot.config.QBConfig.*;

public class QBMath {
    private static final LambdaIf DEBUG_LAMBDA = LambdaIf.getNew(getRawDebug());

    public static int getChunkTryLimit() {
        return CHUNK_TRY_LIMIT_BOUND.minMax(getRawChunkTryLimit());
    }

    public static LambdaIf isDebugEnabled() {
        return DEBUG_LAMBDA;
    }

    public static void ifDebugEnabled(Runnable runnable) {
        isDebugEnabled().runIf(runnable);
    }

    public static Boolean isInstantLoadEnabled() {
        return getRawInstantLoad();
    }
}
