import java.io.FileNotFoundException;
import java.io.FileReader;

public class WrongOrder {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("card.txt");
        } catch (Exception e) {
            System.out.println("General error");
        } catch (FileNotFoundException e) {
            System.out.println("File missing");
        }
    }
}
