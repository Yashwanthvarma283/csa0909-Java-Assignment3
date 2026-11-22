# Q6 - Tokens and Wallets

## Files

- TokenCounter.java
- WalletDeadlock.java
- WalletSafe.java

## How to compile and run

```
javac TokenCounter.java
java TokenCounter

javac WalletDeadlock.java
java WalletDeadlock

javac WalletSafe.java
java WalletSafe
```

## Result

Compile WalletDeadlock and WalletSafe one at a time because both contain the same classes.

- TokenCounter prints `Sum of tokens collected: 210 (expected 210)`.
- WalletDeadlock hangs because of the deadlock. Press Ctrl+C to stop it.
- WalletSafe finishes. Wallet 1 has 1100 and Wallet 2 has 900.
