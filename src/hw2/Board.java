/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

class Board {
// constants

    static final int INITIAL_POSITION = -1;

    static final String BLUE = "BLUE";
    static final String GREEN = "GREEN";
    static final String ORANGE = "ORANGE";
    static final String PURPLE = "PURPLE";
    static final String RED = "RED";
    static final String YELLOW = "YELLOW";
    static final String[] COLORS = {BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW};
    static final int NUM_COLORS = 6;

// names of special characters marking specific spaces on the board
    static final String PLUMPY = "PLUMPY";
    static final String MR_MINT = "MR. MINT";
    static final String JOLLY = "JOLLY";

// positions of the special characters on the board below
    private static final int JOLLY_POS = 42;
    private static final int MR_MINT_POS = 17;
    private static final int PLUMPY_POS = 8;

// A partial board for Candyland
// based on the picture at: http://www.lscheffer.com/CandyLand-big.jpg
    private final String[] board = {RED, PURPLE, YELLOW, BLUE, ORANGE, GREEN, RED, PURPLE, PLUMPY, YELLOW,
        BLUE, ORANGE, GREEN, RED, PURPLE, YELLOW, BLUE, MR_MINT, ORANGE, GREEN,
        RED, PURPLE, YELLOW, BLUE, ORANGE, GREEN, RED, PURPLE, YELLOW, BLUE,
        ORANGE, GREEN, RED, PURPLE, YELLOW, BLUE, ORANGE, GREEN, RED, PURPLE,
        YELLOW, BLUE, JOLLY, ORANGE

    };
    final int FINAL_POSITION = board.length;

    private int[] positions;
    private final int numPlayers;

    /**
     * set all elements of the positions array to INITIAL_POSITION
     *
     * @param _numPlayers -- how many there are
     */
    Board(int _numPlayers) {
        numPlayers = _numPlayers;
        positions = new int[numPlayers];
        for (int player = 0; player < numPlayers; player++) {
            positions[player] = INITIAL_POSITION;
        }
    }

    /**
     * Description: Test if string is a valid color in the game Parameter: str
     * -- string to test Returns: true if it is a color in the game, false if
     * not
     */
    boolean isColor(Face str) {
        for (int color = 0; color < NUM_COLORS; color++) {
            if (COLORS[color].equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: Starting after indicated position search forward on board to
     * find the color Parameters: startPos -- index of current space of player
     * -- start looking *after* this space color -- find the next space with
     * this color Returns: index of next space of chosen color
     *
     */
    int findFace(int startPos, Face color) {
        for (int pos = startPos + 1; pos < FINAL_POSITION; pos++) {
            if (board[pos].equals(color)) {
                return pos;
            }
        }
        return FINAL_POSITION;
    }

    /**
     * Description: find position of indicated person Parameters: name -- name
     * of person to look for Returns: index of space for this name
     */
    int findPerson(Face name) {
        if (PLUMPY.equals(name)) {
            return PLUMPY_POS;
        }
        if (MR_MINT.equals(name)) {
            return MR_MINT_POS;
        }
        if (JOLLY.equals(name)) {
            return JOLLY_POS;
        }
        throw new Error("No such person in the game");
    }

    /**
     * Description: Move a player Parameters: player -- index of player to move
     * card -- indicates where to move repeat -- true if card is a "double"
     * color, false if not positions -- where the players are
     */
    void move(int player, Face card) {
        int nextPos = positions[player];

        if (isColor(card)) {
            nextPos = findFace(positions[player], card);
            positions[player] = nextPos;
        } else {
            positions[player] = findPerson(card);
        }
        System.out.println("Player " + player + " is at position "
                + positions[player]);
    }

    public int winningPosition() {
        return FINAL_POSITION;
    }

    /**
     * Description: Check for a winner Parameters: positions -- where the
     * players are numPlayers -- how many there are Returns: true if there are
     * no winners yet false if anyone has won
     */
    boolean nowinner() {
        for (int player = 0; player < numPlayers; player++) {
            if (positions[player] == FINAL_POSITION) // reached the end
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Print the identity of the winner, if any. If there are no winners, do
     * nothing. Parameters: positions -- the array indicating where the players
     * are located numPlayers -- the number of players
     */
    void printWinner() {
        for (int player = 0; player < numPlayers; player++) {
            // Would be clearer to use a different constant to
            // explicitly define the winning position
            if (positions[player] == FINAL_POSITION) {
                System.out.println("Player " + player + " wins!");
            }
        }
    }
}
