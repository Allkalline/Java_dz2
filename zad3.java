// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.



import java.io.*;
public class zad3 {
    public static void main(String[] args) throws IOException {
        String list = ReadFile("TxtForZad3.txt");  
       // System.out.println(list);
        StringBuilder resBuilder = ParsAndFilter(list);
        System.out.println(resBuilder);
    }
    
    
    
    
    
    
    public static String ReadFile(String fileName) throws IOException {
        
        FileReader reader = new FileReader(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        int с;
        while ((с = reader.read()) != -1) {
            stringBuilder.append((char) с);
        }
        reader.close();
        return stringBuilder.toString();
    } 
    public static StringBuilder ParsAndFilter(String line) {
        StringBuilder result = new StringBuilder("");
        line = line.replaceAll("[{}\"\\[\\]]", "");
        //System.out.println(line);
        
        String [] resArr = line.split("[,:]");
        System.out.println(resArr.length);
        //String [] lst = {"Студент ", " получил ", " по предмету "};
        for (int i = 5; i < resArr.length; i+=6) {
            result.append("Студент ").append(resArr[i-4]).append(" получил ")
                    .append(resArr[i-2]).append(" по предмету ").append(resArr[i])
                    .append("\n");
        }
        return result;
}
        
}
