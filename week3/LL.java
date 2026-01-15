class LL {
        Node head;
        private int size;
        LL() {
            size = 0;
        }
        // Node class
        public class Node {
            String data;
            Node next;

            Node(String data) {
                this.data = data;
                this.next = null;
                size++;
            }
        }
        // Add at beginning
        public void addFirst(String data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        // Add at end
        public void addLast(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        // Print list
        public void printList() {
            Node currNode = head;

            while (currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }
        // Remove first node
        public void removeFirst() {
            if (head == null) {
                System.out.println("Empty List, nothing to delete");
                return;
            }
            head = head.next;
            size--;
        }
        // Remove last node
        public void removeLast() {
            if (head == null) {
                System.out.println("Empty List, nothing to delete");
                return;
            }
            size--;
            if (head.next == null) {
                head = null;
                return;
            }
            Node secondLast = head;
            Node lastNode = head.next;
            while (lastNode.next != null) {
                secondLast = secondLast.next;
                lastNode = lastNode.next;
            }
            secondLast.next = null;
        }
        // Search element
        public boolean search(String key) {
            Node currNode = head;

            while (currNode != null) {
                if (currNode.data.equals(key)) {
                    return true;
                }
                currNode = currNode.next;
            }
            return false;
        }

        // Get size
        public int getSize() {
            return size;
        }
        // Main method
        public static void main(String args[]) {
            LL list = new LL();

            list.addLast("is");
            list.addLast("a");
            list.addLast("list");
            list.printList();

            list.addFirst("this");
            list.printList();

            System.out.println("Size: " + list.getSize());

            list.removeFirst();
            list.printList();

            list.removeLast();
            list.printList();

            System.out.println("Search 'list': " + list.search("list"));
            System.out.println("Search 'hello': " + list.search("hello"));
        }
    }


