package ca.mpringle.study.neet.slidingwindow;

final class LongestSubstring {

    private LongestSubstring() {
    }

    /**
     * Given a string s, find the length of the longest substring without duplicate characters.
     * <p>
     * A substring is a contiguous sequence of characters within a string.
     * <p>
     * 12:20 -> 1:20
     */
    static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        StringBuilder value = new StringBuilder();
        StringBuilder max = value;

        for (char c : s.toCharArray()) {

            int i = value.indexOf("" + c);
            if (i == -1) {
                value.append(c);
            } else {
                value = new StringBuilder(value.substring(i + 1)).append(c);
            }

            max = max.length() < value.length() ? value : max;
        }

        return max.length();
    }
}
