package lesson1.obstacle;

import lesson1.competitor.Participant;

public class Cross extends Obstacle{

    private final int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Participant participant) {
        participant.run(length);
    }

}
