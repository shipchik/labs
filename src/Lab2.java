import java.util.Scanner;



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

        int commonDenominator = this.denominator * fr.denominator;
        int newNumerator = this.numerator * fr.denominator + fr.numerator * this.denominator;
        int thisGcd = gcd(newNumerator, commonDenominator);
        System.out.println(thisGcd);
        System.out.println(newNumerator/thisGcd+"/"+commonDenominator/thisGcd);
    }
    void remove(Fraction fr){
        int commonDenominator = this.denominator * fr.denominator;
        int newNumerator = this.numerator * fr.denominator - fr.numerator * this.denominator;
        int thisGcd = gcd(newNumerator, commonDenominator);
        System.out.println(newNumerator/thisGcd+"/"+commonDenominator/thisGcd);

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
        fraction1.add(fraction2);
    }
}
