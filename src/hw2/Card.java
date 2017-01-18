package hw2;

public class Card {

    private Face face;
    private boolean isDouble;

    public Card(Face face, boolean isDouble) {
        this.face = face;
        this.isDouble = isDouble;
    }

    public Face getFace() {
        return face;
    }

    public boolean isDoubled() {
        return isDouble;
    }

    @Override
    public String toString() {
        return (isDoubled() ? " double" : "") + face.toString();
    }
}
