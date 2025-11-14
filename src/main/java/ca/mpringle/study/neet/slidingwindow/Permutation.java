package ca.mpringle.study.neet.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class Permutation {

    private Permutation() {
    }

    /**
     * You are given two strings s1 and s2.
     * <p>
     * Return true if s2 contains a permutation of s1, or false otherwise.
     * That means if a permutation of s1 exists as a substring of s2, then return true.
     * <p>
     * Both strings only contain lowercase letters.
     * <p>
     * 5:50 -> 6:20 - seemed easy after the longest repeating question, probably put me on the right track
     */
    static boolean checkInclusion(final String s1, final String s2) {

        if (s1 == null && s2 == null) {
            return true;
        }

        final Map<Character, Integer> substringNormalized = new HashMap<>();

        for (char c : s1.toCharArray()) {
            substringNormalized.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            final Map<Character, Integer> stringNormalized = new HashMap<>();
            for (char c : s2.substring(i, i + s1.length()).toCharArray()) {
                stringNormalized.merge(c, 1, Integer::sum);
            }
            if (Objects.equals(substringNormalized, stringNormalized)) {
                return true;
            }
        }

        return false;
    }
}