package lesson2;

/**
 * Урок 2. Исключения
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст
 * вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке
 * лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
 * MyArrayDataException и вывести результат расчета.
 */

public class Main {
    public static int arraySum(String[][] twoDimensionalArray) throws MyArraySizeException, MyArrayDataException {

        if (twoDimensionalArray.length != 4) {
            throw new MyArraySizeException("Длина массива не равна 4");
        }

        for (String[] array : twoDimensionalArray) {
            if (array.length != 4) {
                throw new MyArraySizeException("Высота массива не равна 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(twoDimensionalArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке: " + i  + "," + j + " находиться не число");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        //Неправильная высота массива
        String[][] noLengthArray =
                {{"2", "4", "6", "8"},
                        {"2", "4", "6", "8"},
                        {"2", "4", "6", "8", "5"},
                        {"2", "4", "6", "8"}};

        Integer[][] array = new Integer[4][];
        array[0] = new Integer[4];
        array[0] = new Integer[5];
        array[0] = new Integer[4];

        try {
            System.out.println(arraySum(noLengthArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        //Не числовое значение в ячейке 2.2
        String[][] dataInvalidArray =
                {{"2", "4", "6", "8"},
                        {"2", "4", "6", "8"},
                        {"2", "4", "6S", "8"},
                        {"2", "4", "6", "8"}};

        try {
            System.out.println(arraySum(dataInvalidArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        //Проверка работы массива :)
        String[][] goodArray =
                {{"2", "4", "6", "8"},
                        {"2", "4", "6", "8"},
                        {"2", "4", "6", "8"},
                        {"2", "4", "6", "8"}};

        try {
            System.out.println(arraySum(goodArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}