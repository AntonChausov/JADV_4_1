import java.util.Random;

public class Operator extends Thread{
    final private int DELAY_MIN = 2000;
    final private int DELAY_MAX = 4000;

    public Operator(String name) {
        super(name);
    }

    @Override
    public void run() {
        ATC atc = ATC.getInstance();
        Random rnd = new Random();
        while (!isInterrupted() && atc.getCallLeft() > 0) {
            String call = atc.getCall();
            if (call == null){
                continue;
            }
            System.out.println("Оператор №" + getName() + " обработал звонок " + call);
            try {
                Thread.sleep(rnd.nextInt(DELAY_MAX - DELAY_MIN) + DELAY_MIN);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Оператор №" + getName() + " закончил работу");
    }
}
