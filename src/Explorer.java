import java.util.ArrayList;

public class Explorer extends LivingThing{
    public ArrayList<Treasure> treasures;
    public Explorer(String name, int health, String pieceColor) {
        super(name, health, pieceColor);
        treasures = new ArrayList<Treasure>();

    }
    public ArrayList<Treasure> getTreasures(){
        return treasures;
    }

    public void addTreasure(Treasure booty){
        treasures.add(booty);
    }

    public int getTreasureValue(){
        int money = 0;
        for (int i = 0; i <= treasures.size() - 1; i++) {
            money += treasures.get(i).getValue();
        }
        return money;
    }
}
