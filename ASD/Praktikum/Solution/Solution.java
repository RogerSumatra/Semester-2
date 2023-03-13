import java.util.Scanner;
 
class Node {
    String data;
    Node next;
    
    Node() {}
    
    Node(String input) {
        this.data = input;
        this.next = null;
    }
}
 
class SLL {
    Node head;
    Node tail;
    int size;
  
    boolean isEmpty() {
        return head == null && tail == null;
    }
 
    int getSize() {
        return this.size;
    }
  
    void addLast(String input) {
        Node nodeBaru = new Node(input);
        
        if (isEmpty()) {
            head = nodeBaru;
            tail = nodeBaru;
        } else {
            tail.next = nodeBaru;
            tail = nodeBaru;
        }
        this.size++;
    }
  
    void addFirst(String input) {
        Node nodeBaru = new Node(input);
        
        if (isEmpty()) {
            head = tail = nodeBaru;
        } else {
            nodeBaru.next = head;
            head = nodeBaru;
        }
        this.size++;
    }
  
    void printList() {
        Node pointer = new Node();
        
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            pointer = head;
            while (pointer != null) {
                System.out.print(pointer.data + " -> ");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
  
    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            head = head.next;
        }
        this.size--;
    }
  
    void removeLast() {
        Node pointer = new Node();
        if (isEmpty()) {
            System.out.println("List masih kosong.");
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
}
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        SLL sll = new SLL();
 
        int n = sc.nextInt(); // jumlah loop/input yg mau dimasukkan
        sc.nextLine(); // consume new line, tanya chatGPT aja kalo gatau
 
        String command = ""; // -> digunakan untuk input, misal : "MAKAN JAGUNG"
        String[] splitted = new String[2]; // -> split dari command, akan berisi [MAKAN, JAGUNG]
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");
 
            if (splitted[0].toLowerCase().equals("addfirst")) {
                sll.addFirst(splitted[1]);
            } else if (splitted[0].toLowerCase().equals("addlast")) {
                sll.addLast(splitted[1]);
            } else if (splitted[0].toLowerCase().equals("print")) {
                sll.printList();
            } else if (splitted[0].toLowerCase().equals("remove")) {
                if (splitted[1].toLowerCase().equals("last")) {
                    sll.removeLast();
                } else if (splitted[1].toLowerCase().equals("first")) {
                    sll.removeFirst();
                }
            }
        }
    }
}