package ca.mpringle.study.neet.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

final class ReversePolishNotation {

    private ReversePolishNotation() {
    }

    /**
     * You are given an array of strings tokens that represents a valid arithmetic
     * expression in Reverse Polish Notation.
     * <p>
     * Return the integer that represents the evaluation of the expression.
     * <p>
     * The operands may be integers or the results of other operations.
     * The operators include '+', '-', '*', and '/'.
     * Assume that division between integers always truncates toward zero.
     * <p>
     * 2:30 -> 3:18 - struggled with stupid Deque API and slight problem with regex
     */
    public static int evalRPN(final String[] tokens) {

        final Deque<String> stack = new ArrayDeque<>();

        Arrays
                .stream(tokens)
                .forEach(token -> {

                    if (token.matches("^-?\\d+")) {
                        stack.add(token);

                    } else {
                        final int second = Integer.parseInt(stack.peekLast());
                        stack.removeLast();
                        final int first = Integer.parseInt(stack.peekLast());
                        stack.removeLast();

                        switch (token) {
                            case "+" -> stack.add(Integer.toString(first + second));
                            case "-" -> stack.add(Integer.toString(first - second));
                            case "*" -> stack.add(Integer.toString(first * second));
                            case "/" -> stack.add(Integer.toString(first / second));
                        }
                    }
                });

        return stack.isEmpty() ? 0 : Integer.parseInt(stack.peekLast());
    }
}
