/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ImmolateImprove
 */
class Game {

    Board board;
    static final int NUM_PLAYERS = 2;
    static final int MAX_NUM_PLAYERS = 6;
    int nextRoll = 0;
    List<Player> list = new ArrayList();

    Game() {
        board = new Board(NUM_PLAYERS);
    }

    void printIntro() {
        System.out.println("This is a crude version of Candyland\n");
    }

// Generate the next value "drawn"
// Returns: the value of the next card drawn. Returning the empty string indicates
//          there are no more values
    String draw() {
        String testRolls[] = {Board.PLUMPY, Board.YELLOW,
            Board.RED, Board.YELLOW, Board.GREEN,
            Board.MR_MINT, Board.JOLLY, Board.RED,
            Board.GREEN};
        final int NUM_CARDS = 9;

        if (nextRoll >= NUM_CARDS) {
            return "";
        }
        return testRolls[nextRoll];
    }

// Indicate if this card is a "double" color
// Returns: true if the color is a double, false if not.
// NOTE: This is a very bad way to do this -- but it does help to motivate structures
    boolean drawRepeat() {
        boolean testRollsRepeat[] = {false, true, false, true, false, false, false, false, false};
        final int NUM_CARDS = 9;

        if (nextRoll >= NUM_CARDS) {
            return false;
        }
        return testRollsRepeat[nextRoll];
    }

    public void addPlayers(String name) {

        if (!name.equals("done")) {
            list.add(new Player(name));
        }
    }

    void playGame() {
        // Use nextPlayer to switch among the players
        int nextPlayer = 0;
        boolean done = false;

        printIntro();

        while (list.size() <= MAX_NUM_PLAYERS) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a name player: ");
            String name = sc.nextLine();
            while (name.contains(" ")) {
                System.out.println("name must be a single word. Repeat");
                name = sc.nextLine();
            }

            if (!name.equals("done")) {
                addPlayers(name);
            } else if (name.equals("done")) {
                if (list.size() < NUM_PLAYERS) {
                    System.out.println("Add more players");
                } else {
                    break;
                }

            }

        }

        while (board.nowinner() && !done) {
            String nextCard = draw();
            boolean repeat = drawRepeat();
            nextRoll++;

            if ("" != nextCard) {
                board.move(nextPlayer, nextCard, repeat);
                nextPlayer = (nextPlayer + 1) % NUM_PLAYERS;
            } else {
                done = true;
            }
        }
        if (board.nowinner()) {
            System.out.println("No winner");
        } else {
            board.printWinner();
        }
    }

}
