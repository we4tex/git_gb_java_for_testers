package lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /**
     * Урок 3. Обобщения
     * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
     * 2. Задача:
     * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     * Для хранения фруктов внутри коробки можно использовать ArrayList;
     * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
     * которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     * Можно сравнивать коробки с яблоками и апельсинами;
     * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     * Не забываем про метод добавления фрукта в коробку.
     */

    public static void main(String[] args) {
        System.out.println("Задание 1. Меняем местами два элемента массива:");
        Integer[] intArr = new Integer[2];
        intArr[0] = 3;
        intArr[1] = 7;
        System.out.println(Arrays.deepToString(intArr));
        swap(intArr, 0, 1);
        ArrayList<Integer> arrayList = toArrayList(intArr);
        System.out.println(arrayList);

        System.out.println("\nЗадание 2:");
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<>(apple1, apple2, apple3);
        System.out.println("Вес первой коробки составляет: " + box1.getWeight());
        Box<Orange> box2 = new Box<>(orange1, orange2, orange3);
        System.out.println("Вес второй коробки составляет: " + box2.getWeight());

        //сраниваем вес коробок
        System.out.println(box1.compare(box2));

        System.out.println("\nСоздаем 3 коробку и высыпаем в нее апельсины из второй, проверяем весом");
        Box<Orange> box3 = new Box<>();
        box2.transfer(box3);
        System.out.println("Вес второй коробки составляет: " + box3.getWeight());
    }

    // Меняем два элемента массива местами
    public static void swap(Object[] arr, int index1, int index2) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    // Преобразуем массив в ArrayList
    public static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

}
