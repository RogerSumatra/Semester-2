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

    public void print() {
        NodeDouble temp = kepala;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;

        }
    }
}
