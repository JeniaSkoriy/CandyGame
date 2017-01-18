package hw2;

import static hw2.Face.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {

    Board board;
    static final int NUM_PLAYERS = 2;
    static final int MAX_NUM_PLAYERS = 6;
    int nextRoll = 0;
    List<Player> list = new ArrayList();

    Game() {
        board = new Board();
    }

    void printIntro() {
        System.out.println("This is a crude version of Candyland\n");
    }

    Card draw() {
        Card[] testRolls = {
            new Card(PLUMPY, false),
            new Card(YELLOW, true),
            new Card(RED, false),
            new Card(YELLOW, true),
            new Card(GREEN, false),
            new Card(MR_MINT, false),
            new Card(JOLLY, false),
            new Card(RED, false),
            new Card(GREEN, false)
        };
        return nextRoll >= testRolls.length ? null : testRolls[nextRoll];
    }

    public void addPlayers() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Add player");
            System.out.print("Enter player name: ");
            String name = sc.nextLine();
            while (name.trim().contains(" ")) {
                System.out.print("name must be a single word. Repeat: ");
                name = sc.nextLine();
            }

            if (name.equals("done") && list.size() < 2) {
                System.out.println(list.size());
                throw new RuntimeException("Not enough players");
            } else if (name.equals("done")) {
                break;
            } else {
                list.add(new Player(name));
            }

        } while (list.size() < MAX_NUM_PLAYERS);
    }

    void playGame() {
        // Use nextPlayer to switch among the players
        boolean done = false;

        printIntro();
        addPlayers();

        while (!done && !hasWinner()) {
            for (Player player : list) {
                Card nextCard = draw();
                nextRoll++;

                if (nextCard != null) {
                    System.out.println(player + " roll " + nextCard);
                    board.move(player, nextCard);
                } else {
                    done = true;
                    break;
                }
            }
        }
        if (!hasWinner()) {
            System.out.println("No winner");
        } else {
            System.out.println(determineWinner());
        }
    }

    private boolean hasWinner() {
        for (Player player : list) {
            if (player.getPosition() >= board.winningPosition()) {
                return true;
            }
        }
        return false;
    }

    private Player determineWinner() {
        for (Player player : list) {
            if (player.getPosition() >= board.winningPosition()) {
                return player;
            }
        }
        return null;
    }

}
