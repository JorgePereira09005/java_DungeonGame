package dungeon;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner (System.in);
        
        Dungeon bop = new Dungeon(10,15,5,14,true);
        
//        public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove, Scanner scanner)
        
        
        bop.run();
        
        
    }
}
