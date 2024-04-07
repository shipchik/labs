
import com.company.details.Engine;
import com.company.professions.Driver;
import com.company.vehicles.Car;

class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public double getScholarship() {
        if (averageMark == 8) {
            return 100;
        } else {
            return 80;
        }
    }
}

class Magistracy extends Student {
    String researchWork;

    public Magistracy(String firstName, String lastName, String group, double averageMark, String researchWork) {
        super(firstName, lastName, group, averageMark);
        this.researchWork = researchWork;
    }

    @Override
    public double getScholarship() {
        if (averageMark == 8) {
            return 200;
        } else {
            return 180;
        }
    }
}


abstract class Fruit {
    protected double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public final void printManufacturerInfo() {
        System.out.println("Made in RB");
    }

    public abstract double cost();
}

class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }

    @Override
    public double cost() {
        return weight * 0.5; // стоимость яблока за кг
    }
}

class Pear extends Fruit {
    public Pear(double weight) {
        super(weight);
    }

    @Override
    public double cost() {
        return weight * 0.8; // стоимость груши за кг
    }
}

class Plum extends Fruit {
    public Plum(double weight) {
        super(weight);
    }

    @Override
    public double cost() {
        return weight * 0.6; // стоимость сливы за кг
    }
}

interface Printable {
    void print();
}

class MyBook implements Printable {
    private String name;

    public MyBook(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Книга: " + name);
    }

    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Book) {
                p.print();
            }
        }
    }
}

class Magazine implements Printable {
    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Журнал: " + name);
    }

    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine) {
                p.print();
            }
        }
    }
}


class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}




public class Lab3 {
    static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20 || !login.matches("\\w+")) {
                throw new WrongLoginException("Неверный логин");
            }

            if (password.length() > 20 || !password.matches("\\w+") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Неверный пароль");
            }
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
    static void task1(){
        Student student = new Student("Иван", "Иванов", "Группа 1", 7.5);
        Magistracy magistracy = new Magistracy("Петр", "Петров", "Группа 2", 8.5, "Научн");

        Student[] students = {student, magistracy};

        for (Student s : students) {
            System.out.println(s.getScholarship());
        }
    }


    static void task2(){
        Car car = new Car("Brand", "Class", 2000, new Driver("Full Name", 5), new Engine(100, "Manufacturer"));
        car.start();
    }

    static void task3(){
        Fruit[] fruits = new Fruit[] {
                new Apple(1.0),
                new Pear(1.5),
                new Plum(2.0),
                new Apple(1.2),
                new Pear(0.8),
                new Plum(1.6)
        };

        double totalCost = 0.0;
        double appleCost = 0.0;
        double pearCost = 0.0;
        double plumCost = 0.0;

        for (Fruit fruit : fruits) {
            totalCost += fruit.cost();
            if (fruit instanceof Apple) {
                appleCost += fruit.cost();
            } else if (fruit instanceof Pear) {
                pearCost += fruit.cost();
            } else if (fruit instanceof Plum) {
                plumCost += fruit.cost();
            }
        }

        System.out.println("Общая стоимость проданных фруктов: " + totalCost);
        System.out.println("Общая стоимость проданных яблок: " + appleCost);
        System.out.println("Общая стоимость проданных груш: " + pearCost);
        System.out.println("Общая стоимость проданных слив: " + plumCost);
    }

    static void task4(){
        Printable[] printables = new Printable[] {
                new MyBook("Война и мир"),
                new Magazine("Forbes"),
                new MyBook("Преступление и наказание"),
                new Magazine("Time")
        };

        for (Printable p : printables) {
            p.print();
        }

        System.out.println("\nТолько книги:");
        MyBook.printBooks(printables);

        System.out.println("\nТолько журналы:");
        Magazine.printMagazines(printables);
    }


    static void task5(){
        System.out.println(checkCredentials("valid_login", "valid_password", "valid_password")); // вернет true
        System.out.println(checkCredentials("invalid_login_with_special_chars!", "valid_password", "valid_password")); // вернет false
        System.out.println(checkCredentials("valid_login", "valid_password", "invalid_confirm_password")); // вернет false
    }



}
