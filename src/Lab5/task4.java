package Lab5;
import java.io.*;
class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
}

class Horse extends Animal {
    private static final long serialVersionUID = 1L;
    String name;

    Horse(String name) {
        this.name = name;
    }
}
public class task4 {
    public static void serializeHorse(Horse horse, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(horse);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Horse deserializeHorse(String filename) {
        Horse horse = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            horse = (Horse) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return horse;
    }

    public static void task(){
        Horse horse = new Horse("Pegasus");
        serializeHorse(horse, "horse.ser");

        Horse deserializedHorse = deserializeHorse("horse.ser");
        System.out.println("Deserialized Horse Name: " + deserializedHorse.name);
    }
}
