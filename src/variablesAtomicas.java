
public class variablesAtomicas {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread first = new Thread(counter, "First");
        Thread second = new Thread(counter, "First");
        first.start();
        second.start();
        Thread.sleep(2000);
        System.out.println(Counter.count);
    }

    static class Counter extends Thread{
        public static int count = 0;
        public void run(){
            for (int i = 0; i < 100_000_000 ; i++) {
                count++;
            }
        }
    }
}
