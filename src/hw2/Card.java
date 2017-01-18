package hw2;

public class Card {

    private Face face;
    boolean isDouble;

    Card(Face face, boolean isDouble) {
        this.face = face;
        this.isDouble = isDouble;
    }

    public Face getFace() {
        return face;
    }

    public String isDoubled() {
//////
        if (isDouble) {
            return "double" + getFace();
        } else {
            return getFace() + "";
        }
    }

    @Override
    public String toString() {
        return isDoubled();
    }
}
