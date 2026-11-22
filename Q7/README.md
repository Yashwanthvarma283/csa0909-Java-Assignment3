# Q7 - Result Processing

## Files

- CreateFiles.java
- ResultProcessor.java

## How to compile and run

```
javac CreateFiles.java
java CreateFiles

javac ResultProcessor.java
java ResultProcessor
```

## Result

CreateFiles makes the score files in the current folder. Every 10th file is corrupt and every 25th file is missing.

ResultProcessor runs with 1, 2, 4 and 8 threads. Each run gives 8800 successes and 1200 failures. The time for each pool size is printed.
