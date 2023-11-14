import java.util.Scanner;

public class boardDriver {
    public static void main(String[] args) {
        boolean unimportant = true;
    System.out.println("Collin Wimberly");
    board b = new board(5, 5);
    do{
    b.printBoard(false);
    Scanner input = new Scanner(System.in);
    System.out.print("Enter “w” to go up, “a” to go left, “s” to go down, and “d” to go right -> ");
    char whereMove = input.next().trim().toLowerCase().charAt(0);
    b.move(whereMove);
    }while(unimportant);
}
}
