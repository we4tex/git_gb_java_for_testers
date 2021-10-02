package lesson5;

/*
  Урок 5. Средства ввода-вывода
  1. Реализовать сохранение данных в csv файл;
  2. Реализовать загрузку данных из csv файла. Файл читается целиком.
  Структура csv файла:
  | Строка заголовок с набором столбцов |
  | Набор строк с целочисленными значениями |
  | Разделитель между столбцами - символ точка с запятой (;) |
  > Для хранения данных использовать класс вида:
  | public class AppData {
  | private String[] header;
  | private int[][] data;
  | // ...
  | }
 */

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        AppData appData = new AppData();

        System.out.println("\nЗагружаем и читаем файл: data.csv");
        appData.load("data.csv");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData())+"\n");

        System.out.println("Перезаписываем данные в файле: data.csv");
        CSVWriter writer = new CSVWriter(new FileWriter("data.csv"), ';',
                CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,"\n");
        String[] header = { "Val-1", "Val-2", "Val-3" };
        writer.writeNext(header);
        String[] data1 = { "1", "1", "1" };
        writer.writeNext(data1);
        String[] data2 = { "1", "2", "2" };
        writer.writeNext(data2);
        String [] data3 = { "3", "3", "3" };
        writer.writeNext(data3);
        writer.close();
        System.out.println("Создана копия и файл перезаписан. Проверяем:");
        appData.save("data1.csv");
        appData.load("data.csv");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData())+"\n");

        System.out.println("Проверяем копию:");
        appData.load("data1.csv");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData())+"\n");

    }

}
