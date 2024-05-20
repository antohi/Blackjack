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

//    ACE DOESNT WORK
    public int getValue() {
        if (value.matches("[JQK]")) {
            return 10;
        }
        return Integer.valueOf(value);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Value: " + getValue() + " | Type: " + getType();
    }
}
