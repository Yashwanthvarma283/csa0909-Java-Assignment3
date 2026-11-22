# Q2 - Exam Portal Exceptions

## Files

- StorageDemo.java
- ExamPortal.java

## How to compile and run

```
javac StorageDemo.java
java StorageDemo

javac ExamPortal.java
java ExamPortal
```

## Result

Compile the two files one at a time because both contain the same exception classes.

StorageDemo output:

```
Saved answer01.pdf
Error: Could not store answer02.pdf
Cause: Disk quota exceeded
```

ExamPortal prints a saved message, then the closed window error, the not registered error, and the storage error with its cause.
