class CNode{
    int data;
    CNode next;

    CNode() {}

    CNode(int input) {
        this.data = input;
        this.next = null;
    }
}

class CList {
    CNode head;
    CNode tail;
    int size;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return this.size;
    }

    void addLast(int inputData) {
        CNode newNode = new CNode(inputData);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    void addFirst(int inputData) {
        CNode newNode = new CNode(inputData);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong bro");
        } else if (getSize() == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        this.size--;
    }

    void removeLast() {
        CNode pointer = new CNode();
        pointer = head;
        if (isEmpty()) {
            System.out.println("List kosong bro");
        } else if (getSize() == 1) {
            head = tail = null;
        } else {
            while(pointer.next != tail) {
                pointer = pointer.next;
            }
            tail = pointer;
            tail.next = null;
        }
        this.size--;
         
    }

    void printList() {
        CNode pointer = new CNode();

        if (isEmpty()) {
            System.out.println("List kosong bro");
        } else {
            pointer = head;
            while (pointer != null) {
                System.out.print(pointer.data + " --> ");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }

}

// public class Main {
//     public static void main(String[] args) {
//         CList list = new CList();
//         list.addFirst(0);
//         list.addFirst(-6);
//         list.addLast(1);
//         list.addLast(2);
//         list.addLast(5);
//         list.removeFirst();
//         list.removeLast();
//         list.removeLast();
        

//         list.printList();
        
//     }
// }