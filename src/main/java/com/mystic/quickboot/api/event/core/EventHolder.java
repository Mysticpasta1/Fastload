package com.mystic.quickboot.api.event.core;

import com.mystic.quickboot.client.QBClientEvents;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Common storage type for {@link AbstractEvent}
 * @param argsHolder Holds an array of {@link EventArgs} attached to a key of a given priority.
 * @param priorityHolder Holds all the priorities that are used to access a specific arraylist of events to onElement through.
 * @param <Ctx> used for custom event params. Refer to {@link QBClientEvents FLEvents}
 *           for examples.
 */
public record EventHolder<Ctx> (
        Long2ObjectMap<List<EventArgs<Ctx>>> argsHolder,
        ArrayList<Long> priorityHolder
) {}