import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportTwr {
    static int readStore(String name) throws IOException {
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line = br.readLine();
            while (line != null) {
                sum = sum + Integer.parseInt(line);
                line = br.readLine();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] files = {"store1.txt", "store2.txt", "missing.txt", "store3.txt"};
        int total = 0;
        try (PrintWriter out = new PrintWriter("summary_twr.txt")) {
            for (int i = 0; i < files.length; i++) {
                try {
                    int s = readStore(files[i]);
                    out.println(files[i] + " = " + s);
                    total = total + s;
                } catch (Exception e) {
                    System.out.println("Failed file: " + files[i] + " - " + e);
                }
            }
            out.println("Total = " + total);
        } catch (IOException e) {
            System.out.println("Cannot write the summary file");
        }
        System.out.println("Report finished. Total = " + total);
    }
}
