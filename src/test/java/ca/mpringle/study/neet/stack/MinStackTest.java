package ca.mpringle.study.neet.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class MinStackTest {

    @Test
    void constructorShouldInitializeEmptyStack() {

        final MinStack stack = new MinStack();

        assertEquals(0, stack.size());
        assertDoesNotThrow(stack::pop);
        assertThrows(IllegalStateException.class, stack::top);
    }

    @Test
    void stackShouldWork() {

        final MinStack stack = new MinStack();
        assertEquals(0, stack.size());

        stack.push(100);
        assertEquals(1, stack.size());

        stack.push(200);
        assertEquals(2, stack.size());

        stack.push(300);
        assertEquals(3, stack.size());
        assertEquals(300, stack.top());

        stack.pop();
        assertEquals(200, stack.top());

        stack.pop();
        assertEquals(100, stack.top());

        stack.pop();
        assertEquals(0, stack.size());

        assertThrows(IllegalStateException.class, stack::getMin);
    }

    @Test
    void stackShouldWork2() {

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.top());
        assertEquals(1, minStack.getMin());
    }
}