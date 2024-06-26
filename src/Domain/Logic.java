package Domain;

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
        if (hitCard.getValue().equals("A")) {
            if (player.getHandValue() + 11 > 21) {
                hitCard.setNumValue(2);
                player.addCard(hitCard);
            } else {
                hitCard.setNumValue(11);
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

    public void setDealerStand() {
        this.dealerStand = true;
    }

    public void setPlayerStand() {
        this.playerStand = true;
    }

    public void dealerLogic(Player dealer) {
        if (dealer.getHandValue() < 17)  {
            hit(dealer);
        } else {
            setDealerStand();
//            if (player.getHandValue() > house.getHandValue()) {
//                win(true);
//            } else if (player.getHandValue() < house.getHandValue() && playerStand) {
//                loss(true);
//            }
        }
    }

    public void resetGame(Player dealer, Player player) {
        dealerStand = false;
        playerStand = false;
        player.resetHand();
        dealer.resetHand();
        hit(player);
        hit(player);
        hit(dealer);
        hit(dealer);
    }

}
