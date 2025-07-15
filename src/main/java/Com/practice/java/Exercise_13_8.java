package Com.practice.java;

public class Exercise_13_8 {
    static boolean stopped = false;
    public static void main(String[] args) {
        Thread11 th1 = new Thread11();
        th1.start();
        try{
            Thread.sleep(6*1000);
        } catch (Exception e){}
        stopped = true;
        th1.interrupt();
        System.out.println("stopped");
    }
}
class Thread11 extends Thread{
    public void run() {
        for (int i = 0; !Exercise_13_8.stopped; i++){
            System.out.print(i);
            try{
                Thread.sleep(1*1000);
            }catch (Exception e){
                System.out.println("\nThread interrupted");
                return;
            }
        }
        System.out.println("Thread stopped");
    }
}
