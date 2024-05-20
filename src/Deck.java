import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        createDeck();
    }

    public void createDeck() {
        String[] values = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};
        for (String type : types) {
            for (String value : values) {
                this.deck.add(new Card(value, type));
            }
        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = 1; j < 11; j++) {
//                deck.add(new Card(j));
//            }
//            deck.add(new Card(11));
//        }
//        for (int j = 0; j < 8; j++) {
//            deck.add(new Card(10));
//        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public Card getCard() {
        Collections.shuffle(deck);
        return deck.get(0);
    }

    @Override
    public String toString() {
        return deck.toString();
    }
}
