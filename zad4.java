import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
public class zad4 {
    public static int ScanNum() {
        Scanner str = new Scanner(System.in);
        int num = str.nextInt();
        return num;
    }
    public static String ScanOperation() {
        Scanner str = new Scanner(System.in);
        String operation = str.nextLine();
        return operation;
    }
    public static int Result(String opr, int a, int b) {
        int res = 0;
            switch (opr) {
                case  "+":
                    res = a+b;
                    break;
                case  "-":
                    res = a-b;
                    break;
                case  "*":
                    res = a*b;
                    break;
                case  "/":
                    res = a/b;
                    break;
            }
        return res;
    }
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(zad2.class.getName());
            FileHandler fh = new FileHandler("Zad4Log.txt");
            logger.addHandler(fh);
            SimpleFormatter simpleformatter = new SimpleFormatter();
            fh.setFormatter(simpleformatter);
        System.out.print("Введите первое число: ");
        int a = ScanNum();
        logger.info("Первое число: " + a);
        System.out.print("Введите '+', '-', '*' или '/': ");
        String operation = ScanOperation();
        logger.info("Операция: " + operation);
        System.out.print("Введите второе число: ");
        int b = ScanNum();
        logger.info("Второе число: " + b);
        System.out.println(a + operation + b + " = " + Result(operation, a, b));
        logger.info(a + operation + b + " = " + Result(operation, a, b));
    }
}