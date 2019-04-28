package Classes;

public class MyThread extends Thread {
    int t;
    int countDot;
    private boolean isInterrupted;
    public MyThread(int t)
    {
        this.t=t;
    }
    @Override
    public void run() {
        while (!isInterrupted) {
            try {
                System.out.print(".");
                countDot++;
                Thread.sleep(500);
                if (countDot % 5 == 0)
                    System.out.print("\b\b\b\b\b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void interupt()
    {
        isInterrupted=true;
    }
}
