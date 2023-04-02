import java.util.Scanner;

class Node {
    Node under;
    String data;
    
    Node (String data) {
        this.data = data;
    }
    
    Node () {
        
    }
}

class Stack {
    Node top;
    int size = 0;
    String popedData;
    
    boolean isEmpty() {
        return top == null;
    }
    
    void makeEmpty() {
        top = null;
    }
    
    void push (String newData) { //visit
        Node newNode = new Node(newData);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.under = top;
            top = newNode;
        }
        size++;
    }
    
    String peek() { //current
        if (isEmpty()) {
            return "Homepage";
        } else {
            return top.data;
        }
    }

    String back() { //back
        popedData = top.data;
        top = top.under;
        size--;
        return popedData;
    }
}

public class Solution {

    public static boolean prevForward;
    
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int process = sc.nextInt(); sc.nextLine();
        Stack stack = new Stack();
        Stack stackForward = new Stack();
        prevForward = false;
        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < process; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");
            if (splitted[0].toLowerCase().equals("visit")) { //ini tambah
                prevForward = false;
                stack.push(splitted[1]);
                stackForward.makeEmpty();
                //System.out.println("ini visit");
            } else if (splitted[0].toLowerCase().equals("back")) { 
                if (stack.isEmpty()) {
                    System.out.println("No pages back.");
                } else {
                    stackForward.push(stack.back());
                }
                //System.out.println("ini back");
            } else if (splitted[0].toLowerCase().equals("current")) {
                if (!prevForward) {
                    System.out.println(stack.peek());
                } else if (prevForward) {
                    System.out.println(stackForward.peek());
                }
                //System.out.println("ini current");
            } else if (splitted[0].toLowerCase().equals("forward")) {
                if (stackForward.isEmpty()) {
                    System.out.println("No pages forward.");
                } else {
                    prevForward = true;
                }
            }
        }
        sc.close();
    }
}