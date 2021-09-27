package lesson1;

import lesson1.competitor.Man;
import lesson1.competitor.Woman;
import lesson1.obstacle.Cross;
import lesson1.obstacle.Wall;
import lesson1.obstacle.Water;

public class Main {

    /**
     * Практическое задание
     * 1. Разобраться с имеющимся кодом.
     * 2. Добавить класс Team, который будет содержать:
     * 2.1. название команды;
     * 2.2. массив из четырех участников — в конструкторе можно сразу всех участников указывать);
     * 2.3. метод для вывода информации о членах команды, прошедших дистанцию;
     * 2.4. метод вывода информации обо всех членах команды.
     * 3. Добавить класс Course (полоса препятствий), в котором будут находиться:
     * 3.1. массив препятствий;
     * 3.2. метод, который будет просить команду пройти всю полосу.
     * В итоге должно получиться похожее:
     * public static void main(String[] args) {
     * Course c = new Course(...); // Создаем полосу препятствий
     * Team team = new Team(...); // Создаем команду
     * c.doIt(team); // Просим команду пройти полосу
     * team.showResults(); // Показываем результаты
     * }
     */

    public static void main(String[] args) {

        Course c = new Course(new Cross(1000),
                new Wall(3),
                new Water(100)); // Создаем полосу препятствий
        Team team = new Team("Тестировщики",
                new Man("Дмитрий", 1500, 4, 150),
                new Man("Алексей", 500,3,0),
                new Woman("Анна", 1000, 2, 150),
                new Woman("Екатерина", 2000, 4, 200)); // Создаем команду
        team.getTeamInfo(); // Выводим информацию о спортсменах команды
        System.out.println("\nПрохождение командой дистанции:");
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
        team.showResultsComplete(); // Показываем, тех кто справился с дистанцией

    }

}
