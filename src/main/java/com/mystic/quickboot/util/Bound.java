package com.mystic.quickboot.util;

/**
 * This is a record that stores the "BOUNDS" in com.mystic.quickboot.config.DefaultConfig
 * Min and Maxes are always stored together because seperating them causes spaghetti code, we don't want that.
 */
public record Bound(int max, int min) {
    public static Bound of(final int max, final int min) {
        return new Bound(max, min);
    }

    public static int minMax(final int toCompare, final int max, final int min) {
        return Math.max(Math.min(toCompare, max), min);
    }

    public int minMax(final int toCompare) {
        return minMax(toCompare, max, min);
    }
}
