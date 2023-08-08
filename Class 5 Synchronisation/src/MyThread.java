public class MyThread extends Thread{

    private boolean isDeposit;

    private Double amount;

    private BankAccount bankAccount;

    MyThread(boolean isDeposit, Double amount, BankAccount bankAccount) {
        this.isDeposit = isDeposit;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        test2();

    }

    public void test() {
        System.out.println("Inside Thread - " + currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // critical section
        // lock
        synchronized (bankAccount) {
            System.out.println("Inside synchronised - " + currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isDeposit) {
                bankAccount.depositMoney(amount);
            } else {
                bankAccount.withdraw(amount);
            }

            System.out.println("Operation performed" + currentThread());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void test2() {
        System.out.println("Inside Thread - " + currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // critical section
        // lock
            System.out.println("Inside synchronised - " + currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isDeposit) {
                bankAccount.depositMoney(amount);
            } else {
                bankAccount.withdraw(amount);
            }

            System.out.println("Operation performed" + currentThread());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }


}

