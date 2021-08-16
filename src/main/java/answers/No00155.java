package answers;

import java.util.Stack;

public class No00155 {
    private final Stack<Integer> valStack;
    private final Stack<Integer> minStack;
    private Integer min = null;

    public No00155() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (min == null) {
            min = val;
        } else {
            min = min < val? min : val;
        }
        valStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        valStack.pop();
        if (minStack.isEmpty()) {
            min = null;
        } else {
            min = minStack.peek();
        }
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
