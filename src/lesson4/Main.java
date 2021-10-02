package lesson4;

import java.util.HashMap;

/**
 * Урок 4. Коллекции
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */

public class Main {
    public static void main(String[] args) {

        String[] words = {"Windows", "Linux", "Ubuntu", "FreeBSD", "MacOS", "Mint", "Kali", "ArcLinux", "Android",
                "FreeBSD", "MacOS", "Mint", "Kali", "Linux"};
        System.out.println("Количество слов в массиве: " + words.length);

        HashMap<String, Integer> uniqWords = new HashMap<>();

        for (String word : words) {
            if (uniqWords.containsKey(word)) {
                uniqWords.put(word, uniqWords.get(word) + 1);
            } else {
                uniqWords.put(word, 1);
            }
        }

        System.out.println("Количество повторений каждого слова:\n" + uniqWords);
    }
}
