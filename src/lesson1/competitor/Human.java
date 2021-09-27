package lesson1.competitor;

public abstract class Human implements Participant {

    private final String name;
    private boolean onDistance;
    private final int maxRunDistance;
    private final int maxJumpHeight;
    private final int maxSwimDistance;

    public Human(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " - кросс успешно пройден.");
        } else {
            System.out.println(name + " - кросс не пройден, не хватило сил.");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " - прыжок в длину получился.");
        } else {
            System.out.println(name + " - прыжок в длину не получился.");
            onDistance = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " - бассейн переплыть не удалось, т.к. " + name + " не умеет плавать");
            onDistance = false;
        } else if (distance <= maxSwimDistance) {
            System.out.println(name + " - бассейн переплыть удалось.");
        } else {
            System.out.println(name + " - бассейн переплыть не удалось, не хватило сил.");
            onDistance = false;
        }
    }

    @Override
    public String toString() {
        return name + " : " + (isOnDistance() ? "дистанция успешно пройдена" : "дистанция не пройдена");
    }
}
