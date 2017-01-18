package hw2;

public enum Face {

    GREEN(false),
    RED(false),
    PURPLE(false),
    YELLOW(false),
    BLUE(false),
    ORANGE(false),
    PLUMPY(true),
    MR_MINT(true),
    JOLLY(true);

    private final boolean isCharacter;

    Face(boolean isCharacter) {
        this.isCharacter = isCharacter;
    }

    public boolean isCharacter() {
        return isCharacter;
    }

}
