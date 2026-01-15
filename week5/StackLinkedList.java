class StackLinkedList {
    private Node top;
    // Node class
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Push element
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value + " pushed to stack");
    }
    // Pop element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    // Peek element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    // Print stack (without modifying)
    public void printStack() {
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    // Print and empty the stack
    public void printStack2() {
        System.out.println("Printing and emptying stack:");
        while (!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }
    // Main method to test
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // 30 20 10

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());

        stack.printStack(); // 20 10

        stack.printStack2(); // prints 20 and 10, stack becomes empty

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

