public class UncaughtDemo {
    static void show(int[] numbers) {
        System.out.println(numbers[5]);
    }

    public static void main(String[] args) {
        int[] numbers = new int[3];
        show(numbers);
        System.out.println("This line will not run");
    }
}
