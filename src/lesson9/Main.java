package lesson9;

/*
1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
(любознательность определяется количеством курсов).
3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
которые посещают этот курс.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Вася", Arrays.asList(new Course("Математика"),
                new Course("Программирование"), new Course("Тестирование"))));
        students.add(new Student("Петя", Arrays.asList(new Course("Математика"),
                new Course("Философия"), new Course("Тестирование"), new Course("Программирование"))));
        students.add(new Student("Коля", Arrays.asList(new Course("Основы ООП"),
                new Course("Тестирование"), new Course("Филология"), new Course("Тестирование"))));
        students.add(new Student("Иван", Arrays.asList(new Course("Основы ООП"),
                new Course("Тестирование"))));

        System.out.println("1. Возвращаем список уникальных курсов на которые подписаны студенты:");
        System.out.println(students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));

        System.out.println("2. Возвращаем список из трех самых любознательных:");
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println("3. Список студентов которые посещают курс <Философия>:");
        Course course = new Course("Философия");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));

    }
}
