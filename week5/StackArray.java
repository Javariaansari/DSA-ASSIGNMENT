class StackArray {
    private int[] stack;
    private int top;

    // Constructor
    public StackArray(int size) {
        stack = new int[size];
        top = -1;
    }

    // Push element
    public void push(int value) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = value;
        System.out.println(value + " pushed to stack");
    }

    // Pop element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        return stack[top--];
    }

    // Peek element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // Resize stack
    private void resize() {
        int newSize = stack.length * 2;
        int[] newStack = new int[newSize];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        System.out.println("Stack size doubled to " + newSize);
    }

    // Check empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Print stack
    public void printStack() {
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        StackArray s = new StackArray(2);

        s.push(10);
        s.push(20);
        s.push(30);   // resize

        s.printStack();

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());
        s.printStack();
    }
}

