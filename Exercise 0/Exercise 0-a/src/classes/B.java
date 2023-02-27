package classes;

public class B implements C {
    public final int number;

    public B(int number) {
        this.number = number;
        System.out.println("B");
    }

    public void f1() {
        System.out.println("f1");
    }

    public void f2() {
        System.out.println("f2");
    }

}