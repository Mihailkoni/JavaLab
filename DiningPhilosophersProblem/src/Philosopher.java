import java.util.Random;

public class Philosopher extends Thread {
    private final Bowl bowl;
    private final String name;
    private final Random random = new Random();
    private int riceEatenCount = 0;

    public Philosopher(Bowl bowl, String name) {
        this.bowl = bowl;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(name + " is thinking");
                Thread.sleep(random.nextInt(2000) + 1000);

                bowl.eat(name);
                riceEatenCount++;
                System.out.println(name + " ate the rice. Count: " + riceEatenCount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
