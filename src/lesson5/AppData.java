package lesson5;

import com.opencsv.CSVWriter;
import java.io.*;
import java.util.ArrayList;

public class AppData {

    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData()  {
        return data;
    }

    public AppData() throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("data.csv"), ';',
                CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,"\n");

        //Строка заголовков
        String[] header = { "Value1", "Value2", "Value3" };
        writer.writeNext(header);
        // Строковые данные
        String[] data1 = { "1", "2", "3" };
        writer.writeNext(data1);
        String[] data2 = { "10", "11", "12" };
        writer.writeNext(data2);
        String [] data3 = { "20", "21", "22" };
        writer.writeNext(data3);
        writer.close();

        System.out.println("Файл создан");

    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(rowToString(header));

            for (Integer[] row : data) {
                writer.write(rowToString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String rowToString(T[] row) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < row.length; i++) {
            result.append(row[i].toString());
            if (row.length - 1 != i) {
                result.append(";");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public void load(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add(stringToDataRow(tempString));
            }
            data = dataList.toArray(new Integer[][]{{}});
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Integer[] stringToDataRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
