class Wallet {
    int id;
    int balance;

    Wallet(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }
}

class TransferThread extends Thread {
    Wallet from;
    Wallet to;
    int amount;

    TransferThread(Wallet from, Wallet to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        synchronized (from) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            synchronized (to) {
                from.balance = from.balance - amount;
                to.balance = to.balance + amount;
                System.out.println("Transferred " + amount + " from " + from.id + " to " + to.id);
            }
        }
    }
}

public class WalletDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Wallet w1 = new Wallet(1, 1000);
        Wallet w2 = new Wallet(2, 1000);
        TransferThread t1 = new TransferThread(w1, w2, 100);
        TransferThread t2 = new TransferThread(w2, w1, 200);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Wallet 1: " + w1.balance);
        System.out.println("Wallet 2: " + w2.balance);
    }
}
