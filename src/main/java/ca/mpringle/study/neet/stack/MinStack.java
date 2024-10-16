package ca.mpringle.study.neet.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * <p>
 * Each function should run in O(1) time.
 * <p>
 * 3:40 -> 4:09 -- had to look up the getmin solution, which is ridiculous
 */
final class MinStack {

    private final List<Integer> stack;
    private final List<Integer> minValues;

    MinStack() {

        stack = new ArrayList<>();
        minValues = new ArrayList<>();
    }

    public void push(final int val) {

        stack.add(val);
        final int minValue = minValues.isEmpty() ? val : Math.min(val, minValues.get(minValues.size() - 1));
        minValues.add(minValue);
    }

    public void pop() {

        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
            minValues.remove(minValues.size() - 1);
        }
    }

    public int top() {

        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return stack.get(stack.size() - 1);
    }

    public int size() {

        return stack.size();
    }

    public int getMin() {

        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return minValues.get(minValues.size() - 1);
    }
}