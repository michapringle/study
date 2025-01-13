package ca.mpringle.study.neet.binarysearch;

import java.util.Map;
import java.util.OptionalInt;
import java.util.TreeMap;

final class TimeMap {

    private final Map<String, Map<Integer, String>> map;

    public TimeMap() {

        this.map = new TreeMap<>();
    }

    /**
     * Implement a time-based key-value data structure that supports:
     * <p>
     * - Storing multiple values for the same key at specified time stamps
     * - Retrieving the key's value at a specified timestamp
     * <p>
     * Implement the TimeMap class:
     * - TimeMap() Initializes the object.
     * - void set(String key, String value, int timestamp) Stores the key with the value at
     * the given time timestamp.
     * - String get(String key, int timestamp) Returns the most recent value of key if set
     * was previously called on it and the most recent timestamp for that key
     * prev_timestamp is less than or equal to the given timestamp
     * (prev_timestamp <= timestamp). If there are no values, it returns "".
     * <p>
     * Note: For all calls to set, the timestamps are in strictly increasing order.
     * <p>
     * 1:30 -> 2:20 - had to use the washroom and shower, and the output from running online
     * was super confusing.
     */
    public void set(final String key, final String value, final int timestamp) {

        map.computeIfAbsent(key, k -> new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(final String key, final int timestamp) {

        final Map<Integer, String> values = map.get(key);

        if (values == null) {
            return "";
        }

        final String value = values.get(timestamp);

        if (value != null) {
            return value;
        }

        // could speed this part up with a binary search
        final OptionalInt max = values
                .keySet()
                .stream()
                .mapToInt(i -> i)
                .filter(i -> i < timestamp)
                .max();

        return max.isEmpty() ? "" : values.get(max.getAsInt());
    }
}
