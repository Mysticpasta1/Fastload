package com.mystic.quickboot.common;

import java.util.List;

import static com.mystic.quickboot.common.QBCommonEvents.Events.INTEGER_EVENT;
import static com.mystic.quickboot.common.QBCommonEvents.Events.PROGRESS_LISTENER_EVENT;
import static com.mystic.quickboot.common.QBCommonEvents.Locations.PREPARE_START_REGION;

public class QBCommonHandler {
    public static void init() {}

    static {
        INTEGER_EVENT.registerStatic(1, List.of(PREPARE_START_REGION),
                (eventContext, eventStatus, event, eventArgs) -> eventContext.setHeldObj(1)
        );

        PROGRESS_LISTENER_EVENT.registerStatic(1,
                (eventContext, eventStatus, event, eventArgs) -> eventContext.progressListener().stop()
        );
    }
}
