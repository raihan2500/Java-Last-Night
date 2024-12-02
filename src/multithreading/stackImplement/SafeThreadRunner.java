package multithreading.stackImplement;

public class SafeThreadRunner {
    public static void main(String[] args) {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();

        Thread pushThread = new Thread(()->{
            for(int i = 0; i < 10; i++){
                stack.push(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread popThread = new Thread(()->{
           for(int i = 0; i < 10; i++){
               stack.pop();
               try {
                   Thread.sleep(200);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        pushThread.start();
        popThread.start();

        try {
            pushThread.join();
            popThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
