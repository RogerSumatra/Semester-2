import java.util.Scanner;

class Node {
    String data;
    float data2;
    Node next;

    public Node(String input, float data2) {
        next = null;
        this.data = input;
        this.data2 = data2;
    }

    public Node() {

    }
}

class Queue1 {
    Node head;
    Node tail;
    int size;
    public int k = 1;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return size;
    }

    void enqueue(String input, float data2) {
        Node newNode = new Node(input, data2);
        if (isEmpty()) {
            head = tail = newNode;
        } else if (getSize() == 1) {
            if (head.data2 < newNode.data2) {
                newNode.next = head;
                head = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        } else {
            if (newNode.data2 > head.data2) {
                newNode.next = head;
                head = newNode;
            } else if (newNode.data2 < tail.data2) {
                tail.next = newNode;
                tail = newNode;
            } else {
                Node temp = head;
                while (temp.next != null && temp.next.data2 >= newNode.data2) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        size++;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(k + ". " + temp.data + " (" + temp.data2 + ")");
            temp = temp.next;
            k++;
        }
    }
}

public class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue1 q = new Queue1();

        int n = sc.nextInt();
        sc.nextLine();

        String command = "";
        String[] splitted = new String[3];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");
            float nilai1 = Float.parseFloat(splitted[1]);
            float nilai2 = Float.parseFloat(splitted[2]);
            if (nilai2 == 1) {
                nilai2 = 0.2f;
            } else if (nilai2 == 0) {
                nilai2 = 0f;
            }
            float ipk = nilai1 + nilai2;
            q.enqueue(splitted[0], ipk);
        }
        q.printList();
    }
}