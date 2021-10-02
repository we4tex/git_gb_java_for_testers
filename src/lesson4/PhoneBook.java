package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Урок 4. Коллекции
 * 2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи,
 * а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
 * взаимодействие с пользователем через консоль и т.д).
 * Консоль использовать только для вывода результатов проверки телефонного справочника.
 */

public class PhoneBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "89876543210");
        phoneBook.add("Petrov", "81111111111");
        phoneBook.add("Sidorov", "82222222222");
        phoneBook.add("Ivanov", "83333333333");
        phoneBook.add("Vasiliev", "8999888776655");

        System.out.println("Проверка вывода 2-х номеров сотрудника с фамилией 'Ivanov':\n" + phoneBook.get("Ivanov"));
    }

    private final HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        ArrayList<String> phonesForLastName = phoneBook.getOrDefault(lastName, new ArrayList<>());
        phonesForLastName.add(phoneNumber);
        phoneBook.put(lastName, phonesForLastName);
    }

    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }

}
