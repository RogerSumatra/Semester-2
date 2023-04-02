import java.util.Scanner;

//pake priority queue

class Node {
    Node next;
    String name;
    float IPK;
    
    Node(String name, float IPK) {
        this.name = name;
        this.IPK = IPK;
        this.next = null;
    }
    
    Node() {
        this.next = null;
    }
}

class PriorityQueue {
    Node front;
    Node back;
    int size;
    
    PriorityQueue() {
        front = null;
        back = null;
        size = 0;
    }
    
    boolean isEmpty() {
        return front == null && back == null;
    }
    
    void enqueue(String name, float IPK) {
        Node newNode = new Node(name, IPK);
        Node pointer = front;
        if (isEmpty()) {
            front = back = newNode;
        } else {
            if (newNode.IPK > front.IPK) {
                newNode.next = front;
                front = newNode;
            } else if (newNode.IPK < back.IPK) {
                back.next = newNode;
                back = newNode;
            } else {
                while (pointer.next != null && pointer.next.IPK >= newNode.IPK) {
                    pointer = pointer.next;
                }
                newNode.next = pointer.next;
                pointer.next = newNode;
            }
        }
        size++;
    }
    
    void print() {
        Node pointer = front;
        for (int i = 1; i < size + 1; i++) {
            System.out.println(i + ". " + pointer.name + " (" + pointer.IPK + ")");
            pointer = pointer.next;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PriorityQueue queue = new PriorityQueue();
        int n = input.nextInt(); input.nextLine();
        String command = "";
        String[] splitted = new String[3];

        for (int i = 0; i < n; i++) {
            command = input.nextLine();
            splitted = command.split(" ");
            String name = splitted[0];
            float IPK = Float.parseFloat(splitted[1]);
            float sertif = Float.parseFloat(splitted[2]);
            if (sertif == 1.0) {
                IPK += 0.2;
            }
            queue.enqueue(name, IPK);
        }
        queue.print();
    }
}