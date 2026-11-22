import java.io.IOException;

class ExamException extends Exception {
    ExamException(String message) {
        super(message);
    }

    ExamException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ExamClosedException extends ExamException {
    ExamClosedException(String message) {
        super(message);
    }
}

class NotRegisteredException extends ExamException {
    NotRegisteredException(String message) {
        super(message);
    }
}

class SubmissionStorageException extends ExamException {
    SubmissionStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

class StorageLayer {
    void save(String fileName, long sizeKb) throws SubmissionStorageException {
        try {
            if (sizeKb > 500) {
                throw new IOException("Disk quota exceeded");
            }
            System.out.println("Saved " + fileName);
        } catch (IOException e) {
            throw new SubmissionStorageException("Could not store " + fileName, e);
        }
    }
}

class ServiceLayer {
    StorageLayer storage = new StorageLayer();

    void submit(boolean windowOpen, boolean registered, String fileName, long sizeKb)
            throws ExamException {
        if (!windowOpen) {
            throw new ExamClosedException("Exam window is closed");
        }
        if (!registered) {
            throw new NotRegisteredException("Student is not registered for this course");
        }
        storage.save(fileName, sizeKb);
    }
}

class ControllerLayer {
    ServiceLayer service = new ServiceLayer();

    void handle(boolean windowOpen, boolean registered, String fileName, long sizeKb) {
        try {
            service.submit(windowOpen, registered, fileName, sizeKb);
        } catch (ExamException e) {
            System.out.println("Error: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Cause: " + e.getCause().getMessage());
            }
        }
    }
}

public class ExamPortal {
    public static void main(String[] args) {
        ControllerLayer controller = new ControllerLayer();
        controller.handle(true, true, "answer01.pdf", 120);
        controller.handle(false, true, "answer02.pdf", 120);
        controller.handle(true, false, "answer03.pdf", 120);
        controller.handle(true, true, "answer04.pdf", 800);
    }
}
