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
    private final List<Integer> minValueIndices;

    MinStack() {

        stack = new ArrayList<>();
        minValueIndices = new ArrayList<>();
    }

    public void push(final int val) {

        stack.add(val);
        if (minValueIndices.isEmpty()) {
            minValueIndices.add(0);
        } else if (val < stack.get(lastMinValueIndex())) {
            minValueIndices.add(stack.size() - 1);
        }
    }

    public void pop() {

        if (stack.isEmpty()) {
            return;
        }

        stack.remove(stack.size() - 1);

        if (stack.isEmpty()) {
            minValueIndices.clear();
            return;
        }

        if (lastMinValueIndex() == stack.size() || stack.get(stack.size() - 1) < stack.get(lastMinValueIndex())) {
            minValueIndices.remove(minValueIndices.size() - 1);
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

        return stack.get(lastMinValueIndex());
    }

    private int lastMinValueIndex() {
        return minValueIndices.get(minValueIndices.size() - 1);
    }
}