package ca.mpringle.study.neet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

final class MinimumWindow {

    private MinimumWindow() {
    }

    /**
     * Given two strings s and t, return the shortest substring of s such that every character in t,
     * including duplicates, is present in the substring. If such a substring does not exist,
     * return an empty string "".
     * <p>
     * You may assume that the correct output is always unique.
     * <p>
     * 2:20 -> 3:25 - kind of a PitA
     */
    static String minWindow(final String s, final String t) {

        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        if (s.contains(t)) {
            return t;
        }

        final Map<Character, Integer> tNormalized = new HashMap<>();
        for (char c : t.toCharArray()) {
            tNormalized.merge(c, 1, Integer::sum);
        }

        String minSubstring = s;
        boolean isSubstringFound = false;

        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            for (int j = i + t.length(); j < s.length() + 1; j++) {

                final Map<Character, Integer> sNormalized = new HashMap<>();
                final String currentString = s.substring(i, j);
                for (char c : currentString.toCharArray()) {
                    sNormalized.merge(c, 1, Integer::sum);
                }

                if (contains(sNormalized, tNormalized)) {
                    isSubstringFound = true;
                    minSubstring = minSubstring.length() < currentString.length() ? minSubstring : currentString;
                }
            }
        }

        return isSubstringFound ? minSubstring : "";
    }

    private static boolean contains(
            final Map<Character, Integer> superset,
            final Map<Character, Integer> subset
    ) {

        long count = subset
                .entrySet()
                .stream()
                .filter(entry -> superset.get(entry.getKey()) != null)
                .filter(entry -> superset.get(entry.getKey()) >= entry.getValue())
                .count();

        return count == subset.size();
    }
}