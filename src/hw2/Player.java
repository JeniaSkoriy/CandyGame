package hw2;

public class Player {

    private static final int INITIAL_POSITION = -1;

    private String name;
    private int position;

    Player(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    @Override
    public String toString() {
        return name;
    }

}
