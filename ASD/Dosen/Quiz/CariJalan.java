/*
 * Nama     : Daffarel Adyatma Winuradmaja
 * NIM      : 225150201111016
 * Kelas    : TIF - C
 */

public class CariJalan {
    int start;
    int end;
    Queue[] queue; //queue untuk tiap nomor
    Stack stack; //jawaban

    public void run(int[][] soal, int start, int end) { //menyimpan queue pada setiap nomor
        this.start = start;
        this.end = end;
        this.queue = new Queue[soal.length];
        this.stack = new Stack();
        for (int i = 0; i < soal.length; i++) {
            queue[i] = new Queue();
            for (int j = 0; j < soal[i].length; j++) {
                if (soal[i][j] == 1) {
                    queue[i].enqueue(j);
                }
            }
        }

        // for (int i = 0; i < queue.length; i++) {
        //     System.out.println(i + " size " + queue[i].size + ": ");
        //     queue[i].display();
        //     System.out.println("");
        // }
        // System.out.println("==================");

        //tambah start ke stack
        stack.push(start);
        //System.out.printf("Front dari %d adalah %d\n", start, queue[start].checkFront());
        for (int i = 0; i < queue.length; i++) { //dequeue kalo queue selain index ada yang sama
            if (queue[i].checkFront() == 0 && queue[i].size == 0) {
                queue[i].front = null;
            } else if (queue[i].checkFront() == start) {
                //System.out.printf("i = %d, checkFront = %d, update = %d\n", i, queue[i].checkFront(), start);
                queue[i].dequeue();
                //System.out.printf("i = %d, checkFront = %d, update = %d\n\n", i, queue[i].checkFront(), start);
            }
        }
        find(start);

    }

    public void find(int index) {
        if (stack.peek() != end) {
            if (!(queue[index].isEmpty())) { //kalo ada queue
                //System.out.printf("Front dari %d adalah %d\n", index, queue[index].checkFront());
                int update = queue[index].dequeue();
                //System.out.println("Update adalah = " + update);
                checkQueue(queue, stack, update);
                stack.push(update);
                //System.out.println("update telah ditambah = " + update); System.out.println("");
                //System.out.println("Stack = "); stack.printStack();
                find(update);
                
                
            } else {
                //System.out.println("jalan buntu\n");
                int temp = stack.pop();
                //System.out.println("dibuang " + temp);
                //System.out.println("");
                find(stack.peek());
            }
        } else if (stack.peek() == end) {
            System.out.println("Done");
        }
    }

    public void checkQueue(Queue[] queue, Stack stack, int update) {
        //menambahkan data stack ke array
        int[] valueOfStack = new int[stack.size + 1];
        Node temp = stack.top;
        for (int i = 0; i < stack.size; i++) {
            valueOfStack[i] = temp.data;
            temp = temp.pointer;
        }
        valueOfStack[valueOfStack.length - 1] = update;

        for (int i = 0; i < queue.length; i++) { //dequeue kalo queue selain index ada yang sama
            for (int j = 0; j < valueOfStack.length; j++) {
                if (queue[i].checkFront() == 0 && queue[i].size == 0) {
                    queue[i].front = null;
                } else if (queue[i].checkFront() == valueOfStack[j]) {
                    //System.out.printf("i = %d, checkFront = %d, update = %d\n", i, queue[i].checkFront(), valueOfStack[j]);
                    queue[i].dequeue();
                    //System.out.printf("i = %d, checkFront = %d, update = %d\n\n", i, queue[i].checkFront(), valueOfStack[j]);
                }
            }
        }
        // System.out.println(Arrays.toString(valueOfStack));
    }
}
