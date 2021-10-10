public class Main {

    final private static int DELAY = 3100;

    public static void main(String[] args) throws InterruptedException {
        CallsGenerator callsGenerator = new CallsGenerator();
        callsGenerator.start();
        Thread.sleep(DELAY); // Чтобы 3 звонка успели сгенерироваться
        new Operator("1").start();
        new Operator("2").start();
        new Operator("3").start();

    }
}
