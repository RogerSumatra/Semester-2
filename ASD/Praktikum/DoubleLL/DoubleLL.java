import java.util.Scanner;

class NodeDLL {
    NodeDLL next;
    NodeDLL prev;
    String data;

    NodeDLL() {
        this.next = null;
        this.prev = null;
    }

    NodeDLL(String newData) {
        this.data = newData;
    }
}

class DLL {
    NodeDLL head;
    NodeDLL tail;
    int size;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return size;
    }

    void addFirst(String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    void addLast(String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        if (getSize() == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            
        }
        this.size ++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            if (getSize() == 1) {
                head = tail = null;
            } else {
                head = head.next; 
                head.next.prev = null;
                head.prev = null;
            }
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            if (getSize() == 1) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
            }
        }
        size--;
    }

    void printForward() {
        NodeDLL pointer = new NodeDLL();
        pointer = head;
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            while(pointer != null) {
                System.out.print(pointer.data + " <--> ");
                pointer = pointer.next;
            }
            System.out.println("");
        }
    }

    void printBackward() {
        NodeDLL pointer = new NodeDLL();
        pointer = head;
        if (isEmpty()) {
        System.out.println("List masih kosong.");
        } else {
            while (pointer != null) {
                System.out.print(pointer.data + " <--> ");
                pointer = pointer.prev;
            }
            System.out.println();
        }
        
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DLL dll = new DLL();

        int n = sc.nextInt();
        sc.nextLine();

        String command = "";
        String[] splitted = new String[3];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toUpperCase().equals("ADD")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.addFirst(splitted[2]);
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.addLast(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("REMOVE")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.removeFirst();
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.removeLast();
                }
            } else if (splitted[0].toUpperCase().equals("PRINT")) {
                if (splitted[1].toUpperCase().equals("FWD")) {
                    dll.printForward();
                } else if (splitted[1].toUpperCase().equals("BWD")) {
                    dll.printBackward();
                }
            }
        }
    }
}