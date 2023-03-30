public class ASDC {
    public static void main(String[] args) {
        //LinkedList barisan = new LinkedList();

        // Node node1 = new Node();
        // node1.data = 10;
        // barisan.addLast(node1);

        // Node node2 = new Node();
        // node2.data = 15;
        // barisan.addLast(node2);

        // Node node3 = new Node();
        // node3.data = 30;
        // barisan.addLast(node3);

        // Node node4 = new Node();
        // node4.data = 5;
        // barisan.addFirst(node4);

        // Node node5 = new Node();
        // node5.data = 13;
        // barisan.addAfter(10, node5);

        // System.out.println(barisan.get(5));

        // DoubleLL barisan = new DoubleLL();

        // NodeDouble node1 = new NodeDouble();
        // node1.data = 5;
        // barisan.addFirst(node1);

        // NodeDouble node2 = new NodeDouble();
        // node2.data = 10;
        // barisan.addFirst(node2);

        // barisan.print();
        //===================================================================
        // Stack tumpukanArray = new Stack(5);
        // tumpukanArray.push(100);
        // tumpukanArray.push(300);
        // tumpukanArray.push(200);
        // tumpukanArray.push(600);
        // tumpukanArray.push(800);
        // int terambil1 = tumpukanArray.pop();
        // System.out.println("Terambil " + terambil1);
        // int terambil2 = tumpukanArray.pop();
        // System.out.println("Terambil " + terambil2);
        // tumpukanArray.push(900);
        // tumpukanArray.printStack();
        //=====================================================================
        Queue ant = new Queue(5);
        ant.enqueue(10);
        ant.enqueue(20);
        ant.dequeue();
        ant.display();

    }
}
