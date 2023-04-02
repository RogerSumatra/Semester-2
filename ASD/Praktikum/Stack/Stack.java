class Node {
    String data;
    Node under;

    Node (String data) {
        this.data = data;
    }

    Node() {
    }
}

public class Stack {
    Node top = null;
    int size = 0;

    boolean isEmpty() {
        return top == null;
    }

    void makeEmpty() {
        top = null;
    }

    void push (String newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.under = top;
            top = newNode;
        }
        size++;
    }

    String peek() {
        
        return (isEmpty())? "Stack kosong" : top.data;
    }

    String pop() {
        if (isEmpty()) {
            return "Kosong cuy";
        } else {
            String data = top.data;
            top = top.under;
            size--;
            return data;
        }
    }
}
