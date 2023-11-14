public class Treasure {
    private int value;
    private String description;


    public Treasure(int value, String description) {
        setValue(value);
        setDescription(description);
    }
    public String getConsoleStr(){
        String scrig;
        scrig = ConsoleColors.YELLOW + getDescription().charAt(0) + ConsoleColors.RESET;

        return scrig;
    }


    // SETTERS AND GETTERS START
    public void setValue(int value) {
        this.value = value;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }
    // SETTERS AND GETTERS END
}
