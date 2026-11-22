class BookThread extends Thread {
    SeatBookingBlock screen;
    int seat;

    BookThread(SeatBookingBlock screen, int seat) {
        this.screen = screen;
        this.seat = seat;
    }

    public void run() {
        screen.book(seat);
    }
}

public class SeatBookingBlock {
    private final boolean[] booked;
    private int bookingsMade = 0;

    SeatBookingBlock(int seats) {
        booked = new boolean[seats];
    }

    void book(int seat) {
        synchronized (this) {
            if (booked[seat] == false) {
                booked[seat] = true;
                bookingsMade++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SeatBookingBlock screen = new SeatBookingBlock(10);
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
