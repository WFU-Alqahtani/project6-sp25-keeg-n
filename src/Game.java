// Game.java
public class Game {
    private static int lossStreak = 0;
    private static int wins = 0;
    private static int losses = 0;

    public static void playBlindMansBluff(LinkedList player1, LinkedList computer, LinkedList deck) {
        for (int i = 0; i < 5; i++) {
            Card playerCard = player1.removeFromHead();
            Card computerCard = computer.removeFromHead();

            System.out.println("Opponent's card: ");
            computerCard.printCard();

            boolean playerWins = playerCard.getRank().ordinal() > computerCard.getRank().ordinal();
            if (!playerWins && playerCard.getRank().ordinal() == computerCard.getRank().ordinal()) {
                playerWins = playerCard.getSuit().ordinal() > computerCard.getSuit().ordinal();
            }

            if (playerWins) {
                System.out.println("You win this round!");
                wins++;
                lossStreak = 0;
            } else {
                System.out.println("You lose this round!");
                losses++;
                lossStreak++;
            }

            if (lossStreak >= 3) {
                rageQuit(deck, player1, computer);
                break;
            }
        }
        System.out.println("Game Over! Wins: " + wins + " Losses: " + losses);
    }

    public static void rageQuit(LinkedList deck, LinkedList player1, LinkedList computer) {
        System.out.println("\nResetting the game...\n");
        while (player1.removeFromHead() != null);
        while (computer.removeFromHead() != null);

        for (Card.Suites s : Card.Suites.values()) {
            for (Card.Ranks r : Card.Ranks.values()) {
                if (s != Card.Suites.NULL && r != Card.Ranks.NULL) {
                    deck.addAtTail(new Card(s, r));
                }
            }
        }

        deck.shuffle(512);
        for (int i = 0; i < 5; i++) {
            player1.addAtTail(deck.removeFromHead());
            computer.addAtTail(deck.removeFromHead());
        }
        lossStreak = 0;
        System.out.println("Game restarted!");
    }
}
