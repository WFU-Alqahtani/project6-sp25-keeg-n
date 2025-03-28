
public class Card {
    public enum Suites {NULL, SPADES, CLUBS, DIAMONDS, HEARTS}
    public enum Ranks {NULL, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private Suites suit;
    private Ranks rank;

    public Card() {
        this.suit = Suites.NULL;
        this.rank = Ranks.NULL;
    }

    public Card(Suites s, Ranks r) {
        this.suit = s;
        this.rank = r;
    }

    public Suites getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public void printCard() {
        System.out.println(suit + ": " + rank);
    }
}
