import java.sql.Array;
import java.util.stream.IntStream;

// TIME MILLISNYA MASIH SALAH

public class ThreadTimeExecution {
    public static int sum = 0;
    public static int sumParallel = 0;
    public static int[] arr = new int[1000];

    static class MyNewThread extends Thread {
        private int id;

        public MyNewThread(int id) {
            this.id = id;
        }

        public void run() {
            int awal = id * 250;
            int akhir = (id + 1) * 250;
            int mySum = 0;

            for (int i = awal; i < akhir; i++) {
                mySum += arr[i];
            }

            sumParallel += mySum;
            System.out.println("sum paralel in thread: " + mySum);

        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.println(arr[i]);
        }

        // Serial sum
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            // Beban
            for (int j = 0; j < 1000; j++) {

            }
            sum += arr[i];
        }
        long endTime = System.currentTimeMillis();
        long timeExecution = endTime - startTime;

        System.out.println("sum serial: " + sum);
        System.out.println("serial time: " + timeExecution);

        MyNewThread th0 = new MyNewThread(0);
        MyNewThread th1 = new MyNewThread(1);
        MyNewThread th2 = new MyNewThread(2);
        MyNewThread th3 = new MyNewThread(3);

        startTime = System.currentTimeMillis();

        th0.start();
        th1.start();
        th2.start();
        th3.start();

        try {
            for (int j = 0; j < 1000; j++) {

            }
            th0.join();
            th1.join();
            th2.join();
            th3.join();
            endTime = System.currentTimeMillis();
            timeExecution = endTime - startTime;
            System.out.println("Paralel time: " + timeExecution);

        } catch (InterruptedException e) {

        }

    }
}
