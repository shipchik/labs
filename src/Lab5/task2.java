package Lab5;
import java.util.TreeSet;

class NumberStorage {
    private TreeSet<Integer> numbers;

    public NumberStorage() {
        numbers = new TreeSet<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void removeNumber(int number) {
        numbers.remove(number);
    }

    public int findClosest(int target) {
        Integer floor = numbers.floor(target);
        Integer ceiling = numbers.ceiling(target);

        if (floor == null) {
            return ceiling;
        } else if (ceiling == null) {
            return floor;
        } else {
            return Math.abs(target - floor) < Math.abs(target - ceiling) ? floor : ceiling;
        }
    }
}

public class task2 {

    public static void task(){
        NumberStorage storage = new NumberStorage();


        storage.addNumber(10);
        storage.addNumber(20);
        storage.addNumber(30);


        System.out.println("Наиболее близкое к 25: " + storage.findClosest(25)); // выводит 30


        storage.removeNumber(20);


        System.out.println("Наиболее близкое к 25 после удаления 20: " + storage.findClosest(25)); // выводит 30
    }

}
