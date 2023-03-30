public class Stack {
    int top;
    int[] tumpukan;
    int arraySize;

    public Stack(int arraySize) {
        this.arraySize = arraySize;
        tumpukan = new int[arraySize];
        top = -1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == arraySize - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (!isFull()) {
            top++;
            tumpukan[top] = value;
        } else {
            System.out.printf("Stack penuh bro! Value %d gagal masuk\n", value);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int temp = tumpukan[top];
            top--;
            return temp;
        } else {
            System.out.printf("Stacknya masih kosong bro. Isi dulu lah\n");
            return -1;
        }

    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(tumpukan[i]);
        }
    }
}
