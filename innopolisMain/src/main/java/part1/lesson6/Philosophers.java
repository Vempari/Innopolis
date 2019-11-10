package part1.lesson6;

public class Philosophers {
    public static void main(String[] args) {
        new Worker().main();

    }
}

class Worker {
    Object lock = new Object();
    public void main() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                think();
                eat();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                think();
                eat();
                think();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                think();
                eat();
                think();
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                think();
                eat();
                think();
            }
        });
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                think();
                eat();
                think();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat() {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Философ " + Thread.currentThread().getName() + " ест");
        }
    }

    static void think() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Философ " + Thread.currentThread().getName() + " думает");
    }
}


