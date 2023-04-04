public class Queue {
    Node front, rear;
    int size;

    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }


    public void enqueue(int newData) { //addlast
        Node newNode = new Node(newData);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.pointer = newNode;
            rear = newNode;
        }
        size++;
        
    }

    public int dequeue() { //removefirst
        if (!isEmpty()) {
            int pickData = front.data;
            front = front.pointer;
            size--;
            return pickData;
        } else {
            //System.out.println("Queue kosong untuk dequeue");
            return -1;
        }
        
    }

    public void display() {
        if (isEmpty()) {
            //System.out.println("Queue kosong untuk di display");
        } else {
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.pointer;
            }
            System.out.println("");
            
        }
    }

    public int checkFront() {
        if (isEmpty()) {
            //System.out.println("Queue masih kosong");
            return 0;
        } else {
            return front.data;
        }
    }
}
