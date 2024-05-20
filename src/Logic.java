import java.util.Scanner;

public class Logic {
    private Deck deck;
    private boolean dealerStand;
    private boolean playerStand;


    public Logic() {
        this.deck = new Deck();
        this.dealerStand = false;
        this.playerStand = false;
    }

    // ACE DOESNT WORK
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

    public boolean isDealerStand() {
        return dealerStand;
    }

    public boolean isPlayerStand() {
        return playerStand;
    }

    public void setDealerStand(boolean stand) {
        this.dealerStand = true;
    }

    public void setPlayerStand() {
        this.playerStand = true;
    }

    public void dealerLogic(Player dealer) {
        if (dealer.getHandValue() <= 17) {
            hit(dealer);
        } else {
            dealerStand = true;
//            if (player.getHandValue() > house.getHandValue()) {
//                win(true);
//            } else if (player.getHandValue() < house.getHandValue() && playerStand) {
//                loss(true);
//            }
        }
    }

    public void resetGame(Player house, Player player) {
        dealerStand = false;
        playerStand = false;
        player.resetHand();
        house.resetHand();
    }

}
