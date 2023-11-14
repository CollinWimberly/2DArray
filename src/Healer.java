public class Healer extends LivingThing{
    private int healValue;
    public Healer(String name, int health, String pieceColor, int healValue) {
        super(name, health, pieceColor);
        this.healValue = healValue;
    }

    public void heal(LivingThing lucky){
        lucky.setHealth(lucky.getHealth() + healValue);
    }

    public int getHealValue() {
        return healValue;
    }
}
