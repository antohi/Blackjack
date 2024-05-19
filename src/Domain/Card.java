package Domain;

public class Card {
    private int value;
    private SpecialCards type;

    public Card(int value) {
        this.value = value;
        if (value < 10) {
            this.type = SpecialCards.STANDARD;
        }
        if (value == 10) {
            this.type = SpecialCards.FACE;
        }
        if (value == 11) {
            this.type = SpecialCards.ACE;
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setType(SpecialCards type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public SpecialCards getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }
}
