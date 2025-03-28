public class Main {
    public static LinkedList initializeDeck() {
        LinkedList deck = new LinkedList();
        for (Card.Suites s : Card.Suites.values()) {
            for (Card.Ranks r : Card.Ranks.values()) {
                if (s != Card.Suites.NULL && r != Card.Ranks.NULL) {
                    deck.addAtTail(new Card(s, r));
                }
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        LinkedList deck = initializeDeck();
        deck.shuffle(512);
        deck.print();

        LinkedList player1 = new LinkedList();
        LinkedList computer = new LinkedList();

        for (int i = 0; i < 5; i++) {
            player1.addAtTail(deck.removeFromHead());
            computer.addAtTail(deck.removeFromHead());
        }

        Game.playBlindMansBluff(player1, computer, deck);
    }
}
