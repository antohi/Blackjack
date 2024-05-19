public class Card {
    private String value;
    private String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        if (value.matches("J|Q|K")) {
            return 10;
        }
        return Integer.valueOf(getValue());
    }

    public String getType() {
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
