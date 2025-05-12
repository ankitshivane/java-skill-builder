package skillbuilder.core.multithreading.InterThreadComm.demo1;

class Consumer extends Thread {
    private SharedQueue shared;

    public Consumer(SharedQueue shared) {
        this.shared = shared;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                shared.consume();
                Thread.sleep(150); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
