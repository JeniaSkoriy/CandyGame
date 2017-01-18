package hw2;

public class Face {

    enum color {
        BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW
    }

    enum characters {
        PLUMPY, MR_MINT, JOLLY
    }
    boolean isCharacter;
///////

    Face(String str) {

        for (int color = 0; color < Face.color.values().length; color++) {
            if (Face.color.values().equals(str)) {
                isCharacter = false;
            }
        }
        isCharacter = true;
    }

}
