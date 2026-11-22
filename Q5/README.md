# Q5 - Cinema Seat Booking

## Files

- SeatBooking.java
- SeatBookingRace.java
- SeatBookingBlock.java

## How to compile and run

```
javac SeatBooking.java
java SeatBooking

javac SeatBookingRace.java
java SeatBookingRace

javac SeatBookingBlock.java
java SeatBookingBlock
```

## Result

- SeatBooking (synchronized method) prints `Seats sold: 10`.
- SeatBookingBlock (synchronized block) prints `Seats sold: 10`.
- SeatBookingRace has no synchronization. It sells more than 10 seats and the number changes on every run.
