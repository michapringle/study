package ca.mpringle.study.neet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

final class LongestRepeating {

    private LongestRepeating() {
    }

    /**
     * You are given a s consisting of only uppercase english characters and an integer k.
     * You can choose up to k characters of the s and replace them with any other uppercase English character.
     * <p>
     * After performing at most k replacements, return the length of the longest substring which contains only one
     * distinct character.
     * <p>
     * 3:45 -> 5:45 - had to look up answer
     */

    static int characterReplacement(final String s, final int k) {

        if (s == null) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            final Map<Character, Integer> chars = new HashMap<>();
            for (int j = i; j < s.length(); j++) {

                chars.merge(s.charAt(j), 1, Integer::sum);
                int charCount = chars.values().stream().max(Integer::compareTo).get();
                if (j - i + 1 - charCount <= k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }


    static int characterReplacementNeetCodeAnswer(final String s, final int k) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            final Map<Character, Integer> charCount = new HashMap<>();
            int maxf = 0;

            for (int j = i; j < s.length(); j++) {

                charCount.put(s.charAt(j), charCount.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, charCount.get(s.charAt(j)));
                if ((j - i + 1) - maxf <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}