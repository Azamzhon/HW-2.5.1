import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 1; i <= 100 ; i++) {

            new Passenger(semaphore,i,countDownLatch).start();

        }

        countDownLatch.await();

        System.out.println("Заполнено!");

    }
}
