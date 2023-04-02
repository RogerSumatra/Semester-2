class QueueArray {
    int front;
    int rear;
    int[] antrian;
    int arraySize;

    public QueueArray(int arraySize) {
        this.arraySize = arraySize;
        antrian = new int[arraySize];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        if (rear == -1) {
            return true;

        } else {
            return false;

        }
    }

    public boolean isFull() {
        if (rear == arraySize - 1) {
            return true;

        } else {
            return false;

        }
    }

    public void enqueue(int val) {
        if (!isFull()) {
            rear++;
            antrian[rear] = val;
        } else {
            System.out.println("antrean penuh");
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int temp = antrian[front];
            for (int i = 0; i < rear - 1; i++) {
                antrian[i] = antrian[i + 1];
            }
            rear--;
            return temp;

        } else {
            System.out.println("antrian kosong");
            return -1;
        }

    }

    public void display() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(antrian[i] + " ");

        }

    }
}


public class Queue {
    public static void main(String[] args) {
        QueueArray ant = new QueueArray(5);
        ant.enqueue(10);
        ant.enqueue(20);
        ant.dequeue();

        ant.display();
    }
}