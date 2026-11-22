import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ScoreTask implements Callable<Integer> {
    String fileName;
    ConcurrentHashMap<String, String> status;

    ScoreTask(String fileName, ConcurrentHashMap<String, String> status) {
        this.fileName = fileName;
        this.status = status;
    }

    public Integer call() throws Exception {
        int total = 0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line = br.readLine();
            while (line != null) {
                int mark = Integer.parseInt(line);
                if (mark < 0 || mark > 100) {
                    throw new Exception("Mark out of range");
                }
                total = total + mark;
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        status.put(fileName, "OK");
        return total;
    }
}

public class ResultProcessor {
    public static void main(String[] args) throws InterruptedException {
        int[] poolSizes = {1, 2, 4, 8};
        int totalFiles = 10000;

        for (int p = 0; p < poolSizes.length; p++) {
            ConcurrentHashMap<String, String> status = new ConcurrentHashMap<String, String>();
            ExecutorService pool = Executors.newFixedThreadPool(poolSizes[p]);
            ArrayList<Future<Integer>> futures = new ArrayList<Future<Integer>>();

            long start = System.currentTimeMillis();
            for (int i = 0; i < totalFiles; i++) {
                ScoreTask task = new ScoreTask("score" + i + ".txt", status);
                futures.add(pool.submit(task));
            }

            int success = 0;
            int failed = 0;
            int sum = 0;
            for (int i = 0; i < futures.size(); i++) {
                try {
                    sum = sum + futures.get(i).get();
                    success++;
                } catch (ExecutionException e) {
                    failed++;
                    status.put("score" + i + ".txt", "FAILED");
                }
            }
            pool.shutdown();
            long end = System.currentTimeMillis();

            System.out.println("Threads: " + poolSizes[p]);
            System.out.println("Success: " + success);
            System.out.println("Failed: " + failed);
            System.out.println("Total marks: " + sum);
            System.out.println("Recorded in map: " + status.size());
            System.out.println("Time: " + (end - start) + " ms");
            System.out.println();
        }
    }
}
