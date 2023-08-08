import java.util.ArrayList;

class A extends Thread {
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("hiii");
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("heyyyy");
        }
        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.setDaemon(true);
        a.start();

    }
}