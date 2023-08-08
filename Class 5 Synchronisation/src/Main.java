public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(123, "John", 5000.0);

        MyThread t1 = new MyThread(true, 500.0, bankAccount);
        MyThread t2 = new MyThread(true, 300.0, bankAccount);

        long start = System.currentTimeMillis();

        t2.start();
        t1.start();


        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println(end-start);

        System.out.println(bankAccount.getBalance());

    }
}