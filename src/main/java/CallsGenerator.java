public class CallsGenerator extends Thread {

    final private int DELAY = 1000;
    final private int CALLS_COUNT = 20;

    @Override
    public void run() {
        ATC atc = ATC.getInstance();
        for (int i = 0; i < CALLS_COUNT; i++) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String call = Integer.toString(i + 1);
            atc.addCall(call);
            System.out.println("Поступил звонок " + call);
        }
    }
}
