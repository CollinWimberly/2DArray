import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class board {
    Random rand = new Random();
    private int currentRow = 0;
    private int currentColumn = 0;

    private ArrayList<ArrayList<Space>> board;

    private ArrayList<Treasure> remainingTreasures;
    LivingThing Gazoo = new LivingThing("Gazoo", 20, ConsoleColors.GREEN);
    Explorer ChuckNorris = new Explorer("Chuck Norris", 10000, ConsoleColors.GREEN);
    Healer MotherTheresa = new Healer("Mother Theresa", 1, ConsoleColors.BLUE, 5);
    Monster RazorClaw = new Monster("Razorclaw", 3, ConsoleColors.RED, 9);
    Monster GloomFury = new Monster("Gloomfury", 3, ConsoleColors.RED, 8);
    Monster FangSnarl = new Monster("Fangsnarl", 3, ConsoleColors.RED, 7);
    Monster VileSpike = new Monster("Vilespike", 3, ConsoleColors.RED, 6);
    Monster GrimScowl = new Monster("Grimscowl", 3, ConsoleColors.RED, 5);

    public board(int rows, int cols) {
        //int randCoord1 = rand.nextInt(rows);
        //int randCoord2 = rand.nextInt(cols);

        remainingTreasures = new ArrayList<Treasure>();
        remainingTreasures.add(new Treasure(15, "Gold Pouch"));
        remainingTreasures.add(new Treasure(5, "Pocket Watch"));
        remainingTreasures.add(new Treasure(500, "Gold Ruby Necklace"));
        remainingTreasures.add(new Treasure(860, "Mehrunes Razor"));
        remainingTreasures.add(new Treasure(1000, "The Black Star"));

        board = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<Space> row = new ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(new Space());
        }
        board.add(row);
        }

        board.get(0).get(0).setOccupant(ChuckNorris);

        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setOccupant(RazorClaw);
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setOccupant(GloomFury);
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setOccupant(FangSnarl);
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setOccupant(VileSpike);
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setOccupant(GrimScowl);

        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setOccupant(MotherTheresa);


        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setCache(remainingTreasures.get(0));
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setCache(remainingTreasures.get(1));
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setCache(remainingTreasures.get(2));
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setCache(remainingTreasures.get(3));
        board.get(rand.nextInt(rows)).get(rand.nextInt(cols)).setCache(remainingTreasures.get(4));



    }

    // Method to print the board
    public void printBoard(boolean showContents) {

        for (ArrayList<Space> row : board) {
            for (Space cell : row) {
                System.out.print(cell.getConsoleStr(showContents) + " ");
            }
            System.out.println();
        }
    }

    public void livingEncounter(LivingThing encountered){
        if (encountered instanceof Monster){

        } else if (encountered instanceof Healer) {

        }

    }

    public void treasureFind(Treasure found){

    }

    public boolean move(char m){
        if (m == 'w'){
            if (validSpace(currentRow -1, currentColumn)){
                board.get(currentRow).get(currentColumn).setOccupant(null);
                board.get(currentRow).get(currentColumn).setCache(null);
                currentRow -= 1;
                if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Monster){
                    ((Monster) board.get(currentRow).get(currentColumn).getOccupant()).hurt(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was damaged, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Healer) {
                    ((Healer) board.get(currentRow).get(currentColumn).getOccupant()).heal(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was healed, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getCache() instanceof Treasure) {
                    System.out.println(ChuckNorris.getName() + " found a " + board.get(currentRow).get(currentColumn).getCache()
                            .getDescription()+ " worth " + board.get(currentRow).get(currentColumn).getCache().getValue());
                    ChuckNorris.addTreasure(board.get(currentRow).get(currentColumn).getCache());
                    remainingTreasures.remove(board.get(currentRow).get(currentColumn).getCache());
                }
                board.get(currentRow).get(currentColumn).setOccupant(ChuckNorris);
                if (ChuckNorris.getHealth() <= 0){
                    System.out.println(ChuckNorris.getName() + " has died. Game Over.");
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        } else if (m == 'a') {
            if (validSpace(currentRow, currentColumn -1)){
                board.get(currentRow).get(currentColumn).setOccupant(null);
                board.get(currentRow).get(currentColumn).setCache(null);
                currentColumn -= 1;
                if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Monster){
                    ((Monster) board.get(currentRow).get(currentColumn).getOccupant()).hurt(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was damaged, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Healer) {
                    ((Healer) board.get(currentRow).get(currentColumn).getOccupant()).heal(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was healed, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getCache() instanceof Treasure) {
                    System.out.println(ChuckNorris.getName() + " found a " + board.get(currentRow).get(currentColumn).getCache()
                            .getDescription()+ " worth " + board.get(currentRow).get(currentColumn).getCache().getValue());
                    ChuckNorris.addTreasure(board.get(currentRow).get(currentColumn).getCache());
                    remainingTreasures.remove(board.get(currentRow).get(currentColumn).getCache());
                }
                board.get(currentRow).get(currentColumn).setOccupant(ChuckNorris);
                if (ChuckNorris.getHealth() <= 0){
                    System.out.println(ChuckNorris.getName() + " has died. Game Over.");
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else if (m == 's') {
            if (validSpace(currentRow +1, currentColumn )){
                board.get(currentRow).get(currentColumn).setOccupant(null);
                board.get(currentRow).get(currentColumn).setCache(null);
                currentRow += 1;
                if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Monster){
                    ((Monster) board.get(currentRow).get(currentColumn).getOccupant()).hurt(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was damaged, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Healer) {
                    ((Healer) board.get(currentRow).get(currentColumn).getOccupant()).heal(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was healed, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getCache() instanceof Treasure) {
                    System.out.println(ChuckNorris.getName() + " found a " + board.get(currentRow).get(currentColumn).getCache()
                            .getDescription()+ " worth " + board.get(currentRow).get(currentColumn).getCache().getValue());
                    ChuckNorris.addTreasure(board.get(currentRow).get(currentColumn).getCache());
                    remainingTreasures.remove(board.get(currentRow).get(currentColumn).getCache());
                }
                board.get(currentRow).get(currentColumn).setOccupant(ChuckNorris);
                if (ChuckNorris.getHealth() <= 0){
                    System.out.println(ChuckNorris.getName() + " has died. Game Over.");
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else if (m == 'd') {
            if (validSpace(currentRow, currentColumn +1)){
                board.get(currentRow).get(currentColumn).setOccupant(null);
                board.get(currentRow).get(currentColumn).setCache(null);
                currentColumn += 1;
                if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Monster){
                    ((Monster) board.get(currentRow).get(currentColumn).getOccupant()).hurt(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was damaged, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getOccupant() instanceof Healer) {
                    ((Healer) board.get(currentRow).get(currentColumn).getOccupant()).heal(ChuckNorris);
                    System.out.println(ChuckNorris.getName() + " was healed, and currently has " + ChuckNorris
                            .getHealth());
                } else if (board.get(currentRow).get(currentColumn).getCache() instanceof Treasure) {
                    System.out.println(ChuckNorris.getName() + " found a " + board.get(currentRow).get(currentColumn).getCache()
                            .getDescription()+ " worth " + board.get(currentRow).get(currentColumn).getCache().getValue());
                    ChuckNorris.addTreasure(board.get(currentRow).get(currentColumn).getCache());
                    remainingTreasures.remove(board.get(currentRow).get(currentColumn).getCache());
                }
                board.get(currentRow).get(currentColumn).setOccupant(ChuckNorris);
                if (ChuckNorris.getHealth() <= 0){
                    System.out.println(ChuckNorris.getName() + " has died. Game Over.");
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{

        }
        return false;
    }
    public boolean validSpace(int row, int col){
        return row >= 0 && row < board.size() && col >= 0 && col < board.get(row).size();
    }
}
