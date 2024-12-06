package ca.mpringle.study.neet.twopointers;


final class Palindrome {

    private Palindrome() {
    }

    /**
     * Given a string s, return true if it is a palindrome, otherwise return false.
     * <p>
     * A palindrome is a string that reads the same forward and backward.
     * It is also case-insensitive and ignores all non-alphanumeric characters.
     */
    // 4:20 -> 4:31
    static boolean isPalindrome(final String s) {

        if (s == null) {
            return false;
        }

        final String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0, j = cleaned.length() - 1; i <= j; i++, j--) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
