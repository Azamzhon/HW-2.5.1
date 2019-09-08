import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore semaphore;
    private int places;
    CountDownLatch countDownLatch;


    public Passenger(Semaphore semaphore, int places, CountDownLatch countDownLatch) {
        this.places = places;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }


    @Override
    synchronized public void run() {
        try {
            semaphore.acquire();

            System.out.println("Пассажир купил билет № " + places);
            sleep(1000);

            System.out.println("Занято место № " + places);
            semaphore.release();

            sleep(1000);
            countDownLatch.countDown();

        } catch (InterruptedException i) {
            
        }

    }
}
