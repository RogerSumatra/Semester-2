package Materi;

public class Queue {
    int front;
    int rear;
    int[] antrean;
    int arraySize;

    public Queue(int arraySize) {
        this.arraySize = arraySize;
        antrean = new int[arraySize];
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

    public void enqueue(int value  ) {
        if (!isFull()) {
            rear++;
            antrean[rear] = value;
        } else {
            System.out.println("Penuh bang");
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int temp = antrean[front];
            for (int i = 0; i < rear - 1; i++) {
                antrean[i] = antrean[i + 1];
            }
            rear--;
            return temp;
        } else {
            System.out.println("Antrian kosong");
            return -1;
        }
    }

    public void display() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(antrean[i] + " ");
        }
        System.out.println("");
    }
}
