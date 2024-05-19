package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }
    public void createDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 11; j++) {
                deck.add(new Card(j));
            }
            deck.add(new Card(11));
        }
        for (int j = 0; j < 8; j++) {
            deck.add(new Card(10));
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public Card getCard() {
        return deck.get(deck.indexOf(Math.random()*52));
    }

    @Override
    public String toString() {
        return deck.toString();
    }
}
