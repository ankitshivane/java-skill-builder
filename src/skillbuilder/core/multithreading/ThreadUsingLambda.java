package skillbuilder.core.multithreading;

public class ThreadUsingLambda {
    public static void main(String[] args) {
        threadUsingLambda();
    }

    public static void threadUsingLambda() {
        Thread t1 = new Thread(() -> {
            System.out.println("Inside thread isAlive:" + Thread.currentThread().isAlive());
            for (int i = 0; i < 10; i++) {
                System.out.println("i=" + i);
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("isAlice before starting:" + t1.isAlive());
        t1.start();
//        System.out.println("isAlice is ended??:" + t1.isAlive());
    }
}
