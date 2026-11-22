import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 5000;
        try {
            System.out.print("Enter account number: ");
            int account = sc.nextInt();
            System.out.print("Enter amount: ");
            int amount = sc.nextInt();
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
            if (amount > balance) {
                throw new Exception("Not enough balance");
            }
            FileReader reader = new FileReader("card.txt");
            balance = balance - amount;
            System.out.println("Collect your cash: " + amount);
            System.out.println("Balance left: " + balance);
            reader.close();
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Card reader file is missing");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using the ATM");
        }
    }
}
