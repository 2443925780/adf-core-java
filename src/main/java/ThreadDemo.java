import java.time.LocalDateTime;


public  class ThreadDemo{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("huangjing-1 current time " + LocalDateTime.now());
        });
        Thread t2 = new Thread(() -> {
            System.out.println("huangjing-2 current time " + LocalDateTime.now());
        });
        Thread t3 = new Thread(() -> {
            System.out.println("huangjing-3 current time " + LocalDateTime.now());
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("huangjing:所有子线程结束");
    }

}

