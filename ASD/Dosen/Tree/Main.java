public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();
        Node nb1 = new Node(1);
        t.insert(nb1);

        Node nb2 = new Node(2);
        t.insert(nb1, 1, nb2);

        Node nb3 = new Node(3);
        t.insert(nb1, 1, nb3);

        Node nb4 = new Node(4);
        t.insert(nb1, 2, nb4);

        Node nb5 = new Node(5);
        t.insert(nb1, 3, nb5);

        Node nb6 = new Node(6);
        t.insert(nb1, 5, nb6);

        Node nb7 = new Node(7);
        t.insert(nb1, 5, nb7);
    }
}
