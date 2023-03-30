import java.util.Scanner;

class NodeCSLL {
    NodeCSLL next;
    String namaInput;
    

    NodeCSLL() {}
    NodeCSLL(String namaInput) {
        this.next = next;
        this.namaInput = namaInput;        
    }
}

class CSLL {
    NodeCSLL kepala;
    NodeCSLL ekor;
    String namaInput;
    NodeCSLL balon = new NodeCSLL(namaInput);
    int size;
      
    boolean isEmpty() {
        return kepala == null && ekor == null;
    }

    int getSize() {
        return this.size;
        
    }
    
    void addFirst(String newData) {
        NodeCSLL nodeBaru = new NodeCSLL(newData);
        if(isEmpty()){
            kepala = ekor = nodeBaru;
            ekor.next = kepala;
        }
        else{
            nodeBaru.next = kepala;
            kepala = nodeBaru;
            ekor.next = kepala;
        }
        this.size++;
        balon = nodeBaru;
    }
    
    void addLast(String newData) {
        NodeCSLL nodeBaru = new NodeCSLL(newData);
        if(isEmpty()){
            kepala = ekor = nodeBaru;
            ekor.next = kepala;            
        }
        else{
            ekor.next = nodeBaru;
            ekor = nodeBaru;
            ekor.next = kepala;
        }
        this.size++;
        balon = nodeBaru;
    }

    void printList() {
        NodeCSLL temp = new NodeCSLL();
        temp = kepala.next;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else if(getSize() == 1){
            System.out.print(kepala.namaInput + " -> ");
        }
        else{
            System.out.print(kepala.namaInput + " -> ");
            while(temp != kepala){
                System.out.print(temp.namaInput + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }        
    }

    void balloonPass() {
        // NodeCSLL temp = new NodeCSLL();
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else if(getSize() == 1){
            System.out.println("Tidak bisa oper.");
        }
        else{
            balon = balon.next;
        }        
    }
    
    void balloonLocation() {
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else{
            System.out.println("Balon ada pada " + balon.namaInput + ".");
        }
        
    }

    void balloonExplode() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            System.out.println("Boom! " + balon.namaInput + " kalah.");
            
            System.exit(0);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        CSLL list = new CSLL();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); sc.nextLine();

        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toLowerCase().equals("addfirst")) {
                list.addFirst(splitted[1]);
                
            } else if (splitted[0].toLowerCase().equals("addlast")) {
                list.addLast(splitted[1]);
                
            } else if (splitted[0].toLowerCase().equals("print")) {
                list.printList();
                
            } else if (splitted[0].toLowerCase().equals("balloon")) {
                if (splitted[1].toLowerCase().equals("loc")) {
                    list.balloonLocation();
                    
                } else if (splitted[1].equals("pass")) {
                    list.balloonPass();
                    
                } else if (splitted[1].toLowerCase().equals("boom")) {
                    list.balloonExplode();
                    
                }
            }
        }
    }
}