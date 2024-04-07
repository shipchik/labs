import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void task1(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number- ");
        int a= sc.nextInt();
        for(int i=1;i<5;i++){
            System.out.println((int)Math.pow(a,i));

        }
    }

    public static void task2(){
        int passwd = 4567;
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.print("введите пароль");
            int user_passwd = sc.nextInt();
            if (passwd == user_passwd){
                System.out.println("пароль подтвержден");
                break;
            }
            else {
                System.out.println("пароль не верен, попробуйте еще раз");
            }
        }
    }


    public static void task3(){
        Scanner sc= new Scanner(System.in);
        System.out.println("введите n:");
        int n = sc.nextInt();
        int istart = 1;
        for (int i=0;i<n;i++) istart*=10;
        int iend=istart*10;
        int sum = 0;
        for(int i=istart;i<iend;i++){
            sum+=i;
        }
        System.out.println("сумма чисел от "+istart+" до "+iend+ " равна: "+sum);

    }
    public static void task4(){
        int secret_number = (int) ((Math.random() * (10 - 1)) + 1);
        Scanner sc= new Scanner(System.in);
        System.out.println("загадали число отгадывайте:");

        while (true){
            int n = sc.nextInt();
            if (n==secret_number){
                System.out.println("поздравляем вы отгадали число");
            }
            else{
                System.out.println("Неверно");
                if (n>secret_number){
                    System.out.println("загаданное число меньше");
                }
                else{
                    System.out.println("загаданное число больше");
                }
            }
        }
    }
    public static void task5(){
        for(int i=1000;i<9999;i+=3) System.out.println(i);
    }

    public static void task6(){

        int[] arr = new int[11];
        arr[0]=1;
        arr[1] =1;
        for(int i=2;i<11;i++){
            arr[i] = arr[i-1]+ arr[i-2];
        }
        for(int i=0;i<11;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void task7(){
        int count = 0;
        for(int i=1;i<=999999;i++){


            if(Arrays.stream(String.valueOf(i/1000).split("")).mapToInt(Integer::valueOf).sum() ==
                    Arrays.stream(String.valueOf(i%1000).split("")).mapToInt(Integer::valueOf).sum()){

                count++;
            }


        }

        System.out.println(count);

    }

    public static void task9(){
        int random = (int) ((Math.random() * (155 - 15)) + 15);
        System.out.println("random number: "+ random);
        if(random>25 && random < 100){
            System.out.println("number in a range between (25;100)");
        }
        else{
            System.out.println("number not in the range");
        }
    }

    public static void task10(){
        int random = (int) ((Math.random() * (28800 - 0)) + 0);
        System.out.println("seconds: "+ random);
        System.out.println("hours: "+(17-28800/3600));
    }

    public static void task11(){
        int[] arr = new int[12];
        for(int i=0;i<12;i++){
            arr[i] = (int) ((Math.random() * (15 + 15)) - 15);
            System.out.print(arr[i]+ " ");

        }
        int max=-16;

        for(int i=0;i<12;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        for(int i=12;i>0;i--){
            if (arr[i]==max){
                System.out.println("max elem: "+ max + " index: "+i);
                break;
            }
        }
    }

    public static void task12(){
        int n=0;
        Scanner sc= new Scanner(System.in);
        while (true){
            System.out.println("enter number:");
            int input = sc.nextInt();
            if (input >3){
                n=input;
                break;
            }
            else{
                System.out.println("incorrect number, try againt");
            }
        }
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = (int) ((Math.random() * (n - 0)) + 0);
            System.out.print(arr[i]+" ");
        }
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                System.out.println(arr[i]+" ");
            }
        }

    }

    public static void task13(){
        Vector<String> examp=new Vector<String>( );
        int[][] arr = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                arr[i][j]=(i+1)*(j+1);
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++) {
                if (arr[i][j] != 0) {
                    if (arr[i][j] == arr[j][i]) {
                        arr[j][i] = 0;
                        examp.add(String.format("%s * %s =",i+1,j+1));
                    }
                    else{
                        examp.add(String.format("%s * %s =",i+1,j+1));
                    }
                }
            }
        }


        System.out.println(examp);

    }


    public static void task14(){
        Scanner sc= new Scanner(System.in);
        System.out.print("enter n:");
        int n = sc.nextInt();
        System.out.print("enter m:");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]= (int) ((Math.random() * (100 - 1)) + 1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");

        for(int i=0;i<n;i++){
            int max =0;
            int min = 110;
            int maxid=0;
            int minid=0;
            for(int j=0;j<m;j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                    maxid = j;
                }
                else if (arr[i][j]<min) {
                    min=arr[i][j];
                    minid=j;

                }
            }
            int buff =arr[i][0];
            arr[i][0]=arr[i][maxid];
            arr[i][maxid]=buff;
            buff =arr[i][m-1];
            arr[i][m-1]=arr[i][minid];
            arr[i][minid]=buff;


        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
            Lab5.task7.task();


    }
}