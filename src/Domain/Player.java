package Domain;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int handValue;

    public Player() {
        this.hand = new ArrayList<>();
        this.handValue = 0;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void addCard(Card card){
        hand.add(card);
    }
    public int getHandValue(){
        int sum = hand.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        return sum;
    }

}
