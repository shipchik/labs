package Lab5;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeafMute {
    private final int id;

    DeafMute(int id) {
        this.id = id;
    }

    void eat() {
        System.out.println("Глухонемой " + id + " ест...");
    }

    void talk() {
        System.out.println("Глухонемой " + id + " общается на языке жестов...");
    }
}

public class task7 {
    public static void task(){
        final int NUM_DEAF_MUTES = 5;
        DeafMute[] deafMutes = new DeafMute[NUM_DEAF_MUTES];
        Lock[] forks = new ReentrantLock[NUM_DEAF_MUTES];

        for (int i = 0; i < NUM_DEAF_MUTES; i++) {
            deafMutes[i] = new DeafMute(i);
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < NUM_DEAF_MUTES; i++) {
            final int deafMuteId = i;
            new Thread(() -> {
                while (true) {
                    Lock rightFork = forks[deafMuteId];
                    Lock leftFork = forks[(deafMuteId + 1) % NUM_DEAF_MUTES];

                    rightFork.lock();
                    if (leftFork.tryLock()) {
                        try {
                            deafMutes[deafMuteId].eat();
                        } finally {
                            leftFork.unlock();
                        }
                    }
                    rightFork.unlock();

                    deafMutes[deafMuteId].talk();
                }
            }).start();
        }
    }
}
