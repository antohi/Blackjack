import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Player player;
    private Player dealer;
    private Logic logic;
//    private boolean dealerStand;
//    private boolean playerStand;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player();
        this.dealer = new Player();
        this.logic = new Logic();
    }

    public void run() {
        System.out.println("=====================");
        System.out.println("Welcome to Blackjack!");
        System.out.println("=====================");
        System.out.println("Your score: " + player.getScore() + " | Dealer's score: " + dealer.getScore());
        System.out.println("Input \"s\" to play a new game! Input \"q\" to quit.");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            } else if (input.equals("s")) {
                newGame();
            } else {
                System.out.println("Invalid command! Try again.");
            }
        }
    }

    public void newGame() {
        logic.resetGame(dealer, player);
        while (true) {
            System.out.println("Dealer's cards:");
            dealer.printHand();
            System.out.println("Your hand:");
            player.printHand();
            loss(dealer.checkWin(player));
            win(player.checkWin(dealer));
            if (player.getHandValue() == 21) {
                win(true);
            }
            System.out.println("Would you like to [h] hit or [s] stand?");
            if (!logic.isPlayerStand()) {
                System.out.println("> ");
                String input = scanner.nextLine();
                if (input.equals("h")) {
                    logic.hit(player);
                }
                if (input.equals("s")) {
                    logic.setPlayerStand();
                }
            }
            logic.dealerLogic(dealer);
        }
    }

    public void loss(boolean checkLoss) {
        if (logic.isDealerStand() && logic.isPlayerStand()) {
            if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() < 21) {
                checkLoss = true;
            }
        }
        if (checkLoss) {
            System.out.println("YOU LOSE!");
            dealer.increaseScore();
            logic.resetGame(dealer, player);
            run();
        }
    }

    public void win(boolean checkWin) {
        if (logic.isDealerStand() && logic.isPlayerStand()) {
            if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 21) {
                checkWin = true;
            }
            if (checkWin) {
                if (player.getHandValue() == 21) {
                    System.out.println("=====BLACKJACK=====");
                }
                System.out.println("YOU WIN!");
                logic.resetGame(dealer, player);
                player.increaseScore();
                run();
            }
        }

//    public void dealerLogic() {
//        if (house.getHandValue() <= 17) {
//            logic.hit(house);
//        } else {
//            dealerStand = true;
//            if (player.getHandValue() > house.getHandValue()) {
//                win(true);
//            } else if (player.getHandValue() < house.getHandValue() && playerStand) {
//                checkLoss(true);
//            }
//        }
//    }


//    public void resetGame() {
//        dealerStand = false;
//        playerStand = false;
//        player.resetHand();
//        house.resetHand();
//    }
    }
}
