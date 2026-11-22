class StationThread extends Thread {
    int stationNo;
    int scripts;
    int scanned = 0;

    StationThread(int stationNo, int scripts) {
        this.stationNo = stationNo;
        this.scripts = scripts;
    }

    public void run() {
        for (int i = 1; i <= scripts; i++) {
            scanned++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Station " + stationNo + " interrupted");
            }
        }
        System.out.println("Station " + stationNo + " scanned " + scanned);
    }
}

class StationRunnable implements Runnable {
    int stationNo;
    int scripts;
    int scanned = 0;

    StationRunnable(int stationNo, int scripts) {
        this.stationNo = stationNo;
        this.scripts = scripts;
    }

    public void run() {
        for (int i = 1; i <= scripts; i++) {
            scanned++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Station " + stationNo + " interrupted");
            }
        }
        System.out.println("Station " + stationNo + " scanned " + scanned);
    }
}

public class ScanDemo {
    public static void main(String[] args) throws InterruptedException {
        StationThread[] a = new StationThread[4];
        for (int i = 0; i < 4; i++) {
            a[i] = new StationThread(i + 1, 5 + i);
            a[i].start();
        }
        System.out.println("Station 1 alive: " + a[0].isAlive());
        int total1 = 0;
        for (int i = 0; i < 4; i++) {
            a[i].join();
            total1 = total1 + a[i].scanned;
        }
        System.out.println("Total by Thread: " + total1);

        StationRunnable[] r = new StationRunnable[4];
        Thread[] t = new Thread[4];
        for (int i = 0; i < 4; i++) {
            r[i] = new StationRunnable(i + 1, 5 + i);
            t[i] = new Thread(r[i]);
            t[i].start();
        }
        int total2 = 0;
        for (int i = 0; i < 4; i++) {
            t[i].join();
            total2 = total2 + r[i].scanned;
        }
        System.out.println("Total by Runnable: " + total2);

        StationThread x = new StationThread(9, 1);
        x.run();
        System.out.println("run() was called directly, no new thread was created");
    }
}
