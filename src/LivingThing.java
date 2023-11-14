import java.io.Console;
public class LivingThing {
    private String name;
    private int health;
    private String pieceColor;

    public LivingThing(String name, int health, String pieceColor) {
        setName(name);
        setHealth(health);
        setPieceColor(pieceColor);
    }

    public String getConsoleStr(){
        String scrig;
        scrig = getPieceColor() + getName().charAt(0) + ConsoleColors.RESET;

        return scrig;
    }



    //GETTERS AND SETTERS START
    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }
    public void setHealth(int health) {
        if (health < 0){
            System.out.println("Enter a value greater than zero");
            return;
        }else{
            this.health = health;
        }
    }
    public void setName(String name) {
        this.name = name.trim();
        if (name == ""){
            name = "undefined";
            this.name = name.trim();
        }
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public String getPieceColor() {
        return pieceColor;
    }
    //GETTERS AND SETTERS END
}
