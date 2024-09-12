class MyThread extends Thread {
    public void run() {
        System.out.println("this thread is running");
    }
}

class MyThread2 implements Runnable {
    int threadNumber;

    public MyThread2(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " from thread " + threadNumber);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        for (int i = 0; i < 3; i++) {
            MyThread2 ThreadObject = new MyThread2(i);
            Thread t2 = new Thread(ThreadObject);
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {

            }
        }

    }
}
