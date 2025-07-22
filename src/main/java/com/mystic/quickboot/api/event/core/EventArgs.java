package com.mystic.quickboot.api.event.core;

import com.mystic.quickboot.client.QBClientEvents;
import com.mystic.quickboot.util.obj_holders.MutableObjectHolder;

/**
 * Event args holds a specific implementation that is added to the main registry for {@link AbstractEvent}
 * to onElement through upon firing.
 * @param <Context> used for custom event params. Refer to {@link QBClientEvents FLEvents}
 *           for examples.
 */
@FunctionalInterface
public interface EventArgs<Context> {

    /**
     * @param eventContext The events params.
     * @param event The event instance for managerial purposes.
     * @param closer The instance responsible for holding the value that will close this loop.
     * @param eventArgs The current instance provided for return (recursion)
     * @return The current instance.
     */
    @SuppressWarnings({"UnusedReturnValue", "SameReturnValue"})
    EventArgs<Context> recursive(
            final Context eventContext,
            final MutableObjectHolder<EventStatus> statusHolder,
            final AbstractEvent<Context> event,
            final Object closer,
            final EventArgs<Context> eventArgs
    );
}