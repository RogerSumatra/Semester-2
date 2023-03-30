public class DoubleLL {
    NodeDouble kepala;
    NodeDouble ekor;
    int size;

    public DoubleLL() {
        kepala = null;
        ekor = null;
        size = 0;
    }

    public void addFirst(NodeDouble nodeBaru) {
        if (kepala == null) {
            kepala = ekor = nodeBaru;
        } else {
            kepala.previous = nodeBaru;
            nodeBaru.next = kepala;
            kepala = nodeBaru;
        }
    }

    public void addLast(NodeDouble nodeBaru) {
        if (size == 0) {
            kepala = ekor = nodeBaru;
        }
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List Kosong");
        } else {
            if (size == 1) {
                kepala = ekor = null;
            } else {
                kepala = kepala.next;
                kepala.previous.next = null;
            }
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("List masih kosong");
        }
    }

    public void print() {
        NodeDouble temp = kepala;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;

        }
    }
}

class NodeDouble {
    int data;
    NodeDouble previous;
    NodeDouble next;

    NodeDouble() {
        next = null;
        previous = null;
    }
}
