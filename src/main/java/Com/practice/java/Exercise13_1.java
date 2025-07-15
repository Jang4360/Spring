package Com.practice.java;

public class Exercise13_1 {
    public static void main(String[] args) {
        Runnable runnable = new Thread1();
        Thread th1 = new Thread(runnable);
        th1.start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}
//class Thread1 extends Thread{
//    public void run() {
//        for (int i = 0; i < 300; i++) {
//            System.out.print("-");
//        }
//    }
//}
