# Q1 - ATM Withdrawal

## Files

- ATM.java
- WrongOrder.java
- UncaughtDemo.java

## Setup

Create an empty file named `card.txt` in this folder. Delete it to test the missing file case.

## How to compile and run

```
javac ATM.java
java ATM

javac WrongOrder.java

javac UncaughtDemo.java
java UncaughtDemo
```

## Result

- ATM with `123` and `500` prints the cash and the balance 4500.
- ATM with letters prints Invalid input.
- ATM with a negative amount prints Invalid input.
- ATM with `9000` prints Error: Not enough balance.
- ATM without card.txt prints Card reader file is missing.
- The finally block prints the thank you line every time.
- WrongOrder.java does not compile. The compiler says the exception FileNotFoundException has already been caught.
- UncaughtDemo.java stops with an ArrayIndexOutOfBoundsException and prints the stack trace.
