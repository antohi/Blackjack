import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int handValue;
    private int score;

    public Player() {
        this.hand = new ArrayList<>();
        this.handValue = 0;
        this.score = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public int getHandValue() {
        handValue = hand.stream()
                .mapToInt(Card::getValue)
                .sum();
        return handValue;
    }

    public void printHand() {
        for (Card card:hand) {
            System.out.println(card);
        }
        System.out.println(getHandValue());
    }

    public boolean checkWin(Player againstPlayer) {
        if (againstPlayer.getHandValue() > 21) {
            return true;
        }
        if (getHandValue() == 21) {
            return true;
        }
        return false;
    }

    public void resetHand() {
        this.hand = new ArrayList<>();
        this.handValue = 0;
        this.score = 0;
    }
}
