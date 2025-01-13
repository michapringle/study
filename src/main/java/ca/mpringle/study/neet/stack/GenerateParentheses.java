package ca.mpringle.study.neet.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

final class GenerateParentheses {

    private GenerateParentheses() {
    }

    /**
     * You are given an integer n. Return all well-formed parentheses strings that you can
     * generate with n pairs of parentheses.
     * <p>
     * 5:00 -> 6:00 - had to look up this solution
     */
    static List<String> generateParenthesis(final int n) {

        final List<String> results = new ArrayList<>();
        final Stack<Character> stack = new Stack<>();
        backtrack(n, n, stack, results);
        return results;
    }

    private static void backtrack(
            final int openBrackets,
            final int closedBrackets,
            final Stack<Character> stack,
            final List<String> results
    ) {

        if (openBrackets == 0 && closedBrackets == 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            results.add(sb.toString());
            return;
        }

        if (openBrackets > 0) {
            stack.push('(');
            backtrack(openBrackets - 1, closedBrackets, stack, results);
            stack.pop();
        }

        if (closedBrackets > openBrackets) {
            stack.push(')');
            backtrack(openBrackets, closedBrackets - 1, stack, results);
            stack.pop();
        }
    }
}