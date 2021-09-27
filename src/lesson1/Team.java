package lesson1;

import lesson1.competitor.Man;
import lesson1.competitor.Participant;
import lesson1.competitor.Woman;
import lesson1.obstacle.Obstacle;

public class Team {
    private final String name; // название команды
    private Participant[] participants;    // участники

    public Team(String name,Participant ... participantsGiven ) {
        this.name = name;
        this.participants = participantsGiven;
    }

    public void getTeamInfo() {
        System.out.println("\nВывод информации о команде:" + "\nКоманда: " + this.name);
        int i = 1;
        for (Participant participant : participants) {
            if (participant instanceof Man) {
                System.out.println(i + ") Спортсмен " + participant.getName());
                i++;
            }
            if (participant instanceof Woman) {
                System.out.println(i + ") Спортсменка " + participant.getName());
                i++;
            }
        }
    }

    public void showResults() {
        System.out.println("\nРезультаты прохождения всей дистанции спортсменами из команды: " + name);
        int i = 1;
        for (Participant participant : participants) {
            if (participant instanceof Man) {
                System.out.println(i + ") Спортсмен " + participant + ".");
                i++;
            }
            if (participant instanceof Woman) {
                System.out.println(i + ") Спортсменка " + participant + ".");
                i++;
            }
        }
        System.out.println();
    }

    public void showResultsComplete() {
        System.out.println("Вывод спортсменов, которые справились с дистанцией:");
        for (Participant participant : participants) {
            if (participant.isOnDistance()) {
                if (participant instanceof Man) {
                    System.out.println("> Спортсмен " + participant.getName() + ".");
                }
                if (participant instanceof Woman) {
                    System.out.println("> Спортсменка " + participant.getName() + ".");
                }
            }
        }
    }

    public void doIt(Obstacle obstacle) {
        for (Participant participant : participants) {
            obstacle.doIt(participant);
        }
    }

}
