import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class zad2 {
    public static void main(String[] args) throws SecurityException, IOException {
        int[] arr = new int[10];
        arrayRandomizer(arr);
        Logger logger = Logger.getLogger(zad2.class.getName());

       
            FileHandler fh = new FileHandler("Zad2Log.txt");
            logger.addHandler(fh);
            SimpleFormatter simpleformatter = new SimpleFormatter();
            fh.setFormatter(simpleformatter);
       
        logger.info("Массив: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            logger.info("Итерация " + (i + 1) + ": " + Arrays.toString(arr));
        }

        logger.info("Отсортированный массив: " + Arrays.toString(arr));
    }

    public static void arrayRandomizer(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 10);
        }
    }
}