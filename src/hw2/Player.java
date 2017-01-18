package hw2;

public class Player {

    private String name;
    private int position;
    static final int INITIAL_POSITION = -1;

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

}
