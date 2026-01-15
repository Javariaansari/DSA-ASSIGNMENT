class QueueLinkedList {
    private Node front;
    private Node rear;
    // Node class
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Enqueue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " enqueued");
    }

    // Dequeue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = front.data;
        front = front.next;

        if (front == null) rear = null;

        return removed;
    }
    // Peek
    public int peek() {
        if (front == null) return -1;
        return front.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }

    // Print queue
    public void printQueue() {
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find maximum value
    public int findMax() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        Node temp = front;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    // Find sum of elements
    public int findSum() {
        int sum = 0;
        Node temp = front;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    // Count elements
    public int countElements() {
        int count = 0;
        Node temp = front;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();
        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Max value: " + queue.findMax());
        System.out.println("Sum: " + queue.findSum());
        System.out.println("Count: " + queue.countElements());
    }
}

