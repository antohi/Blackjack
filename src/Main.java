import Domain.*;
public class Main {
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        newDeck.createDeck();
        newDeck.shuffle();
        System.out.println(newDeck);

        System.out.println(newDeck.getDeck().size());

    }
}
