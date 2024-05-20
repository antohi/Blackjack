import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Player player;
    private Player house;
    private Logic logic;
    private boolean dealerStand;
    private boolean playerStand;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player();
        this.house = new Player();
        this.logic = new Logic();
        this.dealerStand = false;
        this.playerStand = false;
    }

    public void run() {
        System.out.println("=====================");
        System.out.println("Welcome to Blackjack!");
        System.out.println("=====================");
        System.out.println("Your score: " + player.getScore() +" | Dealer's score: " + house.getScore());
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
        logic.hit(player);
        logic.hit(player);
        logic.hit(house);
        logic.hit(house);
        while (true) {
            System.out.println("Dealer's cards:");
            house.printHand();
            System.out.println("Your hand:");
            player.printHand();
            checkLoss(house.checkWin(player));
            win(player.checkWin(house));
            System.out.println("Would you like to [h] hit or [s] stand?");
            if (!playerStand) {
                System.out.println("> ");
                String input = scanner.nextLine();
                if (input.equals("h")) {
                    logic.hit(player);
                    continue;
                }
                if (input.equals("s")) {
                    playerStand = true;
                }
            }
            if (!dealerStand) {
                dealerLogic();
            }
        }
    }

//    public void playerStand() {
//        while (true) {
//            System.out.println("Dealer's cards:");
//            house.printHand();
//            checkLoss(house.checkWin(player));
//            System.out.println("Your hand:");
//            player.printHand();
//            win(player.checkWin(house));
//        }
//    }

    public void checkLoss(boolean checkLoss) {
        if (checkLoss) {
            System.out.println("YOU LOSE!");
            house.increaseScore();
            resetGame();
            run();
        }
    }

    public void win(boolean checkWin) {
        if (checkWin) {
            if (player.getScore() == 21) {
                System.out.println("=====BLACKJACK=====");
            }
            System.out.println("YOU WIN!");
            resetGame();
            player.increaseScore();
            run();
        }
    }

    public void dealerLogic() {
        if (house.getScore() <= 17) {
            logic.hit(house);
        } else {
            dealerStand = true;
        }

    }

    public void resetGame() {
        dealerStand = false;
        playerStand = false;
        player.resetHand();
        house.resetHand();
    }
}
