import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Player player;
    private Player house;
    private Logic logic;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player();
        this.house = new Player();
        this.logic = new Logic();
    }

    public void run() {
        System.out.println("=====================");
        System.out.println("Welcome to Blackjack!");
        System.out.println("=====================");
        System.out.println("Your score: " + player.getScore() +" | Dealer's score: " + house.getScore());
        System.out.println("Input \"p\" to play a new game! Input \"q\" to quit.");
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
            checkLoss(house.checkWin(player));
            System.out.println("Your hand:");
            player.printHand();
            win(player.checkWin(house));
            System.out.println("Would you like to [h] hit or [s] stand?");
        }
    }

    public void checkLoss(boolean checkLoss) {
        if (checkLoss) {
            System.out.println("YOU LOSE!");
            house.increaseScore();
            run();
        }
    }

    public void win(boolean checkWin) {
        if (player.getScore() == 21) {
            System.out.println("=====BLACKJACK=====");
        }
        System.out.println("YOU WIN!");
        if (checkWin) {

        }
    }

}
