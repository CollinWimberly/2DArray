public class Monster extends LivingThing{
    private int damage;
    public Monster(String name, int health, String pieceColor, int damage) {
        super(name, health, pieceColor);
        this.damage = damage;
    }

    public void hurt(LivingThing unlucky){
        unlucky.setHealth(unlucky.getHealth() - damage);
    }



    public int getDamage() {
        return damage;
    }
}
