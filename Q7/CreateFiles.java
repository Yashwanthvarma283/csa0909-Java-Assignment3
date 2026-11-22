import java.io.PrintWriter;

public class CreateFiles {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            if (i % 25 != 0) {
                PrintWriter out = new PrintWriter("score" + i + ".txt");
                if (i % 10 == 0) {
                    out.println("abc");
                } else {
                    out.println(60 + i % 40);
                    out.println(50 + i % 50);
                    out.println(70 + i % 30);
                }
                out.close();
            }
        }
        System.out.println("Files created");
    }
}
