import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class ProducerCOnsumer {

    public static BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {

          Thread producer = new Thread(new ProducerThread(q,()-> System.out.println("Producer finished")));
          Thread consumer = new Thread(new ConsumerThread(q,()-> System.out.println("Consumer finished")));

          producer.start();
          consumer.start();







        /*
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("From the main method , ending . . .");
    }
}

class ProducerThread implements Runnable{

    private BlockingQueue q;
    private FinishHandler finishHandler;

    public ProducerThread(BlockingQueue q, FinishHandler finishHandler) {
        this.q = q;
        this.finishHandler = finishHandler;
    }

    public void producer(){
        Random random = new Random();

        IntStream.range(0,50).forEach(value -> {
            try {
                q.put(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*while(true){
            try {
                q.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public void run() {
        System.out.println("Starting the producer");
        producer();
        finishHandler.handleFinished();
    }
}

class ConsumerThread implements Runnable{

    private BlockingQueue q;
    private FinishHandler finishHandler;

    public ConsumerThread(BlockingQueue q, FinishHandler finishHandler) {
        this.q = q;
        this.finishHandler = finishHandler;
    }

    private void consumer(){
        Random random = new Random();

        /*IntStream.range(0,20).forEach(value -> {
            try {
                Thread.sleep(100);

                if(random.nextInt(10) == 0){
                    Integer val = (Integer) q.take();
                    System.out.println("value is : "+val+" and the q size is : "+q.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        while(true){
            try {
                Thread.sleep(100);

                if(random.nextInt(10) == 0){
                    Integer val = (Integer) q.take();
                    System.out.println("value is : "+val+" and the q size is : "+q.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        System.out.println("Starting the consumer");
        consumer();
        finishHandler.handleFinished();
    }
}

@FunctionalInterface
interface FinishHandler{
    void handleFinished();
}