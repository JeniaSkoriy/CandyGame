package hw2;

import static hw2.Face.*;

class Board {
// constants

    static final int INITIAL_POSITION = -1;

// based on the picture at: http://www.lscheffer.com/CandyLand-big.jpg
    private final Face[] board = {RED, PURPLE, YELLOW, BLUE, ORANGE, GREEN, RED, PURPLE, PLUMPY, YELLOW,
        BLUE, ORANGE, GREEN, RED, PURPLE, YELLOW, BLUE, MR_MINT, ORANGE, GREEN,
        RED, PURPLE, YELLOW, BLUE, ORANGE, GREEN, RED, PURPLE, YELLOW, BLUE,
        ORANGE, GREEN, RED, PURPLE, YELLOW, BLUE, ORANGE, GREEN, RED, PURPLE,
        YELLOW, BLUE, JOLLY, ORANGE

    };
    final int FINAL_POSITION = board.length;

    /**
     * Description: Starting after indicated position search forward on board to
     * find the color Parameters: startPos -- index of current space of player
     * -- start looking *after* this space color -- find the next space with
     * this color Returns: index of next space of chosen color
     *
     */
    int findFace(int startPos, Face face) {
        for (int pos = startPos + 1; pos < FINAL_POSITION; pos++) {
            if (board[pos].equals(face)) {
                return pos;
            }
        }
        return FINAL_POSITION;
    }

    /**
     * Description: Move a player Parameters: player -- index of player to move
     * card -- indicates where to move repeat -- true if card is a "double"
     * color, false if not positions -- where the players are
     */
    void move(Player player, Card card) {
        int nextPos = findFace(player.getPosition(), card.getFace());
        if (card.isDoubled()) {
            nextPos = findFace(nextPos, card.getFace());
        }
        player.setPosition(nextPos);
    }

    public int winningPosition() {
        return FINAL_POSITION;
    }

}
