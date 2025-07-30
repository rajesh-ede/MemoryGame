package Projects;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Memorygame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cards = new ArrayList<>();
        cards.add("A"); cards.add("A");
        cards.add("B"); cards.add("B");
        cards.add("C"); cards.add("C");
        cards.add("D"); cards.add("D");
        Collections.shuffle(cards);

        String[] board = new String[cards.size()];
        Arrays.fill(board," ");
        boolean[] flipped = new boolean[cards.size()];
        int pairsFound = 0;

        System.out.println("Welcome to the Memory Game!");
        while(pairsFound < 4){
            printBoard(board);
            int first = getCardIndex(sc,board,flipped,"Enter index of first card to flip:");
            board[first] = cards.get(first);
            flipped[first] = true;
            printBoard(board);

            int second = getCardIndex(sc,board,flipped,"Enter index of second card to file:");
            board[second] = cards.get(second);
            flipped[second] = true;
            printBoard(board);

            if(cards.get(first).equals(cards.get(second))) {
                System.out.println("You found a pair!");
                pairsFound++;
            }else{
                System.out.println("Sorry, those cards don`t match.");
                board[first] = " ";
                  board[second] = " ";
                  flipped[first] = false;
                  flipped[second] = false;
            }
        }
        System.out.println("Congratulations, you won!");
        sc.close();
    }
    public static int getCardIndex(Scanner sc, String[] board,boolean[] flipped,String prompt){
        int index;
        while(true){
            System.out.println(prompt);
            index = sc.nextInt();
            if(index < 0 || index >= board.length){
                System.out.println("Invalid index, try again.");
            } else if (flipped[index]) {
                System.out.println("Cards already flipped, try again");
            }else {
                break;
            }
        }
        return index;
    }
    public static void printBoard(String[] board){
        for(String value : board){
            System.out.print("| " + value+" ");
        }
        System.out.println("|");
    }
}
