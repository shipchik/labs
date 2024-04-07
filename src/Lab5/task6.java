package Lab5;
import java.io.*;

class DivisibleByTenPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

public class task6 {

    public static void task() throws InterruptedException{


        Thread thread1 = new Thread(new DivisibleByTenPrinter());
        Thread thread2 = new Thread(new DivisibleByTenPrinter());
        Thread thread3 = new Thread(new DivisibleByTenPrinter());

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
}
