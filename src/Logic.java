import java.util.Scanner;
public class Logic {
    private Deck deck;

    public Logic() {
        this.deck = new Deck();
    }

    public void hit(Player player) {
        Card hitCard = deck.getCard();
        if (String.valueOf(hitCard.getValue()).equals("A")) {
            if (player.getHandValue() + hitCard.getValue() > 21) {
                hitCard.setValue("2");
                player.addCard(hitCard);
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Would you like your Ace's value to be a +2 or a +11?");
                hitCard.setValue(scanner.nextLine());
                player.addCard(hitCard);
            }
        } else {
            player.addCard(hitCard);
        }
    }

}
