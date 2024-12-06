package ca.mpringle.study.neet.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

final class ValidParentheses {

    private ValidParentheses() {
    }

    /**
     * You are given a string s consisting of the following characters:
     * '(', ')', '{', '}', '[' and ']'.
     * <p>
     * The input string s is valid if and only if:
     * <p>
     * Every open bracket is closed by the same type of close bracket.
     * Open brackets are closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     * <p>
     * Return true if s is a valid string, and false otherwise.
     */
    // 4:00 -> 4:30
    static boolean isValid(final String sequence) {

        final Deque<String> stack = new ArrayDeque<>();
        final Map<String, String> openClosed = new HashMap<>();
        openClosed.put("(", ")");
        openClosed.put("{", "}");
        openClosed.put("[", "]");

        for (int i = 0; i < sequence.length(); i++) {
            final String c = "" + sequence.charAt(i);

            if ("({[".contains(c)) {
                stack.add(c);

            } else if (c.equals(openClosed.get(stack.peekLast()))) {
                stack.removeLast();

            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
