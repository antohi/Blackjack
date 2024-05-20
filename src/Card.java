public class Card {
    private String value;
    private int numValue;
    private String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public void setNumValue(int value) {
        this.numValue = value;
    }

    public void setType(String type) {
        this.type = type;
    }

//    ACE DOESNT WORK
    public int getNumValue() {
        if (value.matches("[JQK]")) {
            return 10;
        }
        if (value.equals("A")) {
            return 11;
        }

        return Integer.valueOf(value);
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Value: " + getValue() + " | Type: " + getType();
    }
}
