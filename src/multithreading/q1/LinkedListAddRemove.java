package multithreading.q1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListAddRemove {
    static Random rand = new Random();
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        Thread adder = new Thread(() ->{
            for(int i = 0; i < 100; i++){
                synchronized (list){
                    list.add(rand.nextInt());
                }

                try {
                    Thread.sleep(rand.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread remover = new Thread(() ->{
            for(int i = 0; i < 100; i++){
                synchronized (list){
                    if (!list.isEmpty()) {
                        list.removeFirst();
                    }
                }
                try{
                   Thread.sleep(rand.nextInt(10));
               } catch (Exception e){

               }
           }
        });

        adder.start();
        remover.start();

        try {
            adder.join();
            remover.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Current size: " + list.size());

    }
}
