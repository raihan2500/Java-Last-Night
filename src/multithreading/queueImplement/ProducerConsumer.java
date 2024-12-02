package multithreading.queueImplement;

import java.util.Date;

public class ProducerConsumer {
    public static void main(String[] args) {

        ThreadSafeQueue<String> queue = new ThreadSafeQueue<>();

        //Producer
        Thread producer = new Thread(()->{
            for(int i = 0; i < 100; i++){
                try {
                    String time = new Date().toString();
                    queue.add(time);
                    System.out.println("Produced: " + time);
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        //Consumer
        Thread consumer = new Thread(()->{
            for(int i = 0; i < 100; i++){
                try {
                    String element = queue.remove();
                    System.out.println("Consumed: " + element);
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done.");
    }
}
