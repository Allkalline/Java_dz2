// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.*;
public class zad1 {
    public static void main(String[] args) throws Exception {
      String list = ReadFile("TxtForZad1.txt"); 
      //System.out.println(list); 
      StringBuilder resultSelect = ParsAndFilter(list);
      System.out.println(resultSelect);
    }
    public static StringBuilder ParsAndFilter(String line) {
        line = line.replaceAll("[{}\"]", "");
        //System.out.println(line);
        StringBuilder result = new StringBuilder("select * from students where ");

        String [] arrayData = line.split(", ");
        for (int i =0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if(arrData[1].equals("null") == false) {
                if (i != 0) {
                    result.append(", " + arrData[0] + " : " + arrData[1]);
                   
                } else {
                    result.append(arrData[0] + " : " + arrData[1]);
                }
            }
            
        }
        return result;
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
    }