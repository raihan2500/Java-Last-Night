package multithreading.queueImplement;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadSafeQueue <T> {
    private final int MAX_SIZE = 10;
    private final Queue<T> queue = new LinkedList<>();

    public synchronized void add(T element) throws Exception{
        while (queue.size() == MAX_SIZE){
            wait();
        }
        queue.offer(element); // Same as add()
        /* Note for offer() method
            Returns a boolean: true if the element was added successfully, false if the queue is full (in case of bounded queues).
            Non-Blocking: Unlike add(), which throws an exception if the queue is full, offer() simply returns false.
         */
        notifyAll();
    }

    synchronized T remove()throws Exception{
        while (queue.isEmpty()){
            wait();
        }
        T element = queue.poll(); //Same ass remove()
        /* Note for poll()
            The queue.poll() method in Java is used to retrieve and remove the head of the queue, or return null if the queue is empty.
         */
        notifyAll();
        return  element;
    }

    synchronized boolean isEmpty(){
        return queue.isEmpty();
    }

    synchronized boolean isFull(){
        return queue.size() == MAX_SIZE;
    }
}
