/*
 * Nama     : Daffarel Adyatma Winuradmaja
 * NIM      : 225150201111016
 * Kelas    : TIF - C
 */

public class Stack {
    Node top;
    int size;
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int pop() { //untuk buang data terakhir
        if (isEmpty()) {
            System.out.println("Stack Kosong untuk pop");
            return 0;
        } else {
            Node temp = top; //removeLast dari linkedlist
            top = top.pointer;
            size--;
            return temp.data;
        }
    }

    public void push(int newData) { //addLast linkedlist. untuk add data
        Node newNode = new Node(newData);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.pointer = top;
            top = newNode;
        }
        size++;
    }

    public int peek() { //untuk lihat data top (yang ditambah terakhir)
        return top.data;
    }

    public void printStack() { //cetak data dari kiri ke kanan
        Node temp = top;
        int[] holder = new int[size];
        int index = size - 1;
        while (temp != null) {
            holder[index] = temp.data;
            temp = temp.pointer;
            index--;
        }
        for (int i = 0; i < holder.length; i++) {
            if (i == 0) {
                System.out.print(holder[i]);
            } else {
                System.out.print(" --> " + holder[i]);
            }
           
        }
        System.out.println("");
    }
}