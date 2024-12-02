package multithreading.waitAndNotify;

public class demoRunner {

    public static void main(String[] args)
    {

        // Make an instance of demo class
        demo obj = new demo();

        // Thread t1 will call part1()
        Thread t1 = new Thread(new Runnable() {
            public void run() { obj.part1(); }
        });

        // Thread t2 will call part2()
        Thread t2 = new Thread(new Runnable() {
            public void run() { obj.part2(); }
        });

        // Start t2 and then t1
        t2.start();
        t1.start();
    }
}