public class Main {
    public static void main (String[] args) {
        int[][] soal = {
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 0},
        };
        int start = 2;
        int end = 7;
        CariJalan test = new CariJalan();
        test.run(soal, start, end);

        System.out.println("pencarian " + start + " sampai " + end);

        System.out.println("===========================");

        test.stack.printStack();

        System.out.println("===========================");
        // Stack tes = new Stack();
        // tes.push(0);
        // tes.push(1);
        // System.out.println(tes.peek());
        // tes.printStack();

        // Queue tes = new Queue();
        // tes.enqueue(1);
        // tes.enqueue(2);
        // tes.enqueue(3);
        // tes.display();
        // System.out.println(tes.checkFront());
        // int temp = tes.dequeue();
        // System.out.println(temp + " telah terambil");
        // tes.display();

        //check queue every number
        // Queue[] connect2 = test.queue;
        // for (int i = 0; i < connect2.length; i++) {
        //     System.out.println(i + ": ");
        //     connect2[i].display();
        //     System.out.println("");
        // }

    }
}



