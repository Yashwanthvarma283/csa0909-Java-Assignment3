class BookThread extends Thread {
    SeatBookingRace screen;
    int seat;

    BookThread(SeatBookingRace screen, int seat) {
        this.screen = screen;
        this.seat = seat;
    }

    public void run() {
        screen.book(seat);
    }
}

public class SeatBookingRace {
    private final boolean[] booked;
    private int bookingsMade = 0;

    SeatBookingRace(int seats) {
        booked = new boolean[seats];
    }

    void book(int seat) {
        if (booked[seat] == false) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            booked[seat] = true;
            bookingsMade++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SeatBookingRace screen = new SeatBookingRace(10);
        BookThread[] users = new BookThread[100];
        for (int i = 0; i < users.length; i++) {
            users[i] = new BookThread(screen, i % 10);
            users[i].start();
        }
        for (int i = 0; i < users.length; i++) {
            users[i].join();
        }
        System.out.println("Seats sold: " + screen.bookingsMade);
    }
}
