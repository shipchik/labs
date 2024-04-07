import java.util.Scanner;
import java.util.Vector;


class Circle{
    int radius;
    int x_centre;
    int y_centre;
    public Circle(){
        this.radius = 2;
        this.x_centre=0;
        this.y_centre=0;
    }

    public Circle(int radius){
        this.radius = radius;
        this.x_centre = 0;
        this.y_centre = 0;
    }
    public Circle(int radius, int x_centre){
        this.radius = radius;
        this.x_centre = x_centre;
        this.y_centre = 0;
    }
    public Circle(int radius, int x_centre, int y_centre){
        this.radius = radius;
        this.x_centre = x_centre;
        this.y_centre = y_centre;
    }

    void print(){
        System.out.println("radius:" +this.radius+ "\nx_centre:"+this.x_centre+"\n y_centre: "+ this.y_centre);
    }
    void change_radius(int radius){
        this.radius = radius;
    }
    void change_centre(int x,int y){
        this.x_centre += x;
        this.y_centre += y;
    }

    void ploschad_length(){
        System.out.println("ploshad: "+Math.PI*Math.pow(this.radius,2)+"\n length: "+Math.PI*2*this.radius);

    }

}

class Warehouse{
    int items;
    int price;


    public Warehouse(){
        this.items = 10;
        this.price = 10;
    }

    public Warehouse(int items,int price){
        this.items = items;
        this.price = price;
    }

    void change_count(int count){
        this.items = count;
    }
    void change_price(int price){
        this.price = price;
    }

    void equal(Warehouse ware){
        if (this.price == ware.price){
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }
    static private int gcd (int x, int y) {
        /* Remove the following line. */
        return 1;
    }
    void sum_of_items(Warehouse[] wares){
        int sum=0;
        for(int i=0;i< wares.length;i++){
            sum+= wares[i].items;
        }
        System.out.println("count of items: "+sum+this.items);
    }

}


class Book{
    String author;
    String name;
    int year;
    int page_count;

    public Book(){
        this.author = "";
        this.name = "";
        this.year = 0;
        this.page_count = 0;

    }

    public Book(String author,String name,int year, int page_count){
        this.author = author;
        this.name = name;
        this.year = year;
        this.page_count = page_count;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setpage_count(int page_count) {
        this.page_count = page_count;
    }

    public void displayInfo() {
        System.out.println("Автор: " + author);
        System.out.println("Название книги: " + name);
        System.out.println("Год выпуска: " + year);
        System.out.println("Количество страниц: " + page_count);
    }

    public void setAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите автора: ");
        this.author = scanner.nextLine();
    }

    public void setname() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        name = scanner.nextLine();
    }

    public void setYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год выпуска: ");
        year = scanner.nextInt();
    }

    public void setpage_count() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество страниц: ");
        page_count = scanner.nextInt();
    }
}

class MyMath {
    static int nok(int a, int b) {
        return a * b / nod(a, b);
    }

    static int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nod(b, a % b);
    }
}
class Fraction{
    int numerator;
    int denominator;
    public Fraction(int numerator, int denomirator){
        this.numerator = numerator;
        this.denominator = denomirator;
    }
    public  Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }

    int ceil(){
        int cel = numerator/denominator;
        this.numerator = numerator - cel*denominator;
        return cel;

    }
    void add(Fraction fr){

        int cdenominator = MyMath.nok(this.denominator,fr.denominator);
        int cNumerator = this.numerator*(cdenominator/ this.denominator) + fr.numerator * (cdenominator/fr.denominator);
        int ceil = cNumerator/cdenominator;
        cNumerator -= ceil*cdenominator;
        System.out.println(ceil +" "+ cNumerator+ "/"+cdenominator);
    }
    void add_to_frac(Fraction fr){

        int cdenominator = MyMath.nok(this.denominator,fr.denominator);
        int cNumerator = this.numerator*(cdenominator/ this.denominator) + fr.numerator * (cdenominator/fr.denominator);

        this.numerator = cNumerator;
        this.denominator=cdenominator;

    }
    void remove(Fraction fr){
        int commonDenominator = this.denominator * fr.denominator;
        int newNumerator = this.numerator * fr.denominator - fr.numerator * this.denominator;
        int thisGcd = MyMath.nod(newNumerator, commonDenominator);
        int ceil = (newNumerator/thisGcd)/(commonDenominator/thisGcd);
        newNumerator -= ceil*commonDenominator/thisGcd;
        System.out.println(ceil+" "+newNumerator+"/"+commonDenominator/thisGcd);

    }

    void multiple(Fraction fr){
        int commondenominator = this.denominator * fr.denominator;
        int newnumerator = this.numerator * fr.numerator;
        int ceil = newnumerator/commondenominator;
        newnumerator -= ceil*commondenominator;
        System.out.println(ceil +" "+ newnumerator+ "/"+commondenominator);
    }

    void devide(Fraction fr){
        int commondenominator = this.denominator * fr.numerator;
        int newnumerator = this.numerator * fr.denominator;
        int ceil = newnumerator/commondenominator;
        newnumerator -= ceil*commondenominator;
        System.out.println(ceil +" "+ newnumerator+ "/"+commondenominator);
    }



}


class MyDouble {
    private double value;

    public MyDouble(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

public class Lab2 {
    static void task1(){
        Circle circle = new Circle(10,10,10);
        circle.ploschad_length();
    }

    static void task2(){

    }

    static void task3(){
        Book b = new Book();
        b.setname();
    }
    static void task4(){
        Fraction fraction1 = new Fraction(11, 5);
        Fraction fraction2 = new Fraction(23, 4);
        fraction1.multiple(fraction2);

        Vector<Fraction> frac = new Vector<Fraction>(10,1);
        for(int i=0;i< 10;i++){
            frac.add(new Fraction((int)Math.random()*6,(int)Math.random()*6));
        }
        for(int i=2;i<frac.size();i+=2){
            frac.elementAt(i).add_to_frac(frac.elementAt(i+1));
        }
    }

    static void task5(){
        Double d1 = Double.valueOf(10.6);
        Double d2 = Double.valueOf("20.5");


        double d3 = Double.parseDouble("30.5");


        byte b = d1.byteValue();
        short s = d1.shortValue();
        int i = d1.intValue();
        long l = d1.longValue();
        float f = d1.floatValue();


        System.out.println("Значение d1: " + d1);


        String dStr = Double.toString(3.14);
        System.out.println("Строка dStr: " + dStr);
    }

    static void task6(){
        String str = "I like Java!!!";
        System.out.println("Последний символ: " + str.charAt(str.length() - 1));
        System.out.println("Заканчивается на '!!!': " + str.endsWith("!!!"));
        System.out.println("Начинается с 'I like': " + str.startsWith("I like"));
        System.out.println("Содержит 'Java': " + str.contains("Java"));
        System.out.println("Позиция 'Java': " + str.indexOf("Java"));
        System.out.println("Замена 'a' на 'o': " + str.replace('a', 'o'));
        System.out.println("Верхний регистр: " + str.toUpperCase());
        System.out.println("Нижний регистр: " + str.toLowerCase());
        int start = str.indexOf("Java");
        if (start != -1) {
            System.out.println("Подстрока 'Java': " + str.substring(start, start + "Java".length()));
        }
    }

}
