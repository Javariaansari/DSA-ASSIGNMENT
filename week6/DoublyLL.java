class DoublyLL {
    Node head, tail;
    // Node class
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }
    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    // Print forward
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // Print backward
    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    // Delete first node
    public void deleteFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    // Delete last node
    public void deleteLast() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    // Delete node by value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        // Case 1: delete head
        if (temp.data == value) {
            head = head.next;
            if (head != null) head.prev = null;
            System.out.println(value + " deleted.");
            return;
        }

        // Traverse to find node
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }
        // Update tail if last node is deleted
        if (temp.next == null) {
            tail = temp.prev;
        }
        // Update links
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;

        System.out.println(value + " deleted.");
    }

    // Reverse the DLL
    public void reverseDLL() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null)
            head = temp.prev;
    }
    // Search for a value
    public int search(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }
    // Main method to test DLL
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();

        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(30);
        System.out.printf("Print Forward: ");
        dll.printForward();    // 10 ⇆ 20 ⇆ 30 ⇆ null
        System.out.printf("Print Backward: ");
        dll.printBackward();   // 30 ⇆ 20 ⇆ 10 ⇆ null

        dll.deleteFirst();
        System.out.printf("Delete First: ");
        dll.printForward();    // 20 ⇆ 30 ⇆ null

        dll.deleteLast();
        System.out.printf("Delete Last: ");
        dll.printForward();    // 20 ⇆ null

        System.out.printf("Add First: ");
        dll.addLast(40);
        dll.addLast(50);
        dll.addFirst(10);
        dll.printForward();    // 10 ⇆ 20 ⇆ 40 ⇆ 50 ⇆ null
        System.out.printf("Delete by value: ");
        dll.deleteByValue(40);
        dll.printForward();    // 10 ⇆ 20 ⇆ 50 ⇆ null

        System.out.printf("Reverse: ");
        dll.reverseDLL();
        dll.printForward();    // 50 ⇆ 20 ⇆ 10 ⇆ null

        System.out.println("Search 20: index " + dll.search(20)); // 1
        System.out.println("Search 100: index " + dll.search(100)); // -1
    }
}
