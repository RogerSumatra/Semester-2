class A {
    // private int y = 20;
    // int x = 15;
    // class B {
    //     int x = 10;
    //     void methodpadaB() {
    //         System.out.println("Hello, saya method di kelas B");
    //         System.out.println("Kelas B berada dalam kelas A");
    //         System.out.println("y = " + y);
    //         System.out.println("x di B = " + this.x);
    //         System.out.println("x di A = " + A.this.x);
    //     }
    // }
    // void methodPadaA() {
    //     B b = new B();
    //     System.out.println("Hello, saya method kelas A");
    //     System.out.println("Saya membuat object dari inner class B");
    //     b.methodpadaB();
    // }
    void methodPadaA() {
        class B {
            int i = 10;
            void methodpadaB() {
                System.out.println("i = " + i);
            }
        }
        B b = new B();
        b.methodpadaB();
    }
}